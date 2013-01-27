package org.open.erp.services.productie.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import javax.persistence.EntityManager;

import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.Produs;
import org.open.erp.services.productie.Semifabricat;
import org.open.erp.services.productie.Utilaj;



public class RegistruProductie {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegistruProductie.class.getName());
	/* set up */
	public static EntityManager entityManager;
		
	public RegistruProductie(EntityManager em) {
		entityManager = em;
	}
	
	/* interogari */
	public FluxProductie getFluxProductie(Integer idFlux){
		return entityManager.find(FluxProductie.class, idFlux);
		}
	
	public List<FluxProductie> getListaFluxuri(){
		return entityManager.createQuery("SELECT f FROM FluxProductie f").getResultList();
		}
		
	
	public List<Semifabricat> getListaSemifabricate(){
		return entityManager.createQuery("SELECT s FROM Semifabricat s").getResultList();
		}
	
	public List<CriteriuCalitate> getListaCriterii(){
			return entityManager.createQuery("SELECT c FROM CriteriuCalitate c").getResultList();
		}
	
	public CriteriuCalitate salveazaCriteriuCalitate(CriteriuCalitate criteriu) throws Exception{
		try{

			if (criteriu.getIdCriteriu() == null || 
				entityManager.find(criteriu.getClass(), criteriu.getIdCriteriu()) == null)
				entityManager.persist(criteriu);
			else
				entityManager.merge(criteriu);
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return criteriu;
	}
	
	public void stergeCriteriuCalitate(CriteriuCalitate criteriu){
			entityManager.remove(criteriu);
		}
	
	public Semifabricat salveazaSemifabricat(Semifabricat semif) throws Exception{
		try{

			if (semif.getIdSemifabricat() == null || 
				entityManager.find(semif.getClass(), semif.getIdSemifabricat()) == null)
				entityManager.persist(semif);
			else
				entityManager.merge(semif);
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return semif;
	}
	
	public FazaProductie getFazaProductie(Integer idFaza){
			return entityManager.find(FazaProductie.class, idFaza);
		}
	
	public List<FazaProductie> getListaFazePeFlux(Integer idFlux){
			return entityManager.createQuery("SELECT faze FROM FluxProductie f where f.idFlux=:idFlux").setParameter("idFlux", idFlux).getResultList();
		}
	
	
	/* persistenta */
	public FluxProductie salveazaFlux(FluxProductie flux) throws Exception{
		try{

			if (flux.getIdFlux() == null || 
				entityManager.find(flux.getClass(), flux.getIdFlux()) == null)
				entityManager.persist(flux);
			else
				entityManager.merge(flux);
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return flux;
	}
	
	public void stergeFlux(FluxProductie flux){
			entityManager.remove(flux);
		}
	
	public FazaProductie salveazaFaza(FazaProductie faza) throws Exception{
		try{
			
			if (faza.getFaza() == null || 
				entityManager.find(faza.getClass(), faza.getFaza()) == null)
				entityManager.persist(faza);
			else
				entityManager.merge(faza);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return faza;
	}
	
	public void stergeFaza(FazaProductie faza){
			entityManager.remove(faza);
		}
	
	
	public List<FazaProductie> getListaFaze(){
			return entityManager.createQuery("SELECT fz FROM FazaProductie fz").getResultList();
		}
	
	public FazaProductie getFazaProductie(String faza){
			return entityManager.find(FazaProductie.class, faza);
		
	}
	public void refreshFlux(FluxProductie flux){
			entityManager.refresh(flux);
		}
	
	public List<Utilaj> getUtilaje(){
			return entityManager.createQuery("SELECT ut FROM Utilaj ut").getResultList();
		}
	
	public void stergeUtilaj(Utilaj utilaj){
			entityManager.remove(utilaj);
		}
	
	
	public void stergeSemifabricat(Semifabricat semifabricat){
			entityManager.remove(semifabricat);
		}
	
	
	/* 
	 * 
	 * 
	 * PRODUS
	 * 
	 *  
	 *  */
	
	List<Produs> produse = new ArrayList<Produs>();
	
	private String sqlProdusDefaultText = "SELECT o FROM Produs o";
	
	public List<Produs> getProduse() {
		return produse;
	}

	public void setProduse(List<Produs> produse) {
		this.produse = produse;
	}

	public void generateRandomProduse(Integer nrProduse) {
		Random randomPret = new Random();
		@SuppressWarnings("unused")
		Integer pret;
		for (int i = 1; i <= nrProduse; i++) {
			pret = 50 + randomPret.nextInt(1450);
			produse.add(new Produs(i, "Produs_" + i, null, null, null, null, null, null, null));
		}
	}

	public RegistruProductie() {
		generateRandomProduse(20);
		
	}

	public RegistruProductie(Integer nrProduse) {
		generateRandomProduse(nrProduse);
		
	}
	
	public Collection<Produs> getProduseOrdonateDupaId() {
		 @SuppressWarnings("unchecked")
		List<Produs> result = this.entityManager.createQuery(this.sqlProdusDefaultText).getResultList();
		TreeSet<Produs> produseOrdonate = new TreeSet<Produs>();
		
		produseOrdonate.addAll(result);
		return produseOrdonate;
	}
	
	 public Produs getProdusDupaCod(Integer id){
    	 Produs p = this.entityManager.find(Produs.class, id);
     	this.entityManager.refresh(p);
     	return p;
     }
	
	 public void addProdus(Produs p){
	     	try{
	     		entityManager.getTransaction().begin();
	             if (this.entityManager.contains(p))
	                 this.entityManager.merge(p);
	             else
	                 this.entityManager.persist(p);
	             entityManager.getTransaction().commit();
	     	}catch(Exception ex){
	     		if (entityManager.getTransaction().isActive())
	     			entityManager.getTransaction().rollback();
	     		throw new RuntimeException(ex.getMessage());
	     	}        
	     }

	     public void removeProdus(Produs p){
	     	try{
	     		entityManager.getTransaction().begin();
	             if (this.entityManager.contains(p))
	                 this.entityManager.remove(p);
	             entityManager.getTransaction().commit();
	     	}catch(Exception ex){
	     		if (entityManager.getTransaction().isActive())
	     			entityManager.getTransaction().rollback();
	     		throw new RuntimeException(ex.getMessage());
	     	} 
	     }


	     public void refreshProdus(Produs p){
	     	this.entityManager.refresh(p);
	     }
	     
	     public Produs getProdus(Integer idProdus) throws Exception {
	 		Produs p = new Produs();
	 		p.setIdProdus(idProdus);
	 		Integer pIndex = produse.indexOf(p);
	 		if (pIndex >= 0)
	 			return this.produse.get(pIndex);
	 		else
	 			throw new Exception("No data found: Produs inexistent!");
	 	}
	     
	     public Produs  CautareProdusDupaDenumire(String denumire){
	 		
	 		return (Produs) this.entityManager
	                 .createQuery(sqlProdusDefaultText + " WHERE o.denumire = :denumire")
	                 .setParameter("denumire", denumire)
	                 .getSingleResult();
	     }
}

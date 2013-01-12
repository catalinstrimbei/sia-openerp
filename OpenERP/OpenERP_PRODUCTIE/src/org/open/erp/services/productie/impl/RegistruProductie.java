package org.open.erp.services.productie.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
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
	
}

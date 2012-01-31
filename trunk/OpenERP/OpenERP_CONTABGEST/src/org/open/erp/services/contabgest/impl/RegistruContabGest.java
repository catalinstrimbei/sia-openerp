package org.open.erp.services.contabgest.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.open.erp.services.contabgest.CentruCost;
import org.open.erp.services.contabgest.CheltuieliFixe;
import org.open.erp.services.contabgest.CheltuieliVariabile;
import org.open.erp.services.contabgest.DummyFazaProductie;
import org.open.erp.services.contabgest.DummyPersoana;
import org.open.erp.services.contabgest.ProceseTehnicoEconomice;
import org.open.erp.services.contabgest.ProdusFinit;
import org.open.erp.services.contabgest.ResponabilCentruCost;
import org.open.erp.services.contabgest.TipCheltuieli;
import org.open.erp.services.contabgest.exceptions.ContabGestLogger;




public class RegistruContabGest {
	
	private static Logger logger = Logger.getLogger(RegistruContabGest.class.getName());	
	ContabGestLogger logger2 = new ContabGestLogger();
	
	/* set up */
	private EntityManager entityManager;
	public RegistruContabGest(EntityManager em) {
		entityManager = em;
	}
	
	/* interogari */
	public DummyPersoana getPPers(Integer id){
		return entityManager.find(DummyPersoana.class, id);
	}
	
	public List<DummyPersoana> getToatePersoanele(){
		return entityManager.createQuery("SELECT p FROM DummyPersoana p").getResultList();
	}
	
	/* persistenta */
	public DummyPersoana salveazaPersoana(DummyPersoana dummyPersoana) throws Exception{
		try{
			
			if (dummyPersoana.getId() == null || 
				entityManager.find(dummyPersoana.getClass(), dummyPersoana.getId()) == null)
				entityManager.persist(dummyPersoana);
			else
				entityManager.merge(dummyPersoana);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return dummyPersoana;
	}
	
	public ProdusFinit salveazaProdusFinit(ProdusFinit produsFinit) throws Exception{
		try{
			if (produsFinit.getIdProdusFinit() == null || 
				entityManager.find(produsFinit.getClass(), produsFinit.getIdProdusFinit()) == null)
				entityManager.persist(produsFinit);
			else
				entityManager.merge(produsFinit);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return produsFinit;
	}
	
	public CheltuieliFixe salveazaCheltuieliFixe(CheltuieliFixe cheltuieliFixe) throws Exception{
		try{
			if (cheltuieliFixe.getIdTipCheltuieli() == null || 
				entityManager.find(cheltuieliFixe.getClass(), cheltuieliFixe.getIdTipCheltuieli()) == null)
				entityManager.persist(cheltuieliFixe);
			else
				entityManager.merge(cheltuieliFixe);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return cheltuieliFixe;
	}
	
	
	
	public CheltuieliVariabile salveazaCheltuieliVariabile(CheltuieliVariabile cheltuieliVariabile) throws Exception{
		try{
			if (cheltuieliVariabile.getIdTipCheltuieli() == null || 
				entityManager.find(cheltuieliVariabile.getClass(), cheltuieliVariabile.getIdTipCheltuieli()) == null)
				entityManager.persist(cheltuieliVariabile);
			else
				entityManager.merge(cheltuieliVariabile);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return cheltuieliVariabile;
	}
	
	
	
	public DummyPersoana getPersoanaIdR(Integer idPersoana) throws Exception
	{
		try{
			return entityManager.find(DummyPersoana.class, idPersoana);
		}
		catch(Exception ex)
		{
			logger2.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger2.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger2.logERROR("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}	
	
	
	

	public void stergePersoana(DummyPersoana dummyPersoana){
		entityManager.remove(dummyPersoana);
	}
	
	public void refreshPersoana(DummyPersoana dummyPersoana){
		entityManager.refresh(dummyPersoana);
	}

	public TipCheltuieli salveazaTipCheltuiala(TipCheltuieli tipCheltuieli) throws Exception {
		try{
			if (tipCheltuieli.getIdTipCheltuieli() == null || 
				entityManager.find(tipCheltuieli.getClass(), tipCheltuieli.getIdTipCheltuieli()) == null)
				entityManager.persist(tipCheltuieli);
			else
				entityManager.merge(tipCheltuieli);
			
		}catch(Exception ex){
			
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return tipCheltuieli;
	}
	
	
	public ProceseTehnicoEconomice salveazaTipProceseTehnicoEconomice(ProceseTehnicoEconomice proceseTehnicoEconomice) throws Exception {
		try{
			if (proceseTehnicoEconomice.getIdProces() == null || 
				entityManager.find(proceseTehnicoEconomice.getClass(), proceseTehnicoEconomice.getIdProces()) == null)
				entityManager.persist(proceseTehnicoEconomice);
			else
				entityManager.merge(proceseTehnicoEconomice);
			
		}catch(Exception ex){
			
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return proceseTehnicoEconomice;
	}
	
	

	public CentruCost salveazaCentruCost(CentruCost centruCost) throws Exception {
		try{
			if (centruCost.getIdCentruCost() == null || 
				entityManager.find(centruCost.getClass(), centruCost.getIdCentruCost()) == null)
				entityManager.persist(centruCost);
			else
				entityManager.merge(centruCost);
			
		}catch(Exception ex){
			
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return centruCost;
	}
	

	
	
	public DummyPersoana salveazaDummyPersoana(DummyPersoana dummyPersoana) throws Exception {
		try{
			if (dummyPersoana.getId() == null || 
				entityManager.find(dummyPersoana.getClass(), dummyPersoana.getId()) == null)
				entityManager.persist(dummyPersoana);
			else
				entityManager.merge(dummyPersoana);
			
		}catch(Exception ex){
			
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return dummyPersoana;
	}
	
	public ProdusFinit getProdusFinitById(Integer idProdusFinit) throws Exception{
		try{
			//return entityManager.find(ProdusFinit.class, id);
			//return (ProdusFinit) entityManager.createQuery("SELECT c FROM ProdusFinit c WHERE c.idProdusFinit = :id")
			//		.setParameter("idProdusFinit", id)
			//		.getSingleResult();
			
			return (ProdusFinit) entityManager.createQuery("SELECT c FROM ProdusFinit c WHERE c.idProdusFinit =:idProdusFinit").setParameter("idProdusFinit", idProdusFinit).getSingleResult();
		}catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	public CentruCost getCentruCostById(Integer idCentruCost) throws Exception{
		try{
			//return entityManager.find(ProdusFinit.class, id);
			//return (ProdusFinit) entityManager.createQuery("SELECT c FROM ProdusFinit c WHERE c.idProdusFinit = :id")
			//		.setParameter("idProdusFinit", id)
			//		.getSingleResult();
			
			return  (CentruCost) entityManager.createQuery("SELECT c FROM CentruCost c WHERE c.idCentruCost =:idCentruCost").setParameter("idCentruCost", idCentruCost).getSingleResult();
			
		}catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	
	public DummyFazaProductie getDummyFazaProductieById(Integer idFazaProductie) throws Exception{
		try{
			//return entityManager.find(DummyFazaProductie.class, id);
			//return  (DummyFazaProductie) entityManager.createQuery("SELECT d FROM DummyFazaProductie d WHERE d.idFazaProductie = :idFazaProductie")
				//	.setParameter("idFazaProductie", idFazaProductie).getSingleResult();
			
			return (DummyFazaProductie) entityManager.createQuery("SELECT c FROM DummyFazaProductie c WHERE c.idFazaProductie =:idFazaProductie").setParameter("idFazaProductie", idFazaProductie).getSingleResult();
			
		}catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	public ResponabilCentruCost getResponabilCentruCostById(Integer id) throws Exception{
		try{
			//return entityManager.find(ResponabilCentruCost.class, id);
			return (ResponabilCentruCost) entityManager.createQuery("SELECT c FROM ResponabilCentruCost c WHERE c.id = :id")
					.setParameter("id", id)
					.getSingleResult();
		}catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	public ProceseTehnicoEconomice getProceseTehnicoEconomiceById(Integer idProces) throws Exception{
		try{
			//return entityManager.find(ProceseTehnicoEconomice.class, id);
			//return (ProceseTehnicoEconomice) entityManager.createQuery("SELECT c FROM ProceseTehnicoEconomice c WHERE c.idProces= :id")
			//		.setParameter("idProces", id)
			//		.getSingleResult();
			
			return (ProceseTehnicoEconomice) entityManager.createQuery("SELECT c FROM ProceseTehnicoEconomice c WHERE c.idProces =:idProces").setParameter("idProces", idProces).getSingleResult();
			
		}catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	
	
	
	
	

	
	public ResponabilCentruCost salveazaResponabilCentruCost(ResponabilCentruCost responabilCentruCost) throws Exception {
		try{
			if (responabilCentruCost.getId() == null || 
				entityManager.find(responabilCentruCost.getClass(), responabilCentruCost.getId()) == null)
				entityManager.persist(responabilCentruCost);
			else
				entityManager.merge(responabilCentruCost);
			
		}catch(Exception ex){
			
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return responabilCentruCost;
		
	}

	

	public DummyFazaProductie salveazaDummyFazaProductie(
			DummyFazaProductie dummyFazaProductieNoua) throws Exception{
		try{
			if (dummyFazaProductieNoua.getIdFazaProductie() == null || 
				entityManager.find(dummyFazaProductieNoua.getClass(), dummyFazaProductieNoua.getIdFazaProductie()) == null)
				entityManager.persist(dummyFazaProductieNoua);
			else
				entityManager.merge(dummyFazaProductieNoua);
			
		}catch(Exception ex){
			
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return dummyFazaProductieNoua;	}

	
	public ArrayList<ProdusFinit> getProduseFInitte() {
					Query q = entityManager.createQuery(
						"SELECT c FROM ProdusFinit c "	);
					@SuppressWarnings("unchecked")
					ArrayList<ProdusFinit> produseFinite = (ArrayList<ProdusFinit>) q
							.getResultList();
					return produseFinite;
				}
				/* persistenta */
				public ProdusFinit salveazaProdus(ProdusFinit produsFinit) throws Exception{
					try{
			
						//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
						if (produsFinit.getIdProdusFinit() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
							entityManager.find(produsFinit.getClass(), produsFinit.getIdProdusFinit()) == null)
							entityManager.persist(produsFinit);
						else
							entityManager.merge(produsFinit);
		
					}catch(Exception ex){
						logger.info("EROARE PERSISTENTA ***** ");
						ex.printStackTrace();
						throw ex;
					}
					return produsFinit;
				}
	
}


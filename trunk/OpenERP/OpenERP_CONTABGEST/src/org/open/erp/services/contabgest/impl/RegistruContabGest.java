package org.open.erp.services.contabgest.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
//import org.open.erp.services.contabgest.DummyPersoana;
import org.open.erp.services.contabgest.CheltuieliFixe;
import org.open.erp.services.contabgest.ProdusFinit;
import org.open.erp.services.contabgest.exceptions.ContabGestLogger;


public class RegistruContabGest {
	
	private static Logger logger = Logger.getLogger(RegistruContabGest.class.getName());	
	ContabGestLogger logger2 = new ContabGestLogger();
	
	/* set up */
	private EntityManager entityManager;
	public RegistruContabGest(EntityManager em) {
		entityManager = em;
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

	public ProdusFinit getProdusFinitIdR(Integer idProdusFinit) throws Exception
	{
		try{
			return entityManager.find(ProdusFinit.class, idProdusFinit);
		}
		catch(Exception ex)
		{
			logger2.logERROR("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger2.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger2.logERROR("<< Stack Trace >>" + st.toString());
			throw ex;
		}
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
	
	public List<ProdusFinit> getToateProdusele(){
		return entityManager.createQuery("SELECT p FROM ProdusFinit p").getResultList();
	}
	
	/* interogari */
	/*
	public DummyPersoana getPPers(Integer id){
		return entityManager.find(DummyPersoana.class, id);
	}
	
	public List<DummyPersoana> getToatePersoanele(){
		return entityManager.createQuery("SELECT p FROM DummyPersoana p").getResultList();
	}
	*/
	
	/* persistenta */
	/*
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
	*/

	
	/*
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
	
	
	

	public void stergeProiect(DummyPersoana dummyPersoana){
		entityManager.remove(dummyPersoana);
	}
	
	public void refreshPersoana(DummyPersoana dummyPersoana){
		entityManager.refresh(dummyPersoana);
	}
*/
}
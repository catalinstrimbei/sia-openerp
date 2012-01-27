package org.open.erp.services.productie.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.ActivitateTeamBuilding;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.Functie;
import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.Semifabricat;
import org.open.erp.services.productie.teste.TestProductie;

public class RegistruProductie {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestProductie.class.getName());
	/* set up */
	public static EntityManager entityManager;
	
	public RegistruProductie() {
		
	}
	
	public RegistruProductie(EntityManager em) {
		entityManager = em;
	}
	
	public void synchronize() {
		// sincronizare cu baza de date
		entityManager.getTransaction().begin();
		try {
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	

	/* interogari */
	public FluxProductie getFluxProductie(Integer idFlux) throws Exception{
		try
		{
		return entityManager.find(FluxProductie.class, idFlux);
		}
		catch(Exception ex)
		{
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	public List<FluxProductie> getListaFluxuri() throws Exception{
		try
		{
			return entityManager.createQuery("SELECT f FROM FluxProductie f").getResultList();
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	public List<Semifabricat> getListaSemifabricate()throws Exception{
		try
		{
			return entityManager.createQuery("SELECT s FROM Semifabricat s").getResultList();
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	public List<CriteriuCalitate> getListaCriterii() throws Exception{
		try
		{
			return entityManager.createQuery("SELECT c FROM CriteriuCalitate c").getResultList();
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
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
	
	public void stergeCriteriuCalitate(CriteriuCalitate criteriu) throws Exception{
		try 
		{
			entityManager.remove(criteriu);
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	public FazaProductie getFazaProductie(Integer idFaza) throws Exception{
		try
		{
			return entityManager.find(FazaProductie.class, idFaza);
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	public List<FazaProductie> getListaFazePeFlux(Integer idFlux) throws Exception{
		try
		{
			return entityManager.createQuery("SELECT faze FROM FluxProductie f where f.idFlux=:idFlux").setParameter("idFlux", idFlux).getResultList();
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
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
	
	public void stergeFlux(FluxProductie flux) throws Exception{
		try 
		{
			entityManager.remove(flux);
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
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
	
	public void stergeFaza(FazaProductie faza) throws Exception{
		try 
		{
			entityManager.remove(faza);
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	
	public List<FazaProductie> getListaFaze() throws Exception{
		try
		{
			return entityManager.createQuery("SELECT fz FROM FazaProductie fz").getResultList();
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	
	public FazaProductie getFazaProductie(String faza) throws Exception{
		try
		{
			return entityManager.find(FazaProductie.class, faza);
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	public void refreshFlux(FluxProductie flux) throws Exception{
		try
		{
			entityManager.refresh(flux);
		}
		catch(Exception ex){
			logger.error("Persistence Error in method >> "  + Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	}


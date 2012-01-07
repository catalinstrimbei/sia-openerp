package org.open.erp.services.productie.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.Functie;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.teste.TestProductie;

public class RegistruProductie {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestProductie.class.getName());
	/* set up */
	private EntityManager entityManager;
	
	public RegistruProductie() {
	}
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
	
	public void refreshFlux(FluxProductie flux){
		entityManager.refresh(flux);
	}
	}


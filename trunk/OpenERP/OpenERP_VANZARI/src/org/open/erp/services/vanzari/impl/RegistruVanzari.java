package org.open.erp.services.vanzari.impl;

import java.util.List;
import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.open.erp.services.vanzari.OfertePret;
import org.open.erp.services.vanzari.Persoana;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class RegistruVanzari {

private static Logger logger = Logger.getLogger(RegistruVanzari.class.getName());	
	
	/* set up */
	private EntityManager entityManager;
	public RegistruVanzari(EntityManager em) {
		entityManager = em;
	}

	/* interogari */
	public OfertePret getOfertaDePret(Integer idOfertaPret){
		return entityManager.find(OfertePret.class, idOfertaPret);
	}
	
	
	
	public List<OfertePret> getToateOfertele(){
		return entityManager.createQuery("SELECT o FROM OfertePret o").getResultList();
		
	}
	
	
	
	/* persistenta */
	public OfertePret salveazaOferta(OfertePret oferta) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (oferta.getIdOfertaPret() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(oferta.getClass(), oferta.getIdOfertaPret()) == null)
				entityManager.persist(oferta);
			else
				entityManager.merge(oferta);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return oferta;
	}

	
	
	public void stergeOferte(OfertePret oferta){
		entityManager.remove(oferta);
	}

	

	
	public void refreshOferta(OfertePret oferta){
		entityManager.refresh(oferta);
	}
	
	//persistenta
		public Persoana salveazaPersoana(Persoana persoana) throws Exception{
			logger.debug("a intrat in salveaza persoana din registru");
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				
				if (persoana.getIdPersoana() == null || 
					entityManager.find(persoana.getClass(), persoana.getIdPersoana()) == null)
					entityManager.persist(persoana);
				else
					entityManager.merge(persoana);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return persoana;
		}
}




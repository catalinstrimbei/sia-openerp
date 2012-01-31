package org.open.erp.services.plati.impl;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.open.erp.services.plati.FacturaPrimita;
import org.open.erp.services.plati.Plata;

/**
 * 
 * @BusinessObject(Repository)
 * 
 */
public class RegistruPlati {
	private static Logger logger = Logger.getLogger(RegistruPlati.class.getName());	
	
	/* set up */
	private EntityManager entityManager;
	public RegistruPlati(EntityManager em) {
		entityManager = em;
	}

	/* interogari */
	public Plata getPlata(Integer id){
		return entityManager.find(Plata.class, id);
	}
	
	public List<Plata> getToatePlatile(){
		return entityManager.createQuery("SELECT p FROM Plata p").getResultList();
	}
	
	
	/* persistenta */
	public Plata salveazaPlata(Plata plata) throws Exception{
		try{
			
			//if (!entityManager.contains(plata)) /* o posibilitate de verificare */
			if (plata.getIdPlata() == null || /* plata.getIdPlata() pentru plata cu id generat*/
				entityManager.find(plata.getClass(), plata.getIdPlata()) == null)
				entityManager.persist(plata);
			else
				entityManager.merge(plata);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return plata;
	}
	
	public void stergePlata(Plata plata){
		entityManager.remove(plata);
	}

	public FacturaPrimita salveazaFacturaPrimita(
			FacturaPrimita factura) throws Exception{
		logger.debug("--De salvat facturile cu ID: " + factura.getIdFactura());
		try{
			//if (!entityManager.contains(factura.getFurnizor()))
			entityManager.merge(factura.getFurnizor());
			
			//if (!entityManager.contains(proiect))
			if (factura.getIdFactura() == null ||
				entityManager.find(factura.getClass(), factura.getIdFactura()) == null)
				entityManager.persist(factura);
			else
				entityManager.merge(factura);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return factura;
	}	
	
	public void refreshPlata(Plata plata){
		entityManager.refresh(plata);
	}
}

package org.open.erp.services.nomgen.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegistruPersoana {
	
private static Logger logger = Logger.getLogger(RegistruPersoana.class.getName());

/* set up */
private EntityManager entityManager;
public RegistruPersoana(EntityManager em) {
	entityManager = em;
}

/* interogari */
public Persoana getPersoana(Integer id){
	return entityManager.find(Persoana.class, id);
}

public List<Persoana> getToatePersoanele(){
	return entityManager.createQuery("SELECT p FROM persoana p").getResultList();
}

/* persistenta */
public Persoana salveazaPersoana(Persoana persoana) throws Exception{
	try{
		
		if (persoana.getId() == null || 
			entityManager.find(persoana.getClass(), persoana.getId()) == null)
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

public void stergePersoana(Persoana persoana){
	entityManager.remove(persoana);
}


public void refreshPersoana(Persoana persoana){
	entityManager.refresh(persoana);
}
}







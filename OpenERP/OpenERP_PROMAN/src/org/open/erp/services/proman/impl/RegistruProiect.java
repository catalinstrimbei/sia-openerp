package org.open.erp.services.proman.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.open.erp.services.proman.ActivitateBugetata;
import org.open.erp.services.proman.Proiect;

/**
 * 
 * @BusinessObject(Repository)
 * 
 */
public class RegistruProiect {
	private static Logger logger = Logger.getLogger(RegistruProiect.class.getName());	
	
	/* set up */
	private EntityManager entityManager;
	public RegistruProiect(EntityManager em) {
		entityManager = em;
	}

	/* interogari */
	public Proiect getProiect(Integer id){
		return entityManager.find(Proiect.class, id);
	}
	
	public List<Proiect> getToateProiectele(){
		return entityManager.createQuery("SELECT p FROM Proiect p").getResultList();
	}
	
	public List<Proiect> getProiecteDupaResponsabil(Integer idResponsabil){
		return entityManager
				.createQuery("SELECT p FROM Proiect p WHERE p.responsabil.idPersoana=:idPersoana")
				.setParameter("idPersoana", idResponsabil)
				.getResultList();
	}
	
	/* persistenta */
	public Proiect salveazaProiect(Proiect proiect) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (proiect.getIdProiect() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(proiect.getClass(), proiect.getIdProiect()) == null)
				entityManager.persist(proiect);
			else
				entityManager.merge(proiect);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return proiect;
	}
	
	public void stergeProiect(Proiect proiect){
		entityManager.remove(proiect);
	}

	public ActivitateBugetata salveazaActivitateBugetata(
			ActivitateBugetata activitate) throws Exception{
		logger.debug("--De salvat activitate cu ID: " + activitate.getIdActivitate());
		try{
			/* Proiectul plimbandu-se de la client-la server-inapoi la client-iarasi la server
			 * nu este adus inca in/atasat de cache
			 * */
			//if (!entityManager.contains(activitate.getProiect()))
			entityManager.merge(activitate.getProiect());
			
			//if (!entityManager.contains(proiect))
			if (activitate.getIdActivitate() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(activitate.getClass(), activitate.getIdActivitate()) == null)
				entityManager.persist(activitate);
			else
				entityManager.merge(activitate);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return activitate;
	}	
	
	public void refreshProiect(Proiect proiect){
		entityManager.refresh(proiect);
	}
}


/*



<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
	<persistence-unit name="OpenERP_PROMAN" transaction-type="JTA">
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<jta-data-source>java:jdbc/LocalPG_XA</jta-data-source>
      <properties>
         <property name="hibernate.dialect" value="org.hibernate.dialect.Oracle9Dialect"/>
         <property name="hibernate.hbm2ddl.auto" value="validate | update | create | create-drop"/>
      </properties>		
	</persistence-unit>
</persistence>


*/
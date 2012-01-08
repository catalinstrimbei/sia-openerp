package org.open.erp.services.marketing.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.open.erp.services.marketing.Campanie;



/**
 * 
 * @BusinessObject(Repository)
 * 
 */
public class RegistruMarketing {

	private static Logger logger = Logger.getLogger(RegistruMarketing.class.getName());

		
		/* set up */
		private EntityManager entityManager;
		public RegistruMarketing(EntityManager em) {
			entityManager = em;
		}

		/* interogari */
		public Campanie getCampanie(Integer id){
			return entityManager.find(Campanie.class, id);
		}
		
		public List<Campanie> getCampaniile(){
			return entityManager.createQuery("SELECT C FROM Campanie c").getResultList();
		}
		
		public List<Campanie> getCampanieDupaResponsabil(Integer idResponsabil){
			return entityManager.
					createQuery("SELECT p FROM Proiect p WHERE p.responsabil.idPersoana=:idPersoana")
					.setParameter("idPersoana", idResponsabil)
					.getResultList();
		}
		
		/* persistenta */
		public Campanie salveazaProiect(Campanie campanie) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (campanie.getIdCampanie() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(campanie.getClass(), campanie.getIdCampanie()) == null)
					entityManager.persist(campanie);
				else
					entityManager.merge(campanie);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return campanie;
		}
		
		public void stergeProiect(Campanie campanie){
			entityManager.remove(campanie);
		}

		
		public void refreshProiect(Campanie campanie){
			entityManager.refresh(campanie);
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


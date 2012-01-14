package org.open.erp.services.marketing.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

import org.hibernate.Hibernate;
import org.open.erp.services.marketing.Campanie;
import org.open.erp.services.marketing.PersoanaTinta;



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
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public Campanie getCampanie(Integer id){
			Campanie campanie;
			campanie = entityManager.find(Campanie.class, id);
			try
			{
				campanie.setPersoaneTinta(this.getPersoaneTintaPeCampanie(campanie));
			}
			catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
			}
			return campanie;
		}
		public PersoanaTinta getPersoanaTinta(Integer id){
			return entityManager.find(PersoanaTinta.class, id);
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
		public Campanie salveazaCampanie(Campanie campanie) throws Exception{
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
		
		public PersoanaTinta salveazaPersoanaTinta(PersoanaTinta persoanaTinta) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (persoanaTinta.getId() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(persoanaTinta.getClass(), persoanaTinta.getId()) == null)
					entityManager.persist(persoanaTinta);
				else
					entityManager.merge(persoanaTinta);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return persoanaTinta;
		}
		public void stergeCampanie(Campanie campanie){
			entityManager.remove(campanie);
		}

		
		public void refreshCampanie(Campanie campanie){
			entityManager.refresh(campanie);
		}
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		public List<PersoanaTinta> getPersoaneTintaPeCampanie(Campanie campanie) throws Exception{
			
			List<PersoanaTinta> persoaneTinta = new ArrayList<PersoanaTinta>();
			try{
				persoaneTinta = entityManager.createQuery("SELECT pt FROM PersoanaTinta pt,where pt.idCampanie= :campanie")
												.setParameter("campanie", campanie)
												.getResultList();
				Hibernate.initialize(persoaneTinta);
				persoaneTinta.size();
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return persoaneTinta;
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


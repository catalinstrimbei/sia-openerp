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
import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.Discount;
import org.open.erp.services.marketing.DummyProdus;
import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.PersoanaTinta;
import org.open.erp.services.marketing.ProdusDiscount;
import org.open.erp.services.marketing.ProduseAditionale;
import org.open.erp.services.marketing.Promotie;
import org.open.erp.services.marketing.RaspunsChestionar;
import org.open.erp.services.marketing.RaspunsIntrebare;
import org.open.erp.services.marketing.Responsabil;



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
		public Chestionar salveazaChestionar(Chestionar chestionar) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (chestionar.getIdChestionar()== null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(chestionar.getClass(), chestionar.getIdChestionar()) == null)
					entityManager.persist(chestionar);
				else
					entityManager.merge(chestionar);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return chestionar;
		}
		public DummyProdus salveazaProdus(DummyProdus produs) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (produs.getId()== null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(produs.getClass(), produs.getId()) == null)
					entityManager.persist(produs);
				else
					entityManager.merge(produs);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return produs;
		}
		public Discount salveazaDiscount(Discount discount) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (discount.getIdDiscount()== null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(discount.getClass(), discount.getIdDiscount()) == null)
					entityManager.persist(discount);
				else
					entityManager.merge(discount);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return discount;
		}
		public Intrebare salveazaIntrebare(Intrebare intrebare) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (intrebare.getIdIntrebare()== null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(intrebare.getClass(), intrebare.getIdIntrebare()) == null)
					entityManager.persist(intrebare);
				else
					entityManager.merge(intrebare);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return intrebare;
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
		public ProdusDiscount salveazaProdusDiscount(ProdusDiscount produsDiscount) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (produsDiscount.getIdProdusDiscount()== null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(produsDiscount.getClass(), produsDiscount.getIdProdusDiscount()) == null)
					entityManager.persist(produsDiscount);
				else
					entityManager.merge(produsDiscount);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return produsDiscount;
		}
		
		public ProduseAditionale salveazaProduseAditionale(ProduseAditionale produseAditionale) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (produseAditionale.getIdCombinatie()== null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(produseAditionale.getClass(), produseAditionale.getIdCombinatie()) == null)
					entityManager.persist(produseAditionale);
				else
					entityManager.merge(produseAditionale);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return produseAditionale;
		}
		
		public Promotie salveazaPromotie(Promotie promotie) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (promotie.getIdPromotie()== null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(promotie.getClass(), promotie.getIdPromotie()) == null)
					entityManager.persist(promotie);
				else
					entityManager.merge(promotie);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return promotie;
		}
			
		
		public RaspunsChestionar salveazaRaspunsChestionar(RaspunsChestionar raspunsChestionar) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (raspunsChestionar.getIdRaspuns()== null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(raspunsChestionar.getClass(), raspunsChestionar.getIdRaspuns()) == null)
					entityManager.persist(raspunsChestionar);
				else
					entityManager.merge(raspunsChestionar);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return raspunsChestionar;
		}
		public RaspunsIntrebare salveazaRaspunsIntrebare(RaspunsIntrebare raspunsIntrebare) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (raspunsIntrebare.getIdRaspunsIntrebare()== null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(raspunsIntrebare.getClass(), raspunsIntrebare.getIdRaspunsIntrebare()) == null)
					entityManager.persist(raspunsIntrebare);
				else
					entityManager.merge(raspunsIntrebare);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return raspunsIntrebare;
		}
		public Responsabil salveazaResponsabil(Responsabil responsabil) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (responsabil.getIdResponsabil()== null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(responsabil.getClass(), responsabil.getIdResponsabil()) == null)
					entityManager.persist(responsabil);
				else
					entityManager.merge(responsabil);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return responsabil;
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


package org.open.erp.services.marketing.impl;

import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;

import org.open.erp.services.marketing.CampaniePromovare;
import org.open.erp.services.marketing.CercetarePiata;
import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.MarketingSrvLocal;
import org.open.erp.services.marketing.Promotie;
import org.open.erp.services.marketing.RaspunsIntrebare;
import org.open.erp.services.marketing.Reclamatie;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;

@Stateless
public class MarketingSrvImpl implements MarketingSrv, MarketingSrvLocal {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MarketingSrvImpl.class.getName());

	@PersistenceContext(unitName = "OpenERP_MARKETING")
	private EntityManager entityManager = new EntityManager() {

		@Override
		public <T> T unwrap(Class<T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setProperty(String arg0, Object arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setFlushMode(FlushModeType arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void remove(Object arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void refresh(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void refresh(Object arg0, LockModeType arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void refresh(Object arg0, Map<String, Object> arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void refresh(Object arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void persist(Object arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public <T> T merge(T arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void lock(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void lock(Object arg0, LockModeType arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void joinTransaction() {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isOpen() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public EntityTransaction getTransaction() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T getReference(Class<T> arg0, Object arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<String, Object> getProperties() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Metamodel getMetamodel() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public LockModeType getLockMode(Object arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public FlushModeType getFlushMode() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EntityManagerFactory getEntityManagerFactory() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getDelegate() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CriteriaBuilder getCriteriaBuilder() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub

		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2, Map<String, Object> arg3) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, Map<String, Object> arg2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void detach(Object arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public <T> TypedQuery<T> createQuery(String arg0, Class<T> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> TypedQuery<T> createQuery(CriteriaQuery<T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createQuery(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0, Class arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> TypedQuery<T> createNamedQuery(String arg0, Class<T> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Query createNamedQuery(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean contains(Object arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void close() {
			// TODO Auto-generated method stub

		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub

		}
	};

	public MarketingSrvImpl() {

	}

	@EJB(lookup = "java:global/OpenERP_NOMMAT/NomenclatorMaterialeImpl!org.open.erp.services.nommat.NomenclatorMaterialeSrv")
	private NomenclatorMaterialeSrv nommatSrv;

	/*
	 * @EJB(lookup=
	 * "java:global/OpenERP_PERSONAL/PersonalImpl!org.open.erp.services.personal.PersonalSrv"
	 * ) private PersonalSrv personalSrv;
	 */

	@EJB(lookup = "java:global/OpenERP_NOMGEN/NomenclatoareImpl!org.open.erp.services.nomgen.NomenclatoareSrv")
	private NomenclatoareSrv nomgenSrv;

	public void setNommatSrv(NomenclatorMaterialeSrv nommatSrv) {
		this.nommatSrv = nommatSrv;
	}

	@Override
	public void setNomgenSrv(NomenclatoareSrv nomgenSrv) {
		this.nomgenSrv = nomgenSrv;

	}

	/*
	 * public void setPersonalSrv(PersonalSrv personalSrv) { this.personalSrv =
	 * personalSrv; }
	 */

	@Override
	public Promotie crearePromotie(Promotie promotie) {
		logger.info("5.1 Initiere/Creare promotie noua");

		entityManager.persist(promotie);

		return promotie;
	}

	@Override
	public CampaniePromovare creareCampaniePromovare(CampaniePromovare campaniePromovare) {
		logger.debug("3.1 Initiere/Creare campanie promovare noua");

		entityManager.persist(campaniePromovare);

		return campaniePromovare;
	}

	@Override
	public RaspunsIntrebare creareRaspunsIntrebare(RaspunsIntrebare raspunsIntrebare) {
		logger.debug("2.3 Initiere/Creare raspuns nou");

		entityManager.persist(raspunsIntrebare);

		return raspunsIntrebare;
	}

	@Override
	public Intrebare creareIntrebare(Intrebare intrebare) {
		logger.debug("2.2 Initiere/Creare intrebare noua");

		entityManager.persist(intrebare);

		return intrebare;
	}

	@Override
	public Chestionar creareChestionar(Chestionar chestionar) {
		logger.debug("2.1 Initiere/Creare chestionar nou");

		entityManager.persist(chestionar);

		return chestionar;
	}

	@Override
	public CercetarePiata creareCercetarePiata(CercetarePiata cercetarePiata) {
		logger.debug("1.1 Initiere/Creare cercetare de piata noua");

		entityManager.persist(cercetarePiata);

		return cercetarePiata;
	}

	@Override
	public Reclamatie creareReclamatie(Reclamatie reclamatie) {
		logger.debug("5.1 Initiere/Creare reclamatie noua");

		entityManager.persist(reclamatie);

		return reclamatie;
	}

	@Override
	public CampaniePromovare findCampanieById(long id) {

		CampaniePromovare campaniePromovare = entityManager.find(CampaniePromovare.class, id);

		return campaniePromovare;
	}
}

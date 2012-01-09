package org.open.erp.services.stocuri.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.BonConsum;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.LogInterceptor;
import org.open.erp.services.stocuri.LoturiIntrari;
import org.open.erp.services.stocuri.StocuriSrvLocal;
import org.open.erp.services.stocuri.StocuriSrvRemote;
import org.open.erp.services.stocuri.exceptions.IntrariStocExceptions;
import org.open.erp.services.stocuri.exceptions.StocuriExceptions;
import org.open.erp.services.stocuri.impl.AplicarePret.METODE;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
@Interceptors(LogInterceptor.class)
@Stateless(name = "StocuriSrv", mappedName = "StocuriSrv")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StocuriImpl implements StocuriSrvLocal, StocuriSrvRemote {
	private Procesare procesare;
	private AplicarePret applicarePret;
	@Resource
	private SessionContext sessionContext;
	@PersistenceContext(unitName = "OpenERP_STOCURI")
	private EntityManager em;

	@PostConstruct
	void init() {
		this.applicarePret = new AplicarePret(em);
		this.procesare = new Procesare(applicarePret, em);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void intrareInStoc(Material mijlocCirculant, LoturiIntrari lot,
			Gestiune gestiune) {
		try {
			procesare.intrareInStoc(mijlocCirculant, lot, gestiune);
		} catch (IntrariStocExceptions e) {
			e.printStackTrace();
			IntrariStocExceptions.logger.loggeazaERROR(e.getMessage(), e);
		}

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void transfer(Gestiune gestOut, Gestiune gestIn,
			Material mijlocCirculant, Integer cantitate) {
		try {
			procesare.transfer(gestOut, gestIn, mijlocCirculant, cantitate);
		} catch (StocuriExceptions e) {
			e.printStackTrace();
			IntrariStocExceptions.logger.loggeazaERROR(e.getMessage(), e);
		}

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public BonConsum consumProductie(CerereAprovizionare comMateriale) {
		return (BonConsum) procesare.proceseazaComandaMateriale(comMateriale);

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Double getStocMaterialByGestiune(Material material, Gestiune gestiune) {
		return procesare
				.getRegArtStoc()
				.getArticolByGestiuneAndMaterial(gestiune.getIdGestiune(),
						material.getIdMaterial()).getCatitateStocPeGestiune()
				.doubleValue();

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Double getPretArticolAplicareMetodaCalcul(ArticolStoc articol) {
		try {
			return applicarePret.getPretProdLot(articol);
		} catch (StocuriExceptions e) {
			e.printStackTrace();
			IntrariStocExceptions.logger.loggeazaERROR(e.getMessage(), e);
			return null;
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Double verificareStocMaterial(Material material) {
		try {
			return procesare.verificareStocMaterial(material);
		} catch (StocuriExceptions e) {
			e.printStackTrace();
			IntrariStocExceptions.logger.loggeazaERROR(e.getMessage(), e);
			return 0.0;
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void iesireStoc(Document doc) {
		try {
			procesare.procesareComandaIesire(doc);
		} catch (StocuriExceptions e) {
			e.printStackTrace();
			IntrariStocExceptions.logger.loggeazaERROR(e.getMessage(), e);
		}

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Boolean intrareInStoc(Document doc, Gestiune gestIn) {
		return procesare.intrareInStoc(doc, gestIn);

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Boolean iesireDinStoc(Material material, Integer cantitate) {
		try {
			return procesare.iesireDinStoc(material, cantitate);

		} catch (StocuriExceptions e) {
			e.printStackTrace();
			IntrariStocExceptions.logger.loggeazaERROR(e.getMessage(), e);
			return false;
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Document proceseazaComandaMateriale(
			CerereAprovizionare comandaMateriale) {

		// sessionContext.getTimerService().createTimer(
		// new Date(new Date().getTime() + (12 * 60 * 60 * 1000)),
		// "start new timer");
		return procesare.proceseazaComandaMateriale(comandaMateriale);
	}

	@Override
	public List<ArticolStoc> getArticole() {
		return procesare.getRegArtStoc().getListaByClasa(ArticolStoc.class);
	}

	@Override
	public ArticolStoc getArticolById(Integer id) {
		return procesare.getRegArtStoc().getEntityById(id, ArticolStoc.class);
	}

	public SessionContext getSessionContext() {
		return sessionContext;
	}

	@Override
	public void setMetodaCurenta(METODE metoda) {
		applicarePret.setMetodaCurenta(metoda);

	}

	@Override
	public METODE getMetodaCurenta() {
		return applicarePret.getMetodaCurenta();
	}

	@Override
	@Timeout
	public void urmarireListaPrioritati(Timer timer) {
		try {
			procesare.urmarireListaPrioritati();
		} catch (StocuriExceptions e) {
			e.logger.loggeazaERROR("esec in urmarirea comanzilor", e);
		}
	}

}

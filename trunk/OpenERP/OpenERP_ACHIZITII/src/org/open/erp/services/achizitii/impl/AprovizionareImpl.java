package org.open.erp.services.achizitii.impl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.AprovizionareSrvLocal;
import org.open.erp.services.achizitii.AprovizionareSrvRemote;
import org.open.erp.services.achizitii.Articol;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.achizitii.LinieCerereOferta;
import org.open.erp.services.achizitii.LinieComanda;
import org.open.erp.services.achizitii.LinieOfertaAchizitie;
import org.open.erp.services.achizitii.LiniePlanAprovizionare;
import org.open.erp.services.achizitii.NIR;
import org.open.erp.services.achizitii.OfertaAchizitie;
import org.open.erp.services.achizitii.PlanAprovizionare;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.StareDocument;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.Procesare;

import com.sun.xml.ws.developer.Stateful;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */

@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AprovizionareImpl implements AprovizionareSrv,
		PropertyChangeListener, AprovizionareSrvLocal, AprovizionareSrvRemote {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(AprovizionareImpl.class.getName());
	
	@EJB(mappedName = "ContabilizareSrvImpl/local")
	 private ContabilizareSrv contabilizareSrv;
	
	@EJB(mappedName = "StocuriSrvImpl/local")
	 private StocuriSrv stocuriSrv;
	
	@PersistenceContext(unitName = "OpenERP_Achizitii")
	 private EntityManager entityManager;
	
	@Resource
	 private SessionContext sessionContext;
	
	public AprovizionareImpl() {
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public PlanAprovizionare inregistrareCerereAprovizionare(Document cerereApr) {
		// Vom crea un plan de aprovizionare nou daca suntem intr-o saptamana
		// noua,
		// altfel vom return planul de aprovizionare existent
		PlanAprovizionare plan = PlanAprovizionare.getPlanAprovizionare();
		CerereAprovizionare cerere = (CerereAprovizionare) cerereApr;
		// Vom adauga in plan liniile din cerere. In cazul in care in plan nu
		// exista produsele din liniile cererii vom
		// crea o linie noua in plan
		// logger.debug("NrLinii: "+cerereApr.getLiniiDocument().size());
		for (LinieDocument linieCerere : cerere.getLiniiDocument()) {
			LiniePlanAprovizionare liniePlan = plan
					.existaArticolInLiniiPlan(linieCerere.getMaterial());

			logger.debug("ExistaArticolInLiniiPlan: " + liniePlan);
			int linii = plan.getLiniiPlan().size();
			logger.error("NrLiniiInitial: " + linii);
			if (liniePlan == null) {
				liniePlan = new LiniePlanAprovizionare(
						linieCerere.getMaterial(), linieCerere.getCantitate(),
						linii + 1);
				liniePlan.setPlanAprovizionare(plan);
				liniePlan.setStatus(LiniePlanAprovizionare.IN_ASTEPTARE);
				plan.addLiniePlan(liniePlan);
			} else {
				liniePlan.setCantitate(liniePlan.getCantitate()
						+ linieCerere.getCantitate());
			}

		}
		return plan;

	}
		
	public void ascultaFurnizoriCerereriAprovizionare(Procesare procesare) {

		try {
			procesare.addChangeListener(this);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void propertyChange(
			PropertyChangeEvent evenimentCuCerereAprovizionare) {
		// Se extrage cererea de aprovizionare din evenimentul generat de
		// crearea unei noi Cereri de Aprovizionare in clasa
		// Procesare apartinand modulului de Stocuri
		// logger.debug("Metoda : propertyChange ");
		try {
			this.inregistrareCerereAprovizionare((CerereAprovizionare) evenimentCuCerereAprovizionare
					.getNewValue());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
	}

	
	// fiecare linie a Planului de Aprovizionare devine o Cerere de Oferta
	// pentru furnizori
	// schimbam statusul pentru fiecare linie pentru a sti care care sunt
	// articolele pentru care s-a facut cererea de oferta
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public CerereOferta adaugareLiniiCerereOferta(CerereOferta cerere,
			List<LiniePlanAprovizionare> liniiPlan) {
		CerereOferta cerereOferta = cerere;
		Integer linie = cerere.getLinii().size();
		for (LiniePlanAprovizionare liniePlan : liniiPlan) {
			Material articol = liniePlan.getArticol();
			Double cantitate = liniePlan.getCantitate();
			LinieCerereOferta linieCerereOferta = new LinieCerereOferta(
					linie + 1, cerere, articol, cantitate);
			liniePlan.setStatus(LiniePlanAprovizionare.EXISTA_CERERE_OFERTA);
			cerere.addLinieCerere(linieCerereOferta);
			linie++;
		}
		return cerereOferta;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	// se inregistreaza Oferta de Achizitie primita de la furnizor
	public OfertaAchizitie creareOfertaAchizitie(CerereOferta cerereOferta,
			Date data, Furnizor furnizor, List<LinieOfertaAchizitie> linii) {

		cerereOferta.setStatusCerereOferta(CerereOferta.PRIMITA);
		return new OfertaAchizitie(data, OfertaAchizitie.IN_CURS, furnizor,
				linii);

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Comanda analizaOferteAchizitie(List<OfertaAchizitie> oferteAchizitie) {
		Double prag = (double) 9999999;
		OfertaAchizitie ofertaPrag = null;
		for (OfertaAchizitie oferta : oferteAchizitie) {
			double pragOferta = 0;
			double valTotal = 0;
			for (LinieOfertaAchizitie linie : oferta.getLiniiOferta()) {
				valTotal += linie.getPret() * linie.getCantitate();
			}
			oferta.setValTotal(valTotal);
			pragOferta = 0.8 * valTotal + 0.2 * oferta.getNrZile();
			if (pragOferta <= prag) {
				prag = pragOferta;
				ofertaPrag = oferta;
			}
		}
		logger.fatal(ofertaPrag.getNrZile());
		for (LinieOfertaAchizitie linie : ofertaPrag.getLiniiOferta()) {
			logger.fatal(linie.getLinie() + " "
					+ linie.getArticol().getDenumire() + " "
					+ linie.getCantitate() + " " + linie.getPret());
		}
		return this.creareComandaDinOferta(ofertaPrag);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	// Comanda se realizeaza pe baza liniilor de Aprovizionare - in cazul
	// comenzilor regulate
	public Comanda adaugaLiniiComanda(Comanda comanda,
			List<LiniePlanAprovizionare> liniiPlan) {
		Comanda comandaAchizitie = comanda;
		Integer linie = comandaAchizitie.getLiniiComanda().size();
		logger.error(comandaAchizitie.getLiniiComanda().size());
		for (LiniePlanAprovizionare liniePlan : liniiPlan) {
			LinieComanda linieComanda = new LinieComanda(linie + 1,
					comandaAchizitie, liniePlan.getArticol(),
					liniePlan.getCantitate(),
					((Articol) liniePlan.getArticol()).getPretAchizitie());
			comandaAchizitie.addLinii(linieComanda);
			liniePlan.setStatus(LiniePlanAprovizionare.CREAT_COMANDA);
			linie++;
		}
		return comandaAchizitie;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	// Comanda se realizeaza pe baza Ofertei de Achizitie primita
	public Comanda creareComandaDinOferta(OfertaAchizitie oferta) {
		Comanda comanda = new Comanda(oferta.getFurnizor(),
				oferta.getDataOferta(), Comanda.IN_CURS);
		Integer linie = comanda.getLiniiComanda().size();
		for (LinieOfertaAchizitie linieOferta : oferta.getLiniiOferta()) {
			LinieComanda linieComanda = new LinieComanda(linie + 1, comanda,
					linieOferta.getArticol(), linieOferta.getCantitate(),
					linieOferta.getPret());
			comanda.addLinii(linieComanda);
			linie++;
		}
		return comanda;
	}

	
	public NIR adaugareLiniiNir(NIR nir, List<LinieDocument> liniiNIR)
			throws CtbException {
		NIR nirFact = nir;
		nir.setLiniiDocument(liniiNIR);
		this.inregistrareFactura(nir.getFactura());
		logger.debug("S-a jurnalizat factura aferenta NIR-ului");
		this.receptieMateriale(nir);
		logger.debug("S-au inregistrat pe stoc articolele din NIR");
		return nirFact;

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int inregistrareFactura(Factura factura) throws CtbException {
		logger.debug("Se incearca inregistrarea facturii "
				+ factura.getNrFact());
		return contabilizareSrv.jurnalizareAchizitie(factura.getDataDoc(),
				((Factura) factura).getValFact(),
				((Factura) factura).getTVATotal(), factura.getNrDoc(),
				((Factura) factura).getFurnizor().getId(),
				factura.getLiniiDocument(), StareDocument.NOU, 1);

	}

	public int procesareFactRetur(Factura facturaRetur) throws CtbException {
		this.returMateriale(facturaRetur);
		return contabilizareSrv.jurnalizareAchizitie(facturaRetur.getDataDoc(),
				((Factura) facturaRetur).getValFact(), ((Factura) facturaRetur)
						.getTVATotal(), facturaRetur.getNrDoc(),
				((Factura) facturaRetur).getFurnizor().getId(), facturaRetur
						.getLiniiDocument(), StareDocument.NOU, 1);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void receptieMateriale(Document nir) {
		try {
			stocuriSrv.intrareInStoc(nir,null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void returMateriale(Document facturaRetur) {
		try {
			stocuriSrv.iesireStoc(facturaRetur);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int hashCode() {
		// TODO Auto-generated method stub

		return super.hashCode();

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

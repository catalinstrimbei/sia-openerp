package org.open.erp.services.achizitii.impl;


import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
import org.open.erp.services.achizitii.exceptions.AchizitiiExceptions;
import org.open.erp.services.achizitii.registri.RegistruAprovizionare;
import org.open.erp.services.achizitii.registri.RegistruAprovizionareEJB;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.StareDocument;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.ctbgen.impl.ContabilizareSrvImpl;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.Procesare;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */

@Stateful (name= "AprovizionareSrv")
@TransactionManagement(TransactionManagementType.CONTAINER)
 
public class AprovizionareImpl implements AprovizionareSrvLocal, AprovizionareSrvRemote {
    public PlanAprovizionare planAprovizionare=null;
    public CerereOferta cerereOf=null;
    public List<LiniePlanAprovizionare> liniiPlanAprovizionareComanda=new ArrayList<LiniePlanAprovizionare>();
    public List<LiniePlanAprovizionare> liniiPlanAprovizionareCerereOf=new ArrayList<LiniePlanAprovizionare>();
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(AprovizionareImpl.class.getName());	

	@EJB(mappedName = "ContabilizareSrv/local")
	 private ContabilizareSrv contabilizareSrv=new ContabilizareSrvImpl();
	
	@EJB(mappedName = "StocuriSrv/local")
	 private StocuriSrv stocuriSrv;
	
	
	
	@PersistenceContext(unitName = "OpenERP_ACHIZITII")
	 private EntityManager em;
	
	@Resource
	 private SessionContext sessionContext;
	 public RegistruAprovizionare registru;
	 public RegistruAprovizionareEJB registruEJB; 

	
	public AprovizionareImpl() {
	}		
	

	@PostConstruct
	public void init(){
		logger.debug("<<< EM >>> = " + em);		
				
		if (this.registru == null)
			registru = new RegistruAprovizionare(em);
		
		if (this.registruEJB == null)
			registruEJB = new RegistruAprovizionareEJB(em);
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public PlanAprovizionare getPlanAprovizionare() throws AchizitiiExceptions {
		PlanAprovizionare plan;
		try {
		plan= this.registruEJB.getPlanAprovizionare();
		
		this.planAprovizionare=plan;
		} catch (Exception e) {
		   
			throw new AchizitiiExceptions("Eroare la persistenta: "+e.getMessage());
		}
		PlanAprovizionare planNou = null;
        if ((plan==null)||(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) != plan.getSaptAn())||           
           (Calendar.getInstance().get(Calendar.YEAR) != plan.getAn()))
          { 
        	if (plan!=null){
        		plan.setStatusPlan(PlanAprovizionare.FINALIZAT);
        		try {
					plan=this.registru.salveazaPlanAprovizionare(plan);
				} catch (Exception e) {
					throw new AchizitiiExceptions("Eroare la persistenta PlanAprovizionare: "+e.getMessage());
				}
        	}
        	Calendar c = Calendar.getInstance();
     	    Date date = new Date();
     	    c.setTime(date);
     	    c.setFirstDayOfWeek(Calendar.MONDAY);
     	    c.set(Calendar.DAY_OF_WEEK,  Calendar.SUNDAY);
     	   planNou = new PlanAprovizionare(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR)					
					,Calendar.getInstance().get(Calendar.YEAR)
					,Calendar.getInstance().getTime()
					,c.getTime());			
     	  planNou.setStatusPlan(PlanAprovizionare.IN_CURS);
     	  try {
			planNou=this.registru.salveazaPlanAprovizionare(planNou);
		       } catch (Exception e) {
			throw new AchizitiiExceptions("Eroare la persistenta Plan Aprovizionare: "+e.getMessage());
		       }
     	  this.planAprovizionare=planNou;
        }
        return planNou;
    }
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public PlanAprovizionare inregistrareCerereAprovizionare(PlanAprovizionare plan,Document cerereApr) throws AchizitiiExceptions {
		// Vom crea un plan de aprovizionare nou daca suntem intr-o saptamana
		// noua,
		// altfel vom return planul de aprovizionare existent		
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
			this.inregistrareCerereAprovizionare(this.planAprovizionare,(CerereAprovizionare) evenimentCuCerereAprovizionare
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
   //---***--- Linii Plan Aprovizionare transformate in cerereOferta care trebuie salvate in BD dupa executarea acestei metode
			this.liniiPlanAprovizionareCerereOf.add(liniePlan);			
		}
		return cerereOferta;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	// se inregistreaza Oferta de Achizitie primita de la furnizor
	public OfertaAchizitie creareOfertaAchizitie(CerereOferta cerereOferta,
			Date data, Furnizor furnizor, LinkedList<LinieOfertaAchizitie> linii) throws AchizitiiExceptions {
        OfertaAchizitie ofertaAchizitie=new OfertaAchizitie(data, OfertaAchizitie.IN_CURS, furnizor,linii);
        ofertaAchizitie.setCerereOferta(cerereOferta);
		cerereOferta.setStatusCerereOferta(CerereOferta.PRIMITA);
		this.cerereOf=cerereOferta;
   //---***--- Dupa crearea unei Oferte de achizitii trebuie salvata in BD si variabila privata CerereOf;
		return ofertaAchizitie;
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
		comanda.setOfertaAchizitie(oferta);
		return comanda;
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
	//---***--- Linii Plan Aprovizionare transformate in linii comanda care trebuie salvate in BD dupa executarea acestei metode
			this.liniiPlanAprovizionareComanda.add(liniePlan);	
		}
		return comandaAchizitie;
	}

	
	public NIR adaugareLiniiNir(NIR nir, List<LinieDocument> liniiNIR)
			throws CtbException {
		NIR nirFact = nir;
		nir.setLiniiDocument(liniiNIR);
		//this.inregistrareFactura(nir.getFactura()); -- 1
		logger.debug("S-a jurnalizat factura aferenta NIR-ului");
		//this.receptieMateriale(nir); --2
		// 1 si 2 se executa dupa ce se apeleaza metoda curenta 'adaugaLiniiNir'
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
				((Factura) factura).getTVATotal(), (int) factura.getNrDoc(),
				 ((Factura) factura).getFurnizor().getIdFurnizor(),
				factura.getLiniiDocument(), StareDocument.NOU, 1);

	}

	public int procesareFactRetur(Factura facturaRetur) throws CtbException {
		//this.returMateriale(facturaRetur); -- se executa dupa apelarea metodei curente 'procesareFactRetur'
		return contabilizareSrv.jurnalizareAchizitie(facturaRetur.getDataDoc(),
				((Factura) facturaRetur).getValFact(), ((Factura) facturaRetur)
						.getTVATotal(), (int) facturaRetur.getNrDoc(),
				((Factura) facturaRetur).getFurnizor().getIdFurnizor(), facturaRetur
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

	public SessionContext getSessionContext() {
		return sessionContext;
	}

	public void setSessionContext(SessionContext sessionContext) {
		this.sessionContext = sessionContext;
	}

}

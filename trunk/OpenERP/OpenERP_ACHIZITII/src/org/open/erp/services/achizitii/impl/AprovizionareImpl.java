package org.open.erp.services.achizitii.impl;


import java.beans.PropertyChangeEvent;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
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
import org.open.erp.services.achizitii.Categorie;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.achizitii.LinieCerereOferta;
import org.open.erp.services.achizitii.LinieComanda;
import org.open.erp.services.achizitii.LinieFacturaAchizitie;
import org.open.erp.services.achizitii.LinieNIR;
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
    public PlanAprovizionare planAprovizionare;
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

	@Override
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
		return contabilizareSrv.jurnalizareAchizitie(factura.getDataDocument(),
				((Factura) factura).getValFact(),
				((Factura) factura).getTVATotal(), (int) factura.getNrDoc(),
				 ((Factura) factura).getFurnizor().getIdFurnizor(),
				factura.getLiniiDocument(), StareDocument.NOU, 1);

	}

	public int procesareFactRetur(Factura facturaRetur) throws CtbException {
		//this.returMateriale(facturaRetur); -- se executa dupa apelarea metodei curente 'procesareFactRetur'
		return contabilizareSrv.jurnalizareAchizitie(facturaRetur.getDataDocument(),
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
	@Override
	public Articol getArticoleById(Integer idMaterial_) throws Exception {
		try {
			return registru.getArticoleById(idMaterial_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public Collection<Articol> getListaArticole() throws Exception {
		try {
			return registru.getListaArticole();
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public Articol salveazaArticol(Articol articol_) throws Exception {
		try {
			return registru.salveazaArticol(articol_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}		
	}
   @Override
	public void stergeArticol(Articol articol_) throws Exception {
		try {
			this.registru.stergeArticol(articol_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	// ////////////////////////
   @Override
	public Categorie getCategorieById(long id_cat_) throws Exception {
		try {
			return this.registru.getCategorieById(id_cat_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public Collection<Categorie> getListaCategorii() throws Exception {
		try {
			return registru.getListaCategorii();
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public Categorie salveazaCategorie(Categorie categorie_) throws Exception {
		try {
			return this.registru.salveazaCategorie(categorie_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}		
	}
   @Override
	public void stergeCategorie(Categorie categorie_) throws Exception {
		try {
			registru.stergeCategorie(categorie_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	// //////////
   @Override
	public CerereOferta getCerereOfertaById(long id_CerereOferta_) throws Exception {
		try {
			return registru.getCerereOfertaById(id_CerereOferta_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public Collection<CerereOferta> getListaCereriOferta() throws Exception {
		try {
			return registru.getListaCereriOferta();
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public CerereOferta salveazaCerereOferta(CerereOferta cerereOferta_)
			throws Exception {
		try {
			return registru.salveazaCerereOferta(cerereOferta_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
		//return cerereOferta_;
	}
   @Override
	public void stergeCerereOferta(CerereOferta cerereOferta_) throws Exception {
		try {
			registru.stergeCerereOferta(cerereOferta_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	// /////////////////
   @Override
	public Comanda getComandaById(Integer idComanda_) throws Exception {
		try {
			return registru.getComandaById(idComanda_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public Collection<Comanda> getListaComenzi() throws Exception {
		try {
			return registru.getListaComenzi();
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public Comanda salveazaComanda(Comanda comanda_) throws Exception {
		try {
			return registru.salveazaComanda(comanda_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
		//return comanda_;
	}
   @Override
	public void stergeComanda(Comanda comanda_) throws Exception {
		try {
			registru.stergeComanda(comanda_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	// Metode NIR
   @Override
	public NIR getNIRByIdId(long nrDocument_) throws Exception {
		try {
			return registru.getNIRByIdId(nrDocument_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}

	}
   @Override
	@SuppressWarnings("unchecked")
	public Collection<NIR> getListaNIR() throws Exception {
		try {
			return registru.getListaNIR();
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public NIR salveazaNIR(NIR NIR_) throws Exception {
		try {
			return registru.salveazaNIR(NIR_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
		//return NIR_;
	}
   @Override
	public void stergeNIR(NIR NIR_) throws Exception {
		try {
			registru.stergeNIR(NIR_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}

	// Metode OfertaAchizitie
   @Override
	public OfertaAchizitie getOfertaAchizitie(long id_OfertaAchizitie_)
			throws Exception {
		try {
			return registru.getOfertaAchizitie(id_OfertaAchizitie_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}

	}
   @Override
	@SuppressWarnings("unchecked")
	public Collection<OfertaAchizitie> getListaOfertaAchizitie() throws Exception {
		try {
			return registru.getListaOfertaAchizitie();
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public OfertaAchizitie salveazaOfertaAchizitie(OfertaAchizitie OfertaAchizitie_)
			throws Exception {
		try {
			return registru.salveazaOfertaAchizitie(OfertaAchizitie_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
		//return OfertaAchizitie_;
	}
   @Override
	public void stergeOfertaAchizitie(OfertaAchizitie OfertaAchizitie)
			throws Exception {
		try {
			registru.stergeOfertaAchizitie(OfertaAchizitie);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}

	// Metode PlanAprovizionare
   @Override
	public PlanAprovizionare getPlanAprovizionareById(long idPlanAprovizionare_)
			throws Exception {
		try {
			return registru.getPlanAprovizionareById(idPlanAprovizionare_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}

	}
   @Override
	@SuppressWarnings("unchecked")
	public Collection<PlanAprovizionare> getListaPlanAprovizionare() throws Exception {
		try {
			return registru.getListaPlanAprovizionare();
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public PlanAprovizionare salveazaPlanAprovizionare(
			PlanAprovizionare PlanAprovizionare_) throws Exception {
		try {
			return registru.salveazaPlanAprovizionare(PlanAprovizionare_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
		//return PlanAprovizionare_;
	}
   @Override
	public void stergePlanAprovizionare(PlanAprovizionare PlanAprovizionare_)
			throws Exception {
		try {
			registru.stergePlanAprovizionare(PlanAprovizionare_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}
   @Override
	public Factura getFacturaById(Integer idActivitate_) throws Exception {
		try {
			return registru.getFacturaById(idActivitate_);
		} catch (Exception ex) {

			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			throw ex;
		}
	}
   @Override
	public Collection<Factura> getListaFactura() throws Exception {
		try {
			return registru.getListaFactura();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}
   @Override
	public Factura salveazaFactura(Factura factura_) throws Exception {
		try {
			return registru.salveazaFactura(factura_);
		} catch (Exception ex) {
			logger.error("eroare in metoda salveazafactura");
			ex.printStackTrace();
			throw ex;
		}
		//return factura_;
	}
   @Override
	public void stergeFactura(Factura factura_) throws Exception {
		try {
			registru.stergeFactura(factura_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}
   @Override
	public Furnizor getFurnizorById(Integer id_) throws Exception {
		try {
			return registru.getFurnizorById(id_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("eroare in metoda getFurnizorbyId");
			ex.printStackTrace();
			throw ex;
		}
	}
   @Override
	public Collection<Furnizor> getListaFurnizor() throws Exception {
		try {
			return registru.getListaFurnizor();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("eroare in metoda getListaFurnizor");
			ex.printStackTrace();
			throw ex;
		}
	}
   @Override
	public Furnizor salveazaFurnizor(Furnizor furnizor_) throws Exception {
		logger.info("Am intrat pe  salveazaFurnizor in RegistruAprovizionare");
		try {
			return registru.salveazaFurnizor(furnizor_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
		//return furnizor_;
	}
   @Override
	public LinieCerereOferta getLinieCerereOfertaById(Integer idliniecerereoferta_)
			throws Exception {
		try {
			return registru.getLinieCerereOfertaById(idliniecerereoferta_);
		} catch (Exception ex) {

			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			throw ex;
		}
	}
   @Override
	public Collection<LinieCerereOferta> getLinieCerereOferta() throws Exception {
		try {
			return registru.getLinieCerereOferta();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}
   @Override
	public LinieCerereOferta salveazaLinieCerereOferta(
			LinieCerereOferta liniecerereoferta_) throws Exception {
		try {
			return registru.salveazaLinieCerereOferta(liniecerereoferta_);
		} catch (Exception ex) {
			logger.error("eroare in metoda salveazaLinieCerereOferta");
			ex.printStackTrace();
			throw ex;
		}
		//return liniecerereoferta_;
	}
   @Override
	public void stergeLinieCerereOferta(LinieCerereOferta liniecerereoferta_)
			throws Exception {
		try {
			registru.stergeLinieCerereOferta(liniecerereoferta_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}
   @Override
	public LinieComanda getLinieComandaById(Integer idliniecomanda_) throws Exception {
		try {
			return registru.getLinieComandaById(idliniecomanda_);
		} catch (Exception ex) {

			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			throw ex;
		}
	}
   @Override
	public Collection<LinieComanda> getLinieComanda() throws Exception {
		try {
			return registru.getLinieComanda();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}
   @Override
	public LinieComanda salveazaLinieComanda(LinieComanda liniecomanda_)
			throws Exception {
		try {
			return registru.salveazaLinieComanda(liniecomanda_);
		} catch (Exception ex) {
			logger.error("eroare in metoda salveazaLinieComanda");
			ex.printStackTrace();
			throw ex;
		}
		//return liniecomanda_;
	}
   @Override
	public void stergeLinieComanda(LinieComanda liniecomanda_) throws Exception {
		try {
			registru.stergeLinieComanda(liniecomanda_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}

	// ----------------LinieFacturaAchizitie--------------------------
   @Override
	public LinieFacturaAchizitie getLinieFacturaAchizitieById(Integer linieDoc)
			throws Exception {
		try {
			return registru.getLinieFacturaAchizitieById(linieDoc);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
   @Override
	public Collection<LinieFacturaAchizitie> getLinieFacturaAchizitie()
			throws Exception {
		try {
			return registru.getLinieFacturaAchizitie();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
   @Override
	public LinieFacturaAchizitie salveazaLinieFacturaAchizitie(
			LinieFacturaAchizitie lfactAchiz_) throws Exception {
		try {
			return registru.salveazaLinieFacturaAchizitie(lfactAchiz_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
		//return lfactAchiz_;
	}
   @Override
	public void stergeLinieFacturaAchizitie(LinieFacturaAchizitie lFactAchiz_)
			throws Exception {
		try {
			registru.stergeLinieFacturaAchizitie(lFactAchiz_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	// ------------------------linie nir---------------------
   @Override
	public LinieNIR getLinieNIRById(Integer linieDoc) throws Exception {
		try {
			return registru.getLinieNIRById(linieDoc);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
   @Override
	public Collection<LinieNIR> getLinieNIR() throws Exception {
		try {
			return registru.getLinieNIR();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
   @Override
	public LinieNIR salveazaLinieNIR(LinieNIR linieNir_) throws Exception {
		try {
			return registru.salveazaLinieNIR(linieNir_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
		//return linieNir_;
	}
   @Override
	public void stergeLinieNIR(LinieNIR linieNir_) throws Exception {
		try {
			registru.stergeLinieNIR(linieNir_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	// --------Linie oferta achizitie----------
   @Override
	public LinieOfertaAchizitie getLinieOfertaAchizitieById(Integer linieDoc)
			throws Exception {
		try {
			return registru.getLinieOfertaAchizitieById(linieDoc);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
   @Override
	public Collection<LinieOfertaAchizitie> getLinieOfertaAchizitie() throws Exception {
		try {
			return registru.getLinieOfertaAchizitie();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
   @Override
	public LinieOfertaAchizitie salveazaLinieOfertaAchizitie(
			LinieOfertaAchizitie lofertaAchiz_) throws Exception {
		try {
			return registru.salveazaLinieOfertaAchizitie(lofertaAchiz_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
		//return lofertaAchiz_;
	}
   @Override
	public void stergeLinieOfertaAchizitie(LinieOfertaAchizitie lofertaAchiz_)
			throws Exception {
		try {
			registru.stergeLinieOfertaAchizitie(lofertaAchiz_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	// -----------------------linie plan aprovizionare-------------
	@Override
	public LiniePlanAprovizionare getLiniePlanAprovizionareById(
			Integer idLiniePlanAprovizionare) throws Exception {
		try {
			return registru.getLiniePlanAprovizionareById(idLiniePlanAprovizionare);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	@Override
	public Collection<LiniePlanAprovizionare> getLiniePlanAprovizionare()
			throws Exception {
		try {
			return registru.getLiniePlanAprovizionare();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	@Override
	public LiniePlanAprovizionare salveazaLiniePlanAprovizionare(
			LiniePlanAprovizionare lofertaAprov_) throws Exception {
		try {
			return registru.salveazaLiniePlanAprovizionare(lofertaAprov_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
		//return lofertaAprov_;
	}
	@Override
	public void stergeLiniePlanAprovizionare(LiniePlanAprovizionare lofertaAprov_)
			throws Exception {
		try {
			registru.stergeLiniePlanAprovizionare(lofertaAprov_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<OfertaAchizitie> getOferteAchizitiePerFurnizor(Furnizor furnizor_) throws Exception{
		try{
			return registruEJB.getOferteAchizitiePerFurnizor(furnizor_);
		}catch(Exception ex){
			logger.error("ERROR: "+ex.getMessage());
			throw ex;
		}
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Articol> getArticolePeCategorii(Categorie categorie_) throws Exception{
		try{
			return registruEJB.getArticolePeCategorii(categorie_);
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Categorie> getCategoriiPeFurnizori(Furnizor furnizor_) throws Exception{
		try{
			return registruEJB.getCategoriiPeFurnizori(furnizor_);
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<CerereOferta> getCereriOfertaPeStatus(Integer statusCerereOferta_) throws Exception{
		try{
			return registruEJB.getCereriOfertaPeStatus(statusCerereOferta_);
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Comanda> getcomenziPeFurnizor(Furnizor furnizor_) throws Exception{
		try{
			return registruEJB.getcomenziPeFurnizor(furnizor_);
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Comanda> getComenziPeStatus(Integer statusComanda_) throws Exception{
		try{
			return registruEJB.getComenziPeStatus(statusComanda_);
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	@Override
	public PlanAprovizionare getPlanAprovizionareRegistru() throws Exception{
		try{
			return (PlanAprovizionare) registruEJB.getPlanAprovizionare();
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}


}

package org.open.erp.services.contabgen.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.exceptii.ExceptieTipContInvalid;
import org.open.erp.services.contabgen.ContabilitateGeneralaLocalSrv;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.contabgen.conturi.Clasa;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.conturi.Cont.Tip;
import org.open.erp.services.contabgen.conturi.ContActiv;
import org.open.erp.services.contabgen.conturi.ContCheltuieli;
import org.open.erp.services.contabgen.conturi.ContPasiv;
import org.open.erp.services.contabgen.conturi.ContVenituri;
import org.open.erp.services.contabgen.conturi.PlanConturi;
import org.open.erp.services.contabgen.rapoarte.BilantContabil;
import org.open.erp.services.contabgen.sabloane.Sablon;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiune;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiuneContabila;
import org.open.erp.services.contabgen.tranzactii.OperatiuneContabila;
import org.open.erp.services.contabgen.tranzactii.Tranzactie;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContabilitateGeneralaImpl implements ContabilitateGeneralaLocalSrv, ContabilitateGeneralaSrv {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ContabilitateGeneralaImpl.class.getName());

	ContabilitateGeneralaRegistru registru;
	
	@PersistenceContext(unitName = "OpenERP_CONTABGEN")
	private EntityManager em;
	
	@PostConstruct
	public void init(){		
		if (this.registru == null)
			registru = new ContabilitateGeneralaRegistru(em);
	}	
	
	@Override
	public boolean adaugaCont(Cont cont, Integer codClasa) {

		logger.info("Adaugare cont: " + cont.getDenumireCont() + "in clasa de conturi: "+ codClasa);
		
		try{
			Clasa cls = registru.getClasaDeConturi(codClasa); 
			
			if (cls==null){
				cls= new Clasa();
				cls.setCodClasa(codClasa);
				cls = em.merge(cls);
			}
			
			if (registru.getContDinClasaDeConturi(cont.getIdCont())==null){
				cont.setClasa(cls);
			}else{
				em.merge(cont);
			}
				
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** "+ex.getMessage());
			return false;
		}
		return true;	
	}

	@Override
	public Tranzactie creareTranzactie() {
		Tranzactie tran = new Tranzactie();
		return tran;
	}

	@Override
	public Sablon creareSablon(String denumire, OperatiuneContabila opCont) {
		logger.info("Creare sablon: " + denumire + "pentru operatiunea contabila: "+ opCont.getDescriereOperatiune());	
		
		for(InregistrareOperatiuneContabila op : opCont.getInregistrari())
		{
			logger.info("Cont debitor: " + op.getDebitCont().getDenumireCont());
			logger.info("Cont creditor: " + op.getContCredit().getDenumireCont());
		}
		
		logger.info("Salvare sablon");
		return em.merge(new Sablon(denumire, opCont));
	
	}

	@Override
	public BilantContabil creareBilantContabil() {
		logger.info("Creare bilant contabil: ");	
		BilantContabil bilant = new BilantContabil();
		List<Cont> conturi = registru.getConturiDinClaseleDeConturi();
		if(conturi == null)
			return null;
		
		bilant.setConturi(conturi);

		logger.info("Salvare bilant");
		return em.merge(bilant);
	}

	@Override
	public Cont creazaCont(Tip tip,int codCont, String denumire, String descriere,
			double sold, boolean tranzactionabil) throws ExceptieTipContInvalid {
		Cont cont;
		switch (tip) {
		case ACTIV:
			cont = registru.getContDinClasaDeConturi(ContActiv.class, codCont);
			return (cont!=null)? cont : (Cont) new ContActiv(codCont,  denumire,  descriere,
					 sold,  tranzactionabil);
		case CHELTUIELI:
			cont = registru.getContDinClasaDeConturi(ContCheltuieli.class, codCont);
			return (cont!=null)? cont : (Cont) new ContCheltuieli(codCont,  denumire,  descriere,
					 sold,  tranzactionabil);
		case VENITURI:
			cont = registru.getContDinClasaDeConturi(ContVenituri.class, codCont);
			return (cont!=null)? cont : (Cont) new ContVenituri(codCont,  denumire,  descriere,
					 sold,  tranzactionabil);
		case PASIV:
			cont = registru.getContDinClasaDeConturi(ContPasiv.class, codCont);
			return (cont!=null)? cont : (Cont) new ContPasiv(codCont,  denumire,  descriere,
					 sold,  tranzactionabil);
		default:
			throw new ExceptieTipContInvalid();
		}

	}

	@Override
	public Cont creazaCont(int codCont, String denumireCont,
			String descriere, double sold, Tip tip,
			List<InregistrareOperatiune> intrari, boolean tranzactionabil)
			throws ExceptieTipContInvalid {
		Cont cont = null;

		switch (tip) {
		case ACTIV:
			cont = (Cont) new ContActiv();
			break;
		case CHELTUIELI:
			cont = (Cont) new ContCheltuieli();
			break;
		case VENITURI:
			cont = (Cont) new ContVenituri();
			break;
		case PASIV:
			cont = (Cont) new ContPasiv();
			break;
		default:
			throw new ExceptieTipContInvalid();
		}
		if (cont == null)
			throw new ExceptieTipContInvalid();

		cont.adaugaProprietati(codCont, denumireCont, descriere, sold, tip,
				tranzactionabil, intrari);

		return (Cont) cont;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public PlanConturi creazaPlanConturi() {
		PlanConturi plan = registru.getPlanConturiConturi();
		if(plan == null){
			plan = new PlanConturi();
		}
		return plan;
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public boolean salveazaPlanConturi(PlanConturi plan) {
		try{
			em.merge(plan);
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** "+ex.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public ContabilitateGeneralaRegistru getRegistru() {
		return this.registru;
	}

}

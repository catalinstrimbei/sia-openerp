package org.open.erp.services.marketing.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.marketing.Campanie;
import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.Discount;
import org.open.erp.services.marketing.DummyProdus;
import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.MarketingManagementSrv;
import org.open.erp.services.marketing.MarketingManagementSrvLocal;
import org.open.erp.services.marketing.MarketingManagementSrvRemote;
import org.open.erp.services.marketing.PersoanaTinta;
import org.open.erp.services.marketing.ProdusDiscount;
import org.open.erp.services.marketing.ProduseAditionale;
import org.open.erp.services.marketing.Promotie;
import org.open.erp.services.marketing.RaspunsChestionar;
import org.open.erp.services.marketing.RaspunsIntrebare;
import org.open.erp.services.marketing.Responsabil;
//import org.open.erp.services.nomgen.NomenclatoareSrvLocal;
//import org.open.erp.services.nomgen.Produs;



/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
@Stateless(name="MarketingManagementSrvRemote")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MarketingManagementImpl implements  MarketingManagementSrvLocal,MarketingManagementSrvRemote {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MarketingManagementImpl.class.getName());
	
	private RegistruMarketing	registruMarketing;
	/* Dependente resurse injectate */
	@PersistenceContext(unitName="OpenERP_MARKETING")
	private EntityManager em;
	@Resource
	private SessionContext sessionContext;	
	//@EJB(mappedName="NomenclatoareDummyImpl/local") /* BUG JBoss 5 referinte EJB: de folosit mappedName */
	//private NomenclatoareSrvLocal nomGenSrv;
	/*
	 * 
	 * @ConstrutorForDummy
	 * 
	 */
	public MarketingManagementImpl() {
	}	
	
	@PostConstruct
	public void init(){
		logger.debug(">>>>>>>>>>>> Exista em? " + em);						
		
		if (this.registruMarketing == null)
			registruMarketing = new RegistruMarketing(em);
	}	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)

	@Override
	public Campanie definireCampanie(String nume, Date dataStart,
			Date dataSfarsit, List<PersoanaTinta> PersoaneTinta)
			throws Exception {
		logger.debug(">>>>>>>>>>>> START Creare Campanie");	
		
		Campanie campanieNoua = new Campanie();
		campanieNoua.setDenumireCampanie(nume);
		campanieNoua.setDataSfarsit(dataSfarsit);
		campanieNoua.setDataStart(dataStart);
		campanieNoua.setPersoaneTinta(PersoaneTinta);
		logger.debug(campanieNoua.getDenumireCampanie());
		logger.debug("Perioada in care se desfasoara campania:" + campanieNoua.getDataStart().toString() + " - " + campanieNoua.getDataSfarsit().toString());
		campanieNoua.setStatus(-1);
		campanieNoua.setPersoaneTinta(PersoaneTinta);
		
		logger.debug("Persoane avizate : " );
		for (int i=0 ; i < PersoaneTinta.size() ; i++)
		{
			logger.debug(PersoaneTinta.get(i).getNume() + " " + PersoaneTinta.get(i).getPrenume());
		}
		campanieNoua= this.salveazaCampanie(campanieNoua);
		
		return campanieNoua;
	}
	
	@Override
	public Promotie getPromotie(Integer idPromotie) {
		return registruMarketing.getPromotie(idPromotie);
	}
	@Override
	public DummyProdus getProdus(Integer idProdus) {
		return registruMarketing.getprodus(idProdus);
	}
	@Override
	public Campanie getCampanie(Integer idCampanie) {
		return registruMarketing.getCampanie(idCampanie);
//		return null;
	}	
	@Override
	public PersoanaTinta getPersoanaTinta(Integer idPersoana) {
		return registruMarketing.getPersoanaTinta(idPersoana);
//		return null;
	}	
	@Override
	public Discount getDiscount(Integer idDiscount) {
		return registruMarketing.getDiscount(idDiscount);
//		return null;
	}	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void initiereCampanie(Campanie campanie) throws Exception{
		campanie.setStatus(1);
		this.salveazaCampanie(campanie);
		//TODO creaza metoda pentru trimiterea mail-urilor catre persoanele tinta
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void finalizareCampanie(Campanie campanie) throws Exception {
		campanie = this.getCampanie(campanie.getIdCampanie());
		if (campanie.getStatus() != 1)
		{
			campanie = null;
			logger.debug("Campania trebuie sa fie in desfasurare");
		}
		else
			campanie.setStatus(2);
		this.salveazaCampanie(campanie);
		//TODO creaza metoda pentru interpretarea rezultatelor daca este cazul;
	}
	@Override
	public void derulareChestionar(Chestionar chestionar) {
		// TODO creaza metoda pentru trimiterea mail-urilor
		
	}
	@Override
	public Chestionar initiereChestionar(String denumire,
			Responsabil responsabil, Integer nrIntrebari, String scop,
			List<Intrebare> listaIntrebari) {
		Intrebare 		iteratorIntrebari;
		logger.debug("Chestionar " + denumire + " creat.");
		
		Chestionar chestionarNou = new Chestionar(1, denumire,  responsabil,scop,nrIntrebari,listaIntrebari);
		
		logger.debug(" Intrebari: " );
		for (int i=0 ; i < listaIntrebari.size() ; i++)
		{
			iteratorIntrebari = listaIntrebari.get(i);
			logger.debug(iteratorIntrebari.getIdIntrebare() + ") "  + iteratorIntrebari.getTextIntrebare());
		//	for (int j=1 ; j <= iteratorIntrebari.getRaspunsuri().size() ; j++){
		//		logger.debug("   "+j + ")" + iteratorIntrebari.getRaspuns(j));
		//	}
		}
		
		return chestionarNou;
	}
	@Override
	public void proceseazaRezultate(Chestionar chestionar) {
		// TODO creaza metoda pentru procesarea rezultatelor		
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Promotie definirePromotie(String denumire,
			String mesajPromotional, Date dataInceput, Date dataSfarsit,
			Integer tipPromotie)
					throws Exception {
		Promotie  promotieNoua = new Promotie();
		promotieNoua.setDenumirePromotie(denumire);
		promotieNoua.setMesajPromotional(mesajPromotional);
		promotieNoua.setDataStart(dataInceput);
		promotieNoua.setDataSfarsit(dataSfarsit);
		promotieNoua.setTipPromotie(tipPromotie);
		
		logger.debug(mesajPromotional);		
		promotieNoua.setListProduseAditionale((List)new ArrayList<ProdusDiscount>());
		promotieNoua.setListProduseAditionale((List)new ArrayList<ProduseAditionale>());
		promotieNoua = this.salveazaPromotie(promotieNoua);
		return promotieNoua;
	}
	
	@Override
	public float getPretFinalByPromotie(DummyProdus produs, Promotie promotie,float pretInitial) {
		ProdusDiscount  produsDiscount;
		Discount 		discount;
		Float			pretFinal = (float) 0;
		if (promotie.getTipPromotie() == Promotie.DISCOUNT)
		{
			Iterator<ProdusDiscount> iterator = promotie.getListaProduseDiscount().iterator();
			while (iterator.hasNext())
			{
				produsDiscount = iterator.next();
				if (produsDiscount.getProdus().equals(produs))
				{
					discount = this.getDiscount(produsDiscount.getDiscount().getIdDiscount());
					logger.debug(discount.getValoare());
					if (discount.getTipDiscount() == Discount.PROCENT)
						pretFinal = pretInitial - (pretInitial * discount.getValoare()) / 100;
					else
						pretFinal = pretInitial - discount.getValoare();
				}
			}
		}
		else
			pretFinal = pretInitial;
		return pretFinal;
	}
	@Override
	public float getPretFinalByProdus(DummyProdus produs) {
		// TODO Auto-generated method stub
		return (float)(produs.getPretVanzare() * 0.8);
	}

	

	@Override
	public PersoanaTinta salveazaPersoanaTinta(PersoanaTinta persoana)
			throws Exception {
		logger.debug(">>>>>>Start salveazaPersoanaTinta");
		PersoanaTinta result = new PersoanaTinta();
		if (persoana == null){
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaPersoanaTinta(persoana);
			logger.debug(">>>>>>End salveaza persoana Tinta");
		}
		return result;
	}
	@Override
	public Campanie salveazaCampanie(Campanie campanie)
			throws Exception {
		logger.debug(">>>>>>Start salveaza campanie");
		Campanie result = new Campanie();
		if (campanie == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaCampanie(campanie);
			logger.debug(">>>>>>End salveaza campanie");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.open.erp.services.marketing.MarketingManagementSrv#salveazaChestionar(org.open.erp.services.marketing.Chestionar)
	 */
	@Override
	public Chestionar salveazaChestionar(Chestionar chestionar)
			throws Exception {
		logger.debug(">>>>>>Start salveaza chestionar");
		Chestionar result = new Chestionar();
		if (chestionar == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaChestionar(chestionar);
			logger.debug(">>>>>>End salveaza chestionar");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.open.erp.services.marketing.MarketingManagementSrv#salveazaDiscount(org.open.erp.services.marketing.Discount)
	 */
	@Override
	public Discount salveazaDiscount(Discount discount) throws Exception {
		logger.debug(">>>>>>Start salveaza discount");
		Discount result = new Discount();
		if (discount == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaDiscount(discount);
			logger.debug(">>>>>>End salveaza discount");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.open.erp.services.marketing.MarketingManagementSrv#salveazaIntrebare(org.open.erp.services.marketing.Intrebare)
	 */
	@Override
	public Intrebare salveazaIntrebare(Intrebare intrebare) throws Exception {
		logger.debug(">>>>>>Start salveaza intrebare");
		Intrebare result = new Intrebare();
		if (intrebare == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaIntrebare(intrebare);
			logger.debug(">>>>>>End salveaza intrebare");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.open.erp.services.marketing.MarketingManagementSrv#salveazaProdusDiscount(org.open.erp.services.marketing.ProdusDiscount)
	 */
	@Override
	public ProdusDiscount salveazaProdusDiscount(ProdusDiscount produsDiscount)
			throws Exception {
		logger.debug(">>>>>>Start salveaza produs discount");
		ProdusDiscount result = new ProdusDiscount();
		if (produsDiscount == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaProdusDiscount(produsDiscount);
			logger.debug(">>>>>>End salveaza produs discount");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.open.erp.services.marketing.MarketingManagementSrv#salveazaProdusAditional(org.open.erp.services.marketing.ProduseAditionale)
	 */
	@Override
	public ProduseAditionale salveazaProdusAditional(
			ProduseAditionale produsAditional) throws Exception {
		logger.debug(">>>>>>Start salveaza produse aditionale");
		ProduseAditionale result = new ProduseAditionale();
		if (produsAditional == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaProduseAditionale(produsAditional);
			logger.debug(">>>>>>End salveaza produse aditionale");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.open.erp.services.marketing.MarketingManagementSrv#salveazaPromotie(org.open.erp.services.marketing.Promotie)
	 */
	@Override
	public Promotie salveazaPromotie(Promotie promotie) throws Exception {
		logger.debug(">>>>>>Start salveaza promotie");
		Promotie result = new Promotie();
		if (promotie == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaPromotie(promotie);
			logger.debug(">>>>>>End salveaza promotie");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.open.erp.services.marketing.MarketingManagementSrv#salveazaRaspunsChestionar(org.open.erp.services.marketing.RaspunsChestionar)
	 */
	@Override
	public RaspunsChestionar salveazaRaspunsChestionar(
			RaspunsChestionar raspunsChestionar) throws Exception {
		logger.debug(">>>>>>Start salveaza raspuns chestionar");
		RaspunsChestionar result = new RaspunsChestionar();
		if (raspunsChestionar == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaRaspunsChestionar(raspunsChestionar);
			logger.debug(">>>>>>End salveaza raspuns chestionar");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.open.erp.services.marketing.MarketingManagementSrv#salveazaRaspunsIntrebare(org.open.erp.services.marketing.RaspunsIntrebare)
	 */
	@Override
	public RaspunsIntrebare salveazaRaspunsIntrebare(
			RaspunsIntrebare raspunsIntrebare) throws Exception {
		logger.debug(">>>>>>Start salveaza raspuns intrebare");
		RaspunsIntrebare result = new RaspunsIntrebare();
		if (raspunsIntrebare == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaRaspunsIntrebare(raspunsIntrebare);
			logger.debug(">>>>>>End salveaza raspuns intrebare");
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.open.erp.services.marketing.MarketingManagementSrv#salveazaResponsabil(org.open.erp.services.marketing.Responsabil)
	 */
	@Override
	public Responsabil salveazaResponsabil(Responsabil responsabil)
			throws Exception {
		logger.debug(">>>>>>Start salveaza responsabil");
		Responsabil result = new Responsabil();
		if (responsabil == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaResponsabil(responsabil);
			logger.debug(">>>>>>End salveaza responsabil");
		}
		return result;
		
	}

	/* (non-Javadoc)
	 * @see org.open.erp.services.marketing.MarketingManagementSrv#salveazaDummyProdus(org.open.erp.services.marketing.DummyProdus)
	 */
	@Override
	public DummyProdus salveazaDummyProdus(DummyProdus produs) throws Exception {
		logger.debug(">>>>>>Start salveaza produs");
		DummyProdus result = new DummyProdus();
		if (produs == null){	
			sessionContext.setRollbackOnly();
			logger.debug(">>>>>>Tranzactie Anulata");
		}
		else{			
			result = this.registruMarketing.salveazaProdus(produs);
			logger.debug(">>>>>>End salveaza produs");
		}
		return result;
	}
	
}

package org.open.erp.services.marketing.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateful;

import org.open.erp.services.marketing.Campanie;
import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.Discount;
import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.MarketingManagementSrv;
import org.open.erp.services.marketing.MarketingManagementSrvLocal;
import org.open.erp.services.marketing.MarketingManagementSrvRemote;
import org.open.erp.services.marketing.PersoanaTinta;
import org.open.erp.services.marketing.ProdusDiscount;
import org.open.erp.services.marketing.ProduseAditionale;
import org.open.erp.services.marketing.Promotie;
import org.open.erp.services.marketing.Responsabil;
import org.open.erp.services.nomgen.Produs;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
@Stateful
public class MarketingManagementImpl implements MarketingManagementSrv, MarketingManagementSrvRemote, MarketingManagementSrvLocal {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MarketingManagementImpl.class.getName());
	
	
	/*
	 * 
	 * @ConstrutorForDummy
	 * 
	 */
	public MarketingManagementImpl() {
	}	
	
	
	// implementare actiuni serviciu ProjectManagementSrv //
	@Override
	public Campanie definireCampanie(String nume, 
			Date dataStart, Date dataSfarsit,Responsabil responsabil, List<PersoanaTinta> PersoaneTinta) {
		
		logger.debug("Creare Campanie");
		
		Campanie campanieNoua = new Campanie(1, nume, dataStart, dataSfarsit, responsabil);
		logger.debug(campanieNoua.getDenumireCampanie());
		logger.debug("Perioada in care se desfasoara campania:" + campanieNoua.getDataStart().toString() + " - " + campanieNoua.getDataSfarsit().toString());
		campanieNoua.setStatus(-1);
		campanieNoua.setPersoaneTinta(PersoaneTinta);
		
		logger.debug("Persoane avizate : " );
		for (int i=0 ; i < PersoaneTinta.size() ; i++)
		{
			logger.debug(PersoaneTinta.get(i).getNume() + " " + PersoaneTinta.get(i).getPrenume());
		}
		
		return campanieNoua;
	}
	@Override
	public void initiereCampanie(Campanie campanie) {
		campanie.setStatus(1);
		//TODO creaza metoda pentru trimiterea mail-urilor catre persoanele tinta
	}
	@Override
	public void finalizareCampanie(Campanie campanie) {
		campanie.setStatus(2);
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
			for (int j=1 ; j <= iteratorIntrebari.getRaspunsuri().size() ; j++){
				logger.debug("   "+j + ")" + iteratorIntrebari.getRaspuns(j));
			}
		}
		
		return chestionarNou;
	}
	@Override
	public void proceseazaRezultate(Chestionar chestionar) {
		// TODO creaza metoda pentru procesarea rezultatelor		
	}
	@Override
	public Promotie definirePromotie(String denumire,
			String mesajPromotional, Date dataInceput, Date dataSfarsit,
			Integer tipPromotie, List<ProdusDiscount>  produseDiscount,
			List<ProduseAditionale> listProduseAditionale) {
		Promotie  promotieNoua = new Promotie(1,denumire,mesajPromotional,dataInceput,dataSfarsit,tipPromotie);
		Produs				produs;
		Discount			discount;
		ProdusDiscount		prodDisc;
		ProduseAditionale	prodAdd;
		Iterator<ProdusDiscount>			iteratorDisc;
		Iterator<ProduseAditionale>			iteratorProdAdd;
		String				tipDiscount;
		List<Produs>		produseAditionale;
		logger.debug("Promotia " + denumire + " a fost creata.");
		if ( tipPromotie == Promotie.DISCOUNT) 
		{
			logger.debug("Tip Promotie: Discount");
			promotieNoua.setListaProduseDiscount(produseDiscount);
		}
		else
		{
			logger.debug("Tip Promotie: Produs Aditional");
			promotieNoua.setListProduseAditionale(listProduseAditionale);
		}
		logger.debug(mesajPromotional);
		logger.debug("Produse calificate");
		
		if ( tipPromotie == Promotie.DISCOUNT) 
		{
			logger.debug("Produs         Tip discount          Valoare");
			iteratorDisc = produseDiscount.iterator();
			while (iteratorDisc.hasNext())
			{
				prodDisc = (ProdusDiscount) iteratorDisc.next();
				discount = prodDisc.getDiscount();
				produs = prodDisc.getProdus();
				if (discount.getTipDiscount() == Discount.PROCENT)
					tipDiscount = "Procent";
				else
					tipDiscount = "Valoare neta";
				logger.debug(produs.getDenumire() + "      -      " + tipDiscount + "       -        " + discount.getValoare().toString());
			}
		}
		else
		{
			logger.debug("Produs         Tip discount");
			logger.debug("             Se mai primesc si produsele:");
			iteratorProdAdd = listProduseAditionale.iterator();
			while (iteratorProdAdd.hasNext())
			{
				prodAdd = (ProduseAditionale)iteratorProdAdd.next();
				produseAditionale = (List<Produs>) prodAdd.getProduseAditionale();
				produs = prodAdd.getProdus();
				for (int p = 1; p < produseAditionale.size(); p++)
				{
					
					logger.debug(produseAditionale.get(p).getId() + "       " + produseAditionale.get(p).getDenumire());
				}
			}
			
		}
		return promotieNoua;
	}
	
	@Override
	public float getPretFinalByPromotie(Produs produs, Promotie promotie,float pretInitial) {
		return promotie.getPretByPretInitial(produs, pretInitial);
	}
	@Override
	public float getPretFinalByProdus(Produs produs) {
		// TODO Auto-generated method stub
		return (float)(produs.getPretVanzare() * 0.8);
	}
}

package org.open.erp.services.banci.impl;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.open.erp.services.banci.CarduriBNC;
import org.open.erp.services.banci.BanciSrv;
import org.open.erp.services.banci.CompanieBanci;
import org.open.erp.services.banci.Cont;
import org.open.erp.services.banci.CrediteBNC;
import org.open.erp.services.banci.DepoziteBNC;
import org.open.erp.services.banci.LiniiPlati;
import org.open.erp.services.banci.SchimbValBNC;
import org.open.erp.services.nomgen.Companie;


public class BanciImpl implements BanciSrv {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BanciImpl.class.getName());
	
	@Override
	public Companie CreareFirma(Integer id, String nume){
		logger.debug("1.1 Creare firma");
		Companie comp = new Companie();
		comp.setNume(nume);
		comp.setId(id);
		comp.setTipFirma("Firma");
		return comp;
	}
	
	@Override
	public Companie CreareBanca(Integer id, String nume){
		logger.debug("1.2 Creare Banca");
		Companie comp = new Companie();
		comp.setNume(nume);
		comp.setId(id);
		comp.setTipFirma("Banca");
		return comp;
	}
	
	@Override
	public Cont CreareContLei(Integer id, String nume){
		logger.debug("1.3 Creare cont lei");
		Cont cont = new Cont();
		cont.setNume(nume);
		cont.setId(id);
		cont.setTipCont("Lei");
		return cont;
	}
	
	@Override
	public Cont CreareContValuta(Integer id, String nume){
		logger.debug("1.4 Creare cont valuta");
		Cont cont = new Cont();
		cont.setNume(nume);
		cont.setId(id);
		cont.setTipCont("Valuta");
		return cont;
	}
	
	@Override
	public SchimbValBNC creareSchimbValBNC(Companie client, Date datatranz,Integer monedacurenta,
			Double valmoncurent,Integer monedaschimb,
			Double valmondupaschimb,Integer cursval,
			Double comisionscb,List<LiniiPlati> liniePlata){
		logger.debug("1.5 Initiere/Creare schimb valutar");
		SchimbValBNC schimbnou = new SchimbValBNC(client, datatranz, monedacurenta, valmoncurent, monedaschimb, valmondupaschimb, cursval, comisionscb, liniePlata);
		return schimbnou;		
	}
	
	@Override
	public LiniiPlati CreareLinieplati(Date datacurenta, Double sumaplatita, String denumireplata){
		logger.debug("1.6 Creare linie plata");
		LiniiPlati linieplata = new LiniiPlati(datacurenta, sumaplatita, denumireplata);	
		return linieplata;
	}

	@Override
	public CompanieBanci crearerelatieCompanieBanci(Companie companie) {
		CompanieBanci relcompbanc = new CompanieBanci();
		relcompbanc.setNumeBanca(companie.getNume());
		return relcompbanc;
	}

	@Override
	public CompanieBanci adaugareBanca(CompanieBanci compbanc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanieBanci adaugareCont(CompanieBanci compbanc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarduriBNC creareCarduriBNC(Companie firma, Cont cont, Companie banca, 
			Date dataeliberarii, Date dataexpirarii, 
			Double valsoldinitial) {
		CarduriBNC card = new CarduriBNC(firma,cont,banca,dataeliberarii,dataexpirarii,valsoldinitial);
		return card;
	}
	
	public LiniiPlati creareLiniiPlati(Date datacurenta, Double sumaplatita, String denumireplata){
		return new LiniiPlati(datacurenta,sumaplatita,denumireplata);
	}

	@Override
	public Double soldcontcard(CarduriBNC card) {
		card.actualizaresoldfinal();
		return card.getvalsoldfinal();
	}

	@Override
	public CrediteBNC creareCrediteBNC(Companie firma, Cont cont,
			Companie banca, Double sumaContract, Integer perioadaContract,
			Date datacontract, Date datascadenteicontract, Date datascadenteiluna, Double sumaplataluna,
			Double ratadobanziian, LiniiPlati platiintermed) {
		CrediteBNC credit = new CrediteBNC(firma.getNume(), banca.getNume(), cont.getNume(), sumaContract, perioadaContract,
				datacontract, datascadenteicontract, datascadenteiluna, sumaplataluna,
				ratadobanziian,platiintermed);
		return credit;
	}

	@Override
	public void actualizareCredit(CrediteBNC credit) {
		credit.actualizarecredit();
	}

}

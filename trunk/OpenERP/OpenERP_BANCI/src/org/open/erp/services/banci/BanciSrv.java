package org.open.erp.services.banci;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import org.open.erp.services.nomgen.*;
 @Remote
public interface BanciSrv {
	
	public Companie CreareFirma(Integer id, String nume);
	public Companie CreareBanca(Integer id, String nume);
	public Cont CreareContLei(Integer id, String nume);
	public Cont CreareContValuta(Integer id, String nume);
	public LiniiPlati CreareLinieplati(Date datacurenta, Double sumaplatita, String denumireplata);
	public CompanieBanci crearerelatieCompanieBanci(Companie companie);
	public CompanieBanci adaugareBanca(CompanieBanci compbanc);
	public CompanieBanci adaugareCont(CompanieBanci compbanc);
	
	public CarduriBNC creareCarduriBNC(Companie firma, Cont cont, Companie banca, 
			Date dataeliberarii, Date dataexpirarii, 
			Double valsoldinitial);
	
	public CrediteBNC creareCrediteBNC(Companie firma, Cont cont,
			Companie banca, Double sumaContract, Integer perioadaContract,
			Date datacontract, Date datascadenteicontract, Date datascadenteiluna, Double sumaplataluna,
			Double ratadobanziian, LiniiPlati platiintermed);
	
	public void actualizareCredit(CrediteBNC credit);
	
	public SchimbValBNC creareSchimbValBNC(Companie client, Date datatranz,Integer monedacurenta,
			Double valmoncurent,Integer monedaschimb,
			Double valmondupaschimb,Integer cursval,
			Double comisionscb,List<LiniiPlati> liniePlata);
	public LiniiPlati creareLiniiPlati(Date datacurenta, Double sumaplatita, String denumireplata);
	public Double soldcontcard(CarduriBNC card);
	public void adaugareCont(Cont contNou);
	public void adaugaDepozit(DepoziteBNC depozitNou);
	public void creareCrediteBnc(CrediteBNC creditNou);
}

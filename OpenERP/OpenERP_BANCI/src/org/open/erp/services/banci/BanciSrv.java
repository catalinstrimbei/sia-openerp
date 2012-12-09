package org.open.erp.services.banci;

import java.util.Date;
import java.util.List;

public interface BanciSrv {
	public SchimbValBNC creareSchimbValBNC(Date datatranz,Integer monedacurenta,Double valmoncurent,Integer monedaschimb,Double valmondupaschimb,Integer cursval,Double comisionscb,List<LiniiPlati> liniePlata);
	public void creareExrasCont();
	public void creareRaportCredite();
	public void sumeRetrase(CarduriBNC card);
	
	
	/* Obtinerea unui raport cu ce depozite are o companie si la ce banci?
	 * 	Suma depusa initiala in contul ca economie
	2.	Tip cont(lei valuta)
	3.	Perioada depozit
	4.	Suma aflata in cont la momentul actual.
	5.  Cand si ce sume am depus.
	6. Cand si sume am retras.
	 
	 /* un Raport cu conturile inchise 
	  
	  nume cont
	  titular(companie)
	  data deschiderii cont 
	  data inchiderii cont
	  motiv inchidere
	  rulaj cont sa vedem ce sume s-au tranzactionat in acel cont pentru a intelege daca am pierdut un client bun inainte de inchidere.
	  */
	 
	 
	/*Obtinerea unui raport cu conturile inca deschise
	 *  nume cont
	  titular(companie)
	  data deschiderii cont 
	  rulaj cont sa vedem ce sume s-au tranzactionat in acel cont pana in prezent pt a intelege daca clientul este important sau nu.
	  */
	 */
	 
	
	/*
	1.	Obtinerea unui extras de cont pentru un cont anume la o banca cu care lucreaza o companie
	2.	Obtinerea unui raport cu ce credite unei companii si la ce banci
	1.	Suma contractata
	2.	Tip cont(lei valuta)
	3.	Perioada contractare
	4.	Suma ramasa de plata la momentul actual



	3.	Ce sume am retras dintr-un cont cu ajutorul cardului?


	•	Nume cont, 
	•	Nume banca
	•	Tip cont (lei sau valuta)
	•	Retrageri sume cu cardul (rulaje)
	o	Datele la care s-au retras sume cu cardul
	o	Sumele retrase cu cardul  
	o	Sold final cont dupa ultima retragere cu cardul
	*/

}

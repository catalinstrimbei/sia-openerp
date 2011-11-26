package org.open.erp.services.ctbgen;

import java.util.Date;
import java.util.List;


/**
 * 
 * @author Echipa9 Irimia, Iftimie, Sarbu, Ricea, Chiriac
 * 
 * @ApplicationServiceFacade(ServiceAPI):
 * 
 * @Dependente: NomGenSrv
 * 
 * @EntitatiNomGen: Material
 * 
 * @EntitatiAlteSrv: 
 * 
 * @EntitatiLocale: Cont, SablonNC, ArticolCtb,  InregistrareRJ, LunaCurenta, Balanta,
 * ListaContMatVal, PlanConturi.
 * 
 * @UseCaseL:
 * 
 * ("Jurnalizare Operatii Contabile"):
 * 1. Creaza instanta inregistrare in registru jurnal pentru vanzari
 * 2. Creaza instanta inregistrare in registru jurnal pentru achizitii
 * 3. Creaza instanta inregistrare in registru jurnal pentru incasari
 * 4. Creaza instanta inregistrare in registru jurnal pentru plati
 * 5. Creaza instanta inregistrare in registru jurnal pentru salarii
 * 6. Creaza instanta inregistrare in registru jurnal pentru consum
 * 7. Creaza instanta inregistrare in registru jurnal pentru productia obtinuta
 * 8. Returneaza status de existenta sau inchidere pentru luna operatiei
 * 9. Returneaza un cont pentru asocieri diverse
 * 10. Utilizare interna- creareCont, creareaSablon, sau inchidereLuna cu creareBalata
 *  
 *    
 */

public interface ContabilizareSrv {
	
	/**
	 * Jurnalizeaza notele contabile aferente unei vanzari si scaderea din gestiune daca e cazul
	 * 
	 * @param data 			Data documentului de inregistrat
	 * @param valFact   	Valoarea facturii de inregistrat
	 * @param nrDoc         NrDocumentului de inregistrat
	 * @param idPartener	Id partenerului aferent facturii
	 * @param listaContMat  Lista de materiale vandute, prin id si cu pretul aferent pt a scadea din gestiune
	 * @param stareInreg 	Starea aplicata documentului de inregistrat 0-New, 1-Update, 2-Delete  
	 * @param idInreg       Daca sunt operatii update/ delete id initial al inregistrarii
	 * 
	 * @return Returneaza idInregistrarii  necesar pentru update sau delete document ulterior.
	 * 
	 */
	public Integer jurnalizareVanzare(Date data, Double valFact, Integer nrDoc,Integer idPartener, List<ListaContMatVal> listaContMat, Integer stareInreg,Integer idInreg);
	
	
	
	/**
	 * Jurnalizeaza notele contabile aferente unei achizitii si intrarea in gestiune daca e cazul
	 * 
	 * @param data 			Data documentului de inregistrat
	 * @param valFact   	Valoarea facturii de inregistrat
	 * @param nrDoc         NrDocumentului de inregistrat
	 * @param idPartener	Id partenerului aferent facturii de intrare
	 * @param listaContMat  Lista de materiale cumparate, prin id si cu pretul aferent pt  intrarea in gestiune
	 * @param stareInreg 	Starea aplicata documentului de inregistrat 0-New, 1-Update, 2-Delete  
	 * @param idInreg       Daca sunt operatii update/ delete id initial al inregistrarii (null pentru new)
	 * 
	 * @return Returneaza idInregistrarii  necesar pentru update sau delete document ulterior.
	 * 
	 */
	public int jurnalizareAchizitie(Date data, Double valFact, String nrDoc,Integer idPartener,  List<ListaContMatVal> listaContMat, Integer stareInreg,Integer idInreg);
	
	
	/**
	 * Jurnalizeaza notele contabile aferente unei incasari prin casa sau banca
	 * 
	 * @param data 			Data documentului de inregistrat
	 * @param valInc    	Valoarea facturii de inregistrat
	 * @param nrDoc         NrDocumentului de inregistrat
	 * @param tipInc        0 pentru casa si 1 pentru banca
	 * @param idPartener	Id partenerului aferent incasarii de pe o factura (sau 0 daca plata e pe cont)
	 * @param idCont        idContului  daca se trece direct pe cont si nu apartine unei facturi
	 * @param stareInreg 	Starea aplicata documentului de inregistrat 0-New, 1-Update, 2-Delete  
	 * @param idInreg       Daca sunt operatii update/ delete id initial al inregistrarii(null pentru new)
	 * 
	 * @return Returneaza idInregistrarii  necesar pentru update sau delete document ulterior.
	 * 
	 */
	public int  jurnalizareIncasare(Date data, Double valInc, Integer nrDoc,Integer tipInc,Integer idPartener, Integer idCont, Integer stareInreg,Integer idInreg);
	
	
	/**
	 * Jurnalizeaza notele contabile aferente unei plati prin casa sau banca
	 * 
	 * @param data 			Data documentului de inregistrat
	 * @param valPlata    	Valoarea facturii de inregistrat
	 * @param nrDoc         NrDocumentului de inregistrat
	 * @param tipPlata      0 pentru casa si 1 pentru banca
	 * @param idPartener	Id partenerului aferent incasarii de pe o factura (sau 0 daca plata e pe cont)
	 * @param idCont        idContului  daca se trece direct pe cont si nu apartine unei facturi
	 * @param stareInreg 	Starea aplicata documentului de inregistrat 0-New, 1-Update, 2-Delete  
	 * @param idInreg       Daca sunt operatii update/ delete id initial al inregistrarii(null pentru new)
	 * 
	 * @return Returneaza idInregistrarii  necesar pentru update sau delete document ulterior.
	 * 
	 */
	public int jurnalizarePlata(Date data, Double valInc, Integer nrDoc,Integer tipPlata,Integer idPartener, Integer idCont, Integer stareInreg,Integer idInreg);
	
	
	/**
	 * Jurnalizeaza notele contabile aferente unei plati prin casa sau banca
	 * 
	 * @param data 			Data documentului de inregistrat
	 * @param valBrut    	Valoarea salarii brute
	 * @param sanatAng      Valoare contributii sanatate angajati
	 * @param somajAng      Valoare contributii somaj angajati
	 * @param casAng	    Valoare contributii CAS angajati
	 * @param impAng        Impozit pe salarii
     * @param sanatFirma    Valoare contributii sanatate Firma
	 * @param somajFirma    Valoare contributii somaj Firma
	 * @param casFirma	    Valoare contributii CAS Firma
	 * @param medicFirma    Valoare contributii concedii medicale Firma
	 * @param riscFirma 	Valoare contributii fond risc Firma
	 * @param stareInreg 	Starea aplicata documentului de inregistrat 0-New, 1-Update, 2-Delete 
	 * @param idInreg       Daca sunt operatii update/ delete id initial al inregistrarii(null pentru new)
	 * 
	 * @return Returneaza idInregistrarii  necesar pentru update sau delete document ulterior.
	 * 
	 */
	public int jurnalizareSalarii(Date data, Double valBrut,Double sanatAng, Double somajAng,Double casAng, Double impAng ,Double sanatFirma,
			Double somajFirma, Double casFirma, Double medicFirma,Double riscFirma,Integer stareInreg,Integer idInreg);
	
	/**
	 * Jurnalizeaza notele contabile aferente unui Bon de Consum
	 * 
	 * @param data 			Data documentului de inregistrat
	 * @param nrDoc         NrDocumentului de inregistrat
	 * @param listaContMat  Lista de materiale consumate, prin id si cu valoarea aferenta pt  iesirea in gestiune
	 * @param stareInreg 	Starea aplicata documentului de inregistrat 0-New, 1-Update, 2-Delete  
	 * @param idInreg       Daca sunt operatii update/ delete id initial al inregistrarii (null pentru new)
	 * 
	 * @return Returneaza idInregistrarii  necesar pentru update sau delete document ulterior.
	 * 
	 */
	
	public int jurnalizareConsum(Date data, Integer nrDoc, List<ListaContMatVal> listaContMat, Integer stareInreg,Integer idInreg);
	
	
	/**
	 * Jurnalizeaza notele contabile aferente unui Note de Productie
	 * 
	 * @param data 			Data documentului de inregistrat
	 * @param nrDoc         NrDocumentului de inregistrat
	 * @param listaContMat  Lista de materiale produse, prin id si cu valoarea aferenta pt  stocul produs
	 * @param stareInreg 	Starea aplicata documentului de inregistrat 0-New, 1-Update, 2-Delete  
	 * @param idInreg       Daca sunt operatii update/ delete id initial al inregistrarii (null pentru new)
	 * 
	 * @return Returneaza   idInregistrarii  necesar pentru update sau delete document ulterior.
	 * 
	 */
	public int  jurnalizareProductie(Date data, Integer nrDoc, List<ListaContMatVal> listaContMat, Integer stareInreg,Integer idInreg);
	
	
	void jurnalizareNcDiversa();
	
	Integer verificaLunaInchisa(Date data);
	Integer getidLunaDoc(Date data);
	
	PlanConturi getPlanConturi();
	
	int getIdCont(Cont cont);
	boolean getContDisponibil(Cont cont);
	Cont  crearePlanCont();
	
	SablonNC creareSablonNC();
	
	void inchideLuna();
	void anuleazaInchidere();
	
	
	
	

}

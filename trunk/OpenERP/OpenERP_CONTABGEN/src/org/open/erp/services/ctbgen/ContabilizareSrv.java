package org.open.erp.services.ctbgen;

import java.util.Date; 
import java.util.List;

import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.LinieDocument;


/**
 * 
 * @author Echipa ContabGEN: Irimia, Iftimie, Sarbu, Ricea, Chiriac
 * 
 * @ApplicationServiceFacade(ServiceAPI):
 * 
 * @Dependente: NomGenSrv
 * 
 * @EntitatiNomGen: Material, Document
 * 
 * @EntitatiAlteSrv: 
 * 
 * @EntitatiLocale: Cont, SablonNC, ArticolCtb,  InregistrareRJ, LunaCurenta, Balanta,
 * ListaContMatVal, FisaCont, RegPlanConturi,RegLuniLucru, RegTipuriContabile, RegInregistrariRJ, 
 * RegSablonNC, RegBalanta .
 * 
 * @UseCase: ("Jurnalizare Operatii Contabile"):
 * <p>1. Creaza instanta inregistrare in registru jurnal pentru vanzari
 * 2. Creaza instanta inregistrare in registru jurnal pentru achizitii
 * 3. Creaza instanta inregistrare in registru jurnal pentru incasari
 * 4. Creaza instanta inregistrare in registru jurnal pentru plati
 * 5. Creaza instanta inregistrare in registru jurnal pentru salarii
 * 6. Creaza instanta inregistrare in registru jurnal pentru consum
 * 7. Creaza instanta inregistrare in registru jurnal pentru productia obtinuta
 * 8. Returneaza status de existenta sau inchidere pentru luna operatiei
 * 9. Returneaza un cont pentru asocieri diverse
 * 10. Utilizare interna- creareCont, creareaSablon, sau inchidereLuna cu creareBalanta</p>
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
	public Integer jurnalizareVanzare(Date data, Double valFact,Double tvaFact, Integer nrDoc,Integer idPartener, List<LinieDocument> listaContMat, 
			StareDocument stareDocument,Integer idInreg) throws CtbException;
	
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
	public Integer jurnalizareAchizitie(Date data, Double valFact,Double tvaFact, Integer nrDoc,Integer idPartener,  List<LinieDocument> listaContMat, 
			StareDocument stareDocument,Integer idInreg) throws CtbException;
	
	
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
	public Integer  jurnalizareIncasare(Date data, Double valInc, Integer nrDoc, TipIncasare tipIncasare,Integer idPartener, String simbolCont, 
			StareDocument stareDocument,Integer idInreg) throws CtbException;
	
	
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
	public Integer jurnalizarePlata(Date data, Double valInc, Integer nrDoc, TipPlata tipPlata,Integer idPartener, String simbolCont, 
			StareDocument stareDocument, Integer idInreg) throws CtbException;
	
	
	/**
	 * Jurnalizeaza notele contabile aferente unui stat de plata
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
	public Integer jurnalizareSalarii(Date data,Integer nrDoc, Double valBrut,Double sanatAng, Double somajAng,Double casAng, Double impAng ,Double sanatFirma,
			Double somajFirma, Double casFirma, Double medicFirma,Double riscFirma,StareDocument stareDocument,Integer idInreg) throws CtbException;
	
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
	
	public Integer jurnalizareConsum(Date data, Integer nrDoc, List<LinieDocument> listaContMat, StareDocument stareDocument,
			Integer idInreg) throws CtbException;
	
	
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
	public Integer jurnalizareProductie(Date data, Integer nrDoc, List<LinieDocument> listaContMat, 
			StareDocument stareDocument,Integer idInreg) throws CtbException;
	
	/**
	 * Jurnalizeaza notele contabile diverse
	 */
	
	void jurnalizareNcDiversa( Date data, Integer nrInreg, Cont contd, Cont contc, Double suma,StareDocument stareDocument, Integer idInreg)throws CtbException;
	
	//---------------------------------
	
	/**
	 * Metode pentru celelalte departamente, pentru aflarea unei valori
	 *  sau obtinerea de registri de valori
	 *  
	 */
	public String verificaLunaInchisa(Date data);
	public boolean getContDisponibil(Cont cont);
	
	public RegConturi getRegConturi();
	public RegLuniLucru getRegLuniLucru();
	public List<String> getTipuriContabile();
	//---------------------------------
	
	/**
	 * Metode necesare domeniului modulului
	 *  
	 */
	
	public Cont  crearePlanCont(String denCont, String simbolCont, String clasaCont, StatusSintetic tipSintetic,  Cont contParinte, TipCont tipCont);
	public SablonNC creareSablonNC(Integer nrSablon, Cont contDebit, Cont contCredit);
	public RegSablonNC getRegSablonNC();
	public LinieMaterialValoare creareLinieMaterialValoare(TipContabil tipMaterial, Double valoare);
	public TipContabil creareTipMaterial(Integer idTip, String denumireTip, Cont contProprietar, Cont contIntrare, Cont contIesire);
	
	public void inchideLuna(LunaLucru luna) throws CtbException ;
	public void anuleazaInchidere(LunaLucru luna);
	public Cont getContDupaSimbol(String simbol);
	public LunaLucru getOrCreateLuna(Date data);
	public List<FisaCont> creazaFisaCont(Cont cont);
	public List<FisaCont> creazaFisaContPartener (Cont cont, Integer idPart);
	
	Integer getidLunaDoc(Date data);
	RegConturi getPlanConturi();
	int getIdCont(Cont cont);
	public RegInregistrareRJ getRegInregistrari();
	public InregistrareRJ salvareInreg(InregistrareRJ inreg);
	public List<ArticolCtb> getListArt(Integer idInreg);
	public List<InregistrareRJ>	getListaInreg();
	public Cont salveazaCont(Cont cont);
	public void stergeCont(Cont cont);

	public RegTipuriContabile getRegTipuriContabile();
	
	
		
	
}

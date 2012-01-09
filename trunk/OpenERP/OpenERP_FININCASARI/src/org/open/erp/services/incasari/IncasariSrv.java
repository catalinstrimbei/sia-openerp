package org.open.erp.services.incasari;


import java.util.Date;

/**
 * @author Echipa FININCASARI (Croitoru Catalina, Dascalu Alexandru, Marcu Anca, Maierean Adela, Saftencu Eugenia, Zaharia Corina)
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: VanzariSrv, PersonalSrv, ContabilizareSrv
 * 
 * @EntitatiLocale: BiletLaOrdin, Cec, Chitanta, ExtrasCont, Incasare
 * 
 * @UseCase:
 * 1. Incasare prin numerar
 * 2. Incasare prin bilet la ordin/cec
 * 3. Incasare prin cont bancar(tranfer bancar)
 * 4. Inregistrare chitanta/depunere la banca/cec/bilet la ordin
 * 5. Confirmare imposibilitate plata
 * 6. Incasarea platii partiale (rest incasare factura)
 * 7. Compensari incasari facturi
 */

import java.util.List;

import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.incasari.exception.IncasariException;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaEmisa;

public interface IncasariSrv {
	/** Scop Inregistreaza platile efectuate 
	 * 
	 * @param doc Documentul pe baza caruia se efectueaza plata
	 * @throws IncasariException
	 * @throws NumberFormatException
	 * @throws CtbException
	 */

	void confirmareIncasare(Incasare doc) throws IncasariException,
			NumberFormatException, CtbException;
/**
 *  Jurnalizeaza notele contabile aferente efectuarii unei plati
 *  
 * @param doc Documentul pe baza caruia se efectueaza plata
 * @throws IncasariException
 * @throws NumberFormatException
 * @throws CtbException
 */
 
	void confirmareDepunereLaBanca(Incasare doc);
	/**
	 *  Jurnalizarea depunerii cec-ului sau biletului la ordin
	 *  
	 *  @param doc Documentul pe baza caruia se efectueaza plata
	 *   
	 */
	  

	

	Double getSumaRON(String moneda, Double suma, Double curs);
	/**
	 *  Calculeaza suma in functie de moneda in care se efectueaza plata
	 * @param moneda      Moneda in care se efectueaza plata
	 * @param suma        Suma incasata
	 * @param curs        Cursul valutar curent
	 * @return            Returneaza suma convertita in moneda specificata
	 */

	
	Double restIncasareFactura(FacturaEmisa factura);
	/**Calculeaza diferenta dintre suma totala a facturii si suma incasata
	 * 
	 * @param factura       Factura pe baza careia se efectueaza plata
	 * @return              Returneaza restul de plata de pe o factura data
	 */

	Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
			String sumaIncasataLitere, Boolean avans,
			List<FacturaEmisa> facturi, Date dataEmiterii, String seria,
			Integer numar, String locatie, String moneda, Client client,
			Double curs) throws IncasariException, CtbException;
	/**
	 * Se efectueaza inregistrarea platii in contabilitate pe baza chitantei
	 * 
	 * @param casier                 Angajatul care efectueaza incasarea platii
	 * @param sumaIncasata           Suma incasata in cifre
	 * @param sumaIncasataLitere     Suma incasata in litere
	 * @param avans                  Se specifica daca plata se realizeaza in avans 
	 * @param facturi                Factura pe baza careia se efectueaza plata
	 * @param dataEmiterii           Data emiterii chitantei
	 * @param seria                  Seria chitantei
	 * @param numar                  Numarul de inregistrare al chitantei
	 * @param locatie                Filiala in care se efectueaza plata
	 * @param moneda                 Moneda in care se incaseaza suma de plata
	 * @param client                 Id-ul de inregistrare al clientului 
	 * @param curs                   Cursul valutar curent
	 * @return                       Inregistrarea in contabilitatea a unei noi chitante
	 * @throws IncasariException
	 * @throws CtbException
	 */


	Cec inregistrareCec(Date dataEmiterii, Boolean avans, Client client,
			String seria, Integer numar, String locatie, String stare,
			Double suma, String sumaInLitere, List<FacturaEmisa> facturi,
			String moneda, Double curs) throws IncasariException;
/**
 * Se efectueaza inregistrarea platii in contabilitate pe baza unui cec
	 * 
 * @param dataEmiterii         Data emiterii cec-ului
 * @param avans                Se specifica daca plata se realizeaza in avans
 * @param client               Id-ul de inregistrare al clientului 
 * @param seria                Seria cec-ului
 * @param numar                Numarul de inregistrare al cec-ului
 * @param locatie              Filiala in care se efectueaza plata
 * @param stare                Starea curenta a cec-ului
 * @param facturi              Factura pe baza careia se efectueaza plata
 * @param dataScadenta         Data in care expira cec-ul
 * @param suma                 Suma incasata in cifre
 * @param sumaInLitere         Suma incasata in litere
 * @param moneda               Moneda in care se incaseaza suma de plata
 * @param curs                 Cursul valutar curent
 * @return                     Inregistrarea in contabilitatea a unei noi plati prin intremediul unui cec
 * @throws IncasariException
	 */
 
 
	BiletLaOrdin inregistrareBiletLaOrdin(Date dataEmiterii, Boolean avans,
			Client client, String seria, Integer numar, String locatie,
			String stare, List<FacturaEmisa> facturi, Persoana garant,
			Date dataScadenta, Double suma, String sumaInLitere, String moneda,
			Double curs) throws IncasariException;
/**
 * Se efectueaza inregistrarea platii in contabilitate pe baza unui bilet la ordin
 * 
 * @param dataEmiterii         Data emiterii biletului la ordin
 * @param avans                Se specifica daca plata se realizeaza in avans
 * @param client               Id-ul de inregistrare al clientului 
 * @param seria                Seria biletului la ordin
 * @param numar                Numarul de inregistrare al biletului la ordin
 * @param locatie              Filiala in care se efectueaza plata
 * @param stare                Starea curenta a biletului la ordin
 * @param facturi              Factura pe baza careia se efectueaza plata
 * @param garant               Persoana 
 * @param dataScadenta         Data in care expira biletul la ordine
 * @param suma                 Suma incasata in cifre
 * @param sumaInLitere         Suma incasata in litere
 * @param moneda               Moneda in care se incaseaza suma de plata
 * @param curs                 Cursul valutar curent
 * @return                     Inregistrarea in contabilitatea a unei noi plati prin intremediul unui bilet la ordin
 * @throws IncasariException
 */
	

	void confirmareImposibilitatePlata(Incasare doc);

	/**
	 *  Se verifica daca starea cec-ului sau biletului la ordin este "refuzat"
	 *  
	 *  @param doc Documentul pe baza caruia se efectueaza plata
	 *   
	 */

	ExtrasCont inregistrareExtrasCont(Date dataEmiterii, Boolean avans,
			Client client, String seria, Integer numar, String locatie,
			List<FacturaEmisa> facturi, Double suma, String sumaInLitere,
			String moneda, Double curs) throws IncasariException;
}

/**
 * Se efectueaza inregistrarea platii in contabilitate pe baza unui extras de cont
	 * 
 * @param dataEmiterii         Data emiterii extrasului de cont
 * @param avans                Se specifica daca plata se realizeaza in avans
 * @param client               Id-ul de inregistrare al clientului 
 * @param seria                Seria extrasului de cont
 * @param numar                Numarul de inregistrare al extrasului de cont
 * @param locatie              Filiala in care se efectueaza plata
 * @param stare                Starea curenta a extrasului de cont
 * @param facturi              Factura pe baza careia se efectueaza plata
 * @param dataScadenta         Data in care expira extrasul de cont
 * @param suma                 Suma incasata in cifre
 * @param sumaInLitere         Suma incasata in litere
 * @param moneda               Moneda in care se incaseaza suma de plata
 * @param curs                 Cursul valutar curent
 * @return                     Inregistrarea in contabilitatea a unei noi plati prin intremediul unui extras de cont
 * @throws IncasariException
	 */
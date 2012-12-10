package org.open.erp.services.finincasari;

import java.util.ArrayList;
import java.util.Date;

import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Facturi;
//import org.open.erp.services.vanzari.VanzariSrv;

/**
 * @author Isabela
 *
 */

public interface FinanciarIncasariSrv {

double getSuma (String moneda, Double suma, Double cursValutar);

double restIncasareFacturi(Facturi Facturi);
	//inregistrarea incasarii pe  baza  Bilet la Ordine


BiletOrdine incasareBO(String localitate, Date dataEmiterii, Double valueOf,
		String moneda, String sumaLitere,
		ArrayList<org.open.erp.services.vanzari.Facturi> facturi,
		Angajat angajat, Persoana persoana) throws Exception;

CEC incasareCec(String string, Date dataEmiterii, double d, String string2,
		String string3, Object object) throws Exception;

OrdinDePlata incasareOP(String string, Date dataEmiterii, double d,
		String string2, String string3, int i, String string4,
		ArrayList<org.open.erp.services.vanzari.Facturi> facturi) throws Exception;

Chitanta inregistrareCt(String string, Date dataEmiterii, double d,
		String string2, String string3,
		ArrayList<org.open.erp.services.vanzari.Facturi> facturi,
		Angajat angajat) throws Exception;

ExtrasDeCont incasareEC(String string, Date dataEmiterii, double d,
		String string2, String string3,
		ArrayList<org.open.erp.services.vanzari.Facturi> facturi) throws Exception;




/*
CEC incasareCec(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar) throws Exception;


Chitanta inregistrareCt (String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, ArrayList<Facturi>Facturi,Angajat angajat) throws Exception;	

ExtrasDeCont incasareEC(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, ArrayList<Facturi>Facturi) throws Exception;

OrdinDePlata incasareOP(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, Integer numarOrdinPlata, String cF,ArrayList<Facturi>Facturi) throws Exception;

void setVanzariSrv(VanzariSrv vanzariSrv);
*/

	
 
}
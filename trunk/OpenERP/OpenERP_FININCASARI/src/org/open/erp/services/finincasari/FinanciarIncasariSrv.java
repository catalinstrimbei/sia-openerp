package org.open.erp.services.finincasari;

import java.util.ArrayList;
import java.util.Date;

import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Factura;
import org.open.erp.services.vanzari.VanzariSrv;

/**
 * @author Isabela
 *
 */

public interface FinanciarIncasariSrv {

double getSuma (String moneda, Double suma, Double cursValutar);

double restIncasareFactura(Factura factura);
	//inregistrarea incasarii pe  baza  Bilet la Ordine

//BiletOrdine incasareBO (String localitate, Date dataEmiterii, Double suma,
	//	String moneda, String sumaLitere, String contBancar) throws Exception;


CEC incasareCec(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar,ArrayList<Factura>factura) throws Exception;


Chitanta inregistrareCt (String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar, ArrayList<Factura>factura,Angajat angajat) throws Exception;	

ExtrasDeCont incasareEC(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar,ArrayList<Factura>factura) throws Exception;

OrdinDePlata incasareOP(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar,
			Integer numarOrdinPlata, String cF,ArrayList<Factura>factura) throws Exception;

void setVanzariSrv(VanzariSrv vanzariSrv);


BiletOrdine incasareBO(String localitate, Date dataEmiterii, Double suma,
		String moneda, String sumaLitere, String contBancar, ArrayList<Factura> factura, Angajat angajat, Persoana persoana) throws Exception;


	
 
}
package org.open.erp.services.finincasari.impl;

import java.util.ArrayList;
import java.util.Date;


import org.apache.log4j.Logger;
import org.open.erp.services.finincasari.BiletOrdine;
import org.open.erp.services.finincasari.CEC;
import org.open.erp.services.finincasari.Chitanta;
import org.open.erp.services.finincasari.ExtrasDeCont;
import org.open.erp.services.finincasari.FinanciarIncasariSrv;
import org.open.erp.services.finincasari.OrdinDePlata;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Factura;
import org.open.erp.services.vanzari.VanzariSrv;


public  class FinanciarIncasariImpl implements FinanciarIncasariSrv {
	
	
	@SuppressWarnings("unused")
	private FinanciarIncasariSrv financiarIncasariSrv;


	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FinanciarIncasariImpl.class.getName());
	

	public void setFinanciarIncasariSrv(FinanciarIncasariSrv financiarIncasariSrv) {
		this.financiarIncasariSrv = financiarIncasariSrv;
	}
	
	@Override
	public double getSuma(String moneda, Double suma, Double cursValutar) {
		// TODO Auto-generated method stub
		if (moneda.equals("EURO")) {
			suma =  (suma * cursValutar);
		}
		return suma;
	}

	@Override
	public double restIncasareFactura(Factura factura) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BiletOrdine incasareBO(String localitate, Date dataEmiterii,
			Double suma, String moneda, String sumaLitere, String contBancar,  ArrayList<Factura>factura, Angajat angajat, Persoana persoana)
			throws Exception {
		// TODO Auto-generated method stub
		logger.debug("1.Incasare prin Bilet la Ordine");
		
		if (suma ==0.00) {
			throw new Exception("Suma nu poate fi nula");
		}
		
		if (!moneda.equals("RON")) {
			Double cursValutar = 4.23;
			suma = getSuma(moneda, suma,cursValutar);
		}
		
		BiletOrdine BO = new BiletOrdine(localitate, dataEmiterii,suma,  moneda, sumaLitere,  contBancar, null, null);
		return BO;
		
	}

	
	@Override
	public CEC incasareCec(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar,
			ArrayList<Factura> factura) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("2.Incasare prin CEC");
		
		if( suma == 0.00){
			throw new Exception("Suma nu poate fi nula");
		}
		if (!moneda.equals("RON")) {
			Double cursValutar = 4.23;
			suma = getSuma(moneda, suma,cursValutar);
		}
		
	
		CEC Cec = new CEC(localitate,dataEmiterii,suma,moneda,sumaLitere,contBancar);
	
		return Cec;
	}

	@Override
	public ExtrasDeCont incasareEC(String localitate, Date dataEmiterii,
			Double suma, String moneda, String sumaLitere, String contBancar,
			ArrayList<Factura> factura) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("3.Incasare prin extras de cont");
		
		if (suma ==0.00) {
			throw new Exception("Suma nu poate fi nula");
		}
		if (!moneda.equals("RON")) {
			Double cursValutar = 4.23;
			suma = getSuma(moneda, suma,cursValutar);
		}
		
		ExtrasDeCont EC = new ExtrasDeCont(localitate,dataEmiterii,suma,moneda,sumaLitere,contBancar);
		return EC;
	}

	@Override
	public OrdinDePlata incasareOP(String localitate, Date dataEmiterii,
			Double suma, String moneda, String sumaLitere, String contBancar,
			Integer numarOrdinPlata, String cF, ArrayList<Factura> factura) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("4.Incasare prin Ordin De Plata");
		if (suma ==0.00) {
			throw new Exception("Suma nu poate fi nula");
		}
		if (!moneda.equals("RON")) {
			Double cursValutar = 4.23;
			suma = getSuma(moneda, suma,cursValutar);
		}
		OrdinDePlata OP = new OrdinDePlata(localitate,dataEmiterii,suma,moneda,sumaLitere,contBancar);
		return OP;
	}
	@Override
	public Chitanta inregistrareCt(String localitate, Date dataEmiterii,
			Double suma, String moneda, String sumaLitere, String contBancar,
			ArrayList<Factura> factura, Angajat angajat) throws Exception {
		
		// TODO Auto-generated method stub
		
		logger.debug("5.Inregistrare chitanta pentru suma incasata");
		if (suma ==0.00) {
			throw new Exception("Suma nu poate fi nula");
		}
		if (!moneda.equals("RON")) {
			Double cursValutar = 4.23;
			suma = getSuma(moneda, suma,cursValutar);
		}

		Chitanta ct = new Chitanta(localitate,dataEmiterii,suma,moneda,sumaLitere,contBancar,angajat);
		return ct;
	
	}

	@Override
	public void setVanzariSrv(VanzariSrv vanzariSrv) {
		// TODO Auto-generated method stub
		
	}



	
	

}
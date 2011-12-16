package org.open.erp.services.plati.impl;

import java.util.Date;
import java.util.List;

import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.incasari.Chitanta;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.plati.CEC;
import org.open.erp.services.plati.ExtrasCont;
import org.open.erp.services.plati.FacturaPrimita;
import org.open.erp.services.plati.FinPlatiSrv;
import org.open.erp.services.plati.OrdinPlata;
import org.open.erp.services.plati.Plata;
import org.open.erp.services.plati.exceptions.PlatiExceptions;


public class FinPlatiImpl implements FinPlatiSrv {

	@Override
	public void confirmarePlata(Plata doc) throws PlatiExceptions,
			NumberFormatException, CtbException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmareDepunereLaBanca(Plata doc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getSumaRON(String moneda, Double suma, Double curs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double restPlataFactura(FacturaPrimita factura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
			Boolean avans, List<FacturaPrimita> facturi, Date dataEmiterii,
			String seria, Integer numar, String locatie, String moneda,
			Furnizor furnizor, Double curs) throws PlatiExceptions,
			CtbException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CEC inregistrareCEC(Date dataEmiterii, Boolean avans,
			Furnizor furnizor, String seria, Integer numar, String locatie,
			String stare, Double suma, List<FacturaPrimita> facturi,
			String moneda, Double curs) throws PlatiExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdinPlata inregistrareOrdinPlata(Date dataEmiterii, Boolean avans,
			Furnizor furnizor, String seria, Integer numar, String locatie,
			String stare, Double suma, List<FacturaPrimita> facturi,
			String moneda, Double curs) throws PlatiExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtrasCont inregistrareExtrasCont(Date dataEmiterii, Boolean avans,
			Furnizor furnizor, String seria, Integer numar, String locatie,
			List<FacturaPrimita> facturi, Double suma, String moneda,
			Double curs) throws PlatiExceptions {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package org.open.erp.services.plati;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.plati.OrdinPlata;
import org.open.erp.services.plati.CEC;
import org.open.erp.services.plati.Chitanta;
import org.open.erp.services.plati.ExtrasCont;
import org.open.erp.services.plati.Plata;
import org.open.erp.services.plati.exceptions.PlatiExceptions;
import org.open.erp.services.plati.FacturaPrimita;
import org.open.erp.services.personal.Angajat;

public interface FinPlatiSrv {
	
	void confirmarePlata(Plata doc) throws PlatiExceptions,
	NumberFormatException, CtbException;

	void confirmareDepunereLaBanca(Plata doc);

	Double getSumaRON(String moneda, Double suma, Double curs);

	Double restPlataFactura(FacturaPrimita factura);

	Chitanta inregistrareChitanta(Angajat casier, Double sumaIncasata,
	Boolean avans,
	List<FacturaPrimita> facturi, Date dataEmiterii, String seria,
	Integer numar, String locatie, String moneda, DummyFurnizor furnizor,
	Double curs) throws PlatiExceptions, CtbException;

	CEC inregistrareCEC(Integer idPlata, Date dataEmiterii, Boolean avans, DummyFurnizor furnizor,
	String seria, Integer numar, String locatie, String stare,
	Double suma, List<FacturaPrimita> facturi,
	String moneda, Double curs) throws PlatiExceptions;

	OrdinPlata inregistrareOrdinPlata(Integer idPlata, Date dataEmiterii, Boolean avans, DummyFurnizor furnizor,
			String seria, Integer numar, String locatie, String stare,
			Double suma, List<FacturaPrimita> facturi,
			String moneda, Double curs) throws PlatiExceptions;

	ExtrasCont inregistrareExtrasCont(Integer idPlata, Date dataEmiterii, Boolean avans,
			DummyFurnizor furnizor, String seria, Integer numar, String locatie,
	List<FacturaPrimita> facturi, Double suma,
	String moneda, Double curs) throws PlatiExceptions;

	ArrayList<FacturaPrimita> getFacturiFurnizor(DummyFurnizor furnizor);
	
	public List<FacturaPrimita> compensariParteneri(
			List<FacturaPrimita> facturi, Double suma) throws PlatiExceptions;
	
	public int acceptaPlataFurnizor(Partener partener,Double valoare, Date data);

	List<DummyFurnizor> getfurnizor();
		
}

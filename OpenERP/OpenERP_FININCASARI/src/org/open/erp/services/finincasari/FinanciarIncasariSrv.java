package org.open.erp.services.finincasari;


import java.util.List;
import java.util.Date;
import org.open.erp.services.vanzari.FacturaEmisa;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.contagen.exception.ContaException;
import org.open.erp.services.finincasari.exception.FinanciarIncasariException;

import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Client;

public interface FinanciarIncasariSrv {

	void confirmareIncasare(FinIncasari doc) throws FinanciarIncasariException, NumberFormatException, ContaException;
	
	void confirmareDepunereLaBanca(FinIncasari doc);
	
	Double getSumaRON (String moneda, Double suma, Double cursValutar);
	
	Double restIncasareFact (FacturaEmisa factura);
	

	

	void confiramreImposibilitateplata (FinIncasari doc);
	

	Chitanta inregistrareChitanta(Angajat casier, Double valueOf,
			String string, boolean b, List<FacturaEmisa> facturi,
			Date dataEmitere, String string2, int i, String string3,
			String string4, Client client, Object object);


	
	ExtrasCont inregistrareExtrasCont(Date dataEmitere, Boolean avans,
			Client client, String seria, Integer numar, String locatie,
			List<FacturaEmisa> facturi, Double suma, String sumaInLitere,
			String moneda, Double curs) throws FinanciarIncasariException;

	CEC inregistrareCEC(Date dataEmitere, boolean b, Client client,
			String string, int i, String string2, String string3,
			Double valueOf, String string4, List<FacturaEmisa> facturi,
			String string5, Object object);

	BiletLaOrdine inregistrareBiletLaOrdine(Date dataEmitere, boolean b,
			Client client, String string, int i, String string2,
			String string3, List<FacturaEmisa> facturi, Persoana garant,
			Date dataScadenta, Double valueOf, String string4, String string5,
			Object object);

	void setContabilitateGeneralaSrv(Object contabilitateGeneralaSrv);

	void setVanzariSrv(VanzariSrv vanzariSrv);

	


	
	
	
 
}
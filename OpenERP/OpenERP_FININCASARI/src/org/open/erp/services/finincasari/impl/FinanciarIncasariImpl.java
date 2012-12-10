package org.open.erp.services.finincasari.impl;

import java.util.ArrayList;
import java.util.Date;



import org.open.erp.services.finincasari.TipIncasare;
import org.open.erp.services.finincasari.BiletOrdine;
import org.open.erp.services.finincasari.CEC;
import org.open.erp.services.finincasari.Chitanta;
import org.open.erp.services.finincasari.ExtrasDeCont;
import org.open.erp.services.finincasari.FinanciarIncasariSrv;
import org.open.erp.services.finincasari.OrdinDePlata;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Facturi;
//import org.open.erp.services.vanzari.VanzariSrv;


/**
 * @author Isabela
 *
 */
public  class FinanciarIncasariImpl implements FinanciarIncasariSrv {
	
	



	@SuppressWarnings("unused")
	private FinanciarIncasariSrv financiarIncasariSrv;


	private boolean avans;

	
	@SuppressWarnings("unused")
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
	public double restIncasareFacturi(Facturi Facturi) {
		// TODO Auto-generated method stub
		return 0;
	}

	public BiletOrdine incasareBO(String localitate, Date dataEmiterii,
			Double suma, String moneda, String sumaLitere,  ArrayList<Facturi>Facturi, Angajat angajat, Persoana persoana)
			throws Exception {
		// TODO Auto-generated method stub
		;
		
		if (suma ==0.00) {
			throw new Exception("Suma nu poate fi nula");
		}
		
		if (!moneda.equals("RON")) {
			Double cursValutar = 4.23;
			suma = getSuma(moneda, suma,cursValutar);
		}
		
		BiletOrdine BO = new BiletOrdine(localitate, dataEmiterii,suma,  moneda,  sumaLitere, angajat, persoana);
		return BO;
		
	}

	
	public CEC incasareCec(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, 
			ArrayList<Facturi> Facturi) throws Exception {
		// TODO Auto-generated method stub
	
		
		if( suma == 0.00){
			throw new Exception("Suma nu poate fi nula");
		}
		if (!moneda.equals("RON")) {
			Double cursValutar = 4.23;
			suma = getSuma(moneda, suma,cursValutar);
		}
		
	
		CEC Cec = new CEC(localitate,dataEmiterii,suma,moneda,sumaLitere);
	
		return Cec;
	}

	public ExtrasDeCont incasareEC(String localitate, Date dataEmiterii,
			Double suma, String moneda, String sumaLitere, 
			ArrayList<Facturi> Facturi) throws Exception {
		// TODO Auto-generated method stub
		
		if (suma ==0.00) {
			throw new Exception("Suma nu poate fi nula");
		}
		if (!moneda.equals("RON")) {
			Double cursValutar = 4.23;
			suma = getSuma(moneda, suma,cursValutar);
		}
		
		ExtrasDeCont EC = new ExtrasDeCont(localitate,dataEmiterii,suma,moneda,sumaLitere);
		return EC;
	}

	public OrdinDePlata incasareOP(String localitate, Date dataEmiterii,
			Double suma, String moneda, String sumaLitere, 
			Integer numarOrdinPlata, String cF, ArrayList<Facturi> Facturi) throws Exception {
		// TODO Auto-generated method stub
		
		if (suma ==0.00) {
			throw new Exception("Suma nu poate fi nula");
		}
		if (!moneda.equals("RON")) {
			Double cursValutar = 4.23;
			suma = getSuma(moneda, suma,cursValutar);
		}
		OrdinDePlata OP = new OrdinDePlata(localitate,dataEmiterii,suma,moneda,sumaLitere);
		return OP;
	}
	
	@SuppressWarnings("unused")
	public Chitanta inregistrareCt(String localitate, Date dataEmiterii,
			Double suma, String moneda, String sumaLitere, 
			ArrayList<Facturi> Facturi, Angajat angajat) throws Exception {
		
		// TODO Auto-generated method stub

		
		
		if (suma ==0.00) {
			throw new Exception("Suma nu poate fi nula");
		}
		if (!moneda.equals("RON")) {
			Double cursValutar = 4.23;
			suma = getSuma(moneda, suma,cursValutar);
		}
		Chitanta ct = new Chitanta(localitate,dataEmiterii,suma,moneda,sumaLitere,angajat);
		
		
				Boolean tipIncasare = TipIncasare.casa;
				try {
					if (avans) {
						tipIncasare = TipIncasare.avans;
					}
					

				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}

		
	return ct;
	
	}

	@Override
	public CEC incasareCec(String string, Date dataEmiterii, double d,
			String string2, String string3, Object object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdinDePlata incasareOP(String string, Date dataEmiterii, double d,
			String string2, String string3, int i, String string4,
			ArrayList<Facturi> facturi) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chitanta inregistrareCt(String string, Date dataEmiterii, double d,
			String string2, String string3, ArrayList<Facturi> facturi,
			Angajat angajat) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtrasDeCont incasareEC(String string, Date dataEmiterii, double d,
			String string2, String string3, ArrayList<Facturi> facturi)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	//public void setVanzariSrv(VanzariSrv vanzariSrv) {
		// TODO Auto-generated method stub
		
	//}

	


	
	

}
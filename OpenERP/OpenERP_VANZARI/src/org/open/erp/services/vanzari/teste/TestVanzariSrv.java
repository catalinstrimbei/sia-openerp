package org.open.erp.services.vanzari.teste;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.Clienti;
import org.open.erp.services.nommat.Produse;
import org.open.erp.services.vanzari.ArticolComanda;
import org.open.erp.services.vanzari.Avize;
import org.open.erp.services.vanzari.Comenzi;
import org.open.erp.services.vanzari.Facturi;
import org.open.erp.services.vanzari.OfertePret;
import org.open.erp.services.vanzari.Responsabil;
import org.open.erp.services.vanzari.VanzariSrv;

public class TestVanzariSrv {
	private static Logger logger;
	VanzariSrv vanzariInstance;
	
	
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestVanzariSrv.class.getName());	
		
	}
	
	@Before public void initServices(){	

		
	}
		
	@Test
	public void testVerificareOferta() throws Exception{
	
		
		//4.1. Preluare date produsee
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Date dataEmitere=new Date(System.currentTimeMillis());
		
			
		logger.info("START creare date de test Verificare ------ ");
		
		logger.info("START creare produse----- ");
		Produse produs1 = new Produse(1, "Produs 1", 67890, 10.00, 13.00 );
		Clienti client1= new Clienti(10,null,"Popescu","Ion", "PF");
		OfertePret ofertaPret1=new OfertePret(100, produs1, client1,dateFormat.parse("31/11/2012"), dataEmitere,"ceva");
		
		logger.info("FINAL creare produse----- ");
		
		//OfertePret valOferta = vanzariInstance.creareOfertePret(produs1, client1, null, null);
		
		logger.info("Valoarea ofertei produsului: "+produs1.getDenumire() + " este de: " + ofertaPret1.getPretOferta(100.00) );
		
}
	@Test
	public void testAdaugaComanda() throws Exception{
		
	// Se face o comanda
		logger.info("Start creare comanda");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		
		Date dataEmitere=new Date(System.currentTimeMillis());
		
		logger.info("Adaugare produs");
		Produse produs1 = new Produse(1, "Produs 1", 67890, 10.00, 13.00 );
		
		logger.info("Adaugare client");
		Clienti client1= new Clienti(10,null,"Popescu","Ion", "PF");
		
		logger.info("Adaugare oferta");
		OfertePret ofertaPret1=new OfertePret(100, produs1, client1,dateFormat.parse("31/11/2012"), dataEmitere,"ceva");
		
		logger.info("Adaugare comanda");		
		Comenzi comanda = new Comenzi(1, new Date(), new ArrayList<ArticolComanda>());
			
		logger.info("Adaugare aritcol comanda");			
		ArticolComanda articolComanda1=new ArticolComanda(1, ofertaPret1, 10.00, 6.00);
		logger.info(articolComanda1.calcValoare());
		
		logger.info("Adaugare aritcol2 comanda");
		ArticolComanda articolComanda2=new ArticolComanda(2, ofertaPret1, 101.00, 101.00);
		logger.info(articolComanda2.calcValoare());
			
		comanda.adauga(articolComanda1);
		comanda.adauga(articolComanda2);
	
		
		logger.info(comanda.getValoareComanda());
		}
	
	@Test
	public void testCreareFactura() throws Exception{
		logger.info("Begin test TestVanzariSrv(create factura)!");
		//--------
		logger.info("START creare responsabil----- ");
		Responsabil responsabil = new Responsabil(1, "Popescu", "Mihai", "SV","564789","Responsabil livrare", "are experienta" );
		logger.info("FINAL creare responsabil----- ");
	
		logger.info("Start creare comanda");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		
		Date dataEmitere=new Date(System.currentTimeMillis());
		
		logger.info("Adaugare produs");
		Produse produs1 = new Produse(1, "Produs 1", 67890, 10.00, 13.00 );
		
		logger.info("Adaugare client");
		Clienti client1= new Clienti(10,null,"Popescu","Ion", "PF");
		
		logger.info("Adaugare oferta");
		OfertePret ofertaPret1=new OfertePret(100, produs1, client1,dateFormat.parse("31/11/2012"), dataEmitere,"ceva");
		
		logger.info("Adaugare comanda");		
		Comenzi comanda = new Comenzi(1, new Date(), new ArrayList<ArticolComanda>());
			
		logger.info("Adaugare aritcol comanda");			
		ArticolComanda articolComanda1=new ArticolComanda(1, ofertaPret1, 10.00, 0.00);
		logger.info(articolComanda1.calcValoare());
		
		logger.info("Adaugare aritcol2 comanda");
		ArticolComanda articolComanda2=new ArticolComanda(2, ofertaPret1, 101.00, 101.00);
		logger.info(articolComanda2.calcValoare());
		
		logger.info("START creare aviz----- ");
		Avize aviz = new Avize(1, new Date(), responsabil );
		logger.info("FINAL creare comanda----- ");
		
		logger.info("Start caz de utilizare creare factura----- ");
		Facturi factura = vanzariInstance.creareFactura(responsabil, produs1, comanda);
		
		//assertNotNull("Nu exista factura noua!", factura);
		//
				
		logger.debug("1.7 Afisare liniile facturii (cantitateaAcceptata>0)");
		for (ArticolComanda articol: articole) {
			
			valoare = valoare + articol.calcValoare();
		}
		
		logger.debug("Status proiect: " + factura.getComanda().getCantitateAcceptata());
		//--------
		logger.info("End Test TestVanzariSrv!");
		
	}
	
	
	}

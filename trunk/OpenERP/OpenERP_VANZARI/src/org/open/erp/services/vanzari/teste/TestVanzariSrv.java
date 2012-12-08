package org.open.erp.services.vanzari.teste;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.vanzari.ArticolComanda;
import org.open.erp.services.vanzari.Avize;
import org.open.erp.services.vanzari.Clienti;
import org.open.erp.services.vanzari.Comenzi;
import org.open.erp.services.vanzari.DispozitiiLivrare;
import org.open.erp.services.vanzari.Facturi;
import org.open.erp.services.vanzari.LiniiAviz;
import org.open.erp.services.vanzari.LiniiDispozitieLivrare;
import org.open.erp.services.vanzari.LiniiFactura;
import org.open.erp.services.vanzari.OfertePret;
import org.open.erp.services.vanzari.Produse;
import org.open.erp.services.vanzari.VanzariSrv;


public class TestVanzariSrv {
	private static Logger logger;
	VanzariSrv vanzariInstance;
	StocuriSrv stocuriInstance;
	
	
	
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestVanzariSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		vanzariInstance= VanzariSrvFactory.getVanzariSrv();
		stocuriInstance=VanzariSrvFactory.getStocuriSrv();
		logger.info("Initializare VanzariSRV pentru TESTARE!");
		

	}
		
	@Test
	public void testVerificareOferta() throws Exception{
	
		
		//Se face oferta de pret
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		
		Date dataEmitere=new Date(System.currentTimeMillis());
		
			
		logger.info("***START creare date de test oferta de pret*** ");
		logger.info("1.1 Creare oferta de pret--->>>> ");
		
		logger.info("1.2 START creare produse ");
		Produse produs1 = new Produse(1, "Produs 1", 67890, 10.00, 13.00 );
		
		logger.info("2.2 START creare clienti ");
		
		Adresa adr = new Adresa ("1", "Iasi", "Iasi", "Ro", "St", "700358");
		PersoanaFizica pers = new PersoanaFizica(1, "Test", "M", "ics@yahoo.co","Anngajat", null, "12-03-1988", "074444445", adr );
		Clienti client1= new Clienti(pers, "PF");
		
		logger.info("1.2 START creare oferta de pret ");
	
		OfertePret ofertaPret1= vanzariInstance.creareOfertePret(100, produs1,dateFormat.parse("31/11/2012"), dataEmitere,"ceva");
		
		logger.info("FINAL creare produse/clienti/oferte de pret ");
		
		//OfertePret valOferta = vanzariInstance.creareOfertePret(produs1, client1, null, null);
		
		logger.info("Valoarea ofertei produsului: "+produs1.getDenumire() + " este de: " + ofertaPret1.getPretOferta(100.00) );
		logger.info("===========================================");
}
	@Test
	public void testAdaugaComanda() throws Exception{
		
	// Se face o comanda
		
		logger.info("***START creare date de test comanda*** ");
		logger.info("2.1 Creare comanda--->>>> ");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		
		Date dataEmitere=new Date(System.currentTimeMillis());
		
		logger.info("1.2 START creare produse");
		Produse produs1 = new Produse(1, "Produs 1", 67890, 10.00, 13.00 );
		
		logger.info("2.2 START creare clienti");
		Adresa adr = new Adresa ("1", "Iasi", "Iasi", "Ro", "St", "700358");
		PersoanaFizica pers = new PersoanaFizica(1, "Test", "M", "ics@yahoo.co","Anngajat", null, "12-03-1988", "074444445", adr );
		Clienti client1= new Clienti(pers, "PF");
		
		logger.info("1.1 Start creare oferta de pret");
		OfertePret ofertaPret1=vanzariInstance.creareOfertePret(100, produs1,dateFormat.parse("31/11/2012"), dataEmitere,"ceva");
		
		logger.info("2.1 START creare comenzi");		
		Comenzi comanda = vanzariInstance.creareComanda(1, new Date(), new ArrayList<ArticolComanda>());
		
		logger.info("FINAL creare produse/clienti/oferte de pret/comada ");
		
		logger.info("2.3 Adaugare aritcol1 comanda");			
		ArticolComanda articolComanda1=new ArticolComanda(1, ofertaPret1, 10.00, 6.00);
		logger.info(articolComanda1.calcValoare());
		
		logger.info("2.3 Adaugare aritcol2 comanda");
		ArticolComanda articolComanda2=new ArticolComanda(2, ofertaPret1, 101.00, 101.00);
		logger.info(articolComanda2.calcValoare());
			
		comanda.adauga(articolComanda1);
		comanda.adauga(articolComanda2);
	
		
		logger.info(comanda.getValoareComanda());
		logger.info("=====================================================");
		}
	
	@Test
	public void testCreareDispozitieLivrare() throws Exception{
		
		logger.info("***START creare date test dispozitie de livare***");
		logger.info("3.1 Dispozitie de livrare--->>>>");
		
		logger.info("3.4 START creare responsabil ");
		Responsabil responsabil = new Responsabil(1, "Popescu", "Mihai", "SV","564789","Responsabil livrare", "are experienta" );
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		
		Date dataEmitere=new Date(System.currentTimeMillis());
		
		ListaCaracteristici caract = new ListaCaracteristici("1", "Material Dur");
		Material mat = new Material("1", "fier", "20", "5"," 1.2", null, caract);
		logger.debug("++++++ Afisare Material: " + mat.getDenumireMaterial() + "; "+ "Detalii: " + mat.getPretStandard() + ", " + mat.getCantitateStandard());
		
		logger.info("1.2 START creare produse");
		Produse produs1 = new Produse(mat, 1, "Produs 1", 67890, 10.00, 13.00 );
		
		logger.info("3.2 START creare clienti");
		
		Adresa adr = new Adresa ("1", "Iasi", "Iasi", "Ro", "St", "700358");
		PersoanaFizica pers = new PersoanaFizica(1, "Test", "M", "ics@yahoo.co","Anngajat", null, "12-03-1988", "074444445", adr );
		Clienti client1= new Clienti(pers, "PF");
		
		
		logger.info("1.1START creare oferta de pret");
		OfertePret ofertaPret1=vanzariInstance.creareOfertePret(100, produs1,dateFormat.parse("31/11/2012"), dataEmitere,"ceva");
		
		logger.info("2.1 START creare comenzi");		
		Comenzi comanda = vanzariInstance.creareComanda(1, new Date(), new ArrayList<ArticolComanda>());
			
		logger.info("FINAL creare produse/clienti/oferte de pret/comada ");
		
		logger.info("2.3 Adaugare articol comanda");			
		ArticolComanda articolComanda1=new ArticolComanda(1, ofertaPret1, 10.00, 0.00);
		logger.info(articolComanda1.calcValoare());
		
		logger.info("2.3 Adaugare aritcol2 comanda");
		ArticolComanda articolComanda2=new ArticolComanda(2, ofertaPret1, 101.00, 101.00);
		logger.info(articolComanda2.calcValoare());
		
		comanda.adauga(articolComanda1);
		comanda.adauga(articolComanda2);
	
		
		logger.info("3.1 START creare Dispozitie de Livrare ");
		DispozitiiLivrare dispozitie = vanzariInstance.creareDispozitieLivrare(1, new Date(),responsabil, comanda, new ArrayList<LiniiDispozitieLivrare>());
		logger.info("FINAL creare dispozitie de plata ");
		
		logger.debug("Afisare liniile dispozitie (cantitateaAcceptata>0)----");
		Integer i=1;
		for (ArticolComanda articol: dispozitie.getComanda().getArticole()) {
	
			if(articol.getCantitateAcceptata()> 0){
				
				LiniiDispozitieLivrare linieDispozitieLivrare = new LiniiDispozitieLivrare(i, articol);
				dispozitie.adaugaLinieDispozitie(linieDispozitieLivrare);
				i=i+1;
				//apelare iesire din stoc a articolului
				stocuriInstance.iesireStoc(articol.getOferta().getProdus().getMaterial(), articol.getCantitateAcceptata());
				logger.debug("*****************************" +  articol.getOferta().getProdus().getMaterial().getDenumireMaterial());
			}
		}
		
		logger.debug("Afisare linii dispozitie" );
		for (LiniiDispozitieLivrare linie : dispozitie.getLiniiDispozitieLivare()) {
			
			logger.info (linie.getArticol().getCantitateAcceptata());
			
		}
		
		
		//---
		logger.info("========================================================");
		
	}
	
	@Test
	public void testCreareAviz() throws Exception{
		
		logger.info("***START creare date test aviz***");
		logger.info("4.1 Avize--->>>>");
		
		
		logger.info("4.5 START creare responsabil ");
		Responsabil responsabil = new Responsabil(1, "Popescu", "Mihai", "SV","564789","Responsabil livrare", "are experienta" );
	
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		
		Date dataEmitere=new Date(System.currentTimeMillis());
		
		logger.info("1.2 START creare produse");
		Produse produs1 = new Produse(1, "Produs 1", 67890, 10.00, 13.00 );
		
		logger.info("2.2 START creare clienti");
		Adresa adr = new Adresa ("1", "Iasi", "Iasi", "Ro", "St", "700358");
		PersoanaFizica pers = new PersoanaFizica(1, "Test", "M", "ics@yahoo.co","Anngajat", null, "12-03-1988", "074444445", adr );
		Clienti client1= new Clienti(pers, "PF");
		
		logger.info("1.1 START creare oferta de pret");
		OfertePret ofertaPret1=vanzariInstance.creareOfertePret(100, produs1,dateFormat.parse("31/11/2012"), dataEmitere,"ceva");
		
		logger.info("2.1 START creare comenzi");		
		Comenzi comanda = vanzariInstance.creareComanda(1, new Date(), new ArrayList<ArticolComanda>());
		
		logger.info("FINAL creare produse/clienti/oferte de pret/comada ");
		
		logger.info("2.3 Adaugare aritcol1 comanda");			
		ArticolComanda articolComanda1=new ArticolComanda(1, ofertaPret1, 10.00, 0.00);
		logger.info(articolComanda1.calcValoare());
		
		logger.info("2.3 Adaugare aritcol2 comanda");
		ArticolComanda articolComanda2=new ArticolComanda(2, ofertaPret1, 101.00, 101.00);
		logger.info(articolComanda2.calcValoare());
		
		comanda.adauga(articolComanda1);
		comanda.adauga(articolComanda2);
	
		
		logger.info("4.1 START creare avize ");
		Avize aviz = vanzariInstance.creareAviz(1, new Date(), responsabil, comanda, new ArrayList<LiniiAviz>());
		logger.info("FINAL creare aviz ");
		
		logger.debug("4.4 Afisare linii aviz (cantitateaAcceptata>0)");
		Integer i=1;
		for (ArticolComanda articol: aviz.getComanda().getArticole()) {
	
			if(articol.getCantitateAcceptata()> 0){
				
				LiniiAviz linieAviz = new LiniiAviz(i, articol);
				aviz.adaugaLinieAviz(linieAviz);
				i=i+1;
			}
		}
		
		logger.debug("Afisare linii aviz" );
		for (LiniiAviz linie : aviz.getLiniiAviz()) {
			
			logger.info (linie.getArticol().getCantitateAcceptata());
			
		}
		
		
		logger.info("======================================================");
		
	}
	
	
	
	@Test
	public void testCreareFactura() throws Exception{
		
		logger.info("***START creare date test aviz***");
		logger.info("5.1 Facturi--->>>>");
		
		logger.info("5.4 START creare responsabil ");
		Angajat responsabil = new Angajat(1, "Popescu", "Mihai", "SV","564789","Responsabil livrare", "are experienta" );
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");		
		Date dataEmitere=new Date(System.currentTimeMillis());
		
		logger.info("1.2 START creare produse");
		Produse produs1 = new Produse(1, "Produs 1", 67890, 10.00, 13.00 );
		Produse produs2 = new Produse(2, "Produs 2", 67892, 2.00, 122.00 );
		
		logger.info("2.2 START creare clienti");
		Adresa adr = new Adresa ("1", "Iasi", "Iasi", "Ro", "St", "700358");
		PersoanaFizica pers = new PersoanaFizica(1, "Test", "M", "ics@yahoo.co","Anngajat", null, "12-03-1988", "074444445", adr );
		Clienti client1= new Clienti(pers, "PF");
		logger.debug("_)_)_)_)_)_)_)_" + client1.getPersoana().getNume());
		
		logger.info("1.1 START creare oferta de pret");
		OfertePret ofertaPret1=vanzariInstance.creareOfertePret(100, produs1,dateFormat.parse("31/11/2012"), dataEmitere,"ceva");
		OfertePret ofertaPret2=vanzariInstance.creareOfertePret(200, produs2,dateFormat.parse("31/11/2012"), dataEmitere,"altceva");
		
		logger.info("2.1 START creare comenzi");		
		Comenzi comanda = vanzariInstance.creareComanda(1, new Date(), new ArrayList<ArticolComanda>());
			
		logger.info("FINAL creare produse/clienti/oferte de pret/comada ");
		
		logger.info("2.3 Adaugare aritcol1 comanda");			
		ArticolComanda articolComanda1=new ArticolComanda(1, ofertaPret1, 10.00, 0.00);
		logger.info(articolComanda1.calcValoare());
		
		logger.info("2.3 Adaugare aritcol2 comanda");
		ArticolComanda articolComanda2=new ArticolComanda(2, ofertaPret1, 101.00, 101.00);
		logger.info(articolComanda2.calcValoare());
		
		logger.info("2.3 Adaugare aritcol3 comanda");
		ArticolComanda articolComanda3=new ArticolComanda(3, ofertaPret2, 202.00, 202.00);
		logger.info(articolComanda3.calcValoare());
		
		comanda.adauga(articolComanda1);
		comanda.adauga(articolComanda2);
		comanda.adauga(articolComanda3);
	
		
		logger.info("4.1 START creare avize ");
		Avize aviz =vanzariInstance.creareAviz(1, new Date(), responsabil, comanda, new ArrayList<LiniiAviz>());
		logger.info("FINAL creare aviz ");
		
		logger.debug("4.4 Afisare liniile aviz (cantitateaAcceptata>0)");
		Integer i=1;
		for (ArticolComanda articol: aviz.getComanda().getArticole()) {
	
			if(articol.getCantitateAcceptata()> 0){
				
				LiniiAviz linieAviz = new LiniiAviz(i, articol);
				aviz.adaugaLinieAviz(linieAviz);
				i=i+1;
			}
		}
		
		logger.debug("Afisare linii aviz" );
		for (LiniiAviz linie : aviz.getLiniiAviz()) {
			
			logger.info (linie.getArticol()/*.getCantitateAcceptata()*/);
			
		}
		
		logger.info("5.1 Start caz de utilizare creare factura ");
		Facturi factura = vanzariInstance.creareFactura(1, new Date(), responsabil, aviz, comanda, new ArrayList<LiniiFactura>());
		//Facturi factura=new Facturi(1, new Date(), responsabil, aviz, comanda, new ArrayList<LiniiFactura>());
		//assertNotNull("Nu exista factura noua!", factura);
		//
				
		logger.debug("5.6 Afisare liniile facturii (cantitateaAcceptata>0)");
		Integer j=1;
		for (ArticolComanda articol: factura.getComanda().getArticole()) {
	
			if(articol.getCantitateAcceptata()> 0){
				
				LiniiFactura linieFactura = new LiniiFactura(j, articol);
				factura.adaugaLinieFactura(linieFactura);
				j=j+1;
			}
		}
		
		logger.debug("Afisare linii factura" );
		for (LiniiFactura linie : factura.getLiniiFactura()) {
			
			logger.info (linie.getArticol().getCantitateAcceptata());
			
		}
		//---
		logger.info("========================================================");
		logger.info("End Test TestVanzariSrv!");
		logger.info("========================================================");
		
	}
	
	
	}

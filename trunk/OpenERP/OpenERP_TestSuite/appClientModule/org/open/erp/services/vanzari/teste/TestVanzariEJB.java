package org.open.erp.services.vanzari.teste;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.teste.StocuriSrvFactory;
import org.open.erp.services.stocuri.teste.TestStocuriEJB;
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
import org.open.erp.services.vanzari.Persoana;
import org.open.erp.services.vanzari.Produse;
import org.open.erp.services.vanzari.VanzariSrv;

public class TestVanzariEJB {
	// Resurse test
		private static Logger logger = Logger.getLogger(TestVanzariEJB.class.getName());
		
		// Unitatea de test sursa/gazda unitatii de test 
		public static VanzariSrv vanzariInstance;
		
		// Set up 
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			vanzariInstance = VanzariSrvFactory.getVanzariSrv();
			logger.info("initTest " + vanzariInstance);
		}
		
		@Test
		public void testCrearePersoana() throws Exception{
			logger.info("-----START creare persoana----- ");
			
			Persoana persoana = vanzariInstance.crearePersoana(1, "ION", "Ion", "sofer");
			
		
			logger.info("-----SFARSIT creare persoana----- " + persoana.getNume() );
			
		}
		
	
}

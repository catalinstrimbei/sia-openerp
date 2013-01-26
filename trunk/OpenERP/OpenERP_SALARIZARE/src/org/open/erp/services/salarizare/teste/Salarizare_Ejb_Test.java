package org.open.erp.services.salarizare.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.salarizare.Centralizare_Stat_Plata;
import org.open.erp.services.salarizare.Pontaje;
import org.open.erp.services.salarizare.Retineri;
import org.open.erp.services.salarizare.SRV_Salarizare;
import org.open.erp.services.salarizare.Sporuri;
import org.open.erp.services.salarizare.Stat_Salarii;
import org.open.erp.services.salarizare.impl.Registru_Salarizare;
import org.open.erp.services.salarizare.impl.Implement_Salarizare;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Salarizare_Ejb_Test {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Implement_Salarizare.class.getName());
	private static SRV_Salarizare salarizareSrvInstance;
	private static PersonalSrv personalSrvInstance;
	private static Registru_Salarizare registru_Salarizare;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		salarizareSrvInstance = (SRV_Salarizare)ctx.lookup("Implement_Salarizare/remote");
		personalSrvInstance = (PersonalSrv)ctx.lookup("PersonalSrv/remote");
		
		logger.info("initTest " + salarizareSrvInstance);
		logger.info("initTest " + personalSrvInstance);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	//Test pentru inregistrarea pontajului pt un anumit angajat
	//load angajat din componenta EJB Personal
	
	@Test
	public void testInregistrarePontaj() throws Exception {
		logger.info("Start test: inregistrarePontaj");
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		Pontaje pontaj = salarizareSrvInstance.inregistrarePontaj(null,angajat, 2013, 11, 160.0, 0.0, 0.0);
		logger.info("A fost creat pontajul cu id-ul: "+pontaj.getCod_Pontaj());
		
		assertNotNull("Metoda de creere a pontajului nu a functionat!", pontaj.getCod_Pontaj());
		
		logger.info("Sfarsit test: inregistrarePontaj");
	}

	
	//test metoda generare automata pontaj pe toata luna pt toti angajatii
	//propagare tranzactie intre inregistrare pontaj si inregistrarePontajLuna
	@Test
	public void testInregistrarePontajLuna() throws Exception {
		logger.info("Start test: inregistrarePontaj");
		
		salarizareSrvInstance.inregistrarePontajLuna(2013, 11);
		
		logger.info("Sfarsit test: inregistrarePontaj");
	}
	
	
	@Test
	public void calculSporuriAngajati() throws Exception {
		logger.info("Begin test: calculSporuriAngajat");
		Double sporuri;
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		sporuri = salarizareSrvInstance.calculSporuriAngajat(2013, 11, angajat);
		logger.info("Sporurile insumate sunt: "+sporuri);
		
		assertNotNull("Metoda de calcul a sporurilor nu a functionat!", sporuri);
		
		logger.info("Sfarsit test: calculSporuriAngajat");
	}
		
	@Test
	public void calculRetineriAngajati() throws Exception {
		logger.info("Start test: calculRetineriAngajat");
		Double retineri;
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());

		retineri = salarizareSrvInstance.calculRetineriAngajat(2013, 11, angajat);
		logger.info("Retinerile insumate sunt: "+retineri);
		
		assertNotNull("Metoda de calcul a retinerilor nu a functionat!", retineri);
		
		logger.info("Sfarsit test: calculRetineriAngajat");
	}
	
	
	@Test
	public void calculVenitBrutAngajati() throws Exception {
		logger.info("Start test: calculVenitBrutAngajat");
		Double venitBrut;
		Angajat angajat = salarizareSrvInstance.getAngajatById(1);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		venitBrut=salarizareSrvInstance.calculVenitBrut(2013, 11, angajat);
		
		logger.info("Venitul brut calculat este: "+venitBrut);
		
		assertNotNull("Metoda de calcul a venitului brut nu a functionat!", venitBrut);
		
		logger.info("Sfarsit test: calculVenitBrutAngajat");
	}
	
	@Test
	public void calculRetineriObligatoriiAngajati() throws Exception {
		logger.info("Start test: calculRetineriObligatoriiAngajat");
		Angajat angajat = salarizareSrvInstance.getAngajatById(1);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Double venitBrut = salarizareSrvInstance.calculVenitBrut(2013, 11, angajat);
		Double cas 	= salarizareSrvInstance.calculRetineriObligatorii(2013, 11, angajat,"CAS", venitBrut);
		logger.info("CAS-ul este: "+cas);
		assertNotNull("Metoda de calcul a cas-ului nu a functionat!", cas);

		Double cass = salarizareSrvInstance.calculRetineriObligatorii(2013, 11, angajat,"CASS", venitBrut);
		logger.info("CASS-ul este: "+cas);
		assertNotNull("Metoda de calcul a cass-ului nu a functionat!", cass);
		
		Double somaj = salarizareSrvInstance.calculRetineriObligatorii(2013, 11, angajat,"SOMAJ", venitBrut);		
		logger.info("Start este: "+cas);
		assertNotNull("Metoda de calcul a somajului nu a functionat!", somaj);
		
		logger.info("Sfarsit test: calculRetineriObligatoriiAngajat");
	}
	
	@Test
	public void calculDeduceriAngajati() throws Exception {
		logger.info("Start test: calculDeduceriAngajat");
		Angajat angajat = salarizareSrvInstance.getAngajatById(1);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Double deduceri = salarizareSrvInstance.calculDeduceri(2013, 11, angajat);
		logger.info("Deducerile sunt: "+deduceri);
		assertNotNull("Metoda de calcul a deducerilor nu a functionat!", deduceri);
		logger.info("End test: calculDeduceriAngajat");
	}
	
	@Test
	public void testinregistrarStatSalariiLuna() throws Exception {
		logger.info("Start test: inregistrareStatSalariiLuna");
		salarizareSrvInstance.inregistrarStatSalariiLuna(2013, 11);
		logger.info("Sfarsit test: inregistrareStatSalariiLuna");
	}
	
	@Test
	public void testInregistrareSpor() throws Exception {
		logger.info("Start test: inregistrareSpor");
		Angajat angajat = salarizareSrvInstance.getAngajatById(1);//personalSrvInstance
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Sporuri spor = salarizareSrvInstance.inregistrareSpor(555,"Bonus", 1, 2013, 11, angajat, 1, 100.0);
		logger.info("A fost creat sporul cu id-ul: "+spor.getCod_Spor());
		assertNotNull("Metoda de creare a sporului nu a functionat!", spor);
		
		logger.info("Sfarsit test: inregistrareSpor");
	}
	
//	@Test
//	public void testInregistrareRetinere() throws Exception {
//		logger.info("Begin test: inregistrareRetinere");
//		Angajat angajat = personalSrvInstance.getAngajatById(1);
//		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
//		
//		Retineri retinere = salarizareSrvInstance.inregistrareRetinere(null,"Penalizare", 1, 2013, 11, angajat, 1, 100.0);
//		logger.info("A fost creat sporul cu id-ul: "+retinere.getCod_Retinere());
//		assertNotNull("Metoda de creare a retinerii nu a functionat!", retinere);
//		
//		logger.info("End test: inregistrareRetinere");
//	}
//	
	@Test
	public void testAdaugaOreConcediu() throws Exception {
		logger.info("Start test: adaugaOreConcediu");
		Angajat angajat = salarizareSrvInstance.getAngajatById(1);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Pontaje pontaj = salarizareSrvInstance.getPontajByAngajat(angajat, 2013, 11);
		logger.info("A fost incarcat pontajul cu id-ul: "+pontaj.getCod_Pontaj());

		salarizareSrvInstance.adaugaOreConcediu(pontaj, 8.0);
		
		logger.info("Sfarsit test: adaugaOreConcediu");
	}
	
	@Test
	public void testAdaugaOreSuplimentare() throws Exception {
		logger.info("Start test: adaugaOreSuplimentare");
		Angajat angajat = salarizareSrvInstance.getAngajatById(1);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Pontaje pontaj = salarizareSrvInstance.getPontajByAngajat(angajat, 2013, 11);
		logger.info("A fost incarcat pontajul cu id-ul: "+pontaj.getCod_Pontaj());

		salarizareSrvInstance.adaugaOreSuplimentare(pontaj, 8.0);
		
		logger.info("Sfarsit test: adaugaOreSuplimentare");
	}
	
	@Test
	public void testGetPontajAnLuna() throws Exception {
		logger.info("Start test: getPontajAnLuna");
		List<Pontaje> pontaje = salarizareSrvInstance.getPontajAnLuna(2013, 11);
		
		assertNotNull("Metoda de incarcare a pontajelor dintr-o luna nu a functionat!", pontaje);
		
		logger.info("Sfarsit test: getPontajAnLuna");
	}
	
	@Test
	public void testGetSporuriAngajat() throws Exception {
		logger.info("Start test: getSporuriAngajat");
		Angajat angajat = salarizareSrvInstance.getAngajatById(1);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		List<Sporuri> sporuri = salarizareSrvInstance.getSporuriAngajat(2013, 11, angajat);
		
		assertNotNull("Metoda de incarcare a sporurilor pentru angajat nu a functionat!", sporuri);
		
		logger.info("Sfarsit test: getSporuriAngajat");
	}
	
	@Test
	public void testGetRetineriAngajat() throws Exception {
		logger.info("Start test: getRetineriAngajat");
		Angajat angajat = salarizareSrvInstance.getAngajatById(1);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		List<Retineri> retineri = salarizareSrvInstance.getRetineriAngajat(2013, 11, angajat);
		
		assertNotNull("Metoda de incarcare a retinerilor pentru angajat nu a functionat!", retineri);
		
		logger.info("Sfarsit test: getRetineriAngajat");
	}

	@Test
	public void testGetStatSalariiAnLuna() throws Exception {
		logger.info("Start test: getStatSalariiAnLuna");
		List<Stat_Salarii> salarii = salarizareSrvInstance.getStatAnLuna(2013, 11);
		
		assertNotNull("Metoda de incarcare a salariilor dintr-o luna nu a functionat!", salarii);
		
		logger.info("Sfarsit test: getStatSalariiAnLuna");
	}

	@Test
	public void testInregistrareCentralizator() throws Exception {
		logger.info("Start test: InregistrareCentralizator");
		
		Centralizare_Stat_Plata centralizator = salarizareSrvInstance.inregistreazaCentralizatorStatSalariiLuna(2011, 11);
		logger.info("A fost creat centralizatorul cu id-ul: "+centralizator.getCentralizator());
		assertNotNull("Metoda de creare a centralizatorului nu a functionat!", centralizator);
		
		logger.info("Sfarsit test: InregistrareCentralizator");
	}
	
	@Test
	public void testGetCentralizatorStatSalariiLuna() throws Exception {
		logger.info("Start test: getCentralizatorStatSalariiLuna");
		
		Centralizare_Stat_Plata centralizator = salarizareSrvInstance.getCentralizatorStatSalariiLuna(2011, 11);
		logger.info("A fost incarcat centralizatorul cu id-ul: "+centralizator.getCentralizator());
		assertNotNull("Metoda de creare a centralizatorului nu a functionat!", centralizator);
		
		logger.info("Sfarsit test: getCentralizatorStatSalariiLuna");
	}

	@Test
	public void testStergeCentralizator() throws Exception {
		logger.info("Start test: testStergeCentralizator");
		
		Centralizare_Stat_Plata centralizator = salarizareSrvInstance.getCentralizatorStatSalariiLuna(2011, 11);
		logger.info("A fost incarcat centralizatorul cu id-ul: "+centralizator.getCentralizator());
		salarizareSrvInstance.stergeCentralizator(centralizator);
		
		logger.info("Sfarsit test: testStergeCentralizator");
	}
	
	/*--- Utils: InitialContext Client EJB-JDNI ----------------------------------------------------*/
	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	

}

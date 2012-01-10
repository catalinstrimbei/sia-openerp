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
import org.open.erp.services.salarizare.CentralizatorStatSalarii;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.Retinere;
import org.open.erp.services.salarizare.SalarizareSrv;
import org.open.erp.services.salarizare.Spor;
import org.open.erp.services.salarizare.StatSalarii;
import org.open.erp.services.salarizare.impl.RegistruSalarizare;
import org.open.erp.services.salarizare.impl.SalarizareImpl;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestSalarizareEJB {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SalarizareImpl.class.getName());
	private static SalarizareSrv salarizareSrvInstance;
	private static PersonalSrv personalSrvInstance;
//	private static RegistruSalarizare registruSalarizare;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		salarizareSrvInstance = (SalarizareSrv)ctx.lookup("SalarizareImpl/remote");
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
		logger.info("Begin test: inregistrarePontaj");
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		Pontaj pontaj = salarizareSrvInstance.inregistrarePontaj(angajat, 2011, 11, 160.0, 0.0, 0.0);
		logger.info("A fost creat pontajul cu id-ul: "+pontaj.getIdPontaj());
		
		assertNotNull("Metoda de creere a pontajului nu a functionat!", pontaj.getIdPontaj());
		
		logger.info("End test: inregistrarePontaj");
	}

	
	//test metoda generare automata pontaj pe toata luna pt toti angajatii
	//propagare tranzactie intre inregistrare pontaj si inregistrarePontajLuna
	@Test
	public void testInregistrarePontajLuna() throws Exception {
		logger.info("Begin test: inregistrarePontaj");
		
		salarizareSrvInstance.inregistrarePontajLuna(2011, 11);
		
		logger.info("End test: inregistrarePontaj");
	}
	
	
	@Test
	public void calculSporuriAngajati() throws Exception {
		logger.info("Begin test: calculSporuriAngajat");
		Double sporuri;
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		sporuri = salarizareSrvInstance.calculSporuriAngajat(2011, 11, angajat);
		logger.info("Sporurile insumate sunt: "+sporuri);
		
		assertNotNull("Metoda de calcul a sporurilor nu a functionat!", sporuri);
		
		logger.info("End test: calculSporuriAngajat");
	}
		
	@Test
	public void calculRetineriAngajati() throws Exception {
		logger.info("Begin test: calculRetineriAngajat");
		Double retineri;
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());

		retineri = salarizareSrvInstance.calculRetineriAngajat(2011, 11, angajat);
		logger.info("Retinerile insumate sunt: "+retineri);
		
		assertNotNull("Metoda de calcul a retinerilor nu a functionat!", retineri);
		
		logger.info("End test: calculRetineriAngajat");
	}
	
	
	@Test
	public void calculVenitBrutAngajati() throws Exception {
		logger.info("Begin test: calculVenitBrutAngajat");
		Double venitBrut;
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		venitBrut=salarizareSrvInstance.calculVenitBrut(2011, 11, angajat);
		
		logger.info("Venitul brut calculat este: "+venitBrut);
		
		assertNotNull("Metoda de calcul a venitului brut nu a functionat!", venitBrut);
		
		logger.info("End test: calculVenitBrutAngajat");
	}
	
	@Test
	public void calculRetineriObligatoriiAngajati() throws Exception {
		logger.info("Begin test: calculRetineriObligatoriiAngajat");
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Double venitBrut = salarizareSrvInstance.calculVenitBrut(2011, 11, angajat);
		Double cas 	= salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"CAS", venitBrut);
		logger.info("CAS-ul este: "+cas);
		assertNotNull("Metoda de calcul a cas-ului nu a functionat!", cas);

		Double cass = salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"CASS", venitBrut);
		logger.info("CASS-ul este: "+cas);
		assertNotNull("Metoda de calcul a cass-ului nu a functionat!", cass);
		
		Double somaj = salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"SOMAJ", venitBrut);		
		logger.info("Somaj este: "+cas);
		assertNotNull("Metoda de calcul a somajului nu a functionat!", somaj);
		
		logger.info("End test: calculRetineriObligatoriiAngajat");
	}
	
	@Test
	public void calculDeduceriAngajati() throws Exception {
		logger.info("Begin test: calculDeduceriAngajat");
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Double deduceri = salarizareSrvInstance.calculDeduceri(2011, 11, angajat);
		logger.info("Deducerile sunt: "+deduceri);
		assertNotNull("Metoda de calcul a deducerilor nu a functionat!", deduceri);
		logger.info("End test: calculDeduceriAngajat");
	}
	
	@Test
	public void testinregistrarStatSalariiLuna() throws Exception {
		logger.info("Begin test: inregistrareStatSalariiLuna");
		salarizareSrvInstance.inregistrarStatSalariiLuna(2011, 11);
		logger.info("End test: inregistrareStatSalariiLuna");
	}
	
	@Test
	public void testInregistrareSpor() throws Exception {
		logger.info("Begin test: inregistrareSpor");
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);//personalSrvInstance
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Spor spor = salarizareSrvInstance.inregistrareSpor("Bonus", 1, 2011, 11, angajat, 1, 100.0);
		logger.info("A fost creat sporul cu id-ul: "+spor.getIdSpor());
		assertNotNull("Metoda de creare a sporului nu a functionat!", spor);
		
		logger.info("End test: inregistrareSpor");
	}
	
	@Test
	public void testInregistrareRetinere() throws Exception {
		logger.info("Begin test: inregistrareRetinere");
		Angajat angajat = personalSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Retinere retinere = salarizareSrvInstance.inregistrareRetinere("Penalizare", 1, 2011, 11, angajat, 1, 100.0);
		logger.info("A fost creat sporul cu id-ul: "+retinere.getIdRetinere());
		assertNotNull("Metoda de creare a retinerii nu a functionat!", retinere);
		
		logger.info("End test: inregistrareRetinere");
	}
	
	@Test
	public void testAdaugaOreConcediu() throws Exception {
		logger.info("Begin test: adaugaOreConcediu");
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Pontaj pontaj = salarizareSrvInstance.getPontajByAngajat(angajat, 2011, 11);
		logger.info("A fost incarcat pontajul cu id-ul: "+pontaj.getIdPontaj());

		salarizareSrvInstance.adaugaOreConcediu(pontaj, 8.0);
		
		logger.info("End test: adaugaOreConcediu");
	}
	
	@Test
	public void testAdaugaOreSuplimentare() throws Exception {
		logger.info("Begin test: adaugaOreSuplimentare");
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Pontaj pontaj = salarizareSrvInstance.getPontajByAngajat(angajat, 2011, 11);
		logger.info("A fost incarcat pontajul cu id-ul: "+pontaj.getIdPontaj());

		salarizareSrvInstance.adaugaOreSuplimentare(pontaj, 8.0);
		
		logger.info("End test: adaugaOreSuplimentare");
	}
	
	@Test
	public void testGetPontajAnLuna() throws Exception {
		logger.info("Begin test: getPontajAnLuna");
		List<Pontaj> pontaje = salarizareSrvInstance.getPontajAnLuna(2011, 11);
		
		assertNotNull("Metoda de incarcare a pontajelor dintr-o luna nu a functionat!", pontaje);
		
		logger.info("End test: getPontajAnLuna");
	}
	
	@Test
	public void testGetSporuriAngajat() throws Exception {
		logger.info("Begin test: getSporuriAngajat");
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		List<Spor> sporuri = salarizareSrvInstance.getSporuriAngajat(2011, 11, angajat);
		
		assertNotNull("Metoda de incarcare a sporurilor pentru angajat nu a functionat!", sporuri);
		
		logger.info("End test: getSporuriAngajat");
	}
	
	@Test
	public void testGetRetineriAngajat() throws Exception {
		logger.info("Begin test: getRetineriAngajat");
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		List<Retinere> retineri = salarizareSrvInstance.getRetineriAngajat(2011, 11, angajat);
		
		assertNotNull("Metoda de incarcare a retinerilor pentru angajat nu a functionat!", retineri);
		
		logger.info("End test: getRetineriAngajat");
	}

	@Test
	public void testGetStatSalariiAnLuna() throws Exception {
		logger.info("Begin test: getStatSalariiAnLuna");
		List<StatSalarii> salarii = salarizareSrvInstance.getStatAnLuna(2011, 11);
		
		assertNotNull("Metoda de incarcare a salariilor dintr-o luna nu a functionat!", salarii);
		
		logger.info("End test: getStatSalariiAnLuna");
	}

	@Test
	public void testInregistrareCentralizator() throws Exception {
		logger.info("Begin test: InregistrareCentralizator");
		
		CentralizatorStatSalarii centralizator = salarizareSrvInstance.inregistreazaCentralizatorStatSalariiLuna(2011, 11);
		logger.info("A fost creat centralizatorul cu id-ul: "+centralizator.getIdCentralizator());
		assertNotNull("Metoda de creare a centralizatorului nu a functionat!", centralizator);
		
		logger.info("End test: InregistrareCentralizator");
	}
	
	@Test
	public void testGetCentralizatorStatSalariiLuna() throws Exception {
		logger.info("Begin test: getCentralizatorStatSalariiLuna");
		
		CentralizatorStatSalarii centralizator = salarizareSrvInstance.getCentralizatorStatSalariiLuna(2011, 11);
		logger.info("A fost incarcat centralizatorul cu id-ul: "+centralizator.getIdCentralizator());
		assertNotNull("Metoda de creare a centralizatorului nu a functionat!", centralizator);
		
		logger.info("End test: getCentralizatorStatSalariiLuna");
	}

	@Test
	public void testStergeCentralizator() throws Exception {
		logger.info("Begin test: testStergeCentralizator");
		
		CentralizatorStatSalarii centralizator = salarizareSrvInstance.getCentralizatorStatSalariiLuna(2011, 11);
		logger.info("A fost incarcat centralizatorul cu id-ul: "+centralizator.getIdCentralizator());
		salarizareSrvInstance.stergeCentralizator(centralizator);
		
		logger.info("End test: testStergeCentralizator");
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

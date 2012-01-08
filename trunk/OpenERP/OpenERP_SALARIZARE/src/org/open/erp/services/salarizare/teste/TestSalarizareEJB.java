package org.open.erp.services.salarizare.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.Retinere;
import org.open.erp.services.salarizare.SalarizareSrv;
import org.open.erp.services.salarizare.Spor;
import org.open.erp.services.salarizare.impl.RegistruSalarizare;
import org.open.erp.services.salarizare.impl.SalarizareImpl;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestSalarizareEJB {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SalarizareImpl.class.getName());
	private static SalarizareSrv salarizareSrvInstance;
	private static PersonalSrv personalSrvInstance;
	private static RegistruSalarizare registruSalarizare;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		salarizareSrvInstance = (SalarizareSrv)ctx.lookup("SalarizareSrv/remote");
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

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	//Test pentru inregistrarea pontajului pt un anumit angajat
	//load angajat din componenta EJB Personal
	@Test
	public void testInregistrarePontaj() throws Exception {
		logger.info("Begin test: inregistrarePontaj");
		Angajat angajat = personalSrvInstance.getAngajatById(10001);
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
	public void calculSporuriAngajati() {
		logger.info("Begin test: calculSporuriAngajat");
		Double sporuri;
		Angajat angajat = personalSrvInstance.getAngajatById(10001);
		
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		sporuri = salarizareSrvInstance.calculSporuriAngajat(2011, 11, angajat);
		logger.info("Sporurile insumate sunt: "+sporuri);
		
		assertNotNull("Metoda de calcul a sporurilor nu a functionat!", sporuri);
		
		logger.info("End test: calculSporuriAngajat");
	}
	
	@Test
	public void calculRetineriAngajati() {
		logger.info("Begin test: calculRetineriAngajat");
		Double retineri;
		Angajat angajat = personalSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());

		retineri = salarizareSrvInstance.calculRetineriAngajat(2011, 11, angajat);
		logger.info("Retinerile insumate sunt: "+retineri);
		
		assertNotNull("Metoda de calcul a retinerilor nu a functionat!", retineri);
		
		logger.info("End test: calculRetineriAngajat");
	}
	
	@Test
	public void calculVenitBrutAngajati() {
		logger.info("Begin test: calculVenitBrutAngajat");
		Double venitBrut;
		Angajat angajat = personalSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		venitBrut=salarizareSrvInstance.calculVenitBrut(2011, 11, angajat);
		
		logger.info("Retinerile insumate sunt: "+venitBrut);
		
		assertNotNull("Metoda de calcul a retinerilor nu a functionat!", venitBrut);
		
		logger.info("End test: calculVenitBrutAngajat");
	}
	
	@Test
	public void calculRetineriObligatoriiAngajati() {
		logger.info("Begin test: calculRetineriObligatoriiAngajat");
		Angajat angajat = personalSrvInstance.getAngajatById(10001);
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
	public void calculDeduceriAngajati() {
		logger.info("Begin test: calculDeduceriAngajat");
		Angajat angajat = personalSrvInstance.getAngajatById(10001);
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
		Angajat angajat = personalSrvInstance.getAngajatById(10001);
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
	
	/*--- Utils: InitialContext Client EJB-JDNI ----------------------------------------------------*/
	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	
	public void testAdaugaOreConcediu() throws Exception {
		logger.info("Begin test: adaugaOreConcediu");
		Angajat angajat = personalSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Pontaj pontaj = registruSalarizare.getPontajByAngajat(angajat, 2011, 11);
		logger.info("A fost incarcat pontajul cu id-ul: "+pontaj.getIdPontaj());

		salarizareSrvInstance.adaugaOreConcediu(pontaj, 8.0);
		
		logger.info("End test: adaugaOreConcediu");
	}
	
	public void testAdaugaOreSuplimentare() throws Exception {
		logger.info("Begin test: adaugaOreSuplimentare");
		Angajat angajat = personalSrvInstance.getAngajatById(10001);
		logger.info("A fost incarcat angajatul cu numele: "+angajat.getNume());
		
		Pontaj pontaj = registruSalarizare.getPontajByAngajat(angajat, 2011, 11);
		logger.info("A fost incarcat pontajul cu id-ul: "+pontaj.getIdPontaj());

		salarizareSrvInstance.adaugaOreSuplimentare(pontaj, 8.0);
		
		logger.info("End test: adaugaOreSuplimentare");
	}
}

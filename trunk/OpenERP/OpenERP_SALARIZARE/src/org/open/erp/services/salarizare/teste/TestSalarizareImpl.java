package org.open.erp.services.salarizare.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.*;
import org.open.erp.services.salarizare.*;
import org.open.erp.services.salarizare.impl.RegistruSalarizare;

public class TestSalarizareImpl {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestSalarizareImpl.class.getName());
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

	

	@Before
	public void setUp() throws Exception {
	
	//	salarizareSrvInstance= SalarizareFactory.getSalarizareSrv();
	//	personalSrvInstance = SalarizareFactory.getPersonalSrv();
	//	registruSalarizare = SalarizareFactory.getRegistruSalarizare();
		logger.info("initTest");		
	}

	@Test
	public void testInregistrarePontaj() throws Exception {
		logger.info("Begin test: inregistrarePontaj");
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
//		Angajat angajat = new Angajat();
//		angajat.setId(10001);
		Pontaj pontaj = salarizareSrvInstance.inregistrarePontaj(null, angajat, 2011, 11, 160.0, 0.0, 0.0);
		assertNotNull("Metoda de creere a pontajului nu a functionat!", pontaj);
		
		logger.info("End test: inregistrarePontaj");
	}
	
	@Test
	public void testInregistrarePontajLuna() throws Exception {
		logger.info("Begin test: inregistrarePontaj");
		salarizareSrvInstance.inregistrarePontajLuna(2011, 11);
		logger.info("End test: inregistrarePontaj");
	}
	
	@Test
	public void calculSporuriAngajati() throws Exception {
		logger.info("Begin test: calculSporuriAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
		salarizareSrvInstance.calculSporuriAngajat(2011, 11, angajat);
		}
		logger.info("End test: calculSporuriAngajat");
	}
	
	@Test
	public void calculRetineriAngajati() throws Exception {
		logger.info("Begin test: calculRetineriAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
		salarizareSrvInstance.calculRetineriAngajat(2011, 11, angajat);
		}
		logger.info("End test: calculRetineriAngajat");
	}
	
	@Test
	public void calculVenitBrutAngajati() throws Exception {
		logger.info("Begin test: calculVenitBrutAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
		salarizareSrvInstance.calculVenitBrut(2011, 11, angajat);
		}
		logger.info("End test: calculVenitBrutAngajat");
	}
	
	@Test
	public void calculRetineriObligatoriiAngajati() throws Exception {
		logger.info("Begin test: calculRetineriObligatoriiAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());

		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
			Double venitBrut = salarizareSrvInstance.calculVenitBrut(2011, 11, angajat);
			salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"CAS", venitBrut);
			salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"CASS", venitBrut);
			salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"SOMAJ", venitBrut);		
		}
		logger.info("End test: calculRetineriObligatoriiAngajat");
	}
	
	@Test
	public void calculImpozitAngajati() throws Exception {
		logger.info("Begin test: calculImpozitAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
			Double venitBrut = salarizareSrvInstance.calculVenitBrut(2011, 11, angajat);
			Double retineriAlte = salarizareSrvInstance.calculRetineriAngajat(2011, 11, angajat);
			Double deduceri = salarizareSrvInstance.calculDeduceri(2011, 11, angajat);
			Double cas = salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"CAS", venitBrut);
			Double cass = salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"CASS", venitBrut);
			Double somaj = salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"SOMAJ", venitBrut);
			salarizareSrvInstance.calculImpozit(2011, 11, angajat, venitBrut, cas, cass, somaj, retineriAlte, deduceri);
		}
		logger.info("End test: calculImpozitAngajat");
	}
	
	@Test
	public void calculDeduceriAngajati() throws Exception {
		logger.info("Begin test: calculDeduceriAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
		salarizareSrvInstance.calculDeduceri(2011, 11, angajat);
		}
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
		Angajat angajat = personalSrvInstance.getAngajatById(1);
		Spor spor = salarizareSrvInstance.inregistrareSpor(555,"Bonus", 1, 2011, 11, angajat, 1, 100.0);
		assertNotNull("Metoda de creare a sporului nu a functionat!", spor);
		
		logger.info("End test: inregistrareSpor");
	}
	
	@Test
	public void testInregistrareRetinere() throws Exception {
		logger.info("Begin test: inregistrareRetinere");
		Angajat angajat = personalSrvInstance.getAngajatById(1);
		Retinere retinere = salarizareSrvInstance.inregistrareRetinere(555,"Penalizare", 1, 2011, 11, angajat, 1, 100.0);
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
}

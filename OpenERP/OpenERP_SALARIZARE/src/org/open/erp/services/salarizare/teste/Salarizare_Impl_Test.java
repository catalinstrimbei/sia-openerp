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
import org.open.erp.services.salarizare.impl.Registru_Salarizare;

public class Salarizare_Impl_Test {

	

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Salarizare_Impl_Test.class.getName());
	private static SRV_Salarizare salarizareSrvInstance;
	private static PersonalSrv personalSrvInstance;
//	private static RegistruSalarizare registruSalarizare;
	

	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		salarizareSrvInstance = (SRV_Salarizare)ctx.lookup("Implement_Salarizare/remote");
		personalSrvInstance = (PersonalSrv)ctx.lookup("PersonalSrv/remote");
		
		logger.info("initTest " + salarizareSrvInstance);
		logger.info("initTest " + personalSrvInstance);
	}

	


	public void setUp() throws Exception {
	
	//	salarizareSrvInstance= SalarizareFactory.getSalarizareSrv();
	//	personalSrvInstance = SalarizareFactory.getPersonalSrv();
	//	registruSalarizare = SalarizareFactory.getRegistruSalarizare();
		logger.info("initTest");		
	}

	public void testInregistrarePontaj() throws Exception {
		Angajat angajat = salarizareSrvInstance.getAngajatById(10001);
//		Angajat angajat = new Angajat();
//		angajat.setId(10001);
		Pontaje pontaj = salarizareSrvInstance.inregistrarePontaj(null, angajat, 2013, 11, 160.0, 0.0, 0.0);
		assertNotNull("Metoda de creere a pontajului nu a functionat!", pontaj);
		
		logger.info("Sfarsit test: inregistrarePontaj");
	}
	

	public void testInregistrarePontajLuna() throws Exception {
		logger.info("Start test: inregistrarePontaj");
		salarizareSrvInstance.inregistrarePontajLuna(2013, 11);
		logger.info("Sfarsit test: inregistrarePontaj");
	}
	

	public void calculSporuriAngajati() throws Exception {
		logger.info("Start test: calculSporuriAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
		salarizareSrvInstance.calculSporuriAngajat(2013, 11, angajat);
		}
		logger.info("Sfarsit test: calculSporuriAngajat");
	}
	

	public void calculRetineriAngajati() throws Exception {
		logger.info("Start test: calculRetineriAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
		salarizareSrvInstance.calculRetineriAngajat(2013, 11, angajat);
		}
		logger.info("Sfarsit test: calculRetineriAngajat");
	}
	

	public void calculVenitBrutAngajati() throws Exception {
		logger.info("Start test: calculVenitBrutAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
		salarizareSrvInstance.calculVenitBrut(2013, 11, angajat);
		}
		logger.info("Sfarsit test: calculVenitBrutAngajat");
	}
	

	public void calculRetineriObligatoriiAngajati() throws Exception {
		logger.info("Start test: calculRetineriObligatoriiAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());

		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
			Double venitBrut = salarizareSrvInstance.calculVenitBrut(2011, 11, angajat);
			salarizareSrvInstance.calculRetineriObligatorii(2013, 11, angajat,"CAS", venitBrut);
			salarizareSrvInstance.calculRetineriObligatorii(2013, 11, angajat,"CASS", venitBrut);
			salarizareSrvInstance.calculRetineriObligatorii(2013, 11, angajat,"SOMAJ", venitBrut);		
		}
		logger.info("Sfarsit test: calculRetineriObligatoriiAngajat");
	}
	

	public void calculImpozitAngajati() throws Exception {
		logger.info("Start test: calculImpozitAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
			Double venitBrut = salarizareSrvInstance.calculVenitBrut(2013, 13, angajat);
			Double retineriAlte = salarizareSrvInstance.calculRetineriAngajat(2013, 11, angajat);
			Double deduceri = salarizareSrvInstance.calculDeduceri(2013, 11, angajat);
			Double cas = salarizareSrvInstance.calculRetineriObligatorii(2013, 11, angajat,"CAS", venitBrut);
			Double cass = salarizareSrvInstance.calculRetineriObligatorii(2013, 11, angajat,"CASS", venitBrut);
			Double somaj = salarizareSrvInstance.calculRetineriObligatorii(2013, 11, angajat,"SOMAJ", venitBrut);
			salarizareSrvInstance.calculImpozit(2013, 11, angajat, venitBrut, cas, cass, somaj, retineriAlte, deduceri);
		}
		logger.info("Sfarsit test: calculImpozitAngajat");
	}
	

	public void calculDeduceriAngajati() throws Exception {
		logger.info("Start test: calculDeduceriAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
		salarizareSrvInstance.calculDeduceri(2013, 11, angajat);
		}
		logger.info("Sfarsit test: calculDeduceriAngajat");
	}
	

	public void testinregistrarStatSalariiLuna() throws Exception {
		logger.info("Start test: inregistrareStatSalariiLuna");
		salarizareSrvInstance.inregistrarStatSalariiLuna(2013, 11);
		logger.info("Sfarsit test: inregistrareStatSalariiLuna");
	}
	

	public void testInregistrareSpor() throws Exception {
		logger.info("Start test: inregistrareSpor");
		Angajat angajat = personalSrvInstance.getAngajatById(1);
		Sporuri spor = salarizareSrvInstance.inregistrareSpor(555,"Bonus", 1, 2013, 11, angajat, 1, 100.0);
		assertNotNull("Metoda de creare a sporului nu a functionat!", spor);
		
		logger.info("V test: inregistrareSpor");
	}
	

	public void testInregistrareRetinere() throws Exception {
		logger.info("Start test: inregistrareRetinere");
		Angajat angajat = personalSrvInstance.getAngajatById(1);
		Retineri retinere = salarizareSrvInstance.inregistrareRetinere(555,"Penalizare", 1, 2013, 11, angajat, 1, 100.0);
		assertNotNull("Metoda de creare a retinerii nu a functionat!", retinere);
		
		logger.info("Sfarsit test: inregistrareRetinere");
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

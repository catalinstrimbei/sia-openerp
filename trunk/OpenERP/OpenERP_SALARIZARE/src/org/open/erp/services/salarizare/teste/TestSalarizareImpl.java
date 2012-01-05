package org.open.erp.services.salarizare.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.ejb.EJB;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.*;
import org.open.erp.services.salarizare.*;
import org.open.erp.services.salarizare.impl.RegistruSalarizare;

public class TestSalarizareImpl {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestSalarizareImpl.class.getName());
	SalarizareSrv salarizareSrvInstance;
	
	@EJB(mappedName="PersonalImpl/local")
	PersonalSrv personalSrvInstance;
	
	RegistruSalarizare registruSalarizare;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		logger.info("initTest");
		salarizareSrvInstance= SalarizareFactory.getSalarizareSrv();
		personalSrvInstance = SalarizareFactory.getPersonalSrv();
		registruSalarizare = SalarizareFactory.getRegistruSalarizare();
		logger.info("initTest");		
	}

	@Test
	public void testInregistrarePontaj() throws Exception {
		logger.info("Begin test: inregistrarePontaj");
		Angajat angajat = personalSrvInstance.getAngajatById(1);
		Pontaj pontaj = salarizareSrvInstance.inregistrarePontaj(angajat, 2011, 11, 160.0, 0.0, 0.0);
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
	public void calculSporuriAngajati() {
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
	public void calculRetineriAngajati() {
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
	public void calculVenitBrutAngajati() {
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
	public void calculRetineriObligatoriiAngajati() {
		logger.info("Begin test: calculRetineriObligatoriiAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
		salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"CAS");
		salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"CASS");
		salarizareSrvInstance.calculRetineriObligatorii(2011, 11, angajat,"SOMAJ");		
		}
		logger.info("End test: calculRetineriObligatoriiAngajat");
	}
	
	@Test
	public void calculImpozitAngajati() {
		logger.info("Begin test: calculImpozitAngajat");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(personalSrvInstance.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
		salarizareSrvInstance.calculImpozit(2011, 11, angajat);
		}
		logger.info("End test: calculImpozitAngajat");
	}
	
	@Test
	public void calculDeduceriAngajati() {
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
	public void testinregistrarStatSalariiLuna() {
		logger.info("Begin test: inregistrareStatSalariiLuna");
		salarizareSrvInstance.inregistrarStatSalariiLuna(2011, 11);
		logger.info("End test: inregistrareStatSalariiLuna");
	}
	
	@Test
	public void testInregistrareSpor() throws Exception {
		logger.info("Begin test: inregistrareSpor");
		Angajat angajat = personalSrvInstance.getAngajatById(1);
		Spor spor = salarizareSrvInstance.inregistrareSpor("Bonus", 1, 2011, 11, angajat, 1, 100.0);
		assertNotNull("Metoda de creere a pontajului nu a functionat!", spor);
		
		logger.info("End test: inregistrareSpor");
	}
	
	@Test
	public void testInregistrareRetinere() {
		logger.info("Begin test: inregistrareRetinere");
		Angajat angajat = personalSrvInstance.getAngajatById(1);
		Retinere retinere = salarizareSrvInstance.inregistrareRetinere("Penalizare", 1, 2011, 11, angajat, 1, 100.0);
		assertNotNull("Metoda de creere a pontajului nu a functionat!", retinere);
		
		logger.info("End test: inregistrareRetinere");
	}
}

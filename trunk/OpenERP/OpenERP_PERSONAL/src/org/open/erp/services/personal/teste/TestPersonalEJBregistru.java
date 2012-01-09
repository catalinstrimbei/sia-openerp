/**
 * 
 */
package org.open.erp.services.personal.teste;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.UserTransaction;

import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.logger.*;
import org.open.erp.services.personal.*;

/**
 * @author Tolic
 *
 */
public class TestPersonalEJBregistru {

	/**
	 * @throws java.lang.Exception
	 */
	/* Resurse test*/
	private static PersonalLogger logger;
	
	/* Unitatea de test sursa/gazda unitatii de test */
	private static PersonalSrv personalInstance;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger = new PersonalLogger();
		InitialContext ctx = initJBossJNDICtx();
		personalInstance = (PersonalSrv)ctx.lookup("PersonalSrv/remote");		
		logger.logINFO("initTest " + personalInstance);
	
	}

	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}	

	@Test
	public void testFunctieById() throws Exception {
		Functie functie = personalInstance.getFunctieById(101);
		System.out.println("Nume functie: " + functie.getNumeFunctie().toString());
	}

	
	
	@Test	
	public void testInserari1() throws Exception {
		try
		{
			logger.logINFO("Begin test: Inserari1");			
			TestPersonalImpl test = new TestPersonalImpl();
			test.generareAnunturi();
			test.initEvenimenteActivitati();		
			
			Angajat	angajat = personalInstance.salveazaAngajat(test.angajat1);			
			ActivitateTeamBuilding	activitateTeamBld = personalInstance.salveazaActivitateTeamBuilding((ActivitateTeamBuilding)test.activitate1);		
			Functie functie = personalInstance.salveazaFunctie(test.functie1);				
			Interviu interviu = personalInstance.salveazaInterviu(test.interviu1);
			ProbaEvaluare	proba = personalInstance.salveazaProbaEvaluare(test.probaEvaluare1);
			
			logger.logINFO("End test: Inserari1");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	@Test	
	public void testInserari2() throws Exception {
		try
		{
			logger.logINFO("Begin test: Inserari2");			
			TestPersonalImpl test = new TestPersonalImpl();
			test.generareAnunturi();
			test.initEvenimenteActivitati();		
			
			Angajat	angajat = personalInstance.getAngajatById(1);
			InterviuCandidat	interviuCandidat = test.interviuCandidat1;
			Candidat candidat = personalInstance.getCandidatById(1);
			interviuCandidat.setCandidat(candidat);
			Interviu interviu = personalInstance.getInterviuById(3);
			interviuCandidat.setInterviu(interviu);
			interviuCandidat = personalInstance.salveazaInterviuCandidat(interviuCandidat);
			
			DosarAngajat	dosar = test.dosar1;
			dosar.setAngajat(angajat);
			dosar = personalInstance.salveazaDosarAngajat(dosar);																			
			
			logger.logINFO("End test: Inserari2");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	@Test	
	public void testInserari2a() throws Exception {
		try
		{
			logger.logINFO("Begin test: Inserari2a");			
			TestPersonalImpl test = new TestPersonalImpl();
			test.generareAnunturi();
			test.initEvenimenteActivitati();							
			
			AnuntLocMunca	anunt = personalInstance.salveazaAnuntLocMunca(test.anunt1);
			
			RezultatProbaEvaluare rezProbaEval = personalInstance.salveazaRezultatProbaEvaluare(test.angajatProbaEvaluare1);													
			
			logger.logINFO("End test: Inserari2a");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	@Test	
	public void testInserari3() throws Exception {
		try
		{
			logger.logINFO("Begin test: Inserari3");			
			TestPersonalImpl test = new TestPersonalImpl();
			test.generareAnunturi();
			test.initEvenimenteActivitati();						
			
			CV	cv = personalInstance.salveazaCV(test.cv1);														
			ContractMunca	contract = personalInstance.salveazaContractMunca(test.contract1);				
			
			logger.logINFO("End test: Inserari3");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	@Test	
	public void testInserari4() throws Exception {
		try
		{
			logger.logINFO("Begin test: Inserari4");			
			TestPersonalImpl test = new TestPersonalImpl();
			test.generareAnunturi();
			test.initEvenimenteActivitati();		
			
			CerereDemisie		cerereDemisie = personalInstance.salveazaCerereDemisie(test.cerereDemisie1);					
			ActivitateTraining	activitateTraining = personalInstance.salveazaActivitateTraining((ActivitateTraining)test.activitate2);		
			Eveniment	eveniment1 = personalInstance.salveazaEveniment(test.eveniment1);
			Eveniment	eveniment2 = personalInstance.salveazaEveniment(test.eveniment2);
			
			logger.logINFO("End test: Inserari4");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	@Test	
	public void testInserari() throws Exception {
		try
		{
		logger.logINFO("Begin test: Inserari");			
		TestPersonalImpl test = new TestPersonalImpl();
		test.generareAnunturi();
		test.initEvenimenteActivitati();		
		
		Angajat	angajat = personalInstance.salveazaAngajat(test.angajat1);			
		ActivitateTeamBuilding	activitateTeamBld = personalInstance.salveazaActivitateTeamBuilding((ActivitateTeamBuilding)test.activitate1);
		
		Functie functie = personalInstance.salveazaFunctie(test.functie1);		
		//Candidat candidat = personalInstance.salveazaCandidat(test.candidat1);		
		CV	cv = personalInstance.salveazaCV(test.cv1);
		
		Interviu interviu = personalInstance.salveazaInterviu(test.interviu1);
		InterviuCandidat	interviuCandidat = personalInstance.salveazaInterviuCandidat(test.interviuCandidat1);
		AnuntLocMunca	anunt = personalInstance.salveazaAnuntLocMunca(test.anunt1);
		ProbaEvaluare	proba = personalInstance.salveazaProbaEvaluare(test.probaEvaluare1);
		
		ContractMunca	contract = personalInstance.salveazaContractMunca(test.contract1);
		DosarAngajat	dosar = personalInstance.salveazaDosarAngajat(test.dosar1);
		RezultatProbaEvaluare rezProbaEval = personalInstance.salveazaRezultatProbaEvaluare(test.angajatProbaEvaluare1);
		CerereDemisie		cerereDemisie = personalInstance.salveazaCerereDemisie(test.cerereDemisie1);			
		
		//ActivitateTeamBuilding	activitateTeamBld = personalInstance.salveazaActivitateTeamBuilding((ActivitateTeamBuilding)test.activitate1);
		ActivitateTraining	activitateTraining = personalInstance.salveazaActivitateTraining((ActivitateTraining)test.activitate2);
		
		Eveniment	eveniment1 = personalInstance.salveazaEveniment(test.eveniment1);
		Eveniment	eveniment2 = personalInstance.salveazaEveniment(test.eveniment2);
		
		logger.logINFO("End test: Inserari");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	
}

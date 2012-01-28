/**
 * 
 */
package org.open.erp.services.personal.teste;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
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
@SuppressWarnings("unused")
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
		Functie functie = personalInstance.getFunctieById(3);
		if(functie != null)
			System.out.println("Nume functie: " + functie.getNumeFunctie().toString());
	}
	@SuppressWarnings("deprecation")
	@Test	
	public void testInserari() throws Exception {
		try
		{
			logger.logINFO("Begin test: Inserari");			
						
			
			TestPersonalImpl test = new TestPersonalImpl();
			test.generareAnunturi();
			test.initEvenimenteActivitati();		
			
			//DummyDepartament departament1 = new DummyDepartament(null, "Departament1", "atributiile vietii");
			
			Angajat	angajat = new Angajat();
			angajat.setActiv(false);
			angajat.setNume(test.angajat1.getNume());
			angajat = personalInstance.salveazaAngajat(test.angajat1);			
			Angajat	angajat2 = personalInstance.salveazaAngajat(test.angajat2);	
			
			Functie functie = personalInstance.salveazaFunctie(test.functie1);				
			Interviu interviu = personalInstance.salveazaInterviu(test.interviu1);
			
			ProbaEvaluare	proba = personalInstance.salveazaProbaEvaluare(test.probaEvaluare1);
						
			DosarAngajat	dosar = test.dosar1;
			dosar.setAngajat(angajat);
			dosar = personalInstance.salveazaDosarAngajat(dosar);	
			
			
			InterviuCandidat	interviuCandidat = new InterviuCandidat();
			Candidat candidat = personalInstance.getCandidatById(1);
			Candidat candidat2 = new Candidat();
			candidat2.setGen('M');
			candidat2.setNume("Nume2");
			candidat2.setTipCandidat("Intern");
			//candidat2.setId(33);
			candidat2.setIdCandidat(104);
			candidat2 = personalInstance.salveazaCandidat(candidat2);
			interviuCandidat.setCandidat(candidat);			
			interviuCandidat.setInterviu(interviu);
			
			interviuCandidat.setRezultatEvaluare("ADMIS");
			interviuCandidat.setDataInterviu(new Date("11/08/2011"));
			
			interviuCandidat = personalInstance.salveazaInterviuCandidat(interviuCandidat);		
			
			AnuntLocMunca	anunt = test.anunt1;
			anunt.setFunctie(functie);
			anunt = personalInstance.salveazaAnuntLocMunca(anunt);
			
			RezultatProbaEvaluare rezProbaEval = test.angajatProbaEvaluare1;						
			rezProbaEval.setAngajat(angajat);				
			rezProbaEval.setProbaEvaluare(proba);			
			rezProbaEval = personalInstance.salveazaRezultatProbaEvaluare(rezProbaEval);	
		
			CV	cv = test.cv1;
			cv.setCandidat(candidat);
			cv.setFunctieVizata(functie);
			cv = personalInstance.salveazaCV(cv);					
			
			cv.setCandidat(candidat2);
			cv.setNrCV(null);
			cv = personalInstance.salveazaCV(cv);
			
			ContractMunca	contract = test.contract1;
			contract.setAngajat(angajat);
			contract.setFunctie(functie);
			contract = personalInstance.salveazaContractMunca(contract);
			
			ContractMunca	contract2 = test.contract2;
			contract2.setAngajat(angajat);
			contract2.setFunctie(functie);
			contract2 = personalInstance.salveazaContractMunca(contract2);
			
			CerereDemisie		cerereDemisie = test.cerereDemisie1;
			cerereDemisie.setContract(contract);
			cerereDemisie = personalInstance.salveazaCerereDemisie(cerereDemisie);		
			
			Eveniment	eveniment1 = test.eveniment1;
			eveniment1.setActivitati(null);
			eveniment1 = personalInstance.salveazaEveniment(eveniment1);
			
			Eveniment	eveniment2 = test.eveniment2;
			eveniment2.setActivitati(null);
			eveniment2 = personalInstance.salveazaEveniment(eveniment2);
						
			ActivitateTraining	activitateTraining = new ActivitateTraining();
			activitateTraining.setDescriereActivitate("Training 1");
			activitateTraining.setLocatie("Locatie training 1");
			activitateTraining.setSumaEstimata(100.00);
			activitateTraining.setEveniment(eveniment1);
			activitateTraining = personalInstance.salveazaActivitateTraining(activitateTraining);		
			
			ActivitateTeamBuilding	activitateTeam = new ActivitateTeamBuilding();
			activitateTeam.setDescriereActivitate("TeamBuilding 1");
			activitateTeam.setLocatie("Locatie TeamBuilding 1");
			activitateTeam.setSumaEstimata(200.00);
			activitateTeam.setEveniment(eveniment2);
			activitateTeam = personalInstance.salveazaActivitateTeamBuilding(activitateTeam);
						
			logger.logINFO("End test: Inserari");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}				
	
}

package org.open.erp.services.personal.teste;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.Anunt;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.DoubleParam;
import org.open.erp.services.personal.Interviu;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.Post;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.Tuple;

public class TestPersonalSrv {
	private static Logger logger;
	PersonalSrv instantaPersonal;
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestPersonalSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		instantaPersonal = PersonalSrvFactory.getPersonalSrv();
		logger.info("Serviciul PersonalSrv a fost instantiat pentru testare!");
	}
	
	@Test
	public void testCrearePersonal() throws Exception{
		logger.setLevel(Level.DEBUG);
		
		logger.info("Inceput testare TestPersonalSrv!");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE,15);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.YEAR, 2012);
		
		Date dataEmitere = cal.getTime();
		cal.add(Calendar.DATE, 10);
		Date dataExpirare = cal.getTime();
		
		Post postLiber = instantaPersonal.crearePost("Medii", 2000);
		Anunt anuntNou = instantaPersonal.creareAnunt("Responsabil resurse umane", 122025, dataEmitere, dataExpirare, "Organizat, bune abilitati de comunicare", postLiber);
		assertNotNull("Nu exista un anunt nou!", anuntNou);
		
		Candidat candidatNou = instantaPersonal.creareCandidat("Ionescu", "Daniel", "str. Prof. Irimescu nr. 8", "0232/115874", "danielIon@yahoo.com", new Date(), 'F');
		assertNotNull("Nu exista un candidat nou!", candidatNou);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.DATE,1);
		cal2.set(Calendar.MONTH, Calendar.OCTOBER);
		cal2.set(Calendar.YEAR, 2007);
		Calendar cal3 = Calendar.getInstance();
		cal3.set(Calendar.DATE,29);
		cal3.set(Calendar.MONTH, Calendar.JULY);
		cal3.set(Calendar.YEAR, 2010);
		
		Tuple<String,Date,Date> studiiAbsolvite = new Tuple<String,Date,Date>();
		studiiAbsolvite.denInstitutie = "Facultatea de Management";
		studiiAbsolvite.dataInceput = cal2.getTime();
		studiiAbsolvite.dataSfarsit = cal3.getTime();
		
		Tuple<String,Date,Date> functiiOcupate = new Tuple<String,Date,Date>();
		functiiOcupate.denInstitutie = "SC. FIRMA";
		functiiOcupate.dataInceput = new Date();
		functiiOcupate.dataSfarsit = new Date();
		
		DoubleParam<String,String> limbiStraine = new DoubleParam<String,String>();
		limbiStraine.limbaStraina = "Franceza";
		limbiStraine.nivelulDeCunoastere = "C1";
		
		CV cvCandidat = instantaPersonal.creareCV(candidatNou, studiiAbsolvite, functiiOcupate, limbiStraine, "organizat");
		assertNotNull("Nu exista un CV nou!", cvCandidat);
		
		logger.debug("Afisarea nivelului pentru limba straina");
		logger.debug("Nivel: " + cvCandidat.getLimbiStraine().getNivelulDeCunoastere().toString());
		
		ProbaEvaluare proba1 = instantaPersonal.creareProbaEvaluare("Proba1");
		ProbaEvaluare proba2 = instantaPersonal.creareProbaEvaluare("Proba2");
		
		Angajat evaluator = instantaPersonal.creareAngajat();
		
		List<Angajat> evaluatori = new ArrayList<Angajat>();
		evaluatori.add(evaluator);
		
		List<ProbaEvaluare> probeInterviu = new ArrayList<ProbaEvaluare>();
		probeInterviu.add(proba1);
		probeInterviu.add(proba2);
		
		Interviu interviuCandidati = instantaPersonal.creareInterviu(anuntNou, evaluatori, probeInterviu, new Date());
		interviuCandidati.adaugareCandidat(candidatNou);
		interviuCandidati.stabilireRezultateInterviu(candidatNou, proba1, 8);
		interviuCandidati.stabilireRezultateInterviu(candidatNou, proba2, 6);
		
		logger.debug("Afisarea rezultatului pentru "+proba2.getNumeTest());
		logger.debug("Rezultat: " + candidatNou.getRezultatLaTeste().get(proba2));
		
		logger.info("Sfarsit Test TestPersonalSrv!");
	}
}

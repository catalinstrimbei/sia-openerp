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
import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.Anunt;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.ContractMunca;
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
		
		
		Post postLiber = instantaPersonal.crearePost("Medii", 2000, new Departament("1","Finante"));
		Anunt anuntNou = instantaPersonal.creareAnunt("Responsabil resurse umane", 122025, dataEmitere, dataExpirare, "Organizat, bune abilitati de comunicare", postLiber);
		assertNotNull("Nu exista un anunt nou!", anuntNou);
		
		Candidat candidatNou = instantaPersonal.creareCandidat(1234,"Ionescu Daniel", "M", "danielIon@yahoo.com", "Candidat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"));
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
		
		List<Tuple<String,Date,Date>> studiiAbs = new ArrayList<Tuple<String,Date,Date>>();
		studiiAbs.add(studiiAbsolvite);
		
		List<Tuple<String,Date,Date>> functiiOcup = new ArrayList<Tuple<String,Date,Date>>();
		studiiAbs.add(functiiOcupate);
		
		List<DoubleParam<String,String>> lStraine = new ArrayList<DoubleParam<String,String>>();
		lStraine.add(limbiStraine);
		
		CV cvCandidat = instantaPersonal.creareCV(candidatNou, studiiAbs, functiiOcup, lStraine, "organizat");
		assertNotNull("Nu exista un CV nou!", cvCandidat);
		
				
		ProbaEvaluare proba1 = instantaPersonal.creareProbaEvaluare("Proba1");
		ProbaEvaluare proba2 = instantaPersonal.creareProbaEvaluare("Proba2");
		
		Angajat evaluator = instantaPersonal.creareAngajat(1234,"Ionescu Daniel", "M", "danielIon@yahoo.com", "Angajat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"),  new ContractMunca (1500, 23, new Date(), "nedeterminata", 0, 8, postLiber, 200));
		
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
		
		
		Candidat candidatNou2 = instantaPersonal.creareCandidat(1235,"Ionescu Florin", "M", "danielIon@yahoo.com", "Candidat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"));
		assertNotNull("Nu exista un candidat nou!", candidatNou2);
		
		Interviu interviuCandidati2 = instantaPersonal.creareInterviu(anuntNou, evaluatori, probeInterviu, new Date());
		interviuCandidati2.adaugareCandidat(candidatNou2);
		interviuCandidati2.stabilireRezultateInterviu(candidatNou2, proba1, 3);
		interviuCandidati2.stabilireRezultateInterviu(candidatNou2, proba2, 4);
		
		List<Candidat> listacandidati=new ArrayList<Candidat>();
		listacandidati.add(candidatNou);
		listacandidati.add(candidatNou2);
		
		int notaMax = 0;
		int rezultat1 =0;
		int rezultat2 =0;
		Candidat deAngajat = new Candidat(null,null,null,null,null,null,null,null,null);
		for (Candidat c:listacandidati){
			rezultat1 = c.getRezultatLaTeste().get(proba1);
			if(rezultat1>notaMax){
				notaMax = rezultat1;
				deAngajat = c;
			}
			rezultat2 = c.getRezultatLaTeste().get(proba2);
			if(rezultat2>notaMax){
				notaMax = rezultat2;
				deAngajat = c;
			}
		}
		
		Angajat angajatNou = instantaPersonal.creareAngajat(deAngajat.getId(),deAngajat.getNume(),deAngajat.getSex(),deAngajat.getMail(),deAngajat.getStatutInCompanie(),deAngajat.getStareCivila(),deAngajat.getDataNastere(),deAngajat.getTelefon(),deAngajat.getAdresa(),  new ContractMunca (1500, 23, new Date(), "nedeterminata", 0, 8, postLiber, 200));
		
		
		
	}
}

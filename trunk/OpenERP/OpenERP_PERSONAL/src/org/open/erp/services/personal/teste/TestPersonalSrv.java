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
import org.open.erp.services.personal.CerereConcediu;
import org.open.erp.services.personal.CerereEveniment;
import org.open.erp.services.personal.Concedii;
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
		
		
		Post postLiber = instantaPersonal.crearePost(1, "Medii", 2000, new Departament("1","Finante"));
		Anunt anuntNou = instantaPersonal.creareAnunt(1, "Responsabil resurse umane", 122025, dataEmitere, dataExpirare, "Organizat, bune abilitati de comunicare", postLiber);
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
		
		CV cvCandidat = instantaPersonal.creareCV(1, candidatNou, studiiAbs, functiiOcup, lStraine, "organizat");
		assertNotNull("Nu exista un CV nou!", cvCandidat);
		
				
		ProbaEvaluare proba1 = instantaPersonal.creareProbaEvaluare(1, "Proba1");
		ProbaEvaluare proba2 = instantaPersonal.creareProbaEvaluare(2, "Proba2");
		
		Angajat evaluator = instantaPersonal.creareAngajat(1234,"Ionescu Daniel", "M", "danielIon@yahoo.com", "Angajat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"),  new ContractMunca (1500, 23, new Date(), "nedeterminata", 0, 8, postLiber, 200));
		
		List<Angajat> evaluatori = new ArrayList<Angajat>();
		evaluatori.add(evaluator);
		
		List<ProbaEvaluare> probeInterviu = new ArrayList<ProbaEvaluare>();
		probeInterviu.add(proba1);
		probeInterviu.add(proba2);
		
		Interviu interviuCandidati = instantaPersonal.creareInterviu(1, anuntNou, evaluatori, probeInterviu, new Date());
		interviuCandidati.adaugareCandidat(candidatNou);
		interviuCandidati.stabilireRezultateInterviu(candidatNou, proba1, 8);
		interviuCandidati.stabilireRezultateInterviu(candidatNou, proba2, 6);
		
		logger.debug("Afisarea rezultatului pentru "+proba2.getNumeTest());
		logger.debug("Rezultat: " + candidatNou.getRezultatLaTeste().get(proba2));
		
			
		Candidat candidatNou2 = instantaPersonal.creareCandidat(1235,"Ionescu Florin", "M", "danielIon@yahoo.com", "Candidat","necasatorit", "01/06/1980","0232/115874", new Adresa("1","Iasi","Iasi","Romania","x","007891"));
		assertNotNull("Nu exista un candidat nou!", candidatNou2);
		
		Interviu interviuCandidati2 = instantaPersonal.creareInterviu(2, anuntNou, evaluatori, probeInterviu, new Date());
		interviuCandidati2.adaugareCandidat(candidatNou2);
		interviuCandidati2.stabilireRezultateInterviu(candidatNou2, proba1, 3);
		interviuCandidati2.stabilireRezultateInterviu(candidatNou2, proba2, 4);
		
		List<Candidat> listacandidati=new ArrayList<Candidat>();
		listacandidati.add(candidatNou);
		listacandidati.add(candidatNou2);
		
		int notaMax = 0;
		int rezultat1 =0;
		int rezultat2 =0;
		Candidat deAngajat = null;
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
		
		logger.info("Angajat ales dupa interviuri:");
		logger.info("Nume: "+angajatNou.getNume());
		
		
		Calendar cal4 = Calendar.getInstance();
		cal4.set(Calendar.DATE,25);
		cal4.set(Calendar.MONTH, Calendar.OCTOBER);
		cal4.set(Calendar.YEAR, 2013);
		
		Calendar cal5= Calendar.getInstance();
		cal5.set(Calendar.DATE,25);
		cal5.set(Calendar.MONTH, Calendar.OCTOBER);
		cal5.set(Calendar.YEAR, 2013);
		
		CerereConcediu cerereNoua = new CerereConcediu(1005, angajatNou,new Date(), null, cal4.getTime(), cal5.getTime(), "Odihna","In asteptare");
		
		cerereNoua.setStatus("Acceptat");
		cerereNoua.setDataAprobare(cal5.getTime());
		
		Concedii con = null;
		if (cerereNoua.getStatus().equals("Acceptat")){
			con = new Concedii(cerereNoua.getNrInregistrare(),cerereNoua.getAngajat(),cerereNoua.getDataInceputConcediu(), cerereNoua.getDataSfarsitConcediu(), cerereNoua.gettipConcediu());
		}
		
		logger.info("Concediu inregistrat:");
		logger.info("Tip concediu: "+ con.gettipConcediu());
		
		Calendar cal6= Calendar.getInstance();
		cal6.set(Calendar.DATE,25);
		cal6.set(Calendar.MONTH, Calendar.OCTOBER);
		cal6.set(Calendar.YEAR, 2013);
		
		Calendar cal7= Calendar.getInstance();
		cal7.set(Calendar.DATE,25);
		cal7.set(Calendar.MONTH, Calendar.OCTOBER);
		
		CerereEveniment cerereEv = new CerereEveniment(2007, evaluator,	new Date(), null, cal6.getTime(),cal7.getTime(), "Party", "In steptare", 5000);
		
		cerereEv.setStatus("Acceptat");
		
		logger.info("Eveniment inregistrat:");
		logger.info("Suma eveniment: "+ cerereEv.getSumaEveniment());
		
		logger.info("Sfarsit Test TestPersonalSrv!");
		
		
	}
}

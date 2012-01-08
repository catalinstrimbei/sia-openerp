package org.open.erp.services.personal.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Collection;

//TODO uncomment this
//import org.open.erp.services.nomgen.Departament;
//import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.personal.DummyDepartament;
import org.open.erp.services.personal.DummyPersoanaFizica;
import org.open.erp.services.personal.Activitate;
import org.open.erp.services.personal.ActivitateTeamBuilding;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.RezultatProbaEvaluare;
import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.CerereDemisie;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.DosarAngajat;
import org.open.erp.services.personal.Eveniment;
import org.open.erp.services.personal.Functie;
import org.open.erp.services.personal.InstructorTraining;
import org.open.erp.services.personal.Interviu;
import org.open.erp.services.personal.InterviuCandidat;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.impl.PersonalImpl;

public class TestPersonalImpl {
	DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	
	PersonalImpl personalService = new PersonalImpl();
	
	Date dataAnunt;
	
	
	
	Collection<AnuntLocMunca> ListaAnunturi = new ArrayList<AnuntLocMunca>();
	Collection<AnuntLocMunca> ListaAnunturi2 = new ArrayList<AnuntLocMunca>();
	public Collection<CV> ListaCandidati = new ArrayList<CV>();
	Collection<Candidat> ListaCandidati2 = new ArrayList<Candidat>();
	Collection<Candidat> ListaCandidati3 = new ArrayList<Candidat>();

	Collection<InterviuCandidat> ListaInterviuri = new ArrayList<InterviuCandidat>();
	Collection<InterviuCandidat> ListaInterviuri2 = new ArrayList<InterviuCandidat>();

	//Collection Narcisa
	Collection<InstructorTraining>  instructori = new ArrayList<InstructorTraining>();//NMV adaugare Lista noua pentru instructoriTraining
	Collection<Activitate> activitati = new ArrayList<Activitate>();//NMV adaugare Lista noua pentru Activitati;
	
	//Creare evenimente
	Eveniment eveniment1 = new Eveniment("EV1", "Training", 1200.00);
	Eveniment eveniment2 = new Eveniment("EV2", "TeamBuilding", 1200.00);
	
	// Activitati
	Activitate activitate1;
	Activitate activitate2;
	Activitate activitate3;
	
	Collection<DummyDepartament> ListaDepartamente = new ArrayList<DummyDepartament>();
	Collection<ProbaEvaluare> probeEvaluare = new ArrayList<ProbaEvaluare>();
	
	public Collection<Angajat> angajati = new ArrayList<Angajat>();
	public Collection<ContractMunca> contracteMunca	= new ArrayList<ContractMunca>();
	public Collection<DosarAngajat>  dosareAngajati = new ArrayList<DosarAngajat>();
	Collection<RezultatProbaEvaluare> ListaRezultateProbe = new ArrayList<RezultatProbaEvaluare>();
	
	Functie functie1 = new Functie(1001, "Functie1");
	Functie functie2 = new Functie(1002, "Functie2");
	Functie functie3 = new Functie(1003, "Functie3");
	Candidat candidat1 = new Candidat(1, "Nume1", "Prenume1", 101, null);
	Candidat candidat2 = new Candidat(2, "Nume2", "Prenume2", 102, null);
	Candidat candidat3 = new Candidat(3, "Nume3", "Prenume3", 103, null);
	Candidat candidat4 = new Candidat(4, "Nume4", "Prenume4", 104, null);
	Candidat candidat5 = new Candidat(5, "Nume5", "Prenume5", 104, null);
	Candidat candidat6 = new Candidat(6, "Nume6", "Prenume6", 105, null);
	CV cv1 = new CV("CV1", candidat1, functie1, new Date("10/08/2011"));
	CV cv2 = new CV("CV2", candidat2, functie1, new Date("10/09/2011"));
	CV cv3 = new CV("CV3", candidat3, functie1, new Date("01/08/2011"));
	CV cv4 = new CV("CV4", candidat4, functie1, new Date("01/08/2011"));
	CV cv5 = new CV("CV5", candidat5, functie2, new Date("01/08/2011"), new Date("10/09/2011"));
	CV cv6 = new CV("CV6", candidat6, functie1, new Date("10/08/2011"));
	CV cv7 = new CV("CV7", candidat6, functie2, new Date("10/08/2011"), new Date("20/11/2011"));
	
	
	DummyPersoanaFizica persoana1 = new DummyPersoanaFizica(1,null,  "Nume1", "Prenume1", null, 'M', null);
	DummyPersoanaFizica persoana2 = new DummyPersoanaFizica(2,null,  "Nume2", "Prenume2", null, 'F', null);
	
	
	Interviu interviu1 = new Interviu(1, "Final");
	Interviu interviu2 = new Interviu(2, "Intermediar");
	Interviu interviu3 = new Interviu(3, "Final");
	Interviu interviu4 = new Interviu(4, "Intermediar");
	
	InterviuCandidat interviuCandidat1 = new InterviuCandidat(1, candidat1, new Date("11/08/2011"), "ADMIS", interviu1);
	InterviuCandidat interviuCandidat2 = new InterviuCandidat(2, candidat2, new Date("11/08/2011"), "RESPINS", interviu1);
	InterviuCandidat interviuCandidat3 = new InterviuCandidat(3, candidat3, new Date("11/08/2011"), "ADMIS", interviu2);



	
	AnuntLocMunca anunt1 = new AnuntLocMunca(1, new String[] { "Internet"}, "Anunt1", functie1, new Date("01/08/2011"), new Date("11/09/2011"));
	AnuntLocMunca anunt3 = new AnuntLocMunca(3, new String[] { "Internet"}, "Anunt3", functie2, new Date("01/08/2011"), new Date("11/09/2011"));
	AnuntLocMunca anunt2 = new AnuntLocMunca(1, new String[] { "Internet"}, "Anunt2", functie1, new Date("12/09/2011"), new Date("10/12/2011"));
	
	DummyDepartament departament1 = new DummyDepartament(1, "Departament1", null);
	DummyDepartament departament2 = new DummyDepartament(2, "Departament2", null);
	DummyDepartament departament3 = new DummyDepartament(3, "Departament3", null);
	
	ProbaEvaluare	probaEvaluare1 = new ProbaEvaluare("Proba1", "Oral", "EvaluarePeriodica", departament1);
	ProbaEvaluare	probaEvaluare2 = new ProbaEvaluare("Proba2", "Practic", "EvaluarePeriodica", departament1);
	ProbaEvaluare	probaEvaluare3 = new ProbaEvaluare("Proba3", "Scris", "EvaluarePeriodica", departament2);
	ProbaEvaluare	probaEvaluare4 = new ProbaEvaluare("Proba4", "Oral", "EvaluarePeriodica", departament2);
	ProbaEvaluare	probaEvaluare5 = new ProbaEvaluare("Proba5", "Scris", "EvaluarePeriodica", departament3);
	ProbaEvaluare	probaEvaluare6 = new ProbaEvaluare("Proba6", "Practic", "Test", departament1);
	
	//Angajat	angajat2 = new Angajat ()
	
	
	Angajat 		angajat1 = new Angajat(persoana1.getId(), persoana1.getNume(), persoana1.getPrenume(), candidat1.getIdCandidat(),candidat1.getTipCandidat(), 10001, false);
	Angajat 		angajat2 = new Angajat(persoana2.getId(), persoana2.getNume(), persoana2.getPrenume(), candidat2.getIdCandidat(),candidat2.getTipCandidat(), 10002, true);
	//Angajat 		angajat1 = new Angajat(persoana1.getIdPersoana(), "Nume1", "Prenume1");
	//ContractMunca	contract1 = new ContractMunca("ContractNr0002", angajat1, functie1, new Date("11/08/2011"), new Date("15/08/2011"), null,null);
	
	ContractMunca	contract1 = new ContractMunca("ContractNr0002", 1000.00, 10.00, angajat1, functie1, new Date("01/01/2010"), new Date("01/01/2010"), new Date("15/08/2015"),0,null);
	ContractMunca	contract2 = new ContractMunca("ContractNr0001", 1000.00, 10.00, angajat2, functie1, new Date("11/08/2011"), new Date("15/08/2011"), new Date("15/08/2020"),0,null);

	DosarAngajat dosar1 = new DosarAngajat(1, angajat1, true, true, true);
	DosarAngajat dosar2 = new DosarAngajat(2, angajat2, null, null, null);
	
	RezultatProbaEvaluare angajatProbaEvaluare1 = new RezultatProbaEvaluare(angajat1, "Foarte Bine", null, probaEvaluare1);
	RezultatProbaEvaluare angajatProbaEvaluare2 = new RezultatProbaEvaluare(angajat1, "Bine", null, probaEvaluare2);
	RezultatProbaEvaluare angajatProbaEvaluare3 = new RezultatProbaEvaluare(angajat2, "Bine", null, probaEvaluare3);
	RezultatProbaEvaluare angajatProbaEvaluare4 = new RezultatProbaEvaluare(angajat1, "Satisfacator", null, probaEvaluare3);
	RezultatProbaEvaluare angajatProbaEvaluare5 = new RezultatProbaEvaluare(angajat2, "Foarte Bine", null, probaEvaluare4);
	RezultatProbaEvaluare angajatProbaEvaluare6 = new RezultatProbaEvaluare(angajat2, "Satisfacator", null, probaEvaluare1);
	RezultatProbaEvaluare angajatProbaEvaluare7 = new RezultatProbaEvaluare(angajat1, "Foarte Bine", null, probaEvaluare4);
	RezultatProbaEvaluare angajatProbaEvaluare8 = new RezultatProbaEvaluare(angajat2, "Bine", null, probaEvaluare5);
	
	CerereDemisie	cerereDemisie1 = new CerereDemisie("CerereDem001", contract1, new Date("11/08/2011"), null, null,null);
	
	public void generareAnunturi() {
		ListaCandidati.add(cv1);
		ListaCandidati.add(cv2);
		ListaCandidati.add(cv3);
		ListaCandidati.add(cv4);
		ListaCandidati.add(cv5);
		ListaCandidati.add(cv6);
		ListaCandidati.add(cv7);
		
		ListaAnunturi.add(anunt1);
		ListaAnunturi.add(anunt2);
		ListaAnunturi.add(anunt3);

		ListaAnunturi2 = personalService.getPosturiVacante(new Date("02/08/2011"), ListaAnunturi);
	}
	
	
	void generareCandidati() {
		ListaInterviuri.add(interviuCandidat1);
		ListaInterviuri.add(interviuCandidat2);
		ListaInterviuri.add(interviuCandidat3);
		
	}
	
	void generareDepartamente(){
		ListaDepartamente.add(departament1);
		ListaDepartamente.add(departament2);
		ListaDepartamente.add(departament3);
	}
	
	void generareProbeEvaluare(){
		probeEvaluare.add(probaEvaluare1);
		probeEvaluare.add(probaEvaluare2);
		probeEvaluare.add(probaEvaluare3);
		probeEvaluare.add(probaEvaluare4);
		probeEvaluare.add(probaEvaluare5);
		probeEvaluare.add(probaEvaluare6);
	}
	
	public void ListaAngajati(){
		angajati.add(angajat1);
		angajati.add(angajat2);
	}
	public void ListaContracte(){
		contracteMunca.add(contract1);
		contracteMunca.add(contract2);
	}
	
	public void ListaDosare(){
		dosareAngajati.add(dosar1);
		dosareAngajati.add(dosar2);

	}
	
	void generareListaRezultate(){
		ListaRezultateProbe.add(angajatProbaEvaluare1);
		ListaRezultateProbe.add(angajatProbaEvaluare2);
		ListaRezultateProbe.add(angajatProbaEvaluare3);
		ListaRezultateProbe.add(angajatProbaEvaluare4);
		ListaRezultateProbe.add(angajatProbaEvaluare5);
		ListaRezultateProbe.add(angajatProbaEvaluare6);
		ListaRezultateProbe.add(angajatProbaEvaluare7);
		ListaRezultateProbe.add(angajatProbaEvaluare8);
	}
	void initEvenimenteActivitati() throws Exception
	{
		activitate1 = new ActivitateTeamBuilding(1, "In progres", angajati);
		activitate2 = Activitate.construct(eveniment1);
		activitate3 = Activitate.construct(eveniment2);
		
		eveniment1.setSumaAlocata(300.00);
		eveniment2.setSumaAlocata(400.00);
		Calendar date = Calendar.getInstance();
		activitate2.setIdActivitate(2);
		activitate2.setDescriereActivitate("Training 1");
		activitate2.setLocatie("Locatie training 1");
		activitate2.setSumaEstimata(100.00);
		date.set(2009,Calendar.DECEMBER,1);
		activitate2.setDataStart(date.getTime());
		activitate3.setIdActivitate(3);
		activitate3.setDescriereActivitate("TeamBuilding 1");
		activitate3.setLocatie("Locatie TeamBuilding 1");
		activitate3.setSumaEstimata(200.00);
		date.set(2009,Calendar.DECEMBER,5);
		activitate3.setDataStart(date.getTime());		
	}
}

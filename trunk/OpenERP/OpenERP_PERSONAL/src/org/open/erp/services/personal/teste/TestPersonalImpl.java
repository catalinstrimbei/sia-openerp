package org.open.erp.services.personal.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.personal.Activitate;
import org.open.erp.services.personal.ActivitateTeamBuilding;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.AngajatProbaEvaluare;
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
	
	List<AnuntLocMunca> listaAnunturi = new ArrayList<AnuntLocMunca>();
	List<AnuntLocMunca> listaAnunturi2 = new ArrayList<AnuntLocMunca>();
	public List<CV> listaCandidati = new ArrayList<CV>();
	List<Candidat> listaCandidati2 = new ArrayList<Candidat>();
	List<Candidat> listaCandidati3 = new ArrayList<Candidat>();

	List<InterviuCandidat> listaInterviuri = new ArrayList<InterviuCandidat>();
	List<InterviuCandidat> listaInterviuri2 = new ArrayList<InterviuCandidat>();

	//List Narcisa
	List<InstructorTraining>  instructori = new ArrayList<InstructorTraining>();//NMV adaugare Lista noua pentru instructoriTraining
	List<Activitate> activitati = new ArrayList<Activitate>();//NMV adaugare lista noua pentru Activitati;
	
	//Creare evenimente
	Eveniment eveniment1 = new Eveniment("EV1", "Training", 1200.00);
	Eveniment eveniment2 = new Eveniment("EV2", "TeamBuilding", 1200.00);
	
	// Activitati
	Activitate activitate1;
	Activitate activitate2;
	Activitate activitate3;
	
	List<Departament> listaDepartamente = new ArrayList<Departament>();
	List<ProbaEvaluare> probeEvaluare = new ArrayList<ProbaEvaluare>();
	
	public List<Angajat> angajati = new ArrayList<Angajat>();
	public List<ContractMunca> contracteMunca	= new ArrayList<ContractMunca>();
	public List<DosarAngajat>  dosareAngajati = new ArrayList<DosarAngajat>();
	List<AngajatProbaEvaluare> listaRezultateProbe = new ArrayList<AngajatProbaEvaluare>();
	
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
	
	
	PersoanaFizica persoana1 = new PersoanaFizica(1,null, null, "Nume1", "Prenume1", null, 'M', null);
	PersoanaFizica persoana2 = new PersoanaFizica(2,null, null, "Nume2", "Prenume2", null, 'F', null);
	
	
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
	
	Departament departament1 = new Departament(1, "Departament1", null, persoana1);
	Departament departament2 = new Departament(2, "Departament2", null, persoana1);
	Departament departament3 = new Departament(3, "Departament3", null, persoana1);
	
	ProbaEvaluare	probaEvaluare1 = new ProbaEvaluare("Proba1", "Oral", "EvaluarePeriodica", departament1);
	ProbaEvaluare	probaEvaluare2 = new ProbaEvaluare("Proba2", "Practic", "EvaluarePeriodica", departament1);
	ProbaEvaluare	probaEvaluare3 = new ProbaEvaluare("Proba3", "Scris", "EvaluarePeriodica", departament2);
	ProbaEvaluare	probaEvaluare4 = new ProbaEvaluare("Proba4", "Oral", "EvaluarePeriodica", departament2);
	ProbaEvaluare	probaEvaluare5 = new ProbaEvaluare("Proba5", "Scris", "EvaluarePeriodica", departament3);
	ProbaEvaluare	probaEvaluare6 = new ProbaEvaluare("Proba6", "Practic", "Test", departament1);
	
	//Angajat	angajat2 = new Angajat ()
	
	
	Angajat 		angajat1 = new Angajat(persoana1.getId(), persoana1.getNume(), persoana1.getPrenume(), candidat1.getIdCandidat(),candidat1.getTipCandidat(), 10001, true);
	Angajat 		angajat2 = new Angajat(persoana2.getId(), persoana2.getNume(), persoana2.getPrenume(), candidat2.getIdCandidat(),candidat2.getTipCandidat(), 10002, true);
	//Angajat 		angajat1 = new Angajat(persoana1.getIdPersoana(), "Nume1", "Prenume1");
	//ContractMunca	contract1 = new ContractMunca("ContractNr0002", angajat1, functie1, new Date("11/08/2011"), new Date("15/08/2011"), null,null);
	
	ContractMunca	contract1 = new ContractMunca("ContractNr0002", 1000.00, 10.00, angajat1, functie1, new Date("11/08/2011"), new Date("15/08/2011"), null,0,null);
	ContractMunca	contract2 = new ContractMunca("ContractNr0001", 1000.00, 10.00, angajat2, functie1, new Date("11/08/2011"), new Date("15/08/2011"), null,0,null);

	DosarAngajat dosar1 = new DosarAngajat(1, angajat1, null, null, null);
	DosarAngajat dosar2 = new DosarAngajat(2, angajat2, null, null, null);
	
	AngajatProbaEvaluare angajatProbaEvaluare1 = new AngajatProbaEvaluare(angajat1, "Foarte Bine", null, probaEvaluare1);
	AngajatProbaEvaluare angajatProbaEvaluare2 = new AngajatProbaEvaluare(angajat1, "Bine", null, probaEvaluare2);
	AngajatProbaEvaluare angajatProbaEvaluare3 = new AngajatProbaEvaluare(angajat2, "Bine", null, probaEvaluare3);
	AngajatProbaEvaluare angajatProbaEvaluare4 = new AngajatProbaEvaluare(angajat1, "Satisfacator", null, probaEvaluare3);
	AngajatProbaEvaluare angajatProbaEvaluare5 = new AngajatProbaEvaluare(angajat2, "Foarte Bine", null, probaEvaluare4);
	AngajatProbaEvaluare angajatProbaEvaluare6 = new AngajatProbaEvaluare(angajat2, "Satisfacator", null, probaEvaluare1);
	AngajatProbaEvaluare angajatProbaEvaluare7 = new AngajatProbaEvaluare(angajat1, "Foarte Bine", null, probaEvaluare4);
	AngajatProbaEvaluare angajatProbaEvaluare8 = new AngajatProbaEvaluare(angajat2, "Bine", null, probaEvaluare5);
	
	CerereDemisie	cerereDemisie1 = new CerereDemisie("CerereDem001", contract1, new Date("11/08/2011"), null, null,null);
	
	public void generareAnunturi() {
		listaCandidati.add(cv1);
		listaCandidati.add(cv2);
		listaCandidati.add(cv3);
		listaCandidati.add(cv4);
		listaCandidati.add(cv5);
		listaCandidati.add(cv6);
		listaCandidati.add(cv7);
		
		listaAnunturi.add(anunt1);
		listaAnunturi.add(anunt2);
		listaAnunturi.add(anunt3);

		listaAnunturi2 = personalService.getPosturiVacante(new Date("02/08/2011"), listaAnunturi);
	}
	
	
	void generareCandidati() {
		listaInterviuri.add(interviuCandidat1);
		listaInterviuri.add(interviuCandidat2);
		listaInterviuri.add(interviuCandidat3);
		
	}
	
	void generareDepartamente(){
		listaDepartamente.add(departament1);
		listaDepartamente.add(departament2);
		listaDepartamente.add(departament3);
	}
	
	void generareProbeEvaluare(){
		probeEvaluare.add(probaEvaluare1);
		probeEvaluare.add(probaEvaluare2);
		probeEvaluare.add(probaEvaluare3);
		probeEvaluare.add(probaEvaluare4);
		probeEvaluare.add(probaEvaluare5);
		probeEvaluare.add(probaEvaluare6);
	}
	
	public void listaAngajati(){
		angajati.add(angajat1);
		angajati.add(angajat2);
	}
	public void listaContracte(){
		contracteMunca.add(contract1);
	}
	
	public void listaDosare(){
		dosareAngajati.add(dosar1);
		dosareAngajati.add(dosar2);

	}
	
	void generareListaRezultate(){
		listaRezultateProbe.add(angajatProbaEvaluare1);
		listaRezultateProbe.add(angajatProbaEvaluare2);
		listaRezultateProbe.add(angajatProbaEvaluare3);
		listaRezultateProbe.add(angajatProbaEvaluare4);
		listaRezultateProbe.add(angajatProbaEvaluare5);
		listaRezultateProbe.add(angajatProbaEvaluare6);
		listaRezultateProbe.add(angajatProbaEvaluare7);
		listaRezultateProbe.add(angajatProbaEvaluare8);
	}
	void initEvenimenteActivitati() throws Exception
	{
		activitate1 = new ActivitateTeamBuilding(1, "In progres", angajati);
		activitate2 = Activitate.construct(eveniment1);
		activitate3 = Activitate.construct(eveniment2);
		
		eveniment1.setSumaAlocata(300.00);
		eveniment2.setSumaAlocata(400.00);
		Calendar date = Calendar.getInstance();
		activitate2.setIdActivitate("2");
		activitate2.setDescriereActivitate("Training 1");
		activitate2.setLocatie("Locatie training 1");
		activitate2.setSumaEstimata(100.00);
		date.set(2009,Calendar.DECEMBER,1);
		activitate2.setDataStart(date.getTime());
		activitate3.setIdActivitate("3");
		activitate3.setDescriereActivitate("TeamBuilding 1");
		activitate3.setLocatie("Locatie TeamBuilding 1");
		activitate3.setSumaEstimata(200.00);
		date.set(2009,Calendar.DECEMBER,5);
		activitate3.setDataStart(date.getTime());		
	}
}

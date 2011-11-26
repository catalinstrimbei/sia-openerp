package org.open.erp.services.personal.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.CerereDemisie;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.Functie;
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
	List<CV> listaCandidati = new ArrayList<CV>();
	List<Candidat> listaCandidati2 = new ArrayList<Candidat>();
	List<Candidat> listaCandidati3 = new ArrayList<Candidat>();

	List<InterviuCandidat> listaInterviuri = new ArrayList<InterviuCandidat>();
	List<InterviuCandidat> listaInterviuri2 = new ArrayList<InterviuCandidat>();

	
	List<Departament> listaDepartamente = new ArrayList<Departament>();
	List<ProbaEvaluare> probeEvaluare = new ArrayList<ProbaEvaluare>();
	List<Angajat> angajati = new ArrayList<Angajat>();
	
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
	
	
	Persoana persoana1 = new Persoana(1, "Nume1", "Prenume1");
	
	
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
	
	Departament departament1 = new Departament("Dep1", "Departament1", 20);
	Departament departament2 = new Departament("Dep2", "Departament2", 10);
	Departament departament3 = new Departament("Dep3", "Departament3", 10);
	
	ProbaEvaluare	probaEvaluare1 = new ProbaEvaluare("Oral", "EvaluarePeriodica", departament1);
	ProbaEvaluare	probaEvaluare2 = new ProbaEvaluare("Practic", "EvaluarePeriodica", departament1);
	ProbaEvaluare	probaEvaluare3 = new ProbaEvaluare("Scris", "EvaluarePeriodica", departament2);
	ProbaEvaluare	probaEvaluare4 = new ProbaEvaluare("Oral", "EvaluarePeriodica", departament2);
	ProbaEvaluare	probaEvaluare5 = new ProbaEvaluare("Scris", "EvaluarePeriodica", departament3);
	ProbaEvaluare	probaEvaluare6 = new ProbaEvaluare("Practic", "Test", departament1);
	
	//Angajat	angajat2 = new Angajat ()
	
	
	Angajat 		angajat1 = new Angajat(persoana1.getIdPersoana(), "Nume1", "Prenume1", candidat1.getIdCandidat(),candidat1.getTipCandidat(), 10001, true);
	//Angajat 		angajat1 = new Angajat(persoana1.getIdPersoana(), "Nume1", "Prenume1");
	ContractMunca	contract1 = new ContractMunca("ContractNr0002", angajat1, functie1, new Date("11/08/2011"), new Date("15/08/2011"), null,null);
	CerereDemisie	cerereDemisie1 = new CerereDemisie("CerereDem001", contract1, new Date("11/08/2011"), null, null,null);
	
	void generareAnunturi() {
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
	
	
	
	/*
	public void vizualizareRecrutare() {
		this.generareAnunturi();
		this.generareCandidati();
		Iterator<AnuntLocMunca> iterator = listaAnunturi2.iterator();
		System.out.println("VIZUALIZARE RECRUTARE");
		System.out.println("Anunturi valide " + listaAnunturi2.size());
		
		//System.out.println("Interviuri " + listaInterviuri.size());

		
		while (iterator.hasNext()) {
			//System.out.println("AM AJUNS AICI2");
			AnuntLocMunca anunt = iterator.next();
			System.out.println(anunt.getFunctie().getNumeFunctie());
			listaCandidati2 = personalService.getCandidatipeFunctie(anunt, listaCandidati);			
			Iterator<Candidat> iterator2 = listaCandidati2.iterator();
			System.out.println("Numar candidati: " + listaCandidati2.size());
			while (iterator2.hasNext()) {		
			   //System.out.println("--" + iterator2.next().getNume());
				//System.out.println("Candidati " + listaCandidati2.size());
			   Candidat candidat = iterator2.next();
			   listaCandidati3 = personalService.recrutare(candidat, listaInterviuri);
			  // System.out.println("Interviuri " + listaInterviuri.size());
				Iterator<Candidat> iterator3 = listaCandidati3.iterator();

				//System.out.println("Pentru angajare " + listaCandidati3.size());
				while (iterator3.hasNext()) {
					//System.out.println("AM AJUNS AICI");
					System.out.println("--Numele candidatului pentru angajare: " + iterator3.next().getNume());

				if (listaCandidati3.size() > 0)
				{
					System.out.println("Numar candidati pentru angajare: " + listaCandidati3.size());
					while (iterator3.hasNext()) {
						//System.out.println("AM AJUNS AICI");
						System.out.println("--" + iterator3.next().getNume());
					}

				}
			
			}
		}	
	}
		
	}
	
	*/
	
}

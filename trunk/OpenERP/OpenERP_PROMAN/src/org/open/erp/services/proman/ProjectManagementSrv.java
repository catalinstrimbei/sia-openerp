package org.open.erp.services.proman;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
/**
 * 
 * @author catalin.strimbei
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: BugetareSrv, NomGenSrv
 * 
 * @EntitatiNomGen: Persoana
 * 
 * @EntitatiAlteSrv: Buget
 * 
 * @EntitatiLocale: Proiect, Task
 * 
 * @UseCase("1.Initiere proiect"):
 * 1. Creare proiect, Rezultat: instanta Proiect
 * Completare: id, asignare responsabil (uc:creare|alegere), dataStart, dataFinalizare, buget (uc:creare)
 * Implicit: status NOT_STARTED
 * 1.1 Adaugare activitati (*), Rezultat: instante Activitate
 * Completare titulaura, asignare responsabil (uc:creare|alegere),  dataStart, dataFinalizare, buget!(uc:creare)
 * Implicit: status NOT_STARTED, cost 0.0, procentRealizare 0%
 * Verificare: coordonare termene (dataStart, dataFinalizare) cu activitati precedente
 * 1.2 Salvare proiect (agregat - salvare inclusiv a activitatilor)
 * 
 * @UseCase("2.Editare proiect/Adaugare activitati noi/Restructurare activitati")
 * 
 * @UseCase("3.Actualizare status proiect"):
 * 2.1 Alegere proiect nefinalizat
 * 2.2 Alegerea activitate nefinalizata
 * 2.3 Completare (la nivel activitate): status (IN_CURS, SUSPENDATA, INCHEIATA), procentRealizare, cost
 * Verificare: coordonare status cu activitati precedente
 * Implicit: data ultimei actualizari este data curenta 
 * 2.4 Afisare/Calcul (nivel proiect): procent-progres-proiect, cost-global-proiect, sold-buget
 * 2.5 Afisare GANTT 
 * 
 * 
 * @UseCase("Special pentru MDB/JMS: 
 * - jurnalizare in DB a unor evenimente din desfasurarea proiectelor sau
 * - trimitere mail/alerte responsabili sau trimitere-semnalizare probleme pe forum
 * - integrare-f-slaba pe baza de mesaje-eveniment intre EJBuri
 * ")
 * 
 * @UseCase("Special pentru EJBTimer: start sau finish automat pentru anumite activitati")
 * 
 * @UseCase("Special pentru Interceptori: 
 * - validare: depasire buget
 * - securitate
 * ")
 *
 * 
 */
@Remote
public interface ProjectManagementSrv{
	/**
	 * Returneaza un proiect templetizat.
	 * 
	 * @param nume 			Titulatura proiectului nou creat
	 * @param responsabil 	Numele persoanei responsabil general
	 * @param dataStart 	Data estimata start 
	 * @param dataSfarsit 	Data estimata sfarsit
	 * @param valoareBuget 	Valoare buget estimat
	 * 
	 * @return instanta Proiect nou creata. 
	 * 
	 */
	Proiect creareProiect(String nume, Responsabil responsabil, Date dataStart, Date dataSfarsit, Double valoareBuget) throws Exception ;
	Proiect creareProiect(Proiect proiectNou) throws Exception;
	Proiect salvareProiect(Proiect proiect) throws Exception;
	
	/**
	 * Scop					Creeaza activitate si o asociaza proiectului.
	 * 
	 * @param proiect		Proiectul caruia i se va asocia activitatea nou creata
	 * @param responsabil
	 * @param titulatura
	 * @param dataStart
	 * @param dataSfarsit
	 * @param valoareBugetata
	 * 
	 * @return activitatea nou creata
	 * 
	 */	
	Activitate creareActivitate(Proiect proiect, Responsabil responsabil, String titulatura, Date dataStart, Date dataSfarsit, Double valoareBugetata) throws Exception;
	/**
	 * Scop					Schimba status proiect in started, schimba status prima activitate in started.
	 * 
	 * @param proiect		Proiectul a carui derulare va fi initiata
	 * 
	 * @return 
	 * 
	 */	
	void startProiect(Proiect proiect);
	/**
	 * Scop					Schimba status proiect in progress, actualizeaza activitate, actualizeaza linii de bugetare proiect
	 * 
	 * @param nume 			Activitate in progres.
	 * 
	 * @return 
	 * 
	 */	
	void progresActivitate(Activitate activitate, Double procent, Double cost, Date dataActualizata);
	/**
	 * Scop					Calculeaza sold proiect de la inceput pina la data specificata
	 * 
	 * @param proiect 		Proiect in progres.
	 * @param proiect 		Data referinta sold.
	 * 	
	 * @return				Valoare(suma) reprezentand soldul calculat 
	 * 
	 */	
	Double getSoldProiectInCurs(Integer idProiect, Date dataSold);	
	
	/* Data Operations */
	Proiect getProiect(Integer idProiect);
	List<Proiect> getProiecte();
	
}

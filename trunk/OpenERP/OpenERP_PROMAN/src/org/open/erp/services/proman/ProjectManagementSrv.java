package org.open.erp.services.proman;

import java.util.Date;
import java.util.List;

import org.open.erp.services.buget.BugetareSrv;
/**
 * @author catalin.strimbei
 * 
 * @ApplicationServiceFacade
 * 
 * 
 * @Dependente: BugetareSrv, NomGenSrv
 * 
 * @EntitatiNomGen: Persoana
 * 
 * @EntitatiAlteSrv: Buget
 * 
 * @EntitatiLocale: Proiect, Activitate
 * 
 * @UseCase("1.Initiere proiect"):
 * 
 * @UseCase("2.Editare proiect/Adaugare activitati noi/Restructurare activitati")
 * 
 * @UseCase("3.Actualizare status proiect"):
 *
 * @UseCase("4. Alerta status proiect"):
 * 
 */
public interface ProjectManagementSrv{
	/**
	 * Returneaza un proiect templetizat.
	 * 
	 * @param nume 			Titulatura proiectului nou creat
	 * @param dataStart 	Data estimata start 
	 * @param dataSfarsit 	Data estimata sfarsit
	 * 
	 * @return instanta Proiect nou creata. 
	 * 
	 */
	Proiect creareProiect(String numeProiect, Date dataStart, Date dataSfarsit, Double valoareBuget) throws Exception ;

	/**
	 * Scop					Creeaza activitate si o asociaza proiectului.
	 * 
	 * @param proiect		Proiectul caruia i se va asocia activitatea nou creata
	 * @param titulatura
	 * @param dataStart
	 * @param dataSfarsit
	 * 
	 * @return activitatea nou creata
	 * 
	 */		
	Activitate creareActivitate(Proiect proiect, String titulatura, Date dataStart, Date dataSfarsit) throws Exception;
	
	/**
	 * Scop						Asociaza/Repartizeaza o persoana responsabila pentru o activitate.
	 * 
	 * @param activitate		Activitate careia i se va asocia responsabilul
	 * @param responsabil
	 * 
	 */		
	void stabilireResponsabilActivitate(Activitate activitate, Responsabil responsabil);
	
	/**
	 * Scop						Stabileste un buget pentru o activitate.
	 * 
	 * @param activitate		Activitate careia i se va asocia responsabilul
	 * @param valoareBugetata	Valoare bugetului asociat activitatii
	 * 
	 */		
	void stabilireLinieBugetara(Activitate activitate, Double valoareBugetata);
	
	
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
	
	
	/* Alte Operatii */
	Proiect getProiect(Integer idProiect);
	List<Proiect> getProiecte();
	Proiect salvareProiect(Proiect proiect) throws Exception;
	void setBugetareSrv(BugetareSrv bugetareSrv);	
}

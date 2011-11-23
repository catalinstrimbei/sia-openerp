package org.open.erp.services.proman;

import java.util.Date;

import org.open.erp.services.nomgen.Persoana;
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
 * @UseCase("initiere proiect"):
 * 1. Creaza instanta proiect
 * 2. Cerere buget
 * *. Returneata proiect initializat in IN_ASTEPTARE
 *  
 * @UseCase("initiere proiect"):
 *  
 */
public interface ProjectManagementSrv {
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
	Proiect creareProiect(String nume, Persoana responsabil, Date dataStart, Date dataSfarsit, Double valoareBuget);
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
	Activitate creareActivitate(Proiect proiect, Persoana responsabil, String titulatura, Date dataStart, Date dataSfarsit, Double valoareBugetata);
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
}

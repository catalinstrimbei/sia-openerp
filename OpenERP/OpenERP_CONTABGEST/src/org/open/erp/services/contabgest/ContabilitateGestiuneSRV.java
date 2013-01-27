package org.open.erp.services.contabgest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.Reteta;


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
public interface ContabilitateGestiuneSRV {
	

	
		/**
		 * Returneaza o analiza templetizata.
		 * 
		 * @param numeAnaliza     Titlul analizei
		 * @param dataInceput     Data inceput analiza 
		 * @param dataSfarsit 	  Data estimata sfarsit analiza
		 * @param responsabil     Responsabil analiza
		 * @param procentRealizat Valoarea procentului realizat din analiza
		 ** 
		 * @return  Analiza nou creata. 
		 * 
		 */
		Analiza creareAnaliza(String numeAnaliza, Date dataInceput, Date dataSfarsit,  Double procentRealizare) throws Exception ;
		Analiza creareAnaliza(Analiza analizaNoua) throws Exception;
		Analiza salvareAnaliza(Analiza analiza) throws Exception;
		
		/**
		 * Scop					Creeaza  o calculatie si o asociaza analizei.
		 * 
		 * @param analiza	    	Analiza caruia i se va asocia calculatia nou creata
		 * @param reteta            Reteta analizata
		 * @param valoareCost       Valoare costurilor extra preluata din CosturiExtra
		 * 
		 * 		
		 * @return calculatie noua nou creata
		 * 
		 */	
		Calculatii creareCalculatii(Analiza analiza, Reteta reteta, Double valoareCost) throws Exception;
		/**
		 * Scop					Schimba status analiza in initializata
		 * 
		 * @param analiza		Analiza a carui derulare va fi initializata
		 * 
		 * @return 
		 * 
		 */	
		void startAnaliza(Analiza analiza);
		
	
		
		/* Data Operations */
		Analiza getAnaliza(Integer IdAnaliza);
		List<Analiza> getAnaliza();
		


}

package org.open.erp.services.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;


import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Persoana;
/**
 * 
 * @author Ioana
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: BugetareSrv, NomGenSrv
 * 
 * @EntitatiNomGen: Persoana, Departament
 * 
 * @EntitatiBugetareSrv: Buget
 * 
 * @EntitatiLocale: Activitate, ActivitateTeamBuilding, ActivitateTraining, Angajat, AngajatProbaEvaluare,
 * * * * * * * * *  AnuntLocMunca, Candidat, CerereDemisie, ContractMunca, CV, DosarAngajat, Eveniment, Functie,
 * * * * * * * * *  InstructorTraining, Interviu, InterviuCandidat, ProbaEvaluare
 * 
 * 
 * @UseCase("recrutare"):
 * 1. Creare instante: functie, anunt loc de munca
 * 2. Afisarea continutului anunturilor locurilor de munca valide in functie de o data precizata
 * 3. Creare instante: candidat, CV
 * 4. Afisarea numelor candidatilor pentru locurile de munca valide
 * 5. Creare instante: interviu, interviuCandidat
 * 6. Afisarea numelor candidatilor care au fost admisi la interviul final
 * *. Returneaza candidatii propusi pentru angajare
 * * * *
 *  
 *  *  @UseCase("angajare"): ---- DE IMPLEMENTAT
* 1. Creare instanta angajat
* 2. Initializarea atributului statusului in privinta activitatii cu "true"
* 3. Creare instanta dosar angajat pentru fiecare angajat
* 4. Creare instanta contract de munca pentru fiecare angajat daca dosarul este complet, completarea functiei si 
*       necompletarea datei de terminare a contractului 
* 
* *. 
 *  
 * @UseCase("concediere"):
 * 1. Modificarea datelor contractului de munca pentru un angajat: 
 * ** ** ** data terminarii cu data curenta a realizarii actiunii,
 * ** ** ** motivul de incheiere cu "Concediere";
 * 2. Modificarea datelor despre angajat :statusul de activ devine "False"
 * 
 * * * *
 * 
 * @UseCase("demisionare"):
 * 1. Creare instanta CerereDemisie prin neprecizarea statusului(a evolutiei cererii)
 * 2. Procesarea cererii de demisie : data inregistrarii, numar de zile pentru preaviz
 * 3. Modificarea datelor angajatului care demisioneaza: data terminare, motiv incheiere devine "Demisionare"
 * 4. Modificarea datelor despre angajat :statusul de activ devine "False"
 * 5. Actualizarea statusului cererei in "Finalizata"
 * 
 * * * *
 *  

 * 
 * 
 * @UseCase("evaluareAngajati"):
 * 1. Creare instante: probaEvaluare, departament
 * 2. Afisarea probelor pe fiecare departament
 * 3. Afisarea rezultatelor pe fiecare proba
 * *. Returneaza rezultatele pe fiecare departament/ proba/ angajati (in vederea creari de ierarhizari de exemplu)
 *  
 * @UseCase("recrutare"):
 *  
 */
public interface PersonalSrv {
	
	List<AnuntLocMunca> getPosturiVacante(Date dataVizata_, List<AnuntLocMunca> listaInit_);
	
	/**
	 * Scop    Returneaza o lista cu posturile valide dupa o data precizata
	 * 
	 * @param  dataVizata_ 	Data setata de utilizator, care va fi comparata cu data anuntului de munca
	 * @param  listaInit_ 	Lista cu toate anunturile existente
	 * 
	 * @return continutul fiecarui anunt valid 
	 * 
	 */
	
	List<Candidat> getCandidatipeFunctie(AnuntLocMunca anuntLocMunca_, List<CV> listaInit_);
	
	/**
	 * Scop    Pentru fiecare anunt de loc de munca, returneaza o lista cu candidatii care au aplicat cv-urile 
	 *          pentru functia precizata in anunt
	 * 
	 * @param  anuntLocMunca_ 	Anuntul locului de munca pentru care se vor afisa candidatii
	 * @param  listaInit_ 	    Lista cu toate  cv-urile existente
	 * 
	 * @return lista cu date despre candidati
	 * 
	 */
	
	
	List<Candidat> recrutare(Date dataAnunt_, Candidat candidat_, List<InterviuCandidat> listaInit_);
	
	/**
	 * Scop    Returneaza o lista cu candidatii care au au fost admisi la interviul final, interviu organizat dupa 
	 *         o data precizata
	 * 
	 * @param  dataAnunt_ 	    Data precizata de utilizator, care va fi comparata cu data sustinerii interviului
	 * @param  candidat_        Candidatul pentru care se afiseaza interviurile finale si admise
	 * @param  listaInit_ 	    Lista cu toate  interviurile existente
	 * 
	 * @return lista cu date despre candidati admisi la interviurile finale
	 * 
	 */
	
	
	
	HashMap <Departament, List<ProbaEvaluare>> getProbeEvaluareDepartament (List<ProbaEvaluare> probeEvaluareInit_, List<Departament> departamenteInit_);
	
	/**
	 * Scop    Returneaza o lista a probelor grupate pe fiecare departament 
	 *         
	 * @param  probeEvaluareInit_ 	    Lista cu toate probele de evaluare
	 * @param  departamenteInit_ 	    Lista cu toate  departamentele existente
	 * 
	 * @return map cu fiecare departament si probele fiecaruia
	 * 
	 */
	
	//TreeMap<ProbaEvaluare, AngajatProbaEvaluare> evaluarePeriodica(List <AngajatProbaEvaluare> angajatProbaInit_, List<ProbaEvaluare> probeEvaluareInit_ );
	
	//HashMap<Departament, List<HashMap<ProbaEvaluare, List<HashMap<Angajat, Integer>>>>> evaluarePeriodica(List<Departament> departamente_init, List <AngajatProbaEvaluare> angajatProbaInit_, List<ProbaEvaluare> probeEvaluareInit_ );;
	
	HashMap <Angajat, List<HashMap<ProbaEvaluare, Integer>>> getNoteAngajatByProba (List <AngajatProbaEvaluare> angajatProbaInit_, List<ProbaEvaluare> probeEvaluareInit_);
	/**
	 * Scop    Returneaza lista rezultatelor angajatilor la fiecare proba grupate pe fiecare departament 
	 *         
	 * @param  angajatProbaInit_ 	    Lista cu toate rezultatele la toate probele de evaluare
	 * @param  probeEvaluareInit_ 	    Lista cu toate probele de evaluare
	 * 
	 * @return map cu fiecare proba si rezultatele fiecarui angajat
	 * 
	 */
	
	CV getCVByCandidat(Candidat candidat_);

	void angajare(Candidat candidat_);
	
	void demisionare(CerereDemisie cerereDemisie_);
	
	/**
	 * Scop   
	 * 
	 * @param cerereDemisie_ 
	 * 
	 * @return 
	 * 
	 */
	
	void concediere(ContractMunca contractMunca_);

	Angajat getAngajatById(Integer marca_);
	
	
	List<Angajat> getListaAngajati();
	
	List<ContractMunca> getListaContracteByAngajat(Angajat angajat_);
	
	DosarAngajat getDosarByAngajat(Angajat angajat_);

	void activareAngajati(List<Angajat> listaAngajati);
	

}

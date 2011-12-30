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
 *  *  @UseCase("angajare"):
* 1. Creare instanta angajat
* 2. Creare instanta dosar angajat pentru fiecare angajat
* 3. Creare instanta contract de munca pentru fiecare angajat, completarea functiei si 
*       necompletarea datei de terminare a contractului 
* 4. Initializarea atributului statusului in privinta activitatii cu "true" dupa completarea dosarului
* 
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
 *
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
	

	HashMap<ProbaEvaluare, List<AngajatProbaEvaluare>> getRezultateEvaluareByProba (List <AngajatProbaEvaluare> angajatProbaInit_, List<ProbaEvaluare> probeEvaluareInit_);
	/**
	 * Scop    Returneaza lista rezultatelor angajatilor la fiecare proba  
	 *         
	 * @param  angajatProbaInit_ 	    Lista cu toate rezultatele la toate probele de evaluare
	 * @param  probeEvaluareInit_ 	    Lista cu toate probele de evaluare
	 * 
	 * @return map cu fiecare proba si rezultatele fiecarui angajat
	 * 
	 */
	
	CV getCVByCandidat(Candidat candidat_);
	
	/**
	 * Scop    Returneaza cv-ul pentru fiecare candidat
	 *         
	 * @param  candidat_ 	    Candidatul pentru care se cauta cv-ul
	 * 
	 * @return date Cv pentru candidatul precizat
	 * 	
	 */
	

	void angajare(Candidat candidat_);
	/**
	 * Scop    Creeaza un nou angajat cu dosarul acestuia si a contractului de munca prin precizarea candidatului
	 *         
	 * @param  candidat_ 	    Candidatul care va fi angajat
	 * 
	 * @return 
	 * 	
	 */
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
	
	/**
	 * Scop   
	 * 
	 * @param contractMunca_ 
	 * 
	 * @return 
	 * 
	 */
	
	
	ContractMunca relocalizare_promovare(Integer marca_, Functie functieNoua_, ContractMunca contractVizat_, boolean promovare_, double salarBaza_, double tarifOrar_);
	
	/**
	 * Scop						Relocalizarea unui angajat ca urmare a resturcturarii firmei sau ca urmare a promovarii angajatului 
	 * 
	 * @param marca_			marca angajatului ce urmeaza a fi relocalizat
	 * @param functieNoua_		Noua functie pe care urmeaza a fi plasat
	 * @param contractVizat_	Contractul care va fi terminat pentru a se incheia unul nou. In cazul in care acest parametru
	 * 							este null se vor termina toate contractele precedente si se va incheia unul singur nou
	 * @param promovare_		specifica daca metoda este apelata pentru relocalizare sau promovare
	 * @param salarBaza			noul salariu de baza
	 * @param tarifOrar_		noul tarif orar
	 * @return					Contractul nou incheiat sau contractul modificat in urma promovarii.
	 */
	
	
	Angajat getAngajatById(Integer marca_);
	
	/**
	 * Scop  Returneaza datele despre un angajat dupa precizarea marcii 
	 * 
	 * @param marca_  Marca angajatului, element unic de identificare pentru angajat, dupa care se face cautarea
	 * 
	 * @return date angajat 
	 * 
	 */
	
	
	List<Angajat> getListaAngajati();
	
	/**
	 * Scop  Returneaza o lista cu toti angajatii
	 * 
	 * 
	 * @return 
	 * 
	 */
	
	
	List<ContractMunca> getListaContracteByAngajat(Angajat angajat_);
	
	/**
	 * Scop  			 Returneaza o lista a contractelor de munca pentru un angajat precizat
	 * 
	 * @param  angajat_  Angajatul dupa care se face cautarea
	 * 
	 * @return           lista contracte curente pentru un angajat
	 * 
	 */
	
	ContractMunca getContractAngajatActiv(Angajat angajat_);	
	/**
	 * Scop  			 Returneaza un contract de munca pentru un angajat precizat
	 * 
	 * @param  angajat_  Angajatul dupa care se face cautarea
	 * 
	 * @return           un contract curent pentru un angajat
	 * 
	 */
	
	DosarAngajat getDosarByAngajat(Angajat angajat_);
	
	/**
	 * Scop  			 Returneaza dosarul de angajare pentru un angajat precizat
	 * 
	 * @param  angajat_  Angajatul dupa care se face cautarea
	 * 
	 * @return           dosarul curent pentru un angajat
	 * 
	 */

	void activareAngajati(List<Angajat> listaAngajati);
	
	/**
	 * Scop                   Seteaza activ statusul unui angajat daca dosarul acestuia este complet
	 * 
	 * @param  listaAngajati  Lista tuturor angajatilor pentru care se realizeaza operatiunea
	 * 
	 * @return           
	 * 
	 */
	Functie adaugareFunctie(String	numeFunctie_, Integer pozitiaInCOR_, List<String> obiective_, 
							List<String>	responsabilitati_, List<String>	cunostinte_, 
							List<String>	deprinderi_, List<String>	aptitudini_, Departament departament);
	/**
	 * Scop                   Permite adaugarea unei noi functii cu anumite atribute
	 * 
	 * @param  numeFunctie_  		numele Functiei
	 * @param  pozitiaInCOR_  		Pozitia in clasificarea ocupatiilor din Romania
	 * @param  obiective_  			Lista obiectivelor urmartie de aceasta functie
	 * @param  responsabilitati_  	Lista responsabilitatilor ascoCiate cu aceasta functie
	 * @param  cunostinte_  		Lista cunostintelor ascociate cu aceasta functie
	 * @param  aptitudini_  		Lista aptitudinilor ascociate cu aceasta functie
	 * @param  cunostinte_  		Lista cunostintelor necesare pt aceasta functie
	 * 
	 * @return    Functia nou creata       
	 * 
	 */
	
	
	List<Eveniment> getEvenimenteAnuale(Integer _year);//NMV>>metoda pentru evenimentele anuale
	/**
	 * @param _year anul pentru care trebuie returnata lista de evenimente.
	 * Daca year = 0 va returna toate evenimentele din toti anii
	 * @return list evenimente pentru anul primit ca parametru
	 */	
	
	void aprobareEveniment(Eveniment _eveniment);
	/**
	 * @param _activitate //metoda ce determina daca un eveniment este aprobat sau nu in functie de suma alocata si estimata
	 * 
	 */
}
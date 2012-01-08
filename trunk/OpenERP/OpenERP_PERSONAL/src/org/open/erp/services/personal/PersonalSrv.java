package org.open.erp.services.personal;

import java.util.Date;
import java.util.HashMap;
import java.util.Collection;

//TODO uncomment this
//import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.personal.logger.PersonalExceptions;
/**
 * 
 * @author Ioana
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: BugetareSrv, NomGenSrv
 * 
 * @EntitatiNomGen: DummyPersoana, DummyDepartament
 * 
 * @EntitatiBugetareSrv: Buget
 * 
 * @EntitatiLocale: Activitate, ActivitateTeamBuilding, ActivitateTraining, Angajat, RezultatProbaEvaluare,
 * * * * * * * * *  AnuntLocMunca, Candidat, CerereDemisie, ContractMunca, CV, DosarAngajat, Eveniment, Functie,
 * * * * * * * * *  Instructor, Interviu, InterviuCandidat, ProbaEvaluare
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
	
	ActivitateTeamBuilding				getActivitateTeamBuildingById(Integer idActivitate_) throws Exception;
	/**
	 * Scop  Returneaza datele unei activitati de Team-Building dupa precizarea id-ului
	 * 
	 * @param idActivitate_  id-ul activitatii, element unic de identificare pentru o activitate, dupa care se face cautarea
	 * 
	 * @return Obiectul de tip ActivitateTeamBuilding 
	 * 
	 */
	Collection<ActivitateTeamBuilding>	getListaActivitatiTeamBuilding() throws Exception;
	/**
	 * Scop  Returneaza o Lista cu toate Activitatile de Team-Building
	 * 
	 * 
	 * @return o lista cu toate Activitatile de Team-Building
	 * 
	 */
	ActivitateTeamBuilding				salveazaActivitateTeamBuilding(ActivitateTeamBuilding activitate_) throws Exception;
	/**
	 * Scop  Salveaza o ActivitateTeamBuilding in BD
	 * 
	 * 
	 * @return Obiectul de tip ActivitateTeamBuilding 
	 * 
	 */
	void								stergeActivitateTeamBuilding(ActivitateTeamBuilding activitate_) throws Exception;
	/**
	 * Scop  Sterge o ActivitateTeamBuilding din BD
	 * 
	 * 
	 * @return nimic.
	 * 
	 */
	
	ActivitateTraining				getActivitateTrainingById(Integer idActivitate_) throws Exception;
	/**
	 * Scop  Returneaza datele unei activitati de Training dupa precizarea id-ului
	 * 
	 * @param idActivitate_  id-ul activitatii, element unic de identificare pentru o activitate, dupa care se face cautarea
	 * 
	 * @return Obiectul de tip ActivitateTraining 
	 * 
	 */
	Collection<ActivitateTraining>	getListaActivitatiTraining() throws Exception;
	/**
	 * Scop  Returneaza o lista cu toate Activitatile de Training
	 * 
	 * 
	 * @return o lista cu toate Activitatile de Training
	 * 
	 */
	ActivitateTraining				salveazaActivitateTraining(ActivitateTraining activitate_) throws Exception;
	/**
	 * Scop  Salveaza o ActivitateTraining in BD
	 * 
	 * 
	 * @return Obiectul de tip ActivitateTraining 
	 * 
	 */
	void							stergeActivitateTraining(ActivitateTraining activitate_) throws Exception;
	/**
	 * Scop  Sterge o ActivitateTraining din BD
	 * 
	 * 
	 * @return nimic.
	 * 
	 */
	
	Angajat							getAngajatById(Integer idAngajat_) throws Exception;
	/**
	 * Scop  Returneaza datele despre un angajat dupa precizarea id-ului
	 * 
	 * @param idAngajat_  id-ul persoanei, element unic de identificare pentru o persoana din cadrul firmei, dupa care se face cautarea
	 * 
	 * @return Obiectul de tip Angajat 
	 * 
	 */
	Angajat							getAngajatByMarca(Integer marca_) throws Exception;
	/**
	 * Scop  Returneaza datele despre un angajat dupa precizarea marcii
	 * 
	 * @param marca_  Marca angajatului, element unic de identificare pentru angajat, dupa care se face cautarea
	 * 
	 * @return Obiectul de tip Angajat 
	 * 
	 */
	Collection<Angajat>				getListaAngajati() throws Exception;
	/**
	 * Scop  Returneaza o Lista cu toti angajatii
	 * 
	 * 
	 * @return o lista cu toti Angajatii
	 * 
	 */
	Angajat							salveazaAngajat(Angajat angajat_) throws Exception;
	/**
	 * Scop  Salveaza un Angajat in BD
	 * 
	 * 
	 * @return Obiectul de tip Angajat 
	 * 
	 */
	void							stergeAngajat(Angajat angajat_) throws Exception;
	/**
	 * Scop  Sterge un angajat din BD
	 * 
	 * 
	 * @return nimic.
	 * 
	 */
							
	AnuntLocMunca				getAnuntLocMuncaById(Integer idAnunt_) throws Exception;
	/**
	 * Scop  Returneaza datele unui Anunt de loc de Munca dupa precizarea id-ului
	 * 
	 * @param idAnunt_  id-ul anuntului, element unic de identificare pentru un anunt, dupa care se face cautarea
	 * 
	 * @return Obiectul de tip AnuntLocMunca 
	 * 
	 */
	Collection<AnuntLocMunca>	getListaAnunturiLocMunca() throws Exception;
	/**
	 * Scop  Returneaza o lista cu toate Anunturile pentru locuri de Munca
	 * 
	 * 
	 * @return o lista cu toate Anunturile pentru locuri de Munca
	 * 
	 */
	AnuntLocMunca				salveazaAnuntLocMunca(AnuntLocMunca anunt_) throws Exception;
	/**
	 * Scop  Salveaza un AnuntLocMunca in BD
	 * 
	 * 
	 * @return Obiectul de tip AnuntLocMunca 
	 * 
	 */
	void							stergeAnuntLocMunca(AnuntLocMunca anunt_) throws Exception;
	/**
	 * Scop  Sterge un AnuntLocMunca  din BD
	 * 
	 * 
	 * @return nimic.
	 * 
	 */
	
	

	// InterviuCandidat
	InterviuCandidat getInterviuCandidatById(Integer idInterviuCandidat_) throws Exception;
	/**
	 * Scop  Returneaza datele unui Interviu Candidat dupa precizarea id-ului
	 * 
	 * @param idInterviuCandidat_  id-ul interviului, element unic de identificare pentru un interviu, dupa care se face cautarea
	 * 
	* @return Obiectul de tip InterviuCandidat 
	* 
	*/
	Collection<InterviuCandidat>	getListaInterviuriCandidati() throws Exception;
	/**
	 * Scop  Returneaza o lista cu toate Interviurile Candidati
	 * 
	 * 
	 * @return o lista cu toate Interviurile Candidati
	 * 
	 */
	
	InterviuCandidat	salveazaInterviuCandidat(InterviuCandidat idInterviuCandidat_) throws Exception;
	/**
	 * Scop  Salveaza un AnuntLocMunca in BD
	 * 
	 * 
	 * @return Obiectul de tip AnuntLocMunca 
	 * 
	 */
	
	
	void	stergeInterviuCandidat(InterviuCandidat interviuCandidat_) throws Exception;
	/**
	 * Scop  Sterge un InterviuCandidat  din BD
	 * 
	 * 
	 * @return 
	 * 
	 */
	
	
		
	//ProbaEvaluare
	ProbaEvaluare getProbaEvaluareById(Integer idProba_) throws Exception;
	/**
	 * Scop  Returneaza datele unei Probe de Evaluare dupa precizarea id-ului
	 * 
	 * @param idProba_  id-ul probei, element unic de identificare, dupa care se face cautarea
	 * 
	* @return Obiectul de tip ProbaEvaluare 
	* 
	*/
	
	Collection<ProbaEvaluare>	getListaProbeEvaluare() throws Exception;
	/**
	 * Scop  Returneaza o lista cu toate Probele de Evaluare
	 * 
	 * 
	 * @return o lista cu toate Probele de Evaluare
	 * 
	 */
	ProbaEvaluare salveazaProbaEvaluare(Integer idProba_, String tipEvaluare) throws Exception;
	/**
	 * Scop  Salveaza o proba de evealuare
	 * 
	 * 
	 * @return Obiectul de tip ProbaEvaluare
	 * 
	 */
	
	void	stergeProbaEvaluare(ProbaEvaluare proba_) throws Exception;
	/**
	 * Scop  Sterge un InterviuCandidat  din BD
	 * 
	 * 
	 * @return 
	 * 
	 */	
	
	
	//ResponsabilActivitate
	ResponsabilActivitate getResponsabilActivitateById(Integer id_) throws Exception;
	/**
	 * Scop  Returneaza datele unei Responsabil al unei activitati dupa precizarea id-ului
	 * 
	 * @param id_  id-ul probei, element unic de identificare, dupa care se face cautarea
	 * 
	* @return Obiectul de tip ResponsabilActivitate 
	* 
	*/
	
	Collection<ResponsabilActivitate>	getListaResponsabiliActivitati() throws Exception;
	/**
	 * Scop  Returneaza o lista cu toti Responsabilii de Activitati
	 * 
	 * 
	 * @return o lista cu cu toti Responsailii de Activitati
	 * 
	 */
	
	ResponsabilActivitate salveazaResponsabilActivitate(Integer id_) throws Exception;
	/**
	 * Scop  Salveaza un responsabil pentru o activitate
	 * 
	 * 
	 * @return Obiectul de tip ResponsabilActivitate
	 * 
	 */
	
	void	stergeResponsabilActivitate(ResponsabilActivitate responsabil_) throws Exception;
	/**
	 * Scop  Sterge un ResponsabilActivitate  din BD
	 * 
	 * 
	 * @return 
	 * 
	 */	
	
		
	//RezultatProbaEvaluare
	RezultatProbaEvaluare getRezultatProbaEvaluareById(Integer id_) throws Exception;
	/**
	 * Scop  Returneaza rezultatele pentru probele de evaluare dupa precizarea id-ului
	 * 
	 * @param id_  id-ul rezultatului, element unic de identificare, dupa care se face cautarea
	 * 
	* @return Obiectul de tip RezultatProbaEvaluare 
	* 
	*/
	
	Collection<RezultatProbaEvaluare>	getListaRezultateProbeEvaluare() throws Exception;
	/**
	 * Scop  Returneaza o lista cu toate rezultatele pentru probele de evaluare
	 * 
	 * 
	 * @return o lista cu cu toti Responsabilii de Activitati
	 * 
	 */
	
	RezultatProbaEvaluare salveazaRezultatProbaEvaluare(Integer id_) throws Exception;
	/**
	 * Scop  Salveaza rezultatatul pentru probele de evaluare
	 * 
	 * 
	 * @return Obiectul de tip RezultatProbaEvaluare
	 * 
	 */
	
	void	stergeRezultatProbaEvaluare(RezultatProbaEvaluare rezultat_) throws Exception;
	/**
	 * Scop  Sterge un RezultatProbaEvaluare  din BD
	 * 
	 * 
	 * @return 
	 * 
	 */	
	
	
	
	
	

	Candidat				getCandidatById(Integer idPersoanaCandidat_) throws Exception;
	/**
	 * Scop  Returneaza datele unui Candidat dupa precizarea id-ului persoanei
	 * 
	 * @param idPersoanaCandidat_  id-ul Persoanei extinse de Candidat
	 * 
	 * @return Obiectul de tip Candidat
	 * 
	 */
	
	Candidat				getCandidatByIdCandidat(Integer idCandidat_) throws Exception;
	/**
	 * Scop  Returneaza datele unui Candidat dupa precizarea id-ului candidatului
	 * 
	 * @param idCandidat_  id-ul Candidatului
	 * 
	 * @return Obiectul de tip Candidat
	 * 
	 */
	
	Collection<Candidat>	getListaCandidati() throws Exception;
	/**
	 * Scop  Returneaza o Lista cu toti candidatii
	 * 
	 * 
	 * @return o lista cu toti candidatii
	 * 
	 */
	Candidat				salveazaCandidat(Candidat candidat) throws Exception;
	/**
	 * Scop  Salveaza un Candidat in BD
	 * 
	 * 
	 * @return Obiectul de tip Candidat 
	 * 
	 */
	void				   stergeCandidat(Candidat candidat_) throws Exception;
	/**
	 * Scop  Sterge un candidat din BD
	 * 
	 * 
	 * @return nimic.
	 * 
	 */
	
	CerereDemisie				getCerereDemisieById(Integer idCerereDemisie_) throws Exception;
	/**
	 * Scop  Returneaza datele unei cererei de demisie dupa precizarea id-ului
	 * 
	 * @param idCerereDemisie_  id-ul cererii de demisie, element unic de identificare pentru o cerere de demisie, dupa care se face cautarea
	 * 
	 * @return Obiectul de tip CerereDemisie 
	 * 
	 */
	Collection<CerereDemisie>	getListaCereriDemisie() throws Exception;
	/**
	 * Scop  Returneaza o lista cu toate cererile de demisie
	 * 
	 * 
	 * @return o lista cu toate cererile de demisie
	 * 
	 */
	CerereDemisie				salveazaCerereDemisie(CerereDemisie cerereDemisie_) throws Exception;
	/**
	 * Scop  Salveaza o CerereDemisie in BD
	 * 
	 * 
	 * @return Obiectul de tip CerereDemisie 
	 * 
	 */
	void						stergeCerereDemisie(CerereDemisie cerereDemisie_) throws Exception;
	/**
	 * Scop  Sterge o CerereDemisie din BD
	 * 
	 * 
	 * @return nimic.
	 * 
	 */
	
	ContractMunca							getContractMuncaById(Integer idContractMunca_) throws Exception;
	/**
	 * Scop  Returneaza datele despre un contract de munca dupa precizarea id-ului
	 * 
	 * @param idContractMunca_  id-ul contractului de munca
	 * 
	 * @return Obiectul de tip ContractMunca 
	 * 
	 */
	
	Collection<ContractMunca>				getListaContracteMunca() throws Exception;
	/**
	 * Scop  Returneaza o Lista cu toate contractele de munca
	 * 
	 * 
	 * @return o lista cu toate Contractele de Munca
	 * 
	 */
	ContractMunca							salveazaContractMunca(ContractMunca contractMunca_) throws Exception;
	/**
	 * Scop  Salveaza un ContractMunca in BD
	 * 
	 * 
	 * @return Obiectul de tip ContractMunca 
	 * 
	 */
	void							stergeContractMunca(ContractMunca contractMunca_) throws Exception;
	/**
	 * Scop  Sterge un contract de munca din BD
	 * 
	 * 
	 * @return nimic.
	 * 
	 */
							
	CV				getCVById(Integer idCV_) throws Exception;
	/**
	 * Scop  Returneaza datele unui CV dupa precizarea id-ului
	 * 
	 * @param idCV_  id-ul CVului, element unic de identificare pentru un CV, dupa care se face cautarea
	 * 
	 * @return Obiectul de tip CV 
	 * 
	 */
	Collection<CV>	getListaCVuri() throws Exception;
	/**
	 * Scop  Returneaza o lista cu toate CVurile
	 * 
	 * 
	 * @return o lista cu toate CVurile
	 * 
	 */
	CV				salveazaCV(CV cv_) throws Exception;
	/**
	 * Scop  Salveaza un CV in BD
	 * 
	 * 
	 * @return Obiectul de tip CV
	 * 
	 */
	void							stergeCV(CV cv_) throws Exception;
	/**
	 * Scop  Sterge un CV  din BD
	 * 
	 * 
	 * @return nimic.
	 * 
	 */
	
	
	DosarAngajat				getDosarAngajatById(Integer idDosarAngajat_) throws Exception;
	/**
	 * Scop  Returneaza datele unui DosarAngajat dupa precizarea id-ului
	 * 
	 * @param idDosarAngajat_  id-ul Dosarului Angajatului, element unic de identificare pentru un Dosar Angajat, dupa care se face cautarea
	 * 
	 * @return Obiectul de tip dosar Angajat 
	 * 
	 */
	Collection<DosarAngajat>	getListaDosareAngajat() throws Exception;
	/**
	 * Scop  Returneaza o lista cu toate Dosarele
	 * 
	 * 
	 * @return o lista cu toate Dosarele
	 * 
	 */
	DosarAngajat				salveazaDosarAngajat(DosarAngajat dosarAngajat_) throws Exception;
	/**
	 * Scop  Salveaza un Dosar Angajat in BD
	 * 
	 * 
	 * @return Obiectul de tip Dosar Angajat
	 * 
	 */
	void							stergeDosarAngajat(DosarAngajat dosarAngajat_) throws Exception;
	/**
	 * Scop  Sterge un DosarAngajat  din BD
	 * 
	 * 
	 * @return nimic.
	 * 
	 */
	
	
	
	
	

	Functie adaugaFunctie(Integer idFunctie, String numeFunctie) throws Exception;
	Functie getFunctie(Integer idFunctie) throws Exception;
	
	
	ActivitateTeamBuilding	creareActivitateTeamBld(Integer nrInscrisi_) throws PersonalExceptions;
	
	
	
	
	
	
	/**
	 * Scop    Creaza o noua activitate de team building
	 * 
	 * @param  nrInscrisi	numarul de persoane inscrise	 
	 * 
	 * @return o noua activitate  
	 * 
	 */
	Collection<AnuntLocMunca> getPosturiVacante(Date dataVizata_, Collection<AnuntLocMunca> ListaInit_);
	
	/**
	 * Scop    Returneaza o Lista cu posturile valide dupa o data precizata
	 * 
	 * @param  dataVizata_ 	Data setata de utilizator, care va fi comparata cu data anuntului de munca
	 * @param  ListaInit_ 	Lista cu toate anunturile existente
	 * 
	 * @return continutul fiecarui anunt valid 
	 * 
	 */
	
	Collection<Candidat> getCandidatipeFunctie(AnuntLocMunca anuntLocMunca_, Collection<CV> ListaInit_);
	
	/**
	 * Scop    Pentru fiecare anunt de loc de munca, returneaza o Lista cu candidatii care au aplicat cv-urile 
	 *          pentru functia precizata in anunt
	 * 
	 * @param  anuntLocMunca_ 	Anuntul locului de munca pentru care se vor afisa candidatii
	 * @param  ListaInit_ 	    Lista cu toate  cv-urile existente
	 * 
	 * @return Lista cu date despre candidati
	 * 
	 */
	
	
	Collection<Candidat> recrutare(Date dataAnunt_, Candidat candidat_, Collection<InterviuCandidat> ListaInit_);
	
	/**
	 * Scop    Returneaza o Lista cu candidatii care au au fost admisi la interviul final, interviu organizat dupa 
	 *         o data precizata
	 * 
	 * @param  dataAnunt_ 	    Data precizata de utilizator, care va fi comparata cu data sustinerii interviului
	 * @param  candidat_        Candidatul pentru care se afiseaza interviurile finale si admise
	 * @param  ListaInit_ 	    Lista cu toate  interviurile existente
	 * 
	 * @return Lista cu date despre candidati admisi la interviurile finale
	 * 
	 */
	
	
	
	HashMap <DummyDepartament, Collection<ProbaEvaluare>> getProbeEvaluareDepartament (Collection<ProbaEvaluare> probeEvaluareInit_, Collection<DummyDepartament> departamenteInit_);
	
	/**
	 * Scop    Returneaza o Lista a probelor grupate pe fiecare departament 
	 *         
	 * @param  probeEvaluareInit_ 	    Lista cu toate probele de evaluare
	 * @param  departamenteInit_ 	    Lista cu toate  departamentele existente
	 * 
	 * @return map cu fiecare departament si probele fiecaruia
	 * 
	 */
	

	HashMap<ProbaEvaluare, Collection<RezultatProbaEvaluare>> getRezultateEvaluareByProba (Collection <RezultatProbaEvaluare> angajatProbaInit_, Collection<ProbaEvaluare> probeEvaluareInit_);
	/**
	 * Scop    Returneaza Lista rezultatelor angajatilor la fiecare proba  
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
	
	
	Collection<ContractMunca> getListaContracteByAngajat(Angajat angajat_);
	
	/**
	 * Scop  			 Returneaza o Lista a contractelor de munca pentru un angajat precizat
	 * 
	 * @param  angajat_  Angajatul dupa care se face cautarea
	 * 
	 * @return           Lista contracte curente pentru un angajat
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

	void activareAngajati(Collection<Angajat> ListaAngajati);
	
	/**
	 * Scop                   Seteaza activ statusul unui angajat daca dosarul acestuia este complet
	 * 
	 * @param  ListaAngajati  Lista tuturor angajatilor pentru care se realizeaza operatiunea
	 * 
	 * @return           
	 * 
	 */
	Functie adaugareFunctie(String	numeFunctie_, Integer pozitiaInCOR_, Collection<String> obiective_, 
							Collection<String>	responsabilitati_, Collection<String>	cunostinte_, 
							Collection<String>	deprinderi_, Collection<String>	aptitudini_, DummyDepartament departament);
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
	
	
	Collection<Eveniment> getEvenimenteAnuale(Integer _year);//NMV>>metoda pentru evenimentele anuale
	/**
	 * @param _year anul pentru care trebuie returnata Lista de evenimente.
	 * Daca year = 0 va returna toate evenimentele din toti anii
	 * @return Collection evenimente pentru anul primit ca parametru
	 */	
	
	void aprobareEveniment(Eveniment _eveniment);
	/**
	 * @param _activitate //metoda ce determina daca un eveniment este aprobat sau nu in functie de suma alocata si estimata
	 * 
	 */
}

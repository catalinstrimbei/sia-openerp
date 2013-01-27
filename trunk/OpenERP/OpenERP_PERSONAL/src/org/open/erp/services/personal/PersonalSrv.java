package org.open.erp.services.personal;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.Departament;

/**
* @Dependente: NomGenSrv
* 
* @EntitatiNomGen: Persoana, Departament
* 
* @EntitatiLocale: Candidat, Anunt, CV, Interviu
* 
* @UseCase("Recrutare personal"):
* 
* 1.Creare anunturi pentru loc de munca
* 2.Primire CV-uri
* 3.Selectie candidati
* 4.Sustinere interviuri
* 5.Stabilirea listei de angajati

 @UseCase("Stabilire concedii"):
* 
* 1.Solicitare concediu
* 2. Analizare cerere
* 3. Luare decizie
* 4. Inregistrare concediu

@UseCase("Cheltuieli ocazionale cu personalul"):
* 
* 1.Solicitare cheltuiala
* 2. Analizare cerere
* 3. Luare decizie
* 4. Inregistrare cheltuiala
*
*/
public interface PersonalSrv {
	
	/**
	 * Se creaza un post nou
	 * 
	 * @param nivelStudii Nivelul minim de studii absolvite;
	 * @param salarMinim  Nivelul minim salarial pentru acest post
	 * @param dep Departamentul in care se creaza postul nou
	 * @return instanta Post nou creata
	 */
	Post crearePost(String nivelStudii, int salarMinim, Departament dep);
	
	/**
	 * Returneaza un anunt pentru un loc de munca vacant
	 * 
	 * @param titluAnunt      Descrierea postului vacant
	 * @param indexCOR        Codul postului din Clasificarea Ocupatiilor din Romania
	 * @param dataEmitere     Data emiterii anuntului	
	 * @param dataExpirare    Data la care expira anuntul
	 * @param cerintePost     Descrierea cunostintelor necesare pentru ocuparea postului
	 * 
	 * @return instanta Anunt nou creata
	 * 
	 */
	Anunt creareAnunt (String titluAnunt, Integer indexCOR, Date dataEmitere, Date dataExpirare, String cerintePost ,Post postLiber);
	
	/**
	 * Se creaza un anunt nou pe baza unuia existent
	 * 
	 * @param anuntNou Anuntul deja inregistrat
	 * 
	 * @return instanta Anunt nou creata
	 * 
	 */
	Anunt creareAnunt (Anunt anuntNou);
	
	/**
	 * Se creaza un candidat nou
	 * 
	 * @param nume          Numele candidatului
	 * @param prenume		Prenumele candidatului
	 * @param adresa		Adresa de resedinta a candidatului	
	 * @param telefon		Numarul de telefon al cadidatului
	 * @param email			Adresa de e-mail a conadidatului
	 * @param dataNasterii	Data nasterii
	 * @param sex			Un caracter ce defineste sexul femeiesc (F) sau barbatesc (B)
	 * 
	 * @return instanta Candidat nou creata
	 */
	
	Candidat creareCandidat(Integer id, String nume, String sex, String mail,
			String statutInCompanie, String stareCivila, String dataNastere,
			String telefon, Adresa adresa);
	
	/**
	 * Creaza un CV nou atribuit unei persoane
	 * 
	 * @param titular           Persoana care aplica pentru post
	 * @param studiiAbsolvite   Lista studiilor absolvite si perioada desfasurarii lor
	 * @param functiiOcupate    Lista functiilor ocupate si perioada aferenta lor
	 * @param limbiStraine      Lista cu limbile straine cunoscute si nivelul acestora
	 * @param aptitudini        Descrierea aptitudinilor
	 * 
	 * @return instant CV nou creata
	 * 
	 */
	CV creareCV (Candidat titular, List<Tuple<String,Date,Date>> studiiAbsolvite, List<Tuple<String,Date,Date>> functiiOcupate, List<DoubleParam<String,String>> limbiStraine,String aptitudini);

	/**
	 * Selectia candidatilor pentru interviu
	 * 
	 * @param listaCVCandidati  Lista CV-urilor primite de la candidati
	 * @param anuntPostLiber    Anuntul pentru care se face selectia
	 * 
	 * @return lista persoanelor ce corespund standardelor de selectie
	 * 
	 */
	List<Candidat> selectareCandidati(List<CV> listaCVCandidati,Anunt anuntPostLiber);
	
	/**
	 * Se creaza o proba de evaluare ca va fi folosita la un interviu
	 * 
	 * @param numeProba Numele testului efectuat
	 * 
	 * @return instanta ProbaEvaluare nou creata
	 */	
	ProbaEvaluare creareProbaEvaluare(String numeProba);
	
	/**
	 * Se creaza un angajat nou
	 * 
	 * @return instanta Angajat nou creata
	 */	
	Angajat creareAngajat(Integer id, String nume, String sex, String mail,
			String statutInCompanie, String stareCivila, String dataNastere,
			String telefon, Adresa adresa, ContractMunca cm);
	
	/**
	 * Crearea unui tip nou de interviu
	 * 
	 * @param numePost         Functia pentru care e sustinut interviul
	 * @param numeEvaluatori   Numele angajatilor firmei care asista la interviu  
	 * @param probeInterviu    Testele la care e supus candidatul pe parcursul interviului
	 * @param dataInterviu     Data la care are loc interviul
	 * 
	 * @return instanta Interviu nou creata
	 * 
	 */
	Interviu creareInterviu(Anunt titluAnunt, List<Angajat> numeEvaluatori, List<ProbaEvaluare> probeInterviu, Date dataInterviu);
	
	/**
	 * Se stabileste candidatul ce va fi angajat
	 * 
	 * @param interviuriEfectuate Lista interviurilor pentru ocuparea postului vacant
	 * 
	 * @return candidatul care e propus pentru angajare
	 * 
	 */
	void stabilireAngajatiNoi (Angajat angajatNou, ContractMunca cm, Post postAtribuit);
	
	/**
	 * Returneaza o cerere de concediu 
	 * 
	 * @param nrInregistrare      Numar cerere
	 * @param contract        Numarul de contract al angajatului ce solicita cererea
	 * @param dataCerere     Data depunerii cererii	
	 * @param dataAprobare    Data la care cererea a fost aprobata
	 * @param perioadaConcediu     Perioada de concediu
	 * @param tipConcediu		Tipul de concediu (de odihna/medical/maternal etc)
	 * @param status	Statusul cererii (aprobata/in curs de aprobare/ refuzata)
	 * 
	 * @return instanta Cerere nou creata
	 * 
	 */		
	CerereConcediu creareCerereConcediu (Integer nrInregistrare, ContractMunca contract, Date dataCerere, Date dataAprobare, Integer perioadaConcediu, String tipConcediu,
			String status);
	
	/**
	 * Se creaza o cerere noua pe baza uneia existente
	 * 
	 * @param CerereConcediu Concediul deja inregistrat
	 * 
	 * @return instanta Cerere nou creata
	 * 
	 */
	CerereConcediu creareCerereConcediu (CerereConcediu CerereConcediuNou);
	
	
	
	/**
	 * Returneaza o cerere de eveniment
	 * 
	 * @param nrInregistrare      Numar cerere
	 * @param contract        Numarul de contract al angajatului ce solicita cererea
	 * @param dataCerere     Data depunerii cererii	
	 * @param dataAprobare    Data la care cererea a fost aprobata
	 * @param perioadaEveniment     Perioada evenimentului
	 * @param tipEveniment		Tipul de eveniment (training / teambuiding etc.)
	 * @param status	Statusul cererii (aprobata/in curs de aprobare/ refuzata)
	 * 
	 * @return instanta Cerere nou creata
	 * 
	 */		
	CerereEveniment creareCerereEveniment (Integer nrInregistrare, ContractMunca contract, Date dataCerere, Date dataAprobare, Integer perioadaEveniment, String tipEveniment,
			String status);
	
	/**
	 * Se creaza o cerere noua pe baza uneia existente
	 * 
	 * @param CerereEveniment Evenimentul deja inregistrat
	 * 
	 * @return instanta Cerere nou creata
	 * 
	 */
	CerereEveniment creareCerereEveniment (CerereEveniment CerereEvenimentNou);
	
	/**
	 * Scop  Returneaza o Lista cu toti angajatii
	 * 
	 * 
	 * @return o lista cu toti Angajatii
	 * 
	 */
	 List<Angajat> getListaAngajati() throws Exception;

	 Angajat	getAngajatById(Integer idAngajat_) throws Exception;
/**
 * Scop  Returneaza datele despre un angajat dupa precizarea id-ului
 * 
 * @param idAngajat_  id-ul persoanei, element unic de identificare pentru o persoana din cadrul firmei, dupa care se face cautarea
 * 
 * @return Obiectul de tip Angajat 
 * 
 */

	 Angajat salveazaAngajat(Angajat angajat) throws Exception;


}
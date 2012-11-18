package org.open.erp.services.personal;

import java.util.Date;
import java.util.List;

/**
* @Dependente: NomGenSrv
* 
* @EntitatiNomGen: Persoana, Departament
* 
* @EntitatiLocale: Candidat, AnuntLocMunca, CV, Interviu
* 
* Recrutare personal:
* 
* @UseCase("1.Creare anunturi pentru loc de munca")
* 
* @UseCase("2.Primire CV-uri")
* 
* @UseCase("3.Selectie candidati")
*
* @UseCase("4.Sustinere interviuri")
* 
* @UseCase("5.Stabilirea listei de angajati")
*
*/
public interface PersonalSrv {
	
	/**
	 * Se creaza un post nou
	 * 
	 * @param nivelStudii Nivelul minim de studii absolvite;
	 * @param salarMinim  Nivelul minim salarial pentru acest post
	 * @return instanta Post nou creata
	 */
	Post crearePost(String nivelStudii, int salarMinim);
	
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
	
	Candidat creareCandidat(String nume, String prenume, String adresa, String telefon, String email, Date dataNasterii,char sex);
	
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
	CV creareCV (Candidat titular, Tuple<String,Date,Date> studiiAbsolvite, Tuple<String,Date,Date> functiiOcupate, DoubleParam<String,String> limbiStraine,String aptitudini);

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
	Candidat stabilireAngajatiNoi (List<Interviu> interviuriEfectuate);
}

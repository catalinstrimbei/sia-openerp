package org.open.erp.services.salarizare;

//import java.util.List;

import java.util.List;

import org.open.erp.services.personal.Angajat;

/**
 * 
 * @author ionut.hrubaru
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: PersonalSrv, NomenclatoareSrv
 * 
 * @EntitatiNomenclatoare: Persoana, Departament
 * 
 * @EntitatiPersonalSrv: Angajat
 * 
 * @EntitatiLocale: Pontaj, Retinere, Spor, Configurare, StatSalarii, CentralizatorStatSalarii 
 * 
 * @UseCase("inregistrare pontaj"):
 * 1. Creaza instanta pontaj
 * 2. Inregistrare pontaj pe angajat
 * *. Returneata pontaj initializat pentru un angajat
 * 
 * @UseCase("inregistrare pontaj la nivel de luna"):
 * 1. Creaza instanta pontaj pe fiecare angajat
 * 2. Incarcare angajati cu contract activ
 * 3. Inregistrare pontaj pe angajat pentru o anumita luna 
 * 
 * @UseCase("Adaugare ore suplimentare si de concediu"):
 * 1.Incarcare pontaj angajat
 * 2.Editare manuala a pontajului 
 * 3.Adaugare ore suplimentare si de concediu
 * 
 * @UseCase("Inregistrare stat salarii"):
 * 1.Incarcare lista pontaje
 * 2.Calcul sporuri
 * 3.Calcul venit brut
 * 3.Calcul retineri 
 * 4.Calcul Deduceri
 * 5.Calcul Impozit
 * 6.Calcul Venit Net
 * 7.Generare stat plata
 * 
 * @UseCase("Generare centralizator stat salarii")
 *  1.Incarcare calcule luna
 *  2.Agregare sume
 *  3.Generare totaluri pentru contabilitate
 * 
 *  
 */
public interface SalarizareSrv {
	/**
	 * Inregistreaza un pontaj pentru un anumit Angajat
	 * 
	 * @param idPontaj			id-ul pontajului
	 * @param angajat			Angajatul pentru care se creeaza pontajul
	 * @param an 				Anul pentru care se realizeaza pontajul
	 * @param luna 				Luna pentru care se realizeaza pontajul
	 * @param oreLucrate 		Numarul de ore lucrate 
	 * @param oreSupliemntare 	Numarul de ore suplimentare lucrate
	 * @param oreConcediu 		Numarul de ore concediu 
	 * 
	 * @return instanta Pontaj nou creata. 
	 * @throws Exception 
	 * 
	 */
	Pontaj inregistrarePontaj(Integer idPontaj, Angajat angajat, Integer an, Integer luna, Double oreLucrate, Double oreSuplimentare, Double oreConcediu) throws Exception;
	/**
	 * Inregistreaza pontajele tuturor angajatilor pornind de la numarul de ore lucratoare din luna
	 * 
	 * @param an 				Anul pentru care se realizeaza pontajul
	 * @param luna 				Luna pentru care se realizeaza pontajul
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void inregistrarePontajLuna(Integer an, Integer luna) throws Exception;
	//List<Pontaj> inregistrarePontajLuna(Integer an, Integer Luna); //o sa declare un array de angajati o sa-l ia din personal srv si pt fiecare o sa apeleze inregistrare Pontaj, si o sa puna in array de pontaje pe care il returneaza
	//void inregistrarePontajLunaAngajati(Integer an, Integer Luna, List<Angajat> angajat);
	
	
	/**
	 * Adauga ore concediu pt un anumit pontaj (insemnand un angajat/luna/an)
	 * 
	 * @param pontaj 			pontaj pe un angajat/an/luna
	 * @param oreConcediu 		Numarul de ore concediu
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void adaugaOreConcediu(Pontaj pontaj, Double oreConcediu) throws Exception;
	
	/**
	 * Adauga ore suplimentare pt un anumit pontaj (insemnand un angajat/luna/an)
	 * 
	 * @param pontaj 			pontaj pe un angajat/an/luna
	 * @param oreSuplimentare 	Numarul de ore suplimentare
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void adaugaOreSuplimentare(Pontaj pontaj, Double oreSuplimentare) throws Exception;
	
	/**
	 * Adauga spor pentru un angajat sau pt toti angajatii (practic e un create din CRUD)
	 * 
	 * @param id				Id-ul Sporului
	 * @param denumire			Denumirea Sporului
	 * @param tip				1=>La nivel de angajat, 2=>pt toti angajatii (angajat va fi trimis null)
	 * @param an 				Anul pentru care se adauga sporul
	 * @param luna 				Luna pentru care se adauga sporul
	 * @param angajat			Angajatul pentru care adauga sporul
	 * @param modCalcul			1=>suma fixa, 2=>procent din salarul de baza (obtinut de undeva din PersonalSrv)
	 * 
	 * @return  Spor
	 * @throws Exception 
	 * 
	 */
	Spor inregistrareSpor(Integer id, String denumire, Integer tip, Integer an, Integer luna, Angajat angajat, Integer modCalcul, Double valoare) throws Exception;
	
	/**
	 * Calculeaza sporuri pentru un angajat (poate avea mai multe intr-o luna) si le insumeaza 
	 * 
	 * @param an 				Anul pentru care se calculeaza sporurile
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza sporurile
	 * 
	 * @return  Double valoarea insumata a sporurilor
	 * @throws Exception 
	 * 
	 */
	Double calculSporuriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception;
	
	/**
	 * Calculeaza venitul brut pentru un anumit angajat - an si luna - insumeaza nr de ore + ore suplimentare - scade orele de concediu si aduna sporuri 
	 * 
	 * @param an 				Anul pentru care se calculeaza sporurile
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza sporurile
	 * 
	 * @return  Double - venitul brut
	 * @throws Exception 
	 * 
	 */
	Double calculVenitBrut(Integer an, Integer luna, Angajat angajat) throws Exception;
	
	/**
	 * Adauga o retinere pentru un angajat sau pt toti angajatii (practic e un create din CRUD)
	 * 
	 * @param denumire			id retinere
	 * @param denumire			Denumirea retinerii
	 * @param tip				1=>La nivel de angajat, 2=>pt toti angajatii (angajat va fi trimis null)
	 * @param an 				Anul pentru care se adauga sporul
	 * @param luna 				Luna pentru care se adauga sporul
	 * @param angajat			Angajatul pentru care adauga sporul
	 * @param modCalcul			1=>suma fixa, 2=>procent din salarul de baza (obtinut de undeva din PersonalSrv)
	 * 
	 * @return  Retinere
	 * @throws Exception 
	 * 
	 */
	Retinere inregistrareRetinere(Integer id, String denumire, Integer tip, Integer an, Integer luna, Angajat angajat, Integer modCalcul, Double valoare) throws Exception;
	
	/**
	 * Calculeaza retinerile pentru un angajat (poate avea mai multe intr-o luna) si le insumeaza - mai putin retinerile obligatorii
	 * 
	 * @param an 				Anul pentru care se calculeaza retinerile
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza retinerile
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	Double calculRetineriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception;
	
	/**
	 * Calculeaza retinerile obligatorii pentru un angajat - folosind configurarea procentelor CAS, CASS, Somaj si salarul brut 
	 * 
	 * @param an 				Anul pentru care se calculeaza retinerile
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza retinerile
	 * @tipRetinere				tipul - "CAS", "CASS", "Somaj"
	 * @venitBrut				venitul brut al angajatului (vezi metoda calculVenitBrut)
	 * 
	 * @return  Double - valoarea insumata a retinerilor obligatorii
	 * 
	 */
	Double calculRetineriObligatorii(Integer an, Integer luna, Angajat angajat, String tipRetinere, Double venitBrut);
	
	/**
	 * Calculeaza deducerile pentru un angajat - folosind numarul de copii din intretinere obitnuti din PersonalSrv 
	 * 
	 * @param an 				Anul pentru care se calculeaza deducerile
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza deducerile
	 * 
	 * @return  Double - valoarea deducerii
	 * 
	 */
	Double calculDeduceri(Integer an, Integer luna, Angajat angajat);
	
	/**
	 * Calculeaza impozitul pentru un angajat - folosind procentul de impozit din Configurare 
	 * 
	 * @param an 				Anul pentru care se calculeaza impozitul
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza impozitul
	 * @venitBrut				venitul brut al angajatului (vezi metoda calculVenitBrut)
	 * @cas						cas angajat (vezi metoda calculRetineriObligatorii)
	 * @cass					cass angajat (vezi metoda calculRetineriObligatorii)
	 * @somaj					somaj angajat (vezi metoda calculRetineriObligatorii)
	 * @retineriAlte			alte retineri angajat (vezi metoda calculRetineriAngajat)
	 * @deduceri				deduceri angajat (vezi metoda calculDeduceri
	 * 
	 * @return  Double - valoarea impozitului
	 * 
	 */
	Double calculImpozit(Integer an, Integer luna, Angajat angajat, Double venitBrut, Double cas, Double cass, Double somaj, Double retineriAlte, Double deduceri);
	
	/**
	 * Calculeaza salarul net pentru un angajat -  
	 * 
	 * @param an 				Anul pentru care se calculeaza salarul net
	 * @param luna 				Luna pentru care se calculeaza salarul net
	 * @param angajat			Angajatul pentru care se calculeaza salarul net
	 * @venitBrut				venitul brut al angajatului (vezi metoda calculVenitBrut)
	 * @cas						cas angajat (vezi metoda calculRetineriObligatorii)
	 * @cass					cass angajat (vezi metoda calculRetineriObligatorii)
	 * @somaj					somaj angajat (vezi metoda calculRetineriObligatorii)
	 * @impozit					impozit angajat (vezi metoda calculImpozit)
	 * @retineriAlte			alte retineri angajat (vezi metoda calculRetineriAngajat)
	 * @deduceri				deduceri angajat (vezi metoda calculDeduceri)
	 * 
	 * @return  Double - valoarea salarului net
	 * 
	 */
	Double calculSalarNet(Integer an, Integer luna, Angajat angajat, Double venitBrut, Double cas, Double cass, Double somaj, Double impozit, Double retineriAlte, Double deduceri);
	
	/**
	 * Inregistreaza statul de salariu pentru toti angajatiii 
	 * 
	 * @param an 				Anul pentru care se realizeaza statul de salarii
	 * @param luna 				Luna pentru care se realizeaza statul de salarii
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void inregistrarStatSalariiLuna(Integer an, Integer luna) throws Exception;	
	
	/**
	 * returneaza centralizatorul de salarii pentru toti angajatii (de folosit in contabilitate, obiectul statsalarii returnat va contine toate sumele de inregistrat) 
	 * de vorbit cu cei de la conta daca au nevoie de total sume sau pt fiecare angajat
	 * @param an 				Anul pentru care se returneaza statul de salarii
	 * @param luna 				Luna pentru care se returneaza statul de salarii
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	CentralizatorStatSalarii getCentralizatorStatSalariiLuna(Integer an, Integer luna) throws Exception;
	
	/**
	 * returneaza un angajat pornind de la id prin apelarea metodei corespunzatoare din Personal - singura diferenta e ca daca metoda din Personal nu intoarce nimic a
	 * atunci un angajat nou este creat 
	 * @param id 				Id-ul angajatului
	 * 
	 * @return Angajat  
	 * @throws Exception 
	 * 
	 */
	Angajat getAngajatById(Integer id) throws Exception;
	
	/**
	 * returneaza pontajul pentru un anumit angajat si o luna  
	 * @param an 				Anul pentru care se returneaza pontajul
	 * @param luna 				Luna pentru care se returneaza pontajul
	 * @param angajat			Angajatul pentru care se returneaza pontajul 
	 * 
	 * @return  Pontaj
	 * @throws Exception 
	 * 
	 */
	Pontaj getPontajByAngajat(Angajat angajat, Integer an, Integer luna) throws Exception;
	
	/**
	 * returneaza pontajele pentru un an si o luna  
	 * @param an 				Anul pentru care se returneaza pontajele
	 * @param luna 				Luna pentru care se returneaza pontajele
	 * 
	 * @return  List<Pontaj>
	 * @throws Exception 
	 * 
	 */
	List<Pontaj> getPontajAnLuna(Integer an, Integer luna) throws Exception;
	
	/**
	 * returneaza sporurile pentru un angajat specific, un an si o luna  
	 * @param an 				Anul pentru care se returneaza sporurile
	 * @param luna 				Luna pentru care se returneaza sporurile
	 * @param angajat			Angajatul pentru care se returneaza sporurile
	 * 
	 * @return  List<Spor>
	 * @throws Exception 
	 * 
	 */
	List<Spor> getSporuriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception;
	
	/**
	 * returneaza retinerile pentru un angajat specific, un an si o luna  
	 * @param an 				Anul pentru care se returneaza retinerile
	 * @param luna 				Luna pentru care se returneaza retinerile
	 * @param angajat			Angajatul pentru care se returneaza retinerile
	 * 
	 * @return  List<Retinere>
	 * @throws Exception 
	 * 
	 */
	List<Retinere> getRetineriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception;

	/**
	 * returneaza salariile tuturor angajatilor pentru un an si o luna  
	 * @param an 				Anul pentru care se returneaza salariile
	 * @param luna 				Luna pentru care se returneaza salariile
	 * 
	 * @return  List<StatSalarii>
	 * @throws Exception 
	 * 
	 */
	List<StatSalarii> getStatAnLuna(Integer an, Integer luna) throws Exception;
	
	/**
	 * genereaza centralizatorul de salarii pentru toti angajatii pentru un an si o luna 
	 * @param an 				Anul pentru care se returneaza statul de salarii
	 * @param luna 				Luna pentru care se returneaza statul de salarii
	 * 
	 * @return CentralizatorStatSalarii 
	 * @throws Exception 
	 * 
	 */
	CentralizatorStatSalarii inregistreazaCentralizatorStatSalariiLuna(Integer an, Integer luna) throws Exception;	
	
	/**
	 * sterge un centralizator de salarii pornind de la id 
	 * @param idCentralizator   id-ul centralizatorului care se doreste a fi sters 				I
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void stergeCentralizator(CentralizatorStatSalarii centralizator) throws Exception;
	
	/**
	 * returneaza sporurile generale care nu sunt legate de un angajat   
	 * @return  List<Spor>
	 * @throws Exception 
	 * 
	 */
	List<Spor> getSporuriGenerale() throws Exception;
	

	/**
	 * sterge un spor pornind de la id 
	 * @param idSpor   id-ul sporului care se doreste a fi sters 				I
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void stergeSpor(Spor spor) throws Exception;

	/**
	 * sterge o retinere 
	 * @param Retinere
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void stergeRetinere(Retinere retinere) throws Exception;
	
	/**
	 * sterge un pontaj  
	 * @param Pontaj   
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void stergePontaj(Pontaj pontaj) throws Exception;
	
	/**
	 * sterge un stat salarii  
	 * @param StatSalarii   
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void stergeStatSalarii(StatSalarii statSalarii) throws Exception;

	/**
	 * salveaza un stat salarii  
	 * @param StatSalarii   
	 * 
	 * @return StatSalarii 
	 * @throws Exception 
	 * 
	 */
	StatSalarii salveazaStatSalarii(StatSalarii statSalarii) throws Exception;

	/**
	 * returneaza retinerile generale care nu sunt legate de un angajat   
	 * @return  List<Retinere>
	 * @throws Exception 
	 * 
	 */
	List<Retinere> getRetineriGenerale() throws Exception;
	
	/**
	 * returneaza pontajul pentru un anumit angajat   
	 * @param angajat			Angajatul pentru care se returneaza pontajul 
	 * 
	 * @return  List<Pontaj>
	 * @throws Exception 
	 * 
	 */
	List<Pontaj> getPontajAngajatAll(Angajat angajat) throws Exception;
}

package org.open.erp.services.salarizare;
import java.util.List;

import org.open.erp.services.personal.Angajat;
public interface SRV_Salarizare {
	
	
	/**
	 * @EntitatiLocale: Pontaje, Retineri, Sporuri, Config, Stat_Salarii, Centralizare_Stat_Plata
	 * @Dependente:  NomenclatoareSrv, PersonalSrv,
	 * @EntitatiPersonalSrv: Angajat
	 * 

	 * 

	 * 
	 * 	 * @UseCase("Inregistrarea unui pontaj"):
	 * 1. Creaza instanta pontajului
	 * 2. Inregistrarea pontajul pentru un anume angajat
	 * *. Returneaza pontaj initializat pentru un angajat
	 * 
	 * @UseCase("inregistrare pontaj la nivel de luna"):
	 * 1. Creaza instanta pontaj pe fiecare angajat
	 * 2. Incarcare angajati cu contract activ
	 * 3. Inregistrare pontaj pe angajat pentru o anumita luna 
	 * 
	 * @UseCase("Generare centralizator stat salarii")
	 *  1.Incarcare calcule luna
	 *  2.Agregare sume
	 *  3.Generare totaluri pentru contabilitate
	 * 
	 *  
	 * 
	 * @UseCase("Adaugare ore suplimentare sau concediu"):
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
	 */
	
	/**
	 * Inregistreaza un pontaj pentru un anumit Angajat
	 * 
	 * @param cod_Pontaj			Cod-ul pontajului
	 * @param angajat			        Angajatul pentru care se creeaza pontajul
	 * @param Pontaj_an 				Anul pentru care se realizeaza pontajul
	 * @param Pontaj_luna 				Luna pentru care se realizeaza pontajul
	 * @param Pontaj_oreLucrate 		Numarul de ore lucrate 
	 * @param pontaj_oreSuplimentare 	Numarul de ore suplimentare lucrate
	 * @param Pontaj_oreConcediu 		Numarul de ore concediu 
	 * 
	 * @return instanta Pontaj nou creata. 
	 * @throws Exception 
	 * 
	 */
	Pontaje inregistrarePontaj(Integer cod_Pontaj, Angajat angajat, Integer Pontaj_an, Integer Pontaj_luna, Double Pontaj_oreLucrate, Double pontaj_oreSuplimentare, Double Pontakj_oreConcediu) throws Exception;
	/**
	 * Inregistreaza pontajele tuturor angajatilor pornind de la numarul de ore lucratoare din luna
	 * 
	 * @param Pontaj_an 				Anul pentru care se realizeaza pontajul
	 * @param Pontaj_luna 				Luna pentru care se realizeaza pontajul
	 * 
	 * @return  
	 * @throws Pontaj_oreConcediu 
	 * 
	 */

	void adaugaOreConcediu(Pontaje pontaje, Double oreConcediu) throws Exception;
	
	/**
	 * Adauga ore suplimentare pt un anumit pontaj (insemnand un angajat/luna/an)
	 * 
	 * @param pontaj 			        pontaj pe un angajat/an/luna
	 * @param pontaj_oreSuplimentare 	Numarul de ore suplimentare
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void inregistrarePontajLuna(Integer an, Integer luna) throws Exception;
	
	
	/**
	 * Adauga ore concediu pt un anumit pontaj (insemnand un angajat/luna/an)
	 *  
	 * @param pontaj 			         pontaj pe un angajat/an/luna
	 * @param Pontaj_oreConcediu 		Numarul de ore concediu
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void adaugaOreSuplimentare(Pontaje pontaje, Double oreSuplimentare) throws Exception;
	
	/**
	 * Adauga spor pentru un angajat sau pt toti angajatii (practic e un create din CRUD)
	 * 
	 * @param an 				Anul pentru care se adauga sporul
	 * @param luna 				Luna pentru care se adauga sporul
	 * @param angajat			Angajatul pentru care adauga sporul
	 * @param modCalcul			1=>suma fixa, 2=>procent din salarul de baza (obtinut de undeva din PersonalSrv)

	 * @param cod_Spor				Cod-ul Sporului
	 * @param denumire_Spor			Denumirea Sporului
	 * @param tip_Spor				1=>La nivel de angajat, 2=>pt toti angajatii (angajat va fi trimis null)
	 * 
	 * @return  Spor
	 * @throws Exception 
	 * 
	 */
	Sporuri inregistrareSpor(Integer cod_Spor, String denumire_Spor, Integer tip_Spor, Integer an, Integer luna, Angajat angajat, Integer modCalcul, Double valoare) throws Exception;
	
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
	 * @param cod_Retinere			Cod retinere
	 * @param denumire_Retinere			Denumirea retinerii
	 * @param tip_Retinere				1=>La nivel de angajat, 2=>pt toti angajatii (angajat va fi trimis null)
	 * @param an 				Anul pentru care se adauga sporul
	 * @param luna 				Luna pentru care se adauga sporul
	 * @param angajat			Angajatul pentru care adauga sporul
	 * @param mod_Calcul			1=>suma fixa, 2=>procent din salarul de baza (obtinut de undeva din PersonalSrv)
	 * 
	 * @return  Retinere
	 * @throws Exception 
	 * 
	 */
	Retineri inregistrareRetinere(Integer cod_Retinere, String denumire_Retinere, Integer tip_Retinere, Integer an, Integer luna, Angajat angajat, Integer modCalcul, Double valoare) throws Exception;
	
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
	 * @param Salariu_Brut				venitul brut al angajatului (vezi metoda calculVenitBrut)
	 * @param CAS						cas angajat (vezi metoda calculRetineriObligatorii)
	 * @param CASS					cass angajat (vezi metoda calculRetineriObligatorii)
	 * @param Somaj					somaj angajat (vezi metoda calculRetineriObligatorii)
	 * @param Impozit					impozit angajat (vezi metoda calculImpozit)
	 * @param Alte_Retineri			alte retineri angajat (vezi metoda calculRetineriAngajat)
	 * @param Deduceri				deduceri angajat (vezi metoda calculDeduceri)
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
	Centralizare_Stat_Plata getCentralizatorStatSalariiLuna(Integer an, Integer luna) throws Exception;
	
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
	 * @param Pontaj_an 				Anul pentru care se returneaza pontajul
	 * @param Pontaj_luna 				Luna pentru care se returneaza pontajul
	 * @param angajat			Angajatul pentru care se returneaza pontajul 
	 * 
	 * @return  Pontaj
	 * @throws Exception 
	 * 
	 */
	Pontaje getPontajByAngajat(Angajat angajat, Integer an, Integer luna) throws Exception;
	
	/**
	 * returneaza pontajele pentru un an si o luna  
	 * @param Pontaj_an 				Anul pentru care se returneaza pontajele
	 * @param Pontaj_luna 				Luna pentru care se returneaza pontajele
	 * 
	 * @return  List<Pontaje>
	 * @throws Exception 
	 * 
	 */
	List<Pontaje> getPontajAnLuna(Integer an, Integer luna) throws Exception;
	
	/**
	 * returneaza sporurile pentru un angajat specific, un an si o luna  
	 * @param an 				Anul pentru care se returneaza sporurile
	 * @param luna 				Luna pentru care se returneaza sporurile
	 * @param angajat			Angajatul pentru care se returneaza sporurile
	 * 
	 * @return  List<Sporuri>
	 * @throws Exception 
	 * 
	 */
	List<Sporuri> getSporuriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception;
	
	/**
	 * returneaza retinerile pentru un angajat specific, un an si o luna  
	 * @param an 				Anul pentru care se returneaza retinerile
	 * @param luna 				Luna pentru care se returneaza retinerile
	 * @param angajat			Angajatul pentru care se returneaza retinerile
	 * 
	 * @return  List<Retineri>
	 * @throws Exception 
	 * 
	 */
	List<Retineri> getRetineriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception;

	/**
	 * returneaza salariile tuturor angajatilor pentru un an si o luna  
	 * @param an 				Anul pentru care se returneaza salariile
	 * @param luna 				Luna pentru care se returneaza salariile
	 * 
	 * @return  List<Stat_Salarii>
	 * @throws Exception 
	 * 
	 */
	List<Stat_Salarii> getStatAnLuna(Integer an, Integer luna) throws Exception;
	
	/**
	 * genereaza centralizatorul de salarii pentru toti angajatii pentru un an si o luna 
	 * @param an 				Anul pentru care se returneaza statul de salarii
	 * @param luna 				Luna pentru care se returneaza statul de salarii
	 * 
	 * @return Centralizare_Stat_lata 
	 * @throws Exception 
	 * 
	 */
	Centralizare_Stat_Plata inregistreazaCentralizatorStatSalariiLuna(Integer An, Integer Luna) throws Exception;	
	
	/**
	 * sterge un centralizator de salarii pornind de la id 
	 * @param cod_Centralizator   cod-ul centralizatorului care se doreste a fi sters 				I
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void stergeCentralizator(Centralizare_Stat_Plata centralizator) throws Exception;
	
	/**
	 * returneaza sporurile generale care nu sunt legate de un angajat   
	 * @return  List<Sporuri>
	 * @throws Exception 
	 * 
	 */
	List<Sporuri> getSporuriGenerale() throws Exception;
	

	/**
	 * sterge un spor pornind de la id 
	 * @param Cod_Spor   id-ul sporului care se doreste a fi sters 				I
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void stergeSpor(Sporuri sporuri) throws Exception;

	/**
	 * sterge o retinere 
	 * @param Retineri
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void stergeRetinere(Retineri retineri) throws Exception;
	
	/**
	 * sterge un pontaj  
	 * @param Pontaje   
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void stergePontaj(Pontaje pontaje) throws Exception;
	
	/**
	 * sterge un stat salarii  
	 * @param Stat_Salarii   
	 * 
	 * @return  
	 * @throws Exception 
	 * 
	 */
	void stergeStatSalarii(Stat_Salarii stat_Salarii) throws Exception;

	/**
	 * salveaza un stat salarii  
	 * @param Stat_Salarii   
	 * 
	 * @return Stat_Salarii 
	 * @throws Exception 
	 * 
	 */
	Stat_Salarii salveazaStatSalarii(Stat_Salarii statSalarii) throws Exception;

	/**
	 * returneaza retinerile generale care nu sunt legate de un angajat   
	 * @return  List<Retinerei>
	 * @throws Exception 
	 * 
	 */
	List<Retineri> getRetineriGenerale() throws Exception;
	
	/**
	 * returneaza pontajul pentru un anumit angajat   
	 * @param angajat			Angajatul pentru care se returneaza pontajul 
	 * 
	 * @return  List<Pontaje>
	 * @throws Exception 
	 * 
	 */
	List<Pontaje> getPontajAngajatAll(Angajat angajat) throws Exception;
	
}

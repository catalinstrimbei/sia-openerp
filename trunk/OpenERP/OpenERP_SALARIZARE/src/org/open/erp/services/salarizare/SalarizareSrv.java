package org.open.erp.services.salarizare;

//import java.util.List;

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
	Pontaj inregistrarePontaj(Angajat angajat, Integer an, Integer luna, Double oreLucrate, Double oreSuplimentare, Double oreConcediu) throws Exception;
	/**
	 * Inregistreaza pontajele tuturor angajatilor pornind de la numarul de ore lucratoare din luna
	 * 
	 * @param an 				Anul pentru care se realizeaza pontajul
	 * @param luna 				Luna pentru care se realizeaza pontajul
	 * 
	 * @return  
	 * 
	 */
	void inregistrarePontajLuna(Integer an, Integer luna);
	//List<Pontaj> inregistrarePontajLuna(Integer an, Integer Luna); //o sa declare un array de angajati o sa-l ia din personal srv si pt fiecare o sa apeleze inregistrare Pontaj, si o sa puna in array de pontaje pe care il returneaza
	//void inregistrarePontajLunaAngajati(Integer an, Integer Luna, List<Angajat> angajat);
	
	
	/**
	 * Adauga ore concediu pt un anumit pontaj (insemnand un angajat/luna/an)
	 * 
	 * @param pontaj 			pontaj pe un angajat/an/luna
	 * @param oreConcediu 		Numarul de ore concediu
	 * 
	 * @return  
	 * 
	 */
	void adaugaOreConcediu(Pontaj pontaj, Double oreConcediu);
	
	/**
	 * Adauga ore suplimentare pt un anumit pontaj (insemnand un angajat/luna/an)
	 * 
	 * @param pontaj 			pontaj pe un angajat/an/luna
	 * @param oreSuplimentare 	Numarul de ore suplimentare
	 * 
	 * @return  
	 * 
	 */
	void adaugaOreSuplimentare(Pontaj pontaj, Double oreSuplimentare);
	
	/**
	 * Adauga spor pentru un angajat sau pt toti angajatii (practic e un create din CRUD)
	 * 
	 * @param denumire			Denumirea Sporului
	 * @param tip				1=>La nivel de angajat, 2=>pt toti angajatii (angajat va fi trimis null)
	 * @param an 				Anul pentru care se adauga sporul
	 * @param luna 				Luna pentru care se adauga sporul
	 * @param angajat			Angajatul pentru care adauga sporul
	 * @param modCalcul			1=>suma fixa, 2=>procent din salarul de baza (obtinut de undeva din PersonalSrv)
	 * 
	 * @return  Spor
	 * 
	 */
	Spor inregistrareSpor(String denumire, Integer tip, Integer an, Integer luna, Angajat angajat, Integer modCalcul, Double valoare);
	
	/**
	 * Calculeaza sporuri pentru un angajat (poate avea mai multe intr-o luna) si le insumeaza 
	 * 
	 * @param an 				Anul pentru care se calculeaza sporurile
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza sporurile
	 * 
	 * @return  Double valoarea insumata a sporurilor
	 * 
	 */
	Double calculSporuriAngajat(Integer an, Integer luna, Angajat angajat);
	
	/**
	 * Calculeaza venitul brut pentru un anumit angajat - an si luna - insumeaza nr de ore + ore suplimentare - scade orele de concediu si aduna sporuri 
	 * 
	 * @param an 				Anul pentru care se calculeaza sporurile
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza sporurile
	 * 
	 * @return  Double - venitul brut
	 * 
	 */
	Double calculVenitBrut(Integer an, Integer luna, Angajat angajat);
	
	/**
	 * Adauga o retinere pentru un angajat sau pt toti angajatii (practic e un create din CRUD)
	 * 
	 * @param denumire			Denumirea retinerii
	 * @param tip				1=>La nivel de angajat, 2=>pt toti angajatii (angajat va fi trimis null)
	 * @param an 				Anul pentru care se adauga sporul
	 * @param luna 				Luna pentru care se adauga sporul
	 * @param angajat			Angajatul pentru care adauga sporul
	 * @param modCalcul			1=>suma fixa, 2=>procent din salarul de baza (obtinut de undeva din PersonalSrv)
	 * 
	 * @return  Retinere
	 * 
	 */
	Retinere inregistrareRetinere(String denumire, Integer tip, Integer an, Integer luna, Angajat angajat, Integer modCalcul, Double valoare);
	
	/**
	 * Calculeaza retinerile pentru un angajat (poate avea mai multe intr-o luna) si le insumeaza - mai putin retinerile obligatorii
	 * 
	 * @param an 				Anul pentru care se calculeaza retinerile
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza retinerile
	 * 
	 * @return  
	 * 
	 */
	Double calculRetineriAngajat(Integer an, Integer luna, Angajat angajat);
	
	/**
	 * Calculeaza retinerile obligatorii pentru un angajat - folosind configurarea procentelor CAS, CASS, Somaj si salarul brut 
	 * 
	 * @param an 				Anul pentru care se calculeaza retinerile
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza retinerile
	 * @tipRetinere				tipul - "CAS", "CASS", "Somaj"
	 * 
	 * @return  Double - valoarea insumata a retinerilor obligatorii
	 * 
	 */
	Double calculRetineriObligatorii(Integer an, Integer luna, Angajat angajat, String tipRetinere);
	
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
	 * 
	 * @return  Double - valoarea impozitului
	 * 
	 */
	Double calculImpozit(Integer an, Integer luna, Angajat angajat);
	
	/**
	 * Calculeaza salarul net pentru un angajat -  
	 * 
	 * @param an 				Anul pentru care se calculeaza impozitul
	 * @param luna 				Luna pentru care se calculeaza
	 * @param angajat			Angajatul pentru care se calculeaza impozitul
	 * 
	 * @return  Double - valoarea salarului net
	 * 
	 */
	Double calculSalarNet(Integer an, Integer luna, Angajat angajat);
	
	/**
	 * Inregistreaza statul de salariu pentru toti angajatiii 
	 * 
	 * @param an 				Anul pentru care se realizeaza statul de salarii
	 * @param luna 				Luna pentru care se realizeaza statul de salarii
	 * 
	 * @return  
	 * 
	 */
	void inregistrarStatSalariiLuna(Integer an, Integer luna);	
	
	/**
	 * returneaza statul de salariu pentru toti angajatii (de folosit in contabilitate, obiectul statsalarii returnat va contine toate sumele de inregistrat) 
	 * de vorbit cu cei de la conta daca au nevoie de total sume sau pt fiecare angajat
	 * @param an 				Anul pentru care se returneaza statul de salarii
	 * @param luna 				Luna pentru care se returneaza statul de salarii
	 * 
	 * @return  
	 * 
	 */
	CentralizatorStatSalarii getStatSalariiLuna(Integer an, Integer luna);
}

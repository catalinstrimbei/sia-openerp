package org.open.erp.services.stocuri;

import org.open.erp.services.nomenclatoare.Material;
import org.open.erp.services.nomenclatoare.Produs;
/**
 * 
 * @author echipa.stocuri
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: AchizitionareSrv, NomGenSrv, PersonalSrv
 * 
 * @EntitatiNomGen: Produs, Material, MijlocCirculant
 * 
 * @EntitatiAlteSrv: CerereAprovizionare, Angajat
 * 
 * @EntitatiLocale: ComandaMateriale, BonConsum, Depozit, Gestionar, Gestiune
 * 
 * @UseCase("intrare, transfer, iesire din stoc"):
 * 1. Intrarea in stoc a unor mijloace circulante
 * 2. Transferul mijloacelor circulante
 * 3. Iesirea mijloacelor circulante
 * *. Returneaza stocul unui produs dintr-o gestiune
 * *. Returneaza pretul articolului dupa aplicarea metodei de calcul
 * *. Verifica daca un produs este in stoc
 *  
 * @UseCase("intrare, transfer, iesire din stoc"):
 *  
 */
public interface StocuriSrv {
	/**
	 * Returneaza void
	 * 
	 * @param Material 		Denumirea materialului intrat
	 * @param LoturiIntrari 	Lotul de intrare
	 * @param Gestiune 	Gestiunea pentru care se realizeaza intararea
	
	 * 
	 * @return instanta intrareInStoc nou creata 
	 * 
	 */
	void intrareInStoc(Material material, LoturiIntrari lot, Gestiune gestiune);
	/**
	 * Returneaza void
	 * 
	 * @param gestiuneOut 	Gestiunea pentru din care se realizeaza iesirea	
	 * @param gestiuneIn 	Gestiunea pentru care se realizeaza intararea
	 * @param material 	Denumirea Mijlocului Circulant intrat
	 * @param cantitate 	Cantitatea care este transferata	
	 
	 * 
	 * @return instanta transfer nou creat
	 * 
	 */
	void transfer(Gestiune gestOut, Gestiune gestIn, Material material, Integer cantitate);
	BonConsum consumProductie(CerereAprovizionare comMateriale);
	/**
	 * Returneaza void
	 * 
	 * @param comProd 	comanda pe baza careia se realizeaza iesirea
	 
	 * 
	 * @return instanta iesire nou creata
	 * 
	 */
    void iesireVanzare(ComandaProduse comProd);
    /**
	 * Scop					Returneaza stocul unui produs dintr-o anumita gestiune
	 * 
	 * @param produs 		Produsul pentru care dorim sa aflam stocul
	 * @param gestiune 		gestiunea din care face parte produsul
	 * 	
	 * @return				Valoare reprezentand stocul produsului 
	 * 
	 */	
	Integer getStocProdusByGestiune(Produs produs, Gestiune gestiune);
	/**
	 * Scop					Returneaza pretul unui articol dupa aplicarea metodei de calcul
	 * 
	 * @param articol 		Articolul pentru care se calculeaza pretul
	 * 	
	 * @return				Valoare(suma) reprezentand pretul articolului 
	 * 
	 */	
	Double getPretArticolAplicareMetodaCalcul(ArticolStoc articol);
	/**
	 * Scop					Returneaza stocul unui produs 
	 * 
	 * @param produs 		Produsul pentru care dorim sa aflam stocul
	 * 	
	 * @return				Valoare reprezentand stocul produsului 
	 * 
	 */	
	Integer verificareStocMaterial(Material material);
}

package org.open.erp.services.stocuri;

import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.Produs;

/**
 * @author echipa.stocuri
 * 
 * @ApplicationServiceFacade
 * 
 * 
 * @Dependente: Achizitii, Vanzari, Productie
 * 
 * @EntitatiAchizitii: Produs
 * 
 * @EntitatiVanzari: Produs
 * 
 * @EntitatiProductie: Produs (semifabricat, produs finit)
 * 
 * @EntitatiLocale: Lot sau Stoc
 * 
 * @UseCase("1. Creare lot nou"):
 * 
 * @UseCase("2. Intrare in stoc"):
 * 
 * @UseCase("3. Iesire din stoc")
 * 
 * @UseCase("4. Verificare stoc curent"):
 *
 * @UseCase("5. Transfer intre gestiuni"):
 * 
 * @UseCase("6. Alerta stoc curent"):
 * 
 * @UseCase("7. Casare/Eliminare lot"):
 * 
 */

public interface StocuriSrv {
	
	/** 1. Intrare in stoc
	 * Returneaza void
	 * 
	 * @param Produs 			Denumirea produs intrat
	 * @param Gestiune 			Gestiunea pentru care se realizeaza intararea
	
	 * 
	 * @return instanta intrareStoc nou creata 
	 * 
	 */
	
	void intrareStoc(Produs produs, Gestiune gestiunea);
	
	
	/** 2. Verificare stoc
	 * Returneaza stocul unui produs dintr-o gestiune
	 * 
	 * @param Produs		Produsului pentru care dorim sa aflam stocul
	 * @param Gestiune		Gestiunea in care dorim sa aflam stocul
	 * @return 				Valoarea reprezentand stocul produsului		
	 * 
	 */
	
	Double verificareStoc(Produs produs,Gestiune gestiune);
	
	
	/** 3. Iesire din stoc
	 * Returneaza void
	 * 
	 * @param Produs 			Denumirea produsului care iese din gestiune
	 * @param cantitate 		cantitate care iese
	
	 * 
	 * @return instanta iesireStoc nou creata 
	 * 
	 */
	
	
	void iesireStoc(Produs produs, Gestiune gestiune, Double cantitate);
	
	/** 4. Transfer intre getsiuni
	 * Returneaza void
	 * 
	 * @param produs	 		Denumirea produs care este transferat
	 * @param gestiuneIesire 	Gestiunea pentru din care se realizeaza iesirea	
	 * @param gestiuneIntrare 	Gestiunea pentru care se realizeaza intararea
	 * @param cantitate 		Cantitatea care este transferata	
	 
	 * 
	 * @return instanta transfer nou creat
	 * 
	 */
	
	void transfer(Produs produs, Gestiune gestiuneIesire, Gestiune gestiuneIntrare);
	
	void alertaStoc(Articol articol);
	
	
	
	void casareLot();
	
	// verifica daca exista un lot pentru un produs si o gestiune, folosit la instrare in stoc
		//boolean existaArticol(Produs produs, Gestiune gestiune);
		
		
		public Articol getArticolByGestiune(Produs produs, Gestiune gestiune);
		
		public void creareLot(Produs produs, Gestiune gestiune);
	
	void setAchizitiiSrv(AchizitiiSrv achizitiiSrv);
}
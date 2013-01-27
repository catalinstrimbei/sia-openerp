package org.open.erp.services.stocuri;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import org.open.erp.services.nommat.Material;
//import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.stocuri.ListaGestiuni;

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

@Remote
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
	
	void intrareStoc(Material material, Double cantitate, Double Pret, Gestiune gestiunea) throws Exception;
	
	void intrareStoc(BonTransfer bonTransfer, Double pret) throws Exception;
	
	public void intrareStoc(Material material, Gestiune gestiune, Double cantitate) throws Exception;
	
	public void adaugareArtLot(Material material, Double cantitate, Double pret, Gestiune gestiune) throws Exception;
	
	
	
	
	/** 2. Verificare stoc
	 * Returneaza stocul unui produs dintr-o gestiune
	 * 
	 * @param Produs		Produsului pentru care dorim sa aflam stocul
	 * @param Gestiune		Gestiunea in care dorim sa aflam stocul
	 * @return 				Valoarea reprezentand stocul produsului		
	 * 
	 */
	
	Double verificareStoc(Material produs,Gestiune gestiune);
	
	public Double verificareStoc(Material material, ListaGestiuni listagest);
	
	Double verificareStoc(Material material);
	
	
	/** 3. Iesire din stoc
	 * Returneaza void
	 * 
	 * @param Produs 			Denumirea produsului care iese din gestiune
	 * @param cantitate 		cantitate care iese
	
	 * 
	 * @return instanta iesireStoc nou creata 
	 * 
	 */
	
	
	void iesireStoc(Material material,  Double cantitate, Gestiune gestiune) throws Exception;
	
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
	
	void transfer(BonTransfer bonTransfer) throws Exception;
	
	void alertaStoc(Articol articol);
	
	public Articol getArticolByGestiune(Material produs, Gestiune gestiune);
	
	public ListaGestiuni GestiuniDisponibile ();
	
	
	//constrct
	public Depozit creareDepozit(String locatie) throws Exception;
	
	public Articol creareArticol(Double cantPeGestiune,
			Gestiune gestiune, Material material, List<Loturi> loturiArticole) throws Exception;
	
	public Loturi creareLot(Double cantitate, Double pretIntrare, Date dataIntrare, Articol articol) throws Exception;
	
	public Gestiune creareGestiune(String denumire, Depozit depozit) throws Exception;

	public BonTransfer creareBonTransfer(Material material, Double cantitate, Gestiune gestiuneIntrare, Gestiune gestiuneIesire) throws Exception;

	public Material creareMaterial(Material mat) throws Exception;

	public Material getMaterial(String i) throws Exception;
	
	// verifica daca exista un lot pentru un produs si o gestiune, folosit la instrare in stoc
	//boolean existaArticol(Produs produs, Gestiune gestiune);
	//void casareLot();
	//void setAchizitiiSrv(AchizitiiSrv achizitiiSrv);
	//void setNomenclatorMaterialeSrv(NomenclatorMaterialeSrv NomenclatorMaterialeSrv);
}

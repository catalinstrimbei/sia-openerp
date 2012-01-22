package org.open.erp.services.productie;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Remote;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.stocuri.BonConsum;

/**
 * 
 * @author Echipa_Productie;
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: StocuriSrv, NomGenSrv, PersonalSrv;
 * 
 * @EntitatiNomGen: Departament, Material, MijlocFix, Persoana, Produs;
 * 
 * @EntitatiPersonal: Angajat, Functie;
 * 
 * @EntitatiStocuri: ArticolStoc;
 *
 * @EntitatiLocale: ComandaProductie, CriteriuCalitate, FazaProductie, FluxProductie,
 * FunctieNecesara, SectieProductie, Semifabricat, Utilaj.
 * 
 * @UseCase("definire flux productie"):
 * 1. Definire faze productie
 * 2. Definire resurse
 *   
 * @UseCase("lansare comanda"):
 * 1. Primire comanda
 * 2. Lansare comanda
 * 3. Controlul calitatii
 * 4. Livrare comanda
 * 5. Returneaza cantitatile de produse finale si deseuri
 * 
 *@UseCase ("inregistrare gestiune"):
 *1. calcul consum resurse
 *2. calcul produse finale si deseuri 
 *
 */
//@Remote
public interface ProductieSrv {

	/**
	 * Creaza un flux de productie pentru produs.
	 * 
	 * @param idFlux    Id-ul fluxului
	 * @param produs; 	Produsul pentru care se creaza fluxul
	 * 
	 * @return 	semifabricat/produs in functie de faza la care se gaseste 
	 * 			(prin apelarea functiilor procesareSemifabricat() si procesareProdus()). 
	 * @throws Exception 
	 * 
	 */
	
	public FluxProductie definireFluxProductie(Integer idFlux, Produs produs) throws Exception;
	
	
	/**
	 * Creaza o faza de productie pentru flux.
	 * 
	 * 
	 * @param ......................
	 * 
	 * @return 	semifabricat/produs in functie de faza la care se gaseste 
	 * 			(prin apelarea functiilor procesareSemifabricat() si procesareProdus()). 
	 * @throws Exception 
	 * 
	 */
	
	public FazaProductie definireFazaProductie(String faza, FluxProductie flux,
			Utilaj utilaj, Double timpFolosire, ArrayList<FunctieNecesara> functiiNecesare,
			ArrayList<Material> materialeReteta,
			Semifabricat semifabricatDorit, Produs produsDorit,
			Divizie sectie, Integer nrOrdine, Boolean isFinal) throws Exception; 
	
	
	/**
	 * Apeleaza fluxul de productie si creaza produsul pentru care s-a facut comanda
	 * @param produs	Produsul pentru care s-a facut comanda;
	 * @param comanda	Comanda primita.
	 * 
	 * @return 	Produsul creat.
	 */
	public Produs lansareComandaProductie (ComandaProductie comanda, Produs produs)  throws Exception;
	
	/**
	 * Contorizeaza consumul de resurse
	 * @param faza 		Faza in care se consuma resursele cerute
	 * @param produs    Produsul pentru care se consuma resursele
	 * 
	 * @return 	Lista de resurse (utilaje,materiale,angajati)
	 */
	public ArrayList<Object> consumResursa(FazaProductie faza, Produs produs) throws Exception;
	
	/**
	 * Realizeaza controlul calitatii pentru fiecare unitate de produs
	 * @param produs	Produsul pentru care se face controlul calitatii
	 * 
	 * @return	Cantitatea de produse finite si cantitatea de deseuri (sub forma unei liste)
	 */
	public ArrayList<Integer> controlCalitate (Produs produs)  throws Exception;
	
	/**
	 * Trimite cantitatea de produs final obtinut catre modulul de stocuri
	 * @param cantitateProdus	Cantitatea de produse finale
	 * @param produs			Produsul livrabil
	 * @return		Cantiatea de produs final care va fi adaugata la cantitatea din stocuri.
	 */
	public Integer livrareProdus(Integer cantitateProdus, Produs produs)  throws Exception;
	
	/**
	 * Gestioneaza consumul de resurse pentru a fi preluat de contabilitatea de gestiune
	 * @param produs	Produsul pentru care se gestioneaza consumul de resurse
	 * 
	 * @return 	Lista de resurse consumate
	 */
	public ArrayList<Object> inregistrareGestiuneConsum(FazaProductie faza, Produs produs)  throws Exception;
	
	/**
	 * Gestioneaza cantitatea de produse obtinute
	 * @param produs	Produsul penru care se gestioneaza productia
	 * 
	 * @return	Cantitatea de produse finale si deseuri.
	 */
	public ArrayList<Integer> inregistrareGestiuneProductie(Produs produs)  throws Exception;

	FluxProductie getFlux(Integer idFlux) throws Exception;
	
	public void fabricare(Produs produs, Integer idFlux) throws Exception;
	public FazaProductie getFazaFlux(FluxProductie flux,Integer nrOrdine) throws Exception;
	
	public void comandaMateriale(FazaProductie faza, FluxProductie flux) throws Exception;
	
	
}

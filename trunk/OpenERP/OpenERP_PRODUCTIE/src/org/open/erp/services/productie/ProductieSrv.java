package org.open.erp.services.productie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.Angajat;
//import org.open.erp.services.stocuri.BonConsum;

/**
 * 
 * @author Echipa_Productie;
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: StocuriSrv, NomGenSrv, PersonalSrv;
 * 
 * @EntitatiNomGen: Divizie, Departament,MateriePrima, Material, MijlocFix, 
 * Persoana, Produs, Document, LinieDocument;
 * 
 * @EntitatiPersonal: Angajat, Functie;
 * 
 * @EntitatiStocuri: ArticolStoc, CerereAprovizionare;
 *
 * @EntitatiLocale: ComandaProductie, CriteriuCalitate, FazaProductie, FluxProductie,
 * FunctieNecesara, Semifabricat, Utilaj.
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
@Remote
public interface ProductieSrv {

	/**
	 * Creaza un flux de productie pentru produs.
	 * 
	 * @param idFlux    Id-ul fluxului care se doreste a fi definit
	 * @param produs; 	Produsul pentru care se creaza fluxul
	 * 
	 * @return Fluxul pentru produsul primit ca parametru
	 * @throws Exception 
	 * 
	 */
	public FluxProductie definireFluxProductie(Integer idFlux, Produs produs) throws Exception;
	
	
	/**
	 * Creaza o faza de productie pentru flux.
	 * 
	 * 
	 * @param faza				Faza curenta curenta
	 * @param flux				Fluxul pentru care apartie faza curenta
	 * @param utilaj			Utilajul folosit in faza curenta de productie
	 * @param timpFolosire		Timpul in care utilajul este folosit
	 * @param functiiNecesare	Functiile necesare ale angajatilor pentru realizarea fazei curente
	 * @param materialeReteta	Materialele care sunt incluse in reteta, pentru faza curenta
	 * @param semifabricatDorit	Semifabricatul care se doreste a se obtine la sfarsitul fazei curente
	 * 							(parametrul este null in ultima faza si se foloseste doar in fazele intermediare)
	 * @param produsDorit		Produsul care se doreste a se obtine la sfarsitul fazei
	 * 							(parametrul este null in fazele intermediare si se foloseste doar in faza finala)
	 * @param sectie			Sectia in care se desfasoara faz curenta
	 * @param nrOrdine			Numarul de ordine al fazei curente in vadrul fluxului 
	 * 							(pentru a determina daca este faza prima faza sau faza intermediara)
	 * @param isFinal			Parametru ce indica daca faza curenta este finala sau nu
	 * 
	 * 
	 * @return                  Faza de productie pentru fluxul primit ca parametru
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
	 * @return 	        Lista de resurse (utilaje,materiale,angajati)
	 */
	public ArrayList<Object> consumResursa(FazaProductie faza, Produs produs) throws Exception;
	
	/**
	 * Realizeaza controlul calitatii pentru fiecare unitate de produs
	 * @param produs	Produsul pentru care se face controlul calitatii
	 * 
	 * @return	        Cantitatea de produse finite si cantitatea de deseuri (sub forma unei liste)
	 */
	public ArrayList<Integer> controlCalitate (Produs produs)  throws Exception;
	
	/**
	 * Trimite cantitatea de produs final obtinut catre modulul de stocuri
	 * @param cantitateProdus	Cantitatea de produse finale
	 * @param produs			Produsul livrabil
	 * @return		            Cantiatea de produs final care va fi adaugata la cantitatea din stocuri.
	 */
	public Integer livrareProdus(Integer cantitateProdus, Produs produs)  throws Exception;
	
	/**
	 * Gestioneaza consumul de resurse pentru a fi preluat de contabilitatea de gestiune
	 * @param faza		Faza de productie pentru care se inregistreaza consumul de resurse
	 * @param produs	Produsul pentru care se gestioneaza consumul de resurse
	 * 
	 * @return 	        Lista de resurse consumate
	 */
	public ArrayList<Object> inregistrareGestiuneConsum(FazaProductie faza, Produs produs)  throws Exception;
	
	/**
	 * Gestioneaza cantitatea de produse obtinute
	 * @param produs	Produsul penru care se gestioneaza productia
	 * 
	 * @return	        Cantitatea de produse finale si deseuri.
	 */
	public ArrayList<Integer> inregistrareGestiuneProductie(Produs produs)  throws Exception;

	/**
	 * Metoda care preia fluxul in functie de id-ul primit ca parametru
	 * @param idFlux	Fluxul care se doreste a fi preluat
	 * 
	 * @return          Fluxul dorit
	 * @throws Exception
	 */
	FluxProductie getFlux(Integer idFlux) throws Exception;
	
	/**
	 * Metoda care realizeaza fabricarea semifabricatelor/produsului final 
	 * pentru fiecare faza a fluxului
	 *  
	 * @param produs	Produsul pentru care se realizeaza fabricarea
	 * @param idFlux	Fluxul pentru care se realizeaza procesarea.
	 * @throws Exception
	 */
	public void fabricare(Produs produs, Integer idFlux) throws Exception;
	
	/**
	 * Metoda care preia faza unui flux in functie de numarul de ordine.
	 * 
	 * @param flux		Fluxul din care se doreste sa se preia faza
	 * @param nrOrdine	Numarul fazei dorite.
	 * @return          faza de productie dorita
	 * 
	 * @throws Exception
	 */
	public FazaProductie getFazaFlux(FluxProductie flux,Integer nrOrdine) throws Exception;
	
	/**
	 * Metoda care realizeaza comanda de materiale necesare unei anumite faze dintr-un anumit flux
	 * 
	 * @param faza	Faza pentru care se face comanda de materiale
	 * @param flux	Fluxul in care se doreste faza
	 * 
	 * @throws Exception
	 */
	public void comandaMateriale(FazaProductie faza, FluxProductie flux) throws Exception;
	
	public List<FluxProductie> getListaFluxuri() throws Exception;
	
	void stergeFlux(FluxProductie flux) throws Exception;
	
	public List<Semifabricat> getListaSemifabricate() throws Exception;
	
	public List<CriteriuCalitate> getCriteriiCalitate() throws Exception;
	
	void stergeCriteriuCalitate(CriteriuCalitate criteriu) throws Exception;
	
	public CriteriuCalitate salveazaCriteriuCalitate(Integer idCriteriu, String criteriu) throws Exception;
	
	public FazaProductie getFazaProductie(String faza) throws Exception; 
	
	public List<FazaProductie> getListaFaze() throws Exception;
	
	public void stergeFaza(FazaProductie faza) throws Exception;
}

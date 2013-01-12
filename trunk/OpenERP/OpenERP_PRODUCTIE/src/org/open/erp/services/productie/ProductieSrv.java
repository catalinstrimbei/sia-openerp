package org.open.erp.services.productie;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nommat.Material;


/**
 * 
 * @author Echipa_Productie;
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: StocuriSrv, NomenclatoareSrv, NomenclatoareMaterialeSrv, PersonalSrv;
 * 
 * @EntitatiNomenclatoare: Divizie, Departament, MijlocFix, Persoana, Document, LinieDocument;
 * 
 * @EntitatiNomenclatorMateriale: MateriePrima, Material, Produs;
 * 
 * @EntitatiPersonal: Angajat, Functie;
 * 
 * @EntitatiStocuri: ArticolStoc;
 *
 * @EntitatiLocale: ComandaProductie, CerereAprovizionare, CriteriuCalitate, FazaProductie, FluxProductie,
 * FunctieNecesara, Semifabricat, Utilaj.
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
	
	/**
	 * Metoda care returneaza lista tuturor fluxurilor
	 * 
	 * @return lista de fluxuri
	 * @throws Exception
	 */
	public List<FluxProductie> getListaFluxuri() throws Exception;
	
	/**
	 * Metoda care sterge un anumit flux de productie
	 * 
	 * @param flux	Fluxul de productie care se doreste a fi sters
	 * @throws Exception
	 */
	void stergeFlux(FluxProductie flux) throws Exception;
	
	/**
	 * Metoda care returneaza lista tuturor semifabricatelor
	 * 
	 * @return lista de semifabricae
	 * @throws Exception
	 */
	public List<Semifabricat> getListaSemifabricate() throws Exception;
	
	/**
	 * Metoda care sterge un anumit semifabricat
	 * 
	 * @param semifabricat	Semifabricatul care se doreste a fi sters
	 * @throws Exception
	 */
	public void stergeSemifabricat(Semifabricat semifabricat) throws Exception;
	
	/**
	 * Metoda care salveaza un anumit semifabricat
	 * 
	 * @param idSemifabricat	Id-ul semifabricatului
	 * @param semifabricat		Denumirea semifabricatului
	 * @param listaMateriale	Lista de materiale necesare crearii semifabricatului
	 * @param semifabricatContinut	Un alt semifabricat necesar crearii semifabricatului curent
	 * @return	Semifabricatul
	 * @throws Exception
	 */
	public Semifabricat salveazaSemifabricat(Integer idSemifabricat, String semifabricat,
			ArrayList<Material> listaMateriale,
			Semifabricat semifabricatContinut) throws Exception;
	
	/**
	 * Metoda care returneaza lista criteriile de calitate
	 * 
	 * @return	lista criteriilor de calitate
	 * @throws Exception
	 */
	public List<CriteriuCalitate> getCriteriiCalitate() throws Exception;
	
	/**
	 * Metdoda care sterge un criteriu de calitate
	 * 
	 * @param criteriu	Criteriul care se doreste a fi sters
	 * @throws Exception
	 */
	void stergeCriteriuCalitate(CriteriuCalitate criteriu) throws Exception;
	
	/**
	 * Metoda care salveaza un criteriu de calitate
	 * 
	 * @param idCriteriu	Id-ul criteriului
	 * @param criteriu		Denumirea criteriului
	 * @return		Criteriul de calitate
	 * @throws Exception
	 */
	public CriteriuCalitate salveazaCriteriuCalitate(Integer idCriteriu, String criteriu) throws Exception;
	
	/**
	 * Metoda care returneaza o anumita faza de productie
	 * 
	 * @param faza	Denumirea fazei
	 * @return		Faza dorita
	 * @throws Exception
	 */
	public FazaProductie getFazaProductie(String faza) throws Exception; 
	
	/**
	 * Metoda care returneaza lista tuturor fazelor
	 * 
	 * @return	Lista de faze
	 * @throws Exception
	 */
	public List<FazaProductie> getListaFaze() throws Exception;
	
	/**
	 * Metoda care sterge o anumita faza
	 * 
	 * @param faza	Faza care se doreste a fi stearsa
	 * @throws Exception
	 */
	public void stergeFaza(FazaProductie faza) throws Exception;
	
	/**
	 * Metoda care returneaza lista tuturor utilaje
	 * 
	 * @return	lista de utilaje
	 * @throws Exception
	 */
	public List<Utilaj> getUtilaje() throws Exception;
	
	/**
	 * Metoda care sterge un anumit utilaj
	 * 
	 * @param utilaj	Utilajul care se doreste a fi sters
	 * @throws Exception
	 */
	public void stergeUtilaj(Utilaj utilaj) throws Exception;


	public void setNomenclatoareSrv(NomenclatoareSrv nomenclatoareSrv);
}

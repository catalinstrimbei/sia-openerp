package org.open.erp.services.marketing;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.open.erp.services.nomgen.Produs;
/**
 * 
 * @author Echipa.Marketing
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: NomGenSrv
 * 
 * @EntitatiNomGen: Persoana
 * 
 * @EntitatiLocale: Campanie, Chestionar, Discount, Intrebare, PersoanaTinta, Promotie, RaspunsChestionar, Responsabil
 * 
 * @UseCase("Management campanie de publicitate"):
 * 1. Creaza instanta campanie
 * 2. Deruleaza campania nou creata
 * 
 *  
 * @UseCase("Management chestionare"):
 *  1. initiere chestionar
 *  2. derulare chestionar
 *  3. proceseaza rezultate
 *  
 *  @UseCase("Management Promotii"):
 *  1. Creeaza o promotie;
 *  2. Obtine pretul final dupa obtinerea unei promotii
 */
public interface MarketingManagementSrv {
//-----------------------------------------------DEFINIRE CAMPANIE START---------------------------------------------
	/**
	 * Returneaza o campanie.
	 * 
	 * @param nume 			Titulatura campaniei nou creata
	 * @param responsabil 	Numele persoanei responsabil general
	 * @param dataStart 	Data estimata start 
	 * @param dataSfarsit 	Data estimata sfarsit
	 * @param PersoaneTinta	Lista persoanelor tinta 
	 * 
	 * @return instanta Campanie nou creata. 
	 * 
	 */
	Campanie definireCampanie(String nume,  Date dataStart, Date dataSfarsit,Responsabil responsabil,List<PersoanaTinta> PersoaneTinta);
//-----------------------------------------------DEFINIRE CAMPANIE END-----------------------------------------------
//-----------------------------------------------INITIERE CAMPANIE START---------------------------------------------
	/**
	 * Scop					Schimba status unei campanii in started, trimite mail-urile informative persoanelor tinta.
	 * 
	 * @param Campanie		Campania ce va fi initiata
	 * 
	 * @return 
	 * 
	 */	
	void initiereCampanie(Campanie campanie);
//-----------------------------------------------INITIERE CAMPANIE END-----------------------------------------------
//-----------------------------------------------DERULARE CAMPANIE START---------------------------------------------
	/**
	 * Scop					Schimba status unei campanii in finalizata, prelucreaza rezultate daca este cazul
	 * 
	 * @param Campanie		Campania ce va fi derulata
	 * 
	 * @return 
	 * 
	 */	
	void finalizareCampanie(Campanie campanie);
//-----------------------------------------------DERULARE CAMPANIE END--------------------------------------------------
//-----------------------------------------------INITIERE CHESTIONAR START-----------------------------------------------
	/**
	 * Returneaza un chestionar nou.
	 * 
	 * @param denumire			Denumirea chestionarului
	 * @param responsabil 		Numele persoanei responsabile
	 * @param nrIntrebari		Numarul de intrebari continute de chestionar
	 * @param scop				Scopul pentru care se aplica chestionarul
	 * @param listaIntrebari	Lista intrebarilor continuta de chestionar
	 * 
	 * @return instanta Chestionar nou creata. 
	 * 
	 */
	Chestionar initiereChestionar(String denumire, Responsabil responsabil,Integer nrIntrebari,String scop, List<Intrebare> listaIntrebari);
//-----------------------------------------------INITIERE CHESTIONAR END--------------------------------------------------
//-----------------------------------------------DERULARE CHESTIONAR START------------------------------------------------
	/**
	 * Trimite e-mail clientilor cu chestionarul ce se doreste a fi derulat
	 * 
	 * @param chestionar		Denumirea chestionarului	 
	 * 
	 * 
	 */
	void derulareChestionar(Chestionar chestionar);
//-----------------------------------------------DERULARE CHESTIONAR END--------------------------------------------------
//-----------------------------------------------PROCESEAZA REZULTATE CHESTIONAR START------------------------------------
	/**
	 * Trimite e-mail clientilor cu chestionarul ce se doreste a fi derulat
	 * 
	 * @param chestionar		Denumirea chestionarului	 
	 * 
	 * 
	 */
	void proceseazaRezultate(Chestionar chestionar);
//-----------------------------------------------PROCESEAZA REZULTATE CHESTIONAR END--------------------------------------
//-----------------------------------------------DEFINIRE PROMOTIE START--------------------------------------------------
/**
 * Returneaza un chestionar nou.
 * 
 * @param denumire			Denumirea chestionarului
 * @param responsabil 		Numele persoanei responsabile
 * @param nrIntrebari		Numarul de intrebari continute de chestionar
 * @param scop				Scopul pentru care se aplica chestionarul
 * @param listaIntrebari	Lista intrebarilor continuta de chestionar
 * 
 * @return instanta Chestionar nou creata. 
 * 
 */
Promotie definirePromotie(String denumire,String mesajPromotional, Date dataInceput, Date dataSfarsit, Integer TipPromotie,
		Map<Produs,Discount>	listaProduse , Map<Produs,List<Produs>>	listProduseAditionale);

/**
 * Returneaza un pretul unui produs dupa aplicarea discounturilor specifice unei promotii.
 * 
 * @param produs		Produsul pentru care se doreste calcularea pretului final
 * @param promotie		Promotia in care se incadreaza produsul
 * 
 * @return pretul final dupa aplicarea discounturilor;
 */
float getPretFinalByPromotie(Produs produs,Promotie promotie, float pretInitial);


/**
 * Returneaza un pretul unui produs dupa aplicarea discounturilor specifice unei promotii.
 * 
 * @param produs		Produsul pentru care se doreste calcularea pretului final
 * @param promotie		Promotia in care se incadreaza produsul
 * 
 * @return pretul final dupa aplicarea discounturilor;
 */
float getPretFinalByProdus(Produs produs);
}
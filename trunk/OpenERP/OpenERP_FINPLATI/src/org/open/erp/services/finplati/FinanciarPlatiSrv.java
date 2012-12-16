package org.open.erp.services.finplati;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.open.erp.services.achizitii.AchizitiiSrv;

import org.open.erp.services.achizitii.Factura;


/**
 * @author paraschivgeanina
 * 
 * @ApplicationServiceFacade
 * 
 * 
 * @Dependente: BanciSrv, AchizitiiSrv
 * 
 * @EntitatiAlteSrv: Buget
 * 
 * @EntitatiLocale: Proiect, Activitate
 * 
 * @UseCase("1. Monitorizare datorii"):
 * 
 * @UseCase("2. Plati in avans"):
 * 
 * @UseCase("3. Efectuare plati pt furnizori"):
 *
 * @UseCase("4. Efectuare plati pt diverse datorii"):
 * 
 * @UseCase("5. Urmarire plati si datorii ramase"):
 *
 */

public interface FinanciarPlatiSrv {
	
	/**
	 * Returneaza o situatie financiara templetizata
	 * 
	 * @param cDate		Data curenta / Data pentru care se face verificarea
	 * 
	 * @return instanta SituatieFinanciara
	 * 
	 */
	Double getSumePlatite(Date cDate);
	
	


	/**
	 * Alocare buget pentru datorii
	 * 
	 * @param buget		Bugetul alocat
	 * 
	 */
	void setBugetDatorii(Double buget);
	
	
	/**
	 * Afisare solduri facturi
	 * 
	 * @return datorii Double ce reprezinta diferenta dintra val. totala a facturilor si val. achitata.
	 * 
	 */
	
// 	void setAchizitiiSrv(AchizitiiSrv achizitiisrv);
	Double getSolduriFactura();
	
	/**
	 * Se va creea un contract nou cu un furnizor dat ca paramatru
	 * 
	 * @param furnizor		Furnizorul nostru
	 * 
	 * @param total			Valoarea totala a contractului
	 * 
	 * @param avans			Daca nu s-a facut vreo plata in avans, poate fi null
	 * 
	 * @return Contract		Entitate tip contract ce contine toate datele contractului
	 * 
	 */
	Contract createContractFurnizor(FurnizorContract furnizor, Double total, Plata avans);

	/**
	 * Se va adauga unui contract existent o plata in avans
	 * 
	 * @param contract		Contractul nostru
	 * 
	 * @param plata			Plata in avans ce trebuie adaugata
	 * 
	 */
	void inregistrarePlataAvans(Contract contract, Plata plata);

	/**
	 * Se va afisa valoarea totala a discountului obtinut
	 * 
	 * @param contract		Contractul nostru
	 * 
	 * @return discount		Double ce reprezinta discountul acordat din valoare totala a contractului.
	 * 
	 */
	Double afisareDiscountAcordat(Contract contract);
	
	/**
	 * Se va adauga unui contract existent o plata in avanas
	 * 
	 * @param contract		Discountul pus pe contract
	 * 
	 */


	Double afisareSituatie(Contract contract);
	
	/**
	 * Se va adauga unui contract existent o plata in avanas
	 * 
	 * @param contract		Discountul pus pe contract
	 * 
	 * @return remaining    Ce a mai ramas de platit.
	 * 
	 */


	List<Persoana> afisareListaPersonal();
	/**
	 *
	 * @return Se va afisa o lista cu personalul
	 * 
	 */


	void stabilireResponsabilPlata();
	
	/**
	 *  Vom stabili persoana responsabila utilizand rezultatele obtinute in functie de aptitudini.
	 * 
	 */

	Map<TipPlata,List<Plata>> clasificarePlati();
	/**
	 * Clasificam tipul de plati ca: plata catre un furnizor, datorie si alte plati
	 *
	 *
	 *@return map   Map-ul va cuprinde cele 3 tipuri de liste(plati).
	 * 
	 */

	Plata procesarePlata(FurnizorContract furnizor, Double valoarePlata);

	/**
	 * 
	 *@param furnizor1
	 *
	 *@param valoarePlata
	 *
	 *Se va adauga o plata facuta de furnizor prin virament bancar, cer...
	 * 
	 */
	Boolean verificarePlata(FurnizorContract furnizor1, Plata plata);

	/**
	 * 
	 *@param furnizor
	 *@param plata
	 * 
	 * @return verificareplata
	 */
	
	void procesarePlata(Double valoarePlata);

	/**
	 * 
	 *@param valoarePlata
	 *
	 *Efectuare plata pt datorii
	 *Va adauga o plata pe categoria de plati datorie
	 * 
	 */
	
	ChitantaPlata primireChitanta(Double valoarePlata);
	/**
	 * Daca furnizorul a primit plata, ofera chitanta
	 * 
	 *@param valoareplata
	 * 
	 */

	Double afisareSituatiePlati();
	/**
	 * Ne afiseaza o situatie a platilor
	 * 
	 */


	Double afisareDatorii();
	/**
	 *  Se afiseaza datoriile ramase in urma achitarii unor plati pe contract, factura.
	 * 
	 */


	Double afisarePlatiTotale();
	/**
	 *  Calcularea tuturor platilor.
	 * 
	 */


	Double afisareSold();
	/**
	 *  Calculam soldul final prin scaderea datoriilor din buget.
	 * 
	 */


	double getBugetDatorii();


	SituatieFinanciara getSituatieFinanciara();


	void setSituatieFinanciara(SituatieFinanciara sitFit);


	Contract cautaContractFurnizor(Integer idContract);


	void setAchizitii(AchizitiiSrv achizitiiSrv);
	
	
}

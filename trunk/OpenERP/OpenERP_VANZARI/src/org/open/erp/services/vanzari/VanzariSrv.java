package org.open.erp.services.vanzari;


import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

//import org.open.erp.services.stocuri.StocuriSrv;


/**
 * @author echipa.vanzari
 * 
 * @ApplicationServiceFacade
 * 
 * 
 * @Dependente: NomencaltorMaterialeSrv, NomenclatoareSrv
 * 
 * @EntitatiNomGen: Parteneri
 * 
 * @EntitatiNomMat: Produse
 * 
 * @EntitatiLocale: OfertePret, Comenzi, Documente
 * 
 * @UseCase("1. Oferta de pret"):
 * 
 * @UseCase("2.Comenzi de la clienti"):
 * 
 * @UseCase("3.Dispozitie de livrare"):
 *
 * @UseCase("4. Avize"):
 * 
 * @UseCase("5. Facturi livrare"):
 * 
 */

@Remote

public interface VanzariSrv {
	
	/**
	 * Returneaza o vanzare
	 * 
	 * @param idVanzare         Id-ul vanzarii realizate.
	 * @param idClient			Id-ul clientului pentru care se realizeaza vanzarea.
	 * @param idOfertePret      Id-ul ofertei de pret.
	 * @param idComanda			Id-ul comenzii clientului.
	 * @param idAviz			Id-ul avizului asociat vanzarii.
	 * @param idFactura			Id-ul facturii asociate vanzarii.
	 * 
	 * @return instanta Factura nou creata		
	 **/

	
	/**
	 * 		Scop 						Asociaza o oferta de pret unui client.
	 * 
	 * @param idProdus					Id-ul produsului din nommat pentru care se realizeaza oferta.
	 *. 
	 * @param dataValabilitate			Data valabilitatii ofertei de pret
	 * @param observatii				Observatii cu privire la ofertele de pret
	 * @return	oferta nou creata.			
	 */
	
	OfertePret creareOfertePret(Integer idOfertaPret, Produse produs, Date dataValabilitate,Date dataeminiteri, String observatii);
	/**
	 * 		Scop						Creaza o comanda unui client
	 * 
	 * @param produs					Selectam produsul din nomenclatoare generale.	
	 * @param ofertePret				Selectam oferta de pret din OfertePret.
	 * @param data						Data cand a fost creata comanda.
	 * @param cantitateComandata		Cantitatea pe care o comanda clientul.
	 * @param cantitateAcceptata		Cantitatea care a fost acceptata de producator.
	 * @return	comanda nou creata.
	 */
	
	Comenzi creareComanda(Integer idComanda, Date data, List<ArticolComanda> articole);

/**
 * 		Scop							Crearea documentelor corespunzatoare comenzii.
 * 
 * @param responsabil					Persoana responsabila cu livrarea produselor.
 * @param produs						Produsele de livrat catre client.
 * @param comanda						Sunt selectate cantiatea acceptata.
 * @return		factura nou creata.		
 */
	
	
	Facturi creareFactura(Integer idFactura,Date data,Persoana responsabil,Avize aviz, Comenzi comanda, List<LiniiFactura> liniiFactura);
	
	
	
	
	/**
	 * 		Scop						Crearea unui aviz nou corespunzator unei comenzi.
	 * @param responsabil				Persoana responsabila sa faca livarea comenzii.
	 * @param comanda					Comanda pentru care se intocmeste un aviz.
	 * @param liniiAviz					Liniile unui aviz, sunt trecute toate produsele ce urmeaza a fi livrate.
	 * @return		aviz nou creat.
	 */
		
	
	Avize creareAviz(Integer idAviz,Date date,Persoana responsabil, Comenzi comanda, List<LiniiAviz>liniiAviz);
	/**
	 *  Scop							Crearea unei dispozitii de livarer corespunzatoare unei comenzi.
	 * @param responsabil				Persoana responsabila sa faca livarea comenzii.
	 * @param comanda					Comanda pentru care se intocmeste un dispozitia de livrare.
	 * @param liniiDispozitieLivrare	Liniile unei dispozitii de livarer, sunt trecute toate produsele ce urmeaza a fi livrate.
	 * @return		dispozitie de livare nou creata.
	 */
	
	
	
DispozitiiLivrare creareDispozitieLivrare(Integer idDispozitieLivrare,Date data,Persoana responsabil, Comenzi comanda, List<LiniiDispozitieLivrare>liniiDispozitieLivrare);

/**
 * 
 * @param stocuriSrv
 */
//void  setStocuri(StocuriSrv stocuriSrv);
/**
 * 
 * @param id						Id-ul facturii pentru care se calculeaza valoarea facturii
 * @return
 */
double getValoareFact(Integer id);

OfertePret salvareOferta(OfertePret oferta) throws Exception;

/* Data Operations */
OfertePret getOfertaDePret(Integer idOfertaPret);
List<OfertePret> getOferte();




//void iesireStoc(Material material, Double cantitate
		// ) throws Exception;

}	 


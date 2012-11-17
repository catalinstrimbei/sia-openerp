package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.nomgen.Clienti;
import org.open.erp.services.nommat.Produse;


/**
 * @author mihalescu.ionela
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
	 * @param idClient					Id-ul clientului din nomgen pentru care se realizeaza oferta. 
	 * @param dataValabilitate			Data valabilitatii ofertei de pret
	 * @param observatii				Observatii cu privire la ofertele de pret
	 * @return	oferta nou creata.			
	 */
	OfertePret creareOfertePret(Produse produs, Clienti client, Date dataValabilitate, String observatii);
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
	Comenzi creareComanda( Produse produs, OfertePret ofertePret, Date data, Double cantitateComandata, Double cantitateAcceptata);

/**
 * 		Scop							Crearea documentelor corespunzatoare comenzii.
 * 
 * @param responsabil					Persoana responsabila cu livrarea produselor.
 * @param produs						Produsele de livrat catre client.
 * @param comanda						Sunt selectate cantiatea acceptata.
 * @return		document nou creat.		
 */
	
	Documente creareDocument(Responsabil responsabil, Produse produs, Comenzi comanda);
	

}

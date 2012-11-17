package org.open.erp.services.vanzari;

import java.util.Date;


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


	

}

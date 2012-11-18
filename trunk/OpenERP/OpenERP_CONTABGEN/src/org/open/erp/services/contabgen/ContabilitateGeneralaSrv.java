package org.open.erp.services.contabgen;

import org.open.erp.services.conturi.PlanConturi;

/**
 * @author ContaGen
 * 
 * @ApplicationServiceFacade
 * 
 * 
 * @Dependente: Achizitii
 * 
 * @EntitatiAchizitii: Factura, NIR, Comanda
 * 
 * @EntitatiAlteSrv: 
 * 
 * @EntitatiLocale: Cont, Clasa, Operatiune, Sablon
 * 
 * @UseCase("1. Configurarea planului de conturi"):
 * 
 * @UseCase("2. Inregistrare tranzactie"):
 * 
 * @UseCase("3. Creare sablon contabil"):
 *
 * @UseCase("4. Generarea unui raport contabil"):
 * 
 */

public interface ContabilitateGeneralaSrv {
	
	/**
	 * Returneaza planul de conturi
	 * 
	 * @return instanta Proiect nou creata. 
	 * 
	 */
	PlanConturi crearePlanConturi();

}

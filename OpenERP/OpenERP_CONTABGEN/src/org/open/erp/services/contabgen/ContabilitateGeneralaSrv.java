package org.open.erp.services.contabgen;

import java.util.ArrayList;
import java.util.List;

import org.open.erp.exceptii.ExceptieTipContInvalid;
import org.open.erp.services.conturi.Clasa;
import org.open.erp.services.conturi.Cont;
import org.open.erp.services.conturi.Cont.Tip;
import org.open.erp.services.conturi.PlanConturi;
import org.open.erp.services.rapoarte.BilantContabil;
import org.open.erp.services.sabloane.Sablon;
import org.open.erp.services.tranzactii.OperatiuneContabila;
import org.open.erp.services.tranzactii.Tranzactie;

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
	 * Returneaza TRUE/FALSE
	 * 
	 * @param Cont 		Detaliile contului
	 * @param codClasa	Clasa din care va face parte contul
	 * 
	 * @return boolean
	 * 
	 */
	boolean adaugaCont(Cont cont, Integer codClasa);
	
	/**
	 * Returneaza o tranzactie
	 * 
	 * @return instanta Tranzactie nou creata. 
	 * 
	 */
	Tranzactie creareTranzactie();
	
	/**
	 * Returneaza un sablon
	 * 
	 * @return instanta Sablon nou creat 
	 * 
	 */
	Sablon creareSablon(String denumire, OperatiuneContabila opCont);
	
	
	/**
	 * Returneaza bilantul contabil
	 * 
	 * @return instanta bilant contabil 
	 * 
	 */
	BilantContabil creareBilantContabil(ArrayList<Cont> conturi);
	
	Cont creazaCont(Tip tip) throws ExceptieTipContInvalid;

}

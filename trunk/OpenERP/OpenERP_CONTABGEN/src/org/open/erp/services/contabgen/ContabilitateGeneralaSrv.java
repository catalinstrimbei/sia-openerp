package org.open.erp.services.contabgen;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import org.open.erp.exceptii.ExceptieTipContInvalid;
import org.open.erp.services.contabgen.conturi.Clasa;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.conturi.Cont.Tip;
import org.open.erp.services.contabgen.conturi.PlanConturi;
import org.open.erp.services.contabgen.impl.ContabilitateGeneralaRegistru;
import org.open.erp.services.contabgen.rapoarte.BilantContabil;
import org.open.erp.services.contabgen.sabloane.Sablon;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiune;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiuneContabila;
import org.open.erp.services.contabgen.tranzactii.OperatiuneContabila;
import org.open.erp.services.contabgen.tranzactii.Tranzactie;

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
@Remote
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
	Cont adaugaCont(Cont cont, Integer codClasa);
	
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
	BilantContabil creareBilantContabil();
	
	Cont creazaCont(Tip tip,int codCont, String denumire, String descriere,
			double sold, boolean tranzactionabil) throws ExceptieTipContInvalid;

	Cont creazaCont(int codCont, String denumireCont, String descriere,
			double sold, Tip tip, List<InregistrareOperatiune> intrari,
			boolean tranzactionabil) throws ExceptieTipContInvalid;
	
	PlanConturi creazaPlanConturi();

	PlanConturi salveazaPlanConturi(PlanConturi plan);
	
	InregistrareOperatiuneContabila salveazaOperatiuneContabila(InregistrareOperatiuneContabila operatiune);

	Cont salveazaCont(Cont cont);

	Clasa salveazaClasa(Clasa cls);

	List<Cont> getConturiDinClaseleDeConturi();


}

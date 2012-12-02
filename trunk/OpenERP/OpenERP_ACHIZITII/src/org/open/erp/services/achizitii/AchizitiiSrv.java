package org.open.erp.services.achizitii;


import java.util.Date;
import org.open.erp.services.nommat.Materiale;
import org.open.erp.services.nommat.NomenclatorGeneralSrv;

import org.open.erp.services.stocuri.StocuriSrv;


/**
 * @author catalin.strimbei
 * 
 * @ApplicationServiceFacade
 * 
 * 
 * @Dependente: StocuriSrv, NomGenSrv, NomenclatoareSrv
 * 
 * @EntitatiNomGenSrv: Material
 * 
 * @EntitatiStocuriSrv: Gestiune, Lot sau Stoc
 * 
 *  @EntitatiNomenclatoareSrv: PersoanaJuridica
 * 
 * @EntitatiLocale: CerereAprov, CerereOferta,Comanda,Factura, Furnizori, LiniiCerereAprov, LiniiCerereOferta, LiniiFactura, LiniiNIR
 * 
 *  @EntitatiLocale: LiniiOferta, LiniiPlanAprov, NIR, Oferta, PlanAprov;
 * 
 * @UseCase("1.Gestiune plan de aprovizionare"):
 * 
 * @UseCase("2.Gestiune cereri de oferta")
 * 
 * @UseCase("3.Gestiune oferte de la furnizori"):
 *
 * @UseCase("4.Gestiune Comenzii"):
 * 
 * @UseCase("4.Receptie materiale"):
 * 
 * 
 */

public interface AchizitiiSrv {
	
	CerereAprov creareCerereAprov(Integer nr, Date data);//s, Materiale material);
	/**
	 * Scop					Creeaza Cerere de Aprovizionare care va fi inclusa intr-un plan de aprovizionare
	 * 
	 * @param nr		
	 * @param data
	 *
	 * @return CerereAprov nou creata
	 * 
	 */	
	LiniiCerereAprov creareLinieCerereAprov(CerereAprov cerere, Integer nrLinie, Materiale material, Double cantitate);
	
	/**
	 * Scop		Adauga linii in cerera de aprovizionare
	 * 
	 * @param Cerere   Cererea de  aprovizionare careia se asociaza  liniile		
	 * @param nrLinie
	 * @param material  Materialul de pe linia respectiva
	 * @param cantitate 
	 * 
	 * @return Linia din cererea Aprovizionare Nou creata
	 * 
	 */	
	
	
	PlanAprov crearePlanAprov(Integer nrPlan, Integer an, Integer luna, Integer saptamana);
	
	/**
	 * Scop					Crearea unui plan de aprovizionare
	 * @param nr		
	 * @param Luna
	 * @param An  
	 * @param Saptamana
	 * 
	 * @return Plan  de Aprov nou creat
	 * 
	 */	
	
	
	LiniiPlanAprov creareLiniePlan(Integer nrLiniePlanAprov, PlanAprov planAprov, Materiale material, Double cantitate);
	
	/**
	 * Scop					Asociere de  linii in planul de aprovizionare
	 * @param nrLiniePlanAprov	
	 * @param planAprov  Planul pentru care adaugam o linie
	 * @param material  
	 * @param cantitate
	 * 
	 * @return LiniePlan nou creata
	 * 
	 */	
	
	CerereOferta creareCerereOferta(Integer nrCerereOferta, Date dataCerereOferta);
	
	/**
	 * Scop					Crearea unei oferte
	 * @param nrCerereOferta	
	 * @param dataCerereOferta  
	 * 
	 * @return LiniePlan nou creata
	 * 
	 */	
	  
	public void stabilireFurnizor(CerereOferta cerereOferta, Furnizori furnizor);
	/**
	 * Scop					Adaugarea de furnizori pentru CerereaDeOferta
	 * @param cerereOferta	
	 * @param furnizor  
	 * 
	 */	
	
	
	
	LiniiCerereOferta creareLinie(Integer nrLinie, Double cantitate, Materiale material, CerereOferta cerereOferta);
	/**
	 * Scop					Asociere de  linii  pentru o CerereDeOferta
	 * @param nrLinie	
	 * @param cantitate  
	 * @param material  
	 * @param cerereOferta
	 * 
	 * @return LinieCerereOferta nou creata
	 * 
	 */	

	Oferta creareOferta(Integer nrOferta, Date dataOferta, Date dataLivrare, Double valoareTotala, Furnizori furnizor, CerereOferta cerereOferta);
	
	/**
	 * Scop				Gestionarea tuturor ofertelor care au fost primite pentru o cerere de Oferta
	 * @param nrOferta	
	 * @param dataOferta  
	 * @param dataLivrare  
	 * @param valoareTotala
	 * @param dataOferta  
	 * @param dataLivrare  
	 * @param valoareTotala
	 * @param furnizor  
	 * @param cerereOferta  Cererea  de oferta pentru care  este oferta nou creata
	 * 
	 * @returnOferta nou creata
	 * 
	 */	
	
	
    LiniiOferta creareLinieOferta(Integer nrLinie, Double pret, Materiale material, Double cantitate, Oferta oferta);
     
    /**
	 * Scop				Asocierea de linii pentru o  oferta
	 * @param nrLinie	
	 * @param material  
	 * @param pret  
	 * @param cantitate
	 * @param oferta   Oferta pentru care se asociaza noua Linie creata
	 * 
	 * @return LinieOferta nou  creata
	 * 
	 */	
    

     Oferta  comparare(Oferta oferta1, Oferta oferta2 );
     
     /**
 	 * Scop				Stabilirea celei mai potrivite oferte in functie de  pretul oferit
 	 * @param oferta1	
 	 * @param oferta2  
 	 * 
 	 * @return Oferta cea mai avantajoasa 
 	 * 
 	 */	
     
    
    Comanda creareComanda(Integer nrComanda, Date dataComanda, Furnizori furnizor, Oferta oferta, Double valoareTotalaComanda);
	
    
	/**
	 * Scop				Gestionarea tuturor ofertelor care au fost primite pentru o cerere de Oferta
	 * @param nrOferta	
	 * @param dataOferta  
	 * @param dataLivrare  
	 * @param valoareTotala
	 * @param dataOferta  
	 * @param dataLivrare  
	 * @param valoareTotala
	 * @param furnizor  
	 * @param cerereOferta  Cererea  de oferta pentru care  este oferta nou creata
	 * 
	 * @returnOferta nou creata
	 * 
	 */	
    
    LiniiComanda creareLinieComanda(Integer nrLinie, Double pret, Materiale material,
    						Double cantitate, Comanda comanda, LiniiOferta linieO);
    /**
 	 * Scop				Asocierea de linii pentru o  comanda
 	 * @param nrLinie	
 	 * @param material  
 	 * @param pret  
 	 * @param cantitate
 	 * @param comanda   Comanda pentru care se asociaza noua Linie creata
 	 * @param linieO  Linia din oferta pentru care se creaza o comanda
 	 * @return LinieComanda nou  creata
 	 * 
 	 */	
     
    
    
    
    public Materiale stabilireMaterial(LiniiPlanAprov liniePlan);
	
	
	 
	public   void  addOferta(Oferta oferta1);



	public void trimitereCerereOferta(CerereOferta cerereOferta, Furnizori furnizor);

	

	
	
	
	
	public void setMaterialSrv(NomenclatorGeneralSrv matSrv);
	
	
	
	public Comanda salveazaComanda(Comanda comanda);
	public void trimitereComanda(Comanda comanda, Furnizori furnizor);

	
	//FActura
	public Furnizori creareFurnizor(String denumire);
	public Factura creareFactura(Integer nrFactura, Date dataFactura, Date dataScadenta, Double valoareTotala, String denumireFurnizor);
	public LiniiFactura creareLinieFactura(Integer nrLinieLF, Double pret, Materiale material, Double cantitate, Factura factura, LiniiComanda linieComanda);
	public void  comparareFacturaComanda(Factura factura, Comanda comanda);
	
	
	public NIR creareNIR(Integer nrNIR, Date data, Furnizori furnizor, Double valoareTotala);
	public LiniiNIR  creareLiniiNIR(NIR nir, Integer nrLInie, Materiale material, Double cantitate, Double pret, Double valoareLinie, Double tvaLinie);
	

}

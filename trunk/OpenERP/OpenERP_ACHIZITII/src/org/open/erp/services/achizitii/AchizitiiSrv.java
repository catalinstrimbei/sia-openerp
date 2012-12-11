package org.open.erp.services.achizitii;


import java.util.Date;

import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.stocuri.Articol;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.stocuri.Gestiune;

import org.open.erp.services.stocuri.StocuriSrv;


/**
 * @author Borosu, Martinas, Negrut,Sandu,Sutu
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
	
		
	CerereAprov creareCerereAprov(Integer nr, Date data, Material material);
	/**
	 * Scop					Creeaza Cerere de Aprovizionare care va fi inclusa intr-un plan de aprovizionare
	 * 
	 * @param nr		
	 * @param data
	 *
	 * @return CerereAprov nou creata
	 * 
	 */	
	LiniiCerereAprov creareLinieCerereAprov(CerereAprov cerere, Integer nrLinie, Material material, Double cantitate);
	
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
	
	CerereOferta creareCerereOferta(Integer nrCerereOferta, Date dataCerereOferta);
	
	/**
	 * Scop					Crearea unei oferte
	 * @param nrCerereOferta	
	 * @param dataCerereOferta  
	 * 
	 * @return LiniePlan nou creata
	 * 
	 */	
	
	LiniiCerereOferta creareLinie(Integer nrLinie, Double cantitate, Material material, CerereOferta cerereOferta);
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
	
	public Material stabilireMaterial(LiniiPlanAprov liniePlan);

    Oferta  comparare(Oferta oferta1, Oferta oferta2 );
    
    /**
	 * Scop				Stabilirea celei mai potrivite oferte in functie de  pretul oferit
	 * @param oferta1	
	 * @param oferta2  
	 * 
	 * @return Oferta cea mai avantajoasa 
	 * 
	 */	
    
    public   void  addOferta(Oferta oferta1);
	
	public void stabilireFurnizor(CerereOferta cerereOferta, Furnizori furnizor);

	public void trimitereCerereOferta(CerereOferta cerereOferta, Furnizori furnizor);

	public Oferta creareOferta(Integer nrOferta, Date dataOferta, Date dataLivrare, Double valoareTotala, Furnizori furnizor, CerereOferta cerereOferta);
	
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

    LiniiOferta creareLinieOferta(Integer nrLinie, Double pret, Material material, Double cantitate, Oferta oferta);
    
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

	public void setMaterialSrv(NomenclatorMaterialeSrv matSrv);

	LiniiPlanAprov creareLiniePlan(Integer nrLiniePlanAprov, PlanAprov planAprov, Material material, Double cantitate);
	
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
	
	public Comanda creareComanda(Integer nrComanda, Date dataComanda, Furnizori furnizor, Oferta oferta, Double valoareTotalaComanda);	
	
	LiniiComanda creareLinieComanda(Integer nrLinie, Double pret, Material material,
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
	
	public Comanda salveazaComanda(Comanda comanda);
    
  	public void trimitereComanda(Comanda comanda, Furnizori furnizor);
		
public Furnizori creareFurnizor(String denumire);
	
	public Factura creareFactura(Integer nrFactura, Date dataFactura, Date dataScadenta, Double valoareTotala,  String denumireFurnizor);  	
  	/**
	 * Scop				Creare factura	
	 * @param nrFactura	
	 * @param dataFactura
	 * @param dataScadenta
	 * @param valoareTotala
	 * @param Furnizor
	 * 
	 * @return LiniePlan nou creata
	 * 
	 */	
  	
  	LiniiFactura creareLinieFactura(Integer nrLinieLF, Double pret, Material material, Double cantitate, Factura factura, LiniiComanda linieComanda);
  	/**
	 * Scop					Adaugarea unei linii la factura
	 * @param nrCerereOferta	
	 * @param dataCerereOferta  
	 * 
	 * @return LiniePlan nou creata
	 * 
	 */	
  	
	public void  comparareFacturaComanda(Factura factura, Comanda comanda);

	/**
	 * Scop		Validarea facturii   daca aceasta este conform comenzii pentru a se inregistra intrarea in stoc
	 * @param factura	
	 * @param comanda  
	 * 
	 * 
	 */

	public NIR creareNIR(Integer nrNIR, Date data, Furnizori furnizor, Double valoareTotala);
	 
	 /**
	 * Scop				 Creare NIR
	 * @param nrNIR	
	 * @param data
	 * @param factura
	 * @param valoareTotala
	 *
	 * @return Factura nou creata
	 * 
	 */	
	  	
	 
	 LiniiNIR  creareLiniiNIR(NIR nir, Integer nrLInie,
			Material material, Double cantitate, Double pret, Double valoareLinie, Double tvaLinie, Gestiune gest);
	 
	 /**
	 * Scop				 Aociere Linie Notei de receptie
	 * @param nrNIR	
	 * @param data
	 * @param factura
	 * @param valoareTotala
	 *
	 * @return Linia  Nou creata
	 * 
	 */	
	     
	public void trimitereMaterialLaStoc2( Material material, Double cantitate, Double pret, Gestiune gestiune);
		
	public Double crestereStoc(Material material, Gestiune gestiune, NIR nir, LiniiNIR lNIR);
	
//	public void intrareStoc(LiniiNIR linie, Gestiune gestiune);
//	
//	public Articol getArticolByGestiune(Material material, Gestiune gestiune);
	//public void creareLot(LiniiNIR linie, Gestiune gestiune);




}

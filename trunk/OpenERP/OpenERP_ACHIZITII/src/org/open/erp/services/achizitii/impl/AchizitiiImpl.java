package org.open.erp.services.achizitii.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.stocuri.*;
import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.AchizitiiSrvLocal;
import org.open.erp.services.achizitii.CerereAprov;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.Furnizori;
import org.open.erp.services.achizitii.LiniiCerereAprov;
import org.open.erp.services.achizitii.LiniiCerereOferta;
import org.open.erp.services.achizitii.LiniiComanda;
import org.open.erp.services.achizitii.LiniiFactura;
import org.open.erp.services.achizitii.LiniiNIR;
import org.open.erp.services.achizitii.LiniiOferta;
import org.open.erp.services.achizitii.LiniiPlanAprov;
import org.open.erp.services.achizitii.NIR;
import org.open.erp.services.achizitii.Oferta;
import org.open.erp.services.achizitii.PlanAprov;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.stocuri.Articol;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.Loturi;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriImpl;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AchizitiiImpl implements AchizitiiSrv, AchizitiiSrvLocal {
		
	/* Dependente resurse proprii */
	private static Logger logger = Logger.getLogger(AchizitiiImpl.class.getName());
	private RegistruAchizitii registruAchizitii;
	
	/* Dependente resurse injectate */
	@PersistenceContext(unitName="OpenERP_ACHIZITII")
	private EntityManager em;
	
	@Resource
	private SessionContext sessionContext;
	
	@EJB(lookup="java:global/OpenERP_NOMMAT/NomenclatorMaterialeImpl!org.open.erp.services.nommat.NomenclatorMaterialeSrv")
	private NomenclatorMaterialeSrv materialeSrv;
	
	@EJB(lookup="java:global/OpenERP_STOCURI/StocuriImpl!org.open.erp.services.stocuri.StocuriSrv")
	private StocuriSrv stocuriSrv;
	
	public void setMaterialSrv(NomenclatorMaterialeSrv matSrv){
		this.materialeSrv = matSrv;
	}
	
	public void setStocuriSrv(StocuriSrv stocSrv){
		this.stocuriSrv = stocSrv;
	}

	/* Initializare */
	public AchizitiiImpl(){
		
	}
	
	@PostConstruct
	public void init() {
		if(this.registruAchizitii == null) 
			registruAchizitii = new RegistruAchizitii(em);
	}

		
	/* implementare actiuni serviciu ProjectManagementSrv */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public CerereAprov creareCerereAprov(Integer nr, Date data, Material material)
		{
		logger.debug("1.1 Initiere/Creare cerere de aprovizionare noua");
		CerereAprov cerereNoua = new CerereAprov(nr, data, material);
		cerereNoua.setMaterial(material);
		return cerereNoua;
		
		}
	
	@Override
	public LiniiCerereAprov creareLinieCerereAprov(CerereAprov cerere, Integer nrLinie, Material material, Double cantitate){
		logger.debug("1.2 Adaugare linie intr-o Cerere Aprovizionare");
		
		LiniiCerereAprov linieCerereAprov = new LiniiCerereAprov(cerere, 1, material, cantitate);	
		cerere.adaugaLinieCerereAprov(linieCerereAprov);
		linieCerereAprov.setCerereAprov(cerere);
		return linieCerereAprov;
		
	}
	
	@Override
	public PlanAprov crearePlanAprov(Integer nrPlan, Integer an, Integer luna, Integer saptamana)
	{
		logger.debug(" 1.3.1 Creare plan nou");
		PlanAprov planNou=new PlanAprov(nrPlan, an, luna, saptamana);
		return planNou;
	}
	
	@Override
	public LiniiPlanAprov creareLiniePlan(Integer nrLiniePlanAprov, PlanAprov planAprov,Material material, Double cantitate){
		logger.debug("1.3.2 Adaugare linie plan");
		LiniiPlanAprov liniePlan=new LiniiPlanAprov(nrLiniePlanAprov, planAprov, material, cantitate);
		planAprov.adaugaLinie(liniePlan);
		liniePlan.setPlanAProv(planAprov);
		return liniePlan;
	}
	
	@Override
	public CerereOferta creareCerereOferta(Integer nrCerereOferta, Date dataCerereOferta)
	{
		logger.debug("2.1.1 Creare cerere oferta noua");
		CerereOferta cerereNoua=new CerereOferta(nrCerereOferta, dataCerereOferta);
		return cerereNoua;
	}
	
	@Override
	public LiniiCerereOferta creareLinie(Integer nrLinie, Double cantitate, Material material, CerereOferta cerereOferta){
		logger.debug("2.1.2 Adaugare linie in cerere oferta");
		
		LiniiCerereOferta linieOferta=new LiniiCerereOferta(nrLinie, cantitate, material, cerereOferta);
		cerereOferta.adaugaLinie(linieOferta);
		linieOferta.setCerereOferta(cerereOferta);
		return linieOferta;
	}
	
	@Override
	public Material stabilireMaterial(LiniiPlanAprov liniePlan){
		logger.debug("2.1.3 Stabilire material linie ");
		Material material=liniePlan.getMaterial();
		return material;
	}
	
	@Override
	public void stabilireFurnizor(CerereOferta cerereOferta, Furnizori furnizor){
		logger.debug("2.2 Identificare furnizor");
		cerereOferta.setFurnizor(furnizor);
	}

	public void trimitereCerereOferta(CerereOferta cerereOferta, Furnizori furnizor){
		logger.debug("2.3 S-a trimis cererea de oferta");
	}
	
	//Oferta
	@Override
	public Oferta creareOferta(Integer nrOferta, Date dataOferta, Date dataLivrare,Double valoareTotala, Furnizori furnizor, CerereOferta cerereOferta){
		logger.debug("3.1.1 Primire oferte de la furnizori (Creare ferta noua)");
		Oferta ofertaNoua=new Oferta(nrOferta, dataOferta, dataLivrare,valoareTotala, furnizor, cerereOferta);
		return ofertaNoua;
	}
	
	//LinieOferta
	@Override
	public LiniiOferta creareLinieOferta(Integer nrLinie, Double pret, Material material, Double cantitate, Oferta oferta){
		logger.debug("3.1.2 Adaugare linie in oferta primita");
		
		LiniiOferta linieOferta = new LiniiOferta(nrLinie, pret, material, cantitate, oferta);
		//oferta.adaugaLinie(linieOferta);
		linieOferta.setOferta(oferta); 
		return linieOferta;
	}
     
	//comparareOferta
	@Override
	public   void  addOferta(Oferta oferta1){
		  List<Oferta> oferte=  new ArrayList<Oferta>();
		    oferte.add(oferta1);
		 }
	
	@Override
	public Oferta  comparare(Oferta oferta1, Oferta oferta2 )
	  {
	   logger.debug("3.2 Comparare oferta " + oferta1.getNrOferta()+ " cu oferta "+ oferta2.getNrOferta());
	   
	  if (oferta1.getValoareTotala() > oferta2.getValoareTotala() )
	   return oferta1;
	 
	  else
	   return oferta2;
	  }
	
	@Override
	public Oferta salveazaOferta(Oferta oferta){
    	if (oferta.getNrOferta() == null)
    		throw new RuntimeException("Trebuie introdusa neaparat nrOferta ");	    	
    	logger.info("3.3 SALVARE oferta : " + oferta);
		return oferta;
    }
	
	//LinieComanda
	@Override
	public LiniiComanda creareLinieComanda(Integer nrLinie, Double pret, Material material, Double cantitate, Comanda comanda, LiniiOferta linieO){
		logger.debug("4.1 Adaugare linie in Comanda " );
		
		LiniiComanda linieComanda = new LiniiComanda(nrLinie, pret, linieO.getMaterial(), cantitate, comanda);
		//comanda.adaugaLinieComanda(linieComanda);
		linieComanda.setComanda(comanda);
		return linieComanda;
	}
	
	//Comanda
	@Override
	public Comanda creareComanda(Integer nrComanda, Date dataComanda, Furnizori furnizor, Oferta oferta, Double valoareTotalaComanda){
		logger.debug("4.2 Creare Comanda " + nrComanda);
		
		Comanda comanda = new Comanda(nrComanda, dataComanda, oferta.getFunrizor(), valoareTotalaComanda);
		return comanda;
	}
		
	@Override
	public Comanda salveazaComanda(Comanda comanda){
    	if (comanda.getNrComanda() == null)
    		throw new RuntimeException("Trebuie introdusa neaparat nrComanda ");	    	
    	logger.info("4.3 SALVARE comanda : " + comanda);
		return comanda;
    }
	
	@Override
	public void trimitereComanda(Comanda comanda, Furnizori furnizor){
		logger.debug("4.4 S-a trimis comanda la furnizorul " + furnizor);
	}
	
	//Furnizori
	@Override
	public Furnizori creareFurnizor(Furnizori furnizori){
		logger.debug("5.1.1 S-a introdus un nou Furnizor!!!");
		
		Furnizori furnizor = new Furnizori();
		return furnizor;		
	}
	
	@Override
	public Factura creareFactura(Integer nrFactura, Date dataFactura, Date dataScadenta, Double valoareTotala, String denumireFurnizor){
		logger.debug("5.1.2 S-a creat Factura!!!");
		
		Factura factura = new Factura(nrFactura, dataFactura, dataScadenta, valoareTotala);
		Furnizori furnizorFact = new Furnizori();
		factura.setFunrizor(furnizorFact);
		return factura;
	}
	
	/*public void addOferta(Oferta oferta1){
		  List<Oferta> oferte=  new ArrayList<Oferta>();
		    oferte.add(oferta1);
	  }*/
		
	@Override
	public void  comparareFacturaComanda(Factura factura, Comanda comanda){
	   logger.debug("5.2.2 Comparare factura numarul" + factura.getNrFactura() + " cu comanda numarul " + comanda.getNrComanda());
	   
	  if (factura.getValoareTotala() != comanda.getValoareTotala())
		  logger.debug("Factura nu corespunde cu comanda."); //creare facturaRetur
	  else		  
		  logger.debug("Validare receptie"); //crestereStoc	  	
	  }
	

	//crestere cantitate in Stoc in cazul receptiei Materiallor
	@Override
	public Double crestereStoc(Material material, Gestiune gestiune, NIR nir, LiniiNIR lNIR){
		Double cantitateStoc = 0.00;
		//for(LiniiNIR lNIR : nir.getLinieNir()){
			if(lNIR.getMaterial() == material){
				cantitateStoc += lNIR.getCantitate();
				logger.debug("Pentru materialul " + material.getDenumireMaterial() + " cantitatea a crescut cu " + cantitateStoc);
			}
			else
				logger.debug("Materialle primite nu corespund cu cele de pe NIR");
		//}
		return cantitateStoc;
	}
	
		
	//LiniiFactura
	@Override
	public LiniiFactura creareLinieFactura(Integer nrLinieLF, Double pret, Material material, Double cantitate, Factura factura, LiniiComanda linieComanda){
		logger.debug("5.2.1 S-a introdus linia " + nrLinieLF + " pentru factura numraul " + factura.getNrFactura());
		
		LiniiFactura lf = new LiniiFactura(nrLinieLF, pret, linieComanda.getMaterial(), cantitate, factura);
		lf.setFactura(factura);
		return lf;
	}
	
	//NIR
	@Override
	public NIR creareNIR(Integer nrNIR, Date data, Furnizori furnizor, Double valoareTotala){
	   logger.debug("5.2.1 Creare NIR " + nrNIR); 
	   NIR nir = new NIR (nrNIR, data, furnizor, valoareTotala);
	   
	   return nir;
	}
		
	//LiniiNIR
	@Override
	public LiniiNIR  creareLiniiNIR(NIR nir, Integer nrLInie, Material material, Double cantitate, Double pret, Double valoareLinie, Double tvaLinie, Gestiune gest){  
		logger.debug("5.3.2 Adaugare linie " + nrLInie + " in NIR " + nir.getNrNIR());
		LiniiNIR linieNIr = new LiniiNIR(nir, nrLInie, material, cantitate, pret, valoareLinie, tvaLinie);
		
		 if (stocuriSrv != null) {
			 stocuriSrv.intrareStoc(material, cantitate, pret, gest);
			 } 
		 else{
			        System.out.println("StocuriSrv este null");
			 }		
		logger.debug("Cantitatea materialului a crescut cu " + cantitate);
		//this.intrareStoc(material, gestiune);
		logger.debug("Materialul " + material.getDenumireMaterial() + " a intrat in stoc.");

		return linieNIr;
	}

	@Override
	public Furnizori creareFurnizor(String denumire) {
		// TODO Auto-generated method stub
		return null;
	}

//	public void trimitereMaterialLaStoc(Gestiune gest, NIR nir){
//		List<LiniiNIR> linii = new ArrayList<LiniiNIR>();
//		
//		Iterator<LiniiNIR> iterator = linii.listIterator();
//		while(iterator.hasNext()){
//			intrareStoc(iterator.next(), gest);
//			logger.debug("S-a trimis materialul  " + iterator.next().getMaterial().getDenumireMaterial() + "in stoc");
//
//		}
		
	@Override
	public void trimitereMaterialLaStoc2( Material material, Double cantitate, Double pret, Gestiune gestiune) {
			stocuriSrv.intrareStoc(material, cantitate, pret, gestiune);
			logger.debug("S-a trimis materialul  " + material.getDenumireMaterial() + "in stoc");	
	}
	
}	
	
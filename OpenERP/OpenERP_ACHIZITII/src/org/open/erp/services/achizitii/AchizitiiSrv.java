package org.open.erp.services.achizitii;


import java.util.Date;
import org.open.erp.services.nommat.Materiale;
import org.open.erp.services.nommat.NomenclatorGeneralSrv;

public interface AchizitiiSrv {
	
	CerereAprov creareCerereAprov(Integer nr, Date data, Materiale material);
	
	
	LiniiCerereAprov creareLinieCerereAprov(CerereAprov cerere, Integer nrLinie, Materiale material, Double cantitate);
	
	
	
	CerereOferta creareCerereOferta(Integer nrCerereOferta, Date dataCerereOferta);
	
	
	
	LiniiCerereOferta creareLinie(Integer nrLinie, Double cantitate, Materiale material, CerereOferta cerereOferta);
	
	
	
	public Materiale stabilireMaterial(LiniiPlanAprov liniePlan);
	
	 public Oferta  comparare(Oferta oferta1, Oferta oferta2 );
	 
	public   void  addOferta(Oferta oferta1);

	public void stabilireFurnizor(CerereOferta cerereOferta, Furnizori furnizor);

	public void trimitereCerereOferta(CerereOferta cerereOferta, Furnizori furnizor);

	public Oferta creareOferta(Integer nrOferta, Date dataOferta, Date dataLivrare, Double valoareTotala, Furnizori furnizor, CerereOferta cerereOferta);

	public LiniiOferta creareLinieOferta(Integer nrLinie, Double pret, Materiale material, Double cantitate, Oferta oferta);
	
	
	
	public void setMaterialSrv(NomenclatorGeneralSrv matSrv);
	
	
	
	public LiniiPlanAprov creareLiniePlan(Integer nrLiniePlanAprov, PlanAprov planAprov,Materiale material, Double cantitate);
	
	
	
	public PlanAprov crearePlanAprov(Integer nrPlan, Integer an, Integer luna, Integer saptamana);
	public Comanda creareComanda(Integer nrComanda, Date dataComanda, Furnizori furnizor, Oferta oferta, Double valoareTotalaComanda);	
	public LiniiComanda creareLinieComanda(Integer nrLinie, Double pret, Materiale material, Double cantitate, Comanda comanda, LiniiOferta linieO);
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

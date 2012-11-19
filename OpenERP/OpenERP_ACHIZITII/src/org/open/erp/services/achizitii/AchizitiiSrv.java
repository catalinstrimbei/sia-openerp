package org.open.erp.services.achizitii;


import java.util.Date;

import org.open.erp.services.nomgen.Furnizori;
import org.open.erp.services.nommat.Materiale;
import org.open.erp.services.nommat.NomenclatorGeneralSrv;

public interface AchizitiiSrv {
	
	CerereAprov creareCerereAprov(Integer nr, Date data, Materiale material);
	LiniiCerereAprov creareLinieCerereAprov(CerereAprov cerere, Integer nrLinie, Materiale material, Double cantitate);
	CerereOferta creareCerereOferta(Integer nrCerereOferta, Date dataCerereOferta);
	LiniiCerereOferta creareLinie(Integer nrLinie, Double cantitate, Materiale material, CerereOferta cerereOferta);
	public Materiale stabilireMaterial(LiniiPlanAprov liniePlan);
	public void stabilireFurnizor(CerereOferta cerereOferta, Furnizori furnizor);
	public void trimitereOferta(CerereOferta cerereOferta, Furnizori furnizor);
	public Oferta creareOferta(Integer nrOferta, Date dataOferta, Date dataLivrare, Furnizori furnizor, CerereOferta cerereOferta);
	public LiniiOferta creareLinieOferta(Integer nrLinie, Double pret, Materiale material, Double cantitate, Oferta oferta);
	public void setMaterialSrv(NomenclatorGeneralSrv matSrv);
	public LiniiPlanAprov creareLiniePlan(Integer nrLiniePlanAprov, PlanAprov planAprov,Materiale material, Double cantitate);
	public PlanAprov crearePlanAprov(Integer nrPlan, Integer an, Integer luna, Integer saptamana);
}
package org.open.erp.services.achizitii.impl;


import java.util.Date;
import java.util.List;

import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.CerereAprov;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.LiniiCerereAprov;
import org.open.erp.services.achizitii.LiniiCerereOferta;
import org.open.erp.services.achizitii.LiniiOferta;
import org.open.erp.services.achizitii.LiniiPlanAprov;
import org.open.erp.services.achizitii.Oferta;
import org.open.erp.services.achizitii.PlanAprov;
import org.open.erp.services.nomgen.Furnizori;
import org.open.erp.services.nommat.Materiale;
import org.open.erp.services.nommat.NomenclatorGeneralSrv;


public class AchizitiiImpl implements AchizitiiSrv {
	
	private NomenclatorGeneralSrv materialeSrv;
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AchizitiiImpl.class.getName());
	
	public void setMaterialSrv(NomenclatorGeneralSrv matSrv){
		this.materialeSrv=matSrv;
	}
	
	public CerereAprov creareCerereAprov(Integer nr, Date data, Materiale material) {
		logger.debug("1.1 Initiere/Creare cerere de aprovizionare noua");
		
		CerereAprov cerereNoua = new CerereAprov(nr, data, material);
		Materiale mat = materialeSrv.creareMateriale(material);
		cerereNoua.setMaterial(material);
		return cerereNoua;
		
	}
			
	public LiniiCerereAprov creareLinieCerereAprov(CerereAprov cerere, Integer nrLinie, Materiale material, Double cantitate){
		logger.debug("1.2 Adaugare linie intr-o Cerere Aprovizionare");
		
		LiniiCerereAprov linieCerereAprov = new LiniiCerereAprov(cerere, 1, material, cantitate);	
		cerere.adaugaLinieCerereAprov(linieCerereAprov);
		linieCerereAprov.setCerereAprov(cerere);
		return linieCerereAprov;
		
	}
	
	public CerereOferta creareCerereOferta(Integer nrCerereOferta, Date dataCerereOferta)
	{
		logger.debug("1.1 Creare cerere noua");
		CerereOferta cerereNoua=new CerereOferta(nrCerereOferta, dataCerereOferta);
		
		return cerereNoua;
	}
	
	public AchizitiiImpl(){
		
	}
	
	public LiniiCerereOferta creareLinie(Integer nrLinie, Double cantitate, Materiale material, CerereOferta cerereOferta){
		logger.debug("2.2 Adaugare linie in cerere");
		
		LiniiCerereOferta linieOferta=new LiniiCerereOferta(nrLinie, cantitate, material, cerereOferta);
		cerereOferta.adaugaLinie(linieOferta);
		linieOferta.setCerereOferta(cerereOferta);
		return linieOferta;
	}
	
	public Materiale stabilireMaterial(LiniiPlanAprov liniePlan){
		logger.debug("2.3 Stabilire material linie ");
		Materiale material=liniePlan.getMaterial();
		return material;
	}
	
	public void stabilireFurnizor(CerereOferta cerereOferta, Furnizori furnizor){
		logger.debug("Setare furnizor");
		cerereOferta.setFurnizor(furnizor);
	}

	public void trimitereOferta(CerereOferta cerereOferta, Furnizori furnizor){
		logger.debug("S-a trimis oferta");
	}
	
	public Oferta creareOferta(Integer nrOferta, Date dataOferta, Date dataLivrare, Furnizori furnizor, CerereOferta cerereOferta){
		logger.debug(" Creare oferta noua");
		Oferta ofertaNoua=new Oferta(nrOferta, dataOferta, dataLivrare, furnizor, cerereOferta);
		return ofertaNoua;
	}
	
	public LiniiOferta creareLinieOferta(Integer nrLinie, Double pret, Materiale material, Double cantitate, Oferta oferta){
		logger.debug("Adaugare linie in oferta");
		
		LiniiOferta linieOferta=new LiniiOferta(nrLinie, pret, material, cantitate, oferta);
		oferta.adaugaLinie(linieOferta);
		linieOferta.setOferta(oferta);
		return linieOferta;
	}
	
	
	public PlanAprov crearePlanAprov(Integer nrPlan, Integer an, Integer luna, Integer saptamana)
	{
		logger.debug("Creare plan nou");
		PlanAprov planNou=new PlanAprov(nrPlan, an, luna, saptamana);
		return planNou;
	}
	
	public LiniiPlanAprov creareLiniePlan(Integer nrLiniePlanAprov, PlanAprov planAprov,Materiale material, Double cantitate){
		logger.debug(" Adaugare linie plan");
		
		LiniiPlanAprov liniePlan=new LiniiPlanAprov(nrLiniePlanAprov, planAprov, material, cantitate);
		planAprov.adaugaLinie(liniePlan);
		liniePlan.setPlanAProv(planAprov);
		return liniePlan;
	}
	
	
}

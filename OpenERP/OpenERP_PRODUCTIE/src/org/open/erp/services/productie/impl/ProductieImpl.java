package org.open.erp.services.productie.impl;

import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.Produs;
import org.open.erp.services.productie.ComandaProductie;
import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FazaProductie;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.FunctieNecesara;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.Semifabricat;
import org.open.erp.services.productie.Utilaj;

public class ProductieImpl implements ProductieSrv {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProductieImpl.class.getName());
	
	private static ProductieSrv productie;
	
	
	
	
	@Override
	public FluxProductie definireFluxProductie(Integer idFlux, Produs produs)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FazaProductie definireFazaProductie(String faza, FluxProductie flux,
			Utilaj utilaj, Double timpFolosire,
			ArrayList<FunctieNecesara> functiiNecesare,
			ArrayList<Material> materialeReteta,
			Semifabricat semifabricatDorit, Produs produsDorit, Divizie sectie,
			Integer nrOrdine, Boolean isFinal) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produs lansareComandaProductie(ComandaProductie comanda,
			Produs produs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> consumResursa(FazaProductie faza, Produs produs)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> controlCalitate(Produs produs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer livrareProdus(Integer cantitateProdus, Produs produs)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> inregistrareGestiuneConsum(FazaProductie faza,
			Produs produs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Integer> inregistrareGestiuneProductie(Produs produs)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FluxProductie getFlux(Integer idFlux) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fabricare(Produs produs, Integer idFlux) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FazaProductie getFazaFlux(FluxProductie flux, Integer nrOrdine)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void comandaMateriale(FazaProductie faza, FluxProductie flux)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FluxProductie> getListaFluxuri() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stergeFlux(FluxProductie flux) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Semifabricat> getListaSemifabricate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stergeSemifabricat(Semifabricat semifabricat) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Semifabricat salveazaSemifabricat(Integer idSemifabricat,
			String semifabricat, ArrayList<Material> listaMateriale,
			Semifabricat semifabricatContinut) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CriteriuCalitate> getCriteriiCalitate() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stergeCriteriuCalitate(CriteriuCalitate criteriu)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CriteriuCalitate salveazaCriteriuCalitate(Integer idCriteriu,
			String criteriu) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FazaProductie getFazaProductie(String faza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FazaProductie> getListaFaze() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stergeFaza(FazaProductie faza) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utilaj> getUtilaje() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stergeUtilaj(Utilaj utilaj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	
}

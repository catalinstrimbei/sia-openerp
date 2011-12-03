package org.open.erp.services.stocuri.impl;


import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.BonConsum;
import org.open.erp.services.stocuri.CerereAprovizionare;
import org.open.erp.services.stocuri.ComandaProduse;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.LoturiIntrari;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.exceptions.IntrariStocExceptions;
import org.open.erp.services.stocuri.exceptions.StocuriExceptions;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */
public class StocuriImpl implements StocuriSrv {
	private Procesare procesare;
	private AplicarePret applicarepret;

	public StocuriImpl() {
		super();
	}

	public StocuriImpl(Procesare procesareComandaMateriale,
			AplicarePret applicarepret) {
		super();
		this.procesare = procesareComandaMateriale;
		this.applicarepret = applicarepret;
	}

	@Override
	public void intrareInStoc(Material mijlocCirculant,
			LoturiIntrari lot, Gestiune gestiune) {
		try {
			procesare.intrareInStoc(mijlocCirculant, lot, gestiune);
		} catch (IntrariStocExceptions e) {
			e.printStackTrace();
			e.logger.loggeazaERROR(e.getMessage(), e);
		}

	}

	@Override
	public void transfer(Gestiune gestOut, Gestiune gestIn,
			Material mijlocCirculant, Integer cantitate) {
		try {
			procesare.transfer(gestOut, gestIn, mijlocCirculant, cantitate);
		} catch (StocuriExceptions e) {
			e.printStackTrace();
			e.logger.loggeazaERROR(e.getMessage(), e);
		}

	}

	@Override
	public BonConsum consumProductie(CerereAprovizionare comMateriale) {
		return (BonConsum) procesare.preoceseazaComandaMateriale(comMateriale);

	}

	@Override
	public Integer getStocMaterialByGestiune(Material produs, Gestiune gestiune) {
		return procesare.getArticolByMijlocAndGestiune(produs, gestiune)
				.getCatitateStocPeGestiune();

	}

	@Override
	public Double getPretArticolAplicareMetodaCalcul(ArticolStoc articol) {
		try {
			return applicarepret.getPretProdLot(articol);
		} catch (StocuriExceptions e) {
			e.printStackTrace();
			e.logger.loggeazaERROR(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public Integer verificareStocMaterial(Material material) {
		try{
		return procesare.verificareStocMaterial(material).intValue();
		}catch (StocuriExceptions e) {
			e.printStackTrace();
			e.logger.loggeazaERROR(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public void iesireStoc(Document doc) {
		try{
			procesare.procesareComandaIesire(doc);
		}catch (StocuriExceptions e) {
			e.printStackTrace();
			e.logger.loggeazaERROR(e.getMessage(), e);
		}
		
	}

	@Override
	public Boolean intrareStoc(Document doc) {
		return procesare.intrareInStoc(doc);
			
	}

	@Override
	public Boolean iesireDinStoc(Material material, Integer cantitate) {
		try{
			return procesare.iesireDinStoc(material, cantitate);
			
		}catch (StocuriExceptions e) {
			e.printStackTrace();
			e.logger.loggeazaERROR(e.getMessage(), e);
			return false;
		}
	}

	
}

package org.open.erp.services.nommat.impl;

import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.UnitateDeMasura;


public class NomenclatorMaterialeImpl implements NomenclatorMaterialeSrv {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(NomenclatorMaterialeImpl.class.getName());

	@Override
	public  Material introducereMaterial(String codMaterial, String denumireMaterial, String cantitateStandard, String pretStandard,
			String categorieMaterial, String procentTVACurent, String observatii, ListaCaracteristici caracteristici) {
		logger.debug("1. Introducere Material");
		Material material = new Material (codMaterial,denumireMaterial,cantitateStandard,pretStandard,categorieMaterial,procentTVACurent,observatii,caracteristici);
		return material;
	}
		
	@Override
	public UnitateDeMasura incarcareUnitate(String id, String unitateDeMasura) {
		logger.debug("2. Incarcare Unitate");
		UnitateDeMasura unitMas= new UnitateDeMasura(id,unitateDeMasura);
		return unitMas;
	}

	@Override
	public ListaCaracteristici incarcareLista(String id,
			String listaCaracteristici) {
		logger.debug("3. Incarcare ListaCaract");
		ListaCaracteristici listaCaract= new ListaCaracteristici(id,listaCaracteristici);
		return listaCaract;
	}
	
	
	@Override
	public Material cautareMaterialDupaDenumire(String denumire) {
	Material newMaterial = new Material();
	logger.debug("5. Cautare Material dupa denumire");
	newMaterial.setDenumireMaterial(denumire);
	return newMaterial;
	}
	
}

	
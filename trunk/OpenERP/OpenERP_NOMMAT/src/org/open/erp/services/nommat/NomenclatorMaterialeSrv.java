package org.open.erp.services.nommat;

import org.open.erp.services.nommat.Material;

public interface NomenclatorMaterialeSrv {
	 Material introducereMaterial(String codMaterial, String denumireMaterial, String cantitateStandard, String pretStandard,
			 	String categorieMaterial, String procentTVACurent, String observatii, ListaCaracteristici listaCaracteristici);
	 Material cautareMaterialDupaDenumire(String denumire);
	 UnitateDeMasura incarcareUnitate(String id, String unitateDeMasura);
	 ListaCaracteristici incarcareLista(String id, String listaCaracteristici);
	}
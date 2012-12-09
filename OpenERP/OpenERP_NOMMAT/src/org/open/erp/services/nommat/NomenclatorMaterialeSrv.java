package org.open.erp.services.nommat;

public interface NomenclatorMaterialeSrv {
	 Material introducereMaterial(String codMaterial, String denumireMaterial, String cantitateStandard, String pretStandard,
			 	String categorieMaterial, String procentTVACurent, String observatii, ListaCaracteristici listaCaracteristici);
	 UnitateDeMasura incarcareUnitate(String id, String unitateDeMasura);
	 ListaCaracteristici incarcareLista(String id, String listaCaracteristici);
	}
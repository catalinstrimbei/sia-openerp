package org.open.erp.services.nommat;

import org.open.erp.services.nommat.Material;

public interface NomenclatorMaterialeSrv {
	 Material introducereMaterial(String codMaterial, String denumireMaterial, String cantitateStandard, String pretStandard,
			 	String categorieMaterial, String procentTVACurent, String observatii, ListaCaracteristici listaCaracteristici);
	 Material cautareMaterialDupaDenumire(String denumire);
	 void modificareMaterial(String codMaterial,String newcodMaterial, String newdenumireMaterial, String newcantitateStandard, String newpretStandard,
				String newcategorieMaterial, String newprocentTVACurent, String newobservatii, ListaCaracteristici newcaracteristici, Boolean overwrite);
	 void stergereMaterial(String CodMaterial);
	 UnitateDeMasura incarcareUnitate(String id, String unitateDeMasura);
	 ListaCaracteristici incarcareLista(String id, String listaCaracteristici);
	}
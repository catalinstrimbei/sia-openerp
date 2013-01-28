package org.open.erp.services.nommat;

import javax.ejb.Remote;

import org.open.erp.services.nommat.Material;

@Remote
public interface NomenclatorMaterialeSrv {
	 Material introducereMaterial(String codMaterial, String denumireMaterial, String cantitateStandard, String pretStandard,
			 	String categorieMaterial, String procentTVACurent, String observatii, ListaCaracteristici listaCaracteristici);
	 Material cautareMaterialDupaDenumire(String denumire);
	 Material modificareMaterial(String codMaterial,String newcodMaterial, String newdenumireMaterial, String newcantitateStandard, String newpretStandard,
				String newcategorieMaterial, String newprocentTVACurent, String newobservatii, ListaCaracteristici newcaracteristici, Boolean overwrite);
	 String stergereMaterial(String codMaterial);
	 UnitateDeMasura incarcareUnitate(String id, String unitateDeMasura);
	 ListaCaracteristici incarcareLista(String id, String listaCaracteristici);
	 Material cautareMaterialDupaCod(String codMaterial);
	Material salvareMaterial(Material material) throws Exception;
	}
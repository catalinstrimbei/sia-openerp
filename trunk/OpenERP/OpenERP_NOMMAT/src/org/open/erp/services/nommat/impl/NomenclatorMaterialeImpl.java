package org.open.erp.services.nommat.impl;

import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.UnitateDeMasura;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NomenclatorMaterialeImpl implements NomenclatorMaterialeSrv {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(NomenclatorMaterialeImpl.class.getName());
	private List<Material> lista_materiale=new ArrayList<Material>();
	
	@Override
	public  Material introducereMaterial(String codMaterial, String denumireMaterial, String cantitateStandard, String pretStandard,
			String categorieMaterial, String procentTVACurent, String observatii, ListaCaracteristici caracteristici) {
		logger.debug("1. Introducere Material");
		Material material = new Material (codMaterial,denumireMaterial,cantitateStandard,pretStandard,categorieMaterial,procentTVACurent,observatii,caracteristici);
		lista_materiale.add(material);
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
		logger.debug("4. Cautare Material");
	
		Iterator<Material> cmat=lista_materiale.iterator();
		while (cmat.hasNext()){ 
			if(cmat.next().getDenumireMaterial()==denumire){
				/*System.out.println(cmat.next().getCodMaterial() + cmat.next().getCantitateStandard() + cmat.next().getDenumireMaterial() 
						+ cmat.next().getPretStandard() + cmat.next().getProcentTVACurent() + cmat.next().getCategorieMaterial());
				*/
			Material returnMaterial= new Material(cmat.next().getCodMaterial(),cmat.next().getCantitateStandard(),cmat.next().getDenumireMaterial(), cmat.next().getPretStandard(),cmat.next().getProcentTVACurent(),cmat.next().getCategorieMaterial());
			return returnMaterial;
			}
			}
	}
	

	@Override
	public void modificareMaterial(String codMaterial,
			String newcodMaterial, String newdenumireMaterial,
			String newcantitateStandard, String newpretStandard,
			String newcategorieMaterial, String newprocentTVACurent,
			String newobservatii, ListaCaracteristici newcaracteristici,
			Boolean overwrite) {
		logger.debug("5. Editare Material");
		Iterator<Material> mat=lista_materiale.iterator();
		while (mat.hasNext()) {
            if (mat.next().getCodMaterial()==codMaterial) {
            	if(overwrite==true){
            	
            	mat.next().setCodMaterial(newcodMaterial);
            	mat.next().setCantitateStandard(newcantitateStandard);
            	mat.next().setDenumireMaterial(newdenumireMaterial);
            	mat.next().setPretStandard(newpretStandard);
            	mat.next().setProcentTVACurent(newprocentTVACurent);
            	mat.next().setObservatii(newobservatii);
            	mat.next().setCategorieMaterial(newcategorieMaterial);
            	System.out.println("Material cod:" + newcodMaterial + "a fost modificat");
            	}
            	else{
            		mat.next().setCodMaterial(newcodMaterial);
            		newcantitateStandard=mat.next().getCantitateStandard()+newcantitateStandard;
                	mat.next().setCantitateStandard(newcantitateStandard);
            		newdenumireMaterial=mat.next().getDenumireMaterial()+newdenumireMaterial;
            		mat.next().setDenumireMaterial(newdenumireMaterial);
            		newpretStandard=mat.next().getPretStandard() + newpretStandard;
                	mat.next().setPretStandard(newpretStandard);
                	newprocentTVACurent=mat.next().getProcentTVACurent()+newprocentTVACurent;
                	mat.next().setProcentTVACurent(newprocentTVACurent);
                	newobservatii=mat.next().getObservatii()+newobservatii;
                	mat.next().setObservatii(newobservatii);
                	newcategorieMaterial= mat.next().getCategorieMaterial() + newcategorieMaterial;
                	mat.next().setCategorieMaterial(newcategorieMaterial);
                	System.out.println("Material cod:" + newcodMaterial + "a fost modificat");
            	}
            	
          
            }
        }
	
	}
	
	@Override
	public void stergereMaterial(String codMaterial){
		logger.debug("6. Stergere Material");
		Iterator<Material> m=lista_materiale.iterator();
		while (m.hasNext()) 
            if (m.next().getCodMaterial() == codMaterial) {      	
            	   	lista_materiale.remove(m.next());
            	
            	}	
	}



}	
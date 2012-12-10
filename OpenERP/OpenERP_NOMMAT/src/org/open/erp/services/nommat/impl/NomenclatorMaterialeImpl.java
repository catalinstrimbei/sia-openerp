package org.open.erp.services.nommat.impl;

import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.UnitateDeMasura;
import java.util.ArrayList;

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
		Iterator<Material> i=lista_materiale.iterator;
		while (i.hasNext()){
			if(i.getDenumireMaterial()=denumire){
				System.out.println(i.getcodMaterial() + i.getCantitateStandard() + i.getDenumireMaterial() 
						+ i.getPretStandard() + i.getProcentTVACurent() + i.getCategorieMaterial());
			}
		
	return newMaterial;
	}
	
	@Override
	public void modificareMaterial(String codMaterial,String newcodMaterial, String newdenumireMaterial, String newcantitateStandard, String newpretStandard,
			String newcategorieMaterial, String newprocentTVACurent, String newobservatii, ListaCaracteristici newcaracteristici, BOOL overwrite) {
		
		Iterator<Material> i=lista_materiale.iterator;
		while (i.hasNext()) {
            if (i.getcodMaterial()==codMaterial) {
            	if(overwrite==1){
            	
            	i.setCodMaterial(newcodMaterial);
            	i.setCantitateStandard(newcantitateStandard);
            	i.setDenumireMaterial(newdenumireMaterial);
            	i.setPretStandard(pretStandard);
            	i.setProcentTVACurent(newprocentTVACurent);
            	i.setObservatii(newobservatii);
            	i.setCategorieMaterial(newcategorieMaterial);
            	}
            	else{
            		i.setCodMaterial(newcodMaterial);
            		newcantitateStandard=i.getCantitateStandard()+newcantitateStandard;
                	i.setCantitateStandard(newcantitateStandard);
            		newdenumireMaterial=i.getDenumireMaterial()+newdenumireMaterial;
            		i.setDenumireMaterial(newdenumireMaterial);
            		newpretStandard=i.getPretStandard() + newpretStandard;
                	i.setPretStandard(newpretStandard);
                	newprocentTVACurent=i.getProcentTVACurent()+newprocentTVACurent;
                	i.setProcentTVACurent(newprocentTVACurent);
                	newobservatii=i.getObservatii()+newobservatii;
                	i.setObservatii(newobservatii);
                	newcategorieMaterial= i.getCategorieMaterial() + newcategorieMaterial;
                	i.setCategorieMaterial(newcategorieMaterial);
            	}
            	
          
            }
        }
	return newMaterial;
	}
		


	public void stergereMaterial(String stergedupaCodMaterial){
		
		Iterator<Material> i=lista_materiale.iterator;
		
		while (i.hasNext()) 
		
            if (i.getcodMaterial()==codMaterial) {
            	if (i.hasPrevious()){            	
            	i.previous().next()=i.next();
            	     		
            	}
            	else{
            		i.next().previous()=null;
               	}
            }
           	
       
	}

}	
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
		Iterator<Material> i=lista_materiale.iterator();
		while (i.hasNext()){
			if(i.next().getDenumireMaterial()=denumire){
				System.out.println(i.next().getcodMaterial() + i.next().getCantitateStandard() + i.next().getDenumireMaterial() 
						+ i.next().getPretStandard() + i.next().getProcentTVACurent() + i.next().getCategorieMaterial());
			}
		
	return newMaterial;
	}
	
	@Override
	public Material modificareMaterial(String codMaterial,String newcodMaterial, String newdenumireMaterial, String newcantitateStandard, String newpretStandard,
			String newcategorieMaterial, String newprocentTVACurent, String newobservatii, ListaCaracteristici newcaracteristici, BOOL overwrite) {
		
		Iterator<Material> i=lista_materiale.iterator();
		while (i.hasNext()) {
            if (i.next().getcodMaterial()==codMaterial) {
            	if(overwrite==1){
            	
            	i.next().setCodMaterial(newcodMaterial);
            	i.next().setCantitateStandard(newcantitateStandard);
            	i.next().setDenumireMaterial(newdenumireMaterial);
            	i.next().setPretStandard(pretStandard);
            	i.next().setProcentTVACurent(newprocentTVACurent);
            	i.next().setObservatii(newobservatii);
            	i.next().setCategorieMaterial(newcategorieMaterial);
            	}
            	else{
            		i.next().setCodMaterial(newcodMaterial);
            		newcantitateStandard=i.next().getCantitateStandard()+newcantitateStandard;
                	i.next().setCantitateStandard(newcantitateStandard);
            		newdenumireMaterial=i.next().getDenumireMaterial()+newdenumireMaterial;
            		i.next().setDenumireMaterial(newdenumireMaterial);
            		newpretStandard=i.next().getPretStandard() + newpretStandard;
                	i.next().setPretStandard(newpretStandard);
                	newprocentTVACurent=i.next().getProcentTVACurent()+newprocentTVACurent;
                	i.next().setProcentTVACurent(newprocentTVACurent);
                	newobservatii=i.next().getObservatii()+newobservatii;
                	i.next().setObservatii(newobservatii);
                	newcategorieMaterial= i.next().getCategorieMaterial() + newcategorieMaterial;
                	i.next().setCategorieMaterial(newcategorieMaterial);
            	}
            	
          
            }
        }
	return newMaterial;
	}
		


	public void stergereMaterial(String codMaterial){
		Iterator<Material> i=lista_materiale.iterator;
		while (i.hasNext()) 
            if (i.next().getCodMaterial()==codMaterial) {
            	      	
            	i.next().previous().next()=i.next().next();
            	}
            	
            }
           	
       
	}

}	
package org.open.erp.services.nommat.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.open.erp.services.nommat.Material;

public class RegistruMateriale {
	private static Logger logger = Logger.getLogger(RegistruMateriale.class.getName());

	private EntityManager entityManager;
	public RegistruMateriale(EntityManager em) {
		entityManager = em;
	}

	public Material getMaterial(String codMaterial){
		return entityManager.find(Material.class, codMaterial);
	}

	public List<Material> getToateMateriale(){
		return entityManager.createQuery("SELECT m FROM material m").getResultList();
	}

	
	public Material salveazaMaterial(Material material) throws Exception{
		try{
			
			if (material.getCodMaterial() == null || 
				entityManager.find(material.getClass(), material.getCodMaterial()) == null)
				entityManager.persist(material);
			else
				entityManager.merge(material);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return material;
	}

	public void stergeMaterial(Material material){
		entityManager.remove(material);
	}


	public void refreshMaterial(Material material){
		entityManager.refresh(material);
	}
	}







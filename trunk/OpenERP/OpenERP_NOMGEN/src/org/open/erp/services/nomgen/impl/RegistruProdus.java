package org.open.erp.services.nomgen.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import javax.persistence.EntityManager;

import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.MateriePrima;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.Produs;


public class RegistruProdus {
	List<Produs> produse = new ArrayList<Produs>();
	 private EntityManager entityManager;
	 private String sqlProdusDefaultText = "SELECT o FROM Produs o";
	 private String sqlMFDefaultText = "SELECT o FROM MijlocFix o";
	 private String sqlMaterialDefaultText = "SELECT o FROM Material o";
	 private String sqlMPDefaultText = "SELECT o FROM MateriePrima o";
	 
	 public RegistruProdus(EntityManager entityManager) {
         this.entityManager = entityManager;
     }

	 
	 
	
	public List<Produs> getProduse() {
		return produse;
	}

	public void setProduse(List<Produs> produse) {
		this.produse = produse;
	}

	public void generateRandomProduse(Integer nrProduse) {
		Random randomPret = new Random();
		Integer pret;
		for (int i = 1; i <= nrProduse; i++) {
			pret = 50 + randomPret.nextInt(1450);
			produse.add(new Produs(i, "Produs_" + i, null, null, i, i, i, null, pret.doubleValue()));
		}
	}

	public RegistruProdus() {
		generateRandomProduse(20);
		
	}

	public RegistruProdus(Integer nrProduse) {
		generateRandomProduse(nrProduse);
		
	}
	
	/* (iv) Probleme de ordonare: model de lucru si problema individuala */
	public Collection<Produs> getProduseOrdonateDupaId() {
		 @SuppressWarnings("unchecked")
		List<Produs> result = this.entityManager.createQuery(this.sqlProdusDefaultText).getResultList();
		TreeSet<Produs> produseOrdonate = new TreeSet<Produs>();
		// Produs implementeaza Comparable dupa idProdus
		produseOrdonate.addAll(result);
		return produseOrdonate;
	}
	
	 public Produs getProdusDupaCod(Integer id){
    	 Produs p = this.entityManager.find(Produs.class, id);
     	this.entityManager.refresh(p);
     	return p;
     }
	
	 
	 public Collection<MijlocFix> getMFOrdonatbyId() {
		 @SuppressWarnings("unchecked")
		List<MijlocFix> result = this.entityManager.createQuery(this.sqlMFDefaultText).getResultList();
		TreeSet<MijlocFix> mfOrdonate = new TreeSet<MijlocFix>();
		// Produs implementeaza Comparable dupa idmf
		mfOrdonate.addAll(result);
		return mfOrdonate;
	}
	
	 public MijlocFix getMFDupaCod(Integer id){
		 MijlocFix mf = this.entityManager.find(MijlocFix.class, id);
     	this.entityManager.refresh(mf);
     	return mf;
     }
	 
	 
	 public Collection<Material> getMaterialOrdonatbyId() {
		 @SuppressWarnings("unchecked")
		List<Material> result = this.entityManager.createQuery(this.sqlMaterialDefaultText).getResultList();
		TreeSet<Material> mOrdonate = new TreeSet<Material>();
		// Produs implementeaza Comparable dupa idm
		mOrdonate.addAll(result);
		return mOrdonate;
	}
	
	 public Material getMaterialDupaCod(Integer id){
		 Material m = this.entityManager.find(Material.class, id);
     	this.entityManager.refresh(m);
     	return m;
     }
	 
	 public Collection<MateriePrima> getMPOrdonatbyId() {
		 @SuppressWarnings("unchecked")
		List<MateriePrima> result = this.entityManager.createQuery(this.sqlMPDefaultText).getResultList();
		TreeSet<MateriePrima> mpOrdonate = new TreeSet<MateriePrima>();
		// Produs implementeaza Comparable dupa idmp
		mpOrdonate.addAll(result);
		return mpOrdonate;
	}
	
	 public MateriePrima getMPDupaCod(Integer id){
		 MateriePrima mp = this.entityManager.find(MateriePrima.class, id);
     	this.entityManager.refresh(mp);
     	return mp;
     }
	 
	//CRUD
	 
	 public void addProdus(Produs p){
	     	try{
	     		entityManager.getTransaction().begin();
	             if (this.entityManager.contains(p))
	                 this.entityManager.merge(p);
	             else
	                 this.entityManager.persist(p);
	             entityManager.getTransaction().commit();
	     	}catch(Exception ex){
	     		if (entityManager.getTransaction().isActive())
	     			entityManager.getTransaction().rollback();
	     		throw new RuntimeException(ex.getMessage());
	     	}        
	     }

	     public void removeProdus(Produs p){
	     	try{
	     		entityManager.getTransaction().begin();
	             if (this.entityManager.contains(p))
	                 this.entityManager.remove(p);
	             entityManager.getTransaction().commit();
	     	}catch(Exception ex){
	     		if (entityManager.getTransaction().isActive())
	     			entityManager.getTransaction().rollback();
	     		throw new RuntimeException(ex.getMessage());
	     	} 
	     }


	     public void refreshProdus(Produs p){
	     	this.entityManager.refresh(p);
	     }
	     
	
	     public void addMF(MijlocFix m){
		     	try{
		     		entityManager.getTransaction().begin();
		             if (this.entityManager.contains(m))
		                 this.entityManager.merge(m);
		             else
		                 this.entityManager.persist(m);
		             entityManager.getTransaction().commit();
		     	}catch(Exception ex){
		     		if (entityManager.getTransaction().isActive())
		     			entityManager.getTransaction().rollback();
		     		throw new RuntimeException(ex.getMessage());
		     	}        
		     }

		     public void removeMijlocFix(MijlocFix m){
		     	try{
		     		entityManager.getTransaction().begin();
		             if (this.entityManager.contains(m))
		                 this.entityManager.remove(m);
		             entityManager.getTransaction().commit();
		     	}catch(Exception ex){
		     		if (entityManager.getTransaction().isActive())
		     			entityManager.getTransaction().rollback();
		     		throw new RuntimeException(ex.getMessage());
		     	} 
		     }


		     public void refreshMF(MijlocFix m){
		     	this.entityManager.refresh(m);
		     }
	     
		     public void addMP(MateriePrima mp){
			     	try{
			     		entityManager.getTransaction().begin();
			             if (this.entityManager.contains(mp))
			                 this.entityManager.merge(mp);
			             else
			                 this.entityManager.persist(mp);
			             entityManager.getTransaction().commit();
			     	}catch(Exception ex){
			     		if (entityManager.getTransaction().isActive())
			     			entityManager.getTransaction().rollback();
			     		throw new RuntimeException(ex.getMessage());
			     	}        
			     }

			     public void removeMP(MateriePrima mp){
			     	try{
			     		entityManager.getTransaction().begin();
			             if (this.entityManager.contains(mp))
			                 this.entityManager.remove(mp);
			             entityManager.getTransaction().commit();
			     	}catch(Exception ex){
			     		if (entityManager.getTransaction().isActive())
			     			entityManager.getTransaction().rollback();
			     		throw new RuntimeException(ex.getMessage());
			     	} 
			     }


			     public void refreshMP(MateriePrima mp){
			     	this.entityManager.refresh(mp);
			     }

			     
			     public void addMaterial(Material m){
				     	try{
				     		entityManager.getTransaction().begin();
				             if (this.entityManager.contains(m))
				                 this.entityManager.merge(m);
				             else
				                 this.entityManager.persist(m);
				             entityManager.getTransaction().commit();
				     	}catch(Exception ex){
				     		if (entityManager.getTransaction().isActive())
				     			entityManager.getTransaction().rollback();
				     		throw new RuntimeException(ex.getMessage());
				     	}        
				     }

				     public void removeMaterial(Material m){
				     	try{
				     		entityManager.getTransaction().begin();
				             if (this.entityManager.contains(m))
				                 this.entityManager.remove(m);
				             entityManager.getTransaction().commit();
				     	}catch(Exception ex){
				     		if (entityManager.getTransaction().isActive())
				     			entityManager.getTransaction().rollback();
				     		throw new RuntimeException(ex.getMessage());
				     	} 
				     }


				     public void refreshMaterial(Material m){
				     	this.entityManager.refresh(m);
				     }
			     
			     
			     
			     
	/* (v) Probleme de interogare 1 (operatii de cautare simpla in colectii) */
	public Produs getProdus(Integer idProdus) throws Exception {
		Produs p = new Produs();
		p.setIdMaterial(idProdus);
		Integer pIndex = produse.indexOf(p);
		if (pIndex >= 0)
			return this.produse.get(pIndex);
		else
			throw new Exception("No data found: Produs inexistent!");
	}
	
	  public void synchronize(){
	        // sincronizare cu baza de date
	        entityManager.getTransaction().begin();
	        try {
	            entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            entityManager.getTransaction().rollback();
	        }
	    }

	public Produs  CautareProdusDupaDenumire(String denumire){
		
		return (Produs) this.entityManager
                .createQuery(sqlProdusDefaultText + " WHERE o.denumire = :denumire")
                .setParameter("denumire", denumire)
                .getSingleResult();
	}
	
    	
    
	
}

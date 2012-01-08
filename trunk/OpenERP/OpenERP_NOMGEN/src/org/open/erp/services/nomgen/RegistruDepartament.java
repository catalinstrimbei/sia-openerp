package org.open.erp.services.nomgen;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;

public class RegistruDepartament {
	private EntityManager entityManager;
    private String sqlDepartamentDefaultText = "SELECT o FROM Departament o";

    public RegistruDepartament(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /* Operatii de cautare conventionale */
    public Set<Departament> getDepartament() {
   	 @SuppressWarnings("unchecked")
        List<Departament> result = this.entityManager.createQuery(this.sqlDepartamentDefaultText).getResultList();

        TreeSet<Departament> depOrdonate = new TreeSet<Departament>();
        depOrdonate.addAll(result);

        return depOrdonate;
    }

    public Departament getDepDupaCod(Integer codDep){
    	Departament c = this.entityManager.find(Departament.class, codDep);
    	this.entityManager.refresh(c);
    	return c;
    }
    
    public void addDepartament(Departament document){
     	try{
     		entityManager.getTransaction().begin();
             if (this.entityManager.contains(document))
                 this.entityManager.merge(document);
             else
                 this.entityManager.persist(document);
             entityManager.getTransaction().commit();
     	}catch(Exception ex){
     		if (entityManager.getTransaction().isActive())
     			entityManager.getTransaction().rollback();
     		throw new RuntimeException(ex.getMessage());
     	}        
     }

     
    public void removeDepartament(Departament document){
     	try{
     		entityManager.getTransaction().begin();
             if (this.entityManager.contains(document))
                 this.entityManager.remove(document);
             entityManager.getTransaction().commit();
     	}catch(Exception ex){
     		if (entityManager.getTransaction().isActive())
     			entityManager.getTransaction().rollback();
     		throw new RuntimeException(ex.getMessage());
     	} 
     }

    public Departament getDepartamentDupaDenumire(String den){
        return (Departament) this.entityManager
                .createQuery(sqlDepartamentDefaultText + " WHERE o.denumire = :den")
                .setParameter("den", den)
                .getSingleResult();
    }

    public Long getCountDepartament() {
        return (Long) this.entityManager
        .createQuery("SELECT COUNT(c) FROM  c")
        .getSingleResult();
	}

    
}

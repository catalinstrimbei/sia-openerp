package org.open.erp.services.nomgen.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;


public class RegistruDocument {
     private EntityManager entityManager;
     private String sqlDocumentDefaultText = "SELECT o FROM Document o";
     private String sqlLiniiDoctDefaultText = "SELECT o FROM LinieDocument o";
   //  private String sqlClaseDocumenteDefaultText = "SELECT o FROM Document o";

     public RegistruDocument(EntityManager entityManager) {
         this.entityManager = entityManager;
     }

     
     
     
     /* Operatii de cautare conventionale */
     public Set<Document> getDocumente() {
    	 @SuppressWarnings("unchecked")
         List<Document> result = this.entityManager.createQuery(this.sqlDocumentDefaultText).getResultList();

         TreeSet<Document> documenteOrdonate = new TreeSet<Document>();
         documenteOrdonate.addAll(result);

         return documenteOrdonate;
     }

     public Document getDocumentDupaCod(String codDocument){
     	Document c = this.entityManager.find(Document.class, codDocument);
     	this.entityManager.refresh(c);
     	return c;
     }
     
     
     public Set<LinieDocument> getLinieDocument() {
    	 @SuppressWarnings("unchecked")

         List<LinieDocument> result = this.entityManager.createQuery(this.sqlLiniiDoctDefaultText).getResultList();

         TreeSet<LinieDocument> liniidocumenteOrdonate = new TreeSet<LinieDocument>();
         liniidocumenteOrdonate.addAll(result);

         return liniidocumenteOrdonate;
     }

     public LinieDocument getLinieDocumentDupaCodDoc(String codDocument){
     	LinieDocument ld = this.entityManager.find(LinieDocument.class, codDocument);
     	this.entityManager.refresh(ld);
     	return ld;
     }
     
     public LinieDocument getLinieDocumentDupaMaterial(Material m){
      	LinieDocument ld = this.entityManager.find(LinieDocument.class, m);
      	this.entityManager.refresh(ld);
      	return ld;
      }
     

     /* Operatii CRUD */
     public void addDocument(Document document){
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

     
     public void addLinieDocument(LinieDocument ld){
      	try{
      		entityManager.getTransaction().begin();
              if (this.entityManager.contains(ld))
                  this.entityManager.merge(ld);
              else
                  this.entityManager.persist(ld);
              entityManager.getTransaction().commit();
      	}catch(Exception ex){
      		if (entityManager.getTransaction().isActive())
      			entityManager.getTransaction().rollback();
      		throw new RuntimeException(ex.getMessage());
      	}        
      }

     
     
     
     
     public void removeDocument(Document document){
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

     
     public void removeLinieDocument(LinieDocument ld){
      	try{
      		entityManager.getTransaction().begin();
              if (this.entityManager.contains(ld))
                  this.entityManager.remove(ld);
              entityManager.getTransaction().commit();
      	}catch(Exception ex){
      		if (entityManager.getTransaction().isActive())
      			entityManager.getTransaction().rollback();
      		throw new RuntimeException(ex.getMessage());
      	} 
      }


     public void refreshDocument(Document document){
     	this.entityManager.refresh(document);
     }
     
     public void refreshLinieDocument(LinieDocument ld){
      	this.entityManager.refresh(ld);
      }
     
     /* Operatii de cautare specifice */
     
     
     public Document getDocumentDupaNrDocument(String nrDocument){
         return (Document) this.entityManager
                 .createQuery(sqlDocumentDefaultText + " WHERE o.nrDocument = :nrDocument")
                 .setParameter("nrDocument", nrDocument)
                 .getSingleResult();
     }

     public Long getCountDocumente() {
         return (Long) this.entityManager
         .createQuery("SELECT COUNT(c) FROM  c")
         .getSingleResult();
 	}

     
     

}

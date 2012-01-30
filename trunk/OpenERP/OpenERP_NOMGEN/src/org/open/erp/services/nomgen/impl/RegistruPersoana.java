package org.open.erp.services.nomgen.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;

import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;



public class RegistruPersoana {

	 private EntityManager entityManager;
     private String sqlPersoanaDefaultText = "SELECT o FROM Persoana o";
     private String sqlPartenerDefaultText = "SELECT o FROM Partener o";
     private String sqlPFDefaultText = "SELECT o FROM PersoanaFizica o";
     private String sqlPJDefaultText = "SELECT o FROM PesoanaJuridica o";

     public RegistruPersoana(EntityManager entityManager) {
         this.entityManager = entityManager;
     }

     /* Operatii de cautare conventionale */
     public Set<Persoana> getPersoana() {
      	 @SuppressWarnings("unchecked")
         List<Persoana> result = this.entityManager.createQuery(this.sqlPersoanaDefaultText).getResultList();

         TreeSet<Persoana> persoaneOrdonate = new TreeSet<Persoana>();
         persoaneOrdonate.addAll(result);

         return persoaneOrdonate;
     }

     public Persoana getPersoanaDupaCod(String codPersoana){
    	 Persoana c = this.entityManager.find(Persoana.class, codPersoana);
     	this.entityManager.refresh(c);
     	return c;
     }

     
     public Set<PersoanaFizica> getPF() {
      	 @SuppressWarnings("unchecked")
         List<PersoanaFizica> result = this.entityManager.createQuery(this.sqlPFDefaultText).getResultList();

         TreeSet<PersoanaFizica> pfOrdonate = new TreeSet<PersoanaFizica>();
         pfOrdonate.addAll(result);

         return pfOrdonate;
     }

     public PersoanaFizica getPF(String idPersoana){
    	 PersoanaFizica p = this.entityManager.find(PersoanaFizica.class, idPersoana);
     	this.entityManager.refresh(p);
     	return p;
     }

     
     
     public Set<Partener> getPartener() {
      	 @SuppressWarnings("unchecked")
         List<Partener> result = this.entityManager.createQuery(this.sqlPartenerDefaultText).getResultList();

         TreeSet<Partener> parteneriOrdonate = new TreeSet<Partener>();
         parteneriOrdonate.addAll(result);

         return parteneriOrdonate;
     }

     public Partener getPartenerDupaCodPersoana(Integer idPersoana){
    	 Partener p = this.entityManager.find(Partener.class, idPersoana);
     	this.entityManager.refresh(p);
     	return p;
     }

     
     public Set<PersoanaJuridica> getPJ() {
      	 @SuppressWarnings("unchecked")
         List<PersoanaJuridica> result = this.entityManager.createQuery(this.sqlPJDefaultText).getResultList();

         TreeSet<PersoanaJuridica> pjOrdonate = new TreeSet<PersoanaJuridica>();
         pjOrdonate.addAll(result);

         return pjOrdonate;
     }

     public PersoanaJuridica getPJ(String idPersoana){
    	 PersoanaJuridica pj = this.entityManager.find(PersoanaJuridica.class, idPersoana);
     	this.entityManager.refresh(pj);
     	return pj;
     }
     
   
     
     /* Operatii CRUD */
     public void addPersoana(Persoana persoana){
     	try{
     		entityManager.getTransaction().begin();
             if (this.entityManager.contains(persoana))
                 this.entityManager.merge(persoana);
             else
                 this.entityManager.persist(persoana);
             entityManager.getTransaction().commit();
     	}catch(Exception ex){
     		if (entityManager.getTransaction().isActive())
     			entityManager.getTransaction().rollback();
     		throw new RuntimeException(ex.getMessage());
     	}        
     }

     public void removePersoana(Persoana persoana){
     	try{
     		entityManager.getTransaction().begin();
             if (this.entityManager.contains(persoana))
                 this.entityManager.remove(persoana);
             entityManager.getTransaction().commit();
     	}catch(Exception ex){
     		if (entityManager.getTransaction().isActive())
     			entityManager.getTransaction().rollback();
     		throw new RuntimeException(ex.getMessage());
     	} 
     }


     public void refreshPersoana(Persoana persoana){
     	this.entityManager.refresh(persoana);
     }
     
     
     
     
     
     
     public void addPartener(Partener partener){
      	try{
      		entityManager.getTransaction().begin();
              if (this.entityManager.contains(partener))
                  this.entityManager.merge(partener);
              else
                  this.entityManager.persist(partener);
              entityManager.getTransaction().commit();
      	}catch(Exception ex){
      		if (entityManager.getTransaction().isActive())
      			entityManager.getTransaction().rollback();
      		throw new RuntimeException(ex.getMessage());
      	}        
      }

      public void removePartener(Partener partener){
      	try{
      		entityManager.getTransaction().begin();
              if (this.entityManager.contains(partener))
                  this.entityManager.remove(partener);
              entityManager.getTransaction().commit();
      	}catch(Exception ex){
      		if (entityManager.getTransaction().isActive())
      			entityManager.getTransaction().rollback();
      		throw new RuntimeException(ex.getMessage());
      	} 
      }


      public void refreshPartener(Partener partener){
      	this.entityManager.refresh(partener);
      }
     
      
      public void addPersoanaFizica(PersoanaFizica pf){
        	try{
        		entityManager.getTransaction().begin();
                if (this.entityManager.contains(pf))
                    this.entityManager.merge(pf);
                else
                    this.entityManager.persist(pf);
                entityManager.getTransaction().commit();
        	}catch(Exception ex){
        		if (entityManager.getTransaction().isActive())
        			entityManager.getTransaction().rollback();
        		throw new RuntimeException(ex.getMessage());
        	}        
        }

        public void removePersoanaFizica(PersoanaFizica pf){
        	try{
        		entityManager.getTransaction().begin();
                if (this.entityManager.contains(pf))
                    this.entityManager.remove(pf);
                entityManager.getTransaction().commit();
        	}catch(Exception ex){
        		if (entityManager.getTransaction().isActive())
        			entityManager.getTransaction().rollback();
        		throw new RuntimeException(ex.getMessage());
        	} 
        }


        public void refreshPersoanaFizica(PersoanaFizica pf){
        	this.entityManager.refresh(pf);
        }
      
        
        public void addPersoanaJuridica(PersoanaJuridica pj){
        	try{
        		entityManager.getTransaction().begin();
                if (this.entityManager.contains(pj))
                    this.entityManager.merge(pj);
                else
                    this.entityManager.persist(pj);
                entityManager.getTransaction().commit();
        	}catch(Exception ex){
        		if (entityManager.getTransaction().isActive())
        			entityManager.getTransaction().rollback();
        		throw new RuntimeException(ex.getMessage());
        	}        
        }

        public void removePersoanaJuridica(PersoanaJuridica pj){
        	try{
        		entityManager.getTransaction().begin();
                if (this.entityManager.contains(pj))
                    this.entityManager.remove(pj);
                entityManager.getTransaction().commit();
        	}catch(Exception ex){
        		if (entityManager.getTransaction().isActive())
        			entityManager.getTransaction().rollback();
        		throw new RuntimeException(ex.getMessage());
        	} 
        }


        public void refreshPersoanaJuridica(PersoanaJuridica pj){
        	this.entityManager.refresh(pj);
        }
      
     
     /* Operatii de cautare specifice */
        
     public Persoana getPersoanaDupaAdresa(String adresa){
         return (Persoana) this.entityManager
                 .createQuery(sqlPersoanaDefaultText + " WHERE o.adresa = :adresa")
                 .setParameter("adresa", adresa)
                 .getSingleResult();
     }

     public Long getCountPersoane() {
         return (Long) this.entityManager
         .createQuery("SELECT COUNT(c) FROM Persoana c")
         .getSingleResult();
 	}


    public PersoanaFizica cautarePersoanaFizicaDupaPrenume(String nume){
    	return (PersoanaFizica) this.entityManager
                .createQuery(sqlPFDefaultText + " WHERE o.nume = :nume")
                .setParameter("nume", nume)
                .getSingleResult();
    	
    }
	
    
    public PersoanaJuridica cautarePersoanaJuridicaDupaDenumire(String denumire){
    	return (PersoanaJuridica) this.entityManager
                .createQuery(sqlPJDefaultText + " WHERE o.denumire = :denumire")
                .setParameter("denumire", denumire)
                .getSingleResult();
    	
    }
    
	
}

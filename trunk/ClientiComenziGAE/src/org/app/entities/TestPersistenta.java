package org.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;


@ManagedBean
@ApplicationScoped
public class TestPersistenta implements Serializable{
	public void persist(ActionEvent evt){
			EntityManagerFactory emf = Persistence.
				createEntityManagerFactory("transactions-optional");
			EntityManager em = emf.createEntityManager();
			
			// Stergere comenzi
			List<Comanda> lstComenzi = em.
					createQuery("SELECT c FROM Comanda c").getResultList();
			if (!lstComenzi.isEmpty()){
				em.getTransaction().begin();
				for (Comanda c: lstComenzi)
					em.remove(c);
				em.getTransaction().commit();
			}
			
			// Populare clienti
			List<Client> lstClientiPersistenti = em.
					createQuery("SELECT c FROM Client c").getResultList();
			
			if (!lstClientiPersistenti.isEmpty()){
				em.getTransaction().begin();
				for (Client c: lstClientiPersistenti)
					em.remove(c);
				em.getTransaction().commit();					
			}
			// Create
			em.getTransaction().begin();
			em.persist(new Client("101", "Mobilis SRL", "RO5605658", "Iasi", "Iasi", "Sos. Pacurari, 138", "700545", "0232 250 179", "0232 258 747", "office@mobilis.com.ro"));
			em.persist(new Client("102", "The Red Point SA", "RO14172456", "Iasi", "Iasi","Bd. Poitiers, 16", "700671", " 0232 263 131", "0232 263 131", "office@theredpoint.ro"));
			em.persist(new Client("103", "Heliomedia SRL", "RO5605658", "Timisoara", "Timis","Str. Drubeta, 128", "307220" , "0730 712 234", "0256 466 470", " heliomedia_tm@yahoo.com "));
			em.persist(new Client("104", "ANDRASOFT CONSULTING SRL", "RO5605658", "Iasi", "Popricani"," str. Aleea Musatini, 21", "703489", "0733 939 111,", "0232 858 346", "andrasoftconsulting@gmail.com"));
			em.getTransaction().commit();
			// Read after create				
			lstClientiPersistenti = em.
					createQuery("SELECT c FROM Client c").getResultList();
			
			System.out.println("Lista clienti persistenti/salvati in baza de date");
			for (Client c: lstClientiPersistenti)
				System.out.println("Id client: " + c.getIdClient() + ", denumire client: " + c.getDenumireClient()+", cod fiscal: " + c.getCodFiscal()+", nume judet: " + c.getNumeJudet()+", nume localitate: " + c.getNumeLocalitate()+", strada: " + c.getStrada()
						//+ ", cod postal: " + c.getCodPostal()
						+" telefon: " + c.getTelefon()+", fax: " + c.getFax()+ ", e-mail: " + c.getEmail());
					
			// Populare produse
			List<Produs> lstProdusePersistente = em.
					createQuery("SELECT p FROM Produs p").getResultList();
			if (!lstProdusePersistente.isEmpty()){
				em.getTransaction().begin();
				for (Produs p: lstProdusePersistente)
					em.remove(p);
				em.getTransaction().commit();				
			}
			// Create
			em.getTransaction().begin();
			em.persist(new Produs(1, "Laptop Acer Aspire", "bc", 10.0));
			em.persist(new Produs(2, "Sistem Desktop PC", "bc", 15.0));
			em.persist(new Produs(3, "Tableta Samsung Galaxy Tab2", "bc", 20.0));
			em.persist(new Produs(4, "Laptop Lenovo G585", "bc", 25.0));
			em.getTransaction().commit();
			// Read after create				
			lstProdusePersistente = em.
					createQuery("SELECT p FROM Produs p").getResultList();
			
			
			System.out.println("Lista produselor persistente/salvate in baza de date");
			for (Produs p: lstProdusePersistente)
				System.out.println("Cod: " + p.getCod() + ", nume: " + p.getDenumire());					
			
			// Populare comenzi	
			Comanda c1 = new Comanda(1l, "", null);
			c1.adauga(lstProdusePersistente.get(0), 20.0);
			c1.adauga(lstProdusePersistente.get(1), 15.0);
			// Create
			em.getTransaction().begin();
			em.persist(c1);
			//em.getTransaction().commit();
			em.getTransaction().rollback();
			// Read after create				
			lstComenzi = em.
					createQuery("SELECT c FROM Comanda c").getResultList();
			
			
			System.out.println("Lista comenzilor persistente/salvate in baza de date");
			for (Comanda c: lstComenzi)
				System.out.println("Id: " + c.getId() + 
						", valoare: " + c.getValoareComanda());						
	}
		
}

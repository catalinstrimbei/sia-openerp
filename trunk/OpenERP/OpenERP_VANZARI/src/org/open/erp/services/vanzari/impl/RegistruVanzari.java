package org.open.erp.services.vanzari.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.Comanda;
import org.open.erp.services.vanzari.FacturaEmisa;

import javax.persistence.EntityManager;

/**
 * 
 * @author Irina Bogdan
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegistruVanzari {
	private static Logger logger = Logger.getLogger(RegistruVanzari.class.getName());	
	
	private EntityManager em;
	
	public RegistruVanzari(EntityManager _em){
		this.em = _em;
	}
	
	public Comanda salveazaComanda(Comanda comanda) throws Exception{
		try{
			if(comanda.getNrComanda() == null || em.find(comanda.getClass(), comanda.getNrComanda()) == null)
				em.persist(comanda);
			else
				em.merge(comanda);
		} catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return comanda;
	} 
	
	public void stergeComanda(Comanda comanda){
		em.remove(comanda);
	}
	
	public FacturaEmisa getFactura(Integer idFactura){
		return em.find(FacturaEmisa.class, idFactura);
	}
	
	public FacturaEmisa salveazaFactura(FacturaEmisa factura) throws Exception{
		try{
			if(factura.getIdFactura() == null || em.find(factura.getClass(), factura.getIdFactura()) == null)
				em.persist(factura);
			else
				em.merge(factura);
		} catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return factura;
	} 
	
	public void stergeFactura(FacturaEmisa factura){
		em.remove(factura);
	}
	
	public Client getClient(Integer idClient){
		return em.find(Client.class, idClient);
	}
	
	public List<Client> getClientByNume(String nume){
		return em.createQuery("SELECT c FROM Client c WHERE c.nume=:nume")
				.setParameter("nume", nume)
				.getResultList();
	}
	
	public Client salveazaClient(Client client) throws Exception{
		try{
			if(client.getId() == null || em.find(client.getClass(), client.getId()) == null)
				em.persist(client);
			else
				em.merge(client);
		} catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return client;
	}
	
	public List<FacturaEmisa> getFacturiClient(Integer idClient){
		return em.createQuery("SELECT f FROM FacturaEmisa f WHERE f.client.id:=IdClient")
				.setParameter("IdClient", idClient)
				.getResultList();
	}
	
}

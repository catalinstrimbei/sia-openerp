package org.open.erp.services.stocuri.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.open.erp.services.stocuri.Articol;
import org.open.erp.services.stocuri.BonTransfer;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.Loturi;


public class RegistruStocuri {

private static Logger logger = Logger.getLogger(RegistruStocuri.class.getName());	
	
	/* set up */
	private EntityManager entityManager;
	
	public RegistruStocuri(EntityManager em) {
		entityManager = em;
	}
	
	
	/* interogari */
	
	//Depozit
	public Depozit getDepozit(Integer id){
		return entityManager.find(Depozit.class, id);
	}
	
	public List<Depozit> getToateDepozitele(){
		return entityManager.createQuery("SELECT d FROM Depozit d").getResultList();
	}
	
	//Gestiune
	
	public Gestiune getGestiune(Integer id){
		return entityManager.find(Gestiune.class, id);
	}
	
	public List<Gestiune> getToateGestiunile(){
		return entityManager.createQuery("SELECT g FROM Gestiune g").getResultList();
	}
	public List<Gestiune> getGestiuneByLocatieDepozit(String locatie){
		return entityManager
				.createQuery("SELECT g FROM Gestiune g WHERE g.depozit.locatie=:locatie")
				.setParameter("locatie", locatie)
				.getResultList();
	}
	
	
	//persistenta
	public Depozit salveazaDepozit(Depozit depozit) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			/* proiect.getIdProiect() pentru proiect cu id generat*/
			if (depozit.getIdDepozit() == null || 
				entityManager.find(depozit.getClass(), depozit.getIdDepozit()) == null)
				entityManager.persist(depozit);
			else
				entityManager.merge(depozit);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return depozit;
	}
	public void stergeDepozit(Depozit depozit){
		entityManager.remove(depozit);
	}
	public void refreshDepozit(Depozit depozit){
		entityManager.refresh(depozit);
	}
	
	public Gestiune salveazaGestiune(Gestiune gestiune) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			/* proiect.getIdProiect() pentru proiect cu id generat*/
			if (gestiune.getIdGest() == null || 
				entityManager.find(gestiune.getClass(), gestiune.getIdGest()) == null)
				entityManager.persist(gestiune);
			else
				entityManager.merge(gestiune);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return gestiune;
	}
	public void stergeGestiune(Gestiune gestiune){
		entityManager.remove(gestiune);
	}
	public void refreshGestiune(Gestiune gestiune){
		entityManager.refresh(gestiune);
	}
	
	public Articol salveazaArticol(Articol articol) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			/* proiect.getIdProiect() pentru proiect cu id generat*/
			if (articol.getIdArticol() == null || 
				entityManager.find(articol.getClass(), articol.getIdArticol()) == null)
				entityManager.persist(articol);
			else
				entityManager.merge(articol);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return articol;
	}
	public void stergeArticol(Articol articol){
		entityManager.remove(articol);
	}
	public void refreshArticol(Articol articol){
		entityManager.refresh(articol);
	}
	
	public BonTransfer salveazaBonTransfer(BonTransfer bonTransfer) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			/* proiect.getIdProiect() pentru proiect cu id generat*/
			if (bonTransfer.getIdBonTransfer() == null || 
				entityManager.find(bonTransfer.getClass(), bonTransfer.getIdBonTransfer()) == null)
				entityManager.persist(bonTransfer);
			else
				entityManager.merge(bonTransfer);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return bonTransfer;
	}
	public void stergeBonTransfer(BonTransfer bonTransfer){
		entityManager.remove(bonTransfer);
	}
	public void refreshBonTransfer(BonTransfer bonTransfer){
		entityManager.refresh(bonTransfer);
	}
	
	public Loturi salveazaLot(Loturi loturi) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			/* proiect.getIdProiect() pentru proiect cu id generat*/
			if (loturi.getIdLot() == null || 
				entityManager.find(loturi.getClass(), loturi.getIdLot()) == null)
				entityManager.persist(loturi);
			else
				entityManager.merge(loturi);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return loturi;
	}
	public void stergeLot(Loturi lot){
		entityManager.remove(lot);
	}
	public void refreshLot(Loturi lot){
		entityManager.refresh(lot);
	}
	
}

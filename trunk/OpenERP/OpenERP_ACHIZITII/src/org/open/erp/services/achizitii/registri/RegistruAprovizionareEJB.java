package org.open.erp.services.achizitii.registri;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.Articol;
import org.open.erp.services.achizitii.Categorie;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.achizitii.OfertaAchizitie;
import org.open.erp.services.achizitii.PlanAprovizionare;

public class RegistruAprovizionareEJB {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegistruAprovizionareEJB.class.getName());	

	/* set up */
	private EntityManager entityManager;
	public RegistruAprovizionareEJB(EntityManager em) {
		entityManager = em;
	}
	@SuppressWarnings("unchecked")
	public Collection<OfertaAchizitie> getOferteAchizitiePerFurnizor(Furnizor furnizor_) throws Exception{
		try{
			return entityManager.createQuery("SELECT oa FROM OfertaAchizitie oa " +
											"WHERE oa.furnizor = :furnizor_")
											.setParameter("furnizor_", furnizor_)
											.getResultList();
		}catch(Exception ex){
			logger.error("ERROR: "+ex.getMessage());
			throw ex;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Articol> getArticolePeCategorii(Categorie categorie_) throws Exception{
		try{
			return entityManager.createQuery("SELECT a FROM Articol a where a.categorieArticol = :categorie")
											.setParameter("categorie", categorie_)
											.getResultList();
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Categorie> getCategoriiPeFurnizori(Furnizor furnizor_) throws Exception{
		try{
			return entityManager.createQuery("SELECT c FROM Categorie c where c.furnizoriCategorie = :furnizor")
											.setParameter("furnizor", furnizor_)
											.getResultList();
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<CerereOferta> getCereriOfertaPeStatus(Integer statusCerereOferta_) throws Exception{
		try{
			return entityManager.createQuery("SELECT co FROM CerereOferta co where co.statusCerereOferta = :status")
											.setParameter("status", statusCerereOferta_)
											.getResultList();
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Comanda> getcomenziPeFurnizor(Furnizor furnizor_) throws Exception{
		try{
			return entityManager.createQuery("SELECT c FROM Comanda c where c.furnizor = :furnizor")
											.setParameter("furnizor", furnizor_)
											.getResultList();
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Comanda> getComenziPeStatus(Integer statusComanda_) throws Exception{
		try{
			return entityManager.createQuery("SELECT c FROM Comanda c where c.statusComanda = :status")
											.setParameter("status", statusComanda_)
											.getResultList();
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	public PlanAprovizionare getPlanAprovizionare() throws Exception{
		try{
		    //List planuri =new ArrayList<PlanAprovizionare>();
			PlanAprovizionare plan= (PlanAprovizionare) entityManager.createQuery("SELECT p FROM PlanAprovizionare p where p.statusPlan = 0")											
											.getSingleResult();
			logger.error("uiiiiiiiiiiiiiiiiiiiiiiiiii "+plan.getIdPlanAprovizionare());
			return plan;
			//return (PlanAprovizionare) planuri.get(0);
			/*return new PlanAprovizionare(1,1,2008,new Date(),null,PlanAprovizionare.IN_CURS);*/
		}catch(Exception ex){
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
}


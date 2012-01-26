package org.open.erp.services.achizitii.registri;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.Articol;
import org.open.erp.services.achizitii.Categorie;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.NIR;
import org.open.erp.services.achizitii.OfertaAchizitie;
import org.open.erp.services.achizitii.PlanAprovizionare;



public class RegistruAprovizionare {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegistruAprovizionare.class.getName());	

		/* set up */
		private EntityManager entityManager;
		public RegistruAprovizionare(EntityManager em) {
			entityManager = em;
		}

	Articol getArticoleById(Integer idMaterial_)	throws Exception 
	{
		try
		{
			return entityManager.find(Articol.class, idMaterial_);
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	
	Collection<Articol>	getListaArticole() throws Exception 
	{
		try
		{
			return entityManager.createQuery("SELECT a FROM Articol a").getResultList();
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
		
	Articol	salveazaArticol(Articol articol_) throws Exception 
	{
		try
		{		
			if (articol_.getIdMaterial() == null ||
				entityManager.find(articol_.getClass(), articol_.getIdMaterial()) == null)
				entityManager.persist(articol_);
			else
				entityManager.merge(articol_);	
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
		return articol_;
	}
	
	void stergeArticol(Articol articol_) throws Exception
	{
		try
		{
			entityManager.remove(articol_);
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
//////////////////////////
	Categorie getCategorieById(long id_cat_)	throws Exception 
	{
		try
		{
			return entityManager.find(Categorie.class, id_cat_);
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	
	Collection<Categorie>	getListaCategorii() throws Exception 
	{
		try
		{
			return entityManager.createQuery("SELECT c FROM Categorie c").getResultList();
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
		
	Categorie salveazaCategorie(Categorie categorie_) throws Exception 
	{
		try
		{		
			if (Long.valueOf(categorie_.getId_cat()) == null ||
				entityManager.find(categorie_.getClass(), categorie_.getId_cat()) == null)
				entityManager.persist(categorie_);
			else
				entityManager.merge(categorie_);	
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
		return categorie_;
	}
	
	void stergeCategorie(Categorie categorie_) throws Exception
	{
		try
		{
			entityManager.remove(categorie_);
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
////////////
	CerereOferta getCerereOfertaById(long id_CerereOferta_)	throws Exception 
	{
		try
		{
			return entityManager.find(CerereOferta.class, id_CerereOferta_);
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	
	Collection<CerereOferta>	getListaCereriOferta() throws Exception 
	{
		try
		{
			return entityManager.createQuery("SELECT co FROM CerereOferta co").getResultList();
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
		
	CerereOferta salveazaCerereOferta(CerereOferta cerereOferta_) throws Exception 
	{
		try
		{		
			if (Long.valueOf(cerereOferta_.getId_CerereOferta()) == null ||
				entityManager.find(cerereOferta_.getClass(), cerereOferta_.getId_CerereOferta()) == null)
				entityManager.persist(cerereOferta_);
			else
				entityManager.merge(cerereOferta_);	
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
		return cerereOferta_;
	}
	
	void stergeCerereOferta(CerereOferta cerereOferta_) throws Exception
	{
		try
		{
			entityManager.remove(cerereOferta_);
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
///////////////////
	Comanda getComandaById(Integer idComanda_)	throws Exception 
	{
		try
		{
			return entityManager.find(Comanda.class, idComanda_);
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	
	Collection<Comanda>	getListaComenzi() throws Exception 
	{
		try
		{
			return entityManager.createQuery("SELECT c FROM Comanda c").getResultList();
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
		
	Comanda salveazaComanda (Comanda comanda_) throws Exception 
	{
		try
		{		
			if ( comanda_.getIdComanda() == null ||
				entityManager.find(comanda_.getClass(), comanda_.getIdComanda()) == null)
				entityManager.persist(comanda_);
			else
				entityManager.merge(comanda_);	
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
		return comanda_;
	}
	
	void stergeComanda(Comanda comanda_) throws Exception
	{
		try
		{
			entityManager.remove(comanda_);
		}
		catch(Exception ex)
		{
			logger.error("ERROR "  + ex.getMessage());
			throw ex;
		}
	}
	
	
	//Metode NIR
	
			NIR				getNIRByIdId(long nrDocument_) throws Exception 
			{
				try
				{
					return entityManager.find(NIR.class, nrDocument_);
				}
				catch(Exception ex)
				{				
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
				
			}
				
			@SuppressWarnings("unchecked")
			Collection<NIR>	getListaNIR() throws Exception 
			{
				try
				{
					return entityManager.createQuery("SELECT n FROM NIR n").getResultList();
				}
				catch(Exception ex)
				{
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
			}
			
			NIR		salveazaNIR(NIR NIR_) throws Exception 
			{
				try
				{		
					if (Long.valueOf(NIR_.getNrDoc()) == null ||
						entityManager.find(NIR_.getClass(), NIR_.getNrDoc()) == null)
						entityManager.persist(NIR_);
					else
						entityManager.merge(NIR_);	
				}
				catch(Exception ex)
				{
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
				return NIR_;
			}

			void	stergeNIR(NIR NIR_) throws Exception
			{
				try
				{
					entityManager.remove(NIR_);
				}
				catch(Exception ex)
				{
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
			}
			//Metode OfertaAchizitie
			
			OfertaAchizitie				getOfertaAchizitie(long id_OfertaAchizitie_) throws Exception 
			{
				try
				{
					return entityManager.find(OfertaAchizitie.class, id_OfertaAchizitie_);
				}
				catch(Exception ex)
				{				
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
				
			}
				
			@SuppressWarnings("unchecked")
			Collection<OfertaAchizitie>	getListaOfertaAchizitie() throws Exception 
			{
				try
				{
					return entityManager.createQuery("SELECT oa FROM OfertaAchizitie oa").getResultList();
				}
				catch(Exception ex)
				{
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
			}
			
			OfertaAchizitie		salveazaOfertaAchizitie(OfertaAchizitie OfertaAchizitie_) throws Exception 
			{
				try
				{		
					if (Long.valueOf(OfertaAchizitie_.getId_OfertaAchizitie()) == null ||
						entityManager.find(OfertaAchizitie_.getClass(), OfertaAchizitie_.getId_OfertaAchizitie()) == null)
						entityManager.persist(OfertaAchizitie_);
					else
						entityManager.merge(OfertaAchizitie_);	
				}
				catch(Exception ex)
				{
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
				return OfertaAchizitie_;
			}

			void	stergeOfertaAchizitie(OfertaAchizitie OfertaAchizitie) throws Exception
			{
				try
				{
					entityManager.remove(OfertaAchizitie);
				}
				catch(Exception ex)
				{
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
			}
			//Metode PlanAprovizionare
			PlanAprovizionare getPlanAprovizionareById(long idPlanAprovizionare_) throws Exception 
			{
				try
				{
					return entityManager.find(PlanAprovizionare.class, idPlanAprovizionare_);
				}
				catch(Exception ex)
				{				
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
				
			}
				
			@SuppressWarnings("unchecked")
			Collection<PlanAprovizionare>	getListaPlanAprovizionare() throws Exception 
			{
				try
				{
					return entityManager.createQuery("SELECT pl FROM PlanAprovizionare pl").getResultList();
				}
				catch(Exception ex)
				{
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
			}
			
			PlanAprovizionare		salveazaPlanAprovizionare(PlanAprovizionare PlanAprovizionare_) throws Exception 
			{
				try
				{		
					if (Long.valueOf(PlanAprovizionare_.getIdPlanAprovizionare()) == null ||
						entityManager.find(PlanAprovizionare_.getClass(), PlanAprovizionare_.getIdPlanAprovizionare()) == null)
						entityManager.persist(PlanAprovizionare_);
					else
						entityManager.merge(PlanAprovizionare_);	
				}
				catch(Exception ex)
				{
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
				return PlanAprovizionare_;
			}

			void	stergePlanAprovizionare(PlanAprovizionare PlanAprovizionare_) throws Exception
			{
				try
				{
					entityManager.remove(PlanAprovizionare_);
				}
				catch(Exception ex)
				{
					logger.error("ERROR: "+ex.getMessage());
					throw ex;
				}
			}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}

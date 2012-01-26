package org.open.erp.services.achizitii.registri;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;

import javax.persistence.EntityManager;

import org.open.erp.services.achizitii.Articol;
import org.open.erp.services.achizitii.Categorie;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.achizitii.LinieCerereOferta;
import org.open.erp.services.achizitii.LinieComanda;
import org.open.erp.services.achizitii.LinieFacturaAchizitie;
import org.open.erp.services.achizitii.LinieNIR;
import org.open.erp.services.achizitii.LinieOfertaAchizitie;
import org.open.erp.services.achizitii.LiniePlanAprovizionare;
import org.open.erp.services.achizitii.NIR;
import org.open.erp.services.achizitii.OfertaAchizitie;
import org.open.erp.services.achizitii.PlanAprovizionare;

public class RegistruAprovizionare {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(RegistruAprovizionare.class.getName());

	/* set up */
	private EntityManager entityManager;

	public RegistruAprovizionare(EntityManager em) {
		entityManager = em;
	}

	Articol getArticoleById(Integer idMaterial_) throws Exception {
		try {
			return entityManager.find(Articol.class, idMaterial_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	Collection<Articol> getListaArticole() throws Exception {
		try {
			return entityManager.createQuery("SELECT a FROM Articol a")
					.getResultList();
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	Articol salveazaArticol(Articol articol_) throws Exception {
		try {
			if (articol_.getIdMaterial() == null
					|| entityManager.find(articol_.getClass(),
							articol_.getIdMaterial()) == null)
				entityManager.persist(articol_);
			else
				entityManager.merge(articol_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
		return articol_;
	}

	void stergeArticol(Articol articol_) throws Exception {
		try {
			entityManager.remove(articol_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	// ////////////////////////
	Categorie getCategorieById(long id_cat_) throws Exception {
		try {
			return entityManager.find(Categorie.class, id_cat_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	Collection<Categorie> getListaCategorii() throws Exception {
		try {
			return entityManager.createQuery("SELECT c FROM Categorie c")
					.getResultList();
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	Categorie salveazaCategorie(Categorie categorie_) throws Exception {
		try {
			if (Long.valueOf(categorie_.getId_cat()) == null
					|| entityManager.find(categorie_.getClass(),
							categorie_.getId_cat()) == null)
				entityManager.persist(categorie_);
			else
				entityManager.merge(categorie_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
		return categorie_;
	}

	void stergeCategorie(Categorie categorie_) throws Exception {
		try {
			entityManager.remove(categorie_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	// //////////
	CerereOferta getCerereOfertaById(long id_CerereOferta_) throws Exception {
		try {
			return entityManager.find(CerereOferta.class, id_CerereOferta_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	Collection<CerereOferta> getListaCereriOferta() throws Exception {
		try {
			return entityManager.createQuery("SELECT co FROM CerereOferta co")
					.getResultList();
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	CerereOferta salveazaCerereOferta(CerereOferta cerereOferta_)
			throws Exception {
		try {
			if (Long.valueOf(cerereOferta_.getId_CerereOferta()) == null
					|| entityManager.find(cerereOferta_.getClass(),
							cerereOferta_.getId_CerereOferta()) == null)
				entityManager.persist(cerereOferta_);
			else
				entityManager.merge(cerereOferta_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
		return cerereOferta_;
	}

	void stergeCerereOferta(CerereOferta cerereOferta_) throws Exception {
		try {
			entityManager.remove(cerereOferta_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	// /////////////////
	Comanda getComandaById(Integer idComanda_) throws Exception {
		try {
			return entityManager.find(Comanda.class, idComanda_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	Collection<Comanda> getListaComenzi() throws Exception {
		try {
			return entityManager.createQuery("SELECT c FROM Comanda c")
					.getResultList();
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	Comanda salveazaComanda(Comanda comanda_) throws Exception {
		try {
			if (comanda_.getIdComanda() == null
					|| entityManager.find(comanda_.getClass(),
							comanda_.getIdComanda()) == null)
				entityManager.persist(comanda_);
			else
				entityManager.merge(comanda_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
		return comanda_;
	}

	void stergeComanda(Comanda comanda_) throws Exception {
		try {
			entityManager.remove(comanda_);
		} catch (Exception ex) {
			logger.error("ERROR " + ex.getMessage());
			throw ex;
		}
	}

	// Metode NIR

	NIR getNIRByIdId(long nrDocument_) throws Exception {
		try {
			return entityManager.find(NIR.class, nrDocument_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}

	}

	@SuppressWarnings("unchecked")
	Collection<NIR> getListaNIR() throws Exception {
		try {
			return entityManager.createQuery("SELECT n FROM NIR n")
					.getResultList();
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}

	NIR salveazaNIR(NIR NIR_) throws Exception {
		try {
			if (Long.valueOf(NIR_.getNrDoc()) == null
					|| entityManager.find(NIR_.getClass(), NIR_.getNrDoc()) == null)
				entityManager.persist(NIR_);
			else
				entityManager.merge(NIR_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
		return NIR_;
	}

	void stergeNIR(NIR NIR_) throws Exception {
		try {
			entityManager.remove(NIR_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}

	// Metode OfertaAchizitie

	OfertaAchizitie getOfertaAchizitie(long id_OfertaAchizitie_)
			throws Exception {
		try {
			return entityManager.find(OfertaAchizitie.class,
					id_OfertaAchizitie_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}

	}

	@SuppressWarnings("unchecked")
	Collection<OfertaAchizitie> getListaOfertaAchizitie() throws Exception {
		try {
			return entityManager.createQuery(
					"SELECT oa FROM OfertaAchizitie oa").getResultList();
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}

	OfertaAchizitie salveazaOfertaAchizitie(OfertaAchizitie OfertaAchizitie_)
			throws Exception {
		try {
			if (Long.valueOf(OfertaAchizitie_.getId_OfertaAchizitie()) == null
					|| entityManager.find(OfertaAchizitie_.getClass(),
							OfertaAchizitie_.getId_OfertaAchizitie()) == null)
				entityManager.persist(OfertaAchizitie_);
			else
				entityManager.merge(OfertaAchizitie_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
		return OfertaAchizitie_;
	}

	void stergeOfertaAchizitie(OfertaAchizitie OfertaAchizitie)
			throws Exception {
		try {
			entityManager.remove(OfertaAchizitie);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}

	// Metode PlanAprovizionare
	PlanAprovizionare getPlanAprovizionareById(long idPlanAprovizionare_)
			throws Exception {
		try {
			return entityManager.find(PlanAprovizionare.class,
					idPlanAprovizionare_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}

	}

	@SuppressWarnings("unchecked")
	Collection<PlanAprovizionare> getListaPlanAprovizionare() throws Exception {
		try {
			return entityManager.createQuery(
					"SELECT pl FROM PlanAprovizionare pl").getResultList();
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}

	PlanAprovizionare salveazaPlanAprovizionare(
			PlanAprovizionare PlanAprovizionare_) throws Exception {
		try {
			if (Long.valueOf(PlanAprovizionare_.getIdPlanAprovizionare()) == null
					|| entityManager.find(PlanAprovizionare_.getClass(),
							PlanAprovizionare_.getIdPlanAprovizionare()) == null)
				entityManager.persist(PlanAprovizionare_);
			else
				entityManager.merge(PlanAprovizionare_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
		return PlanAprovizionare_;
	}

	void stergePlanAprovizionare(PlanAprovizionare PlanAprovizionare_)
			throws Exception {
		try {
			entityManager.remove(PlanAprovizionare_);
		} catch (Exception ex) {
			logger.error("ERROR: " + ex.getMessage());
			throw ex;
		}
	}

	Factura getFacturaById(Integer idActivitate_) throws Exception {
		try {
			return entityManager.find(Factura.class, idActivitate_);
		} catch (Exception ex) {

			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			throw ex;
		}
	}

	Collection<Factura> getListaFactura() throws Exception {
		try {
			return entityManager.createQuery("SELECT x FROM Factura x")
					.getResultList();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}

	Factura salveazaFactura(Factura factura_) throws Exception {
		try {
			if (factura_.getNrFact() == null
					|| entityManager.find(factura_.getClass(),
							factura_.getNrFact()) == null)
				entityManager.persist(factura_);
			else
				entityManager.merge(factura_);
		} catch (Exception ex) {
			logger.error("eroare in metoda salveazafactura");
			ex.printStackTrace();
			throw ex;
		}
		return factura_;
	}

	void stergeFactura(Factura factura_) throws Exception {
		try {
			entityManager.remove(factura_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}

	Furnizor getFurnizorById(Integer id_) throws Exception {
		try {
			return (Furnizor) entityManager
					.createQuery(
							"SELECT x FROM Furnizor x WHERE x.id == :idFurnizor AND rownum <= 1")
					.setParameter("idFurnizor", id_).getSingleResult();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("eroare in metoda getFurnizorbyId");
			ex.printStackTrace();
			throw ex;
		}
	}

	Collection<Furnizor> getListaFurnizor() throws Exception {
		try {
			return entityManager.createQuery("SELECT x FROM Furnizor x")
					.getResultList();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("eroare in metoda getListaFurnizor");
			ex.printStackTrace();
			throw ex;
		}
	}

	Furnizor salveazaFurnizor(Furnizor furnizor_) throws Exception {
		logger.info("Am intrat pe  salveazaFurnizor in RegistruAprovizionare");
		try {
			logger.info("Am intrat pe  try in salveazaFurnizor in RegistruAprovizionare");
			if (furnizor_ == null)
				logger.info(" furnizor_ is null");
			else if ((Integer) (furnizor_.getIdFurnizor()) != null)
				logger.info(" furnizor_.getIdFurnizor() = "
						+ furnizor_.getIdFurnizor());
			else
				logger.info(" furnizor_.getIdFurnizor() = 0");

			if ((Integer) furnizor_.getIdFurnizor() == null
					|| entityManager.find(furnizor_.getClass(),
							furnizor_.getIdFurnizor()) == null)

			{
				logger.info("Am intrat pe  if");
				entityManager.persist(furnizor_);
			} else
				entityManager.merge(furnizor_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
		return furnizor_;
	}

	LinieCerereOferta getLinieCerereOfertaById(Integer idliniecerereoferta_)
			throws Exception {
		try {
			return entityManager.find(LinieCerereOferta.class,
					idliniecerereoferta_);
		} catch (Exception ex) {

			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			throw ex;
		}
	}

	Collection<LinieCerereOferta> getLinieCerereOferta() throws Exception {
		try {
			return entityManager.createQuery(
					"SELECT x FROM LinieCerereOferta x").getResultList();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}

	LinieCerereOferta salveazaLinieCerereOferta(
			LinieCerereOferta liniecerereoferta_) throws Exception {
		try {
			if (Long.valueOf(liniecerereoferta_.getIdLinieCerereOferta()) == null
					|| entityManager.find(liniecerereoferta_.getClass(),
							liniecerereoferta_.getIdLinieCerereOferta()) == null)
				entityManager.persist(liniecerereoferta_);
			else
				entityManager.merge(liniecerereoferta_);
		} catch (Exception ex) {
			logger.error("eroare in metoda salveazaLinieCerereOferta");
			ex.printStackTrace();
			throw ex;
		}
		return liniecerereoferta_;
	}

	void stergeLinieCerereOferta(LinieCerereOferta liniecerereoferta_)
			throws Exception {
		try {
			entityManager.remove(liniecerereoferta_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}

	LinieComanda getLinieComandaById(Integer idliniecomanda_) throws Exception {
		try {
			return entityManager.find(LinieComanda.class, idliniecomanda_);
		} catch (Exception ex) {

			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			throw ex;
		}
	}

	Collection<LinieComanda> getLinieComanda() throws Exception {
		try {
			return entityManager.createQuery("SELECT x FROM LinieComanda x")
					.getResultList();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}

	LinieComanda salveazaLinieComanda(LinieComanda liniecomanda_)
			throws Exception {
		try {
			if (Long.valueOf(liniecomanda_.getIdLinieComanda()) == null
					|| entityManager.find(liniecomanda_.getClass(),
							liniecomanda_.getIdLinieComanda()) == null)
				entityManager.persist(liniecomanda_);
			else
				entityManager.merge(liniecomanda_);
		} catch (Exception ex) {
			logger.error("eroare in metoda salveazaLinieComanda");
			ex.printStackTrace();
			throw ex;
		}
		return liniecomanda_;
	}

	void stergeLinieComanda(LinieComanda liniecomanda_) throws Exception {
		try {
			entityManager.remove(liniecomanda_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			ex.printStackTrace();
			throw ex;
		}
	}

	// ----------------LinieFacturaAchizitie--------------------------
	LinieFacturaAchizitie getLinieFacturaAchizitieById(Integer linieDoc)
			throws Exception {
		try {
			return entityManager.find(LinieFacturaAchizitie.class, linieDoc);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	Collection<LinieFacturaAchizitie> getLinieFacturaAchizitie()
			throws Exception {
		try {
			return entityManager.createQuery(
					"SELECT x FROM LinieFacturaAchizitie x").getResultList();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	LinieFacturaAchizitie salveazaLinieFacturaAchizitie(
			LinieFacturaAchizitie lfactAchiz_) throws Exception {
		try {
			if (lfactAchiz_.getLinieDoc() == null
					|| entityManager.find(lfactAchiz_.getClass(),
							lfactAchiz_.getLinieDoc()) == null)
				entityManager.persist(lfactAchiz_);
			else
				entityManager.merge(lfactAchiz_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
		return lfactAchiz_;
	}

	void stergeLinieFacturaAchizitie(LinieFacturaAchizitie lFactAchiz_)
			throws Exception {
		try {
			entityManager.remove(lFactAchiz_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	// ------------------------linie nir---------------------
	LinieNIR getLinieNIRById(Integer linieDoc) throws Exception {
		try {
			return entityManager.find(LinieNIR.class, linieDoc);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	Collection<LinieNIR> getLinieNIR() throws Exception {
		try {
			return entityManager.createQuery("SELECT x FROM LinieNIR x")
					.getResultList();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	LinieNIR salveazaLinieNIR(LinieNIR linieNir_) throws Exception {
		try {
			if (linieNir_.getLinieDoc() == null
					|| entityManager.find(linieNir_.getClass(),
							linieNir_.getLinieDoc()) == null)
				entityManager.persist(linieNir_);
			else
				entityManager.merge(linieNir_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
		return linieNir_;
	}

	void stergeLinieNIR(LinieNIR linieNir_) throws Exception {
		try {
			entityManager.remove(linieNir_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	// --------Linie oferta achizitie----------
	LinieOfertaAchizitie getLinieOfertaAchizitieById(Integer linieDoc)
			throws Exception {
		try {
			return entityManager.find(LinieOfertaAchizitie.class, linieDoc);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	Collection<LinieOfertaAchizitie> getLinieOfertaAchizitie() throws Exception {
		try {
			return entityManager.createQuery(
					"SELECT x FROM LinieOfertaAchizitie x").getResultList();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	LinieOfertaAchizitie salveazaLinieOfertaAchizitie(
			LinieOfertaAchizitie lofertaAchiz_) throws Exception {
		try {
			if (Long.valueOf(lofertaAchiz_.getIdLinieOfertaAchizitie()) == null
					|| entityManager.find(lofertaAchiz_.getClass(),
							lofertaAchiz_.getIdLinieOfertaAchizitie()) == null)
				entityManager.persist(lofertaAchiz_);
			else
				entityManager.merge(lofertaAchiz_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
		return lofertaAchiz_;
	}

	void stergeLinieOfertaAchizitie(LinieOfertaAchizitie lofertaAchiz_)
			throws Exception {
		try {
			entityManager.remove(lofertaAchiz_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	// -----------------------linie plan aprovizionare-------------
	LiniePlanAprovizionare getLiniePlanAprovizionareById(
			Integer idLiniePlanAprovizionare) throws Exception {
		try {
			return entityManager.find(LiniePlanAprovizionare.class,
					idLiniePlanAprovizionare);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	Collection<LiniePlanAprovizionare> getLiniePlanAprovizionare()
			throws Exception {
		try {
			return entityManager.createQuery(
					"SELECT x FROM LiniePlanAprovizionare x").getResultList();
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

	LiniePlanAprovizionare salveazaLiniePlanAprovizionare(
			LiniePlanAprovizionare lofertaAprov_) throws Exception {
		try {
			if (Long.valueOf(lofertaAprov_.getIdLiniePlanAprovizionare()) == null
					|| entityManager.find(lofertaAprov_.getClass(),
							lofertaAprov_.getIdLiniePlanAprovizionare()) == null)
				entityManager.persist(lofertaAprov_);
			else
				entityManager.merge(lofertaAprov_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
		return lofertaAprov_;
	}

	void stergeLiniePlanAprovizionare(LiniePlanAprovizionare lofertaAprov_)
			throws Exception {
		try {
			entityManager.remove(lofertaAprov_);
		} catch (Exception ex) {
			logger.error("Persistence Error in method >> "
					+ Thread.currentThread().getStackTrace()[1].getMethodName());
			logger.error("Class >> " + ex.getClass().toString()
					+ "<< StackTrace >> " + ex.getStackTrace().toString()
					+ "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();
			StringWriter st = new StringWriter();
			PrintWriter pt = new PrintWriter(st);
			ex.printStackTrace(pt);
			logger.error("<< Stack Trace >>" + st.toString());
			throw ex;
		}
	}

}

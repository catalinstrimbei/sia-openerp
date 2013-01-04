package org.open.erp.services.achizitii.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.CerereAprov;
import org.open.erp.services.achizitii.CerereOferta;
import org.open.erp.services.achizitii.Comanda;
import org.open.erp.services.achizitii.Factura;
import org.open.erp.services.achizitii.LiniiCerereAprov;
import org.open.erp.services.achizitii.LiniiCerereOferta;
import org.open.erp.services.achizitii.LiniiComanda;
import org.open.erp.services.achizitii.LiniiFactura;
import org.open.erp.services.achizitii.LiniiNIR;
import org.open.erp.services.achizitii.LiniiOferta;
import org.open.erp.services.achizitii.LiniiPlanAprov;
import org.open.erp.services.achizitii.NIR;
import org.open.erp.services.achizitii.Oferta;
import org.open.erp.services.achizitii.PlanAprov;


/**
 * 
 * @BusinessObject(Repository)
 * 
 */
public class RegistruAchizitii {
	public static Logger logger = Logger.getLogger(RegistruAchizitii.class.getName());
	
	/* set up */
	private EntityManager entityManager;
	public RegistruAchizitii(EntityManager em){
		entityManager = em;
	}

	/* interogari */
	//PlanAprov
	public PlanAprov getPlanAprov(Integer id){
		return entityManager.find(PlanAprov.class, id);
	}
	
	public List<PlanAprov> getToatePlanurileAprov(){
		return entityManager.createQuery("SELECT p FROM PlanAprov p").getResultList();
	}
	
	public List<PlanAprov> getPlanAprovDupaAn(Integer an){
		return entityManager
				.createQuery("SELECT p FROM PlanAprov p WHERE p.an=:an")
				.setParameter("an", an)
				.getResultList();
		//:an corespunde cu parametrul metodei
		//p.an  si   "an"  corespund cu cele din BD
	}
	
	//CerereAprov
	public CerereAprov getCerereAprov(Integer id){
		return entityManager.find(CerereAprov.class, id);
	}
	
	public List<CerereAprov> getToateCererileAprov(){
		return entityManager.createQuery("SELECT p FROM CerereAprov p").getResultList();
	}
	
	public List<CerereAprov> getCerereAprovDupaMaterial(String idMaterial){
		return entityManager
				.createQuery("SELECT p FROM CerereAprov p WHERE p.material.codMaterial=:codMaterial")
				.setParameter("codMaterial", idMaterial)
				.getResultList();
	}
	
	//CerereOferta
	public CerereOferta getCerereOferta(Integer id){
		return entityManager.find(CerereOferta.class, id);
	}
	
	public List<CerereOferta> getToateCererileDeOferta(){
		return entityManager.createQuery("SELECT p FROM CerereOferta p").getResultList();
	}
	
	public List<CerereOferta> getCerereOfertaDupaIdFurnizor(Integer idFurnizor){
		return entityManager
				.createQuery("SELECT p FROM CerereOferta p WHERE p.furnizor.idFurnizor=:idFurnizor")
				.setParameter("idFurnizor", idFurnizor)
				.getResultList();
	}
	
	public List<CerereOferta> getCerereOfertaDupaNumeFurnizor(String nume){
		return entityManager
				.createQuery("SELECT p FROM CerereOferta p WHERE p.furnizor.numeFurnizor=:numeFurnizor")
				.setParameter("numeFurnizor", nume)
				.getResultList();
	}
	
	//Comanda
	public Comanda getComanda(Integer id){
		return entityManager.find(Comanda.class, id);
	}
	
	public List<Comanda> getToateComenzile(){
		return entityManager.createQuery("SELECT p FROM Comenda p").getResultList();
	}
	
	public List<Comanda> getComandaDupaIdFurnizor(Integer idFurnizor){
		return entityManager
				.createQuery("SELECT p FROM Comanda p WHERE p.funrizor.idFurnizor=:idFurnizor")
				.setParameter("idFurnizor", idFurnizor)
				.getResultList();
	}
	
	public List<Comanda> getComandaDupaNumeFurnizor(String nume){
		return entityManager
				.createQuery("SELECT p FROM Comanda p WHERE p.funrizor.numeFurnizor=:numeFurnizor")
				.setParameter("numeFurnizor", nume)
				.getResultList();
	}
	
	//Oferta
	public Oferta getOferta(Integer id){
		return entityManager.find(Oferta.class, id);
	}
	
	public List<Oferta> getToateOfertele(){
		return entityManager.createQuery("SELECT p FROM Oferta p").getResultList();
	}
	
	public List<Oferta> getOfertaDupaIdFurnizor(Integer idFurnizor){
		return entityManager
				.createQuery("SELECT p FROM Oferta p WHERE p.funrizor.idFurnizor=:idFurnizor")
				.setParameter("idFurnizor", idFurnizor)
				.getResultList();
	}
	
	public List<Oferta> getOfertaDupaNumeFurnizor(String nume){
		return entityManager
				.createQuery("SELECT p FROM Oferta p WHERE p.funrizor.numeFurnizor=:numeFurnizor")
				.setParameter("numeFurnizor", nume)
				.getResultList();
	}
	
	public List<Oferta> getOfertaDupaCerereOferta(Integer idCerereOferta){
		return entityManager
				.createQuery("SELECT p FROM Oferta p WHERE p.cerereOferta.nrCerereOferta=:nrCerereOferta")
				.setParameter("nrCerereOferta", idCerereOferta)
				.getResultList();
	}
	
	public List<Oferta> getOfertaDupaIdFurnizorDinCerereOferta(Integer idFurnizor){
		return entityManager
				.createQuery("SELECT p FROM Oferta p WHERE p.cerereOferta.furnizor.idFurnizor=:idFurnizor")
				.setParameter("idFurnizor", idFurnizor)
				.getResultList();
	} //Merge din Oferta - CerereOferta - Furnizori  si ia idFurnizor
	
	public List<Oferta> getOfertaDupaNumeFurnizorDinCerereOferta(String nume){
		return entityManager
				.createQuery("SELECT p FROM Oferta p WHERE p.cerereOferta.furnizor.numeFurnizor=:numeFurnizor")
				.setParameter("numeFurnizor", nume)
				.getResultList();
	}
	
	//NIR
	public NIR getNIR(Integer id){
		return entityManager.find(NIR.class, id);
	}
	
	public List<NIR> getToateNIRurile(){
		return entityManager.createQuery("SELECT p FROM NIR p").getResultList();
	}
	
	public List<NIR> getNIRDupaIdFurnizor(Integer idFurnizor){
		return entityManager
				.createQuery("SELECT p FROM NIR p WHERE p.furnizor.idFurnizor=:idFurnizor")
				.setParameter("idFurnizor", idFurnizor)
				.getResultList();
	}
	
	public List<NIR> getNIRDupaNumeFurnizor(String nume){
		return entityManager
				.createQuery("SELECT p FROM NIR p WHERE p.furnizor.numeFurnizor=:numeFurnizor")
				.setParameter("numeFurnizor", nume)
				.getResultList();
	}
	
	//Factura
	public Factura getFactura(Integer id){
		return entityManager.find(Factura.class, id);
	}
	
	public List<Factura> getToateFacturile(){
		return entityManager.createQuery("SELECT p FROM Factura p").getResultList();
	}
	
	public List<Factura> getFacuraDupaIdFurnizor(Integer idFurnizor){
		return entityManager
				.createQuery("SELECT p FROM Factura p WHERE p.funrizor.idFurnizor=:idFurnizor")
				.setParameter("idFurnizor", idFurnizor)
				.getResultList();
	}
	
	public List<Factura> getFacturaDupaNumeFurnizor(String nume){
		return entityManager
				.createQuery("SELECT p FROM Factura p WHERE p.funrizor.numeFurnizor=:numeFurnizor")
				.setParameter("numeFurnizor", nume)
				.getResultList();
	}
	
	
	/* persistenta */
	//PlanAprov
	public PlanAprov salveazaPlanAprov(PlanAprov planAprov) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (planAprov.getNrPlanAprov() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(planAprov.getClass(), planAprov.getNrPlanAprov()) == null)
				entityManager.persist(planAprov);
			else
				entityManager.merge(planAprov);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return planAprov;
	}
	
	public void stergePlanAprov(PlanAprov planAprov){
		entityManager.remove(planAprov);
	}

	public LiniiPlanAprov salveazaLiniiPlanAprov(LiniiPlanAprov liniePlanAprov) throws Exception{
		logger.debug("--De salvat linia planului de aprovizionare cu ID: " + liniePlanAprov.getNrLiniePlanAprov());
		try{
			/* Proiectul plimbandu-se de la client-la server-inapoi la client-iarasi la server
			 * nu este adus inca in/atasat de cache
			 * */
			//if (!entityManager.contains(activitate.getProiect()))
			entityManager.merge(liniePlanAprov.getPlanAProv());
			
			//if (!entityManager.contains(proiect))
			if (liniePlanAprov.getNrLiniePlanAprov() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(liniePlanAprov.getClass(), liniePlanAprov.getNrLiniePlanAprov()) == null)
				entityManager.persist(liniePlanAprov);
			else
				entityManager.merge(liniePlanAprov);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return liniePlanAprov;
	}	
	
	public void refreshPlanAprov(PlanAprov planAprov){
		entityManager.refresh(planAprov);
	}
	
	//CerereAprov
	public CerereAprov salveazaCerereAprov(CerereAprov cerereAprov) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (cerereAprov.getNrCerereAprov() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(cerereAprov.getClass(), cerereAprov.getNrCerereAprov()) == null)
				entityManager.persist(cerereAprov);
			else
				entityManager.merge(cerereAprov);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return cerereAprov;
	}
	
	public void stergeCerereAprov(CerereAprov cerereAprov){
		entityManager.remove(cerereAprov);
	}

	public LiniiCerereAprov salveazaLinieCerereAprov(LiniiCerereAprov linieCerereAprov) throws Exception{
		logger.debug("--De salvat linia din CerereAprov cu ID: " + linieCerereAprov.getNrLinieCerereAprov());
		try{
			/* Proiectul plimbandu-se de la client-la server-inapoi la client-iarasi la server
			 * nu este adus inca in/atasat de cache
			 * */
			//if (!entityManager.contains(activitate.getProiect()))
			entityManager.merge(linieCerereAprov.getCerereAprov());
			
			//if (!entityManager.contains(proiect))
			if (linieCerereAprov.getNrLinieCerereAprov() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(linieCerereAprov.getClass(), linieCerereAprov.getNrLinieCerereAprov()) == null)
				entityManager.persist(linieCerereAprov);
			else
				entityManager.merge(linieCerereAprov);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return linieCerereAprov;
	}	
	
	public void refreshCerereAprov(CerereAprov cerereAprov){
		entityManager.refresh(cerereAprov);
	}
	
	//CerereOferta
	public CerereOferta salveazaCerereOferta(CerereOferta cerereOferta) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (cerereOferta.getNrCerereOferta() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(cerereOferta.getClass(), cerereOferta.getNrCerereOferta()) == null)
				entityManager.persist(cerereOferta);
			else
				entityManager.merge(cerereOferta);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return cerereOferta;
	}
	
	public void stergeCerereOferta(CerereOferta cerereOferta){
		entityManager.remove(cerereOferta);
	}

	public LiniiCerereOferta salveazaLinieCerereOferta(LiniiCerereOferta linieCerereOferta) throws Exception{
		logger.debug("--De salvat linia cererii de oferta cu ID: " + linieCerereOferta.getNrLinie());
		try{
			/* Proiectul plimbandu-se de la client-la server-inapoi la client-iarasi la server
			 * nu este adus inca in/atasat de cache
			 * */
			//if (!entityManager.contains(activitate.getProiect()))
			entityManager.merge(linieCerereOferta.getCerereOferta());
			
			//if (!entityManager.contains(proiect))
			if (linieCerereOferta.getNrLinie() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(linieCerereOferta.getClass(), linieCerereOferta.getNrLinie()) == null)
				entityManager.persist(linieCerereOferta);
			else
				entityManager.merge(linieCerereOferta);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return linieCerereOferta;
	}	
	
	public void refreshCerereOferta(CerereOferta cerereOferta){
		entityManager.refresh(cerereOferta);
	}
	
	//Comanda
	public Comanda salveazaComanda(Comanda comanda) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (comanda.getNrComanda() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(comanda.getClass(), comanda.getNrComanda()) == null)
				entityManager.persist(comanda);
			else
				entityManager.merge(comanda);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return comanda;
	}
	
	public void stergeComanda(Comanda comanda){
		entityManager.remove(comanda);
	}

	public LiniiComanda salveazaLinieComanda(LiniiComanda linieComanda) throws Exception{
		logger.debug("--De salvat linia comenzii cu ID: " + linieComanda.getNrLinie());
		try{
			/* Proiectul plimbandu-se de la client-la server-inapoi la client-iarasi la server
			 * nu este adus inca in/atasat de cache
			 * */
			//if (!entityManager.contains(activitate.getProiect()))
			entityManager.merge(linieComanda.getComanda());
			
			//if (!entityManager.contains(proiect))
			if (linieComanda.getNrLinie() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(linieComanda.getClass(), linieComanda.getNrLinie()) == null)
				entityManager.persist(linieComanda);
			else
				entityManager.merge(linieComanda);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return linieComanda;
	}	
	
	public void refreshComanda(Comanda comanda){
		entityManager.refresh(comanda);
	}
	
	//Oferta
	public Oferta salveazaOferta(Oferta oferta) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (oferta.getNrOferta() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(oferta.getClass(), oferta.getNrOferta()) == null)
				entityManager.persist(oferta);
			else
				entityManager.merge(oferta);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return oferta;
	}
	
	public void stergeOferta(Oferta oferta){
		entityManager.remove(oferta);
	}

	public LiniiOferta salveazaLinieOferta(LiniiOferta linieOferta) throws Exception{
		logger.debug("--De salvat linia ofertei cu ID: " + linieOferta.getNrLinie());
		try{
			/* Proiectul plimbandu-se de la client-la server-inapoi la client-iarasi la server
			 * nu este adus inca in/atasat de cache
			 * */
			//if (!entityManager.contains(activitate.getProiect()))
			entityManager.merge(linieOferta.getOferta());
			
			//if (!entityManager.contains(proiect))
			if (linieOferta.getNrLinie() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(linieOferta.getClass(), linieOferta.getNrLinie()) == null)
				entityManager.persist(linieOferta);
			else
				entityManager.merge(linieOferta);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return linieOferta;
	}	
	
	public void refreshOferta(Oferta oferta){
		entityManager.refresh(oferta);
	}
	
	//NIR
	public NIR salveazaNIR(NIR nir) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (nir.getNrNIR() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(nir.getClass(), nir.getNrNIR()) == null)
				entityManager.persist(nir);
			else
				entityManager.merge(nir);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return nir;
	}
	
	public void stergeNIR(NIR nir){
		entityManager.remove(nir);
	}

	public LiniiNIR salveazaLinieNIR(LiniiNIR linieNIR) throws Exception{
		logger.debug("--De salvat linia nir-ului cu ID: " + linieNIR.getNrLInie());
		try{
			/* Proiectul plimbandu-se de la client-la server-inapoi la client-iarasi la server
			 * nu este adus inca in/atasat de cache
			 * */
			//if (!entityManager.contains(activitate.getProiect()))
			entityManager.merge(linieNIR.getNir());
			
			//if (!entityManager.contains(proiect))
			if (linieNIR.getNrLInie() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(linieNIR.getClass(), linieNIR.getNrLInie()) == null)
				entityManager.persist(linieNIR);
			else
				entityManager.merge(linieNIR);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return linieNIR;
	}	
	
	public void refreshNIR(NIR nir){
		entityManager.refresh(nir);
	}
	
	//Factura
	public Factura salveazaFactura(Factura factura) throws Exception{
		try{
			
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (factura.getNrFactura() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(factura.getClass(), factura.getNrFactura()) == null)
				entityManager.persist(factura);
			else
				entityManager.merge(factura);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return factura;
	}
	
	public void stergeFactura(Factura factura){
		entityManager.remove(factura);
	}

	public LiniiFactura salveazaLinieFactura(LiniiFactura linieFactura) throws Exception{
		logger.debug("--De salvat linia facturii cu ID: " + linieFactura.getNrLinie());
		try{
			/* Proiectul plimbandu-se de la client-la server-inapoi la client-iarasi la server
			 * nu este adus inca in/atasat de cache
			 * */
			//if (!entityManager.contains(activitate.getProiect()))
			entityManager.merge(linieFactura.getFactura());
			
			//if (!entityManager.contains(proiect))
			if (linieFactura.getNrLinie() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(linieFactura.getClass(), linieFactura.getNrLinie()) == null)
				entityManager.persist(linieFactura);
			else
				entityManager.merge(linieFactura);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return linieFactura;
	}	
	
	public void refreshFactura(Factura factura){
		entityManager.refresh(factura);
	}
	
}

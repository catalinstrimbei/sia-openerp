package org.open.erp.services.salarizare.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.salarizare.CentralizatorStatSalarii;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.Retinere;
import org.open.erp.services.salarizare.Spor;
import org.open.erp.services.salarizare.StatSalarii;
import org.open.erp.services.salarizare.teste.TestSalarizareImpl;

public class RegistruSalarizare {

	//private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestSalarizareImpl.class.getName());	
	private EntityManager entityManager ;
	
	private static SalarizareLogger logger =  new SalarizareLogger();
	
	public RegistruSalarizare(EntityManager em) {
		entityManager = em;
	}
	public RegistruSalarizare() {
	}
	
	public List<Pontaj> getPontajAnLuna(Integer an, Integer luna) throws Exception{
		List<Pontaj> pontaje = new ArrayList<Pontaj>();
		try{
		pontaje = entityManager.createQuery("SELECT p FROM Pontaj p " +
				"WHERE p.an=:an AND p.luna=:luna")
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getResultList();
		}
		catch(Exception ex){
			logger.logINFO("Eroare incarcare pontajAn Luna:");
			return null;
		}
		/*
		p.setAngajat(angajat);
		p.setAn(an);
		p.setLuna(luna);
		p.setOreLucrate(168.0);
		p.setOreSuplimentare(12.0);
		p.setOreConcediu(24.0);
		*/
		return pontaje;
	}

	public Pontaj getPontajByAngajat(Angajat angajat, Integer an, Integer luna) throws Exception{
		Pontaj p = new Pontaj();
		logger.logINFO("#### S-a incarcat pontajul pt angajatul cu id-ul:"+angajat.getId());
		try{
		p = (Pontaj)entityManager.createQuery("SELECT p FROM Pontaj p " +
				"WHERE p.angajat.id=:id AND p.an=:an AND p.luna=:luna AND rownum<=1")
				.setParameter("id", angajat.getId())
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getSingleResult();
		}
		catch(Exception ex){
			logger.logINFO("Eroare incarcare pontaj pt angajatul cu id-ul:"+angajat.getId());
			return null;
		}
		/*
		p.setAngajat(angajat);
		p.setAn(an);
		p.setLuna(luna);
		p.setOreLucrate(168.0);
		p.setOreSuplimentare(12.0);
		p.setOreConcediu(24.0);
		*/
		return p;
	}

	public List<Spor> getSporuriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception{
		List<Spor> sporuri= new ArrayList<Spor>();
		//aici apelam ceva din DB care incarca sporurile
		//sporuri.add(new Spor("Bonus", 1, 2011, 11, angajat, 1, 100.0));
		
		//sporuri.add(new Spor("Bonus procent", 2, 2011, 11, angajat, 2, 5.0));
		try{
		sporuri = entityManager.createQuery("SELECT s FROM Spor s " +
				"WHERE s.angajat.id=:id AND s.an=:an AND s.luna=:luna")
				.setParameter("id", angajat.getId())
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getResultList();
		}
		catch(Exception ex){
			logger.logINFO("Eroare incarcare sporuri :");
			return null;
		}
		return sporuri;
	}

	public List<Retinere> getRetineriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception{
		List<Retinere> retineri= new ArrayList<Retinere>();
		//aici apelam ceva din DB care incarca sporurile
		//retineri.add(new Retinere("Pensie alimentara", 1, angajat, 2011, 11, 1, 100.0));
		//retineri.add(new Retinere("CAR", 2, angajat, 2011, 11, 2, 5.0));
		try{
		retineri = entityManager.createQuery("SELECT r FROM Retinere r " +
				"WHERE r.angajat.id=:id AND r.an=:an AND r.luna=:luna")
				.setParameter("id", angajat.getId())
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getResultList();
		}
		catch(Exception ex){
			logger.logINFO("Eroare incarcare retineri Luna:");
			return null;
		}
		return retineri;
	}
	
	public List<StatSalarii> getStatAnLuna(Integer an, Integer luna) throws Exception{
		List<StatSalarii> stat = new ArrayList<StatSalarii>();
		try{
			logger.logINFO("Incarcare stat salarii Luna:" + luna + an);
		stat = entityManager.createQuery("SELECT s FROM StatSalarii s, Pontaj p WHERE s.pontaj.idPontaj = p.idPontaj AND p.an = :an AND p.luna = :luna" )
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getResultList();
		}
		catch(Exception ex){
			logger.logINFO("Eroare incarcare stat salarii Luna:");
			return null;
		}
		/*
		p.setAngajat(angajat);
		p.setAn(an);
		p.setLuna(luna);
		p.setOreLucrate(168.0);
		p.setOreSuplimentare(12.0);
		p.setOreConcediu(24.0);
		*/
		return stat;
	}
	
	public CentralizatorStatSalarii getCentralizatorStatSalarii(Integer an, Integer luna) throws Exception{
		CentralizatorStatSalarii centralizator = new CentralizatorStatSalarii();
		try{
		centralizator = (CentralizatorStatSalarii)entityManager.createQuery("SELECT c FROM CentralizatorStatSalarii c " +
				"WHERE c.An=:an AND c.Luna=:luna AND rownum<=1")
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getSingleResult();
		}
		catch(Exception ex){
			logger.logINFO("Eroare incarcare centralizator Luna:");
			return null;
		}
		return centralizator;
	}


	
	/* persistenta */
	public Pontaj salveazaPontaj(Pontaj pontaj) throws Exception{
		try{
			logger.logINFO("<<<<<<OBIECT PONTAJ"+pontaj);
			logger.logINFO("<<<<<<OBIECT PONTAJ CLASS"+pontaj.getClass());
			logger.logINFO("<<<<<<OBIECT PONTAJ CU ID"+pontaj.getIdPontaj());
			if (pontaj.getIdPontaj() == null 
				||	
					//!entityManager.contains(pontaj)
				entityManager.find(pontaj.getClass(), pontaj.getIdPontaj()) == null
				)
			{
				logger.logINFO("Inainte de persist angajat id ***** " + pontaj.getAngajat().getId() + " si idPontaj: " + pontaj.getIdPontaj());
				entityManager.persist(pontaj);
				logger.logINFO("Dupa persist ******** ");
			}
			else
				logger.logINFO("Am facut merge ******** ");
				entityManager.merge(pontaj);
			
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			
			ex.printStackTrace();
			throw ex;
		}
		return pontaj;
	}
	
	public void stergePontaj(Pontaj pontaj){
		pontaj = entityManager.find(pontaj.getClass(), pontaj.getIdPontaj());
		logger.logINFO("Se sterge pontaj cu id-ul:" + pontaj.getIdPontaj());
		if(pontaj!=null)
		entityManager.remove(pontaj);
	}
	
	public Spor salveazaSpor(Spor spor) throws Exception{
		try{
			logger.logINFO("salvam SPORUL cu id-ul: ***** " + spor.getIdSpor());
			if (spor.getIdSpor() == null 
					//|| 
				//entityManager.find(spor.getClass(), spor.getIdSpor()) == null ||
				//!entityManager.contains(spor) 
				)
			{
				entityManager.persist(spor);
			}
			else
				entityManager.merge(spor);
			
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return spor;
	}
	
	public void stergeSpor(Spor spor){
		spor = entityManager.find(spor.getClass(), spor.getIdSpor());
		logger.logINFO("Se sterge sporul cu id-ul:" + spor.getIdSpor());
		if(spor!=null)
		entityManager.remove(spor);
	}
	
	public Retinere salveazaRetinere(Retinere retinere) throws Exception{
		try{
			if (retinere.getIdRetinere() == null || 
				entityManager.find(retinere.getClass(), retinere.getIdRetinere()) == null)
				entityManager.persist(retinere);
			else
				entityManager.merge(retinere);
			
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return retinere;
	}
	
	public void stergeRetinere(Retinere retinere){
		retinere = entityManager.find(retinere.getClass(), retinere.getIdRetinere());
		if(retinere!=null)
		entityManager.remove(retinere);
	}
	
	public StatSalarii salveazaStatSalarii(StatSalarii statSalarii) throws Exception{
		try{
			if (statSalarii.getIdStatSalarii() == null || 
				entityManager.find(statSalarii.getClass(), statSalarii.getIdStatSalarii()) == null)
				entityManager.persist(statSalarii);
			else
				entityManager.merge(statSalarii);
			
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return statSalarii;
	}
	
	public void stergeStatSalarii(StatSalarii statSalarii){
		entityManager.remove(statSalarii);
	}
	
	public CentralizatorStatSalarii salveazaCentralizator(CentralizatorStatSalarii centralizator) throws Exception{
		try{
			if (centralizator.getIdCentralizator() == null || 
				entityManager.find(centralizator.getClass(), centralizator.getIdCentralizator()) == null)
				entityManager.persist(centralizator);
			else
				entityManager.merge(centralizator);
			
		}catch(Exception ex){
			logger.logINFO("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return centralizator;
	}
	
	public void stergeCentralizator(CentralizatorStatSalarii centralizator){
		centralizator = entityManager.find(centralizator.getClass(), centralizator.getIdCentralizator());
		if(centralizator!=null)
		entityManager.remove(centralizator);
	}


	public List<Spor> getSporuriGenerale() throws Exception{
		List<Spor> sporuri= new ArrayList<Spor>();

		try{
		sporuri = entityManager.createQuery("SELECT s FROM Spor s " +
				"WHERE s.angajat.id is null ")
				//.setParameter("id", null)
				.getResultList();
		}
		catch(Exception ex){
			logger.logINFO("Eroare incarcare sporuri generale:");
			return null;
		}
		return sporuri;
	}

	/*
	public ContractMunca getContractActivAngajat(Angajat a){
		ContractMunca contract = new ContractMunca();
		contract.setAngajat(a);
		contract.setSalarBaza(100.0);
		contract.setTarifOrar(10.0);
		return contract;
	}
	*/
}

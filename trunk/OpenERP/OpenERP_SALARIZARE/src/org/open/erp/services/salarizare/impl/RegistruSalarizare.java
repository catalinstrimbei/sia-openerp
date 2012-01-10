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

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestSalarizareImpl.class.getName());	private EntityManager entityManager;
	public RegistruSalarizare(EntityManager em) {
		entityManager = em;
	}
	public RegistruSalarizare() {
	}
	
	public List<Pontaj> getPontajAnLuna(Integer an, Integer luna) {
		List<Pontaj> pontaje = new ArrayList<Pontaj>();
		
		pontaje = entityManager.createQuery("SELECT p FROM Pontaj p " +
				"WHERE p.an=:an AND p.luna=:luna")
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getResultList();
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

	public Pontaj getPontajByAngajat(Angajat angajat, Integer an, Integer luna) {
		Pontaj p;
		p = (Pontaj)entityManager.createQuery("SELECT p FROM Pontaj p " +
				"WHERE p.angajat.id=:id AND p.an=:an AND p.luna=:luna AND rownum<=1")
				.setParameter("id", angajat.getId())
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getSingleResult();
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

	public List<Spor> getSporuriAngajat(Integer an, Integer luna, Angajat angajat){
		List<Spor> sporuri= new ArrayList<Spor>();
		//aici apelam ceva din DB care incarca sporurile
		//sporuri.add(new Spor("Bonus", 1, 2011, 11, angajat, 1, 100.0));
		
		//sporuri.add(new Spor("Bonus procent", 2, 2011, 11, angajat, 2, 5.0));
		sporuri = entityManager.createQuery("SELECT s FROM Spor s " +
				"WHERE s.angajat.id=:id AND s.an=:an AND s.luna=:luna")
				.setParameter("id", angajat.getId())
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getResultList();
		
		return sporuri;
	}

	public List<Retinere> getRetineriAngajat(Integer an, Integer luna, Angajat angajat){
		List<Retinere> retineri= new ArrayList<Retinere>();
		//aici apelam ceva din DB care incarca sporurile
		//retineri.add(new Retinere("Pensie alimentara", 1, angajat, 2011, 11, 1, 100.0));
		//retineri.add(new Retinere("CAR", 2, angajat, 2011, 11, 2, 5.0));
		retineri = entityManager.createQuery("SELECT r FROM Retinere r " +
				"WHERE r.angajat.id=:id AND r.an=:an AND r.luna=:luna")
				.setParameter("id", angajat.getId())
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getResultList();
		return retineri;
	}
	
	public List<StatSalarii> getStatAnLuna(Integer an, Integer luna) {
		List<StatSalarii> stat = new ArrayList<StatSalarii>();
		
		stat = entityManager.createQuery("SELECT s FROM StatSalarii s, Pontaj p WHERE s.pontaj.idPontaj = p.idPontaj AND p.an = :an AND p.luna = :luna" )
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getResultList();
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
	
	/* persistenta */
	public Pontaj salveazaPontaj(Pontaj pontaj) throws Exception{
		try{
			if (pontaj.getIdPontaj() == null || 
				entityManager.find(pontaj.getClass(), pontaj.getIdPontaj()) == null)
			{
				logger.info("Inainte de persist ***** " + pontaj.getAngajat().getId());
				entityManager.persist(pontaj);
				logger.info("Dupa persist ******** ");
			}
			else
				entityManager.merge(pontaj);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return pontaj;
	}
	
	public void stergePontaj(Pontaj pontaj){
		entityManager.remove(pontaj);
	}
	
	public Spor salveazaSpor(Spor spor) throws Exception{
		try{
			if (spor.getIdSpor() == null || 
				entityManager.find(spor.getClass(), spor.getIdSpor()) == null)
			{
				entityManager.persist(spor);
			}
			else
				entityManager.merge(spor);
			
		}catch(Exception ex){
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return spor;
	}
	
	public void stergeSpor(Spor spor){
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
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return retinere;
	}
	
	public void stergeRetinere(Retinere retinere){
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
			logger.info("EROARE PERSISTENTA ***** ");
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
			logger.info("EROARE PERSISTENTA ***** ");
			ex.printStackTrace();
			throw ex;
		}
		return centralizator;
	}
	
	public void stergeCentralizator(CentralizatorStatSalarii centralizator){
		entityManager.remove(centralizator);
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

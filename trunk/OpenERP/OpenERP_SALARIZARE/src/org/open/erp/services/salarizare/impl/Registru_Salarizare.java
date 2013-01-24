package org.open.erp.services.salarizare.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.salarizare.Centralizare_Stat_Plata;
import org.open.erp.services.salarizare.Pontaje;
import org.open.erp.services.salarizare.Retineri;
import org.open.erp.services.salarizare.Sporuri;
import org.open.erp.services.salarizare.Stat_Salarii;
import org.open.erp.services.salarizare.teste.Salarizare_Impl_Test;

public class Registru_Salarizare {

	
	//private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestSalarizareImpl.class.getName());	
		private EntityManager entityManager ;
		
		private static Logger_Salarizare logger =  new Logger_Salarizare();
		
		public Registru_Salarizare(EntityManager em) {
			entityManager = em;
		}
		public Registru_Salarizare() {
		}
		
		public List<Pontaje> getPontajAnLuna(Integer an, Integer luna) throws Exception{
			List<Pontaje> pontaje = new ArrayList<Pontaje>();
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

		public List<Pontaje> getPontajAngajatAll(Angajat angajat) throws Exception{
			List<Pontaje> pontaje = new ArrayList<Pontaje>();
			try{
			pontaje = entityManager.createQuery("SELECT p FROM Pontaj p " +
					"WHERE p.angajat.id=:id")
					.setParameter("id", angajat.getId())
					.getResultList();
			}
			catch(Exception ex){
				logger.logINFO("Eroare incarcare pontajAn gajatAll");
				return null;
			}
			return pontaje;
		}

		public Pontaje getPontajByAngajat(Angajat angajat, Integer an, Integer luna) throws Exception{
			Pontaje p = new Pontaje();
			logger.logINFO("#### S-a incarcat pontajul pt angajatul cu id-ul:"+angajat.getId());
			try{
			p = (Pontaje)entityManager.createQuery("SELECT p FROM Pontaj p " +
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

		public List<Sporuri> getSporuriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception{
			List<Sporuri> sporuri= new ArrayList<Sporuri>();
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

		public List<Retineri> getRetineriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception{
			List<Retineri> retineri= new ArrayList<Retineri>();
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
		
		public List<Stat_Salarii> getStatAnLuna(Integer an, Integer luna) throws Exception{
			List<Stat_Salarii> stat = new ArrayList<Stat_Salarii>();
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
		
		public Centralizare_Stat_Plata getCentralizatorStatSalarii(Integer an, Integer luna) throws Exception{
			Centralizare_Stat_Plata centralizator = new Centralizare_Stat_Plata();
			try{
			centralizator = (Centralizare_Stat_Plata)entityManager.createQuery("SELECT c FROM Centralizare_Stat_Plata c " +
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
		public Pontaje salveazaPontaj(Pontaje pontaj) throws Exception{
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
		
		public void stergePontaj(Pontaje pontaj){
			pontaj = entityManager.find(pontaj.getClass(), pontaj.getIdPontaj());
			logger.logINFO("Se sterge pontaj cu id-ul:" + pontaj.getIdPontaj());
			if(pontaj!=null)
			entityManager.remove(pontaj);
		}
		
		public Sporuri salveazaSpor(Sporuri spor) throws Exception{
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
		
		public void stergeSpor(Sporuri spor){
			spor = entityManager.find(spor.getClass(), spor.getIdSpor());
			logger.logINFO("Se sterge sporul cu id-ul:" + spor.getIdSpor());
			if(spor!=null)
			entityManager.remove(spor);
		}
		
		public Retineri salveazaRetinere(Retineri retinere) throws Exception{
			try{
				if (retinere.getIdRetinere() == null 
						//|| 
					//entityManager.find(retinere.getClass(), retinere.getIdRetinere()) == null
					)
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
		
		public void stergeRetinere(Retineri retinere){
			retinere = entityManager.find(retinere.getClass(), retinere.getIdRetinere());
			if(retinere!=null)
			entityManager.remove(retinere);
		}
		
		public Stat_Salarii salveazaStatSalarii(Stat_Salarii statSalarii) throws Exception{
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
		/*
		public void stergeStatSalarii(StatSalarii statSalarii){
			entityManager.remove(statSalarii);
		}
		*/
		public Centralizare_Stat_Plata salveazaCentralizator(Centralizare_Stat_Plata centralizator) throws Exception{
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
		
		public void stergeCentralizator(Centralizare_Stat_Plata centralizator){
			centralizator = entityManager.find(centralizator.getClass(), centralizator.getIdCentralizator());
			if(centralizator!=null)
			entityManager.remove(centralizator);
		}

		public void stergeStatSalarii(Stat_Salarii statSalarii){
			statSalarii = entityManager.find(statSalarii.getClass(), statSalarii.getIdStatSalarii());
			if(statSalarii!=null)
			entityManager.remove(statSalarii);
		}

		public List<Sporuri> getSporuriGenerale() throws Exception{
			List<Sporuri> sporuri= new ArrayList<Sporuri>();

			try{
			sporuri = entityManager.createQuery("SELECT s FROM Sporuri s " 
			//+"WHERE s.angajat.id is null "
					)
					//.setParameter("id", null)
					.getResultList();
			}
			catch(Exception ex){
				logger.logINFO("Eroare incarcare sporuri generale:");
				return null;
			}
			return sporuri;
		}

		public List<Retineri> getRetineriGenerale() throws Exception{
			List<Retineri> retineri= new ArrayList<Retineri>();

			try{
			retineri = entityManager.createQuery("SELECT s FROM Retineri s " 
			//+"WHERE s.angajat.id is null "
					)
					//.setParameter("id", null)
					.getResultList();
			}
			catch(Exception ex){
				logger.logINFO("Eroare incarcare retineri generale:");
				return null;
			}
			return retineri;
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
	/*	
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
			return centralizator;
		}
		*/
	
	
	
}

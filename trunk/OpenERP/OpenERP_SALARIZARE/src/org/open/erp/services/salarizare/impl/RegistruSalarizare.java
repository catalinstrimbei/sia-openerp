package org.open.erp.services.salarizare.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.Retinere;
import org.open.erp.services.salarizare.Spor;

public class RegistruSalarizare {

	private EntityManager entityManager;
	public RegistruSalarizare(EntityManager em) {
		entityManager = em;
	}
	public RegistruSalarizare() {
	}
	
	public Pontaj getPontajByAngajat(Angajat angajat, Integer an, Integer luna) {
		Pontaj p;
		p = (Pontaj)entityManager.createQuery("SELECT p FROM Pontaj p " +
				"WHERE p.angajat.marca=:marca AND p.an=:an AND p.luna=:luna")
				.setParameter("marca", angajat.getMarca())
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
				"WHERE s.angajat.marca=:marca AND s.an=:an AND s.luna=:luna")
				.setParameter("marca", angajat.getMarca())
				.setParameter("an", an)
				.setParameter("luna", luna)
				.getResultList();
		
		return sporuri;
	}

	public ArrayList<Retinere> getRetineriAngajat(Integer an, Integer luna, Angajat angajat){
		ArrayList<Retinere> retineri= new ArrayList<Retinere>();
		//aici apelam ceva din DB care incarca sporurile
		retineri.add(new Retinere("Pensie alimentara", 1, angajat, 2011, 11, 1, 100.0));
		retineri.add(new Retinere("CAR", 2, angajat, 2011, 11, 2, 5.0));
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
}

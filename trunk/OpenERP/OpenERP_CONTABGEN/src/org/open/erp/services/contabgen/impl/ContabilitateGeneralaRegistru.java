package org.open.erp.services.contabgen.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.open.erp.services.contabgen.conturi.Clasa;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.conturi.PlanConturi;

public class ContabilitateGeneralaRegistru {
	private static Logger logger = Logger.getLogger(ContabilitateGeneralaRegistru.class.getName());	
	
	private EntityManager entityManager;
	public ContabilitateGeneralaRegistru(EntityManager em) {
		entityManager = em;
	}
	
	public Clasa getClasaDeConturi(Integer id){
		return entityManager.find(Clasa.class, id);
	}
	
	public Cont getContDinClasaDeConturi(Integer id){
		return entityManager.find(Cont.class, id);
	}
	
	public <T> T getContDinClasaDeConturi(Class<T> meta, Integer id){
		return entityManager.find(meta, id);
	}
	
	public List<Cont> getConturiDinClaseleDeConturi(){
		return entityManager.createQuery("SELECT c FROM Cont c").getResultList();
	}
	
	public PlanConturi getPlanConturiConturi(){
		List<PlanConturi> planuri = entityManager.createQuery("SELECT pc FROM PlanConturi pc").getResultList();
		return (planuri != null) ? planuri.get(0):null;
	}
}
package org.open.erp.services.contabgen.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.open.erp.services.contabgen.conturi.Clasa;
import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.conturi.PlanConturi;
import org.open.erp.services.contabgen.tranzactii.InregistrareOperatiuneContabila;

public class ContabilitateGeneralaRegistru implements Serializable{
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
	
	public InregistrareOperatiuneContabila getOperatiuneContabila(Integer id){
		return entityManager.find(InregistrareOperatiuneContabila.class, id);
	}
	
	public <T> T getContDinClasaDeConturi(Class<T> meta, Integer id){
		return entityManager.find(meta, id);
	}
	
	public List<Cont> getConturiDinClaseleDeConturi(){
		return entityManager.createQuery("SELECT c FROM Cont c").getResultList();
	}
	
	public List<Clasa> getClaseleDeConturi(){
		return entityManager.createQuery("SELECT c FROM Clasa c left join fetch c.conturi").getResultList();
	}
	
	public List<InregistrareOperatiuneContabila> getInregistrariOperatiuneContabila(){
		return entityManager.createQuery("SELECT c FROM InregistrareOperatiuneContabila c").getResultList();
	}
	
	public PlanConturi getPlanConturiConturi(){
		List<PlanConturi> planuri = entityManager.createQuery("SELECT pc FROM PlanConturi pc").getResultList();
		if (planuri != null && planuri.size()>0)
			return planuri.get(0);
		else
			return null;
	}
}
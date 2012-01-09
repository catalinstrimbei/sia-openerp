package org.open.erp.services.ctbgen;


import java.util.List;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegConturi extends Registru{
	
	private static RegConturi singleReference;

	private RegConturi() {
		sqlDefaultText = "SELECT o FROM Cont o";
	}

	public static RegConturi instantiaza() {
		if (singleReference == null)
			singleReference = new RegConturi();
		return singleReference;
	}

	private List<Cont> planConturi;

	public List<Cont> getPlanConturi() {
		/*
		TODO: dar exista si javax.persistence.TypedQuery
		
		TypedQuery<Cont> query = em.createQuery(sqlDefaultText, Cont.class);
		List<Cont> results = query.getResultList();

		dar mie imi arata cu rosu importul ..de cand am instalat cele din tutoriale
		 */
		
		@SuppressWarnings("unchecked")
		List<Cont> result = em.createQuery(this.sqlDefaultText).getResultList();
		return result;
	}

	void setPlanConturi(List<Cont> planConturi) {//TODO: le adaug adica sterg to si adaug + nu cred ca mai ai nevoie
		for(int i=0;i<planConturi.size();i++){
			addCont(planConturi.get(i)); //aici e syncronise
		}
	}
	
	//private static int contorId = 1;
	
	public void addCont(Cont cont) {
		if (em.contains(cont))
			em.merge(cont);
		else
			em.persist(cont);
	
		synchronize();
	}

	void removeSablon(Cont cont) { //TODO: de ce se cheama asa? lucreaza cu conturi
		em.remove(cont);
		
		synchronize();
	}

	public Cont getContDupaId(Integer idCont) {
		List<Cont> planConturi = this.getPlanConturi();
		for (Cont c : planConturi) {
			if (idCont == c.getIdCont()) {
				return c;
			}
		}
		return null;
	}
	
	//TODO: remove me
	public void printAll(){
		for(int i=0;i<planConturi.size();i++){
			System.out.println(planConturi.get(i).getSimbolCont().toString());
		}
	}
}

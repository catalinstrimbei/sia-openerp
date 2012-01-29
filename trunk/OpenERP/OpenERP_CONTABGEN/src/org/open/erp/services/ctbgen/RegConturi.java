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
		sqlDefaultText = "SELECT o FROM Cont o ";
	}


	public static RegConturi instantiaza() {
		if (singleReference == null)
			singleReference = new RegConturi();
		return singleReference;
	}

	
	public List<Cont> getPlanConturi() {
			
		@SuppressWarnings("unchecked")
		List<Cont> result = em.createQuery(this.sqlDefaultText).getResultList();
		return result;
	}

	void setPlanConturi(List<Cont> planConturi) {//TODO: le adaug adica sterg to si adaug + nu cred ca mai ai nevoie
		for(int i=0;i<planConturi.size();i++){
			try {
				addCont(planConturi.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //aici e syncronise
		}
	}
	
	

	
	public Cont addCont(Cont cont)  {
		try{
			if (cont.getIdCont() == null || 
				em.find(cont.getClass(), cont.getIdCont()) == null)
			{
				em.persist(cont);
				//System.out.println("add "+cont.getSimbolCont());
			}
			else{
				em.merge(cont);
				//System.out.println("merge "+cont.getSimbolCont());
				}
			
		}catch(Exception ex){
			System.out.println("EROARE PERSISTENTA *****add cont "+ ex.getMessage());
			//ex.printStackTrace();
		
		}
	
	return cont;
}

	void removeCont(Cont cont) {
		em.remove(cont);
		
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
	
	public Cont getContDupaSimbol(String simbol) {
		List<Cont> planConturi = this.getPlanConturi();
		for (Cont c : planConturi) {
			if (simbol.equals(c.getSimbolCont())) {
				return c;
			}
		}
		return null;
	}
	
	//TODO: remove me
	public void printAll(){
		List<Cont> planConturi = this.getPlanConturi();
		for(int i=0;i<planConturi.size();i++){
			System.out.println(planConturi.get(i).getSimbolCont().toString());
		}
	}
}

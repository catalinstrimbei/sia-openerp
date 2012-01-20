package org.open.erp.services.ctbgen;

import java.util.List;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegSablonNC extends Registru{
	private static RegSablonNC singleReference;

	private RegSablonNC() {
		sqlDefaultText = "SELECT o FROM SablonNC o";
	}

	public static RegSablonNC instantiaza() {
		if (singleReference == null)
			singleReference = new RegSablonNC();
		return singleReference;
	}
	
	public List<SablonNC> getSabloane() { 
		@SuppressWarnings("unchecked")
		List<SablonNC> result = em.createQuery(this.sqlDefaultText).getResultList();
		return result;
	}
	

	public SablonNC getSablonDupaNr(Integer nrSab) {
		List<SablonNC>listaSabloane=getSabloane();
		
		for (SablonNC s : listaSabloane) {
			if (nrSab.equals(s.getNrSablon())) {
				return s;
			}
		}
		return null;
	}

	public SablonNC getSablonConsum(Integer nr, Cont contMat) {
		List<SablonNC>listaSabloane=getSabloane();
		
		for (SablonNC s : listaSabloane) {
			if (nr.equals(s.getNrSablon()) && contMat.equals(s.getContCredit())) {
				return s;
			}
		}
		return null;
	}
	
	public SablonNC getSablonAchizitie(Integer nr, Cont contMat) {
		List<SablonNC>listaSabloane=getSabloane();
		
		for (SablonNC s : listaSabloane) {
			if (nr.equals(s.getNrSablon()) && contMat.equals(s.getContDebit())) {
				return s;
			}
		}
		return null;
	}
	
	public SablonNC getSablonIncasare(Integer nr) {
		List<SablonNC>listaSabloane=getSabloane();
		
		for (SablonNC s : listaSabloane) {
			if (nr.equals(s.getNrSablon())) {
				return s;
			}
		}
		return null;
	}


	
	public SablonNC addSablon(SablonNC sabl) {
		try{
			if (sabl.getIdSablon() == null || 
				em.find(sabl.getClass(), sabl.getIdSablon()) == null)
			{
				em.persist(sabl);
				//System.out.println("add "+sabl.getNrSablon());
			}
			else{
				em.merge(sabl);
				//System.out.println("merge "+sabl.getNrSablon());
				}
			
		}catch(Exception ex){
			System.out.println("EROARE PERSISTENTA *****add cont "+ ex.getMessage());
			//ex.printStackTrace();
			
		}
	
	return sabl;
}

	public void removeSablon(SablonNC sabl) {
		em.remove(sabl);
		

	}

	// TODO: remove me
	public void printAll() {
		List<SablonNC>listaSabloane=getSabloane();
		for (int i = 0; i < listaSabloane.size(); i++) {
			System.out.println(listaSabloane.get(i).toString());
		}
	}
}

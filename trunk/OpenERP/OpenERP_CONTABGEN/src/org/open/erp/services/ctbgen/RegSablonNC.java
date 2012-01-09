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
		sqlDefaultText = "SELECT o FROM Cont o";
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

	public void addSablon(SablonNC sabl) {
		if (em.contains(sabl))
			em.merge(sabl);
		else
			em.persist(sabl);
	
		synchronize();
	}

	public void removeSablon(SablonNC sabl) {
		em.remove(sabl);
		
		synchronize();
	}

	// TODO: remove me
	public void printAll() {
		List<SablonNC>listaSabloane=getSabloane();
		for (int i = 0; i < listaSabloane.size(); i++) {
			System.out.println(listaSabloane.get(i).toString());
		}
	}
}

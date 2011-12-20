package org.open.erp.services.ctbgen;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegSablonNC {
	private static RegSablonNC singleReference;

	private RegSablonNC() {
		listaSabloane = new ArrayList<SablonNC>();
	}

	public static RegSablonNC instantiaza() {
		if (singleReference == null)
			singleReference = new RegSablonNC();
		return singleReference;
	}
	
	private List<SablonNC> listaSabloane;

	public SablonNC getSablonDupaNr(Integer nrSab) {
		for (SablonNC s : this.listaSabloane) {
			if (nrSab.equals(s.getNrSablon())) {
				return s;
			}
		}
		return null;
	}

	public SablonNC getSablonConsum(Integer nr, Cont contMat) {
		for (SablonNC s : this.listaSabloane) {
			if (nr.equals(s.getNrSablon()) && contMat.equals(s.getContCredit())) {
				return s;
			}
		}
		return null;
	}
	
	public SablonNC getSablonAchizitie(Integer nr, Cont contMat) {
		for (SablonNC s : this.listaSabloane) {
			if (nr.equals(s.getNrSablon()) && contMat.equals(s.getContDebit())) {
				return s;
			}
		}
		return null;
	}
	
	public SablonNC getSablonIncasare(Integer nr) {
		for (SablonNC s : this.listaSabloane) {
			if (nr.equals(s.getNrSablon())) {
				return s;
			}
		}
		return null;
	}

	private static int contorId = 1;
	public void addSablon(SablonNC sabl) {
		if(sabl.getIdSablon()==-1){
			sabl.setIdSablon(contorId);
			contorId++;
		}
		if (!listaSabloane.contains(sabl)) {
			listaSabloane.add(sabl);
		}
	}

	public void removeSablon(SablonNC sabl) {
		listaSabloane.remove(sabl);
	}

	// TODO: remove me
	public void printAll() {
		for (int i = 0; i < listaSabloane.size(); i++) {
			System.out.println(listaSabloane.get(i).toString());
		}
	}
}

package org.open.erp.services.productie;

import org.open.erp.services.personal.Functie;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */

public class FunctieNecesara extends Functie{

	Integer nrAngajatiFunctie;

	public FunctieNecesara(Integer id, String denumire) {
		super(id, denumire);
	}

	public FunctieNecesara(Integer id, String denumire,
			Integer nrAngajatiFunctie) {
		super(id, denumire);
		this.nrAngajatiFunctie = nrAngajatiFunctie;
	}

	public FunctieNecesara(){
		super();
	}

	public Integer getNrAngajatiFunctie() {
		return nrAngajatiFunctie;
	}

	public void setNrAngajatiFunctie(Integer nrAngajatiFunctie) {
		this.nrAngajatiFunctie = nrAngajatiFunctie;
	}
	
		
}

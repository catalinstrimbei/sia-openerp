package org.open.erp.services.conturi;

import java.util.ArrayList;
import java.util.List;

public class Clasa {

	private List<Cont> conturi = new ArrayList<Cont>();

	public List<Cont> getConturi() {
		return conturi;
	}

	public void addCont( Cont cont) {
		this.conturi.add(cont);
	}
	
	public void removeCont( Cont cont ){
		this.conturi.remove(cont);
	}
}

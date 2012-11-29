package org.open.erp.services.rapoarte;

import java.util.List;

import org.open.erp.services.conturi.Cont;
import org.open.erp.services.conturi.ContActiv;
import org.open.erp.services.conturi.ContPasiv;

public class BilantContabil extends Raport {
	
	private List<Cont> conturi;
	private int totalActiv;
	private int totalPasiv;
	
	public List<Cont> getConturi() {
		return conturi;
	}
	
	public BilantContabil() {
	}
	
	public BilantContabil(List<Cont> conturi, int totalActiv, int totalPasiv) {
		this.conturi = conturi;
		this.totalActiv = totalActiv;
		this.totalPasiv = totalPasiv;
		
		if(conturi != null && !conturi.isEmpty()){
			for(Cont cont:conturi){
				
				if(cont.isTranzactionabil()){
					if(cont instanceof ContActiv){
						totalActiv+=cont.getSold();
					}
					
					if(cont instanceof ContPasiv){
						totalPasiv+=cont.getSold();
					}
				}
			}
		}
	}

	public void setConturi(List<Cont> conturi) {
		this.conturi = conturi;
	}
	public int getTotalActiv() {	
		return totalActiv;
	}
	public void setTotalActiv(int totalActiv) {
		this.totalActiv = totalActiv;
	}
	public int getTotalPasiv() {
		return totalPasiv;
	}
	public void setTotalPasiv(int totalPasiv) {
		this.totalPasiv = totalPasiv;
	}
	
	
	
}

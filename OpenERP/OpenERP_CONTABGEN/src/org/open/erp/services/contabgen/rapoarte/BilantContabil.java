package org.open.erp.services.contabgen.rapoarte;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.open.erp.services.contabgen.conturi.Cont;
import org.open.erp.services.contabgen.conturi.ContActiv;
import org.open.erp.services.contabgen.conturi.ContPasiv;

@Entity
public class BilantContabil extends Raport {
	
	
	@ManyToMany
	private List<Cont> conturi;
	private int totalActiv;
	private int totalPasiv;
	
	public List<Cont> getConturi() {
		return conturi;
	}
	
	public BilantContabil() {
	}
	
	
	
	public BilantContabil(List<Cont> conturi) {
		this.conturi = conturi;
	
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

package org.open.erp.services.sabloane;

import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.conturi.Cont;

public class Sablon {
	
	Integer idSablon;
	String denumireSablon;
	
	List<Cont> conturiDebitoare = new ArrayList<Cont>();
	List<Cont> conturiCreditoare = new ArrayList<Cont>();
	
	public List<Cont> getConturiDebitoare() {
		return conturiDebitoare;
	}
	public void addContDebitor(Cont contDebitor) {
		this.conturiDebitoare.add(contDebitor);
	}
	public void removeContDebitor(Cont contDebitor) {
		this.conturiDebitoare.remove(contDebitor);
	}
	public List<Cont> getConturiCreditoare() {
		return conturiCreditoare;
	}
	public void addContCreditor(Cont contCreditor) {
		this.conturiCreditoare.add(contCreditor);
	}
	public void removeContCreditor(Cont contCreditor) {
		this.conturiCreditoare.remove(contCreditor);
	}
	public Integer getIdSablon() {
		return idSablon;
	}
	public void setIdSablon(Integer idSablon) {
		this.idSablon = idSablon;
	}
	public String getDenumireSablon() {
		return denumireSablon;
	}
	public void setDenumireSablon(String denumireSablon) {
		this.denumireSablon = denumireSablon;
	}	
	
}

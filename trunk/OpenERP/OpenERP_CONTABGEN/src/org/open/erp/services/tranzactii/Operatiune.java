package org.open.erp.services.tranzactii;

import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.conturi.Cont;

public class Operatiune {

	Integer idOperatiune;
	String descriereOperatiune;
	TipOperatiune tipOperatiune; //cumparare, vanzare
	
	List<Cont> conturiDebitoare = new ArrayList<Cont>();
	List<Cont> conturiCreditoare = new ArrayList<Cont>();
	Double suma;
	
	
	public Integer getIdOperatiune() {
		return idOperatiune;
	}
	public void setIdOperatiune(Integer idOperatiune) {
		this.idOperatiune = idOperatiune;
	}
	public String getDescriereOperatiune() {
		return descriereOperatiune;
	}
	public void setDescriereOperatiune(String descriereOperatiune) {
		this.descriereOperatiune = descriereOperatiune;
	}
	public TipOperatiune getTipOperatiune() {
		return tipOperatiune;
	}
	public void setTipOperatiune(TipOperatiune tipOperatiune) {
		this.tipOperatiune = tipOperatiune;
	}
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
	public Double getSuma() {
		return suma;
	}
	public void setSuma(Double suma) {
		this.suma = suma;
	}
	
}

package org.open.erp.services.banci;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class CompanieBanci{
	@Id @GeneratedValue
	private Integer idCompanie;
	private String numeCompanie;
	private Vector<String> numeBanca = new Vector<String>();
	private Vector<Cont> numeConturi = new Vector<Cont>(); 
	
	public String getNumeCompanie() {
		return numeCompanie;
	}

	public void setNumeCompanie(String nume) {
		this.numeCompanie = nume;
	}
	public Vector<String> getNumeBanca() {
		return numeBanca;
	}
	
	public void setNumeBanca(String nume) {
		this.numeBanca.addElement(nume);
	}
	
	public Vector<Cont> getConturi() {
		return numeConturi;
	}
	
	public void setCont(Cont cont) {
		this.numeConturi.addElement(cont);
	}

	public CompanieBanci(String numeComp, String numeBanc, Integer idcard, String numeCont, String tcont, Integer tcard) {
		this.numeCompanie = numeComp;
		this.numeBanca.addElement(numeBanc);
		this.numeConturi.addElement(new Cont(idcard, numeCont, tcont, tcard));
	}
	
	public CompanieBanci(){
		super();
	}

	public Integer getIdCompanie() {
		return idCompanie;
	}

	public void setIdCompanie(Integer idCompanie) {
		this.idCompanie = idCompanie;
	}
}

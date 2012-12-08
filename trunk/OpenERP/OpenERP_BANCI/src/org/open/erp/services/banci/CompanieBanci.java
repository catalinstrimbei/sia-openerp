package org.open.erp.services.banci;

import java.util.Vector;

public class CompanieBanci{
	private String numeCompanie;
	private Vector<String> numeBanca;
	private Vector<Cont> numeConturi; 
	
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

	public CompanieBanci(String numeComp, String numeBanc, Integer idcard, String numeCont, Integer tcont, Integer tcard) {
		this.numeCompanie = numeComp;
		this.numeBanca = new Vector<String>();
		this.numeBanca.addElement(numeBanc);
		this.numeConturi = new Vector<Cont>();
		this.numeConturi.addElement(new Cont(idcard, numeCont, tcont, tcard));
	}
	
	public CompanieBanci(){
		super();
	}
}

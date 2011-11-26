package org.open.erp.services.ctbgen;

public class Cont {
	private int idCont;
	private String denCont;
	private String simbolCont;
	private Integer tipSintetic;
	private Cont contParinte;
	private String tipCont;
	
	public int getIdCont() {
		return idCont;
	}
	public void setIdCont(int idCont) {
		this.idCont = idCont;
	}
	public String getDenCont() {
		return denCont;
	}
	public void setDenCont(String denCont) {
		this.denCont = denCont;
	}
	public String getSimbolCont() {
		return simbolCont;
	}
	public void setSimbolCont(String simbolCont) {
		this.simbolCont = simbolCont;
	}
	public Integer getTipSintetic() {
		return tipSintetic;
	}
	public void setTipSintetic(Integer tipSintetic) {
		this.tipSintetic = tipSintetic;
	}
	public Cont getContParinte() {
		return contParinte;
	}
	public void setContParinte(Cont contParinte) {
		this.contParinte = contParinte;
	}
	public String getTipCont() {
		return tipCont;
	}
	public void setTipCont(String tipCont) {
		this.tipCont = tipCont;
	}
	public Cont(int idCont, String denCont, String simbolCont,
			Integer tipSintetic, Cont contParinte, String tipCont) {
		super();
		this.idCont = idCont;
		this.denCont = denCont;
		this.simbolCont = simbolCont;
		this.tipSintetic = tipSintetic;
		this.contParinte = contParinte;
		this.tipCont = tipCont;
	}
	public Cont() {
		super();
	}
	
	public boolean getContDisponibil(Cont cont) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Integer getIdCont(Cont cont) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSimbolCont(Cont cont) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

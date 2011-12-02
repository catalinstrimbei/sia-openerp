package org.open.erp.services.contabgest;

import org.open.erp.services.ctbgen.ArticolCtb;
import org.open.erp.services.ctbgen.Cont;

public class InregistrareGestiune {
	
	Integer idInregistrare;
	private ArticolCtb articolCtb;
	private Cont cont;
	private CentruCost centruCost;
	
	
	
	
	public InregistrareGestiune() {
		super();
	}
	public InregistrareGestiune(Integer idInregistrare, ArticolCtb articolCtb,
			Cont cont, CentruCost centruCost) {
		super();
		this.idInregistrare = idInregistrare;
		this.articolCtb = articolCtb;
		this.cont = cont;
		this.centruCost = centruCost;
	}
	public Integer getIdInregistrare() {
		return idInregistrare;
	}
	public void setIdInregistrare(Integer idInregistrare) {
		this.idInregistrare = idInregistrare;
	}
	public ArticolCtb getArticolCtb() {
		return articolCtb;
	}
	public void setArticolCtb(ArticolCtb articolCtb) {
		this.articolCtb = articolCtb;
	}
	public Cont getCont() {
		return cont;
	}
	public void setCont(Cont cont) {
		this.cont = cont;
	}
	public CentruCost getCentruCost() {
		return centruCost;
	}
	public void setCentruCost(CentruCost centruCost) {
		this.centruCost = centruCost;
	}
	
	

}

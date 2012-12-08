package org.open.erp.services.banci;

public class Cont{
	Integer id;
	String nume;
	Integer tipCont; //lei=1 sau valuta=2
	Integer tipCard;
 
	public String getNume() {
		return nume;
	}
	
	public void setNume(String name) {
		this.nume = name;
	}
	
	public Integer getTipCard() {
		return tipCard;
	}
	
	public void setTipCard(Integer tip) {
		this.tipCard = tip;
	}
	
	public Integer getTipCont() {
		return tipCont;
	}
	
	public void setTipCont(Integer tip) {
		this.tipCont = tip;
	}
	
	public Cont(Integer id, String nume, Integer tip_cont, Integer tip_card) {
		super();
		this.id = id;
		this.nume = nume;
		this.tipCont = tip_cont;
		this.tipCard = tip_card;
	}
	
	public Cont(){
		super();
	}
}

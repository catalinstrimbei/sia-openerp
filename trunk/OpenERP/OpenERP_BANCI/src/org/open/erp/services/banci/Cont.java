package org.open.erp.services.banci;

public class Cont{
	Integer id;
	String nume;
	String tipCont;
	Integer tipCard;
 
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
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
	
	public String getTipCont() {
		return tipCont;
	}
	
	public void setTipCont(String tip) {
		this.tipCont = tip;
	}
	
	public Cont(Integer id, String nume, String tip_cont, Integer tip_card) {
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

package org.open.erp.services.banci;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cont implements Serializable{
	@Id @GeneratedValue
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

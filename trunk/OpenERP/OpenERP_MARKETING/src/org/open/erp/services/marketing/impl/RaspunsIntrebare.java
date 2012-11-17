package org.open.erp.services.marketing.impl;

public class RaspunsIntrebare{
	long id;
	String text;
	Intrebare intrebare;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Intrebare getIntrebare() {
		return intrebare;
	}
	public void setIntrebare(Intrebare intrebare) {
		this.intrebare = intrebare;
	}
}
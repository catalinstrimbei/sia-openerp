package org.open.erp.services.marketing.impl;


public class Intrebare{
	long id;
	String text;
	Chestionar chestionar;
	
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
	public Chestionar getChestionar() {
		return chestionar;
	}
	public void setChestionar(Chestionar chestionar) {
		this.chestionar = chestionar;
	}
}
package org.open.erp.services.marketing.impl;

import java.util.Date;

import org.open.erp.services.marketing.nomgen.Persoana;

public class Reclamatie {
	long id;
	Persoana persoanaReclamanta;
	Date data;
	String text;
	String raspuns;
	StatusReclamatie status; //NOU, ASTEPTARE, REZOLVAT
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Persoana getPersoanaReclamanta() {
		return persoanaReclamanta;
	}
	public void setPersoanaReclamanta(Persoana persoanaReclamanta) {
		this.persoanaReclamanta = persoanaReclamanta;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getRaspuns() {
		return raspuns;
	}
	public void setRaspuns(String raspuns) {
		this.raspuns = raspuns;
	}
	public StatusReclamatie getStatus() {
		return status;
	}
	public void setStatus(StatusReclamatie status) {
		this.status = status;
	}
}

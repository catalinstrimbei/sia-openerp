package org.open.erp.services.marketing.impl;

import java.util.Date;

import org.open.erp.services.marketing.nomgen.Persoana;

public class Chestionar {
	long id;
	Date data;
	String titlu;
	Persoana persoanaChestionata;
	CercetarePiata cercetarePiata;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public Persoana getPersoanaChestionata() {
		return persoanaChestionata;
	}
	public void setPersoanaChestionata(Persoana persoanaChestionata) {
		this.persoanaChestionata = persoanaChestionata;
	}
	public CercetarePiata getCercetarePiata() {
		return cercetarePiata;
	}
	public void setCercetarePiata(CercetarePiata cercetarePiata) {
		this.cercetarePiata = cercetarePiata;
	}
}
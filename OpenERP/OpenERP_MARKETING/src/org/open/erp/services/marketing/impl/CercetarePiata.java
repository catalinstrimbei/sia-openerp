package org.open.erp.services.marketing.impl;

import java.util.Date;

import org.open.erp.services.marketing.nomgen.Angajat;

public class CercetarePiata {
	long id;
	Date dataStart;
	Date dataFinal;
	int buget;
	Angajat responsabilCercetarePiata;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDataStart() {
		return dataStart;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public int getBuget() {
		return buget;
	}
	public void setBuget(int buget) {
		this.buget = buget;
	}
	public Angajat getResponsabilCercetarePiata() {
		return responsabilCercetarePiata;
	}
	public void setResponsabilCercetarePiata(Angajat responsabilCercetarePiata) {
		this.responsabilCercetarePiata = responsabilCercetarePiata;
	}
} 

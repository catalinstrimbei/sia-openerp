package org.open.erp.services.marketing;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.open.erp.services.nomgen.Angajat;

public class CercetarePiata {
	long id;
	Date dataStart;
	Date dataFinal;
	int buget;
	Angajat responsabilCercetarePiata;
	Set<Chestionar> chestionareCercetarePiata = new HashSet<Chestionar>();

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

	public Set<Chestionar> getChestionareCercetarePiata() {
		return chestionareCercetarePiata;
	}

	public void setChestionareCercetarePiata(
			Set<Chestionar> chestionareCercetarePiata) {
		this.chestionareCercetarePiata = chestionareCercetarePiata;
	}
}

package org.open.erp.services.marketing;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.open.erp.services.marketing.nomgen.Persoana;

public class Chestionar {
	long id;
	Date data;
	String titlu;
	Persoana persoanaChestionata;
	Set<Intrebare> intrebariChestionar = new HashSet<Intrebare>();
	
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
	public Set<Intrebare> getIntrebariChestionar() {
		return intrebariChestionar;
	}
	public void setIntrebariChestionar(Set<Intrebare> intrebariChestionar) {
		this.intrebariChestionar = intrebariChestionar;
	}
}
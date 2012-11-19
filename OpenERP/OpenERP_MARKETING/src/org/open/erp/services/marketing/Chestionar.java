package org.open.erp.services.marketing;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.open.erp.services.nomgen.Persoana;

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

	public void adaugaIntrebare(Intrebare intrebare) {
		this.intrebariChestionar.add(intrebare);
	}

	public Chestionar() {

	}

	public Chestionar(long id, Date data, String titlu, Persoana persoanaChestionata) {
		super();
		this.id = id;
		this.data = data;
		this.titlu = titlu;
		this.persoanaChestionata = persoanaChestionata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chestionar other = (Chestionar) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
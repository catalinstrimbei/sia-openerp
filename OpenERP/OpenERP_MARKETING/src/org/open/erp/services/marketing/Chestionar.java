package org.open.erp.services.marketing;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.open.erp.services.nomgen.Persoana;

@Entity
public class Chestionar {
	
	@Id @GeneratedValue
	long id;
	
	@Temporal(TemporalType.DATE)
	Date data;
	
	String titlu;
	
	@ManyToOne
	Persoana persoanaChestionata;
	
	@ManyToOne
	CercetarePiata cercetarePiata;
	
	@OneToMany(mappedBy = "chestionar", targetEntity = Intrebare.class, cascade = ALL, fetch = EAGER)
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

	public CercetarePiata getCercetarePiata() {
		return cercetarePiata;
	}

	public void setCercetarePiata(CercetarePiata cercetarePiata) {
		this.cercetarePiata = cercetarePiata;
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
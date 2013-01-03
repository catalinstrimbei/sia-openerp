package org.open.erp.services.marketing;

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

import org.open.erp.services.personal.Angajat;

@Entity
public class CercetarePiata {

	@Id @GeneratedValue
	long id;
	
	@Temporal(TemporalType.DATE)
	Date dataStart;
	
	@Temporal(TemporalType.DATE)
	Date dataFinal;
	
	int buget;
	
	@ManyToOne
	Angajat responsabilCercetarePiata;
	
	@OneToMany // Trebuie vazut daca mai trebuie completat ceva.
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

	public void setChestionareCercetarePiata(Set<Chestionar> chestionareCercetarePiata) {
		this.chestionareCercetarePiata = chestionareCercetarePiata;
	}

	public void adaugaChestionar(Chestionar chestionar) {
		this.chestionareCercetarePiata.add(chestionar);
	}

	public CercetarePiata() {

	}

	public CercetarePiata(long id, Date dataStart, Date dataFinal, int buget, Angajat responsabilCercetarePiata) {
		super();
		this.id = id;
		this.dataStart = dataStart;
		this.dataFinal = dataFinal;
		this.buget = buget;
		this.responsabilCercetarePiata = responsabilCercetarePiata;
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
		CercetarePiata other = (CercetarePiata) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

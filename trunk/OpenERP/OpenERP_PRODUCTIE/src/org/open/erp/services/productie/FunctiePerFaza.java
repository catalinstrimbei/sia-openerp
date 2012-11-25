package org.open.erp.services.productie;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.Functie;

public class FunctiePerFaza {
	private FazaProductie fazaProductie;
	private Angajat angajat;
	private Functie functie;
	private Integer oreLucru;
	public FazaProductie getFazaProductie() {
		return fazaProductie;
	}
	public void setFazaProductie(FazaProductie fazaProductie) {
		this.fazaProductie = fazaProductie;
	}
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public Functie getFunctie() {
		return functie;
	}
	public void setFunctie(Functie functie) {
		this.functie = functie;
	}
	public Integer getOreLucru() {
		return oreLucru;
	}
	public void setOreLucru(Integer oreLucru) {
		this.oreLucru = oreLucru;
	}
	public FunctiePerFaza(FazaProductie fazaProductie, Angajat angajat,
			Functie functie, Integer oreLucru) {
		super();
		this.fazaProductie = fazaProductie;
		this.angajat = angajat;
		this.functie = functie;
		this.oreLucru = oreLucru;
	}
	public FunctiePerFaza() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((angajat == null) ? 0 : angajat.hashCode());
		result = prime * result
				+ ((fazaProductie == null) ? 0 : fazaProductie.hashCode());
		result = prime * result + ((functie == null) ? 0 : functie.hashCode());
		result = prime * result
				+ ((oreLucru == null) ? 0 : oreLucru.hashCode());
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
		FunctiePerFaza other = (FunctiePerFaza) obj;
		if (angajat == null) {
			if (other.angajat != null)
				return false;
		} else if (!angajat.equals(other.angajat))
			return false;
		if (fazaProductie == null) {
			if (other.fazaProductie != null)
				return false;
		} else if (!fazaProductie.equals(other.fazaProductie))
			return false;
		if (functie == null) {
			if (other.functie != null)
				return false;
		} else if (!functie.equals(other.functie))
			return false;
		if (oreLucru == null) {
			if (other.oreLucru != null)
				return false;
		} else if (!oreLucru.equals(other.oreLucru))
			return false;
		return true;
	}
	
	
}

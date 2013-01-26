package org.open.erp.services.salarizare;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.open.erp.services.personal.Angajat;


@Entity
public class Pontaje implements Serializable{

	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer cod_Pontaj;
	private Integer Pontaj_an;
	private Integer Pontaj_luna;
	@ManyToOne
	private Angajat angajat;
	private Double Pontaj_oreLucrate;
	private Double pontaj_oreSuplimentare;
	private Double Pontaj_oreConcediu;
	public Integer getCod_Pontaj() {
		return cod_Pontaj;
	}
	public void setCod_Pontaj(Integer cod_Pontaj) {
		this.cod_Pontaj = cod_Pontaj;
	}
	public Integer getPontaj_an() {
		return Pontaj_an;
	}
	public void setPontaj_an(Integer pontaj_an) {
		Pontaj_an = pontaj_an;
	}
	public Integer getPontaj_luna() {
		return Pontaj_luna;
	}
	public void setPontaj_luna(Integer pontaj_luna) {
		Pontaj_luna = pontaj_luna;
	}
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public Double getPontaj_oreLucrate() {
		return Pontaj_oreLucrate;
	}
	public void setPontaj_oreLucrate(Double pontaj_oreLucrate) {
		Pontaj_oreLucrate = pontaj_oreLucrate;
	}
	public Double getPontaj_oreSuplimentare() {
		return pontaj_oreSuplimentare;
	}
	public void setPontaj_oreSuplimentare(Double pontaj_oreSuplimentare) {
		this.pontaj_oreSuplimentare = pontaj_oreSuplimentare;
	}
	public Double getPontaj_oreConcediu() {
		return Pontaj_oreConcediu;
	}
	public void setPontaj_oreConcediu(Double pontaj_oreConcediu) {
		Pontaj_oreConcediu = pontaj_oreConcediu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Pontaj_an == null) ? 0 : Pontaj_an.hashCode());
		result = prime * result
				+ ((Pontaj_luna == null) ? 0 : Pontaj_luna.hashCode());
		result = prime
				* result
				+ ((Pontaj_oreLucrate == null) ? 0 : Pontaj_oreLucrate
						.hashCode());
		result = prime
				* result
				+ ((Pontaj_oreConcediu == null) ? 0 : Pontaj_oreConcediu
						.hashCode());
		result = prime * result
				+ ((cod_Pontaj == null) ? 0 : cod_Pontaj.hashCode());
		result = prime
				* result
				+ ((pontaj_oreSuplimentare == null) ? 0
						: pontaj_oreSuplimentare.hashCode());
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
		Pontaje other = (Pontaje) obj;
		if (Pontaj_an == null) {
			if (other.Pontaj_an != null)
				return false;
		} else if (!Pontaj_an.equals(other.Pontaj_an))
			return false;
		if (Pontaj_luna == null) {
			if (other.Pontaj_luna != null)
				return false;
		} else if (!Pontaj_luna.equals(other.Pontaj_luna))
			return false;
		if (Pontaj_oreLucrate == null) {
			if (other.Pontaj_oreLucrate != null)
				return false;
		} else if (!Pontaj_oreLucrate.equals(other.Pontaj_oreLucrate))
			return false;
		if (Pontaj_oreConcediu == null) {
			if (other.Pontaj_oreConcediu != null)
				return false;
		} else if (!Pontaj_oreConcediu.equals(other.Pontaj_oreConcediu))
			return false;
		if (cod_Pontaj == null) {
			if (other.cod_Pontaj != null)
				return false;
		} else if (!cod_Pontaj.equals(other.cod_Pontaj))
			return false;
		if (pontaj_oreSuplimentare == null) {
			if (other.pontaj_oreSuplimentare != null)
				return false;
		} else if (!pontaj_oreSuplimentare.equals(other.pontaj_oreSuplimentare))
			return false;
		return true;
	}
	public Pontaje(Integer cod_Pontaj, Integer pontaj_an, Integer pontaj_luna,
			Angajat angajat, Double pontaj_oreLucrate,
			Double pontaj_oreSuplimentare, Double pontaj_oreConcediu) {
		super();
		this.cod_Pontaj = cod_Pontaj;
		Pontaj_an = pontaj_an;
		Pontaj_luna = pontaj_luna;
		this.angajat = angajat;
		Pontaj_oreLucrate = pontaj_oreLucrate;
		this.pontaj_oreSuplimentare = pontaj_oreSuplimentare;
		Pontaj_oreConcediu = pontaj_oreConcediu;
	}
	public Pontaje() {
		super();
	}
	
	
	
}

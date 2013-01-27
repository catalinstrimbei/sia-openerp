package org.open.erp.services.salarizare;


import java.io.Serializable;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.open.erp.services.personal.Angajat;

@Entity
public class Retineri implements Serializable{

	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer cod_Retinere;
	private String denumire_Retinere;
	private Integer tip_Retinere;
	private Integer an;
	private Integer luna;
	@ManyToOne
	private Angajat angajat;
	private Integer mod_Calcul;
	private Double valoare;
	public Integer getCod_Retinere() {
		return cod_Retinere;
	}
	public void setCod_Retinere(Integer cod_Retinere) {
		this.cod_Retinere = cod_Retinere;
	}
	public String getDenumire_Retinere() {
		return denumire_Retinere;
	}
	public void setDenumire_Retinere(String denumire_Retinere) {
		this.denumire_Retinere = denumire_Retinere;
	}
	public Integer getTip_Retinere() {
		return tip_Retinere;
	}
	public void setTip_Retinere(Integer tip_Retinere) {
		this.tip_Retinere = tip_Retinere;
	}
	public Integer getAn() {
		return an;
	}
	public void setAn(Integer an) {
		this.an = an;
	}
	public Integer getLuna() {
		return luna;
	}
	public void setLuna(Integer luna) {
		this.luna = luna;
	}
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public Integer getMod_Calcul() {
		return mod_Calcul;
	}
	public void setMod_Calcul(Integer mod_Calcul) {
		this.mod_Calcul = mod_Calcul;
	}
	public Double getValoare() {
		return valoare;
	}
	public void setValoare(Double valoare) {
		this.valoare = valoare;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((an == null) ? 0 : an.hashCode());
		result = prime * result + ((angajat == null) ? 0 : angajat.hashCode());
		result = prime * result
				+ ((cod_Retinere == null) ? 0 : cod_Retinere.hashCode());
		result = prime
				* result
				+ ((denumire_Retinere == null) ? 0 : denumire_Retinere
						.hashCode());
		result = prime * result + ((luna == null) ? 0 : luna.hashCode());
		result = prime * result
				+ ((mod_Calcul == null) ? 0 : mod_Calcul.hashCode());
		result = prime * result
				+ ((tip_Retinere == null) ? 0 : tip_Retinere.hashCode());
		result = prime * result + ((valoare == null) ? 0 : valoare.hashCode());
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
		Retineri other = (Retineri) obj;
		if (an == null) {
			if (other.an != null)
				return false;
		} else if (!an.equals(other.an))
			return false;
		if (angajat == null) {
			if (other.angajat != null)
				return false;
		} else if (!angajat.equals(other.angajat))
			return false;
		if (cod_Retinere == null) {
			if (other.cod_Retinere != null)
				return false;
		} else if (!cod_Retinere.equals(other.cod_Retinere))
			return false;
		if (denumire_Retinere == null) {
			if (other.denumire_Retinere != null)
				return false;
		} else if (!denumire_Retinere.equals(other.denumire_Retinere))
			return false;
		if (luna == null) {
			if (other.luna != null)
				return false;
		} else if (!luna.equals(other.luna))
			return false;
		if (mod_Calcul == null) {
			if (other.mod_Calcul != null)
				return false;
		} else if (!mod_Calcul.equals(other.mod_Calcul))
			return false;
		if (tip_Retinere == null) {
			if (other.tip_Retinere != null)
				return false;
		} else if (!tip_Retinere.equals(other.tip_Retinere))
			return false;
		if (valoare == null) {
			if (other.valoare != null)
				return false;
		} else if (!valoare.equals(other.valoare))
			return false;
		return true;
	}
	public Retineri(Integer cod_Retinere, String denumire_Retinere,
			Integer tip_Retinere, Integer an, Integer luna, Angajat angajat,
			Integer mod_Calcul, Double valoare) {
		super();
		this.cod_Retinere = cod_Retinere;
		this.denumire_Retinere = denumire_Retinere;
		this.tip_Retinere = tip_Retinere;
		this.an = an;
		this.luna = luna;
		this.angajat = angajat;
		this.mod_Calcul = mod_Calcul;
		this.valoare = valoare;
	}
	
	
	
	
}

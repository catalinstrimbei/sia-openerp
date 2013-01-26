package org.open.erp.services.salarizare;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Stat_Salarii implements Serializable{
	
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private Integer Cod_Stat_Salarii;
	private Double Salariu_Brut;
	private Double Impozit;
	private Double Alte_Retineri;
	private Double Alte_Sporuri;
	private Double Salariu_Net;
	@OneToOne
	@JoinColumn(name = "pontaj_cod_Pontaj", referencedColumnName = "cod_Pontaj")
	private Pontaje Pontaje;
	private Double CAS;
	private Double CASS;
	private Double Somaj;
	
	public Integer getCod_Stat_Salarii() {
		return Cod_Stat_Salarii;
	}
	public void setCod_Stat_Salarii(Integer cod_Stat_Salarii) {
		Cod_Stat_Salarii = cod_Stat_Salarii;
	}
	public Double getSalariu_Brut() {
		return Salariu_Brut;
	}
	public void setSalariu_Brut(Double salariu_Brut) {
		Salariu_Brut = salariu_Brut;
	}
	public Double getImpozit() {
		return Impozit;
	}
	public void setImpozit(Double impozit) {
		Impozit = impozit;
	}
	public Double getAlte_Retineri() {
		return Alte_Retineri;
	}
	public void setAlte_Retineri(Double alte_Retineri) {
		Alte_Retineri = alte_Retineri;
	}
	public Double getAlte_Sporuri() {
		return Alte_Sporuri;
	}
	public void setAlte_Sporuri(Double alte_Sporuri) {
		Alte_Sporuri = alte_Sporuri;
	}
	public Double getSalariu_Net() {
		return Salariu_Net;
	}
	public void setSalariu_Net(Double salariu_Net) {
		Salariu_Net = salariu_Net;
	}
	public Pontaje getPontaje() {
		return Pontaje;
	}
	public void setPontaje(Pontaje pontaje) {
		Pontaje = pontaje;
	}
	public Double getCAS() {
		return CAS;
	}
	public void setCAS(Double cAS) {
		CAS = cAS;
	}
	public Double getCASS() {
		return CASS;
	}
	public void setCASS(Double cASS) {
		CASS = cASS;
	}
	public Double getSomaj() {
		return Somaj;
	}
	public void setSomaj(Double somaj) {
		Somaj = somaj;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Salariu_Net == null) ? 0 : Salariu_Net.hashCode());
		result = prime * result
				+ ((Alte_Retineri == null) ? 0 : Alte_Retineri.hashCode());
		result = prime * result
				+ ((Alte_Sporuri == null) ? 0 : Alte_Sporuri.hashCode());
		result = prime * result + ((CAS == null) ? 0 : CAS.hashCode());
		result = prime * result + ((CASS == null) ? 0 : CASS.hashCode());
		result = prime
				* result
				+ ((Cod_Stat_Salarii == null) ? 0 : Cod_Stat_Salarii.hashCode());
		result = prime * result + ((Impozit == null) ? 0 : Impozit.hashCode());
		result = prime * result + ((Pontaje == null) ? 0 : Pontaje.hashCode());
		result = prime * result
				+ ((Salariu_Brut == null) ? 0 : Salariu_Brut.hashCode());
		result = prime * result + ((Somaj == null) ? 0 : Somaj.hashCode());
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
		Stat_Salarii other = (Stat_Salarii) obj;
		if (Salariu_Net == null) {
			if (other.Salariu_Net != null)
				return false;
		} else if (!Salariu_Net.equals(other.Salariu_Net))
			return false;
		if (Alte_Retineri == null) {
			if (other.Alte_Retineri != null)
				return false;
		} else if (!Alte_Retineri.equals(other.Alte_Retineri))
			return false;
		if (Alte_Sporuri == null) {
			if (other.Alte_Sporuri != null)
				return false;
		} else if (!Alte_Sporuri.equals(other.Alte_Sporuri))
			return false;
		if (CAS == null) {
			if (other.CAS != null)
				return false;
		} else if (!CAS.equals(other.CAS))
			return false;
		if (CASS == null) {
			if (other.CASS != null)
				return false;
		} else if (!CASS.equals(other.CASS))
			return false;
		if (Cod_Stat_Salarii == null) {
			if (other.Cod_Stat_Salarii != null)
				return false;
		} else if (!Cod_Stat_Salarii.equals(other.Cod_Stat_Salarii))
			return false;
		if (Impozit == null) {
			if (other.Impozit != null)
				return false;
		} else if (!Impozit.equals(other.Impozit))
			return false;
		if (Pontaje == null) {
			if (other.Pontaje != null)
				return false;
		} else if (!Pontaje.equals(other.Pontaje))
			return false;
		if (Salariu_Brut == null) {
			if (other.Salariu_Brut != null)
				return false;
		} else if (!Salariu_Brut.equals(other.Salariu_Brut))
			return false;
		if (Somaj == null) {
			if (other.Somaj != null)
				return false;
		} else if (!Somaj.equals(other.Somaj))
			return false;
		return true;
	}
	public Stat_Salarii(Integer cod_Stat_Salarii, Double salariu_Brut,
			Double impozit, Double alte_Retineri, Double alte_Sporuri,
			Double aalariu_Net,
			org.open.erp.services.salarizare.Pontaje pontaje, Double cAS,
			Double cASS, Double somaj) {
		super();
		Cod_Stat_Salarii = cod_Stat_Salarii;
		Salariu_Brut = salariu_Brut;
		Impozit = impozit;
		Alte_Retineri = alte_Retineri;
		Alte_Sporuri = alte_Sporuri;
		Salariu_Net = aalariu_Net;
		Pontaje = pontaje;
		CAS = cAS;
		CASS = cASS;
		Somaj = somaj;
	}
	public Stat_Salarii() {
		super();
	}

	
	
	
}

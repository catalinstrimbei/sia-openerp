package org.open.erp.services.salarizare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Centralizare_Stat_Plata implements Serializable {

	
	private Integer Cod;
	private Integer An;
	private Integer Luna;
	private List<Stat_Salarii> centralizator = new ArrayList<Stat_Salarii>();
	private Double total_Salar_Brut;
	private Double total_Impozit;
	private Double total_Alte_Retineri;
	private Double total_Alte_Sporuri;
	private Double total_Salar_Net;
	private Double total_CAS;
	private Double total_CASS;
	private Double total_Somaj;
	
	public Integer getCod() {
		return Cod;
	}
	public void setCod(Integer cod) {
		Cod = cod;
	}
	public Integer getAn() {
		return An;
	}
	public void setAn(Integer an) {
		An = an;
	}
	public Integer getLuna() {
		return Luna;
	}
	public void setLuna(Integer luna) {
		Luna = luna;
	}
	public List<Stat_Salarii> getCentralizator() {
		return centralizator;
	}
	public void setCentralizator(List<Stat_Salarii> centralizator) {
		this.centralizator = centralizator;
	}
	public Double getTotal_Salar_Brut() {
		return total_Salar_Brut;
	}
	public void setTotal_Salar_Brut(Double total_Salar_Brut) {
		this.total_Salar_Brut = total_Salar_Brut;
	}
	public Double getTotal_Impozit() {
		return total_Impozit;
	}
	public void setTotal_Impozit(Double total_Impozit) {
		this.total_Impozit = total_Impozit;
	}
	public Double getTotal_Alte_Retineri() {
		return total_Alte_Retineri;
	}
	public void setTotal_Alte_Retineri(Double total_Alte_Retineri) {
		this.total_Alte_Retineri = total_Alte_Retineri;
	}
	public Double getTotal_Alte_Sporuri() {
		return total_Alte_Sporuri;
	}
	public void setTotal_Alte_Sporuri(Double total_Alte_Sporuri) {
		this.total_Alte_Sporuri = total_Alte_Sporuri;
	}
	public Double getTotal_Sala_Net() {
		return total_Salar_Net;
	}
	public void setTotal_Sala_Net(Double total_Sala_Net, Double total_Salar_Net) {
		this.total_Salar_Net = total_Salar_Net;
	}
	public Double getTotal_CAS() {
		return total_CAS;
	}
	public void setTotal_CAS(Double total_CAS) {
		this.total_CAS = total_CAS;
	}
	public Double getTotal_CASS() {
		return total_CASS;
	}
	public void setTotal_CASS(Double total_CASS) {
		this.total_CASS = total_CASS;
	}
	public Double getTotal_Somaj() {
		return total_Somaj;
	}
	public void setTotal_Somaj(Double total_Somaj) {
		this.total_Somaj = total_Somaj;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((An == null) ? 0 : An.hashCode());
		result = prime * result + ((Cod == null) ? 0 : Cod.hashCode());
		result = prime * result + ((Luna == null) ? 0 : Luna.hashCode());
		result = prime * result
				+ ((centralizator == null) ? 0 : centralizator.hashCode());
		result = prime
				* result
				+ ((total_Alte_Retineri == null) ? 0 : total_Alte_Retineri
						.hashCode());
		result = prime
				* result
				+ ((total_Alte_Sporuri == null) ? 0 : total_Alte_Sporuri
						.hashCode());
		result = prime * result
				+ ((total_CAS == null) ? 0 : total_CAS.hashCode());
		result = prime * result
				+ ((total_CASS == null) ? 0 : total_CASS.hashCode());
		result = prime * result
				+ ((total_Impozit == null) ? 0 : total_Impozit.hashCode());
		result = prime * result
				+ ((total_Salar_Net == null) ? 0 : total_Salar_Net.hashCode());
		result = prime
				* result
				+ ((total_Salar_Brut == null) ? 0 : total_Salar_Brut.hashCode());
		result = prime * result
				+ ((total_Somaj == null) ? 0 : total_Somaj.hashCode());
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
		Centralizare_Stat_Plata other = (Centralizare_Stat_Plata) obj;
		if (An == null) {
			if (other.An != null)
				return false;
		} else if (!An.equals(other.An))
			return false;
		if (Cod == null) {
			if (other.Cod != null)
				return false;
		} else if (!Cod.equals(other.Cod))
			return false;
		if (Luna == null) {
			if (other.Luna != null)
				return false;
		} else if (!Luna.equals(other.Luna))
			return false;
		if (centralizator == null) {
			if (other.centralizator != null)
				return false;
		} else if (!centralizator.equals(other.centralizator))
			return false;
		if (total_Alte_Retineri == null) {
			if (other.total_Alte_Retineri != null)
				return false;
		} else if (!total_Alte_Retineri.equals(other.total_Alte_Retineri))
			return false;
		if (total_Alte_Sporuri == null) {
			if (other.total_Alte_Sporuri != null)
				return false;
		} else if (!total_Alte_Sporuri.equals(other.total_Alte_Sporuri))
			return false;
		if (total_CAS == null) {
			if (other.total_CAS != null)
				return false;
		} else if (!total_CAS.equals(other.total_CAS))
			return false;
		if (total_CASS == null) {
			if (other.total_CASS != null)
				return false;
		} else if (!total_CASS.equals(other.total_CASS))
			return false;
		if (total_Impozit == null) {
			if (other.total_Impozit != null)
				return false;
		} else if (!total_Impozit.equals(other.total_Impozit))
			return false;
		if (total_Salar_Net == null) {
			if (other.total_Salar_Net != null)
				return false;
		} else if (!total_Salar_Net.equals(other.total_Salar_Net))
			return false;
		if (total_Salar_Brut == null) {
			if (other.total_Salar_Brut != null)
				return false;
		} else if (!total_Salar_Brut.equals(other.total_Salar_Brut))
			return false;
		if (total_Somaj == null) {
			if (other.total_Somaj != null)
				return false;
		} else if (!total_Somaj.equals(other.total_Somaj))
			return false;
		return true;
	}
	public Centralizare_Stat_Plata(Integer cod, Integer an, Integer luna,
			List<Stat_Salarii> centralizator, Double total_Salar_Brut,
			Double total_Impozit, Double total_Alte_Retineri,
			Double total_Alte_Sporuri, Double total_Sala_Net, Double total_CAS,
			Double total_CASS, Double total_Somaj, Double total_Salar_Net) {
		super();
		Cod = cod;
		An = an;
		Luna = luna;
		this.centralizator = centralizator;
		this.total_Salar_Brut = total_Salar_Brut;
		this.total_Impozit = total_Impozit;
		this.total_Alte_Retineri = total_Alte_Retineri;
		this.total_Alte_Sporuri = total_Alte_Sporuri;
		this.total_Salar_Net = total_Salar_Net;
		this.total_CAS = total_CAS;
		this.total_CASS = total_CASS;
		this.total_Somaj = total_Somaj;
	}
	

	
	
	
	
}

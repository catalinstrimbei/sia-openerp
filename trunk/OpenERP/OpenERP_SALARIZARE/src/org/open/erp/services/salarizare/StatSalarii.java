package org.open.erp.services.salarizare;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class StatSalarii implements Serializable{
	@Id
	@GeneratedValue
	private Integer idStatSalarii;
	@OneToOne
	@JoinColumn(name = "pontaj_idPontaj", referencedColumnName = "idPontaj")
	private Pontaj pontaj;
	private Double cas;
	private Double cass;
	private Double somaj;
	private Double alteRetineri;
	private Double alteSporuri;
	private Double salarBrut;
	private Double impozit;
	private Double salarNet;
	public StatSalarii() {
		super();
	}
	
	public Integer getIdStatSalarii() {
		return idStatSalarii;
	}

	public void setIdStatSalarii(Integer idStatSalarii) {
		this.idStatSalarii = idStatSalarii;
	}

	public Pontaj getPontaj() {
		return pontaj;
	}
	public void setPontaj(Pontaj pontaj) {
		this.pontaj = pontaj;
	}
	public Double getCas() {
		return cas;
	}
	public void setCas(Double cas) {
		this.cas = cas;
	}
	public Double getCass() {
		return cass;
	}
	public void setCass(Double cass) {
		this.cass = cass;
	}
	public Double getSomaj() {
		return somaj;
	}
	public void setSomaj(Double somaj) {
		this.somaj = somaj;
	}
	public Double getAlteRetineri() {
		return alteRetineri;
	}
	public void setAlteRetineri(Double alteRetineri) {
		this.alteRetineri = alteRetineri;
	}
	public Double getAlteSporuri() {
		return alteSporuri;
	}
	public void setAlteSporuri(Double alteSporuri) {
		this.alteSporuri = alteSporuri;
	}
	public Double getSalarBrut() {
		return salarBrut;
	}
	public void setSalarBrut(Double salarBrut) {
		this.salarBrut = salarBrut;
	}
	public Double getImpozit() {
		return impozit;
	}
	public void setImpozit(Double impozit) {
		this.impozit = impozit;
	}
	public Double getSalarNet() {
		return salarNet;
	}
	public void setSalarNet(Double salarNet) {
		this.salarNet = salarNet;
	}

	public StatSalarii(Integer idStatSalarii, Pontaj pontaj, Double cas,
			Double cass, Double somaj, Double alteRetineri, Double alteSporuri,
			Double salarBrut, Double impozit, Double salarNet) {
		super();
		this.idStatSalarii = idStatSalarii;
		this.pontaj = pontaj;
		this.cas = cas;
		this.cass = cass;
		this.somaj = somaj;
		this.alteRetineri = alteRetineri;
		this.alteSporuri = alteSporuri;
		this.salarBrut = salarBrut;
		this.impozit = impozit;
		this.salarNet = salarNet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idStatSalarii == null) ? 0 : idStatSalarii.hashCode());
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
		StatSalarii other = (StatSalarii) obj;
		if (idStatSalarii == null) {
			if (other.idStatSalarii != null)
				return false;
		} else if (!idStatSalarii.equals(other.idStatSalarii))
			return false;
		return true;
	}
	
}

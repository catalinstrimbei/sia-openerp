package org.open.erp.services.contabgest;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



import org.open.erp.services.productie.Reteta;
@Entity
public class Calculatii  implements Serializable{
	
	@Id @GeneratedValue
	private Integer IdCalculatie;
	@ManyToOne
	private Reteta reteta;
	@ManyToOne
	private Analiza analiza;
	
	@OneToMany(mappedBy = "calculatie", 
			targetEntity = CosturiExtra.class, 
			cascade = ALL)
   	private List<CosturiExtra> costuriextra = new ArrayList<CosturiExtra>();
	public Integer getIdCalculatie() {
		return IdCalculatie;
	}
	public void setIdCalculatie(Integer idCalculatie) {
		IdCalculatie = idCalculatie;
	}
	public Reteta getReteta() {
		return reteta;
	}
	public void setReteta(Reteta reteta) {
		this.reteta = reteta;
	}
	public Analiza getAnaliza() {
		return analiza;
	}
	public void setAnaliza(Analiza analiza) {
		this.analiza = analiza;
	}
	public List<CosturiExtra> getCosturiextra() {
		return costuriextra;
	}
	public void setCosturiextra(List<CosturiExtra> costuriextra) {
		this.costuriextra = costuriextra;
	}
	public Calculatii() {
		super();
	}
	public Calculatii(Integer idCalculatie, Reteta reteta, Analiza analiza,
			List<CosturiExtra> costuriextra) {
		super();
		IdCalculatie = idCalculatie;
		this.reteta = reteta;
		this.analiza = analiza;
		this.costuriextra = costuriextra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdCalculatie == null) ? 0 : IdCalculatie.hashCode());
		result = prime * result + ((analiza == null) ? 0 : analiza.hashCode());
		result = prime * result
				+ ((costuriextra == null) ? 0 : costuriextra.hashCode());
		result = prime * result + ((reteta == null) ? 0 : reteta.hashCode());
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
		Calculatii other = (Calculatii) obj;
		if (IdCalculatie == null) {
			if (other.IdCalculatie != null)
				return false;
		} else if (!IdCalculatie.equals(other.IdCalculatie))
			return false;
		if (analiza == null) {
			if (other.analiza != null)
				return false;
		} else if (!analiza.equals(other.analiza))
			return false;
		if (costuriextra == null) {
			if (other.costuriextra != null)
				return false;
		} else if (!costuriextra.equals(other.costuriextra))
			return false;
		if (reteta == null) {
			if (other.reteta != null)
				return false;
		} else if (!reteta.equals(other.reteta))
			return false;
		return true;
	}
   	
}
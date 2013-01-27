package org.open.erp.services.contabgen.rapoarte;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Raport implements Serializable{
	
	@Id
	@GeneratedValue
	Integer idRaport;
	String denumire;
	Date dataInceputRaport;
	Date dataSfarsitRaport;
	
	
	public Integer getIdRaport() {
		return idRaport;
	}
	public void setIdRaport(Integer idRaport) {
		this.idRaport = idRaport;
	}
	public Date getDataInceputRaport() {
		return dataInceputRaport;
	}
	public void setDataInceputRaport(Date dataInceputRaport) {
		this.dataInceputRaport = dataInceputRaport;
	}
	public Date getDataSfarsitRaport() {
		return dataSfarsitRaport;
	}
	public void setDataSfarsitRaport(Date dataSfarsitRaport) {
		this.dataSfarsitRaport = dataSfarsitRaport;
	}
	
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idRaport == null) ? 0 : idRaport.hashCode());
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
		Raport other = (Raport) obj;
		if (idRaport == null) {
			if (other.idRaport != null)
				return false;
		} else if (!idRaport.equals(other.idRaport))
			return false;
		return true;
	}

	
}

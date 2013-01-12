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

}

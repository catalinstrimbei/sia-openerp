package org.open.erp.services.rapoarte;

import java.util.Date;

public class Raport {
	
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

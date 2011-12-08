package org.open.erp.services.plati;

import java.util.Date;

public class Chitanta {
	private Integer idChitanta;
	private Date data;
	private Double suma;
	
	public Chitanta (Integer idChitanta, Date data, Double suma){
		this.idChitanta=idChitanta;
		this.data=data;
		this.suma=suma;
	}
	
	public Integer getIdChitanta() {
		return idChitanta;
	}
	
	public void setIdChitanta(Integer idChitanta) {
		this.idChitanta = idChitanta;
	}

	public Double getSuma() {
		return suma;
	}

	public void setSuma(Double suma) {
		this.suma = suma;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}

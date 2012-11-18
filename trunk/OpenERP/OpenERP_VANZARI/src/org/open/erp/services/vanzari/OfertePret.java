package org.open.erp.services.vanzari;

import java.util.Date;

import org.open.erp.services.nomgen.Clienti;
import org.open.erp.services.nommat.Produse;

public class OfertePret {
	Integer idOfertaPret;
	Produse produs;
	Clienti client;
	Date dataValabilitate;
	Date dataEmitere=new Date(System.currentTimeMillis());
	String observatii;

	public OfertePret() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Double getPretOferta(Double cantitate) { 
		if (cantitate >= 100 && cantitate < 250)
			return produs.getCost()+produs.getCost()*0.3;
		if (cantitate>=250)
			return produs.getCost()+produs.getCost()*0.15;
		
		return produs.getCost()+produs.getCost()*0.5;
}

	public Integer getIdOfertaPret() {
		return idOfertaPret;
	}

	public void setIdOfertaPret(Integer idOfertaPret) {
		this.idOfertaPret = idOfertaPret;
	}

	public Produse getProdus() {
		return produs;
	}

	public void setProdus(Produse produs) {
		this.produs = produs;
	}

	public Clienti getClient() {
		return client;
	}

	public void setClient(Clienti client) {
		this.client = client;
	}

	public Date getDataValabilitate() {
		return dataValabilitate;
	}

	public void setDataValabilitate(Date dataValabilitate) {
		this.dataValabilitate = dataValabilitate;
	}

	public Date getDataEmitere() {
		return dataEmitere;
	}

	public void setDataEmitere(Date dataEmitere) {
		this.dataEmitere = dataEmitere;
	}

	public String getObservatii() {
		return observatii;
	}

	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}

	public OfertePret(Integer idOfertaPret, Produse produs, Clienti client,
			Date dataValabilitate, Date dataEmitere, String observatii) {
		super();
		this.idOfertaPret = idOfertaPret;
		this.produs = produs;
		this.client = client;
		this.dataValabilitate = dataValabilitate;
		this.dataEmitere = dataEmitere;
		this.observatii = observatii;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idOfertaPret == null) ? 0 : idOfertaPret.hashCode());
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
		OfertePret other = (OfertePret) obj;
		if (idOfertaPret == null) {
			if (other.idOfertaPret != null)
				return false;
		} else if (!idOfertaPret.equals(other.idOfertaPret))
			return false;
		return true;
	}

	
	
}

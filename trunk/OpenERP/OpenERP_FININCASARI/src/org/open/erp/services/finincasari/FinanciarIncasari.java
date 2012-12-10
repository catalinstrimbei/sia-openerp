package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Isabela
 *
 */
public class FinanciarIncasari implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Localitate;
	private Date dataEmiterii;
	private Double suma;
	private String moneda;
	private String sumaLitere;
	//private String contBancar;
	Double sumaIncasare;
	
	
	

	public String getLocalitate() {
		return Localitate;
	}
	public void setLocalitate(String localitate) {
		Localitate = localitate;
	}
	
	public Double getSuma() {
		return suma;
	}
	public void setSuma(Double suma) {
		this.suma = suma;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getSumaLitere() {
		return sumaLitere;
	}
	public void setSumaLitere(String sumaLitere) {
		this.sumaLitere = sumaLitere;
	}
	/*public String getContBancar() {
		return contBancar;
	}
	public void setContBancar(String contBancar) {
		this.contBancar = contBancar;
	} */
	public Date getDataEmiterii() {
		return dataEmiterii;
	}
	public void setDataEmiterii(Date dataEmiterii) {
		this.dataEmiterii = dataEmiterii;
	}
	
	public Double getSumaIncasare() {
		return sumaIncasare;
	}
	public void setSumaIncasare(Double sumaIncasare) {
		this.sumaIncasare = sumaIncasare;
	}
	
	public FinanciarIncasari(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere) {
		super();
		Localitate = localitate;
		this.dataEmiterii = dataEmiterii;
		this.suma = suma;
		this.moneda = moneda;
		this.sumaLitere = sumaLitere;
		//this.contBancar = contBancar;
	}
	public FinanciarIncasari() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Localitate == null) ? 0 : Localitate.hashCode());
		//result = prime * result
			//	+ ((contBancar == null) ? 0 : contBancar.hashCode());
		result = prime * result
				+ ((dataEmiterii == null) ? 0 : dataEmiterii.hashCode());
		result = prime * result + ((moneda == null) ? 0 : moneda.hashCode());
		result = prime * result + ((suma == null) ? 0 : suma.hashCode());
		result = prime * result
				+ ((sumaLitere == null) ? 0 : sumaLitere.hashCode());
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
		FinanciarIncasari other = (FinanciarIncasari) obj;
		if (Localitate == null) {
			if (other.Localitate != null)
				return false;
		} else if (!Localitate.equals(other.Localitate))
			return false;
		//if (contBancar == null) {
			//if (other.contBancar != null)
			//	return false;
		//} else if (!contBancar.equals(other.contBancar))
		//	return false;
		if (dataEmiterii == null) {
			if (other.dataEmiterii != null)
				return false;
		} else if (!dataEmiterii.equals(other.dataEmiterii))
			return false;
		if (moneda == null) {
			if (other.moneda != null)
				return false;
		} else if (!moneda.equals(other.moneda))
			return false;
		if (suma == null) {
			if (other.suma != null)
				return false;
		} else if (!suma.equals(other.suma))
			return false;
		if (sumaLitere == null) {
			if (other.sumaLitere != null)
				return false;
		} else if (!sumaLitere.equals(other.sumaLitere))
			return false;
		return true;
	}
	
	
}

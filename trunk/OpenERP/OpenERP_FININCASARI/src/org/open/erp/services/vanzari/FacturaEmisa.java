package org.open.erp.services.vanzari;

import java.util.Date;


public class FacturaEmisa {

	private Integer IdFactura;
	private Double ValoareTotalaFactura;
	private Double SumaIncasata;
	private boolean Platita;
	private Date dataDoc;
	
	

	public Integer getIdFactura() {
		return IdFactura;
	}

	public void setIdFactura(Integer idFactura) {
		IdFactura = idFactura;
	}

	public Double getValoareTotalaFactura() {
		return ValoareTotalaFactura;
	}

	public void setValoareTotalaFactura(Double valoareTotalaFactura) {
		ValoareTotalaFactura = valoareTotalaFactura;
	}

	public void setIdFactura(int idFactura2) {
		// TODO Auto-generated method stub
		
	}

	public Double getSumaIncasata() {
		return SumaIncasata;
	}

	public void setSumaIncasata(Double sumaIncasata) {
		SumaIncasata = sumaIncasata;
	}

	/**
	 * @return the platita
	 */
	public boolean getPlatita() {
		return Platita;
	}

	/**
	 * @param platita the platita to set
	 */
	public void setPlatita(boolean platita) {
		Platita = platita;
	}

	public Date getDataDoc() {
		return dataDoc;
	}

	public void setDataDoc(Date dataDoc) {
		this.dataDoc = dataDoc;
	}

	public Client getClient() {
		// TODO Auto-generated method stub
		return null;
	}

	

}

		
	


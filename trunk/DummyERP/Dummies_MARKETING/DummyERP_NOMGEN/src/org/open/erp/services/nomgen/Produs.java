package org.open.erp.services.nomgen;

import java.util.Date;

public class Produs {
	Integer 			idProdus;
	String				denumire;
	String				unitateMasura;
	Date				dataFabricatie;
	Date				termenValabilitate;
	Float				pretProdus;
	/**
	 * @return the idProdus
	 */
	public Integer getIdProdus() {
		return idProdus;
	}
	/**
	 * @param idProdus the idProdus to set
	 */
	public void setIdProdus(Integer idProdus) {
		this.idProdus = idProdus;
	}
	/**
	 * @return the denumire
	 */
	public String getDenumire() {
		return denumire;
	}
	/**
	 * @param denumire the denumire to set
	 */
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	/**
	 * @return the unitateMasura
	 */
	public String getUnitateMasura() {
		return unitateMasura;
	}
	/**
	 * @param unitateMasura the unitateMasura to set
	 */
	public void setUnitateMasura(String unitateMasura) {
		this.unitateMasura = unitateMasura;
	}
	/**
	 * @return the dataFabricatie
	 */
	public Date getDataFabricatie() {
		return dataFabricatie;
	}
	/**
	 * @param dataFabricatie the dataFabricatie to set
	 */
	public void setDataFabricatie(Date dataFabricatie) {
		this.dataFabricatie = dataFabricatie;
	}
	/**
	 * @return the termenValabilitate
	 */
	public Date getTermenValabilitate() {
		return termenValabilitate;
	}
	/**
	 * @param termenValabilitate the termenValabilitate to set
	 */
	public void setTermenValabilitate(Date termenValabilitate) {
		this.termenValabilitate = termenValabilitate;
	}
	
	public Produs(Integer idProdus, String denumire, String unitateMasura,
			Date dataFabricatie, Date termenValabilitate, Float pretProdus) {
		super();
		this.idProdus = idProdus;
		this.denumire = denumire;
		this.unitateMasura = unitateMasura;
		this.dataFabricatie = dataFabricatie;
		this.termenValabilitate = termenValabilitate;
		this.pretProdus = pretProdus;
	}
	/**
	 * @return the pretProdus
	 */
	public Float getPretProdus() {
		return pretProdus;
	}
	/**
	 * @param pretProdus the pretProdus to set
	 */
	public void setPretProdus(Float pretProdus) {
		this.pretProdus = pretProdus;
	}
	public Produs() {
		super();
	}
	
	
}

package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.util.Date;

import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.personal.Angajat;


/**
 * @author Isabela
 *
 */
public class BiletOrdine extends FinanciarIncasari implements Serializable {


	private static final long serialVersionUID = 1L;
	

	private String seriaBilet;
	private Integer numarBilet;
	private Date dataScadenta;
	
	
	public String getSeriaBilet() {
		return seriaBilet;
	}
	public void setSeriaBilet(String seriaBilet) {
		this.seriaBilet = seriaBilet;
	}
	public Integer getNumarBilet() {
		return numarBilet;
	}
	public void setNumarBilet(Integer numarBilet) {
		this.numarBilet = numarBilet;
	}
	public Date getDataScadenta() {
		return dataScadenta;
	}
	public void setDataScadenta(Date dataScadenta) {
		this.dataScadenta = dataScadenta;
	}
	public BiletOrdine(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar,
			String seriaBilet, Integer numarBilet, Date dataScadenta) {
		super(localitate, dataEmiterii, suma, moneda, sumaLitere, contBancar);
		this.seriaBilet = seriaBilet;
		this.numarBilet = numarBilet;
		this.dataScadenta = dataScadenta;
	}
	public BiletOrdine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BiletOrdine(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar, Angajat angajat, Persoana persoana) {
		super(localitate, dataEmiterii, suma, moneda, sumaLitere, contBancar);
		// TODO Auto-generated constructor stub
	}
	
	
}

package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Isabela
 *
 */
public class OrdinDePlata extends FinanciarIncasari implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer numarOrdinPlata;
	//CF = cod identificare fiscala  
	private String CF;
	
	public Integer getNumarOrdinPlata() {
		return numarOrdinPlata;
	}
	public void setNumarOrdinPlata(Integer numarOrdinPlata) {
		this.numarOrdinPlata = numarOrdinPlata;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public OrdinDePlata(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar,
			Integer numarOrdinPlata, String cF) {
		super(localitate, dataEmiterii, suma, moneda, sumaLitere, contBancar);
		this.numarOrdinPlata = numarOrdinPlata;
		CF = cF;
	}
	public OrdinDePlata() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdinDePlata(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar) {
		super(localitate, dataEmiterii, suma, moneda, sumaLitere, contBancar);
		// TODO Auto-generated constructor stub
	}
	
	
	

}

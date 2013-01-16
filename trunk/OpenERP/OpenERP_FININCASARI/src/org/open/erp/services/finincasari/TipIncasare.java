package org.open.erp.services.finincasari;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @author Isabela
 *
 */

@Entity
public class TipIncasare  extends FinanciarIncasari implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Boolean avans;
	//public Boolean furnizor;
	public static Boolean casa;
	public static Boolean getAvans() {
		return avans;
	}

	public static void setAvans(Boolean avans) {
		TipIncasare.avans = avans;
	}

	public static Boolean getCasa() {
		return casa;
	}

	public static void setCasa(Boolean casa) {
		TipIncasare.casa = casa;
	}

	private Boolean banca;
	
	public TipIncasare(Boolean banca) {
		super();
		this.setBanca(banca);
	}

	public TipIncasare() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boolean getBanca() {
		return banca;
	}

	public void setBanca(Boolean banca) {
		this.banca = banca;
	}
	
	
}

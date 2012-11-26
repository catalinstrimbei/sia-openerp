package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.util.Date;

import org.open.erp.services.personal.Angajat;

public class Chitanta extends FinanciarIncasari implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Angajat angajat;

	public Angajat getAngajat() {
		return angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}

	public Chitanta(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar, Angajat angajat) {
		super(localitate, dataEmiterii, suma, moneda, sumaLitere, contBancar);
		this.angajat = angajat;
	}

	public Chitanta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chitanta(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar) {
		super(localitate, dataEmiterii, suma, moneda, sumaLitere, contBancar);
		// TODO Auto-generated constructor stub
	}
	
	

}

package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.vanzari.Facturi;

/**
 * @author Isabela
 *
 */
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
			String moneda, String sumaLitere, Angajat angajat) {
		super(localitate, dataEmiterii, suma, moneda, sumaLitere);
		this.angajat = angajat;
	}

	public Chitanta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chitanta(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere) {
		super(localitate, dataEmiterii, suma, moneda, sumaLitere);
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<Facturi> getFactura() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

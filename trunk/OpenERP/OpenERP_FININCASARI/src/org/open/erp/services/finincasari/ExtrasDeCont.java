package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * @author Isabela
 *
 */


@Entity
public class ExtrasDeCont extends FinanciarIncasari implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExtrasDeCont() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExtrasDeCont(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere) {
		super(localitate, dataEmiterii, suma, moneda, sumaLitere);
		// TODO Auto-generated constructor stub
	}
	
	

}

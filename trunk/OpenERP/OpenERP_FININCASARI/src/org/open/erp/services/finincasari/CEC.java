package org.open.erp.services.finincasari;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Isabela
 *
 */
public class CEC extends FinanciarIncasari implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CEC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CEC(String localitate, Date dataEmiterii, Double suma,
			String moneda, String sumaLitere, String contBancar) {
		super(localitate, dataEmiterii, suma, moneda, sumaLitere, contBancar);
		// TODO Auto-generated constructor stub
	}

	
	

}

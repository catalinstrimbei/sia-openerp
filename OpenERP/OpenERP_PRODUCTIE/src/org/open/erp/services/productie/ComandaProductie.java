package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.Date;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nommat.Produs;

public class ComandaProductie extends Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Document idComanda;
	Produs produs;
	Integer cantitate;
	Date dataComanda;
	
	
}

package org.open.erp.services.vanzari.exceptions;

/*
 * @author Irina Bogdan
 */

public class ValoareNegativa extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ValoareNegativa(){}
	public ValoareNegativa(String msg){
		super(msg);
	}
}

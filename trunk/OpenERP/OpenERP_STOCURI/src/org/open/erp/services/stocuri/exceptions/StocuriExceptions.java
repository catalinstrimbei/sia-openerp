package org.open.erp.services.stocuri.exceptions;


import org.open.erp.services.stocuri.util.StocuriLogger;

public class StocuriExceptions extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static StocuriLogger logger = new StocuriLogger();

	public StocuriExceptions() {
			}
	
	public StocuriExceptions(String message, Throwable cause) {
		super(message, cause);
	
	}

	public StocuriExceptions(String message) {
		super(message);
		
	}
		
	

}

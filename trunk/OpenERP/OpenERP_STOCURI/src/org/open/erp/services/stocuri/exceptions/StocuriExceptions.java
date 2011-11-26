package org.open.erp.services.stocuri.exceptions;

import org.apache.log4j.Level;
import org.open.erp.services.stocuri.util.StocuriLogger;

public class StocuriExceptions extends Exception {
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

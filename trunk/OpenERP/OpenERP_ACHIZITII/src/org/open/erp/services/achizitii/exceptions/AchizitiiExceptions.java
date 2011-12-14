package org.open.erp.services.achizitii.exceptions;




public class AchizitiiExceptions extends Exception{

	private static final long serialVersionUID = 1L;	
	//private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AchizitiiExceptions.class.getName());

	public AchizitiiExceptions() {
		
			}
	
	public AchizitiiExceptions(String message, Throwable cause) {
		super(message, cause);
	
	}

	public AchizitiiExceptions(String message) {
		super(message);
		
	}
	
}

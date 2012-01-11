package org.open.erp.services.personal.logger;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class PersonalExceptions extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static PersonalLogger logger = new PersonalLogger();
	
	public PersonalExceptions() {
		super();
	}
	public PersonalExceptions(String arg0, Throwable arg1) {
		super(arg0, arg1);		
	}
	public PersonalExceptions(String arg0) {
		super(arg0);		
	}
	public PersonalExceptions(Throwable arg0) {
		super(arg0);		
	}
	
	
	
	
}

package org.open.erp.services.personal.logger;


public class PersonalExceptions extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static PersonalLogger logger = new PersonalLogger();
	
	public PersonalExceptions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonalExceptions(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	public PersonalExceptions(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	public PersonalExceptions(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
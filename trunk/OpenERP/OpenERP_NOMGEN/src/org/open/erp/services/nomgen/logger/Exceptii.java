package org.open.erp.services.nomgen.logger;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class Exceptii extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static NomgenLogger logger = new NomgenLogger();
	
	public Exceptii() {
		super();
	}
	public Exceptii(String arg0, Throwable arg1) {
		super(arg0, arg1);	
	}
	public Exceptii(String arg0) {
		super(arg0);
	}
	public Exceptii(Throwable arg0) {
		super(arg0);
	}
	
	
	
	
}

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
		// TODO Auto-generated constructor stub
	}
	public Exceptii(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	public Exceptii(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	public Exceptii(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

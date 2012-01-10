package org.open.erp.services.contabgest.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class CentruCostInvalidException  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CentruCostInvalidException(String exceptionMessage) {
		super(exceptionMessage);
	}
}

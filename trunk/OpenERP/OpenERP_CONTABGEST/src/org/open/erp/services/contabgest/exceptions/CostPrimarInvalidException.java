package org.open.erp.services.contabgest.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class CostPrimarInvalidException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CostPrimarInvalidException(String exceptionMessage) {
		super(exceptionMessage);
	}
}

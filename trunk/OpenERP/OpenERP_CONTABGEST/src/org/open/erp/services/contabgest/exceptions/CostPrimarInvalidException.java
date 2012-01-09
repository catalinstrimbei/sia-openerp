package org.open.erp.services.contabgest.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class CostPrimarInvalidException extends Exception{
	public CostPrimarInvalidException(String exceptionMessage) {
		super(exceptionMessage);
	}
}

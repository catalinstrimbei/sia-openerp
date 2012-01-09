package org.open.erp.services.contabgest.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class CentruCostInvalidException  extends Exception{
	public CentruCostInvalidException(String exceptionMessage) {
		super(exceptionMessage);
	}
}

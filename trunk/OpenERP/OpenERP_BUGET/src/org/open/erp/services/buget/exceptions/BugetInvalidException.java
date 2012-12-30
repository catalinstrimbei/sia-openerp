package org.open.erp.services.buget.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class BugetInvalidException extends Exception {

	public BugetInvalidException(String exceptionMessage) {
		super(exceptionMessage);
	}

}

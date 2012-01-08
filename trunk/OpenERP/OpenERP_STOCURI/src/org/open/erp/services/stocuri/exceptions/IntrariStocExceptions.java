package org.open.erp.services.stocuri.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class IntrariStocExceptions extends StocuriExceptions {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntrariStocExceptions(String message) {
		super(message);

	}

	public IntrariStocExceptions(String message, Throwable cause) {
		super(message, cause);

	}

}

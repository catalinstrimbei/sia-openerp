package org.open.erp.services.stocuri.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class IesiriStocExceptions extends StocuriExceptions {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IesiriStocExceptions(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IesiriStocExceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}

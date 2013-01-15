package org.open.erp.exceptii;

import javax.ejb.ApplicationException;


@ApplicationException(rollback=true)
public class ExceptieGenerica extends Exception {
	protected CodEroare cod;

	public ExceptieGenerica() {
		super();
		cod = CodEroare.NECUNOSCUT;
	}

	public ExceptieGenerica(CodEroare cod) {
		super();
		this.cod = cod;
	}

	public ExceptieGenerica(String message) {
		super(message);
		cod = CodEroare.NECUNOSCUT;
	}

	@Override
	public String getMessage() {
		return "Eroare!!!!!!!!"+cod;
	}

}

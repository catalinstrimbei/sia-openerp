package org.open.erp.exceptii;

public class ExceptieGenerica extends Exception {
	protected CodEroare cod;

	public ExceptieGenerica() {
		super();
		cod = CodEroare.NECUNOSCUT;
	}

	public ExceptieGenerica(CodEroare cod) {
		super();
		cod = cod;
	}

	public ExceptieGenerica(String message) {
		super(message);
		cod = CodEroare.NECUNOSCUT;
	}

	@Override
	public String getMessage() {
		return cod.mesaj();
	}

}

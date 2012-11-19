package org.open.erp.services.finplati;

public enum ModPlata {
	CASH("Cash"), VIRAMENTBANCAR("Virament Bancar"), CEC("Cec");
	private String value;

	ModPlata(String value) {
		this.value = value;
	}

	public String toValue() {
		return value;
	}
}

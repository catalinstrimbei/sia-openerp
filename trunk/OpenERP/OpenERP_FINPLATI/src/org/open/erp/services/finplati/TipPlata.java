package org.open.erp.services.finplati;

public enum TipPlata {
	FURNIZOR("Furnizor"), DATORIE("Datorie"), ALTTIP("Alt tip");
	private String value;

	TipPlata(String value) {
		this.value = value;
	}

	public String toValue() {
		return value;
	}
}

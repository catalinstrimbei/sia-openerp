package org.open.erp.services.finplati;

public enum StatusContract {
	SEMNAT("Semnat"), AMANAT("Amanat"), ONORAT("Onorat"), NEACHITAT("Neachitat"), ACHITATAV("Achitat avans"), ANULAT("Anulat");
	private String value;

	StatusContract(String value) {
		this.value = value;
	}

	public String toValue() {
		return value;
	}
}

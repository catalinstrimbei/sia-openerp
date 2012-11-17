package org.open.erp.services.marketing.impl;

public enum TipPromovare {

	RECLAMA("Reclama"), PROMOTIE("Promotie"), FLYERE("Flyere");

	private String value;

	TipPromovare(String value) {
		this.value = value;
	}

	public String toValue() {
		return value;
	}

}

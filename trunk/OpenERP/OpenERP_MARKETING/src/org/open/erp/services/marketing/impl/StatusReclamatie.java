package org.open.erp.services.marketing.impl;

public enum StatusReclamatie {
	
	NOU("Nou"), IN_ASTEPTARE("In asteptare"), REZOLVAT("Rezolvat");

	private String value;
	
	StatusReclamatie(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.getValue();
	}


}

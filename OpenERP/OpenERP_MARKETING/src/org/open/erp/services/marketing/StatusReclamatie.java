package org.open.erp.services.marketing;

public enum StatusReclamatie {
	NOU("Nou"), IN_ASTEPTARE("In asteptare"), REZOLVAT("Rezolvat");
	private String value;
	
	StatusReclamatie(String value) {
        this.value = value;
    }
	
	public String toValue() {
		return value;
	}
}

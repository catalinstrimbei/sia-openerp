package org.open.erp.services.finplati;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//nu se adnoteaza Enum
//@Entity
public enum ModPlata {
	//@Id
	//@GeneratedValue
	CASH("Cash"), VIRAMENTBANCAR("Virament Bancar"), CEC("Cec");
	private String value;

	ModPlata(String value) {
		this.value = value;
	}

	public String toValue() {
		return value;
	}
}

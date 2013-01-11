package org.open.erp.services.finplati;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public enum TipPlata {
	//@Id
	//@GeneratedValue
	FURNIZOR("Furnizor"), DATORIE("Datorie"), ALTTIP("Alt tip");
	private String value;

	TipPlata(String value) {
		this.value = value;
	}

	public String toValue() {
		return value;
	}
}

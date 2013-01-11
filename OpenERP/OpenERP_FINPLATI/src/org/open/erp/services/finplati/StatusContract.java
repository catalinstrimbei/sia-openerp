package org.open.erp.services.finplati;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public enum StatusContract implements Serializable {
	//@Id
	//@GeneratedValue
	SEMNAT("Semnat"), AMANAT("Amanat"), ONORAT("Onorat"), NEACHITAT("Neachitat"), ACHITATAV("Achitat avans"), ANULAT("Anulat");
	private String value;

	StatusContract(String value) {
		this.value = value;
	}

	public String toValue() {
		return value;
	}
}

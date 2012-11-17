package org.open.erp.services.marketing.impl;

public enum CanalDistributie {
	TV("Tv"), RADIO("Radio"), INTERNET("Internet"), PRESA_SCRISA("Presa scrisa");

	private String value;
	
	CanalDistributie(String value) {
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

package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String idClient;
	
	private Double soldCurent = 0.00;

	public Double getSoldCurent() {
		return soldCurent;
	}

	public void setSoldCurent(Double soldCurent) {
		this.soldCurent = soldCurent;
	}

	private List<FacturaVanzare> facturi = new ArrayList<FacturaVanzare>(0);

	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

	public List<FacturaVanzare> getFacturi() {
		return facturi;
	}

	public void setFacturi(List<FacturaVanzare> facturi) {
		this.facturi = facturi;
	}

	public Client(String idClient, List<FacturaVanzare> facturi) {
		super();
		this.idClient = idClient;
		this.facturi = facturi;
	}

	public Client() {
		super();
	}

}

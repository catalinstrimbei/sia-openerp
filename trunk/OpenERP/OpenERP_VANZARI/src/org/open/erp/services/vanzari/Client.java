package org.open.erp.services.vanzari;

/*
 * @author Irina Bogdan
 * 
 * @BusinessObject(DummyEntity)
 */

import org.open.erp.services.nomgen.Partener;

public class Client extends Partener {
	//Integer idClient;
	String nume;
	//String adresa;
	String adresaEmail;
	String telefon;
	String cod; // BI/CI/CUI
	Double soldClient;
	
	public Client(){}

	public boolean addClient(){
		// set client data in DB
		return true;
	}
	
	public boolean updateDateClient(){
		// modify client data in DB
		return true;
	}
	
	public boolean stergeClient(){
		// remove client from DB
		return true;
	}
	
	public static Client cautaClientByEmail(String email){
		// search Client in DB
		return new Client();
	}
	
	public static Client cautaClientByNume(String nume){
		//search Client in DB by firstname / lastname
		return new Client();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAdresaEmail() {
		return adresaEmail;
	}

	public void setAdresaEmail(String adresaEmail) {
		this.adresaEmail = adresaEmail;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Double getSoldClient() {
		return soldClient;
	}

	public void setSoldClient(Double soldClient) {
		this.soldClient = soldClient;
	}	
	
}

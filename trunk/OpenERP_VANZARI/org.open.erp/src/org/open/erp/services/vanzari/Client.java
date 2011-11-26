package org.open.erp.services.vanzari;

/*
 * @author Irina Bogdan
 * 
 * @BusinessObject(DummyEntity)
 */

import java.util.Date;

public class Client {
	Integer idClient;
	String nume;
	String prenume;
	String adresa;
	String adresaEmail;
	Date dataNastere;
	
	public Client(){}
	
	public Client(Integer _idClient){
		this.idClient = _idClient;
	}
	
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

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getAdresaEmail() {
		return adresaEmail;
	}

	public void setAdresaEmail(String adresaEmail) {
		this.adresaEmail = adresaEmail;
	}

	public Date getDataNastere() {
		return dataNastere;
	}

	public void setDataNastere(Date dataNastere) {
		this.dataNastere = dataNastere;
	}
	
	
}

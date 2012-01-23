package org.open.erp.services.vanzari;

/**
 * @author Irina Bogdan
 * 
 * @BusinessObject(Entity)
 */

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Client implements Serializable {
	@Id @GeneratedValue
	Integer idClient;
	String nume;
	String adresa;
	String adresaEmail;
	String telefon;
	String codUnic; // BI/CI/CUI
	Double soldClient;
	
	public Client(){ super(); }
	
	public Client(Integer _id, String _nume,  String _adresaEmail, String _telefon, String _codUnic, Double _soldClient){
		this.idClient = _id;
		this.nume = _nume;
		this.adresaEmail = _adresaEmail;
		this.telefon = _telefon;
		this.codUnic = _codUnic;
		this.soldClient = _soldClient;
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

	public String getCodUnic() {
		return codUnic;
	}

	public void setCodUnic(String codUnic) {
		this.codUnic = codUnic;
	}

	public Double getSoldClient() {
		return soldClient;
	}

	public void setSoldClient(Double soldClient) {
		this.soldClient = soldClient;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
}

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
	String adresa;
	String adresaEmail;
	String telefon;
	String codUnic; // BI/CI/CUI
	Double soldClient;
	
	public Client(){ super(); }
	
	public Client(Integer _id, Integer _idPersoana , Integer _durataAfilierii, String _nume,  String _adresaEmail, String _telefon, String _codUnic, Double _soldClient){
		super(_id, _idPersoana, _durataAfilierii);
		this.nume = _nume;
		this.adresaEmail = _adresaEmail;
		this.telefon = _telefon;
		this.codUnic = _codUnic;
		this.soldClient = _soldClient;
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
		return new Client(1, 1, 2, "Gigel", email, "0987654321", "CT123456", 0.0);
	}
	
	public static Client cautaClientByNume(String nume){
		//search Client in DB by firstname / lastname
		return new Client(1, 1, 2, nume, nume+"@yahoo.com", "0987654321", "CT123456", 0.0);
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

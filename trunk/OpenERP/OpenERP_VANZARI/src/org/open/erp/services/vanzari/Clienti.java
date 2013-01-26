package org.open.erp.services.vanzari;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Clienti {
	@Id @GeneratedValue
	Integer idClient;
	
	@OneToOne(targetEntity = org.open.erp.services.vanzari.Persoana.class)
	Persoana persoana;
	String categorie;
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	public Persoana getPersoana() {
		return persoana;
	}
	public void setPersoana(Persoana persoana) {
		this.persoana = persoana;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Clienti(Integer idClient, Persoana persoana, String categorie) {
		super();
		this.idClient = idClient;
		this.persoana = persoana;
		this.categorie = categorie;
	}
	public Clienti() {
		super();
	}
	
	
	

}

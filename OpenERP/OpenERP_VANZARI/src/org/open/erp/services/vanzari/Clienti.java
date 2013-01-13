package org.open.erp.services.vanzari;

import javax.persistence.Entity;

import org.open.erp.services.nomgen.Persoana;

import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.Id;

@Entity
public class Clienti {
	@Id @GeneratedValue
	Integer idClient;
	@OneToOne(targetEntity = org.open.erp.services.nomgen.Persoana.class)
	Persoana persoana;
	String categorie;
	
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

	public Clienti(Persoana persoana, String categorie) {
		super();
		this.persoana = persoana;
		this.categorie = categorie;
	}

	public Clienti() {
		super();
	}
	
	

}

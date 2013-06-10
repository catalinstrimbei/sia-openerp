package org.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Comanda implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	
	// Atribute private
	//@Id
	private Long id;
	
	@Temporal(DATE)
	private String dataComanda;

	@OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL)
	private List<LinieComanda> comenzi = new ArrayList<LinieComanda>();
	
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;
	
	// Constructori
	public Comanda(Long id, String dataComanda, Client client) {
		this.id = id;
		this.dataComanda = dataComanda;
		this.client = client;
	}	
	public Comanda(Long id, String dataComanda, List<LinieComanda> comenzi,
			Client client) {
		this.id = id;
		this.dataComanda = dataComanda;
		this.comenzi = comenzi;
	this.client = client;
	}
	public Comanda() {
	}
	
	// Getteri si setteri
	
public Client getClient() {
	return client;
	}
public void setClient(Client client) {
	this.client = client;
}	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDataComanda() {
		return dataComanda;
	}
	public void setDataComanda(String dataComanda) {
		this.dataComanda = dataComanda;
	}
	public List<LinieComanda> getComenzi() {
		return comenzi;
	}
	public void setComenzi(List<LinieComanda> comenzi) {
		this.comenzi = comenzi;
	}
	public Double getValoareComanda(){
		if (comenzi.isEmpty())
			return null;
		
		Double valoare = 0.0;
		for (LinieComanda articol: comenzi){
			valoare = valoare + articol.getValoareProdus();
		}
		
		return valoare;
	}
	
	// Criteriu de egalitate
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comanda other = (Comanda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	// Operatii specifice logicii modelului afacerii 
	
	public void adauga(Produs produs, Double cantitate){
		LinieComanda articol = new LinieComanda();
		articol.setComanda(this);
		articol.setProdus(produs);
		articol.setCantitate(cantitate);
		this.comenzi.add(articol);
	}
	
	public Boolean verificaProdus(Produs produs){
		return null;
	}
	
	public LinieComanda getLinieComanda(Produs produs){
		return null;
	}
	
	public Double getValoareComandataProdus(Produs produs){
		return null;
	}
	
	@Override
	public String toString() {
		return "Comanda id:" + id + ", dataComanda:" + dataComanda 
				 + "," 
			+ client + ", valoare comanda:"
				+ getValoareComanda();
	}	
	
	
}

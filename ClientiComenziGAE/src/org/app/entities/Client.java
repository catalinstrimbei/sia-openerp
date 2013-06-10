package org.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	//@Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@PrimaryKey
//    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")	
    private String idClient;
	
    private String denumireClient;
    private String codFiscal;
    private String numeJudet;
    private String numeLocalitate;
    private String strada;
    private String codPostal;
    private String telefon;
    private String fax;
    private String email;
    
    @OneToMany(mappedBy="client")
    private List<Comanda> comenzi = new ArrayList<>();
    
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public String getDenumireClient() {
		return denumireClient;
	}
	public void setDenumireClient(String denumireClient) {
		this.denumireClient = denumireClient;
	}
	public String getCodFiscal() {
		return codFiscal;
	}
	public void setCodFiscal(String codFiscal) {
		this.codFiscal = codFiscal;
	}
	public String getNumeJudet() {
		return numeJudet;
	}
	public void setNumeJudet(String numeJudet) {
		this.numeJudet = numeJudet;
	}
	public String getNumeLocalitate() {
		return numeLocalitate;
	}
	public void setNumeLocalitate(String numeLocalitate) {
		this.numeLocalitate = numeLocalitate;
	}
	public String getStrada() {
		return strada;
	}
	public void setStrada(String strada) {
		this.strada = strada;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idClient == null) ? 0 : idClient.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		return true;
	}
	public Client(String idClient, String denumireClient, String codFiscal,
			String numeJudet, String numeLocalitate, String strada,
			String codPostal, String telefon, String fax, String email) {
		super();
		this.idClient = idClient;
		this.denumireClient = denumireClient;
		this.codFiscal = codFiscal;
		this.numeJudet = numeJudet;
		this.numeLocalitate = numeLocalitate;
		this.strada = strada;
		this.codPostal = codPostal;
		this.telefon = telefon;
		this.fax = fax;
		this.email = email;
	}
	public Client() {
		super();
	} 
    
    }
    
	
	
	
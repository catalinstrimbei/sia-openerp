package org.open.erp.services.vanzari;

/**
 * @author Irina Bogdan
 * 
 * @BusinessObject(Entity)
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.ALL;

import org.open.erp.services.vanzari.exceptions.ValoareNegativa;

@Entity
public class Comanda implements Serializable {
	public static final char PENDING = 'P';
	public static final char COMPLETED = 'C';
	public static final char CANCELED = 'X';
	
	@Id @GeneratedValue
	Integer nrComanda;
	Date dataComanada;
	Client client;
	Double valoareComanda;
	Double tvaComanada;
	//Double discountTotal;
	//Double reduceriTotale;
	char stareComanda; // P, C, X
	
	@OneToMany(targetEntity=LinieComanda.class, cascade=ALL)
	ArrayList<LinieComanda> produseComandate;
	// !!!!!!!!!!
	Integer idMetodaPlata;
	Integer idModalitateLivrare;
	Double costLivrare;
	String adresaLivrare;
	
	public Comanda(){
		this.produseComandate = new ArrayList<LinieComanda>();
	}
	
	public Comanda(Integer _nrComanda){
		this.nrComanda = _nrComanda;
		this.produseComandate = new ArrayList<LinieComanda>();
	}
	
	public Comanda(Integer _nrComanda, Date _dataComanda, Client _client, char _stareComanda){
		this.nrComanda = _nrComanda;
		this.dataComanada = _dataComanda;
		this.client = _client;
		this.stareComanda = _stareComanda;
		this.produseComandate = new ArrayList<LinieComanda>();
	}
	
	public static Comanda gasesteComanda(Integer nrComanda){
		// find in DB order with a specified orderNo
		return new Comanda(nrComanda);
		//return null; <- if comanda not found 
	}
	
	public Double calculeazaTvaComanda() throws ValoareNegativa{
		Iterator<LinieComanda> iterator = this.produseComandate.iterator();
		Double tvaComanada = 0.0; 
		while(iterator.hasNext()){
			LinieComanda produs = iterator.next();
			tvaComanada += produs.getTvaLinie();
		}
		return tvaComanada;
	}
	
	public Double calculeazaValoareFaraDiscount() throws ValoareNegativa{
		Iterator<LinieComanda> iterator = this.produseComandate.iterator();
		Double suma = 0.0;
		while(iterator.hasNext()){
			LinieComanda produs = iterator.next();
			suma += produs.getValoareLinieFaraTVA(); 
		}
		return suma;
	}
				
	public Double getValoareComanda() {
		return valoareComanda;
	}

	public void setValoareComanda(Double valoareComanda) {
		this.valoareComanda = valoareComanda;
	}

	public Double getTvaComanada() {
		return tvaComanada;
	}

	public void setTvaComanada(Double tvaComanada) {
		this.tvaComanada = tvaComanada;
	}

	public Integer getNrComanda() {
		return nrComanda;
	}
	public void setNrComanda(Integer nrComanda) {
		this.nrComanda = nrComanda;
	}
	public Date getData() {
		return dataComanada;
	}
	public void setData(Date data) {
		this.dataComanada = data;
	}
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public char getStareComanda() {
		return stareComanda;
	}
	public void setStareComanda(char stareComanda) {
		this.stareComanda = stareComanda;
	}

	public Date getDataComanada() {
		return dataComanada;
	}

	public void setDataComanada(Date dataComanada) {
		this.dataComanada = dataComanada;
	}

	public Integer getIdMetodaPlata() {
		return idMetodaPlata;
	}

	public void setIdMetodaPlata(Integer idMetodaPlata) {
		this.idMetodaPlata = idMetodaPlata;
	}

	public Integer getIdModalitateLivrare() {
		return idModalitateLivrare;
	}

	public void setIdModalitateLivrare(Integer idModalitateLivrare) {
		this.idModalitateLivrare = idModalitateLivrare;
	}

	public Double getCostLivrare() {
		return costLivrare;
	}

	public void setCostLivrare(Double costLivrare) {
		this.costLivrare = costLivrare;
	}

	public String getAdresaLivrare() {
		return adresaLivrare;
	}

	public void setAdresaLivrare(String adresaLivrare) {
		this.adresaLivrare = adresaLivrare;
	}

	public ArrayList<LinieComanda> getProduseComandate() {
		return produseComandate;
	}

	public void setProduseComandate(ArrayList<LinieComanda> produseComandate) {
		this.produseComandate = produseComandate;
	}
	
	
}

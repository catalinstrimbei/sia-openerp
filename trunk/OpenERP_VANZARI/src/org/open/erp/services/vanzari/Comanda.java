package org.open.erp.services.vanzari;

/*
 * @author Irina Bogdan
 * 
 * @BusinessObject(DummyEntity)
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.open.erp.services.exceptions.ValoareNegativa;
import org.open.erp.services.stocuri.ArticolStoc;
//import org.open.erp.services.vanzari.LinieComanda;

public class Comanda {
	public static final char PENDING = 'P';
	public static final char COMPLETED = 'C';
	public static final char CANCELED = 'X';
	
	Integer nrComanda;
	Date dataComanada;
	Integer idClient;
	//Double valoareComanda;
	//Double tvaComanada;
	//Double discountTotal;
	//Double reduceriTotale;
	char stareComanda; // P, C, X
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
			suma += produs.getValoareLinie(); 
		}
		return suma;
	}
	
	public Double calculeazaReducereTotal() throws ValoareNegativa{
		Iterator<LinieComanda> iterator = this.produseComandate.iterator();
		Double reducere = 0.0;
		while(iterator.hasNext()){
			LinieComanda produs = iterator.next();
			reducere += produs.getValoareRedusa(); 
		}
		return reducere;
	}
	
	public Double calculDiscountComanda() throws ValoareNegativa{
		Double discount = 0.0;
		//Comanda comanda = Comanda.gasesteComanda(nrComanda);
		// preluare discount din BD
		discount = 0.05;
		return  discount * this.calculeazaValoareFaraDiscount();
		//return discount;
	}
	
	public Double calculeazaValoareCuDiscount() throws ValoareNegativa{
		return (this.calculeazaValoareFaraDiscount() - this.calculDiscountComanda());
	}
	
	// Adauga produs nou sau incrementeaza cantitatea daca deja exista
	public boolean addProdusInComanda(String idProd, String idCateg, Float cant){
		LinieComanda produsComandat = this.gasesteProdusComandat(idProd);
		if( produsComandat == null){
			ArticolStoc articol = ArticolStoc.cautaProdusDupaId(idProd);
			if( articol != null){
				LinieComanda produs = new LinieComanda(idProd, idCateg, cant);
				//produs.preluareProprietati();
				produs.numeProdus = articol.getNumeProdus();
				produs.pretUnitar = articol.getPretUnitar();
				produs.procentTva =articol.getProcentTva();
				produs.preluareReducere();
				return this.produseComandate.add(produs);
			} else
				return false;
		}
		else{
			System.out.println("cantitate modif");
			float cant_ = produsComandat.getCantitate() + cant;
			System.out.println(cant_);
			return produsComandat.setCantitate(cant_);
		}
		
	}
	
	public LinieComanda gasesteProdusComandat(String idProd){
		LinieComanda produsComandat = null;
		if( !this.produseComandate.isEmpty()){
			Iterator<LinieComanda> iterator = this.produseComandate.iterator();
			while(produsComandat == null && iterator.hasNext()){
				LinieComanda linie = iterator.next();
				if( linie.getIdProdus().equalsIgnoreCase(idProd)){
					produsComandat = linie;
					//System.out.println("gasesteProdusComandat " + produsComandat.getNumeProdus());
				}
			}
		}
		//System.out.println(produsComandat.toString());
		return produsComandat;
	}
	
	public boolean removeProdusDinComanda(String idProd){
		LinieComanda produsComandat = this.gasesteProdusComandat(idProd);
		if( produsComandat == null)
			return false;
		else
			return this.produseComandate.remove(produsComandat);
	}
	
	// update produs din comanda
	 public boolean updateProdusDinComanda(String idProd, float cant){
		 // de rezolvat
		 return true;
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
	
	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
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
}

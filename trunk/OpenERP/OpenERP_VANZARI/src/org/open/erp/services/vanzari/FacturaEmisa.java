package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.open.erp.services.nomgen.Document;

/*
 * @author Irina Bogdan
 * 
 * @BusinessObject(DummyEntity)
 */

public class FacturaEmisa extends Document {
	public static final Boolean PLATITA = true;
	public static final Boolean NEPLATITA = false;
	
	public static final Integer ZILE_RETUR = 20;
	
	Integer idFactura;
	//Date dataFacturare;		
	Double valoareTotalaFactura;
	Double valoareTva;
	Boolean platita; /* factura platita sau nu */
	String adresaFacturare;
	Date dataLivrare;
	
	Integer nrComanda;
	Client client;
	ArrayList<LinieFacturaEmisa> produseFacturate;
	Vanzator vanzator;
	
	Integer idMetodaPlata;
	Integer idModalitateLivrare;
	Double costLivrare;
	String adresaLivrare;
	
	Double sumaIncasata;
	
	public FacturaEmisa(){
		this.valoareTotalaFactura = 0.0;
		this.valoareTva = 0.0;
	}
	
	FacturaEmisa(Integer _idFactura){
		this.valoareTotalaFactura = 0.0;
		this.valoareTva = 0.0;
		this.idFactura = _idFactura;
	}
	
	public FacturaEmisa(Integer _idFactura, Client _client, Vanzator _vanzator, Boolean _platita){
		this.idFactura = _idFactura;
		this.valoareTotalaFactura = 0.0;
		this.valoareTva = 0.0;
		this.client = _client;
		this.vanzator = _vanzator;
		this.platita = _platita;
		
	}
	
	public static FacturaEmisa gasesteFactura(Integer idFactura){
		// find in DB invoice with a specified orderNo
		return new FacturaEmisa(idFactura);
		//return null; <- if invoice not found 
	}
	
	public void calculeazaTvaFactura(){
		Iterator<LinieFacturaEmisa> iterator = this.produseFacturate.iterator();
		Double tva = 0.0; 
		while(iterator.hasNext()){
			LinieFacturaEmisa produs = iterator.next();
			tva += produs.getTvaLinie();
		}
		this.valoareTva = tva;
	}
	
	public void calculeazaValoareFactura(){ // fara TVA
		Iterator<LinieFacturaEmisa> iterator = this.produseFacturate.iterator();
		Double valoare = 0.0;
		while(iterator.hasNext()){
			LinieFacturaEmisa produs = iterator.next();
			valoare += produs.getPretLinie();
		}
		this.valoareTotalaFactura = valoare;
	}
	
	public boolean isReturnable(){
		boolean platit = this.facturaPlatita();
		boolean livrat = this.facturaLivrata();
		if( platit && livrat && (this.nrZileDeLaLivrare() <= FacturaEmisa.ZILE_RETUR))
			return true;
		else
			return false;
	}
	
	public boolean facturaPlatita(){
		// get from bd
		return true;
	}
	
	public boolean facturaLivrata(){
		// get from bd
		return true;		
	}
	
	public Integer nrZileDeLaLivrare(){
		// get from db ...
		return 10;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Double getValoareTotalaFactura() {
		return valoareTotalaFactura;
	}

	public void setValoareTotalaFactura(Double valoareTotalaFactura) {
		this.valoareTotalaFactura = valoareTotalaFactura;
	}

	public Double getValoareTva() {
		return valoareTva;
	}

	public void setValoareTva(Double valoareTva) {
		this.valoareTva = valoareTva;
	}

	public String getAdresaFacturare() {
		return adresaFacturare;
	}

	public void setAdresaFacturare(String adresaFacturare) {
		this.adresaFacturare = adresaFacturare;
	}

	public Date getDataLivrare() {
		return dataLivrare;
	}

	public void setDataLivrare(Date dataLivrare) {
		this.dataLivrare = dataLivrare;
	}

	public Integer getNrComanda() {
		return nrComanda;
	}

	public void setNrComanda(Integer nrComanda) {
		this.nrComanda = nrComanda;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList<LinieFacturaEmisa> getProduseFacturate() {
		return produseFacturate;
	}

	public void setProduseFacturate(ArrayList<LinieFacturaEmisa> produseFacturate) {
		this.produseFacturate = produseFacturate;
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

	public Vanzator getVanzator() {
		return vanzator;
	}

	public void setVanzator(Vanzator vanzator) {
		this.vanzator = vanzator;
	}

	public Boolean getPlatita() {
		return platita;
	}

	public void setPlatita(Boolean platita) {
		this.platita = platita;
	}

	public Double getSumaIncasata() {
		return sumaIncasata;
	}

	public void setSumaIncasata(Double sumaIncasata) {
		this.sumaIncasata = sumaIncasata;
	}
			
}

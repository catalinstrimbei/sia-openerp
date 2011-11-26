package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/*
 * @author Irina Bogdan
 * 
 * @BusinessObject(DummyEntity)
 */

public class FacturaVanzare {
	public static final Boolean PLATITA = true;
	public static final Boolean NEPLATITA = false;
	
	public static final Integer ZILE_RETUR = 20;
	
	Integer idFactura;
	Date dataFacturare;		
	Double valoareTotalaFactura;
	Double valoareTva;
	Boolean valida; /* factura platita sau nu */
	String adresaFacturare;
	Date dataLivrare;
	
	Integer nrComanda;
	Integer idClient;
	ArrayList<LinieFacturaVanzare> produseFacturate;
	
	Integer idMetodaPlata;
	Integer idModalitateLivrare;
	Double costLivrare;
	String adresaLivrare;
	
	public FacturaVanzare(){
		this.valoareTotalaFactura = 0.0;
		this.valoareTva = 0.0;
	}
	
	public FacturaVanzare(Integer _idFactura){
		this.idFactura = _idFactura;
		this.valoareTotalaFactura = 0.0;
		this.valoareTva = 0.0;
	}
	
	public static FacturaVanzare gasesteFactura(Integer idFactura){
		// find in DB invoice with a specified orderNo
		return new FacturaVanzare(idFactura);
		//return null; <- if invoice not found 
	}
	
	public void calculeazaTvaFactura(){
		Iterator<LinieFacturaVanzare> iterator = this.produseFacturate.iterator();
		Double tva = 0.0; 
		while(iterator.hasNext()){
			LinieFacturaVanzare produs = iterator.next();
			tva += produs.getTvaLinie();
		}
		this.valoareTva = tva;
	}
	
	public void calculeazaValoareFactura(){
		Iterator<LinieFacturaVanzare> iterator = this.produseFacturate.iterator();
		Double valoare = 0.0;
		while(iterator.hasNext()){
			LinieFacturaVanzare produs = iterator.next();
			valoare += produs.getPretLinie();
		}
		this.valoareTotalaFactura = valoare;
	}
	
	public boolean isReturnable(){
		boolean platit = this.facturaPlatita();
		boolean livrat = this.facturaLivrata();
		if( platit && livrat && (this.nrZileDeLaLivrare() <= FacturaVanzare.ZILE_RETUR))
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

	public Date getDataFacturare() {
		return dataFacturare;
	}

	public void setDataFacturare(Date dataFacturare) {
		this.dataFacturare = dataFacturare;
	}

	public Boolean getValida() {
		return valida;
	}

	public void setValida(Boolean valida) {
		this.valida = valida;
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

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public ArrayList<LinieFacturaVanzare> getProduseFacturate() {
		return produseFacturate;
	}

	public void setProduseFacturate(ArrayList<LinieFacturaVanzare> produseFacturate) {
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
			
}

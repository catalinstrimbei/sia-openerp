package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.achizitii.Furnizor;
import org.open.erp.services.plati.LinieFacturaPrimita;

@Entity(name = "FacturaPrimita")
@DiscriminatorValue("FacturaPrimita")
public class FacturaPrimita extends Document implements Serializable{
	public static final Boolean PLATITA = true;
	public static final Boolean NEPLATITA = false;
	
	public static final Integer ZILE_RETUR = 20;
	@Id
	Integer idFactura;
	//Date dataFacturare;		
	Double valoareTotalaFactura;
	Double valoareTva;
	Boolean platita; /* factura platita sau nu */
	String adresaFacturare;
	Date dataLivrare;
	
	Integer nrComanda;
	Furnizor furnizor;
	ArrayList<LinieFacturaPrimita> produseFacturate = new ArrayList<LinieFacturaPrimita>();
	
	Integer idMetodaPlata;
	Integer idModalitateLivrare;
	Double costLivrare;
	String adresaLivrare;
	
	Double sumaPlatita;
	
	public FacturaPrimita(){
		this.valoareTotalaFactura = 0.0;
		this.valoareTva = 0.0;
	}
	
	FacturaPrimita(Integer _idFactura){
		this.valoareTotalaFactura = 0.0;
		this.valoareTva = 0.0;
		this.idFactura = _idFactura;
	}
	
	public FacturaPrimita(Integer _idFactura, Furnizor _furnizor, Boolean _platita){
		this.idFactura = _idFactura;
		this.valoareTotalaFactura = 0.0;
		this.valoareTva = 0.0;
		this.furnizor = _furnizor;
		this.platita = _platita;
		
	}
	
	public static FacturaPrimita gasesteFactura(Integer idFactura){
		// find in DB invoice with a specified orderNo
		return new FacturaPrimita(idFactura);
		//return null; <- if invoice not found 
	}
	
	public void calculeazaTvaFactura(){
		Iterator<LinieFacturaPrimita> iterator = this.produseFacturate.iterator();
		Double tva = 0.0; 
		while(iterator.hasNext()){
			LinieFacturaPrimita produs = iterator.next();
			tva += produs.getTVA();
		}
		this.valoareTva = tva;
	}
	
	public void calculeazaValoareFactura(){ // fara TVA
		Iterator<LinieFacturaPrimita> iterator = this.produseFacturate.iterator();
		Double valoare = 0.0;
		while(iterator.hasNext()){
			LinieFacturaPrimita produs = iterator.next();
			valoare += produs.getPretLinie();
		}
		this.valoareTotalaFactura = valoare;
	}
	
	public boolean isReturnable(){
		boolean platit = this.facturaPlatita();
		boolean livrat = this.facturaLivrata();
		if( platit && livrat && (this.nrZileDeLaLivrare() <= FacturaPrimita.ZILE_RETUR))
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

	public Furnizor getFurnizor() {
		return furnizor;
	}

	public void setFurnizor(Furnizor furnizor) {
		this.furnizor = furnizor;
	}

	public ArrayList<LinieFacturaPrimita> getProduseFacturate() {
		return produseFacturate;
	}

	public void setProduseFacturate(ArrayList<LinieFacturaPrimita> produseFacturate) {
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

	public Boolean getPlatita() {
		return platita;
	}

	public void setPlatita(Boolean platita) {
		this.platita = platita;
	}

	public Double getSumaPlatita() {
		return sumaPlatita;
	}

	public void setSumaPlatita(Double sumaPlatita) {
		this.sumaPlatita = sumaPlatita;
	}
			
}
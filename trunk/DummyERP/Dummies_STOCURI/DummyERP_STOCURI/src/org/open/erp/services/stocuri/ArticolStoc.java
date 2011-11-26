package org.open.erp.services.stocuri;

/*
 * @author Irina Bogdan
 */

public class ArticolStoc {
	String idProdus;
	String numeProdus;
	String descriere;
	Float cantitate;
	String unitateMasura;
	Boolean status; // in stoc sau nu
	Double pretUnitar;
	Float procentTva;
	Integer idProducator;
	Integer idFurnizor;
	
	public ArticolStoc(){}
	
	public static String getProductNameById(String idProdus) {
		return "Lapte batut";
	}

	public static Float getProductQuantityById(String idProdus) {
		return (float)100;
	}

	public static Double getProductPriceById(String idProdus) {
		return 3.1;
	}

	public static Double getProductTvaById(String idProdus) {
		return 0.24;
	}
	
	public static boolean actualizeazaStoc(String idProdus){
		return true;
	}
	
	public static ArticolStoc cautaProdusDupaNume(String denumire){
		ArticolStoc produs = new ArticolStoc();
		produs.setNumeProdus(denumire);
		return produs;
	}
	
	public static ArticolStoc cautaProdusDupaId(String idProdus){
		ArticolStoc produs = new ArticolStoc();
		produs.setIdProdus(idProdus);
		produs.setNumeProdus("lapte batut");
		produs.setPretUnitar(3.5);
		produs.setProcentTva((float)0.24);
		return produs;
	}
	
	public String getIdProdus() {
		return idProdus;
	}
	public void setIdProdus(String idProdus) {
		this.idProdus = idProdus;
	}
	public String getNumeProdus() {
		return numeProdus;
	}
	public void setNumeProdus(String numeProdus) {
		this.numeProdus = numeProdus;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public Float getCantitate() {
		return cantitate;
	}
	public void setCantitate(Float cantitate) {
		this.cantitate = cantitate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Double getPretUnitar() {
		return pretUnitar;
	}
	public void setPretUnitar(Double pretUnitar) {
		this.pretUnitar = pretUnitar;
	}
	public Float getProcentTva() {
		return procentTva;
	}
	public void setProcentTva(Float procentTva) {
		this.procentTva = procentTva;
	}
	public Integer getIdProducator() {
		return idProducator;
	}
	public void setIdProducator(Integer idProducator) {
		this.idProducator = idProducator;
	}
	public Integer getIdFurnizor() {
		return idFurnizor;
	}
	public void setIdFurnizor(Integer idFurnizor) {
		this.idFurnizor = idFurnizor;
	}

	public String getUnitateMasura() {
		return unitateMasura;
	}

	public void setUnitateMasura(String unitateMasura) {
		this.unitateMasura = unitateMasura;
	}
	
	
	

}
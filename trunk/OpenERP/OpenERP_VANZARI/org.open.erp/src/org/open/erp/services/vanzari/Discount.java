package org.open.erp.services.vanzari;

import java.util.Date;

/*
 * @author Irina Bogdan
 */

public class Discount {
	Integer idDiscount;
	Integer idClient;
	String denumireDiscount;
	String descriere;
	Double valoareAbsolutaDiscount;
	Double procentDiscount;
	Date dataStart;
	Date dataFinal;
	Boolean statusDiscount; // activ sau nu 
	
	public Discount(){}
	
	public boolean adaugareDiscount(){
		// add current object in DB
		return true;
	}
	
	public boolean modificareDiscount(){
		// 
		return true;
	}
	
	//public static boolean stergeDiscount(Integer idDiscount){
	public boolean stergeDiscount(){
		// delete from DB
		return true;
	}
	
	
	public static Discount getClientDiscounts(Integer idClient){
		// preluare din DB
		return new Discount();
	}
	
	public boolean utilizatDeClient(Integer idClient){
		// check if idDiscount appears in Orders table - where order status = 'C'
		return false;
	}

	public Integer getIdDiscount() {
		return idDiscount;
	}

	public void setIdDiscount(Integer idDiscount) {
		this.idDiscount = idDiscount;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getDenumireDiscount() {
		return denumireDiscount;
	}

	public void setDenumireDiscount(String denumireDiscount) {
		this.denumireDiscount = denumireDiscount;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public Double getValoareAbsolutaDiscount() {
		return valoareAbsolutaDiscount;
	}

	public void setValoareAbsolutaDiscount(Double valoareAbsolutaDiscount) {
		this.valoareAbsolutaDiscount = valoareAbsolutaDiscount;
	}

	public Double getProcentDiscount() {
		return procentDiscount;
	}

	public void setProcentDiscount(Double procentDiscount) {
		this.procentDiscount = procentDiscount;
	}

	public Date getDataStart() {
		return dataStart;
	}

	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Boolean getStatusDiscount() {
		return statusDiscount;
	}

	public void setStatusDiscount(Boolean statusDiscount) {
		this.statusDiscount = statusDiscount;
	}
	
}
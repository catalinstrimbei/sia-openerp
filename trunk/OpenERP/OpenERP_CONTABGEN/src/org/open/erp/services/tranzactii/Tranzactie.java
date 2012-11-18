package org.open.erp.services.tranzactii;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tranzactie {
	
	Integer idTranzactie;
	Date dataTranzactie;
	String tipTranzactie;
	String descriereTranzactie;
	List<Operatiune> operatiuni = new ArrayList<Operatiune>();
	Document document;
	
	public Integer getIdTranzactie() {
		return idTranzactie;
	}
	public void setIdTranzactie(Integer idTranzactie) {
		this.idTranzactie = idTranzactie;
	}
	public Date getDataTranzactie() {
		return dataTranzactie;
	}
	public void setDataTranzactie(Date dataTranzactie) {
		this.dataTranzactie = dataTranzactie;
	}
	public String getTipTranzactie() {
		return tipTranzactie;
	}
	public void setTipTranzactie(String tipTranzactie) {
		this.tipTranzactie = tipTranzactie;
	}
	public String getDescriereTranzactie() {
		return descriereTranzactie;
	}
	public void setDescriereTranzactie(String descriereTranzactie) {
		this.descriereTranzactie = descriereTranzactie;
	}
	public List<Operatiune> getOperatiuni() {
		return operatiuni;
	}
	public void addOperatiune(Operatiune operatiune) {
		this.operatiuni.add(operatiune);
	}
	public void removeOperatiune(Operatiune operatiune) {
		this.operatiuni.remove(operatiune);
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
		
}

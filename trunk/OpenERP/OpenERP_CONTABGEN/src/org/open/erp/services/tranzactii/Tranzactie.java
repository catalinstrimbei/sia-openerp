package org.open.erp.services.tranzactii;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.services.achizitii.Document;

public class Tranzactie {
	
	Integer idTranzactie;
	Date dataTranzactie;
	String tipTranzactie;
	String descriereTranzactie;
	List<OperatiuneContabila> operatiuni = new ArrayList<OperatiuneContabila>();
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
	public List<OperatiuneContabila> getOperatiuni() {
		return operatiuni;
	}
	public void addOperatiune(OperatiuneContabila operatiune) {
		this.operatiuni.add(operatiune);
	}
	public void removeOperatiune(OperatiuneContabila operatiune) {
		this.operatiuni.remove(operatiune);
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
		
}
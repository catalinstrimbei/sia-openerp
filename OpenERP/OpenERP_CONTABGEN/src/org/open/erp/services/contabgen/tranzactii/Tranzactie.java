package org.open.erp.services.contabgen.tranzactii;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.open.erp.services.contabgen.conturi.Document;



@Entity
public class Tranzactie implements Serializable{
	
	@Id
	@GeneratedValue
	Integer idTranzactie;
	@Temporal(TemporalType.TIMESTAMP)
	Date dataTranzactie;
	String tipTranzactie;
	String descriereTranzactie;
	
	List<OperatiuneContabila> operatiuni = new ArrayList<OperatiuneContabila>();
	
	@OneToOne
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

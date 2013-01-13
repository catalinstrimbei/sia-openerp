package org.open.erp.services.contabgen.tranzactii;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.open.erp.services.contabgen.conturi.Document_ContabGen;



@Entity
public class Tranzactie implements Serializable{
	
	@Id
	@GeneratedValue
	Integer idTranzactie;
	@Temporal(TemporalType.TIMESTAMP)
	Date dataTranzactie;
	String tipTranzactie;
	String descriereTranzactie;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<OperatiuneContabila> operatiuni = new ArrayList<OperatiuneContabila>();
	
	@OneToOne
	Document_ContabGen document;
	
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
	public Document_ContabGen getDocument() {
		return document;
	}
	public void setDocument(Document_ContabGen document) {
		this.document = document;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idTranzactie == null) ? 0 : idTranzactie.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tranzactie other = (Tranzactie) obj;
		if (idTranzactie == null) {
			if (other.idTranzactie != null)
				return false;
		} else if (!idTranzactie.equals(other.idTranzactie))
			return false;
		return true;
	}
	
	
		
}

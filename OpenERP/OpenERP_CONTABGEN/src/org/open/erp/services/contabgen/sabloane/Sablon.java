package org.open.erp.services.contabgen.sabloane;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.open.erp.services.contabgen.tranzactii.OperatiuneContabila;

@Entity
public class Sablon implements Serializable{
	
	@Id
	@GeneratedValue
	Integer idSablon;
	String denumireSablon;
	
	@OneToOne
	OperatiuneContabila opCont;
	
	public Sablon() {
	}
	public Sablon(String denumireSablon, OperatiuneContabila opCont) {
		super();
		this.denumireSablon = denumireSablon;
		this.opCont = opCont;
	}
	
	public OperatiuneContabila getOpCont() {
		return opCont;
	}
	public void setOpCont(OperatiuneContabila opCont) {
		this.opCont = opCont;
	}
	
	public Integer getIdSablon() {
		return idSablon;
	}
	public void setIdSablon(Integer idSablon) {
		this.idSablon = idSablon;
	}
	public String getDenumireSablon() {
		return denumireSablon;
	}
	public void setDenumireSablon(String denumireSablon) {
		this.denumireSablon = denumireSablon;
	}	
	
}

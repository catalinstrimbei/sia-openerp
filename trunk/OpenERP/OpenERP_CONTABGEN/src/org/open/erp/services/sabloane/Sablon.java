package org.open.erp.services.sabloane;

import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.conturi.Cont;
import org.open.erp.services.tranzactii.OperatiuneContabila;

public class Sablon {
	
	Integer idSablon;
	String denumireSablon;
	OperatiuneContabila opCont;
	
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

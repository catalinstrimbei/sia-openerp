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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSablon == null) ? 0 : idSablon.hashCode());
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
		Sablon other = (Sablon) obj;
		if (idSablon == null) {
			if (other.idSablon != null)
				return false;
		} else if (!idSablon.equals(other.idSablon))
			return false;
		return true;
	}	
	
}

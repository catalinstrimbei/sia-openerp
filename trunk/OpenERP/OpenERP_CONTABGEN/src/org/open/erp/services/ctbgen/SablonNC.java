package org.open.erp.services.ctbgen;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


/**
 * 
 * @author Echipa ContabGen
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
//@Table(name="Sabloane_note")
public class SablonNC implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idSablon;
	private Integer nrSablon;
	@ManyToOne
	@JoinColumn(name = "contDebit_idCont", referencedColumnName = "idCont")
	private Cont contDebit;
	@ManyToOne
	@JoinColumn(name = "contCredit_idCont", referencedColumnName = "idCont")
	private Cont contCredit;
		

	public SablonNC( Integer idSablon,Integer nrSablon,Cont contDebit, Cont contCredit) {
		
		this.idSablon = idSablon;
		this.nrSablon = nrSablon;
		this.contDebit=contDebit;	
		this.contCredit=contCredit;	
	}
	public SablonNC(Integer nrSablon, Cont contDebit, Cont contCredit) {
		
		this.nrSablon = nrSablon;
		this.contDebit=contDebit;	
		this.contCredit=contCredit;	
	}
	
		

	public SablonNC() {
		
	}



	public Integer getIdSablon() {
		return idSablon;
	}

	public void setIdSablon(Integer idSablon) {
		this.idSablon = idSablon;
	}

	public Integer getNrSablon() {
		return nrSablon;
	}

	public void setNrSablon(Integer nrSablon) {
		this.nrSablon = nrSablon;
	}
	public Cont getContDebit() {
		return contDebit;
	}
	public void setContDebit(Cont contDebit) {
		this.contDebit = contDebit;
	}
	public Cont getContCredit() {
		return contCredit;
	}
	public void setContCredit(Cont contCredit) {
		this.contCredit = contCredit;
	}
	@Override
	public String toString() {
		return "Sablon nr. "  + nrSablon;
	}
	

	
	
	

}

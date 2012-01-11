package org.open.erp.services.ctbgen;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;


/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
public class SablonNC extends Sablon{
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idSablon;
	private Integer nrSablon;
	private Cont contDebit;
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
		return "SablonNC [idSablon=" + idSablon + ", nrSablon=" + nrSablon
				+ ", contDebit=" + contDebit + ", contCredit=" + contCredit
				+ "]";
	}
	

	
	
	

}

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

		

	public SablonNC( Integer idSablon,Integer nrSablon,Cont contDebit, Cont contCredit) {
		super(contDebit, contCredit);
		this.idSablon = idSablon;
		this.nrSablon = nrSablon;
	}
	public SablonNC(Integer nrSablon, Cont contDebit, Cont contCredit) {
		super(contDebit, contCredit);
		this.nrSablon = nrSablon;
	}
	
	
	public SablonNC(Cont contDebit, Cont contCredit) {
		super(contDebit, contCredit);
	}



	public SablonNC() {
		super();
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

	
	
	public String toString() {
		return this.idSablon + ") " + this.nrSablon+ " - D=";
	}

}

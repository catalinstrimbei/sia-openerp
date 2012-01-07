package org.open.erp.services.marketing;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Discount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Integer PROCENT = 1; 
	public static final Integer VALOARE_NETA = 2;
	
	@Id @GeneratedValue
	protected Integer 	idDiscount;
	
	protected String	denumireDiscount;
	protected Integer	tipDiscount = PROCENT;
	protected Float		valoare;
	/**
	 * @return idDiscount
	 */
	public Integer getIdDiscount() {
		return idDiscount;
	}
	/**
	 * @param idDiscount the idDiscount to set
	 */
	public void setIdDiscount(Integer idDiscount) {
		this.idDiscount = idDiscount;
	}
	/**
	 * @return denumireDiscount
	 */
	public String getDenumireDiscount() {
		return denumireDiscount;
	}
	/**
	 * @param denumirediscount the denumirediscount to set
	 */
	public void setDenumirediscount(String denumireDiscount) {
		this.denumireDiscount = denumireDiscount;
	}
	/**
	 * @return tipDiscount
	 */
	public Integer getTipDiscount() {
		return tipDiscount;
	}
	/**
	 * @param tipDiscount the tipDiscount to set
	 */
	public void setTipDiscount(Integer tipDiscount) {
		this.tipDiscount = tipDiscount;
	}
	/**
	 * @return valoare
	 */
	public Float getValoare() {
		return valoare;
	}
	/**
	 * @param valoare the valoare to set
	 */
	public void setValoare(Float valoare) {
		this.valoare = valoare;
	}
	public Discount(Integer idDiscount, String denumireDiscount,
			Integer tipDiscount, Float valoare) {
		super();
		this.idDiscount = idDiscount;
		this.denumireDiscount = denumireDiscount;
		this.tipDiscount = tipDiscount;
		this.valoare = valoare;
	}
	public Discount() {
		super();
	}
	
	
}

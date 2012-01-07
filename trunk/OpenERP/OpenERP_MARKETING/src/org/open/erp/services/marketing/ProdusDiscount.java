package org.open.erp.services.marketing;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.open.erp.services.nomgen.Produs;

@Entity

public class ProdusDiscount implements Serializable {
	@Id @GeneratedValue
	Integer 	idProdusDiscount;
	
	@OneToOne
	@JoinColumn(name ="IdDiscount")
	Discount discount;
	
	@OneToOne
	@JoinColumn(name="IdProdus")
	Produs	produs;
	
	public ProdusDiscount() {
		super();
	}
	public Integer getIdProdusDiscount() {
		return idProdusDiscount;
	}

	public void setIdProdusDiscount(Integer idProdusDiscount) {
		this.idProdusDiscount = idProdusDiscount;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Produs getProdus() {
		return produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public ProdusDiscount(Integer idProdusDiscount, Discount discount,
			Produs produs) {
		super();
		this.idProdusDiscount = idProdusDiscount;
		this.discount = discount;
		this.produs = produs;
	}

	
	
}



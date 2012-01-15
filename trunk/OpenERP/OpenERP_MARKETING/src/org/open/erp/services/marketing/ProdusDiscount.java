package org.open.erp.services.marketing;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//import org.open.erp.services.nomgen.Produs;


@Entity

public class ProdusDiscount implements Serializable {
	@Id @GeneratedValue
	Integer 	idProdusDiscount;
	
	@OneToOne
	@JoinColumn(name ="IdDiscount")
	Discount discount;
	
	@OneToOne
	@JoinColumn(name="IdProdus")
	DummyProdus	produs;
	
	@ManyToOne @JoinColumn(name = "idPromotie")
	Promotie	promotie;
	private static final long serialVersionUID = 1L;
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

	public DummyProdus getProdus() {
		return produs;
	}

	public void setProdus(DummyProdus produs) {
		this.produs = produs;
	}
	public ProdusDiscount(Integer idProdusDiscount, Discount discount,
			DummyProdus produs) {
		super();
		this.idProdusDiscount = idProdusDiscount;
		this.discount = discount;
		this.produs = produs;
	}
	/**
	 * @return the promotie
	 */
	public Promotie getPromotie() {
		return promotie;
	}
	/**
	 * @param promotie the promotie to set
	 */
	public void setPromotie(Promotie promotie) {
		this.promotie = promotie;
	}

	
	
}



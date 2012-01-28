package org.open.erp.services.contabgest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;



//produsul rezultat din mai multe centre cost

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ProdusFinit implements Serializable {
	
	private static final long serialVersionUID = -2057792568208523241L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProdusFinit;
	private String denProdusFinit;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dataProducerii;
	private Double procentProfit;
	
	@OneToMany(mappedBy = "produsfinit", cascade = CascadeType.ALL)
	private Collection<CentruCost> centrucost;
	
	
	
	public ProdusFinit(String denProdusFinit, Double procentProfit) {
		super();
		this.denProdusFinit = denProdusFinit;
		this.procentProfit = procentProfit;
	}
	
	

	public ProdusFinit() {

	}

	public ProdusFinit(Integer idProdusFinit, String denProdusFinit,
			Date dataProducerii, Double procentProfit) {
		super();
		this.idProdusFinit = idProdusFinit;
		this.denProdusFinit = denProdusFinit;
		this.dataProducerii = dataProducerii;
		this.procentProfit = procentProfit;
	}

	public Integer getIdProdusFinit() {
		return idProdusFinit;
	}

	public void setIdProdusFinit(Integer idProdusFinit) {
		this.idProdusFinit = idProdusFinit;
	}

	public String getDenProdusFinit() {
		return denProdusFinit;
	}

	public void setDenProdusFinit(String denProdusFinit) {
		this.denProdusFinit = denProdusFinit;
	}

	public Date getDataProducerii() {
		return dataProducerii;
	}

	public void setDataProducerii(Date dataProducerii) {
		this.dataProducerii = dataProducerii;
	}

	public Double getProcentProfit() {
		return procentProfit;
	}

	public void setProcentProfit(Double procentProfit) {
		this.procentProfit = procentProfit;
	}



	

}


package org.open.erp.services.nomgen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/*
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */
 
@Entity
public class MijlocFix {
	@Id @GeneratedValue
	private Integer id;
	private String  denumire;
	private String  adresa;
	private Integer valoare;
	private Integer termenExploatare;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the denumire
	 */
	public String getDenumire() {
		return denumire;
	}
	/**
	 * @param denumire the denumire to set
	 */
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	/**
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}
	/**
	 * @param adresa the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	/**
	 * @return the valoare
	 */
	public Integer getValoare() {
		return valoare;
	}
	/**
	 * @param valoare the valoare to set
	 */
	public void setValoare(Integer valoare) {
		this.valoare = valoare;
	}
	/**
	 * @return the termenExploatare
	 */
	public Integer getTermenExploatare() {
		return termenExploatare;
	}
	/**
	 * @param termenExploatare the termenExploatare to set
	 */
	public void setTermenExploatare(Integer termenExploatare) {
		this.termenExploatare = termenExploatare;
	}

	
	public MijlocFix(Integer id, String denumire, String adresa, Integer valoare, Integer termenExploatare) {
		super();
		
		this.id = id;
		this.denumire = denumire;
		this.adresa = adresa;
		this.valoare = valoare;
		this.termenExploatare = termenExploatare;
	}
	
	public MijlocFix() {
		super();
	}	

	
	
}

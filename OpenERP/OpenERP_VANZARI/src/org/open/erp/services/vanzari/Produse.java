package org.open.erp.services.vanzari;

import javax.persistence.Entity;

import org.open.erp.services.nommat.Material;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Produse {
	
	@Id @GeneratedValue
	Integer idProdus;

	@OneToOne(targetEntity = org.open.erp.services.nommat.Material.class)
	Material material;	
	String denumire;
	Integer codProdus;
	Double cost;
	Double cantitate;
	Double stoc;
	
	

	public Produse(Material material, Integer idProdus, String denumire,
			Integer codProdus, Double cost, Double cantitate, Double stoc) {
		super();
		this.material = material;
		this.idProdus = idProdus;
		this.denumire = denumire;
		this.codProdus = codProdus;
		this.cost = cost;
		this.cantitate = cantitate;
		this.stoc = stoc;
	}


	public Produse(Integer idProdus, String denumire, Integer codProdus,
			Double cost, Double cantitate) {
		super();
		this.idProdus = idProdus;
		this.denumire = denumire;
		this.codProdus = codProdus;
		this.cost = cost;
		this.cantitate = cantitate;
		
	}
	
	
	
	public Produse() {
		super();
	}



	public Integer getIdProdus() {
		return idProdus;
	}
	public void setIdProdus(Integer idProdus) {
		this.idProdus = idProdus;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public Integer getCodProdus() {
		return codProdus;
	}
	public void setCodProdus(Integer codProdus) {
		this.codProdus = codProdus;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Double getStoc() {
		return stoc;
	}
	public void setStoc(Double stoc) {
		this.stoc = stoc;
	}



	public Material getMaterial() {
		return material;
	}



	public void setMaterial(Material material) {
		this.material = material;
	}


	public Produse(Material material, Integer idProdus, String denumire,
			Integer codProdus, Double cost, Double cantitate) {
		super();
		this.material = material;
		this.idProdus = idProdus;
		this.denumire = denumire;
		this.codProdus = codProdus;
		this.cost = cost;
		this.cantitate = cantitate;
		
	}
	
	


}

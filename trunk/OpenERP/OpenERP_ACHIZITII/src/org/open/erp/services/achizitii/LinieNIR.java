package org.open.erp.services.achizitii;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class LinieNIR extends LinieDocument implements Serializable{

	private Double diferentaCantitate;
	private Double cantitateFacturata;	
	
	public LinieNIR() {
		super();
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	public Double getDiferentaCantitate() {
		return diferentaCantitate;
	}
	private void setDiferentaCantitate(Double diferentaCantitate) {
		this.diferentaCantitate = diferentaCantitate;
	}
	public Double getCantitateFacturata() {
		return cantitateFacturata;
	}
	public void setCantitateFacturata(Double cantitateFacturata) {
		this.cantitateFacturata = cantitateFacturata;
		this.setDiferentaCantitate(cantitateFacturata-this.getCantitate());
	}
	public LinieNIR(Integer linieDoc, Document document, Material material,
			Double cantitate, Double pret, Double tVA, Double cantitateFacturata) {
		super(linieDoc, document, material, cantitate, pret, tVA);
		this.cantitateFacturata = cantitateFacturata;
	}
	
	
	
	
	
	
	

}

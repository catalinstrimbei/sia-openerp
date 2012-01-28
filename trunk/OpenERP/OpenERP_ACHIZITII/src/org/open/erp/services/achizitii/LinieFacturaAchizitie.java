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

public class LinieFacturaAchizitie extends LinieDocument implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -828654688266809711L;
	public LinieFacturaAchizitie() {
		
	}
	private Double valoareLinie;
	public Double getValoareLinie() {
		return valoareLinie;
	}
	public void setValoareLinie(Double valoareLinie) {
		this.valoareLinie = valoareLinie;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}	
	public void setTVA(Double tVA) {
		TVA = tVA;
	}
	public LinieFacturaAchizitie(Integer linieDoc, Document document,
			Material material, Double cantitate, Double pret, Double tVA,
			Double valoareLinie) {
		super(linieDoc, document, material, cantitate, pret, tVA);
		this.valoareLinie = valoareLinie;
	}
	
}

package org.open.erp.services.ctbgen;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
public class ArticolCtb extends Sablon {
	

	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idArt;
	private Integer nrLinArt;
	@ManyToOne
	private InregistrareRJ inregRJ;
	private String denArt;
	private Double sumaDC;

	public ArticolCtb() {
	}
	
	public ArticolCtb(Cont contDebit, Cont contCredit, Integer idArt, Integer nrLinArt, String denArt, Double sumaDC) {
		super(contDebit, contCredit);
		this.idArt = idArt;
		this.nrLinArt = nrLinArt;
		this.denArt = denArt;
		this.sumaDC = sumaDC;
	}

	public Integer getIdArt() {
		return idArt;
	}

	public void setIdArt(Integer idArt) {
		this.idArt = idArt;
	}

	public Integer getNrLinArt() {
		return nrLinArt;
	}

	public void setNrLinArt(Integer nrLinArt) {
		this.nrLinArt = nrLinArt;
	}

	public String getDenArt() {
		return denArt;
	}

	public void setDenArt(String denArt) {
		this.denArt = denArt;
	}

	public Double getSumaDC() {
		return sumaDC;
	}

	public void setSumaDC(Double sumaDC) {
		this.sumaDC = sumaDC;
	}

	@Override
	public String toString() {
		return "ArticolCtb [idArt=" + idArt + ", nrLinArt=" + nrLinArt + ", denArt=" + denArt + ", sumaDC=" + sumaDC + "]";
	}

	public InregistrareRJ getInregRJ() {
		return inregRJ;
	}

	public void setInregRJ(InregistrareRJ inregRJ) {
		this.inregRJ = inregRJ;
	}
	
	
}

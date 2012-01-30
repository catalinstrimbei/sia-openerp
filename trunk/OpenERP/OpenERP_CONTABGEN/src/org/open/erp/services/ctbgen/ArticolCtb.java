package org.open.erp.services.ctbgen;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.JoinColumn;

/**
 * 
 * @author Echipa ContabGEN
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
//@Table(name="Articole_Inregistrari")
public class ArticolCtb  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idArt;
	private Integer nrLinArt;
	@ManyToOne
	@JoinColumn(name = "idInregRJ")
	private InregistrareRJ inregRJ;
	private String denArt;
	@ManyToOne
	@JoinColumn(name = "contDebit_idCont", referencedColumnName = "idCont")
	private Cont contDebit;
	@ManyToOne
	@JoinColumn(name = "contCredit_idCont", referencedColumnName = "idCont")
	private Cont contCredit;
	
	private Double sumaDC;

	public ArticolCtb() {
	}
	
	public ArticolCtb(Cont contDebit, Cont contCredit,  Integer nrLinArt, String denArt, Double sumaDC) {
			
		this.nrLinArt = nrLinArt;
		this.denArt = denArt;
		this.contDebit=contDebit;	
		this.contCredit=contCredit;	
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

	
	public InregistrareRJ getInregRJ() {
		return inregRJ;
	}

	public void setInregRJ(InregistrareRJ inregRJ) {
		this.inregRJ = inregRJ;
	}

	public Cont getContDebit() {
		return contDebit;
	}

	public void setContDebit(Cont contDebit) {
		this.contDebit = contDebit;
	}

	public Cont getContCredit() {
		return contCredit;
	}

	public void setContCredit(Cont contCredit) {
		this.contCredit = contCredit;
	}

	@Override
	public String toString() {
		return "ArticolCtb [idArt=" + idArt + ", nrLinArt=" + nrLinArt
				+ ", inregRJ=" + inregRJ + ", denArt=" + denArt
				+ ", contDebit=" + contDebit + ", contCredit=" + contCredit
				+ ", sumaDC=" + sumaDC + "]";
	}
	
	
}

package org.open.erp.services.ctbgen;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
public class TipContabil implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idTipContabil;
	private String denumireTip;
	@ManyToOne
	@JoinColumn(name = "contProprietar_idCont", referencedColumnName = "idCont")
	private Cont contProprietar;
	@ManyToOne
	@JoinColumn(name = "contIntrare_idCont", referencedColumnName = "idCont")
	private Cont contIntrare;
	@ManyToOne
	@JoinColumn(name = "contIesire_idCont", referencedColumnName = "idCont")
	private Cont contIesire;
	
	
	
	public TipContabil() {
		super();
	}

	public TipContabil(String denumireTip, Cont contProprietar, Cont contIntrare, Cont contIesire) {
		super();
		//this.idTipContabil=-1;
		this.denumireTip = denumireTip;
		this.contProprietar = contProprietar;
		this.contIntrare = contIntrare;
		this.contIesire = contIesire;
	}
	
//	public TipContabil(Integer idTipContabil, String denumireTip, Cont contProprietar, Cont contIntrare, Cont contIesire) {
//		super();
//		this.idTipContabil=idTipContabil;
//		this.denumireTip = denumireTip;
//		this.contProprietar = contProprietar;
//		this.contIntrare = contIntrare;
//		this.contIesire = contIesire;
//	}

	public Integer getIdTipContabil() {
		return idTipContabil;
	}

	public void setIdTipContabil(Integer idTipContabil) {
		this.idTipContabil = idTipContabil;
	}

	public String getDenumireTip() {
		return denumireTip;
	}

	public Cont getContProprietar() {
		return contProprietar;
	}

	public Cont getContIntrare() {
		return contIntrare;
	}

	public Cont getContIesire() {
		return contIesire;
	}

	@Override
	public String toString() {
		return "TipContabil [idTipContabil=" + idTipContabil + ", denumireTip=" + denumireTip + ", contProprietar=" + contProprietar
				+ ", contIntrare=" + contIntrare + ", contIesire=" + contIesire + "]";
	}
	
}

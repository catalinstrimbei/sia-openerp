package org.open.erp.services.ctbgen;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Balanta implements Comparable<Balanta> {
	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "lunaB_idLuna", referencedColumnName = "idLuna")
	private LunaLucru lunaB;
	@ManyToOne
	@JoinColumn(name = "contB_idCont", referencedColumnName = "idCont")
	private Cont contB;
	private Double slodInD;
	private Double slodInC;
	private Double RulajAnD;
	private Double RulajAnC;
	private Double RulajCurD;
	private Double RulajCurC;
	private Double TotalSumD;
	private Double TotalSumC;
	private Double slodFinD;
	private Double slodFinC;
	private boolean anulat;
	
	public Balanta(int id, LunaLucru lunaB, Cont contB, Double slodInD,
			Double slodInC, Double rulajAnD, Double rulajAnC, Double rulajCurD,
			Double rulajCurC, Double totalSumD, Double totalSumC,
			Double slodFinD, Double slodFinC, boolean anulat) {
		super();
		this.id = id;
		this.lunaB = lunaB;
		this.contB = contB;
		this.slodInD = slodInD;
		this.slodInC = slodInC;
		RulajAnD = rulajAnD;
		RulajAnC = rulajAnC;
		RulajCurD = rulajCurD;
		RulajCurC = rulajCurC;
		TotalSumD = totalSumD;
		TotalSumC = totalSumC;
		this.slodFinD = slodFinD;
		this.slodFinC = slodFinC;
		this.anulat = anulat;
	}
	
	public Balanta(LunaLucru lunaB, Cont contB, Double slodInD,
			Double slodInC, Double rulajAnD, Double rulajAnC, Double rulajCurD,
			Double rulajCurC, Double totalSumD, Double totalSumC,
			Double slodFinD, Double slodFinC, boolean anulat) {
		super();
		this.id=-1;
		this.lunaB = lunaB;
		this.contB = contB;
		this.slodInD = slodInD;
		this.slodInC = slodInC;
		RulajAnD = rulajAnD;
		RulajAnC = rulajAnC;
		RulajCurD = rulajCurD;
		RulajCurC = rulajCurC;
		TotalSumD = totalSumD;
		TotalSumC = totalSumC;
		this.slodFinD = slodFinD;
		this.slodFinC = slodFinC;
		this.anulat = anulat;
	}
	
	

	public Balanta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LunaLucru getLunaB() {
		return lunaB;
	}

	public void setLunaB(LunaLucru lunaB) {
		this.lunaB = lunaB;
	}

	public Cont getContB() {
		return contB;
	}

	public void setContB(Cont contB) {
		this.contB = contB;
	}

	public Double getSlodInD() {
		return slodInD;
	}

	public void setSlodInD(Double slodInD) {
		this.slodInD = slodInD;
	}

	public Double getSlodInC() {
		return slodInC;
	}

	public void setSlodInC(Double slodInC) {
		this.slodInC = slodInC;
	}

	public Double getRulajAnD() {
		return RulajAnD;
	}

	public void setRulajAnD(Double rulajAnD) {
		RulajAnD = rulajAnD;
	}

	public Double getRulajAnC() {
		return RulajAnC;
	}

	public void setRulajAnC(Double rulajAnC) {
		RulajAnC = rulajAnC;
	}

	public Double getRulajCurD() {
		return RulajCurD;
	}

	public void setRulajCurD(Double rulajCurD) {
		RulajCurD = rulajCurD;
	}

	public Double getRulajCurC() {
		return RulajCurC;
	}

	public void setRulajCurC(Double rulajCurC) {
		RulajCurC = rulajCurC;
	}

	public Double getTotalSumD() {
		return TotalSumD;
	}

	public void setTotalSumD(Double totalSumD) {
		TotalSumD = totalSumD;
	}

	public Double getTotalSumC() {
		return TotalSumC;
	}

	public void setTotalSumC(Double totalSumC) {
		TotalSumC = totalSumC;
	}

	public Double getSlodFinD() {
		return slodFinD;
	}

	public void setSlodFinD(Double slodFinD) {
		this.slodFinD = slodFinD;
	}

	public Double getSlodFinC() {
		return slodFinC;
	}

	public void setSlodFinC(Double slodFinC) {
		this.slodFinC = slodFinC;
	}

	public boolean isAnulat() {
		return anulat;
	}

	public void setAnulat(boolean anulat) {
		this.anulat = anulat;
	}

	@Override
	public int compareTo(Balanta comparaCU) {
		return this.lunaB.compareTo(comparaCU.lunaB);
	}
	
	@Override
	public String toString() {
		return "Balanta [id=" + id + "/" + lunaB + "/" + contB.getSimbolCont()
				+ "sid=" + slodInD + "sic=" + slodInC
				+ "rad=" + RulajAnD + "rad=" + RulajAnC
				+ "rcd=" + RulajCurD + "rcc=" + RulajCurC
				+ "tsd=" + TotalSumD + "tsc=" + TotalSumC
				+ "sfd=" + slodFinD + "sfc=" + slodFinC
				+ "/" + anulat + "]";
	}

}

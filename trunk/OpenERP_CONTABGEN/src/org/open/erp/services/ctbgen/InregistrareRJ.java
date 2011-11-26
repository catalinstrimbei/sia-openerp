package org.open.erp.services.ctbgen;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Entity)
 * 
 */

public class InregistrareRJ implements Comparable<InregistrareRJ>{
	private Integer idInregRJ;
	private Date dataInregRJ;
	private List <ArticolCtb> articoleRJ;
	private Integer nrDocLeg;
	private LunaLucru lunaCurs;
	private Integer idPartener;
	
	public InregistrareRJ() {
		super();
	}
	
	public InregistrareRJ(Date dataInregRJ, Integer nrDocLeg, LunaLucru lunaCurs, Integer idPartener) {
		super();
		this.idInregRJ=-1;
		this.dataInregRJ = dataInregRJ;
		this.nrDocLeg = nrDocLeg;
		this.lunaCurs = lunaCurs;
		this.idPartener = idPartener;
	}
	
	public InregistrareRJ(Integer idInregRJ, Date dataInregRJ, List<ArticolCtb> articoleRJ, Integer nrDocLeg,
			LunaLucru lunaCurs, Integer idPartener) {
		super();
		this.idInregRJ = idInregRJ;
		this.dataInregRJ = dataInregRJ;
		this.articoleRJ = articoleRJ;
		this.nrDocLeg = nrDocLeg;
		this.lunaCurs = lunaCurs;
		this.idPartener = idPartener;
	}
	
	public Integer getIdInregRJ() {
		return idInregRJ;
	}
	public void setIdInregRJ(Integer idInregRJ) {
		this.idInregRJ = idInregRJ;
	}
	public Date getDataInregRJ() {
		return dataInregRJ;
	}
	public void setDataInregRJ(Date dataInregRJ) {
		this.dataInregRJ = dataInregRJ;
	}
	public List<ArticolCtb> getArticoleRJ() {
		return articoleRJ;
	}
	public void setArticoleRJ(List<ArticolCtb> articoleRJ) {
		//aici ceva nu e bine
		this.articoleRJ = articoleRJ;
	}
	public Integer getNrDocLeg() {
		return nrDocLeg;
	}
	public void setNrDocLeg(Integer nrDocLeg) {
		this.nrDocLeg = nrDocLeg;
	}
	public LunaLucru getLunaCurs() {
		return lunaCurs;
	}
	public void setLunaCurs(LunaLucru lunaCurs) {
		this.lunaCurs = lunaCurs;
	}
	public Integer getIdPartener() {
		return idPartener;
	}
	public void setIdPartener(Integer idPartener) {
		this.idPartener = idPartener;
	}

	@Override
	public int compareTo(InregistrareRJ inreg) {
		if(this.dataInregRJ.after(inreg.getDataInregRJ())) return 1;
		else if(this.dataInregRJ.before(inreg.getDataInregRJ())) return -1;
		else return 0;
	}

	@Override
	public String toString() {
		return "InregistrareRJ [articolRJ=" + articoleRJ.toString() + "]";
	}

	
}

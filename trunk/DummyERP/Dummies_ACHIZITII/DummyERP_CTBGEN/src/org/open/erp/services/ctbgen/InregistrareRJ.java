package org.open.erp.services.ctbgen;

import java.util.Date;
import java.util.List;

public class InregistrareRJ {
	private Integer idInregRJ;
	private Date dataInregRJ;
	private List <ArticolCtb> articoleRJ;
	private Integer nrDocLeg;
	//ar putea fi numeric sau integer pentru a lua id documentului primit
	private LunaCurenta lunaCurs;
	private Integer idPartener;
	
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
		this.articoleRJ = articoleRJ;
	}
	public Integer getNrDocLeg() {
		return nrDocLeg;
	}
	public void setNrDocLeg(Integer nrDocLeg) {
		this.nrDocLeg = nrDocLeg;
	}
	public LunaCurenta getLunaCurs() {
		return lunaCurs;
	}
	public void setLunaCurs(LunaCurenta lunaCurs) {
		this.lunaCurs = lunaCurs;
	}
	public Integer getIdPartener() {
		return idPartener;
	}
	public void setIdPartener(Integer idPartener) {
		this.idPartener = idPartener;
	}
	public InregistrareRJ(Integer idInregRJ, Date dataInregRJ,
			List<ArticolCtb> articoleRJ, Integer nrDocLeg,
			LunaCurenta lunaCurs, Integer idPartener) {
		super();
		this.idInregRJ = idInregRJ;
		this.dataInregRJ = dataInregRJ;
		this.articoleRJ = articoleRJ;
		this.nrDocLeg = nrDocLeg;
		this.lunaCurs = lunaCurs;
		this.idPartener = idPartener;
	}
	public InregistrareRJ() {
		super();
	}
	
	
}

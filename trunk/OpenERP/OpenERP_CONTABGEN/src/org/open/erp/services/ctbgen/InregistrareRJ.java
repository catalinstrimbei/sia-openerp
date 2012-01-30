package org.open.erp.services.ctbgen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Temporal;

import static javax.persistence.GenerationType.AUTO;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.FetchType.EAGER;



/**
 * 
 * @author Echipa ContabGen
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
//@Table(name="Inregistrari_Jurnal")
public class InregistrareRJ implements Comparable<InregistrareRJ>, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idInregRJ;
	@Temporal(DATE)
	private Date dataInregRJ;
	@OneToMany(mappedBy = "inregRJ", cascade =CascadeType. ALL, fetch = EAGER)
	private List <ArticolCtb> articoleRJ;
	private Integer nrDocLeg;
	@ManyToOne
	@JoinColumn(name = "lunaCurs_idLuna", referencedColumnName = "idLuna")
	private LunaLucru lunaCurs;
	private Integer idPartener;
	private boolean anulat;
	
	public InregistrareRJ() {
		super();
	}
	
	public InregistrareRJ(Date dataInregRJ, Integer nrDocLeg, LunaLucru lunaCurs, Integer idPartener) {
		super();
		//this.idInregRJ=-1;
		this.dataInregRJ = dataInregRJ;
		this.nrDocLeg = nrDocLeg;
		this.lunaCurs = lunaCurs;
		this.idPartener = idPartener;
		this.articoleRJ=new ArrayList<ArticolCtb>();
		this.anulat=false;
	}
	
//	public InregistrareRJ(Integer idInregRJ, Date dataInregRJ, List<ArticolCtb> articoleRJ, Integer nrDocLeg,
//			LunaLucru lunaCurs, Integer idPartener) {
//		super();
//		this.idInregRJ = idInregRJ;
//		this.dataInregRJ = dataInregRJ;
//		this.articoleRJ = articoleRJ;
//		this.nrDocLeg = nrDocLeg;
//		this.lunaCurs = lunaCurs;
//		this.idPartener = idPartener;
//		this.anulat=false;
//	}
	
	public boolean isAnulat() {
		return anulat;
	}

	public void setAnulat(boolean anulat) {
		this.anulat = anulat;
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
	
	public void adaugaArticol(ArticolCtb articoleRJ) {
		
		this.articoleRJ.add(articoleRJ); 
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
		return "Inreg-"+this.getIdInregRJ()+"/"+this.getDataInregRJ();
	}

	public void anuleazaInreg(){
		this.anulat=true;
	}
	
}

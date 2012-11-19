package org.open.erp.services.banci;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Clienti;

public class PlatiBNC {
	private Integer contPlata;
	private Integer contDestinatar;
	private Integer tipplata;
	private Integer moneda;
	private Date datatranzactiei;
	private Clienti client;
	private Double valsoldePlatainitial;
	private Double valsoldePlatadupavirament;
	private Double valNumerar;
	private Double comisiontrz;
	private List<LiniiPlati> liniePlata;
	
	public Integer getContPlata() {
		return contPlata;
	}
	public void setContPlata(Integer contPlata) {
		this.contPlata = contPlata;
	}
	
	public Integer getContDestinatar() {
		return contDestinatar;
	}
	public void setContDestinatar(Integer contDestinatar) {
		this.contDestinatar = contDestinatar;
	}
	
	public Integer getTipplata() {
		return tipplata;
	}
	public void setTipplata(Integer tipplata) {
		this.tipplata = tipplata;
	}
	
	public Integer getMoneda() {
		return moneda;
	}
	public void setMoneda(Integer moneda) {
		this.moneda = moneda;
	}
	
	public Date getdatatranzactiei() {
		return datatranzactiei;
	}
	public void setdatatranzactiei(Date datatranzactiei) {
		this.datatranzactiei = datatranzactiei;
	}
	
	public Clienti getClient() {
		return client;
	}
	public void setClient(Clienti client) {
		this.client = client;
	}				
	
	public Double getValsoldePlatainitial() {
		return valsoldePlatainitial;
	}
	public void setValsoldePlatainitial(Double valsoldePlatainitial) {
		this.valsoldePlatainitial = valsoldePlatainitial;
	}
	public Double getValsoldePlatadupavirament() {
		return valsoldePlatadupavirament;
	}
	public void setValsoldePlatadupavirament(Double valsoldePlatadupavirament) {
		this.valsoldePlatadupavirament = valsoldePlatadupavirament;
	}
	
	public Double getValNumerar() {
		return valNumerar;
	}
	public void setValNumerar(Double valNumerar) {
		this.valNumerar = valNumerar;
	}
	public Double getcomisiontrz() {
		return comisiontrz;
	}
	public void setcomisiontrz(Double comisiontrz) {
		this.comisiontrz = comisiontrz;
	}	
	public List<LiniiPlati> getliniePlata() {
		return liniePlata;
	}
	public void setliniePlata(List<LiniiPlati> liniePlata) {
		this.liniePlata = liniePlata;
	
	}
	public PlatiBNC(Integer contPlata,Integer contDestinatar,Integer tipplata,Integer moneda,Date datatranzactiei,Clienti client,Double valsoldePlatainitial,Double valsoldePlatadupavirament,Double valNumerar,Double comisiontrz,List<LiniiPlati> liniePlata) {
		super();
		this.contPlata = contPlata;
		this.contDestinatar = contDestinatar;
		this.tipplata = tipplata;
		this.moneda = moneda;
		this.datatranzactiei = datatranzactiei;
		this.client = client;
		this.valsoldePlatainitial = valsoldePlatainitial;
		this.valsoldePlatadupavirament = valsoldePlatadupavirament;
		this.valNumerar = valNumerar;
		this.comisiontrz = comisiontrz;
		this.liniePlata = liniePlata;
		
	}	
	
	public PlatiBNC() {
		super();
	}
	
}
	

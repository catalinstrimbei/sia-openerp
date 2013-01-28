package org.open.erp.services.banci;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.open.erp.services.nomgen.Companie;

@Entity
public class SchimbValBNC implements Serializable {
	@Id @GeneratedValue
	private Integer Idschimb;
	private Companie client;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datatranz;
	
	private Integer monedacurenta;
	private Double valmoncurenta;
	private Integer monedaschimb;
	private Double valmondupaschimb;
	private Integer cursval;
	private Double comisionscb;
	private List<LiniiPlati> liniePlata;

	public Companie getClient() {
		return client;
	}
	public void setClient(Companie client) {
		this.client = client;
	}				
	public Date getDatatranz() {
		return datatranz;
	}
	public void setDatatranz(Date datatranz) {
		this.datatranz = datatranz;
	}
	public Integer getMonedacurenta() {
		return monedacurenta;
	}
	public void setMonedacurenta(Integer monedacurenta) {
		this.monedacurenta = monedacurenta;
	}
	
	public Double getValmoncurenta() {
		return valmoncurenta;
	}
	public void setValmoncurenta(Double valmoncurenta) {
		this.valmoncurenta = valmoncurenta;
	}
	
	public Integer getMonedaschimb() {
		return  monedaschimb;
	}
	public void setMonedaschimb(Integer  monedaschimb) {
		this.monedaschimb =  monedaschimb;
	}
	
	public Double getValmondupaschimb() {
		return valmondupaschimb;
	}
	public void setValmondupaschimb(Double valmondupaschimb) {
		this.valmondupaschimb = valmondupaschimb;
	}
	
	public Integer getCursval() {
		return  cursval;
	}
	public void setCursval(Integer cursval) {
		this. cursval =  cursval;
	}
	public Double getComisionscb() {
		return comisionscb;
	}
	public void setComisionscb(Double comisionscb) {
		this.comisionscb = comisionscb;
	}
		
	public List<LiniiPlati> getliniePlata() {
		return liniePlata;
	}
	
	public void setliniePlata(List<LiniiPlati> liniePlata) {
		this.liniePlata = liniePlata;	
	}
		
	public SchimbValBNC(Companie client, Date datatranz, Integer monedacurenta, Double valmoncurenta, Integer monedaschimb, Double valmondupaschimb, Integer cursval,Double comisionscb, List<LiniiPlati> liniePlata) {
		this.client = client;
		this.datatranz = datatranz;
		this.monedacurenta = monedacurenta;
		this.valmoncurenta = valmoncurenta;
		this.monedaschimb =  monedaschimb;
		this.valmondupaschimb = valmondupaschimb;
		this.cursval =  cursval;
		this.comisionscb = comisionscb;
		this.liniePlata = liniePlata;
	}	
	
	public SchimbValBNC() {
		super();
	}
	public Integer getIdschimb() {
		return Idschimb;
	}
	public void setIdschimb(Integer idschimb) {
		Idschimb = idschimb;
	}
	
}
package org.open.erp.services.ctbgen;

public class LunaCurenta {
	private Integer idLuna;
	private Integer luna;
	private Integer an;
	private Integer status;
	public Integer getIdLuna() {
		return idLuna;
	}
	public void setIdLuna(Integer idLuna) {
		this.idLuna = idLuna;
	}
	public Integer getLuna() {
		return luna;
	}
	public void setLuna(Integer luna) {
		this.luna = luna;
	}
	public Integer getAn() {
		return an;
	}
	public void setAn(Integer an) {
		this.an = an;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LunaCurenta(Integer idLuna, Integer luna, Integer an, Integer status) {
		super();
		this.idLuna = idLuna;
		this.luna = luna;
		this.an = an;
		this.status = status;
	}
	public LunaCurenta() {
		super();
	}
	
	
	
}

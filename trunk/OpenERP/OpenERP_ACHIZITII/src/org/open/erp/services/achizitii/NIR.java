package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Furnizori;
import org.open.erp.services.nommat.Materiale;

public class NIR {
	private Integer nrNIR;
	private Date data;
	private Furnizori funrizor;
	private Materiale material;
	private Double cantitate;
	private Double valoareTotala;
	public Integer getNrNIR() {
		return nrNIR;
	}
	public void setNrNIR(Integer nrNIR) {
		this.nrNIR = nrNIR;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Furnizori getFunrizor() {
		return funrizor;
	}
	public void setFunrizor(Furnizori funrizor) {
		this.funrizor = funrizor;
	}
	public Materiale getMaterial() {
		return material;
	}
	public void setMaterial(Materiale material) {
		this.material = material;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Double getValoareTotala() {
		return valoareTotala;
	}
	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}
	public NIR(Integer nrNIR, Date data, Furnizori funrizor,
			Materiale material, Double cantitate, Double valoareTotala) {
		super();
		this.nrNIR = nrNIR;
		this.data = data;
		this.funrizor = funrizor;
		this.material = material;
		this.cantitate = cantitate;
		this.valoareTotala = valoareTotala;
	}
	public NIR() {
		super();
	}
	
	

}

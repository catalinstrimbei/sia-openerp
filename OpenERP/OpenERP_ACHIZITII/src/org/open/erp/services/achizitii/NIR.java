package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nommat.Materiale;

public class NIR extends Document{
	private Integer nrNIR;
	private Date data;
	private Furnizori furnizor;
	private List<LiniiNIR> linieNir;
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
		return furnizor;
	}
	public void setFunrizor(Furnizori furnizor) {
		this.furnizor = furnizor;
	}
	public List<LiniiNIR> getLinieNir() {
		return linieNir;
	}
	public void setLinieNir(List<LiniiNIR> linieNir) {
		this.linieNir = linieNir;
	}
	public Double getValoareTotala() {
		return valoareTotala;
	}
	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}
	public NIR(Integer nrNIR, Date data, Furnizori furnizor,
			List<LiniiNIR> linieNir, Double valoareTotala) {
		super();
		this.nrNIR = nrNIR;
		this.data = data;
		this.furnizor = furnizor;
		this.linieNir = linieNir;
		this.valoareTotala = valoareTotala;
	}
		
	public NIR() {
		super();
	}
	public NIR(Integer nrNIR, Date data, Furnizori furnizor,
			Double valoareTotala) {
		super();
		this.nrNIR = nrNIR;
		this.data = data;
		this.furnizor = furnizor;
		this.valoareTotala = valoareTotala;
	}

	

}

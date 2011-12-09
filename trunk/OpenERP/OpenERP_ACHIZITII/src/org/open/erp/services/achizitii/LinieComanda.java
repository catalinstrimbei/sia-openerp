package org.open.erp.services.achizitii;

import org.open.erp.services.nomgen.Material;



public class LinieComanda   {
	public Integer linieComanda;
	public Comanda comanda;
	public Material articol;	
	public Double cantitate;
	public Double pret;
	public Integer getLinieComanda() {
		return linieComanda;
	}
	public void setLinieComanda(Integer linieComanda) {
		this.linieComanda = linieComanda;
	}
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}	
	
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	public LinieComanda(Integer linieComanda, Comanda comanda, Material articol,
			Double cantitate, Double pret) {
		super();
		this.linieComanda = linieComanda;
		this.comanda = comanda;
		this.articol = articol;
		this.cantitate = cantitate;
		this.pret = pret;
	}
	public Material getArticol() {
		return articol;
	}
	public void setArticol(Material articol) {
		this.articol = articol;
	}
		

}

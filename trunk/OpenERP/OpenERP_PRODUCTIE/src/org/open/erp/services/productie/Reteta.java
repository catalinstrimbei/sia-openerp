package org.open.erp.services.productie;

import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.Produs;

public class Reteta {
	private Integer IdReteta;
	private Produs produs;
	private Material material;
	private Semifabricat semifabricat;
	private Double cantitateM;
	private Double cantitateS;
	
	public Double getCantitateM() {
		return cantitateM;
	}
	public void setCantitateM(Double cantitateM) {
		this.cantitateM = cantitateM;
	}
	public Double getCantitateS() {
		return cantitateS;
	}
	public void setCantitateS(Double cantitateS) {
		this.cantitateS = cantitateS;
	}
	
	public Integer getIdReteta() {
		return IdReteta;
	}
	public void setIdReteta(Integer idReteta) {
		IdReteta = idReteta;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}

	public Semifabricat getSemifabricat() {
		return semifabricat;
	}
	public void setSemifabricat(Semifabricat semifabricat) {
		this.semifabricat = semifabricat;
	}
	
	public Reteta(Integer idReteta, Produs produs, Material materiePrima,
			Semifabricat semifabricat, Double cantitateM,Double cantitateS) {
		super();
		IdReteta = idReteta;
		this.produs = produs;
		this.material = materiePrima;
		this.semifabricat = semifabricat;
		this.cantitateM = cantitateM;
		this.cantitateS=cantitateS;
	}
	public Reteta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
}

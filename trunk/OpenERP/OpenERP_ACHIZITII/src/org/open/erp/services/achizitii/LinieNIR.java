package org.open.erp.services.achizitii;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;

public class LinieNIR extends LinieDocument {
	private Integer cantitateConstatata;
	private Integer diferentaCantitate;
	private Double pret;
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	
	public LinieNIR(Integer linieDoc, Document document, Material material,
			Double cantitate, Double pret, Double tVA,
			Integer cantitateConstatata, Integer diferentaCantitate,
			Double pret2) {
		super(linieDoc, document, material, cantitate, pret, tVA);
		this.cantitateConstatata = cantitateConstatata;
		this.diferentaCantitate = diferentaCantitate;
		pret = pret2;
	}
	public Integer getCantitateConstatata() {
		return cantitateConstatata;
	}
	public void setCantitateConstatata(Integer cantitateConstatata) {
		this.cantitateConstatata = cantitateConstatata;
	}
	public Integer getDiferentaCantitate() {
		return diferentaCantitate;
	}
	public void setDiferentaCantitate(Integer diferentaCantitate) {
		this.diferentaCantitate = diferentaCantitate;
	}

}

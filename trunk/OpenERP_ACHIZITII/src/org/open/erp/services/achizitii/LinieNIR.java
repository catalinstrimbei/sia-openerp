package org.open.erp.services.achizitii;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;

public class LinieNIR extends LinieDocument {
	public Integer cantitateConstatata;
	public Integer diferentaCantitate;
	public LinieNIR(Integer linieDoc, Document document, Material material,
			Double cantitate, Double pret, Double tVA,
			Integer cantitateConstatata, Integer diferentaCantitate) {
		super(linieDoc, document, material, cantitate, pret, tVA);
		this.cantitateConstatata = cantitateConstatata;
		this.diferentaCantitate = diferentaCantitate;
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

package org.open.erp.services.achizitii;

import java.util.LinkedList;
import java.util.List;

import org.open.erp.services.nomgen.Document;

public class Factura extends Document {
	public Furnizor furnizor;
	public String nrFact;
	public Double valFact;
	public Double TVATotal;
	public String stare;
	public String getStare() {
		return stare;
	}
	public void setStare(String stare) {
		this.stare = stare;
	}
	public Double getValFact() {
		return valFact;
	}	
	public void setValFact(Double valFact) {
		this.valFact = valFact;
	}
	public Double getTVATotal() {
		return TVATotal;
	}
	public void setTVATotal(Double tVATotal) {
		TVATotal = tVATotal;
	}
	public String getNrFact() {
		return nrFact;
	}
	public void setNrFact(String nrFact) {
		this.nrFact = nrFact;
	}
	public Furnizor getFurnizor() {
		return furnizor;
	}
	public void setFurnizor(Furnizor furnizor) {
		this.furnizor = furnizor;
	}
	public Factura(Double valFact, Double tVATotal, String nrFact,
			Furnizor furnizor) {
		super();
		this.valFact = valFact;
		TVATotal = tVATotal;
		this.nrFact = nrFact;
		this.furnizor = furnizor;
	}

}

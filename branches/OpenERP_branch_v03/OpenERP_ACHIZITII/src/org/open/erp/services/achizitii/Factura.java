package org.open.erp.services.achizitii;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */

public class Factura extends Document {
	public static final Integer STORNATA = -1;
	public static final Integer INREGISTRATA = 1;
	public static final Integer FACTURA_RETUR = 2;
	public static final Integer FACTURA_ACHIZITIE = 3;
	private Furnizor furnizor;
	private String nrFact;
	private Double valFact;
	private Double TVATotal;
	private Integer status;
	private Comanda comanda;
	private Integer tipFact;
	public Integer getTipFact() {
		return tipFact;
	}
	public void setTipFact(Integer tipFact) {
		this.tipFact = tipFact;
	}
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
		comanda.setStatusComanda(Comanda.FINALIZATA);
	}	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public void addLinieFactura(LinieDocument li) {
        this.getLiniiDocument().add(li);
        li.setDocument(this);
    }

	public void removeLinieFactura(LinieDocument li) {
        this.getLiniiDocument().remove(li);
        li.setDocument(this);
    }
	public Factura(Furnizor furnizor, String nrFact, Double valFact,
			Double tVATotal, Integer status, Comanda comanda, Integer tipFact) {
		super();
		this.furnizor = furnizor;
		this.nrFact = nrFact;
		this.valFact = valFact;
		TVATotal = tVATotal;
		this.status = status;
		this.comanda = comanda;
		this.tipFact = tipFact;
	}
	
}

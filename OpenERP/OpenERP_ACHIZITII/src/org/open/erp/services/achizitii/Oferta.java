package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.List;


public class Oferta {
	private Integer nrOferta;
	private Date dataOferta;
	private Date dataLivrare; //cand poate furnizorul sa ne livreze bunurile
	private Furnizori funrizor;
	private List<LiniiOferta> linieOferta;
	private Double valoareTotala;
	private CerereOferta cerereOferta;
		
	public void adaugaLinie(LiniiOferta linie){
		this.linieOferta.add(linie);
	}
	
	public CerereOferta getCerereOferta() {
		return cerereOferta;
	}
	public void setCerereOferta(CerereOferta cerereOferta) {
		this.cerereOferta = cerereOferta;
	}
	public Integer getNrOferta() {
		return nrOferta;
	}
	public void setNrOferta(Integer nrOferta) {
		this.nrOferta = nrOferta;
	}
	public Date getDataOferta() {
		return dataOferta;
	}
	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}
	public Date getDataLivrare() {
		return dataLivrare;
	}
	public void setDataLivrare(Date dataLivrare) {
		this.dataLivrare = dataLivrare;
	}
	public Furnizori getFunrizor() {
		return funrizor;
	}
	public void setFunrizor(Furnizori funrizor) {
		this.funrizor = funrizor;
	}
	public List<LiniiOferta> getLinieOferta() {
		return linieOferta;
	}
	public void setLinieOferta(List<LiniiOferta> linieOferta) {
		this.linieOferta = linieOferta;
	}
	public Double getValoareTotala() {
		return valoareTotala;
	}
	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}
	public Oferta(Integer nrOferta, Date dataOferta, Date dataLivrare,
			Furnizori funrizor, List<LiniiOferta> linieOferta,
			Double valoareTotala) {
		super();
		this.nrOferta = nrOferta;
		this.dataOferta = dataOferta;
		this.dataLivrare = dataLivrare;
		this.funrizor = funrizor;
		this.linieOferta = linieOferta;
		this.valoareTotala = valoareTotala;
	}
	public Oferta() {
		super();
	}

	public Oferta(Integer nrOferta, Date dataOferta, Date dataLivrare,Double valoareTotala,
			Furnizori funrizor, CerereOferta cerereOferta) {
		super();
		this.nrOferta = nrOferta;
		this.dataOferta = dataOferta;
		this.dataLivrare = dataLivrare;
		this.valoareTotala = valoareTotala;
		this.funrizor = funrizor;
		this.cerereOferta = cerereOferta;
		this.valoareTotala = valoareTotala;
	}
	
	
}

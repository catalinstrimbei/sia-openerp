package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispozitiiLivrare {
	Integer idDispozitieLivrare;
	Date data;
	Responsabil responsabil;
	Comenzi comanda;
	List<LiniiDispozitieLivrare> liniiDispozitieLivare = new ArrayList<LiniiDispozitieLivrare>();
	
	public Integer getIdDispozitieLivrare() {
		return idDispozitieLivrare;
	}
	public void setIdDispozitieLivrare(Integer idDispozitieLivrare) {
		this.idDispozitieLivrare = idDispozitieLivrare;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Responsabil getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Responsabil responsabil) {
		this.responsabil = responsabil;
	}
	public Comenzi getComanda() {
		return comanda;
	}
	public void setComanda(Comenzi comanda) {
		this.comanda = comanda;
	}
	public List<LiniiDispozitieLivrare> getLiniiDispozitieLivare() {
		return liniiDispozitieLivare;
	}
	public void setLiniiDispozitieLivare(
			List<LiniiDispozitieLivrare> liniiDispozitieLivare) {
		this.liniiDispozitieLivare = liniiDispozitieLivare;
	}
	public DispozitiiLivrare(Integer idDispozitieLivrare, Date data,
			Responsabil responsabil, Comenzi comanda,
			List<LiniiDispozitieLivrare> liniiDispozitieLivare) {
		super();
		this.idDispozitieLivrare = idDispozitieLivrare;
		this.data = data;
		this.responsabil = responsabil;
		this.comanda = comanda;
		this.liniiDispozitieLivare = liniiDispozitieLivare;
	}
	
public Double getValoareDispozotie(){
		
		Double valoare = 0.0;
		for (LiniiDispozitieLivrare linie: liniiDispozitieLivare){
			valoare = valoare + linie.valoareLinieDispozitie();
		}
		
		return valoare;
	}


public void adaugaLinieDispozitie( LiniiDispozitieLivrare linieDispozitie){
	
	this.liniiDispozitieLivare.add(linieDispozitie);
}

}

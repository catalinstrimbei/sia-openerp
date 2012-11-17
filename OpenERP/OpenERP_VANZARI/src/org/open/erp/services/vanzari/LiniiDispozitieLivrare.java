package org.open.erp.services.vanzari;

import org.open.erp.services.nommat.Produse;

public class LiniiDispozitieLivrare {
	Integer nrLinieDispozitie;
	Produse produs;
	Comenzi comanda;
	Double valoare;
	public Integer getNrLinieDispozitie() {
		return nrLinieDispozitie;
	}
	public void setNrLinieDispozitie(Integer nrLinieDispozitie) {
		this.nrLinieDispozitie = nrLinieDispozitie;
	}
	public Produse getProdus() {
		return produs;
	}
	public void setProdus(Produse produs) {
		this.produs = produs;
	}
	public Comenzi getComanda() {
		return comanda;
	}
	public void setComanda(Comenzi comanda) {
		this.comanda = comanda;
	}
	public Double getValoare() {
		return valoare;
	}
	public void setValoare(Double valoare) {
		this.valoare = valoare;
	}
	public LiniiDispozitieLivrare(Integer nrLinieDispozitie, Produse produs,
			Comenzi comanda, Double valoare) {
		super();
		this.nrLinieDispozitie = nrLinieDispozitie;
		this.produs = produs;
		this.comanda = comanda;
		this.valoare = valoare;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((nrLinieDispozitie == null) ? 0 : nrLinieDispozitie
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LiniiDispozitieLivrare other = (LiniiDispozitieLivrare) obj;
		if (nrLinieDispozitie == null) {
			if (other.nrLinieDispozitie != null)
				return false;
		} else if (!nrLinieDispozitie.equals(other.nrLinieDispozitie))
			return false;
		return true;
	}
	
	

}

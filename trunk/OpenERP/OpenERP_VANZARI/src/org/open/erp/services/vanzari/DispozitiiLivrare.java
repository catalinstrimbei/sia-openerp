package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.open.erp.services.personal.Angajat;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

@Entity
public class DispozitiiLivrare {
	@Id @GeneratedValue
	Integer idDispozitieLivrare;
	
	@Temporal(TIMESTAMP)
	Date data;
	
	@OneToOne(targetEntity = org.open.erp.services.personal.Angajat.class)
	Angajat responsabil;
	
	@OneToOne(targetEntity = org.open.erp.services.vanzari.Comenzi.class)
	Comenzi comanda;
	
	@OneToMany(mappedBy = "dispozitie")
	List<LiniiDispozitieLivrare> liniiDispozitieLivare = new ArrayList<LiniiDispozitieLivrare>();
	
	
	
	
	
	
public DispozitiiLivrare() {
		super();
	}



public DispozitiiLivrare(Integer idDispozitieLivrare, Date data,
			Angajat responsabil, Comenzi comanda,
			List<LiniiDispozitieLivrare> liniiDispozitieLivare) {
		super();
		this.idDispozitieLivrare = idDispozitieLivrare;
		this.data = data;
		this.responsabil = responsabil;
		this.comanda = comanda;
		this.liniiDispozitieLivare = liniiDispozitieLivare;
	}



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



public Angajat getAngajat() {
	return responsabil;
}



public void setAngajat(Angajat responsabil) {
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

package org.open.erp.services.Productie;

import org.open.erp.services.Productie.Produs;
import org.open.erp.services.Personal.Angajat;
import org.open.erp.services.Salarizare.SalarizareStatPlata;

public class Manopera {

	private Produs produs;
	private Angajat angajat;
	private Integer oreLucru;
	private SalarizareStatPlata statplata;
	
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	
	public Integer getOreLucru() {
		return oreLucru;
	}
	public void setOreLucru(Integer oreLucru) {
		this.oreLucru = oreLucru;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public double calculManopera()
	{
		return (this.statplata.getSalariuOreLucrate() / this.statplata.getNrOreLucrate()* this.getOreLucru());
	
		
	}
	
	
	
}

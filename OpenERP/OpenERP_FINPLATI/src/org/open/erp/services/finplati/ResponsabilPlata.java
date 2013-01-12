package org.open.erp.services.finplati;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.open.erp.services.finplati.Persoana;
/**
 * 
 * @author paraschivgeanina
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ResponsabilPlata extends Persoana implements Serializable{
	//@Id @GeneratedValue
	private Integer idResponsabil;
	 String obsExperienta;
	
	 public Integer getidResponsabil() {
		return idResponsabil;
	}

	public void setId(Integer idResponsabil) {
		this.idResponsabil = idResponsabil;
	}
	public String getObsExperienta() {
		return obsExperienta;
	}

	public void setObsExperienta(String obsExperienta) {
		this.obsExperienta = obsExperienta;
	}

	public ResponsabilPlata(Integer IdPersoana, String nume, String prenume,
			String obsExperienta) {
		this.obsExperienta = obsExperienta;
	}

	public ResponsabilPlata() {
		super();
	}	
	
	public ResponsabilPlata(Persoana p) {
		super();
		this.IdPersoana = p.IdPersoana;
		this.nume = p.nume;
		this.prenume = p.prenume;
		this.scorAptitudini = p.scorAptitudini;
	}
}

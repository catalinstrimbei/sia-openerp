package org.open.erp.services.finplati;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author paraschivgeanina
 *
 */
@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class  Persoana implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	protected Integer IdPersoana;
	
	protected String nume;
	protected String prenume;
	protected Integer scorAptitudini;
	
	public Integer getIdPersoana() {
		return IdPersoana;
	}

	public void setIdPersoana(Integer idPersoana) {
		this.IdPersoana = idPersoana;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public void setScorAptitudini(Integer scorAptitudini) {
		this.scorAptitudini = scorAptitudini;
	}
	public Integer getScorAptitudini() {
		return this.scorAptitudini;
	}
}

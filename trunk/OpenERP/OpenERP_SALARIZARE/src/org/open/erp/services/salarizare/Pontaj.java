package org.open.erp.services.salarizare;

import java.io.Serializable;

import javax.persistence.Entity;

import org.open.erp.services.personal.Angajat;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.ManyToOne;
/**
 * 
 * @author ionut.hrubaru
 * 
 * @BusinessObject(Entity)
 *  
 */
@Entity
public class Pontaj implements Serializable{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPontaj == null) ? 0 : idPontaj.hashCode());
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
		Pontaj other = (Pontaj) obj;
		if (idPontaj == null) {
			if (other.idPontaj != null)
				return false;
		} else if (!idPontaj.equals(other.idPontaj))
			return false;
		return true;
	}
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer idPontaj;
	private Integer an;
	private Integer luna;
	@ManyToOne
	private Angajat angajat;
	private Double oreLucrate;
	private Double oreSuplimentare;
	private Double oreConcediu;
	
	
	public Integer getIdPontaj() {
		return idPontaj;
	}
	public void setIdPontaj(Integer idPontaj) {
		this.idPontaj = idPontaj;
	}
	public Integer getAn() {
		return an;
	}
	public void setAn(Integer an) {
		this.an = an;
	}
	public Integer getLuna() {
		return luna;
	}
	public void setLuna(Integer luna) {
		this.luna = luna;
	}
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public Double getOreLucrate() {
		return oreLucrate;
	}
	public Pontaj(Angajat angajat, Integer an, Integer luna, Double oreLucrate,
			Double oreSuplimentare, Double oreConcediu) {
		super();
		this.an = an;
		this.luna = luna;
		this.angajat = angajat;
		this.oreLucrate = oreLucrate;
		this.oreSuplimentare = oreSuplimentare;
		this.oreConcediu = oreConcediu;
	}
	
	
	public Pontaj(Integer idPontaj, Integer an, Integer luna, Angajat angajat,
			Double oreLucrate, Double oreSuplimentare, Double oreConcediu) {
		super();
		this.idPontaj = idPontaj;
		this.an = an;
		this.luna = luna;
		this.angajat = angajat;
		this.oreLucrate = oreLucrate;
		this.oreSuplimentare = oreSuplimentare;
		this.oreConcediu = oreConcediu;
	}
	public Pontaj() {
		super();
	}
	public void setOreLucrate(Double oreLucrate) {
		this.oreLucrate = oreLucrate;
	}
	public Double getOreSuplimentare() {
		return oreSuplimentare;
	}
	public void setOreSuplimentare(Double oreSuplimentare) {
		this.oreSuplimentare = oreSuplimentare;
	}
	public Double getOreConcediu() {
		return oreConcediu;
	}
	public void setOreConcediu(Double oreConcediu) {
		this.oreConcediu = oreConcediu;
	}
	
	
}

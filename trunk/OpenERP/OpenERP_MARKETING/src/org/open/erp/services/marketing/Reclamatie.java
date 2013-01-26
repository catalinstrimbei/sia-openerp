package org.open.erp.services.marketing;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.open.erp.services.nomgen.Persoana;

@Entity
public class Reclamatie implements Serializable{
	
	@Id @GeneratedValue
	long id;
	
	@ManyToOne
	Persoana persoanaReclamanta;
	
	@Temporal(TemporalType.DATE)
	Date data;
	
	String text;
	String raspuns;
	StatusReclamatie status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Persoana getPersoanaReclamanta() {
		return persoanaReclamanta;
	}

	public void setPersoanaReclamanta(Persoana persoanaReclamanta) {
		this.persoanaReclamanta = persoanaReclamanta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRaspuns() {
		return raspuns;
	}

	public void setRaspuns(String raspuns) {
		this.raspuns = raspuns;
	}

	public StatusReclamatie getStatus() {
		return status;
	}

	public void setStatus(StatusReclamatie status) {
		this.status = status;
	}

	public Reclamatie() {

	}

	public Reclamatie(long id, Persoana persoanaReclamanta, Date data, String text, String raspuns, StatusReclamatie status) {
		super();
		this.id = id;
		this.persoanaReclamanta = persoanaReclamanta;
		this.data = data;
		this.text = text;
		this.raspuns = raspuns;
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Reclamatie other = (Reclamatie) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

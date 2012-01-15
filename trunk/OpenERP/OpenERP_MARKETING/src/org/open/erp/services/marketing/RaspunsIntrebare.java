package org.open.erp.services.marketing;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class RaspunsIntrebare {
	@Id
	Integer	IdRaspunsIntrebare;
	@OneToOne
	@JoinColumn(name="idIntrebare")
	Intrebare  intrebare;
	String		raspuns;
	public RaspunsIntrebare() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdRaspunsIntrebare() {
		return IdRaspunsIntrebare;
	}
	public void setIdRaspunsIntrebare(Integer idRaspunsIntrebare) {
		IdRaspunsIntrebare = idRaspunsIntrebare;
	}
	public Intrebare getIntrebare() {
		return intrebare;
	}
	public void setIntrebare(Intrebare intrebare) {
		this.intrebare = intrebare;
	}
	public String getRaspuns() {
		return raspuns;
	}
	public void setRaspuns(String raspuns) {
		this.raspuns = raspuns;
	}
	public RaspunsIntrebare(Integer idRaspunsIntrebare, Intrebare intrebare,
			String raspuns) {
		super();
		IdRaspunsIntrebare = idRaspunsIntrebare;
		this.intrebare = intrebare;
		this.raspuns = raspuns;
	}
	

}

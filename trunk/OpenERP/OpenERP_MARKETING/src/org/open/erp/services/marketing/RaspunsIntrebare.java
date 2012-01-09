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

}

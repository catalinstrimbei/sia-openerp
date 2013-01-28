package org.open.erp.services.banci;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class LiniiAlimentare implements Serializable{
	@Id @GeneratedValue
	private Integer idliniealim;
	
	

	public Integer getIdliniealim() {
		return idliniealim;
	}

	public void setIdliniealim(Integer idliniealim) {
		this.idliniealim = idliniealim;
	}

}

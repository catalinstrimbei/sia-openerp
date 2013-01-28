package org.open.erp.services.banci;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class LiniiAlimentare implements Serializable{
	@Id @GeneratedValue
	private Integer idliniealim;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataalimentare;
	
	

	public Integer getIdliniealim() {
		return idliniealim;
	}

	public void setIdliniealim(Integer idliniealim) {
		this.idliniealim = idliniealim;
	}

	public Date getDataalimentare() {
		return dataalimentare;
	}

	public void setDataalimentare(Date dataalimentare) {
		this.dataalimentare = dataalimentare;
	}

}

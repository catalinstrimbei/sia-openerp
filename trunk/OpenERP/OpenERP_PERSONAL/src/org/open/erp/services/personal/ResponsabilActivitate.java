package org.open.erp.services.personal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//TODO verify and delete this class
@Entity
public class ResponsabilActivitate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer 	id;
	@ManyToOne @JoinColumn(name="marca") 
	private Angajat		responsabil;
	@ManyToOne @JoinColumn(name="idActivitate") 
	private Activitate	activitate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Angajat getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Angajat responsabil) {
		this.responsabil = responsabil;
	}
	public Activitate getActivitate() {
		return activitate;
	}
	public void setActivitate(Activitate activitate) {
		this.activitate = activitate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ResponsabilActivitate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

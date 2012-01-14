package org.open.erp.services.marketing;



import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import org.open.erp.services.nomgen.PersoanaFizica;

@Entity
public class PersoanaTinta extends DummyPersoanaFizica implements Serializable {
	/**
	 * 
	 */
	@GeneratedValue
	Integer 	idPersoanaTinta;
	@ManyToOne @JoinColumn(name = "idCampanie")
	Campanie	campanie;
	
	private static final long serialVersionUID = 1L;

	public PersoanaTinta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idPersoana
	 * @param nume
	 * @param prenume
	 */
	public PersoanaTinta(Integer idPersoana, String nume, String prenume) {
		super();
		this.setId(idPersoana);
		this.setNume(nume);
		this.setPrenume(prenume);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idPersoanaTinta
	 */
	public Integer getIdPersoanaTinta() {
		return idPersoanaTinta;
	}

	/**
	 * @param idPersoanaTinta the idPersoanaTinta to set
	 */
	public void setIdPersoanaTinta(Integer idPersoanaTinta) {
		this.idPersoanaTinta = idPersoanaTinta;
	}

	/**
	 * @return the idCampanie
	 */
	public Campanie getIdCampanie() {
		return idCampanie;
	}

	/**
	 * @param idCampanie the idCampanie to set
	 */
	public void setIdCampanie(Campanie idCampanie) {
		this.idCampanie = idCampanie;
	}
	
}

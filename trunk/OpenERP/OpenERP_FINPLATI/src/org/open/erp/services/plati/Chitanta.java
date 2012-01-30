package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.io.Serializable;
import java.util.Date;

//import javax.persistence.DiscriminatorValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;

import org.open.erp.services.plati.Plata;
import org.open.erp.services.personal.Angajat;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;

@Entity
public class Chitanta extends Plata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8553756025142218909L;
	/**
	 * 
	 */
	protected Integer idChitanta;
	public Integer getIdChitanta() {
		return idChitanta;
	}

	public void setIdChitanta(Integer idChitanta) {
		this.idChitanta = idChitanta;
	}

	public Angajat getCasier() {
		return casier;
	}

	public void setCasier(Angajat casier) {
		this.casier = casier;
	}
	

	private Angajat casier;
	
	public Chitanta() {
		super();
	}

	public Chitanta(Integer idPlata, Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String seria, Integer numar,
			String locatie, Angajat casier) {
		super(idPlata, dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);
		this.casier = casier;
	}
}
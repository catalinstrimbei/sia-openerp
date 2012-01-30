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

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Entity
public class OrdinPlata extends Plata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2176553473223480662L;
	/**
	 * 
	 */
	private Integer idOrdinPlata;
	private static Long intervalValabilitate;
	private String stare;
	private String reprezentand;
	
	public OrdinPlata(Integer idPlata, Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String seria, Integer numar,
			String locatie, String stare) {
		super(idPlata, dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);
		this.stare = stare;
	}
	
	public static Long getIntervalValabilitate() {
		return intervalValabilitate;
	}
	
	public static void setIntervalValabilitate(Long intervalValabilitate) {
		OrdinPlata.intervalValabilitate = intervalValabilitate;
	}

	public String getStare() {
	return stare;
	}

	public void setStare(String stare) {
	this.stare = stare;
	}

	public String getReprezentand() {
		return reprezentand;
	}

	public void setReprezentand(String reprezentand) {
		this.reprezentand = reprezentand;
	}
	
	public OrdinPlata() {
		super();
	}

	public Integer getIdOrdinPlata() {
		return idOrdinPlata;
	}

	public void setIdOrdinPlata(Integer idOrdinPlata) {
		this.idOrdinPlata = idOrdinPlata;
	}
}


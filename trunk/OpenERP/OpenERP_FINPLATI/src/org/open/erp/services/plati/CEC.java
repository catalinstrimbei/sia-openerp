package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "CEC")
@DiscriminatorValue("CEC")
public class CEC extends Plata implements Serializable{
	
	private Integer idCEC;
	private static Long intervalValabilitate;
	private String stare;

	public CEC(Integer idPlata, Date dataEmiterii, Boolean avans, Date dataInregistrarii,
			Double suma, String seria, Integer numar,
			String locatie, String stare) {
		super(idPlata, dataEmiterii, avans, dataInregistrarii, suma,
				seria, numar, locatie);
		this.stare = stare;
	}
	
	public Integer getIdCEC() {
		return idCEC;
	}

	public void setIdCEC(Integer idCEC) {
		this.idCEC = idCEC;
	}

	public static Long getIntervalValabilitate() {
		return intervalValabilitate;
	}
	
	public static void setIntervalValabilitate(Long intervalValabilitate) {
	CEC.intervalValabilitate = intervalValabilitate;
	}

	public String getStare() {
	return stare;
	}

	public void setStare(String stare) {
	this.stare = stare;
	}
	
	public CEC() {
		super();
	}
}
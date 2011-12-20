

package org.open.erp.services.incasari;

import java.util.Date;

import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @author Echipa FININCASARI
 * 
 * @BusinessObject(Entity)
 * 
 */

public class BiletLaOrdin extends Incasare {

	private Date dataScadenta;
	private static Long intervalValabilitate;
	private Persoana garant;
	private String stare;

	public Date getDataScadenta() {
		return dataScadenta;
	}

	public void setDataScadenta(Date dataScadenta) {
		this.dataScadenta = dataScadenta;
	}

	public static Long getIntervalValabilitate() {
		return intervalValabilitate;
	}

	public static void setIntervalValabilitate(Long intervalValabilitate) {
		BiletLaOrdin.intervalValabilitate = intervalValabilitate;
	}

	public String getStare() {
		return stare;
	}

	public void setStare(String stare) {
		this.stare = stare;
	}

	public BiletLaOrdin(Date dataEmiterii, Boolean avans,
			Date dataInregistrarii, Double suma, String sumaInLitere,
			String seria, Integer numar, String locatie,
			 Date dataScadenta, Persoana garant,
			String stare) {
		super(dataEmiterii, avans, dataInregistrarii, suma, sumaInLitere,
				seria, numar, locatie);
		this.dataScadenta = dataScadenta;
		this.garant = garant;
		this.stare = stare;
	}

	public Persoana getGarant() {
		return garant;
	}

	public void setGarant(Persoana garant) {
		this.garant = garant;
	}

}

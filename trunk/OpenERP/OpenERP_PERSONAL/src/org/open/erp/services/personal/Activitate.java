package org.open.erp.services.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

//import org.open.erp.services.buget.Buget;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */

public class Activitate {
	private String 		idActivitate;
	private Eveniment	eveniment;
	private String 		descriereActivitate;
	private Integer 	numarMinimParticipanti;
	private Double		sumaConsumata;
	private Date		dataStart;
	private Date		dataSfarsit;
	private String 		locatie;
	private Double		sumaEstimata;
	
	public Double getSumaEstimata() {
		return sumaEstimata;
	}
	public void setSumaEstimata(Double sumaEstimata) {
		this.sumaEstimata = sumaEstimata;
	}

	//NMV>>se adauga o activitate noua in lista cand se initializeaza clasa.
	private static List<Activitate> activitati = new ArrayList<Activitate>();//NMV>> lista folosita pentru a simula persistenta
	
	public String getIdActivitate() {
		return idActivitate;
	}
	public void setIdActivitate(String idActivitate) {
		this.idActivitate = idActivitate;
	}
	public Eveniment getEveniment() {
		return eveniment;
	}
	public void setEveniment(Eveniment eveniment) {
		this.eveniment = eveniment;
	}
	public String getDescriereActivitate() {
		return descriereActivitate;
	}
	public void setDescriereActivitate(String descriereActivitate) {
		this.descriereActivitate = descriereActivitate;
	}
	public Integer getNumarMinimParticipanti() {
		return numarMinimParticipanti;
	}
	public void setNumarMinimParticipanti(Integer numarMinimParticipanti) {
		this.numarMinimParticipanti = numarMinimParticipanti;
	}
	public Double getSumaConsumata() {
		return sumaConsumata;
	}
	public void setSumaConsumata(Double sumaConsumata) {
		this.sumaConsumata = sumaConsumata;
	}
	public Date getDataStart() {
		return dataStart;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	public Date getDataSfarsit() {
		return dataSfarsit;
	}
	public void setDataSfarsit(Date dataSfarsit) {
		this.dataSfarsit = dataSfarsit;
	}
	public String getLocatie() {
		return locatie;
	}
	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}
	/**
	 * @param idActivitate
	 * @param eveniment
	 * @param descriereActivitate
	 * @param numarMinimParticipanti
	 * @param sumaConsumata
	 * @param dataStart
	 * @param dataSfarsit
	 * @param locatie
	 */
	public Activitate(String idActivitate, Eveniment eveniment,
			String descriereActivitate, Integer numarMinimParticipanti,
			Double sumaConsumata, Date dataStart, Date dataSfarsit,
			String locatie, Double sumaEstimata) {
		super();
		this.idActivitate = idActivitate;
		this.eveniment = eveniment;
		this.descriereActivitate = descriereActivitate;
		this.numarMinimParticipanti = numarMinimParticipanti;
		this.sumaConsumata = sumaConsumata;
		this.dataStart = dataStart;
		this.dataSfarsit = dataSfarsit;
		this.locatie = locatie;
		this.sumaEstimata = sumaEstimata;
		activitati.add(this);//TODO de scos cand avem BD// NMV>>simulare persistenta 
	}
	/**
	 * 
	 */
	public Activitate() {
		super();
		activitati.add(this);//TODO de scos cand avem BD// NMV>>simulare persistenta 
		// TODO Auto-generated constructor stub
	}
	
	public static Activitate construct(Eveniment eveniment) throws Exception{//NMV>>creare metoda construct ce returneaza activitate noua de tip teambuilding sau training in functie de tipul evenimentului
		
		Activitate activitateNoua = null;		
		if(eveniment.getTipEveniment()=="TeamBuilding")
		{
			activitateNoua = new ActivitateTeamBuilding();
		}
		else if (eveniment.getTipEveniment()=="Training")
		{
			activitateNoua = new ActivitateTraining();
		}
		else
		{
			throw new Exception("Eroare!");	//TODO	de rezolvat throw in construct!!
			//return null;
		}
		activitateNoua.setEveniment(eveniment);
		eveniment.AddActivitate(activitateNoua);
		return activitateNoua;
	}
}

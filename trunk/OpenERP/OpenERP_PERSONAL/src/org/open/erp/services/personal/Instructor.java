package org.open.erp.services.personal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;


/**
 * 
 * @BusinessObject(Entity)
 * 
 */
//TODO    adauga Jar si clasa DummyPersoana in persistence.xml
@Entity
public class Instructor extends DummyPersoana {
	public Integer getTraininguriTotal() {
		return traininguriTotal;
	}
	public void setTraininguriTotal(Integer traininguriTotal) {
		this.traininguriTotal = traininguriTotal;
	}
	public List<String> getAptitudini() {
		return aptitudini;
	}
	public void setAptitudini(List<String> aptitudini) {
		this.aptitudini = aptitudini;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer 		traininguriTotal;
	private	List<String>	aptitudini;
	@ManyToMany(mappedBy = "instructori")
	private List<ActivitateTraining>	activitatiTeamBld;
	
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Instructor(Integer id, String adresa) {
		super(id, adresa);
		// TODO Auto-generated constructor stub
	}
	public List<ActivitateTraining> getActivitatiTeamBld() {
		return activitatiTeamBld;
	}
	public void setActivitatiTeamBld(List<ActivitateTraining> activitatiTeamBld) {
		this.activitatiTeamBld = activitatiTeamBld;
	}
	
}

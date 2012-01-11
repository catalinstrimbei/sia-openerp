package org.open.erp.services.personal;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;


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
	public Collection<String> getAptitudini() {
		return aptitudini;
	}
	public void setAptitudini(Collection<String> aptitudini) {
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
	@Transient
	private	Collection<String>	aptitudini;
	@ManyToMany(mappedBy = "instructori")
	private Collection<ActivitateTraining>	activitatiTeamBld;
	
	public Instructor() {
		super();
	}
	public Instructor(Integer id, String adresa) {
		super(id, adresa);
	}
	public Collection<ActivitateTraining> getActivitatiTeamBld() {
		return activitatiTeamBld;
	}
	public void setActivitatiTeamBld(Collection<ActivitateTraining> activitatiTeamBld) {
		this.activitatiTeamBld = activitatiTeamBld;
	}
	
}

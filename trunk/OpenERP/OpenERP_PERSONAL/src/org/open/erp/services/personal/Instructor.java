package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
//TODO    adauga Jar si clasa Persoana in persistence.xml
@Entity
public class Instructor extends Persoana implements Serializable{
	
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
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Instructor(Integer id, String adresa) {
		super(id, adresa);
		// TODO Auto-generated constructor stub
	}
	
}

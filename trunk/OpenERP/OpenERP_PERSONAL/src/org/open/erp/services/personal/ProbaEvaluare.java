package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class ProbaEvaluare implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String 			idProba;
	private String 			tipEvaluare;
	private Integer			durataMinute;
	private List<String> 	intrebari;
	private String			scop;
	//TODO    adauga Jar si clasa Departament in persistence.xml
	//@ManyToOne
	private Departament		departament;
	
	public ProbaEvaluare() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTipEvaluare() {
		return tipEvaluare;
	}
	public void setTipEvaluare(String tipEvaluare) {
		this.tipEvaluare = tipEvaluare;
	}
	public Integer getDurataMinute() {
		return durataMinute;
	}
	public void setDurataMinute(Integer durataMinute) {
		this.durataMinute = durataMinute;
	}
	public List<String> getIntrebari() {
		return intrebari;
	}
	public void setIntrebari(List<String> intrebari) {
		this.intrebari = intrebari;
	}
	public String getScop() {
		return scop;
	}
	public void setScop(String scop) {
		this.scop = scop;
	}
	public Departament getDepartament() {
		return departament;
	}
	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	public String getIdProba() {
		return idProba;
	}
	public void setIdProba(String idProba) {
		this.idProba = idProba;
	}
	public ProbaEvaluare(String idProba, String tipEvaluare,
			Integer durataMinute, List<String> intrebari, String scop,
			Departament departament) {
		super();
		this.idProba = idProba;
		this.tipEvaluare = tipEvaluare;
		this.durataMinute = durataMinute;
		this.intrebari = intrebari;
		this.scop = scop;
		this.departament = departament;
	}
	public ProbaEvaluare(String idProba, String tipEvaluare, String scop,
			Departament departament) {
		super();
		this.idProba = idProba;
		this.tipEvaluare = tipEvaluare;
		this.scop = scop;
		this.departament = departament;
	}

	
}
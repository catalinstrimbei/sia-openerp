package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//TODO uncomment this
//import org.open.erp.services.nomgen.Departament;
import javax.persistence.Transient;

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
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer 		idProba;
	private String 			tipEvaluare;
	private Integer			durataMinute;
	@Transient
	private Collection<String> 	intrebari;
	private String			scop;
	//TODO    adauga Jar si clasa DummyDepartament in persistence.xml
	@ManyToOne @JoinColumn(name="idDepartament") 
	private DummyDepartament		departament;
	
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
	public Collection<String> getIntrebari() {
		return intrebari;
	}
	public void setIntrebari(Collection<String> intrebari) {
		this.intrebari = intrebari;
	}
	public String getScop() {
		return scop;
	}
	public void setScop(String scop) {
		this.scop = scop;
	}
	public DummyDepartament getDepartament() {
		return departament;
	}
	public void setDepartament(DummyDepartament departament) {
		this.departament = departament;
	}
	public Integer getIdProba() {
		return idProba;
	}
	public void setIdProba(Integer idProba) {
		this.idProba = idProba;
	}
	public ProbaEvaluare(Integer idProba, String tipEvaluare,
			Integer durataMinute, Collection<String> intrebari, String scop,
			DummyDepartament departament) {
		super();
		this.idProba = idProba;
		this.tipEvaluare = tipEvaluare;
		this.durataMinute = durataMinute;
		this.intrebari = intrebari;
		this.scop = scop;
		this.departament = departament;
	}
	public ProbaEvaluare(Integer idProba, String tipEvaluare, String scop,
			DummyDepartament departament) {
		super();
		this.idProba = idProba;
		this.tipEvaluare = tipEvaluare;
		this.scop = scop;
		this.departament = departament;
	}

	
}
package org.open.erp.services.personal;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class ProbaEvaluare {
	
	private String 			tipEvaluare;
	private Integer			durataMinute;
	private List<String> 	intrebari;
	private String			scop;
	private Departament		departament;
	
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
	public ProbaEvaluare(String tipEvaluare, Integer durataMinute,
			List<String> intrebari, String scop, Departament departament) {
		super();
		this.tipEvaluare = tipEvaluare;
		this.durataMinute = durataMinute;
		this.intrebari = intrebari;
		this.scop = scop;
		this.departament = departament;
	}
	public ProbaEvaluare() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProbaEvaluare(String tipEvaluare, String scop,
			Departament departament) {
		super();
		this.tipEvaluare = tipEvaluare;
		this.scop = scop;
		this.departament = departament;
	}
	
	
}
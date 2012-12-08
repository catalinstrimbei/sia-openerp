package org.open.erp.services.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CV {
	Candidat titularCV;
	List<Tuple<String,Date,Date>> studiileAbsolvite;
	List<Tuple<String,Date,Date>> functiiOcupate;
	List<DoubleParam<String, String>> limbiStraine;
	String aptitudini;
	
	public CV (Candidat titular,List<Tuple<String,Date,Date>> studiiAbs,List<Tuple<String,Date,Date>>functiiOcp, List<DoubleParam<String,String>>limbiStr, String apt){
		titularCV = titular;
		studiileAbsolvite = new ArrayList<Tuple<String,Date,Date>>();
		for (Tuple<String,Date,Date> t: studiiAbs){
			studiileAbsolvite.add(t);
		}
		functiiOcupate = new ArrayList<Tuple<String,Date,Date>>();
		for (Tuple<String,Date,Date> t: functiiOcp){
			functiiOcupate.add(t);
		}
		limbiStraine = new ArrayList<DoubleParam<String, String>>();
		for (DoubleParam<String, String> d: limbiStr){
			limbiStraine.add(d);
		}
		aptitudini = apt;
	}
	
	public Candidat getTitularCV() {
		return titularCV;
	}

	public void setTitularCV(Candidat titularCV) {
		this.titularCV = titularCV;
	}

	public List<Tuple<String, Date, Date>> getStudiileAbsolvite() {
		return studiileAbsolvite;
	}

	public void setStudiileAbsolvite(List<Tuple<String, Date, Date>> studiileAbsolvite) {
		this.studiileAbsolvite = studiileAbsolvite;
	}

	public List<Tuple<String, Date, Date>> getFunctiiOcupate() {
		return functiiOcupate;
	}

	public void setFunctiiOcupate(List<Tuple<String, Date, Date>> functiiOcupate) {
		this.functiiOcupate = functiiOcupate;
	}

	public List<DoubleParam<String, String>> getLimbiStraine() {
		return limbiStraine;
	}

	public void setLimbiStraine(List<DoubleParam<String, String>> limbiStraine) {
		this.limbiStraine = limbiStraine;
	}

	public String getAptitudini() {
		return aptitudini;
	}

	public void setAptitudini(String aptitudini) {
		this.aptitudini = aptitudini;
	}

	
}

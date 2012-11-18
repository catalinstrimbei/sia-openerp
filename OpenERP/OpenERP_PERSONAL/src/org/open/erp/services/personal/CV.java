package org.open.erp.services.personal;

import java.util.Date;

public class CV {
	Candidat titularCV;
	Tuple<String,Date,Date> studiileAbsolvite;
	Tuple<String,Date,Date> functiiOcupate;
	DoubleParam<String, String> limbiStraine;
	String aptitudini;
	
	public CV (Candidat titular,Tuple<String,Date,Date> studiiAbs,Tuple<String,Date,Date>functiiOcp, DoubleParam<String,String>limbiStr, String apt){
		titularCV = titular;
		studiileAbsolvite = new Tuple<String,Date,Date>();
		studiileAbsolvite.denInstitutie = studiiAbs.denInstitutie;
		studiileAbsolvite.dataInceput = studiiAbs.dataInceput;
		studiileAbsolvite.dataSfarsit = studiiAbs.dataSfarsit;
		functiiOcupate = new Tuple<String,Date,Date>();
		functiiOcupate.denInstitutie = functiiOcp.denInstitutie;
		functiiOcupate.dataInceput = functiiOcp.dataInceput;
		functiiOcupate.dataSfarsit = functiiOcp.dataSfarsit;
		limbiStraine = new DoubleParam<String,String>();
		limbiStraine.limbaStraina = limbiStr.limbaStraina;
		limbiStraine.nivelulDeCunoastere = limbiStr.nivelulDeCunoastere;
		aptitudini = apt;
	}
	
	public Candidat getTitularCV() {
		return titularCV;
	}

	public void setTitularCV(Candidat titularCV) {
		this.titularCV = titularCV;
	}

	public Tuple<String, Date, Date> getStudiileAbsolvite() {
		return studiileAbsolvite;
	}

	public void setStudiileAbsolvite(Tuple<String, Date, Date> studiileAbsolvite) {
		this.studiileAbsolvite = studiileAbsolvite;
	}

	public Tuple<String, Date, Date> getFunctiiOcupate() {
		return functiiOcupate;
	}

	public void setFunctiiOcupate(Tuple<String, Date, Date> functiiOcupate) {
		this.functiiOcupate = functiiOcupate;
	}

	public DoubleParam<String, String> getLimbiStraine() {
		return limbiStraine;
	}

	public void setLimbiStraine(DoubleParam<String, String> limbiStraine) {
		this.limbiStraine = limbiStraine;
	}

	public String getAptitudini() {
		return aptitudini;
	}

	public void setAptitudini(String aptitudini) {
		this.aptitudini = aptitudini;
	}

	
}

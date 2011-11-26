package org.open.erp.services.nomgen;

public class Departament{
	private String 	idDepartament;
	//private Angajat sefDepartament;
	private String 	numeDepartament;
	private Integer	nrAngajati;
	public String getIdDepartament() {
		return idDepartament;
	}
	public void setIdDepartament(String idDepartament) {
		this.idDepartament = idDepartament;
	}
	public String getNumeDepartament() {
		return numeDepartament;
	}
	public void setNumeDepartament(String numeDepartament) {
		this.numeDepartament = numeDepartament;
	}
	public Integer getNrAngajati() {
		return nrAngajati;
	}
	public void setNrAngajati(Integer nrAngajati) {
		this.nrAngajati = nrAngajati;
	}
	public Departament(String idDepartament, String numeDepartament,
			Integer nrAngajati) {
		super();
		this.idDepartament = idDepartament;
		this.numeDepartament = numeDepartament;
		this.nrAngajati = nrAngajati;
	}
	
}

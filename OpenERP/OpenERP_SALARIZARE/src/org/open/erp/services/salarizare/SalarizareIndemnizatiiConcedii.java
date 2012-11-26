package org.open.erp.services.salarizare;

public class SalarizareIndemnizatiiConcedii {
	String codIndemnizatie;
	String denIndemnizarie;
	Float procent;
	Double bazaCalcul;
	public String getCodIndemnizatie() {
		return codIndemnizatie;
	}
	public void setCodIndemnizatie(String codIndemnizatie) {
		this.codIndemnizatie = codIndemnizatie;
	}
	public String getDenIndemnizarie() {
		return denIndemnizarie;
	}
	public void setDenIndemnizarie(String denIndemnizarie) {
		this.denIndemnizarie = denIndemnizarie;
	}
	public Float getProcent() {
		return procent;
	}
	public void setProcent(Float procent) {
		this.procent = procent;
	}
	public Double getBazaCalcul() {
		return bazaCalcul;
	}
	public void setBazaCalcul(Double bazaCalcul) {
		this.bazaCalcul = bazaCalcul;
	}

}

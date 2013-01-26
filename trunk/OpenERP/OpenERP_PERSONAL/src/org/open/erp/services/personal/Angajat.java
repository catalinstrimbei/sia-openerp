package org.open.erp.services.personal;

import javax.persistence.Entity;

import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.PersoanaFizica;

@Entity
public class Angajat extends PersoanaFizica{
	ContractMunca cm;
	private Integer	numarCopii;
	public Integer getNumarCopii() {
		return numarCopii;
	}
	public void setNumarCopii(Integer numarCopii) {
		this.numarCopii = numarCopii;
	}
	public Angajat(Integer id, String nume, String sex, String mail,
			String statutInCompanie, String stareCivila, String dataNastere,
			String telefon, Adresa adresa, ContractMunca cm) {
		super(id, nume, sex, mail, statutInCompanie, stareCivila, dataNastere,
				telefon, adresa);
		this.cm = cm;
	}
	public ContractMunca getCm() {
		return cm;
	}
	public void setCm(ContractMunca cm) {
		this.cm = cm;
	}
	public Angajat() {
		super();
	}

	
	
}

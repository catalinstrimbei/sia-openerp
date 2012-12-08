package org.open.erp.services.personal;

import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.PersoanaFizica;

public class Angajat extends PersoanaFizica {
	ContractMunca cm;
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
	
	
	
}

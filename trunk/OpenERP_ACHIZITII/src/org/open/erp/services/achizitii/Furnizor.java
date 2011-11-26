package org.open.erp.services.achizitii;

import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Persoana;

public class Furnizor extends Partener {
public Integer cont;

public Integer getCont() {
	return cont;
}

public void setCont(Integer cont) {
	this.cont = cont;
}

public Furnizor(String cUI, String denumire, String adresa, String telefon,
		Persoana persContact, Integer cont) {
	super(cUI, denumire, adresa, telefon, persContact);
	this.cont = cont;
}


}

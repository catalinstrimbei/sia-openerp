package org.open.erp.services.nomgen;

public class Clienti {
	
Persoana persoana;
String categorie;//PF sau PJ

public Clienti(Persoana persoana, String categorie) {
	super();
	this.persoana = persoana;
	this.categorie = categorie;
}

public Persoana getPersoana() {
	return persoana;
}

public void setPersoana(Persoana persoana) {
	this.persoana = persoana;
}

public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
}


}

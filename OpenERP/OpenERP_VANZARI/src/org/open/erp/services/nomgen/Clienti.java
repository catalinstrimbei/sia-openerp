package org.open.erp.services.nomgen;

public class Clienti {
Integer idPartener;
String denumire;
String nume;
String prenume;
String categorie;
public Integer getIdPartener() {
	return idPartener;
}
public void setIdPartener(Integer idPartener) {
	this.idPartener = idPartener;
}
public String getDenumire() {
	return denumire;
}
public void setDenumire(String denumire) {
	this.denumire = denumire;
}
public String getNume() {
	return nume;
}
public void setNume(String nume) {
	this.nume = nume;
}
public String getPrenume() {
	return prenume;
}
public void setPrenume(String prenume) {
	this.prenume = prenume;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}
public Clienti(Integer idPartener, String denumire, String nume,
		String prenume, String categorie) {
	super();
	this.idPartener = idPartener;
	this.denumire = denumire;
	this.nume = nume;
	this.prenume = prenume;
	this.categorie = categorie;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((idPartener == null) ? 0 : idPartener.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Clienti other = (Clienti) obj;
	if (idPartener == null) {
		if (other.idPartener != null)
			return false;
	} else if (!idPartener.equals(other.idPartener))
		return false;
	return true;
}


}

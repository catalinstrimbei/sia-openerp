package org.open.erp.services.achizitii;

import java.util.Date;

import org.open.erp.services.nomgen.Document;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */

public class Contract extends Document{
public Date dataInceput;
public Date dataIncheiere;
public String observatiiContract;
public Furnizor furnizor;
public Contract(Date dataInceput, Date dataIncheiere,
		String observatiiContract, Furnizor furnizor) {
	super();
	this.dataInceput = dataInceput;
	this.dataIncheiere = dataIncheiere;
	this.observatiiContract = observatiiContract;
	this.furnizor = furnizor;
}
public Date getDataInceput() {
	return dataInceput;
}
public void setDataInceput(Date dataInceput) {
	this.dataInceput = dataInceput;
}
public Date getDataIncheiere() {
	return dataIncheiere;
}
public void setDataIncheiere(Date dataIncheiere) {
	this.dataIncheiere = dataIncheiere;
}
public String getObservatiiContract() {
	return observatiiContract;
}
public void setObservatiiContract(String observatiiContract) {
	this.observatiiContract = observatiiContract;
}
public Furnizor getFurnizor() {
	return furnizor;
}
public void setFurnizor(Furnizor furnizor) {
	this.furnizor = furnizor;
}

}


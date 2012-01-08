package org.open.erp.services.vanzari;

import java.io.Serializable;

import javax.persistence.Entity;

import org.open.erp.services.nomgen.Persoana;

/**
 * @author Irina Bogdan
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
public class Vanzator extends Persoana implements Serializable {

	//Integer idVinzator;
	String nume;
	String prenume;
	//String adresa;
	Integer codAcces;

	public Vanzator(){super();}
	
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
	public Integer getCodAcces() {
		return codAcces;
	}
	public void setCodAcces(Integer codAcces) {
		this.codAcces = codAcces;
	}
	
	
}

package org.open.erp.services.marketing;

import java.io.Serializable;

import javax.persistence.Entity;

import org.open.erp.services.nomgen.PersoanaFizica;

@Entity
public class PersoanaTinta extends PersoanaFizica implements Serializable{
	public PersoanaTinta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idPersoana
	 * @param nume
	 * @param prenume
	 */
	public PersoanaTinta(Integer idPersoana, String nume, String prenume) {
		super();
		this.setId(idPersoana);
		this.setNume(nume);
		this.setPrenume(prenume);
		// TODO Auto-generated constructor stub
	}

}

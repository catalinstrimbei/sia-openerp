package org.open.erp.services.marketing;



import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.open.erp.services.nomgen.PersoanaFizica;

@MappedSuperclass
public class PersoanaTinta extends PersoanaFizica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

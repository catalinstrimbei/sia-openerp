package org.open.erp.services.marketing;



import javax.persistence.MappedSuperclass;

import org.open.erp.services.nomgen.PersoanaFizica;

@MappedSuperclass
public class PersoanaTinta extends PersoanaFizica {
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

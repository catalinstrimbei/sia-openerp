package org.open.erp.services.personal.impl;

import org.open.erp.services.personal.Persoana;
import org.open.erp.services.personal.PersonalSRV;

/**
* 
* @ApplicationServiceFacadeImpl(Dummy)
* 
*/
public class PersonalDummyImpl implements PersonalSRV{

	@Override
	public Persoana creazaPersona(Integer idPersoana, String nume,
			String prenume) {
		 Persoana p = new Persoana();
		 p.setIdPersoana(idPersoana);
		 p.setNume(nume);
		 p.setPrenume(prenume);

		 return p;
	}

	@Override
	public Persoana getPersoanaCuId(Integer idPersoana) {
		 Persoana p = new Persoana();
		 p.setIdPersoana(idPersoana);
		 p.setNume("dummy");
		 return p;
	}
	
	

}

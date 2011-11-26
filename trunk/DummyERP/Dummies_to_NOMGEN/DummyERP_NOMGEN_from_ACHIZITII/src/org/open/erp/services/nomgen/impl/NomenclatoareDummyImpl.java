package org.open.erp.services.nomgen.impl;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
/*
 * 
 * @ApplicationServiceFacadeImpl(Dummy)
 * 
 */
public class NomenclatoareDummyImpl implements NomenclatoareSrv{

	@Override
	public Document getDocument(Integer nrDocument, String data,
			String observatie, Persoana persoana) {
		
		return new Document();
	}

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

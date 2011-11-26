package org.open.erp.services.nomgen.impl;

import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
/*
 * 
 * @ApplicationServiceFacadeImpl(Dummy)
 * 
 */
public class NomenclatoareDummyImpl implements NomenclatoareSrv{

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

	@Override
	public Material creazaMat(int idMaterial, String numeMaterial, int idContMat) {
		// TODO Auto-generated method stub
		Material m = new Material();
		m.idMaterial = idMaterial;
		m.numeMaterial = numeMaterial;
		return m;
	}

}

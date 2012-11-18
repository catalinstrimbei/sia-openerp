package org.open.erp.services.nomgen.impl;

import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.Subdepartament;




public class NomenclatoareImpl implements NomenclatoareSrv {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(NomenclatoareImpl.class.getName());

	

	@Override
	public PersoanaFizica crearePF(Integer id, String nume, String sex,
			String mail, String statutInCompanie, String stareCivila,
			String dataNastere, String telefon, Adresa adresa) {
		logger.debug("1. Creare persoana fizica");
		PersoanaFizica persF = new PersoanaFizica (id, nume, sex, mail, statutInCompanie, stareCivila, dataNastere, telefon, adresa);
		return persF;
	}

	@Override
	public Adresa creareAdresa(String id, String localitate, String judet,
			String tara, String strada, String codPostal) {
		logger.debug("1. Creare adresa");
		Adresa adresa = new Adresa (id,localitate,judet,tara,strada,codPostal);
		return adresa;
	}
	
	@Override
	public PersoanaJuridica crearePJ(Integer id, String nume,
			String denumireFirma, String tipFirma, String CUI,
			String codFiscal, Adresa adresa) {
		logger.debug("2. Creare persoana juridica");
		PersoanaJuridica persJ=new  PersoanaJuridica(id, nume,  denumireFirma, tipFirma, CUI, codFiscal, adresa);
		return persJ;
	}

	@Override
	public Departament creareDepart(String id, String denumire) {
		logger.debug("1. Creare Departament");
		Departament dep = new Departament (id, denumire);
		return dep;
	}

	@Override
	public Subdepartament creareSubDep(String id, String denumire,
			String descriere, Departament parinte) {
		logger.debug("2. Creare Subdepartament");
		Subdepartament subd = new Subdepartament(id, denumire, descriere, parinte);
		return subd;
	}

	@Override
	public Divizie creareDivizie(String id, String denumire, String descriere,
			Departament parinte, String dataInfiintarii, Subdepartament parinte2) {
		logger.debug("3. Creare Divizie");
		Divizie div = new  Divizie(id, denumire, descriere, parinte, dataInfiintarii, parinte2);
		return div;
	}

	







}

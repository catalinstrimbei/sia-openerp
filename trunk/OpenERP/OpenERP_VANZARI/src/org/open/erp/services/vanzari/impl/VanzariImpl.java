package org.open.erp.services.vanzari.impl;


import java.util.Date;

import org.open.erp.services.nomgen.Clienti;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.Produse;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.vanzari.Comenzi;
import org.open.erp.services.vanzari.Documente;
import org.open.erp.services.vanzari.OfertePret;
import org.open.erp.services.vanzari.Responsabil;
import org.open.erp.services.vanzari.VanzariSrv;

/**
 * 
 * @ApplicationServiceImplementation
 *
 */
public class VanzariImpl implements VanzariSrv{

	private NomenclatoareSrv nomencaltoareSrv;
	private NomenclatorMaterialeSrv nomenclatoareMaterialeSrv;
	private PersonalSrv personalSrv;
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VanzariImpl.class.getName());

	public void setNomencaltoareSrv(NomenclatoareSrv nomencaltoareSrv) {
		this.nomencaltoareSrv = nomencaltoareSrv;
	}

	public void setNomenclatoareMaterialeSrv(
			NomenclatorMaterialeSrv nomenclatoareMaterialeSrv) {
		this.nomenclatoareMaterialeSrv = nomenclatoareMaterialeSrv;
	}

	public void setPersonalSrv(PersonalSrv personalSrv) {
		this.personalSrv = personalSrv;
	}

	@Override
	public OfertePret creareOfertePret(Produse produs, Clienti client,
			Date dataValabilitate, String observatii)  {
		Date data= new Date();
		
		logger.debug("1.1 Creare oferta de pret");
		OfertePret ofertaPret=new OfertePret(1, produs, client, data, dataValabilitate, observatii);
		return ofertaPret;
	}

	@Override
	public Comenzi creareComanda(Produse produs, OfertePret ofertePret,
			Date data, Double cantitateComandata, Double cantitateAcceptata) {
		logger.debug("1.2 Creare comanda");
		double valoare=0;
		
		Comenzi creareComanda= new Comenzi(1, produs, ofertePret, data, cantitateComandata, cantitateAcceptata, valoare);
		return null;
	}

	@Override
	public Documente creareDocument(Responsabil responsabil, Produse produs,
			Comenzi comanda) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

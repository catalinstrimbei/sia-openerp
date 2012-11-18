package org.open.erp.services.vanzari.impl;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.Is;
import org.open.erp.services.nomgen.Clienti;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.Produse;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.vanzari.ArticolComanda;
import org.open.erp.services.vanzari.Comenzi;
import org.open.erp.services.vanzari.Documente;
import org.open.erp.services.vanzari.Facturi;
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
		Date dataEmitere=new Date(System.currentTimeMillis());
		
		logger.debug("1.1 Creare oferta de pret");
		
		
		OfertePret ofertaPret= new OfertePret(1, produs, client, new Date(), dataEmitere, observatii);
	
		return ofertaPret;
	}	

	

	@Override
	public Comenzi creareComanda(Date data, List<ArticolComanda> articole) {
		logger.debug("2.1 Creare comanda");
				
		Comenzi creareComanda=new Comenzi(1, new Date(), articole);
		
		return creareComanda;
	}

	@Override
	public Facturi creareFactura(Responsabil responsabil, Produse produs,
			Comenzi comanda) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

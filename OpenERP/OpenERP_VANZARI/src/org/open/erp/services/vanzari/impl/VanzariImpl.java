package org.open.erp.services.vanzari.impl;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.Is;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.vanzari.ArticolComanda;
import org.open.erp.services.vanzari.Avize;
import org.open.erp.services.vanzari.Comenzi;
import org.open.erp.services.vanzari.DispozitiiLivrare;
import org.open.erp.services.vanzari.Facturi;
import org.open.erp.services.vanzari.LiniiAviz;
import org.open.erp.services.vanzari.LiniiDispozitieLivrare;
import org.open.erp.services.vanzari.LiniiFactura;
import org.open.erp.services.vanzari.OfertePret;
import org.open.erp.services.vanzari.Produse;
import org.open.erp.services.vanzari.VanzariSrv;

/**
 * 
 * @ApplicationServiceImplementation
 *
 */
public class VanzariImpl implements VanzariSrv{

	private NomenclatoareSrv nomencaltoareSrv;
	private StocuriSrv stocuriSrv;
	private PersonalSrv personalSrv;
	
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VanzariImpl.class.getName());

	

	

	public PersonalSrv getPersonalSrv() {
		return personalSrv;
	}

	public void setNomencaltoareSrv(NomenclatoareSrv nomencaltoareSrv) {
		this.nomencaltoareSrv = nomencaltoareSrv;
	}

	public void setStocuriSrv(StocuriSrv stocuriSrv) {
		this.stocuriSrv = stocuriSrv;
	}
	

	@Override
	public Comenzi creareComanda(Integer idComanda, Date data,
			List<ArticolComanda> articole) {
		logger.debug("II.1 Creare comanda");
		
		Comenzi creareComanda=new Comenzi(1, new Date(), articole);
		
		return creareComanda;
	}




	@Override
	public void setPersonalSrv(PersonalSrv personalSrv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStocuri(StocuriSrv stocuriSrv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OfertePret creareOfertePret(Integer idOfertaPret, Produse produs,
			Date dataValabilitate, Date dataeminiteri, String observatii) {
			logger.debug("I.1 Creare oferta de pret");
	
			OfertePret ofertaPret= new OfertePret(1, produs, new Date(), new Date(), observatii);
	 
		return ofertaPret;
	}

	@Override
	public Facturi creareFactura(Integer idFactura, Date data,
			Angajat responsabil, Avize aviz, Comenzi comanda,
			List<LiniiFactura> liniiFactura) {
		logger.debug("V.1 Creare factura");
		Facturi factura=new Facturi(1,new Date(), responsabil, aviz, comanda, liniiFactura);
		
		return factura;
	}

	@Override
	public Avize creareAviz(Integer idAviz, Date date, Angajat responsabil,
			Comenzi comanda, List<LiniiAviz> liniiAviz) {
		logger.debug("IV.1 Creare aviz");
		Avize aviz=new Avize(1, new Date(), responsabil, comanda, liniiAviz);
		return aviz;
	}

	@Override
	public DispozitiiLivrare creareDispozitieLivrare(
			Integer idDispozitieLivrare, Date data, Angajat responsabil,
			Comenzi comanda, List<LiniiDispozitieLivrare> liniiDispozitieLivrare) {
		logger.debug("III.1 Creare dispozitie livrare");
		DispozitiiLivrare dispozitie=new DispozitiiLivrare(1, new Date(), responsabil, comanda, liniiDispozitieLivrare);
		return dispozitie;
	}

	
}
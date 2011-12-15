package org.open.erp.services.plati.impl;

import org.open.erp.services.plati.CEC;
import org.open.erp.services.plati.OrdinPlata;
import org.open.erp.services.plati.DocumentPlata;
import org.open.erp.services.plati.Factura;
import org.open.erp.services.plati.FinPlatiSrv;
import org.open.erp.services.plati.exceptions.PlatiExceptions;
import org.open.erp.services.vanzari.FacturaEmisa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.TipPlata;
import org.open.erp.services.ctbgen.StareDocument;
import org.open.erp.services.ctbgen.exceptii.CtbException;
import org.open.erp.services.incasari.Incasare;
import org.open.erp.services.nomgen.PersoanaJuridica;

public class FinPlatiImpl implements FinPlatiSrv {
	
	private ContabilizareSrv ctbSrv;
	
	public ContabilizareSrv getCtbSrv() {
		return ctbSrv;
	}

	public void setCtbSrv(ContabilizareSrv ctbSrv) {
		this.ctbSrv = ctbSrv;
	}

	@Override
	public Factura inregistrareFactura(String seriaNr, Date data, Double totalPlata, PersoanaJuridica furnizor, PersoanaJuridica client, List<Factura> facturi)throws PlatiExceptions {
		// TODO Auto-generated method stub
		if (totalPlata == null ||  totalPlata == 0.00 ) {
			throw new PlatiExceptions("Suma de platit nu poate fi nula!");
		}
		List<Factura> facturiS = new ArrayList<Factura>(0);
		Calendar currentDate = Calendar.getInstance();
		Date dataCurenta = currentDate.getTime();
		
		Factura factura = new Factura(seriaNr, data, totalPlata, furnizor, client);
		
		
		return  null;
	}
	
	public void confirmarePlata(DocumentPlata doc) throws CtbException,
	PlatiExceptions {
		Calendar currentDate = Calendar.getInstance();
		Date dataCurenta = currentDate.getTime();
		if (doc instanceof CEC) {

			((CEC) doc).setStare("incasat");
			
			//jurnalizarePlata

		//	(Date data, Double valInc, Integer nrDoc,
		//			TipPlata tipPlata, Integer idPartener, Integer idCont,
		//			StareDocument stareDocument, Integer idInreg) throws CtbException{
			
			/*ctbSrv.jurnalizarePlata(dataCurenta, doc.getTotalPlata(),
			doc.getSeriaNr(), TipPlata.CEC, doc.getFacturi().get(0)
					.getClient().getId(), 0, StareDocument.MODIFICAT, 0);

		} else if (doc instanceof OrdinPlata) {
			((OrdinPlata) doc).setStare("incasat");

			ctbSrv.jurnalizarePlata(dataCurenta, doc.getTotalPlata(),
			doc.getSeriaNr(), TipPlata.OrdinPlata, doc.getFacturi().get(0)
					.getClient().getId(), 0, StareDocument.MODIFICAT, 0);*/
}
}
	
	public boolean efectPlata(Double totplata) {
		return true;
	}

	@Override
	public Double compensariParteneri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double verificareSoldFurnizor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double plataAvans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double restPlata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double plataFactNumerar() {
		// TODO Auto-generated method stub
		return null;
	}
}

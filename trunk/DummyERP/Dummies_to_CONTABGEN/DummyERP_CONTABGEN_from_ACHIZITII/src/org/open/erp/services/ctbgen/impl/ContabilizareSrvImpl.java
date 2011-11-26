package org.open.erp.services.ctbgen.impl;

import java.util.Date;
import java.util.List;

import org.open.erp.services.ctbgen.ArticolCtb;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.InregistrareRJ;
import org.open.erp.services.ctbgen.ListaContMatVal;
import org.open.erp.services.ctbgen.PlanConturi;
import org.open.erp.services.ctbgen.SablonNC;

public class ContabilizareSrvImpl implements ContabilizareSrv {

	@Override
	public Integer jurnalizareVanzare(Date data, Double valFact, Integer nrDoc,
			Integer idPartener, List<ListaContMatVal> listaContMat, Integer stareInreg,
			Integer idInreg) {
		// TODO Auto-generated method stub
		
		InregistrareRJ inregVanzare = new InregistrareRJ();
		ArticolCtb articolVanzare = new ArticolCtb();
		SablonNC sablonVanzare= new SablonNC();
		//sablonVanzare=getContDdupaNr(7);
		return null;
	}

	@Override
	public int jurnalizareAchizitie(Date data, Double valFact, String nrDoc,
			Integer idPartener, List<ListaContMatVal> listaContMat, Integer stareInreg,
			Integer idInreg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int jurnalizareIncasare(Date data, Double valInc, Integer nrDoc,
			Integer tipInc, Integer idPartener, Integer idCont,
			Integer stareInreg, Integer idInreg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int jurnalizarePlata(Date data, Double valInc, Integer nrDoc,
			Integer tipPlata, Integer idPartener, Integer idCont,
			Integer stareInreg, Integer idInreg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int jurnalizareSalarii(Date data, Double valBrut, Double sanatAng,
			Double somajAng, Double casAng, Double impAng, Double sanatFirma,
			Double somajFirma, Double casFirma, Double medicFirma,
			Double riscFirma, Integer stareInreg, Integer idInreg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int jurnalizareConsum(Date data, Integer nrDoc,
			List<ListaContMatVal> listaContMat, Integer stareInreg,Integer idInreg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int jurnalizareProductie(Date data, Integer nrDoc,
			List<ListaContMatVal> listaContMat, Integer stareInreg,Integer idInreg) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void jurnalizareNcDiversa() {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer verificaLunaInchisa(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getidLunaDoc(Date data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIdCont(Cont cont) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cont crearePlanCont() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SablonNC creareSablonNC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inchideLuna() {
		// TODO Auto-generated method stub

	}

	@Override
	public void anuleazaInchidere() {
		// TODO Auto-generated method stub

	}

	@Override
	public PlanConturi getPlanConturi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getContDisponibil(Cont cont) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

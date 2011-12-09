package org.open.erp.services.plati.impl;

import org.open.erp.services.plati.Factura;
import org.open.erp.services.plati.FinPlatiSrv;

import java.util.Date;
import org.open.erp.services.ctbgen.ContabilizareSrv;
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
	public Factura inregistrareFactura(String seriaNr, Date data, Double totalPlata, PersoanaJuridica furnizor, PersoanaJuridica client) {
		// TODO Auto-generated method stub
		return  null;
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

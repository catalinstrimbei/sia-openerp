package org.open.erp.services.contabgest.impl;

import java.util.Date;
import java.util.List;

import org.open.erp.services.contabgest.Analiza;
import org.open.erp.services.contabgest.Calculatii;
import org.open.erp.services.contabgest.ContabilitateGestiuneSRV;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.Reteta;

public class ContabilitateGestiuneImpl implements ContabilitateGestiuneSRV{

	@Override
	public Analiza creareAnaliza(String numeAnaliza, Date dataInceput,
			Date dataSfarsit, Double procentRealizare)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Analiza creareAnaliza(Analiza analizaNoua) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Analiza salvareAnaliza(Analiza analiza) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calculatii creareCalculatii(Analiza analiza, Reteta reteta,
			Double valoareCost) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startAnaliza(Analiza analiza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Analiza getAnaliza(Integer IdAnaliza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Analiza> getAnaliza() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	//  public  double costFinal(){
	    	
	 //   	Material material= this.reteta.getMaterial();
	   // 	double cost = Double.parseDouble( material.getPretStandard()) * reteta.getCantitateM() + costuriExtra.getValoareCost();

	 // 	return cost;
	 //   }
}

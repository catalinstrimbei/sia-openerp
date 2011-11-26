package org.open.erp.services.stocuri.impl;

import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.StocuriSrv;

/*
 * @author Irina Bogdan
 */

public class StocuriDummyImpl implements StocuriSrv {
	
	// ar trebuie sa fie metode statice
	public boolean actualizeazaStoc(String idProdus){
		return true;
	}
	
	public ArticolStoc cautaProdusDupaNume(String denumire){
		ArticolStoc produs = new ArticolStoc();
		produs.setNumeProdus(denumire);
		return produs;
	}
	
	public ArticolStoc cautaProdusDupaId(String idProdus){
		ArticolStoc produs = new ArticolStoc();
		produs.setIdProdus(idProdus);
		produs.setNumeProdus("lapte batut");
		produs.setPretUnitar(3.5);
		produs.setProcentTva((float)0.24);
		return produs;
	}
}

package org.open.erp.services.stocuri;

/*
 * @author Irina Bogdan
 */
public interface StocuriSrv {

	//ar trebuie sa fie metode statice
	public boolean actualizeazaStoc(String idProdus);
	public ArticolStoc cautaProdusDupaNume(String denumire);
	public ArticolStoc cautaProdusDupaId(String idProdus);
}

package org.open.erp.services.contabgest;

import java.util.Date;

public interface ContabGestSrv {
	
	/*
	public DummyPersoana defDummyPersoana(	String  nume,
											String  prenume,
											String  formaAdresare
											) throws Exception;
	*/
	public ProdusFinit defProdusFinit(String den, Double procProfit) throws Exception;
	public ProdusFinit getProdusFinit(Integer idProdusFinit) throws Exception;
	/*
	public DummyPersoana getPersoanaId(Integer idPersoana) throws Exception;
	*/


	public 	CheltuieliFixe defCheltuieliFixe(String tipCheltuiala,
			String denCheltuiala, String delatiiCheltuiala) throws Exception;
	
}

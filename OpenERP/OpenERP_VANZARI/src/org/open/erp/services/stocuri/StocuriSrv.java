package org.open.erp.services.stocuri;

public interface StocuriSrv {
	public Produse vizualizareProduse ( Produse produs );
	public String iesireStoc(Produse produs, Double cantitatea);
}

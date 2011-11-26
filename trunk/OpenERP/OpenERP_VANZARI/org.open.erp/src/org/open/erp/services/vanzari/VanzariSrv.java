package org.open.erp.services.vanzari;

import org.open.erp.services.stocuri.ArticolStoc;


/*
 * @author Irina Bogdan
 */

public interface VanzariSrv {
	public boolean livrareProduse();
	public FacturaVanzare facturareProduse(Integer nrComanda, Vanzator vanzator);
	public void returProduse(FacturaVanzare fact);
	public void verificareStoc();
	public Comanda inregistrareComanda(ArticolStoc[] produs, Float[] cant, Client client);
	public boolean procesareComanda(Comanda comanda);
	public void incheiereContract(Client client);
	public Comanda getComenziClient(Integer idClient);
	public void getVanzariLunare(String luna, String an);
}

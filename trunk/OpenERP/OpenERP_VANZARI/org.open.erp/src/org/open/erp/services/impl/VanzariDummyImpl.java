package org.open.erp.services.impl;

/*
 * @author Irina Bogdan
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 * 
 * @Dependente: StocuriSrv
 * 
 * @EntitatiStocuri: ArticolStoc
 * 
 * @EntitatiLocale: Client, FacturaVanzare, Comanda, Vanzator
 */

import java.util.Date;

import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.vanzari.*;
//import org.open.erp.services.vanzari.VanzariSrv;


public class VanzariDummyImpl implements VanzariSrv{
		
	@Override
	public boolean livrareProduse(){
		return true;
	}
	@Override
	public FacturaVanzare facturareProduse(Integer nrComanda, Vanzator vanzator){
		Comanda comanda; // = new Comanda(nrComanda);
		FacturaVanzare factura = null;
		if((comanda = Comanda.gasesteComanda(nrComanda)) == null){
			// Exceptie: comanda not found
		} else{
			factura = new FacturaVanzare();
			factura.setNrComanda(nrComanda);
			factura.setDataFacturare(new Date());
			factura.setValida(false);
			factura.setIdClient(comanda.getIdClient());
			// ....
			// insert invoice into BD
			// send email to user
		}
		return factura;
	}
	@Override
	public void returProduse(FacturaVanzare fact){
		if( fact.isReturnable()){
			// do smth
			//FacturaVanzare facturaRetur = (FacturaVanzare) fact.clone();
		}
	}
	@Override
	public void verificareStoc(){
		
	}
	@Override
	/*
	 * @param ArticolStoc produs
	 * @param Client client
	 * 
	 */
	public Comanda inregistrareComanda(ArticolStoc[] produs, Float[] cant, Client client){	// creareComanda	
		Comanda comanda = new Comanda();
		comanda.setData(new Date());
		comanda.setIdClient(client.getIdClient());
		for(int i=0; i<=produs.length; i++){
			comanda.addProdusInComanda(produs[i].getIdProdus(), null, cant[i]);
		}
		/*comanda.calculeazaValoareCuDiscount();
		comanda.calculeazaTvaComanda();*/

		return comanda;
	}
	
	@Override
	public boolean procesareComanda(Comanda comanda){
		// inregistrarea ei in bd
		return true;
	}
	@Override
	public void incheiereContract(Client client){}
	
	@Override
	public Comanda getComenziClient(Integer idClient) {
		Comanda comanda = new Comanda();
		return comanda;
	}
	@Override
	public void getVanzariLunare(String luna, String an) {
		// TODO Auto-generated method stub
		
	}
	
}

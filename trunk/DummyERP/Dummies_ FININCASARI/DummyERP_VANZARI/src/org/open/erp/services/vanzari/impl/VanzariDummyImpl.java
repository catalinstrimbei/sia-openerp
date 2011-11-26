package org.open.erp.services.vanzari.impl;

import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.vanzari.Client;
import org.open.erp.services.vanzari.FacturaVanzare;
import org.open.erp.services.vanzari.VanzariSrv;

/*
 * 
 * @ApplicationServiceFacadeImpl(Dummy)
 * 
 */
public class VanzariDummyImpl implements VanzariSrv {

	@Override
	public List<FacturaVanzare> getFacturaDupaNumar(ArrayList<String> nrFactura) {
		List<FacturaVanzare> facturi = new ArrayList<FacturaVanzare>();
		for (String nrFact : nrFactura) {
			if (!nrFact.equals(null) && !nrFact.equals("")) {
				FacturaVanzare factura = new FacturaVanzare();
				factura.setNrfactura(nrFact);
				factura.setSumaIncasata(0.00);
				facturi.add(factura);
			}
		}
		return facturi;
	}

	@Override
	public Client getClientDupaID(String idClient) {
		Client client = new Client();
		client.setIdClient(idClient);
		return client;
	
	}

	
}

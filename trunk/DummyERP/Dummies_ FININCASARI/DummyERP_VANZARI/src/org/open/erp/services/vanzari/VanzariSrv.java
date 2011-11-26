package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author catalin.strimbei
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 */

public interface VanzariSrv {
	
	List<FacturaVanzare> getFacturaDupaNumar(ArrayList<String> nrFactura);
	
	Client getClientDupaID(String idClient);
	
}

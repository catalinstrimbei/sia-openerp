package org.open.erp.services.finincasari.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.finincasari.FinanciarIncasariSrv;
import org.open.erp.services.finincasari.impl.FinanciarIncasariImpl;
//import org.open.erp.services.vanzari.VanzariSrv;


/**
 * @author Isabela
 *
 */
public class FinanciarIncasariSrvFactory {
	
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(FinanciarIncasariSrvFactory.class.getName());
	
	public static FinanciarIncasariSrv getIncasariSrv(){
		
		FinanciarIncasariSrv IncasariSrv = new FinanciarIncasariImpl();
		
		//VanzariSrv vanzariSrv = FinanciarIncasariSrvFactory.getVanzariSrv();
		//IncasariSrv.setVanzariSrv(vanzariSrv);
		
		//logger.info("Crerare FinanciarIncasariSrv instance from FinanciarIncasariSrvFactory!");
		return IncasariSrv;
		
	}
	

	//private static VanzariSrv getVanzariSrv() {
		// TODO Auto-generated method stub
		//return new VanzariSrv() {
		//};
	}



			
	


	




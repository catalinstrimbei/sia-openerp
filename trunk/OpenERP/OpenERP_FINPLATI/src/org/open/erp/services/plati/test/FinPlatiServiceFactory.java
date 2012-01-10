package org.open.erp.services.plati.test;

import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.impl.ContabilizareSrvImpl;
import org.open.erp.services.plati.FinPlatiSrv;
import org.open.erp.services.plati.impl.FinPlatiImpl;

public class FinPlatiServiceFactory {
	
		public static FinPlatiSrv getFinPlatiSrv(){
			FinPlatiImpl platiSrv = new FinPlatiImpl();
			platiSrv.setCtbSrv(getContabilizareSrv());
			return platiSrv;
		}
		
		
		public static ContabilizareSrv getContabilizareSrv(){
			return new ContabilizareSrvImpl();
		}
}

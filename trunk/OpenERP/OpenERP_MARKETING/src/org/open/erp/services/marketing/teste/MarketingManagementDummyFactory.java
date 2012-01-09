package org.open.erp.services.marketing.teste;

import org.open.erp.services.marketing.MarketingManagementSrv;
import org.open.erp.services.marketing.impl.MarketingManagementImpl;
//import org.open.erp.services.nomgen.NomenclatoareSrv;
//import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;

/*
 * 
 * @Factory(ProjectManagementSrv, BugetareSrv, NomGenSrv) 
 *  
 *  Furnizeaza depedente Dummy pentru serviciul local si cele dependente
 * 
 */

public class MarketingManagementDummyFactory {
	public static MarketingManagementSrv getMarketingManagementSrv(){
		MarketingManagementImpl MarketingSrv = new MarketingManagementImpl();
		
		MarketingSrv.init();
		return MarketingSrv;
	}
	
	
//	public static NomenclatoareSrv getNomenclatoareSrv(){
//		return new NomenclatoareDummyImpl();
//	}
}

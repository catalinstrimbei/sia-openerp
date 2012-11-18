package org.open.erp.services.achizitii.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.impl.AchizitiiImpl;
import org.open.erp.services.nomgen.NomenclatoareGeneraleSrv;
import org.open.erp.services.nommat.Materiale;
import org.open.erp.services.nommat.NomenclatorGeneralSrv;


public class AchizitiiSrvFactory {
	private static Logger logger = Logger.getLogger(AchizitiiSrvFactory.class.getName());


	public static AchizitiiSrv getAchizitiiSrv(){
		AchizitiiSrv achizitiiSrv = new AchizitiiImpl();
		NomenclatorGeneralSrv nomGenServ = AchizitiiSrvFactory.getMaterialSrv();
	//	NomenclatoareGeneraleSrv nomGen2Srv=AchizitiiSrvFactory.getFurnizoriSrv();
		achizitiiSrv.setMaterialSrv(nomGenServ);
		
		logger.info("Crerare ProjectManagementSrv instance from ProjectManagementSrvFactory!");
		
		return achizitiiSrv;
	}
	
	

	public static NomenclatorGeneralSrv getMaterialSrv(){
		logger.info("Creare dummy instance of NomenclatorGeneralSrv from NomenclatorGeneralSrvFactory!");
		// Dummmy Implementation of BugetareSrv
		return new NomenclatorGeneralSrv()
		{
			
			
		};
		// ----
		
		}
		
	
	
	
	
	//mai trebuie facut si pentru furnizori
}
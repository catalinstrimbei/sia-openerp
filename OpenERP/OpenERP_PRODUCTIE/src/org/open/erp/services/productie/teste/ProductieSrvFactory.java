package org.open.erp.services.productie.teste;

import org.apache.log4j.Logger;

import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareImpl;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.impl.NomenclatorMaterialeImpl;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.impl.PersonalImpl;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.impl.ProductieImpl;


public class ProductieSrvFactory {

	private static Logger logger = Logger.getLogger(ProductieSrvFactory.class.getName());

	public static ProductieSrv getProductieSrv(){
		ProductieSrv productieSrv = new ProductieImpl();
		NomenclatoareSrv nomenclatoareSrv = ProductieSrvFactory.getNomenclatoareSrv();
		productieSrv.setNomenclatoareSrv(nomenclatoareSrv);
		
		logger.info("Creare ProductieSrv instance from ProductieSrvFactory!");
		
		return productieSrv;
	}
	
	//	
	public static NomenclatoareSrv getNomenclatoareSrv(){
		logger.info("Creare dummy instance of NomenclatoareSrv from NomenclatoareSrvFactory!");
		// Dummmy Implementation of NomenclatoareSrv
		return new NomenclatoareImpl();

	}	
	//
			public static NomenclatorMaterialeSrv getNomenclatoareMaterialeSrv(){
				logger.info("Creaza Dummy NOMMAT SRV----");
				return new NomenclatorMaterialeImpl();
			}


			public static PersonalSrv getPersonalSrv(){
				logger.info("Creaza Dummy NOMMAT SRV----");
				return new PersonalImpl();
			}
			
}
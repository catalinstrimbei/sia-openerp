package org.open.erp.services.productie.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.productie.impl.ProductieImpl;
import org.open.erp.services.stocuri.StocuriSrv;

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
		return new NomenclatoareSrv(){
			// Null implementation
		};
		// ----
	}
	
	//
	public static NomenclatorMaterialeSrv getNomenclatorMaterialeSrv(){
		logger.info("Creare dummy instance of NomenclatorMaterialeSrv from NomenclatorMaterialeSrvFactory!");
		// Dummmy Implementation of NomenclatorMaterialeSrv
		return new NomenclatorMaterialeSrv(){
			// Null implementation
		};
		// ----
	}
	
	//
	public static PersonalSrv getPersonalSrv(){
		logger.info("Creare dummy instance of PersonalSrv from PersonalSrvFactory!");
		// Dummmy Implementation of PersonalSrv
		return new PersonalSrv(){
			// Null implementation
		};
		// ----
	}	
	
	//
	public static StocuriSrv getStocuriSrv(){
		logger.info("Creare dummy instance of StocuriSrv from StocuriSrvFactory!");
		// Dummmy Implementation of StocuriSrv
		return new StocuriSrv(){
			// Null implementation
		};
		// ----
	}	
}

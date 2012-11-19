package org.open.erp.services.nommat.teste;

import org.apache.log4j.*;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.impl.NomenclatorMaterialeImpl;

public class NomenclatorMaterialeSrvFactory {

	private static Logger logger = Logger.getLogger(NomenclatorMaterialeSrvFactory.class.getName());
	
	public static NomenclatorMaterialeSrv getNomenSrv(){
		NomenclatorMaterialeSrv nomSrv = new NomenclatorMaterialeImpl();
				
		logger.info("Creare NomenclatoarSrv instance from NomenclatoarMaterialeSrvFactory!");
		
		return nomSrv;
	}
}
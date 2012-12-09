package org.open.erp.services.vanzari.teste;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.open.erp.services.nommat.Material;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.impl.VanzariImpl;

public class VanzariSrvFactory {
	
	private static Logger logger = Logger.getLogger(VanzariSrvFactory.class.getName());
	
	public static VanzariSrv getVanzariSrv(){
		VanzariSrv vanzari = new VanzariImpl();
		logger.info("Creare instanta VanzariSRV din VanzariSrvFactory!");
		return vanzari;
		
	}
	
	
	
	
}

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
		StocuriSrv stocuriSrv=VanzariSrvFactory.getStocuriSrv();
		vanzari.setStocuri(stocuriSrv);
		return vanzari;
		
	}
	
	
	
	public static StocuriSrv getStocuriSrv(){
		logger.info("Creaza Dummy Stocuri SRV----");
		return new StocuriSrv()
		{

			@Override
			public Double verificareStoc(Material material) {
				logger.info(" ****Am aflat stocul produsului");
				return 0.00;
			}

			@Override
			public void iesireStoc(Material material, Double cantitatea) {
				logger.info(" *****Iesire din gestiune");
				
				
			}
		
		};
	}
}

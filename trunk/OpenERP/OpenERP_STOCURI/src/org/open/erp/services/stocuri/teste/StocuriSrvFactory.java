package org.open.erp.services.stocuri.teste;


import org.apache.log4j.Logger;
import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.achizitii.Produs;
import org.open.erp.services.productie.ProductieSrv;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriImpl;
import org.open.erp.services.vanzari.VanzariSrv;

public class StocuriSrvFactory {
	
	private static Logger logger = Logger.getLogger(StocuriSrvFactory.class.getName());
	
	public static StocuriSrv getStocuriSrv(){
		StocuriSrv stocuri = new StocuriImpl();
		AchizitiiSrv achizitiiSrv = StocuriSrvFactory.getAchizitiiSrv(); 
		stocuri.setAchizitiiSrv(achizitiiSrv);
		logger.info("Crerare StocuriSrv instance from StocuriSrvFactory!");
		
		return stocuri;
		
	}
	
	public static AchizitiiSrv getAchizitiiSrv(){
		logger.info("Creaza Dummy ACHIZITIONARE SRV----");
		return new AchizitiiSrv()
		{
			@Override
			public Produs preluareProdus(Produs produs) {
				logger.info("2.1. Preluare date produs");
				return new Produs();
			}
		};
	}

	public static ProductieSrv getProductieSrv(){
		logger.info("Creaza Dummy PRODUCTIE SRV----");
		return new ProductieSrv(){
			// Null implementation
		};
	}
	
	public static VanzariSrv getVanzariSrv(){
		logger.info("Creaza Dummy VANZARI SRV----");
		return new VanzariSrv(){
			// Null implementation
		};
	}
}

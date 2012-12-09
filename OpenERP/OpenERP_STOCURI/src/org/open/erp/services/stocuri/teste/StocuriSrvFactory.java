package org.open.erp.services.stocuri.teste;


import org.apache.log4j.Logger;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriImpl;
import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.UnitateDeMasura;

public class StocuriSrvFactory {
	
	private static Logger logger = Logger.getLogger(StocuriSrvFactory.class.getName());
	
	public static StocuriSrv getStocuriSrv(){
		StocuriSrv stocuri = new StocuriImpl();
		//AchizitiiSrv achizitiiSrv = StocuriSrvFactory.getAchizitiiSrv(); 
	    //stocuri.setAchizitiiSrv(achizitiiSrv);
		logger.info("Crerare StocuriSrv instance from StocuriSrvFactory!");
		
		//NomenclatorMaterialeSrv nomenclatorMaterialeSrv = StocuriSrvFactory.getNomenclatoareMateriaelSrv();
		//stocuri.setNomenclatoareGeneraleSrv(nomenclatorMaterialeSrv);
		
		return stocuri;
		
	}
	
	/*public static AchizitiiSrv getAchizitiiSrv(){
		logger.info("Creaza Dummy ACHIZITIONARE SRV----");
		return new AchizitiiSrv()
		{
			@Override
			public Produs preluareProdus(Produs produs) {
				logger.info("2.1. Preluare date produs");
				return new Produs();
			}
		};
	}*/

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


public static NomenclatorMaterialeSrv getNomenclatoareMateriaelSrv(){
	logger.info("Creaza Dummy NOMMAT SRV----");
	return new NomenclatorMaterialeSrv(){

		@Override
		public Material introducereMaterial(String codMaterial,
				String denumireMaterial, String cantitateStandard,
				String pretStandard, String procentTVACurent,
				String observatii, ListaCaracteristici listaCaracteristici) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UnitateDeMasura incarcareUnitate(String id,
				String unitateDeMasura) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListaCaracteristici incarcareLista(String id,
				String listaCaracteristici) {
			// TODO Auto-generated method stub
			return null;
		}
		// Null implementation
	};
}
}

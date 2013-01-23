package org.open.erp.services.marketing.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.impl.MarketingSrvImpl;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareImpl;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.impl.NomenclatorMaterialeImpl;

public class MarketingSrvFactory {

	private static Logger logger = Logger.getLogger(MarketingSrvFactory.class.getName());

	public static MarketingSrv getMarketingSrv() {

		MarketingSrv marketingSrv = new MarketingSrvImpl();

		NomenclatorMaterialeSrv nommatSrv 	= MarketingSrvFactory.getProjectNommatSrv();
		//PersonalSrv 			personalSrv = MarketingSrvFactory.getProjectPersonalSrv();
		NomenclatoareSrv		nomgenSrv	= MarketingSrvFactory.getProjectNomgenSrv();

		marketingSrv.setNommatSrv(nommatSrv);
		//marketingSrv.setPersonalSrv(personalSrv);
		marketingSrv.setNomgenSrv(nomgenSrv);

		logger.info("Creare MarketingSrv instance from MarketingSrvFactory!");

		return marketingSrv;
	}

	//
	public static NomenclatorMaterialeSrv getProjectNommatSrv() {
		logger.info("Creare dummy instance of ProdusSrv from MarketingSrvFactory!");
		return new NomenclatorMaterialeImpl();
	}

	/*public static PersonalSrv getProjectPersonalSrv() {
		logger.info("Creare dummy instance of AngajatSrv from MarketingSrvFactory!");
		return new PersonalImpl();
	}
*/
	public static NomenclatoareSrv getProjectNomgenSrv() {
		logger.info("Creare dummy instance of PersoanaSrv from MarketingSrvFactory!");
		return new NomenclatoareImpl();
	}

}

package org.open.erp.services.marketing.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.impl.MarketingSrvImpl;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareImpl;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.impl.PersonalImpl;
import org.open.erp.services.productie.ProdusSrv;
import org.open.erp.services.productie.ProdusSrvImpl;

public class MarketingSrvFactory {

	private static Logger logger = Logger.getLogger(MarketingSrvFactory.class.getName());

	public static MarketingSrv getMarketingSrv() {

		MarketingSrv marketingSrv = new MarketingSrvImpl();

		ProdusSrv produsSrv = MarketingSrvFactory.getProjectProdusSrv();
		PersonalSrv personalSrv = MarketingSrvFactory.getProjectPersonalSrv();
		NomenclatoareSrv nomgenSrv = MarketingSrvFactory.getProjectNomgenSrv();

		marketingSrv.setProdusSrv(produsSrv);
		marketingSrv.setPersonalSrv(personalSrv);
		marketingSrv.setNomgenSrv(nomgenSrv);

		logger.info("Creare MarketingSrv instance from MarketingSrvFactory!");

		return marketingSrv;
	}

	//
	public static ProdusSrv getProjectProdusSrv() {
		logger.info("Creare dummy instance of ProdusSrv from MarketingSrvFactory!");
		return new ProdusSrvImpl();
	}

	public static PersonalSrv getProjectPersonalSrv() {
		logger.info("Creare dummy instance of AngajatSrv from MarketingSrvFactory!");
		return new PersonalImpl();
	}

	public static NomenclatoareSrv getProjectNomgenSrv() {
		logger.info("Creare dummy instance of PersoanaSrv from MarketingSrvFactory!");
		return new NomenclatoareImpl();
	}

}

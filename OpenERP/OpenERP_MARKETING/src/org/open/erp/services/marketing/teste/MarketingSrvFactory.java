package org.open.erp.services.marketing.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.impl.MarketingSrvImpl;
import org.open.erp.services.nomgen.AngajatSrv;
import org.open.erp.services.nomgen.AngajatSrvImpl;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareImpl;
import org.open.erp.services.productie.ProdusSrv;
import org.open.erp.services.productie.ProdusSrvImpl;

public class MarketingSrvFactory {

	private static Logger logger = Logger.getLogger(MarketingSrvFactory.class.getName());

	public static MarketingSrv getMarketingSrv() {

		MarketingSrv marketingSrv = new MarketingSrvImpl();

		ProdusSrv produsSrv = MarketingSrvFactory.getProjectProdusSrv();
		AngajatSrv angajatSrv = MarketingSrvFactory.getProjectAngajatSrv();
		NomenclatoareSrv nomgenSrv = MarketingSrvFactory.getProjectNomgenSrv();

		marketingSrv.setProdusSrv(produsSrv);
		marketingSrv.setAngajatSrv(angajatSrv);
		marketingSrv.setNomgenSrv(nomgenSrv);

		logger.info("Creare MarketingSrv instance from MarketingSrvFactory!");

		return marketingSrv;
	}

	//
	public static ProdusSrv getProjectProdusSrv() {
		logger.info("Creare dummy instance of ProdusSrv from MarketingSrvFactory!");
		return new ProdusSrvImpl();
	}

	public static AngajatSrv getProjectAngajatSrv() {
		logger.info("Creare dummy instance of AngajatSrv from MarketingSrvFactory!");
		return new AngajatSrvImpl();
	}

	public static NomenclatoareSrv getProjectNomgenSrv() {
		logger.info("Creare dummy instance of PersoanaSrv from MarketingSrvFactory!");
		return new NomenclatoareImpl();
	}

}

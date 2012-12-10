package org.open.erp.services.banci.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.banci.*;
import org.open.erp.services.banci.impl.*;

public class BanciSrvFactory {
	private static Logger logger = Logger
	.getLogger(BanciSrvFactory.class.getName());

	public static BanciSrv getBanciSrv() {
		BanciSrv contabSrv = new BanciImpl();

		logger.info("Crerare BanciSrv instance from BanciSrvFactory!");

		return contabSrv;
	}
}

package org.open.erp.services.contabgen.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;
import org.open.erp.services.contabgen.impl.ContabilitateGeneralaImpl;

public class ContabilitateGeneralaSrvFactory {

	private static Logger logger = Logger
			.getLogger(ContabilitateGeneralaSrvFactory.class.getName());

	public static ContabilitateGeneralaSrv getContabilitateGeneralaSrv() {
		ContabilitateGeneralaSrv contabSrv = new ContabilitateGeneralaImpl();

		logger.info("Crerare ContabilitateGeneralaSrv instance from ContabilitateGeneralaSrvFactory!");

		return contabSrv;
	}
}

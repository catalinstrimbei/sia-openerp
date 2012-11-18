package org.open.erp.services.finincasari.teste;

import org.apache.log4j.Logger;

import org.open.erp.services.finincasari.FinanciarIncasariSrv;
import org.open.erp.services.finincasari.impl.FinanciarIncasariImpl;
import org.open.erp.services.finincasari.teste.FinanciarIncasariSrvFactory;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.impl.VanzariImpl;
import org.open.erp.services.contabgen.ContabilitateGeneralaSrv;

public class FinanciarIncasariSrvFactory {
	
	private static Logger logger = Logger.getLogger(FinanciarIncasariSrvFactory.class.getName());

	public static FinanciarIncasariSrv getFinanciarIncasariSrv() {
		
		FinanciarIncasariImpl financiarincasariSrv = new FinanciarIncasariImpl();
		financiarincasariSrv.setVanzariSrv(getVanzariSrv());
		financiarincasariSrv.setContabilitateGeneralaSrv(getContabilitateGeneralaSrv());

		return financiarincasariSrv;
	}
	
	
	public static VanzariSrv getVanzariSrv(){
		logger.info("Creare dummy instance of VanzariSrv from VanzariSrvFactory!");
		return new VanzariImpl();
	}

	private static ContabilitateGeneralaSrv getContabilitateGeneralaSrv() {
		logger.info("Creare dummy instance of ContabilitateGeneralaSrv from ContabilitateGeneralaSrvFactory!");
		// TODO Auto-generated method stub
		return ContabilitateGeneralaImpl();
	}


	private static ContabilitateGeneralaSrv ContabilitateGeneralaImpl() {
		// TODO Auto-generated method stub
		return null;
	}


	}

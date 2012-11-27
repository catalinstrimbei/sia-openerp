package org.open.erp.services.banci.teste;

import org.open.erp.services.banci.CarduriBNC;
import org.open.erp.services.banci.CrediteBNC;
import org.open.erp.services.banci.DepoziteBNC;
import org.open.erp.services.banci.LiniiPlati;
import org.open.erp.services.banci.PlatiBNC;
import org.open.erp.services.banci.SchimbValBNC;
import org.open.erp.services.nomgen.Clienti;


public class BanciSrvFactory {
	private static Logger logger = Logger.getLogger(BanciSrvFactory.class.getName());


	public static BanciSrv getBancirv(){
		BanciSrv banciSrv = new BanciImpl();
		org.open.erp.services.nomgen = BanciSrvFactory.getClientiSrv();
	
		BanciSrv.setorg.open.erp.services.nomgen(Clienti);
		
		logger.info("Crerare ProjectManagementSrv instance from ProjectManagementSrvFactory!");
		
		return BanciSrv;
	}
	
	

	public static org.open.erp.services.nomgen getBanciSrv(){
		logger.info("Creare dummy instance of Nomenclator Clienti from BanciSrvFactory!");

	{
		return new BanciSrv();
				
		}
}}
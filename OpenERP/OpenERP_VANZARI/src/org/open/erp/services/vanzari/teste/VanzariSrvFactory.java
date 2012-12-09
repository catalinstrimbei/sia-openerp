package org.open.erp.services.vanzari.teste;

import org.apache.log4j.Logger;

import org.open.erp.services.nommat.Material;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.vanzari.Produse;
import org.open.erp.services.vanzari.Responsabil;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.impl.VanzariImpl;

public class VanzariSrvFactory {
	
	private static Logger logger = Logger.getLogger(VanzariSrvFactory.class.getName());
	
	public static VanzariSrv getVanzariSrv(){
		VanzariSrv vanzari = new VanzariImpl();
		logger.info("Creare instanta VanzariSRV din VanzariSrvFactory!");
		PersonalSrv personalSrv=VanzariSrvFactory.getPersonalSrv();
		StocuriSrv stocuriSrv=VanzariSrvFactory.getStocuriSrv();
		vanzari.setPersonalSrv(personalSrv);
		vanzari.setStocuri(stocuriSrv);
				
		return vanzari;
		
	}
	
	public static PersonalSrv getPersonalSrv(){
		logger.info("Creaza Dummy PERSONAL SRV----");
		return new PersonalSrv()
		{


			@Override
			public Responsabil preluarePersoana(String ocupatie) {
				logger.info("5.1 a) Am delegat persoana responsabila");
				return new Responsabil();
			}
			
			
		};
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

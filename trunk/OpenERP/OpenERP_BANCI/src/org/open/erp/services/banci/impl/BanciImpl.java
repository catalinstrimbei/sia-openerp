package org.open.erp.services.banci.impl;

import java.util.Date;
import java.util.List;

import org.open.erp.services.banci.CarduriBNC;
import org.open.erp.services.banci.BanciSrv;
import org.open.erp.services.banci.CrediteBNC;
import org.open.erp.services.banci.DepoziteBNC;
import org.open.erp.services.banci.LiniiPlati;
import org.open.erp.services.banci.PlatiBNC;
import org.open.erp.services.banci.SchimbValBNC;
import org.open.erp.services.buget.BugetareSrv;
import org.open.erp.services.nomgen.Clienti;
import org.open.erp.services.proman.impl.ProjectManagementImpl;


public class BanciImpl implements BanciSrv {

	private BanciSrv banciSrv;
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BanciImpl.class.getName());
	
	
	
	public void setBanciSrv(BanciSrv banciSrv) {
		this.banciSrv = banciSrv;
	}
		
	public SchimbValBNC creareSchimbValBNC(Date datatranz,Integer monedacurenta,Double valmoncurent,Integer monedaschimb,Double valmondupaschimb,Integer cursval,Double comisionscb,List<LiniiPlati> liniePlata) {
		logger.debug("1.1 Initiere/Creare schimb valutar");
		Clienti client = new Clienti();
		SchimbValBNC schimbnou = new SchimbValBNC(client, datatranz, monedacurenta, valmoncurent, monedaschimb, valmondupaschimb, cursval, comisionscb, liniePlata);
		return schimbnou;		
	}
				
		public LiniiPlati creareLinieplata(Date datatranz,Integer monedacurenta,Double valmoncurent,Integer monedaschimb,Double valmondupaschimb,Integer cursval,Double comisionscb){
			logger.debug("1.2 Adaugare linie intr-o tranzactie de schimb valutar");
			LiniiPlati linieplata = new LiniiPlati(1, datatranz, monedacurenta, valmoncurent, monedaschimb, valmondupaschimb, cursval, comisionscb);	
			SchimbValBNC.setliniePlata(linieplata);
			linieplata.setlinieplata(linieplata);
			return linieplata;
			
		}
}
	
	
	
	
	
	
}

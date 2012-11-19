package org.open.erp.services.banci.impl;

import java.util.Date;
import java.util.List;

import org.open.erp.services.banci.CarduriBNC;
import org.open.erp.services.banci.CrediteBNC;
import org.open.erp.services.banci.DepoziteBNC;
import org.open.erp.services.banci.LiniiPlati;
import org.open.erp.services.banci.PlatiBNC;
import org.open.erp.services.banci.SchimbValBNC;
import org.open.erp.services.nomgen.Clienti;


public class BanciImpl implements BanciSrv {

	
		
		public SchimbValBNC creareSchimbValBNC(Date datatranz,Integer monedacurenta,Double valmoncurent,Integer monedaschimb,Double valmondupaschimb,Integer cursval,Double comisionscb,List<LiniiPlati> liniePlata) {
			logger.debug("1.1 Initiere/Creare schimb valutar");
			
			SchimbValBNC schimbnou = new SchimbValBNC(Date datatranz,Integer monedacurenta,Double valmoncurent,Integer monedaschimb,Double valmondupaschimb,Integer cursval,Double comisionscb,List<LiniiPlati> liniePlata);
			Clienti client = BanciSrv.Clienti(client);
			schimbnou.setClienti(client);
			return schimbnou;
			
		}
				
		public LiniiPlati creareLinieplata(Date datatranz,Integer monedacurenta,Double valmoncurent,Integer monedaschimb,Double valmondupaschimb,Integer cursval,Double comisionscb){
			logger.debug("1.2 Adaugare linie intr-o tranzactie de schimb valutar");
			{
				
			LiniiPlati linieplata = new LiniiPlati(1, Date datatranz,Integer monedacurenta,Double valmoncurent,Integer monedaschimb,Double valmondupaschimb,Integer cursval,Double comisionscb);	
			schimb.adaugaLinieplata(linieplata);
			linieplata.setlinieplata(linieplata);
			return liniePlata;
			
		}
}
	
	
	
	
	
	
}

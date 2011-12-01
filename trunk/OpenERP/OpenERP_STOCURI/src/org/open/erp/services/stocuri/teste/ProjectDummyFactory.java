package org.open.erp.services.stocuri.teste;


import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.impl.AprovizionareImpl;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.impl.PersonalImpl;
import org.open.erp.services.stocuri.util.StocuriLogger;
/*
 * 
 * @Factory(StocuriSrv, AchizitionareSrv, NomGenSrv, PersonalSrv) 
 *  
 *  Furnizeaza depedente Dummy pentru serviciul local si cele dependente
 * 
 */

public class ProjectDummyFactory {
	private static StocuriLogger logger= new StocuriLogger(); 
	
	public static AprovizionareSrv  getAprovizionareSrv( ){
		logger.loggeazaINFO("Creaza Dummy ACHIZITIONARE SRV----");
		return new AprovizionareImpl();
		
	}
	
	public static NomenclatoareSrv  getNomenclatoareSrv( ){
		logger.loggeazaINFO("Creaza Dummy NOMENCLATOARE SRV----");
		return new NomenclatoareDummyImpl();
		
	}
	
	public static PersonalSrv  getPersonalSrv( ){
		logger.loggeazaINFO("Creaza Dummy PERSONAL SRV----");
		return new PersonalImpl();
		
	}
	
}

package org.open.erp.services.stocuri.teste;


import org.open.erp.services.achizitii.AchizitionareSrv;
import org.open.erp.services.achizitii.impl.AchizitionareImpl;
import org.open.erp.services.nomenclatoare.NomenclatoareSrv;
import org.open.erp.services.nomenclatoare.impl.NomenclatoareImpl;
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
	
	public static AchizitionareSrv  getAchizitionareSrv( ){
		logger.loggeazaINFO("Creaza Dummy ACHIZITIONARE SRV----");
		return new AchizitionareImpl();
		
	}
	
	public static NomenclatoareSrv  getNomenclatoareSrv( ){
		logger.loggeazaINFO("Creaza Dummy NOMENCLATOARE SRV----");
		return new NomenclatoareImpl();
		
	}
	
	public static PersonalSrv  getPersonalSrv( ){
		logger.loggeazaINFO("Creaza Dummy PERSONAL SRV----");
		return new PersonalImpl();
		
	}
	
}

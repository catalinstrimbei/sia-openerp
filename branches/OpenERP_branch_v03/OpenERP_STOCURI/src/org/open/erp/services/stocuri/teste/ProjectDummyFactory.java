package org.open.erp.services.stocuri.teste;




import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.AplicarePret;
import org.open.erp.services.stocuri.impl.Procesare;
import org.open.erp.services.stocuri.impl.StocuriImpl;
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
	private static NomenclatoareDummyImpl nomenclatoareDummyImpl;
	private static StocuriImpl stocuriImpl;
	
	/* eliminat depententa prin observer pattern
	public static AprovizionareSrv  getAprovizionareSrv( ){
		logger.loggeazaINFO("Creaza Dummy ACHIZITIONARE SRV----");
		return new AprovizionareImpl();
		
	}
	*/
	
	public static NomenclatoareSrv  getNomenclatoareSrv( ){
		logger.loggeazaINFO("Creaza Dummy NOMENCLATOARE SRV----");
		if(nomenclatoareDummyImpl== null){
			return new NomenclatoareDummyImpl();
		}
		return nomenclatoareDummyImpl;
	
	}
	
	public static StocuriSrv getStocuriSrv(Procesare procesareComandaMateriale,
			AplicarePret applicarepret ){
		logger.loggeazaINFO("Creaza Dummy stocuri SRV----");
		if(stocuriImpl == null){
			return new StocuriImpl(procesareComandaMateriale,applicarepret );
		}
		return stocuriImpl ;
	
	}
	/*
	public static PersonalSrv  getPersonalSrv( ){
		logger.loggeazaINFO("Creaza Dummy PERSONAL SRV----");
		return new PersonalImpl();
		
	}
	*/
	
}

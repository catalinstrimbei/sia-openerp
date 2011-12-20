package org.open.erp.services.achizitii.teste;

import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.impl.AprovizionareImpl;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.impl.ContabilizareSrvImpl;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriImpl;

/*
 * 
 * @Factory(StocuriSrv, ContabilizareSrv, NomGenSrv) 
 *  
 *  Furnizeaza depedente Dummy pentru serviciul local si cele dependente
 * 
 */
public class AprovizionareFactory {
	public static AprovizionareSrv getAprovizionareSrv(){
		return new AprovizionareImpl();
	}	
	
	
	public static NomenclatoareSrv getNomenclatoareSrv(){
		return new NomenclatoareDummyImpl();
	}
	public static ContabilizareSrv getContabGenSrv(){
		return new ContabilizareSrvImpl();
	}
	public static StocuriSrv getStocuriSrv(){
		return new StocuriImpl();
	}

}

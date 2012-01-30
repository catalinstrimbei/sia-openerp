package org.open.erp.services.vanzari.teste;

import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.impl.ContabilizareSrvImpl;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;
//import org.open.erp.services.stocuri.StocuriSrv;
//import org.open.erp.services.stocuri.impl.StocuriImpl;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.impl.VanzariImpl;


public class VanzariFactory {
	
	public static VanzariSrv getVanzariSrv(){
		return new VanzariImpl();
	}
	
	public static NomenclatoareSrv getNomenclatoareSrv(){
		return new NomenclatoareDummyImpl();
	}
	
	public static ContabilizareSrv getContabGenSrv(){
		return new ContabilizareSrvImpl();
	}
	
	/*public static StocuriSrv getStocuriSrv(){
		return new StocuriImpl();
	}*/

}

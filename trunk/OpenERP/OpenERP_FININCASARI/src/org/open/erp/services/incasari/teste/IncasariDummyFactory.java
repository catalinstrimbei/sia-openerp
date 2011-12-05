package org.open.erp.services.incasari.teste;


import org.open.erp.services.incasari.IncasariSrv;
import org.open.erp.services.incasari.impl.IncasariImpl;
import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.vanzari.impl.VanzariImpl;

/*
 * 
 * @Factory(IncasariSrv, BugetareSrv, VanzariSrv) 
 *  
 *  Furnizeaza depedente Dummy pentru serviciul local si cele dependente
 * 
 */

public class IncasariDummyFactory {
	public static IncasariSrv getIncasariSrv(){
		IncasariImpl incasariSrv = new IncasariImpl();
		incasariSrv.setVanzariSrv(getVanzariSrv());
//		incasariSrv.setNomenclatoareSrv(getNomenclatoareSrv());
		return incasariSrv;
	}
	
	public static VanzariSrv getVanzariSrv(){
		return new VanzariImpl();
	}
	
//	public static NomenclatoareSrv getNomenclatoareSrv(){
//		return new NomenclatoareDummyImpl();
//	}
}

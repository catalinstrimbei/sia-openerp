package org.open.erp.services.incasari.teste;


import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.impl.ContabilizareSrvImpl;
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

public class IncasariServiceFactory {
	public static IncasariSrv getIncasariSrv(){
		IncasariImpl incasariSrv = new IncasariImpl();
		incasariSrv.setVanzariSrv(getVanzariSrv());
		incasariSrv.setCtbSrv(getContabilizareSrv());
//		incasariSrv.setNomenclatoareSrv(getNomenclatoareSrv());
		return incasariSrv;
	}
	
	public static VanzariSrv getVanzariSrv(){
		return new VanzariImpl();
	}
	
	public static ContabilizareSrv getContabilizareSrv(){
		return new ContabilizareSrvImpl();
	}
}

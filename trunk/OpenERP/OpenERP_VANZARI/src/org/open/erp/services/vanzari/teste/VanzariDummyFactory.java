package org.open.erp.services.vanzari.teste;

//import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriDummyImpl;
import org.open.erp.services.vanzari.impl.VanzariImpl;
//import org.open.erp.services.vanzari.VanzariSrv;

public class VanzariDummyFactory {
	
	public static VanzariImpl getVanzariSrv(){
		return new VanzariImpl();
	}
	
	public static StocuriDummyImpl getStocuriSrv(){
		return new StocuriDummyImpl();
	}

}

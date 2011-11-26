package org.open.erp.services.teste;

//import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriDummyImpl;
//import org.open.erp.services.vanzari.VanzariSrv;
import org.open.erp.services.impl.VanzariDummyImpl;

public class VanzariDummyFactory {
	
	public static VanzariDummyImpl getVanzariSrv(){
		return new VanzariDummyImpl();
	}
	
	public static StocuriDummyImpl getStocuriSrv(){
		return new StocuriDummyImpl();
	}

}

package org.open.erp.services.achizitii.teste;

import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.impl.AprovizionareImpl;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.impl.ContabilizareSrvImpl;
import org.open.erp.services.finplati.FinplatiSrv;
import org.open.erp.services.finplati.impl.FinPlatiDummyImpl;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;
import org.open.erp.services.stocuri.StocuriSrv;
import org.open.erp.services.stocuri.impl.StocuriDummyImpl;

public class AprovizionareDummyFactory {
	public static AprovizionareSrv getAprovizionareSrv(){
		return new AprovizionareImpl();
	}
	
	public static FinplatiSrv getFinPlatiSrv(){
		return new FinPlatiDummyImpl();
	}
	
	public static NomenclatoareSrv getNomenclatoareSrv(){
		return new NomenclatoareDummyImpl();
	}
	public static ContabilizareSrv getContabGenSrv(){
		return new ContabilizareSrvImpl();
	}
	public static StocuriSrv getStocuriSrv(){
		return new StocuriDummyImpl();
	}

}

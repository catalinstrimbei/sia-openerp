package org.open.erp.services.ctbgen.teste;

import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.impl.ContabilizareSrvImpl;
/*
 * 
 * @Factory(ContabilizareSrv, NomenclatoareSrv)
 *  
 *  Furnizeaza depedente Dummy pentru serviciul local si cele dependente
 * 
 */
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;


public class ContabilizareDummyFactory {
	
		public static ContabilizareSrv getContabilizareSrv(){
			ContabilizareSrvImpl contabSrv =new ContabilizareSrvImpl();
			return contabSrv;
		}
		
		public static NomenclatoareSrv getNomenclatoareSrv(){
			return new NomenclatoareDummyImpl();
		}
}

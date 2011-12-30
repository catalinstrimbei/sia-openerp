package org.open.erp.services.salarizare.teste;

import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.impl.PersonalImpl;
import org.open.erp.services.salarizare.SalarizareSrv;
import org.open.erp.services.salarizare.impl.RegistruSalarizare;
import org.open.erp.services.salarizare.impl.SalarizareImpl;

/*
 * 
 * @Factory(SalarizareSrv, PersonalSrv, RegistruSalarizare) 
 *  
 *  Furnizeaza depedente pentru serviciul local si cele dependente
 * 
 */
public class SalarizareFactory {
	
	public static SalarizareSrv getSalarizareSrv(){
		SalarizareImpl salarizareSrv = new SalarizareImpl();
		
		salarizareSrv.setPersonalSrv(getPersonalSrv());
		salarizareSrv.setRegistru(getRegistruSalarizare());
		
		return salarizareSrv;
	}
	
	public static PersonalSrv getPersonalSrv(){
		return new PersonalImpl();
	}
	
	public static RegistruSalarizare getRegistruSalarizare(){
		return new RegistruSalarizare();
	}
	
}

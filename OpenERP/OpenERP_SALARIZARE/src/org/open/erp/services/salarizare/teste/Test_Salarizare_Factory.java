package org.open.erp.services.salarizare.teste;

import org.open.erp.services.salarizare.SRV_Salarizare;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.impl.PersonalImpl;
import org.open.erp.services.salarizare.SRV_Salarizare;
import org.open.erp.services.salarizare.impl.Implement_Salarizare;
import org.open.erp.services.salarizare.impl.Registru_Salarizare;
public class Test_Salarizare_Factory {

	 	
	 	public static SRV_Salarizare getSalarizareSrv(){
	 		Implement_Salarizare salarizareSrv = new Implement_Salarizare();
	 		
	 		salarizareSrv.setPersonalSrv(getPersonalSrv());
	 		salarizareSrv.setRegistru(getRegistruSalarizare());
	 		
	 		return salarizareSrv;
	 	}
	 	
	 	public static PersonalSrv getPersonalSrv(){
	 		return new PersonalImpl();
	 	}
	 	
	 	public static Registru_Salarizare getRegistruSalarizare(){
	 		return new Registru_Salarizare();
	 	}
	 	
	 }
	
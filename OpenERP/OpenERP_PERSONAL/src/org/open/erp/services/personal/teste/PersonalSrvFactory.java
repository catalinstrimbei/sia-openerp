package org.open.erp.services.personal.teste;

import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareImpl;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.impl.PersonalImpl;

public class PersonalSrvFactory {
	public static PersonalSrv getPersonalSrv(){
		PersonalSrv personal = new PersonalImpl();
		
		return personal;
	}
	
	public static NomenclatoareSrv getNomenclatoareSrv(){
		
		return new NomenclatoareImpl();
		
	}	
}

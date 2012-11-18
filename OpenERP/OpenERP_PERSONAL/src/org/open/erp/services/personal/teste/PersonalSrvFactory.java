package org.open.erp.services.personal.teste;

import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.impl.PersonalImpl;

public class PersonalSrvFactory {
	public static PersonalSrv getPersonalSrv(){
		PersonalSrv personal = new PersonalImpl();
		return personal;
	}
}

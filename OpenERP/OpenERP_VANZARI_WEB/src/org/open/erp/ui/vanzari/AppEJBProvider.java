package org.open.erp.ui.vanzari;

import javax.ejb.EJB;

import org.open.erp.services.vanzari.VanzariSrv;

public class AppEJBProvider {
	/* Inject EJB: chiar daca membrul este static initializarea are loc dupa instantierea clasei (dupa apelul constructorului ...) */
	@EJB(lookup="java:global/OpenERP_VANZARI/VanzariImpl!org.open.erp.services.vanzari.VanzariSrv")
	private static VanzariSrv vanzari;
	
	public static VanzariSrv getVanzariSrv(){
		return vanzari;
	}
	
	public AppEJBProvider(){
		System.out.println("APP BEAN AppEJBProvider - initialized: " + vanzari);
	}

}

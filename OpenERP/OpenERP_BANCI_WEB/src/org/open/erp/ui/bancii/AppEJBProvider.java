package org.open.erp.ui.bancii;

import javax.ejb.EJB;

import org.open.erp.services.banci.BanciSrv;

public class AppEJBProvider {
	//@ManagedBean(name="appEJBProvider", eager=true)
		//@ApplicationScoped
			/* Inject EJB: chiar daca membrul este static initializarea are loc dupa instantierea clasei (dupa apelul constructorului ...) */
			@EJB(lookup="java:global/OpenERP_BANCI/BanciImpl!org.open.erp.services.banci.BanciSrv")
			private static BanciSrv banci;
			
			public static BanciSrv getBanciSrv(){
				return banci;
			}
			
			public AppEJBProvider(){
				System.out.println("APP BEAN AppEJBProvider - initialized: " + banci);
			}
}

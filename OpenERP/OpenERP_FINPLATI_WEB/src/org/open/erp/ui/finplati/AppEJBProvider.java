package org.open.erp.ui.finplati;

import javax.ejb.EJB;

import org.open.erp.services.finplati.FinanciarPlatiSrv;

//import org.open.erp.services.finplati.FinanciarPlatiSrv;

public class AppEJBProvider {

	//@ManagedBean(name="appEJBProvider", eager=true)
	//@ApplicationScoped
		/* Inject EJB: chiar daca membrul este static initializarea are loc dupa instantierea clasei (dupa apelul constructorului ...) */
		@EJB(lookup="java:global/OpenERP_FINPLATI/FinanciarPlatiImpl!org.open.erp.services.proman.FinanciarPlatiSrv")
		private static FinanciarPlatiSrv finplati;
		
		public static FinanciarPlatiSrv getFinanciarPlatiSrv(){
			return finplati;
		}
		
		public AppEJBProvider(){
			System.out.println("APP BEAN AppEJBProvider - initialized: " + finplati);
		}
	}



package org.open.erp.ui.finincasari;

import javax.ejb.EJB;
import org.open.erp.services.finincasari.FinanciarIncasariSrv;

//@ManagedBean(name="appEJBProvider", eager=true)
//@ApplicationScoped
public class AppEJBProvider {
	/* Inject EJB: chiar daca membrul este static initializarea are loc dupa instantierea clasei (dupa apelul constructorului ...) */
	@EJB(lookup="java:global/OpenERP_FININCASARI/FinanciarIncasariImpl!org.open.erp.services.finincasari.FinanciarIncasariSrv")
	private static FinanciarIncasariSrv finincasari;
	
	public static FinanciarIncasariSrv getFinanciarIncasariSrv(){
		return finincasari;
	}
	
	public AppEJBProvider(){
		System.out.println("APP BEAN AppEJBProvider - initialized: " + finincasari);
	}
}

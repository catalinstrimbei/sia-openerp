package org.open.erp.ui.proman;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.proman.ProjectManagementSrv;

//@ManagedBean(name="appEJBProvider", eager=true)
//@ApplicationScoped
public class AppEJBProvider {
	/* Inject EJB: chiar daca membrul este static initializarea are loc dupa instantierea clasei (dupa apelul constructorului ...) */
	@EJB(lookup="java:global/OpenERP_PROMAN/ProjectManagementImpl!org.open.erp.services.proman.ProjectManagementSrv")
	private static ProjectManagementSrv proman;
	
	public static ProjectManagementSrv getProjectManagementSrv(){
		return proman;
	}
	
	public AppEJBProvider(){
		System.out.println("APP BEAN AppEJBProvider - initialized: " + proman);
	}
}

package org.open.erp.ui.productie;

import javax.ejb.EJB;

import org.open.erp.services.productie.ProductieSrv;

//@ManagedBean(name="appEJBProvider", eager=true)
//@ApplicationScoped
public class AppEJBProvider {
	
	@EJB(lookup="java:global/OpenERP_PRODUCTIE/ProductieSrvImpl!org.open.erp.services.productie.ProductieSrv")
	private static ProductieSrv productie;
	
	public static ProductieSrv getProductieSrv(){
		return productie;
	}
	
	public AppEJBProvider(){
		System.out.println("APP BEAN AppEJBProvider - initialized: " + productie);
	}

}
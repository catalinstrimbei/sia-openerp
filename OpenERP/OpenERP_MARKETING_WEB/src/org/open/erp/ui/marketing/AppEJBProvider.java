package org.open.erp.ui.marketing;

import javax.ejb.EJB;

import org.open.erp.services.marketing.MarketingSrv;

public class AppEJBProvider {
	
	@EJB(lookup="java:global/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv")
	private static MarketingSrv marketing;
	
	public static MarketingSrv getMarketingSrv(){
		return marketing;
	}
	
	public AppEJBProvider(){
		System.out.println("APP BEAN AppEJBProvider - initialized: " + marketing);
	}

}

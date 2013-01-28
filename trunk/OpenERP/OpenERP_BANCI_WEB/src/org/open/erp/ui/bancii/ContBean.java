package org.open.erp.ui.bancii;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.banci.BanciSrv;

@ManagedBean(name = "contBean")
@javax.faces.bean.RequestScoped
public class ContBean {
	@EJB(lookup="java:global/OpenERP_BANCI/BanciImpl!org.open.erp.services.banci.BanciSrv")
	private BanciSrv banciSrv;
	


	public BanciSrv getBanciSrv() {
		return banciSrv;
	}

	public void setBanciSrv(BanciSrv banciSrv) {
		this.banciSrv = banciSrv;
	}
}

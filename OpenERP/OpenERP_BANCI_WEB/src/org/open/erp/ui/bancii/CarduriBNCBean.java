package org.open.erp.ui.bancii;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.banci.BanciSrv;


@ManagedBean(name = "carduribncBean")
@javax.faces.bean.RequestScoped
public class CarduriBNCBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2577929799400568953L;
	@EJB(lookup="java:global/OpenERP_BANCI/BanciImpl!org.open.erp.services.banci.BanciSrv")
	private BanciSrv banciSrv;
	

}

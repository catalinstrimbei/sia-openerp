package org.open.erp.ui.finplati;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.open.erp.services.finplati.FinanciarPlatiSrv;


@ManagedBean(name = "plataBean")
@RequestScoped
public class PlataBean implements Serializable {
	@EJB(lookup = "java:global/OpenERP_FINPLATI/FinanciarPlatiImpl!org.open.erp.services.finplati.FinanciarPlatiSrv")
	private FinanciarPlatiSrv financiarplatiSrv;

	public PlataBean(){
	}
	public FinanciarPlatiSrv getFinanciarPlatiSrv() {
		return financiarplatiSrv;
	}

	public void setFinanciarPlatiSrv(FinanciarPlatiSrv financiarplatiSrv) {
		this.financiarplatiSrv = financiarplatiSrv;
	}
	}


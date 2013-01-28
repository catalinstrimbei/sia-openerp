package org.open.erp.ui.finplati;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.finplati.FinanciarPlatiSrv;
import org.open.erp.services.finplati.ResponsabilPlata;

@ManagedBean(name = "responsabilPlataBean")
@javax.faces.bean.RequestScoped

public class ResponsabilPlataBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(lookup="java:global/OpenERP_FINPLATI/FinanciarPlatiImpl!org.open.erp.services.finplati.FinanciarPlatiSrv")
	private FinanciarPlatiSrv financiarPlatiSrv;

	private String obsExperienta;

	//private Date dataFinal;
	
	public ResponsabilPlataBean(){
	}
	
	public FinanciarPlatiSrv getFinanciarPlatiSrv() {
		return financiarPlatiSrv;
	}

	public void setFinanciarPlatiSrv(FinanciarPlatiSrv financiarPlatiSrv) {
		this.financiarPlatiSrv = financiarPlatiSrv;
	}
/*---------------------*/
	public String getObsExperienta() {
		return obsExperienta;
	}

	public void setObsExperienta(String obsExperienta) {
		this.obsExperienta = obsExperienta;
	}

	
	public String adaugaResponsabilPlata() throws Exception{
		
		 ResponsabilPlata responsabilPlataNou = new ResponsabilPlata();
		responsabilPlataNou.setObsExperienta(obsExperienta);
		
	 //   financiarPlatiSrv.adaugaResponsabilPlata(responsabilPlataNou);
		
		return  "responsabilPlataNou";
	}
}

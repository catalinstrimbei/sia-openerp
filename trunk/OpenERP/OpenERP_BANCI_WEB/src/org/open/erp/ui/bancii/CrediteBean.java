package org.open.erp.ui.bancii;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.banci.BanciSrv;
import org.open.erp.services.banci.CrediteBNC;

@ManagedBean(name = "crediteBean")
@javax.faces.bean.RequestScoped
public class CrediteBean {
	@EJB(lookup="java:global/OpenERP_BANCI/BanciImpl!org.open.erp.services.banci.BanciSrv")
	private BanciSrv banciSrv;
	private Integer idcreditbnc;
	private String numeCompanie;
	private String numeCont;
	private Double sumaContractata;
	private Double sumaramasadeplata;
	private Date datacontractare;
	

	public BanciSrv getBanciSrv() {
		return banciSrv;
	}

	public void setBanciSrv(BanciSrv banciSrv) {
		this.banciSrv = banciSrv;
	}

	public String getNumeCompanie() {
		return numeCompanie;
	}

	public void setNumeCompanie(String numeCompanie) {
		this.numeCompanie = numeCompanie;
	}

	public String getNumeCont() {
		return numeCont;
	}

	public void setNumeCont(String numeCont) {
		this.numeCont = numeCont;
	}

	public Double getSumaContractata() {
		return sumaContractata;
	}

	public void setSumaContractata(Double sumaContractata) {
		this.sumaContractata = sumaContractata;
	}

	public Double getSumaramasadeplata() {
		return sumaramasadeplata;
	}

	public void setSumaramasadeplata(Double sumaramasadeplata) {
		this.sumaramasadeplata = sumaramasadeplata;
	}
	
	public Date getDatacontractare() {
		return datacontractare;
	}

	public void setDatacontractare(Date datacontractare) {
		this.datacontractare = datacontractare;
	}
	public String adaugaCreditNou() throws Exception{
		
		CrediteBNC creditNou = new CrediteBNC();
		//contNou.setId(id);
		creditNou.setdatacontractare(datacontractare);
		creditNou.setnumeCompanie(numeCompanie);
		creditNou.setIdcreditbnc(idcreditbnc);
		creditNou.setsumaramasadeplata(sumaramasadeplata);
		creditNou.setsumaContractata(sumaContractata);
		
	
		
	  banciSrv.creareCrediteBnc(creditNou);
		
		return "contNou";
}
}
package org.open.erp.ui.bancii;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.banci.BanciSrv;
import org.open.erp.services.banci.Cont;

@ManagedBean(name = "contBean")
@javax.faces.bean.RequestScoped
public class ContBean {
	@EJB(lookup="java:global/OpenERP_BANCI/BanciImpl!org.open.erp.services.banci.BanciSrv")
	private BanciSrv banciSrv;
	private String nume;
	private String tipCont;
	private Integer tipCard;


	public BanciSrv getBanciSrv() {
		return banciSrv;
	}

	public void setBanciSrv(BanciSrv banciSrv) {
		this.banciSrv = banciSrv;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getTipCont() {
		return tipCont;
	}

	public void setTipCont(String tipCont) {
		this.tipCont = tipCont;
	}

	public Integer getTipCard() {
		return tipCard;
	}

	public void setTipCard(Integer tipCard) {
		this.tipCard = tipCard;
	}
public String adaugaCont() throws Exception{
		
		Cont contNou = new Cont();
		//contNou.setId(id);
		contNou.setNume(nume);
		contNou.setTipCard(tipCard);
		contNou.setTipCont(tipCont);
	
	
		
	    banciSrv.adaugareCont(contNou);
		
		return "contNou";
}
}

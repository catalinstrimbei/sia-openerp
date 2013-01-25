package org.open.erp.ui.marketing;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.open.erp.services.marketing.CampaniePromovare;
import org.open.erp.services.marketing.CanalDistributie;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.TipPromovare;

@ManagedBean(name = "campaniePromovareBean")
@RequestScoped
public class CampaniePromovareBean implements Serializable {

	@EJB(lookup = "java:global/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv")
	private MarketingSrv marketingSrv;

	private TipPromovare tipPromovare;
	private CanalDistributie canalDistributie;
	private Date data;
	private int buget;

	public MarketingSrv getMarketingSrv() {
		return marketingSrv;
	}

	public void setMarketingSrv(MarketingSrv marketingSrv) {
		this.marketingSrv = marketingSrv;
	}

	public TipPromovare getTipPromovare() {
		return tipPromovare;
	}

	public void setTipPromovare(TipPromovare tipPromovare) {
		this.tipPromovare = tipPromovare;
	}

	public CanalDistributie getCanalDistributie() {
		return canalDistributie;
	}

	public void setCanalDistributie(CanalDistributie canalDistributie) {
		this.canalDistributie = canalDistributie;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getBuget() {
		return buget;
	}

	public void setBuget(int buget) {
		this.buget = buget;
	}


	public String creareCampaniePromovare() {

		CampaniePromovare campaniePromovare = new CampaniePromovare();

		campaniePromovare.setTipPromovare(tipPromovare);
		campaniePromovare.setCanalDistributie(canalDistributie);
		campaniePromovare.setData(data);
		campaniePromovare.setBuget(buget);
		
		marketingSrv.creareCampaniePromovare(campaniePromovare);
		return "campaniePromovare";
	}

}

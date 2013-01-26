package org.open.erp.ui.marketing;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.open.erp.services.marketing.CampaniePromovare;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.Promotie;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;

@ManagedBean(name = "promotieBean")
@RequestScoped
public class PromotieBean implements Serializable {

	@EJB(lookup = "java:global/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv")
	private MarketingSrv marketingSrv;

	@EJB(lookup = "java:global/OpenERP_NOMMAT/NomenclatorMaterialeImpl!org.open.erp.services.nommat.NomenclatorMaterialeSrv")
	private NomenclatorMaterialeSrv nomMatSrv;

	private CampaniePromovare campaniePromovare = new CampaniePromovare();
	private Material produsPromotie = new Material();
	private int pretPromotional;
	private Date dataStart;
	private Date dataFinal;

	public PromotieBean() {
	}

	public MarketingSrv getMarketingSrv() {
		return marketingSrv;
	}

	public void setMarketingSrv(MarketingSrv marketingSrv) {
		this.marketingSrv = marketingSrv;
	}

	public CampaniePromovare getCampaniePromovare() {
		return campaniePromovare;
	}

	public void setCampaniePromovare(CampaniePromovare campaniePromovare) {
		this.campaniePromovare = campaniePromovare;
	}
	
	public Material getProdusPromotie() {
		return produsPromotie;
	}

	public void setProdusPromotie(Material produsPromotie) {
		this.produsPromotie = produsPromotie;
	}


	public NomenclatorMaterialeSrv getNomMatSrv() {
		return nomMatSrv;
	}

	public void setNomMatSrv(NomenclatorMaterialeSrv nomMatSrv) {
		this.nomMatSrv = nomMatSrv;
	}

/*	public Material getProdusPromotie() {
		return produsPromotie;
	}

	public void setProdusPromotie(Material produsPromotie) {
		this.produsPromotie = produsPromotie;
	}*/

	public int getPretPromotional() {
		return pretPromotional;
	}

	public void setPretPromotional(int pretPromotional) {
		this.pretPromotional = pretPromotional;
	}

	public Date getDataStart() {
		return dataStart;
	}

	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String crearePromotie() {

		Promotie promotie = new Promotie();

		promotie.setCampaniePromovare(campaniePromovare);
		promotie.setProdusPromotie(produsPromotie);
		promotie.setPretPromotional(pretPromotional);
		promotie.setDataStart(dataStart);
		promotie.setDataFinal(dataFinal);

		marketingSrv.crearePromotie(promotie);

		return "promotie";
	}

}
package org.open.erp.ui.marketing;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.RaspunsIntrebare;

@ManagedBean(name = "raspunsIntrebareBean")
@RequestScoped
public class RaspunsIntrebareBean implements Serializable {

	@EJB(lookup = "java:global/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv")
	private MarketingSrv marketingSrv;

	private String text;
	private Intrebare intrebare;

	public RaspunsIntrebareBean() {
	}

	public MarketingSrv getMarketingSrv() {
		return marketingSrv;
	}

	public void setMarketingSrv(MarketingSrv marketingSrv) {
		this.marketingSrv = marketingSrv;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Intrebare getIntrebare() {
		return intrebare;
	}

	public void setIntrebare(Intrebare intrebare) {
		this.intrebare = intrebare;
	}

	public String creareRaspunsIntrebare() {

		RaspunsIntrebare raspunsIntrebare = new RaspunsIntrebare();

		raspunsIntrebare.setText(text);
		raspunsIntrebare.setIntrebare(intrebare);

		marketingSrv.creareRaspunsIntrebare(raspunsIntrebare);

		return "raspunsIntrebare";
	}
}

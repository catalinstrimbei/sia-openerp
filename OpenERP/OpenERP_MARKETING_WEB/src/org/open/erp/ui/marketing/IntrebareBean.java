package org.open.erp.ui.marketing;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.Intrebare;
import org.open.erp.services.marketing.MarketingSrv;

@ManagedBean(name = "intrebareBean")
@RequestScoped
public class IntrebareBean implements Serializable {

	@EJB(lookup = "java:global/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv")
	private MarketingSrv marketingSrv;

	private String text;
	private long idChestionar;
	private Chestionar chestionar;

	public IntrebareBean() {
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

	public long getIdChestionar() {
		return idChestionar;
	}

	public void setIdChestionar(long idChestionar) {
		this.idChestionar = idChestionar;
	}

	public Chestionar getChestionar() {
		return chestionar;
	}

	public void setChestionar(Chestionar chestionar) {
		this.chestionar = chestionar;
	}

	public String creareIntrebare() {

		Chestionar chestionarGasit = marketingSrv.findChestionarById(idChestionar);
		chestionar = chestionarGasit;

		Intrebare intrebare = new Intrebare();

		intrebare.setText(text);
		intrebare.setChestionar(chestionar);

		marketingSrv.creareIntrebare(intrebare);

		return "intrebare";
	}
}

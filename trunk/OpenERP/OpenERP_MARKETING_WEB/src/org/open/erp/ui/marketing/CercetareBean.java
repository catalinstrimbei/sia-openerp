package org.open.erp.ui.marketing;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.marketing.CercetarePiata;
import org.open.erp.services.marketing.MarketingSrv;

@ManagedBean(name = "cercetareBean")
@javax.faces.bean.RequestScoped
public class CercetareBean implements Serializable{

	public String getDataStart() {
		return dataStart;
	}

	public void setDataStart(String dataStart) {
		this.dataStart = dataStart;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	@EJB(lookup="java:global/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv")
	private MarketingSrv marketingSrv;
	
	private int buget;
	
	private String dataStart;
	
	private String dataFinal;
	
	public CercetareBean(){
		
	}
	
	public MarketingSrv getMarketingSrv() {
		return marketingSrv;
	}

	public void setMarketingSrv(MarketingSrv marketingSrv) {
		this.marketingSrv = marketingSrv;
	}

	public int getBuget() {
		return buget;
	}

	public void setBuget(int buget) {
		this.buget = buget;
	}



	public String creareCercetare() throws Exception{
		
		CercetarePiata cercetareNoua = new CercetarePiata();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		cercetareNoua.setDataStart(dateFormat.parse(dataStart));
		cercetareNoua.setDataFinal(dateFormat.parse(dataFinal));
		cercetareNoua.setBuget(buget);
		
		marketingSrv.creareCercetarePiata(cercetareNoua);
		
		return "cercetareNoua";
	}
	
}

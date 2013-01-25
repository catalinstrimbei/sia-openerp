package org.open.erp.ui.marketing;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.marketing.CercetarePiata;
import org.open.erp.services.marketing.MarketingSrv;

@ManagedBean(name = "cercetareBean")
@javax.faces.bean.RequestScoped
public class CercetareBean implements Serializable{

	@EJB(lookup="java:global/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv")
	private MarketingSrv marketingSrv;
	
	private int buget;
	
	private Date dataStart;
	
	private Date dataFinal;
	
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

	public String creareCercetare() throws Exception{
		
		CercetarePiata cercetareNoua = new CercetarePiata();
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		cercetareNoua.setDataStart(dataStart);
		cercetareNoua.setDataFinal(dataFinal);
		cercetareNoua.setBuget(buget);
		
		marketingSrv.creareCercetarePiata(cercetareNoua);
		
		return "cercetareNoua";
	}
	
}

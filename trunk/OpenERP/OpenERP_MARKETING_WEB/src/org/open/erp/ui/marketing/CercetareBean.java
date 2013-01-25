package org.open.erp.ui.marketing;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.open.erp.services.marketing.CercetarePiata;
import org.open.erp.services.marketing.MarketingSrv;

@ManagedBean(name = "cercetareBean")
@SessionScoped
public class CercetareBean implements Serializable{

	private CercetarePiata cercetarePiata;

	@EJB(lookup="java:global/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv")
	private MarketingSrv marketingSrv;
	
	private int buget;
	
	private Date dataStart;
	
	private Date dataFinal;
	
	public CercetarePiata getCercetarePiata() {
		return cercetarePiata;
	}

	public void setCercetarePiata(CercetarePiata cercetarePiata) {
		this.cercetarePiata = cercetarePiata;
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

	public CercetarePiata creareCercetare(){
		
		CercetarePiata cercetareNoua = new CercetarePiata();
		
		cercetareNoua.setDataStart(dataStart);
		cercetareNoua.setDataFinal(dataFinal);
		cercetareNoua.setBuget(buget);
		
		
		
		marketingSrv.creareCercetarePiata(cercetareNoua);
		
		return cercetareNoua;
	}
	
/*	public String getAsString(FacesContext context, UIComponent component, Object value) {
      if(value == null)
      {
          return null;
      }

      if(!(value instanceof MarketingSrv))
      {
          throw new ConverterException("The value is not a User: " + value);            
      }

      String id = ((MarketingSrv) value).getEmail();
      return (id != null) ? id.toString() : null;
  }*/

}

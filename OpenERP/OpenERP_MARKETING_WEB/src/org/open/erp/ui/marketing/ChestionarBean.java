package org.open.erp.ui.marketing;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.open.erp.services.marketing.CercetarePiata;
import org.open.erp.services.marketing.Chestionar;
import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;

@ManagedBean(name="chestionarBean")
@RequestScoped
public class ChestionarBean implements Serializable{
	
	@EJB(lookup = "java:global/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv")
	private MarketingSrv marketingSrv;
	
	@EJB(lookup = "java:global/OpenERP_NOMGEN/NomenclatoareImpl!org.open.erp.services.nomgen.NomenclatoareSrv")
	private NomenclatoareSrv nomGenSrv;
	
	private Date data;
	private String titlu;
	private Persoana persoanaChestionata;
	private long idCercetarePiata;
	private CercetarePiata cercetarePiata;
	
	public ChestionarBean(){
	}

	public MarketingSrv getMarketingSrv() {
		return marketingSrv;
	}

	public void setMarketingSrv(MarketingSrv marketingSrv) {
		this.marketingSrv = marketingSrv;
	}

	public NomenclatoareSrv getNomGenSrv() {
		return nomGenSrv;
	}

	public void setNomGenSrv(NomenclatoareSrv nomGenSrv) {
		this.nomGenSrv = nomGenSrv;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public Persoana getPersoanaChestionata() {
		return persoanaChestionata;
	}

	public void setPersoanaChestionata(Persoana persoanaChestionata) {
		this.persoanaChestionata = persoanaChestionata;
	}

	public long getIdCercetarePiata() {
		return idCercetarePiata;
	}

	public void setIdCercetarePiata(long idCercetarePiata) {
		this.idCercetarePiata = idCercetarePiata;
	}

	public CercetarePiata getCercetarePiata() {
		return cercetarePiata;
	}

	public void setCercetarePiata(CercetarePiata cercetarePiata) {
		this.cercetarePiata = cercetarePiata;
	}
	
	public String creareChestionar(){
		
		Chestionar chestionarNou= new Chestionar();
		
		chestionarNou.setData(data);
		chestionarNou.setTitlu(titlu);
		chestionarNou.setPersoanaChestionata(persoanaChestionata);
		
		CercetarePiata cercetarePiataNoua=marketingSrv.findCercetarePiataById(idCercetarePiata);
		
		cercetarePiata=cercetarePiataNoua;
		
		chestionarNou.setCercetarePiata(cercetarePiata);
		
		marketingSrv.creareChestionar(chestionarNou);
		
		return "chestionarNou";
		
	}

}

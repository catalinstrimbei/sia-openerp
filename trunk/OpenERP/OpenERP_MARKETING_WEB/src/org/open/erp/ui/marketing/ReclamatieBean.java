package org.open.erp.ui.marketing;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.open.erp.services.marketing.MarketingSrv;
import org.open.erp.services.marketing.Reclamatie;
import org.open.erp.services.marketing.StatusReclamatie;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;

@ManagedBean(name="reclamatieBean")
@RequestScoped
public class ReclamatieBean implements Serializable{
	
	@EJB(lookup = "java:global/OpenERP_MARKETING/MarketingSrvImpl!org.open.erp.services.marketing.MarketingSrv")
	private MarketingSrv marketingSrv;
	
	@EJB(lookup = "java:global/OpenERP_NOMGEN/NomenclatoareImpl!org.open.erp.services.nomgen.NomenclatoareSrv")
	private NomenclatoareSrv nomGenSrv;
	
	private Persoana persoanaReclamanta;
	private Date data;
	private String text;
	private String raspuns;
	private StatusReclamatie status;
	
	public ReclamatieBean(){
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

	public Persoana getPersoanaReclamanta() {
		return persoanaReclamanta;
	}

	public void setPersoanaReclamanta(Persoana persoanaReclamanta) {
		this.persoanaReclamanta = persoanaReclamanta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRaspuns() {
		return raspuns;
	}

	public void setRaspuns(String raspuns) {
		this.raspuns = raspuns;
	}

	public StatusReclamatie getStatus() {
		return status;
	}

	public void setStatus(StatusReclamatie status) {
		this.status = status;
	}
	
	public String creareReclamatie(){
		
		Reclamatie reclamatie = new Reclamatie();
		
		reclamatie.setData(data);
		reclamatie.setPersoanaReclamanta(persoanaReclamanta);
		reclamatie.setText(text);
		reclamatie.setRaspuns(raspuns);
		reclamatie.setStatus(status);
		
		marketingSrv.creareReclamatie(reclamatie);
		
		return "reclamatie";
		
		
	}

}

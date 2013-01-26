package org.open.erp.ui.finplati;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.finplati.Persoana;
import org.open.erp.services.finplati.FinanciarPlatiSrv;

@ManagedBean(name = "persoanaBean")
@javax.faces.bean.RequestScoped
public class PersoanaBean implements Serializable{

	@EJB(lookup="java:global/OpenERP_FINPLATI/FinanciarPlatiSrvImpl!org.open.erp.services.finplati.FinanciarPlatiSrv")
	private FinanciarPlatiSrv financiarPlatiSrv;
	
	protected String nume;
	protected String prenume;
	protected Integer scorAptitudini;
	
	
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public void setScorAptitudini(Integer scorAptitudini) {
		this.scorAptitudini = scorAptitudini;
	}
	public Integer getScorAptitudini() {
		return this.scorAptitudini;
	}
	
	public String adaugaPersoana() throws Exception{
		
		Persoana persoanaNoua = new Persoana();
		persoanaNoua.setNume(nume);
		persoanaNoua.setPrenume(prenume);
		persoanaNoua.setScorAptitudini(scorAptitudini);
	
	    financiarPlatiSrv.adaugaPersoana(persoanaNoua);
		
		return "persoanaNoua";
	
	}
}

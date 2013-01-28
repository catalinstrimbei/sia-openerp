package org.open.erp.ui.bancii;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.open.erp.services.banci.BanciSrv;
import org.open.erp.services.banci.DepoziteBNC;

@ManagedBean(name = "depoziteBean")
@javax.faces.bean.RequestScoped
public class DepoziteBean {
	@EJB(lookup="java:global/OpenERP_BANCI/BanciImpl!org.open.erp.services.banci.BanciSrv")
	private BanciSrv banciSrv;
	private String nume_firma;
	private	String nume_banca;
	private	String nume_cont;
	private Integer tip_cont;
	private	Double suma_depusa_initial;
	private	Integer perioada_depozitului;
	private	Date data_deschidere_depozit;
	private	Date data_expirarii_depozitului;

	public BanciSrv getBanciSrv() {
		return banciSrv;
	}

	public void setBanciSrv(BanciSrv banciSrv) {
		this.banciSrv = banciSrv;
	}

	public String getNume_banca() {
		return nume_banca;
	}

	public void setNume_banca(String nume_banca) {
		this.nume_banca = nume_banca;
	}

	public String getNume_firma() {
		return nume_firma;
	}

	public void setNume_firma(String nume_firma) {
		this.nume_firma = nume_firma;
	}

	public String getNume_cont() {
		return nume_cont;
	}

	public void setNume_cont(String nume_cont) {
		this.nume_cont = nume_cont;
	}

	public Double getSuma_depusa_initial() {
		return suma_depusa_initial;
	}

	public void setSuma_depusa_initial(Double suma_depusa_initial) {
		this.suma_depusa_initial = suma_depusa_initial;
	}

	public Integer getTip_cont() {
		return tip_cont;
	}

	public void setTip_cont(Integer tip_cont) {
		this.tip_cont = tip_cont;
	}

	public Integer getPerioada_depozitului() {
		return perioada_depozitului;
	}

	public void setPerioada_depozitului(Integer perioada_depozitului) {
		this.perioada_depozitului = perioada_depozitului;
	}

	public Date getData_deschidere_depozit() {
		return data_deschidere_depozit;
	}

	public void setData_deschidere_depozit(Date data_deschidere_depozit) {
		this.data_deschidere_depozit = data_deschidere_depozit;
	}

	public Date getData_expirarii_depozitului() {
		return data_expirarii_depozitului;
	}

	public void setData_expirarii_depozitului(Date data_expirarii_depozitului) {
		this.data_expirarii_depozitului = data_expirarii_depozitului;
	}


	
	public String adaugaDepozit() throws Exception{
		;
		DepoziteBNC depozitNou = new DepoziteBNC();
		//contNou.setId(id);
		depozitNou.setnume_companie(nume_firma);
		depozitNou.setnume_banca(nume_banca);
		//depozitNou.setdata_depunerii_lunare(perioada_depozitului);
		depozitNou.setsuma_depusa_lunar(suma_depusa_initial);
		
	    banciSrv.adaugaDepozit(depozitNou);
		
		return "contNou";
}
}

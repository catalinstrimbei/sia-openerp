package org.open.erp.services.marketing.impl;

import java.util.Date;

import org.open.erp.services.marketing.nomgen.Angajat;

public class CampaniePromovare {
	
	long id;
	TipPromovare tipPromovare;
	Date data;
	Angajat promoter;
	CanalDistributie canalDistributie;
	int buget;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public TipPromovare getTipPromovare() {
		return tipPromovare;
	}
	public void setTipPromovare(TipPromovare tipPromovare) {
		this.tipPromovare = tipPromovare;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Angajat getPromoter() {
		return promoter;
	}
	public void setPromoter(Angajat promoter) {
		this.promoter = promoter;
	}
	public CanalDistributie getCanalDistributie() {
		return canalDistributie;
	}
	public void setCanalDistributie(CanalDistributie canalDistributie) {
		this.canalDistributie = canalDistributie;
	}
	public int getBuget() {
		return buget;
	}
	public void setBuget(int buget) {
		this.buget = buget;
	}
}

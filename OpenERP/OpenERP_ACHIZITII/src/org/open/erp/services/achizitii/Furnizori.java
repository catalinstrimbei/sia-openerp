package org.open.erp.services.achizitii;

import java.util.HashMap;
import java.util.Map;

import org.open.erp.services.nomgen.PersoanaJuridica;


 public class Furnizori extends PersoanaJuridica{
	
	private String denumire;
	private String persoanaContact;
	
	private Integer idFurnizor;
	private String numeFurnizor;
	private String adresaFurnizor;
	private String cuiFurnizor;
	
	
	public Furnizori() {
		super();
	}  


	public Furnizori(String denumire) {
		super();
		this.denumire = denumire;
	}


	public Furnizori(String denumire, String persoanaContact) {
		super();
		this.denumire = denumire;
		this.persoanaContact = persoanaContact;
	}

	public String getDenumire() {
		return denumire;
	}


	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}


	public String getPersoanaContact() {
		return persoanaContact;
	}


	public void setPersoanaContact(String persoanaContact) {
		this.persoanaContact = persoanaContact;
	}
	/* larisa lupu----------------------*/
	
	
	public Integer getIdFurnizor() {
		return idFurnizor;
	}
	public void setIdFurnizor(Integer idFurnizor) {
		this.idFurnizor = idFurnizor;
	}
	public String getNumeFurnizor() {
		return numeFurnizor;
	}
	public void setNumeFurnizor(String numeFurnizor) {
		this.numeFurnizor = numeFurnizor;
	}
	public String getAdresaFurnizor() {
		return adresaFurnizor;
	}
	public void setAdresaFurnizor(String adresaFurnizor) {
		this.adresaFurnizor = adresaFurnizor;
	}
	public String getCuiFurnizor() {
		return cuiFurnizor;
	}
	public void setCuiFurnizor(String cuiFurnizor) {
		this.cuiFurnizor = cuiFurnizor;
	}
	

}



package org.open.erp.services.achizitii;

import java.util.HashMap;
import java.util.Map;

import org.open.erp.services.finplati.Plata;
import org.open.erp.services.nomgen.PersoanaJuridica;


 public class Furnizori extends PersoanaJuridica{
	
	private String denumire;
	private String persoanaContact;
	
	
/*	public Furnizori() {
		super();
	}  */


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
	
	Integer idFurnizor;
	String numeFurnizor;
	String adresaFurnizor;
	String cuiFurnizor;
	
	Map<Integer,Plata> plati;
	
	public Furnizori() {
		plati = new HashMap<Integer, Plata>();
	}

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
	
	public Map<Integer,Plata> getPlati() {
		return plati;
	}
	public void setPlati(Map<Integer,Plata> plati) {
		this.plati = plati;
	}
	public void adaugarePlata(Plata plata1) {
		plati.put(plata1.getId(), plata1);
	}
	

	public Boolean verificaPlata(Plata plata) {
			if (plati.containsKey(plata.getId())) {
				Plata fPlata = plati.get(plata.getId());
				if (fPlata.getDataPlatii().equals(plata.getDataPlatii()) && (fPlata.getValoarePlata().equals(plata.getValoarePlata())))
					return true;
				else
					return false;
			}
			else
				return false;
	}
}



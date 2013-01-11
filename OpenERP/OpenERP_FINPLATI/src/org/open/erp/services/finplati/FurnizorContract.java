package org.open.erp.services.finplati;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.open.erp.services.achizitii.Furnizori;

@Entity
public class FurnizorContract implements Serializable {
@Id @GeneratedValue
	Integer idFurnizor;

	String numeFurnizor;
	String adresaFurnizor;
	String cuiFurnizor;
	
	@OneToMany
	Map<Integer,Plata> plati;
	
	public FurnizorContract() {
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
	public void adaugarePlata(Plata plata) {
		plati.put(plata.getId(), plata);
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

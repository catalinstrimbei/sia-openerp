package org.open.erp.services.vanzari;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Material {
	
	@Id @GeneratedValue
	String codMaterial;
	String denumireMaterial;
	String cantitateStandard;
	String pretStandard;
	String procentTVACurent;
	String observatii;
	String um;
	String categorieMaterial;
	public String getCodMaterial() {
		return codMaterial;
	}
	public void setCodMaterial(String codMaterial) {
		this.codMaterial = codMaterial;
	}
	public String getDenumireMaterial() {
		return denumireMaterial;
	}
	public void setDenumireMaterial(String denumireMaterial) {
		this.denumireMaterial = denumireMaterial;
	}
	public String getCantitateStandard() {
		return cantitateStandard;
	}
	public void setCantitateStandard(String cantitateStandard) {
		this.cantitateStandard = cantitateStandard;
	}
	public String getPretStandard() {
		return pretStandard;
	}
	public void setPretStandard(String pretStandard) {
		this.pretStandard = pretStandard;
	}
	public String getProcentTVACurent() {
		return procentTVACurent;
	}
	public void setProcentTVACurent(String procentTVACurent) {
		this.procentTVACurent = procentTVACurent;
	}
	public String getObservatii() {
		return observatii;
	}
	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}
	public String getUm() {
		return um;
	}
	public void setUm(String um) {
		this.um = um;
	}
	public String getCategorieMaterial() {
		return categorieMaterial;
	}
	public void setCategorieMaterial(String categorieMaterial) {
		this.categorieMaterial = categorieMaterial;
	}
	public Material(String codMaterial, String denumireMaterial,
			String cantitateStandard, String pretStandard,
			String procentTVACurent, String observatii, String um,
			String categorieMaterial) {
		super();
		this.codMaterial = codMaterial;
		this.denumireMaterial = denumireMaterial;
		this.cantitateStandard = cantitateStandard;
		this.pretStandard = pretStandard;
		this.procentTVACurent = procentTVACurent;
		this.observatii = observatii;
		this.um = um;
		this.categorieMaterial = categorieMaterial;
	}
	public Material() {
		super();
	}




}

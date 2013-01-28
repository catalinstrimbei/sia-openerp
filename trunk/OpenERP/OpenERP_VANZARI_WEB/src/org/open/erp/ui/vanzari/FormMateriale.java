package org.open.erp.ui.vanzari;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.open.erp.services.vanzari.Material;
import org.open.erp.services.vanzari.VanzariSrv;


@ManagedBean(name="formMaterial")
@SessionScoped
public class FormMateriale implements Serializable {
	String denumireMaterial;
	String cantitateStandard;
	String pretStandard;
	String procentTVACurent;
	String observatii;
	String um;
	String categorieMaterial;
	
	@EJB(lookup="java:global/OpenERP_VANZARI/VanzariImpl!org.open.erp.services.vanzari.VanzariSrv")
	private VanzariSrv vanzarisrv;

	public FormMateriale(String denumireMaterial, String cantitateStandard,
			String pretStandard, String procentTVACurent, String observatii,
			String um, String categorieMaterial, VanzariSrv vanzarisrv) {
		super();
		this.denumireMaterial = denumireMaterial;
		this.cantitateStandard = cantitateStandard;
		this.pretStandard = pretStandard;
		this.procentTVACurent = procentTVACurent;
		this.observatii = observatii;
		this.um = um;
		this.categorieMaterial = categorieMaterial;
		this.vanzarisrv = vanzarisrv;
	}

	public FormMateriale() {
		super();
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

	public VanzariSrv getVanzarisrv() {
		return vanzarisrv;
	}

	public void setVanzarisrv(VanzariSrv vanzarisrv) {
		this.vanzarisrv = vanzarisrv;
	}
	
	
	public String creareMaterial(){
		Material material=new Material();
		material.setDenumireMaterial(denumireMaterial);
		material.setCantitateStandard(cantitateStandard);
		material.setPretStandard(pretStandard);
		material.setProcentTVACurent(procentTVACurent);
		material.setObservatii(observatii);
		material.setUm(um);
		material.setCategorieMaterial(categorieMaterial);
		return "material";
		
	}

}

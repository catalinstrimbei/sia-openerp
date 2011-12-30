package org.open.erp.services.personal;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class DosarAngajat {

	private Integer	idDosar;
	private Angajat	angajat;
	private Boolean fisaMedicala = false;
	private Boolean copieBuletin = false;
	private Boolean adeverintaStudii = false;
	public Integer getIdDosar() {
		return idDosar;
	}
	public void setIdDosar(Integer idDosar) {
		this.idDosar = idDosar;
	}
	public Angajat getAngajat() {
		return angajat;
	}
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public Boolean getFisaMedicala() {
		return fisaMedicala;
	}
	public void setFisaMedicala(Boolean fisaMedicala) {
		this.fisaMedicala = fisaMedicala;
	}
	public Boolean getCopieBuletin() {
		return copieBuletin;
	}
	public void setCopieBuletin(Boolean copieBuletin) {
		this.copieBuletin = copieBuletin;
	}
	public Boolean getAdeverintaStudii() {
		return adeverintaStudii;
	}
	public void setAdeverintaStudii(Boolean adeverintaStudii) {
		this.adeverintaStudii = adeverintaStudii;
	}
	public DosarAngajat(Integer idDosar, Angajat angajat, Boolean fisaMedicala,
			Boolean copieBuletin, Boolean adeverintaStudii) {
		super();
		this.idDosar = idDosar;
		this.angajat = angajat;
		this.fisaMedicala = fisaMedicala;
		this.copieBuletin = copieBuletin;
		this.adeverintaStudii = adeverintaStudii;
	}
	public DosarAngajat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
package org.open.erp.services.banci;



import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.open.erp.services.nomgen.Companie;

@Entity
public class DepoziteBNC implements Serializable {
	
	/*
	Nume companie
	Banca/ Banci la care are depozite
	Nume cont in care a facut depozit
	Tip cont(lei/valuta)
	Suma depusa initial
	Perioada depozitului
	Data/date deschidere depozit
	Data expirarii depozitului
	Data depunerii lunare
	Suma depusa lunar
	Rata dobanzii anuale
	Sume intermediare
	•	Data depunere curenta
	•	Suma depunere curenta
	•	Sold actual( valoare depozitului dupa ultima depunere)

	 */
	 @Id @GeneratedValue
	private Integer iddepozit;
	 
	private String nume_firma;
	private	String nume_banca;
	private	String nume_cont;
	private Integer tip_cont;
	private	Double suma_depusa_initial;
	private	Integer perioada_depozitului;
	
	@Temporal(TemporalType.TIMESTAMP)
	private	Date data_deschidere_depozit;
	
	@Temporal(TemporalType.TIMESTAMP)
	private	Date data_expirarii_depozitului;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private	Integer data_depunerii_lunare;
	
	private	Double suma_depusa_lunar;
	private	Double rata_dobanzii_anuale;
	private	Vector<LiniiDepuneri> sume_intermediare;
	
	
	//setter
	public void setnume_companie(String comp){
		this.nume_firma = comp;
	}
	public void setnume_banca(String comp){
		this.nume_banca = comp;
	}
	public void setnume_cont(String cont){
		this.nume_cont = cont;
	}
	public void settip_cont(Integer tipcont){
		this.tip_cont = tipcont;
	}
	public void setsuma_depusa_initial(Double suma){
		this.suma_depusa_initial = suma;
	}
	public void setperioada_depozitului(Integer perioada){
		this.perioada_depozitului = perioada;
	}
	public void setdata_deschidere_depozit(Date data){
		this.data_deschidere_depozit = data; 
	}
	public void setdata_expirarii_depozitului(Date data){
		this.data_expirarii_depozitului = data;
	}
	public void setdata_depunerii_lunare(Integer zi){
		this.data_depunerii_lunare = zi;
	}
	public void setsuma_depusa_lunar(Double suma){
		this.suma_depusa_lunar = suma;
	}
	public void setrata_dobanzii_anuale(Double rata){
		this.rata_dobanzii_anuale = rata;
	}
	public void setsume_intermediare(LiniiDepuneri sume){
		this.sume_intermediare.addElement(sume);
	}
	
	
	//getter
	public String getnume_companie(){
		return nume_firma;
	}
	public String getnume_banca(){
		return nume_banca;
	}
	public String getnume_cont(){
		return nume_cont;
	}
	public Integer tip_cont(){
		return tip_cont;
	}
	public Double getsuma_depusa_initial(){
		return suma_depusa_initial;
	}
	public Integer getperioada_depozitului(){
		return perioada_depozitului;
	}
	public Date getdata_deschidere_depozit(){
		return data_deschidere_depozit; 
	}
	public Date getdata_expirarii_depozitului(){
		return data_expirarii_depozitului;
	}
	public Integer getdata_depunerii_lunare(){
		return data_depunerii_lunare;
	}
	public Double getsuma_depusa_lunar(){
		return suma_depusa_lunar;
	}
	public Double getrata_dobanzii_anuale(){
		return rata_dobanzii_anuale;
	}
	public Vector<LiniiDepuneri> getsume_intermediare(){
		return sume_intermediare;
	}
		
	public DepoziteBNC(String nume_firma, String nume_banca, String nume_cont, Integer tip_cont, Double suma_depusa_initial,
		Integer perioada_depozitului, Date data_deschidere_depozit, Date data_expirarii_depozitului, Integer data_depunerii_lunare,
		Double suma_depusa_lunar, Double rata_dobanzii_anuale, LiniiDepuneri sume_intermediare){
		this.nume_firma = nume_firma;
		this.nume_banca = nume_banca;
		this.nume_cont = nume_cont;
		this.tip_cont = tip_cont;
		this.suma_depusa_initial = suma_depusa_initial;
		this.perioada_depozitului = perioada_depozitului;
		this.data_deschidere_depozit = data_deschidere_depozit;
		this.data_expirarii_depozitului = data_expirarii_depozitului;
		this.data_depunerii_lunare = data_depunerii_lunare;
		this.suma_depusa_lunar = suma_depusa_lunar;
		this.rata_dobanzii_anuale = rata_dobanzii_anuale;
		this.sume_intermediare = new Vector<LiniiDepuneri>();
		this.sume_intermediare.addElement(sume_intermediare);
	}
	
	public DepoziteBNC() {
		super();
	}
	public Integer getIddepozit() {
		return iddepozit;
	}
	public void setIddepozit(Integer iddepozit) {
		this.iddepozit = iddepozit;
	}

	
	
}
		
	




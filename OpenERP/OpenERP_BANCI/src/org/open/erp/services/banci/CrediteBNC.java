package org.open.erp.services.banci;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CrediteBNC implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9129588260884110612L;

	/*
	�	Nume companie
	�	Nume banca/ Banci la care are contractat credite
	�	Nume cont
	�	Suma contractata
	�	Perioada contractare
	�	Data/date contractare
	�	Data scadentei contractului
	�	Data scadentei lunare
	�	Suma de plata lunara
	�	Rata dobanzii anuale
	�	Plati intermediare
		o	Data plata curenta
		o	Suma plata curenta
		o	Suma ramasa de plata

	*/
	@Id @GeneratedValue
	private Integer idcreditbnc;
	
	private String numeCompanie;
	private Vector<String> numeBanca = new Vector<String>();;
	private String numeCont;
	private Double sumaContractata;
	private Double sumaramasadeplata;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Integer perioadaContractare; //zile
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datacontractare;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datascadenteicontractului;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datascadenteilunare;
	
	private Double	sumaplatalunara;
	private Double	ratadobanziianuale;
	private Vector<LiniiPlati> platiintermediare = new Vector<LiniiPlati>();
	
	
	//getter
	public String getnumeCompanie(){
		return numeCompanie;
	}
	public Vector<String> getnumeBanca(){
		return numeBanca;
	}
	public String getnumeCont(){
		return numeCont;
	}
	public Double getsumaContractata(){
		return sumaContractata;
	}
	public Integer getperioadaContractare(){
		return perioadaContractare;
	}
	public Date getdatacontractare(){
		return datacontractare;
	}
	public Date getdatascadenteicontractului(){
		return datascadenteicontractului;
	}
	public Date getdatascadenteilunare(){
		return datascadenteilunare;
	}
	public Double getsumaplatalunara(){
		return sumaplatalunara;
	}
	public Double getratadobanziianuale(){
		return ratadobanziianuale;
	}
	public Double getsumaramasadeplata(){
		return sumaramasadeplata;
	}
	public Vector<LiniiPlati> getplatiintermediare(){
		return platiintermediare;
	}
	
	//setter
	public void setnumeCompanie(String nume){
		this.numeCompanie = nume;
	}
	public void setnumeBanca(String nume){
		this.numeBanca.addElement(nume);
	}
	public void setnumeCont(String nume){
		this.numeCont = nume;
	}
	public void setsumaContractata(Double suma){
		this.sumaContractata = suma;
	}
	public void setperioadaContractare(Integer perioada){
		this.perioadaContractare = perioada;
	}
	public void setdatacontractare(Date data){
		this.datacontractare = data;
	}
	public void setdatascadenteicontractului(Date data){
		this.datascadenteicontractului = data;
	}
	public void setdatascadenteilunare(Date data){
		this.datascadenteilunare = data;
	}
	public void setsumaplatalunara(Double suma){
		this.sumaplatalunara = suma;
	}
	public void setratadobanziianuale(Double rata){
		this.ratadobanziianuale = rata;
	}
	public void setsumaramasadeplata(Double suma){
		this.sumaramasadeplata = suma;
	}
	public void setplatiintermediare(LiniiPlati plata){
		this.platiintermediare.addElement(plata);
	}
	
	public void actualizarecredit(){
		sumaramasadeplata = sumaContractata;
		for(int i=0;i<platiintermediare.size();i++)
			sumaramasadeplata -= (sumaplatalunara -ratadobanziianuale*(sumaplatalunara));
	}
	
	public CrediteBNC(String numeCompa, String numeBan, String numeCon, Double sumaContract, Integer perioadaContract,
			Date datacontract, Date datascadenteicontract, Date datascadenteiluna, Double sumaplataluna,
			Double ratadobanziian, LiniiPlati platiintermed) {
		this.numeCompanie = numeCompa;
		this.numeBanca.addElement(numeBan);
		this.numeCont = numeCon;
		this.sumaContractata = sumaContract;
		this.perioadaContractare = perioadaContract;
		this.datacontractare = datacontract;
		this.datascadenteicontractului = datascadenteicontract;
		this.datascadenteilunare = datascadenteiluna;
		this.sumaplatalunara = sumaplataluna;
		this.ratadobanziianuale = ratadobanziian;
		this.platiintermediare.addElement(platiintermed);
	}
	
	public CrediteBNC() {
		super();
	}
	public Integer getIdcreditbnc() {
		return idcreditbnc;
	}
	public void setIdcreditbnc(Integer idcreditbnc) {
		this.idcreditbnc = idcreditbnc;
	}	
}
		
	
	
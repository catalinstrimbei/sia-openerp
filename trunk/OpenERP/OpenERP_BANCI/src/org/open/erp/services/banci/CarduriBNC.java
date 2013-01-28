package org.open.erp.services.banci;

import java.util.Date;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.open.erp.services.nomgen.*;
 @Entity
public class CarduriBNC {
	/*
	•	Nume companie
	•	Nume cont, 
	•	Nume banca
	•	Tip cont (lei sau valuta)
	•	data cand a fost emis cardul
	•	Sold Initial cont pana la emiterea cardului
	•	Retrageri sume cu cardul (rulaje)
	o	Datele la care s-au retras sume cu cardul
	o	Sumele retrase cu cardul  
	o	Sold final cont dupa ultima retragere cu cardul
	*/
	 @Id @GeneratedValue
	private Integer idCard;
	 
	private Companie firma;
	@ManyToOne
	private Cont cont;
	
	private Companie banca;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataeliberarii; //cand se preda clientului
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataexpirarii;
	
	private Vector<LiniiPlati> linieretragere = new Vector<LiniiPlati>();
	private Vector<LiniiPlati> liniealimentare = new Vector<LiniiPlati>();
	private Double valsoldinitial;
	private Double valsoldfinal;
	
	//setter
	public Integer getidCard() {
		return idCard;
	}
	public void setidCard(Integer idCard) {
		this.idCard = idCard;
	}

	
	public void setFirma(Companie comp){
		this.firma = comp;
	}
	public void setCont(Cont cont){
		this.cont = cont;
	}
	public void setBanca(Companie comp){
		this.banca = comp;
	}
	public void setdataeliberarii(Date data){
		this.dataeliberarii = data;
	}
	public void setdataexpirarii(Date data){
		this.dataexpirarii = data;
	}
	public void setlinieretragere(LiniiPlati retragere){
		this.linieretragere.addElement(retragere);
	}
	public void setliniealimentare(LiniiPlati plati){
		this.liniealimentare.addElement(plati);
	}
	public void setvalsoldinitial(Double sold){
		this.valsoldinitial = sold;
	}
	public void setvalsoldfinal(Double sold){
		this.valsoldfinal = sold;
	}
	
	//Getter
	public Companie getFirma(){
		return firma;
	}
	public Cont getCont(){
		return cont;
	}
	public Companie getBanca(){
		return banca;
	}
	public Date getdataeliberarii(){
		return dataeliberarii;
	}
	public Date getdataexpirarii(){
		return dataexpirarii;
	}
	public Vector<LiniiPlati> getlinieretragere(){
		return linieretragere;
	}
	public Vector<LiniiPlati> getliniealimentare(){
		return liniealimentare;
	}
	public Double getvalsoldinitial(){
		return valsoldinitial;
	}
	public Double getvalsoldfinal(){
		return valsoldfinal;
	}
	
	public void actualizaresoldfinal(){
		this.valsoldfinal = this.valsoldinitial; 
		for(int i=0; i<this.liniealimentare.size(); i++)
			this.valsoldfinal += this.liniealimentare.elementAt(i).getsumaplatita();
		for(int i=0; i<this.linieretragere.size(); i++)
			this.valsoldfinal -= this.linieretragere.elementAt(i).getsumaplatita();
	}
		
	public CarduriBNC(Companie firma, Cont cont, Companie banca, 
			Date dataeliberarii, Date dataexpirarii, 
			Double valsoldinitial) {
		super();
		this.firma = firma;
		this.cont = cont;
		this.banca = banca;
		this.dataeliberarii = dataeliberarii;
		this.dataexpirarii =  dataexpirarii;
		this.valsoldinitial = valsoldinitial;
	}
	
	public CarduriBNC() {
		super();
	}
	
}
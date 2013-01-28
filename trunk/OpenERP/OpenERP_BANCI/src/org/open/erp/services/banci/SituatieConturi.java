package org.open.erp.services.banci;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.open.erp.services.nomgen.Companie;

@Entity
public class SituatieConturi implements Serializable {
	@Id @GeneratedValue
	/*
	•	nume banca
	•	Nume companie
	•	Nume cont, 
	•	Tip cont (lei sau valuta)
	•	data cand a fost deschis contul
	•	Sold Initial
	•	Solduri intermendiare la diferite date(rulaje)
		o	Datele la care s-a retras 
		o	Date la care s- au depus sume
		o	Sumele retrase
		o	Sumele depuse
	•	Sold final
	*/
 private Integer idsitcont;
	private Companie firma;
	@ManyToOne
	private Cont cont;
	
	private Companie banca;
	private Date datadeschiderii; //cand se preda clientului
	private Vector<SolduriIntermediare> solduriintermediare;
	private Double valsoldinitial;
	private Double valsoldfinal;
	
	//setter
	public void setFirma(Companie comp){
		this.firma = comp;
	}
	public void setCont(Cont cont){
		this.cont = cont;
	}
	public void setBanca(Companie comp){
		this.banca = comp;
	}
	public void setdataexpirarii(Date data){
		this.datadeschiderii = data;
	}
	public void setsolduriintermediar(SolduriIntermediare operatie){
		this.solduriintermediare.addElement(operatie);
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
	public Date getdatadechiderii(){
		return datadeschiderii;
	}	
	public Vector<SolduriIntermediare> getsolduriintermediare(){
		return solduriintermediare;
	}
	public Double getvalsoldinitial(){
		return valsoldinitial;
	}
	public Double getvalsoldfinal(){
		return valsoldfinal;
	}
	
		
	public SituatieConturi(Companie firma, Cont cont, Companie banca, 
			Date datadeschiderii, SolduriIntermediare soldintermediar, 
			Double valsoldinitial, Double valsoldfinal) {
		super();
		this.firma = firma;
		this.cont = cont;
		this.banca = banca;
		this.datadeschiderii = datadeschiderii;
		this.solduriintermediare = new Vector<SolduriIntermediare>();
		this.solduriintermediare.addElement(soldintermediar);		
		this.valsoldinitial = valsoldinitial;
		this.valsoldfinal = valsoldfinal;
	}
	
	public SituatieConturi() {
		super();
	}
	public Integer getIdsitcont() {
		return idsitcont;
	}
	public void setIdsitcont(Integer idsitcont) {
		this.idsitcont = idsitcont;
	}
}

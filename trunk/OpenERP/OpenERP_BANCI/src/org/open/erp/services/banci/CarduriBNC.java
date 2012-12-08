package org.open.erp.services.banci;

import java.util.Date;
import java.util.Vector;

import org.open.erp.services.nomgen.*;

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
	
	private Companie firma;
	private Cont cont;
	private Companie banca;
	private Date dataeliberarii; //cand se preda clientului
	private Date dataexpirarii;
	private Vector<LiniiPlati> linieretragere;
	private Vector<LiniiPlati> liniealimentare;
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
	
		
	public CarduriBNC(Companie firma, Cont cont, Companie banca, 
			Date dataeliberarii, Date dataexpirarii, 
			LiniiPlati linieretragere, LiniiPlati liniealimentare, 
			Double valsoldinitial, Double valsoldfinal) {
		super();
		this.firma = firma;
		this.cont = cont;
		this.banca = banca;
		this.dataeliberarii = dataeliberarii;
		this.dataexpirarii =  dataexpirarii;	
		this.linieretragere = new Vector<LiniiPlati>();
		this.linieretragere.addElement(linieretragere);		
		this.liniealimentare = new Vector<LiniiPlati>();
		this.liniealimentare.addElement(liniealimentare);		
		this.valsoldinitial = valsoldinitial;
		this.valsoldfinal = valsoldfinal;
	}
	
	public CarduriBNC() {
		super();
	}
	
}
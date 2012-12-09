package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Comenzi {
	Integer idComanda;
	 Date data;
	 List<ArticolComanda> articole = new ArrayList<ArticolComanda>();

	 
	 
	 
	public Comenzi() {
		super();
	}

	public Double getValoareComanda(){
	//	if (articole.isEmpty())
			//return null;
		
		Double valoare = 0.0;
		for (ArticolComanda articol: articole){
			valoare = valoare + articol.calcValoare();
		}
		
		return valoare;
	}

	public void adauga( ArticolComanda articolComanda){
		
		this.articole.add(articolComanda);
	}

	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ArticolComanda> getArticole() {
		return articole;
	}

	public void setArticole(List<ArticolComanda> articole) {
		this.articole = articole;
	}

	public Comenzi(Integer idComanda, Date data, List<ArticolComanda> articole) {
		super();
		this.idComanda = idComanda;
		this.data = data;
		this.articole = articole;
	}


 
	
}

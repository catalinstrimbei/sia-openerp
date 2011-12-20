package org.open.erp.services.personal;

import java.util.Date;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
public class AnuntLocMunca {
	private Integer		idAnunt;
	private String[] 	modAnunt = {"Internet", "Ziar", "Radio", "TV", "Altele"};
	private String 		corpAnunt;
	private Functie		functie;
	private Date		dataInceput;
	private Date 		dataExpirare;
	
	
	public AnuntLocMunca(Integer idAnunt, String[] modAnunt, String corpAnunt,
			Functie functie, Date dataInceput, Date dataExpirare) {
		super();
		this.idAnunt = idAnunt;
		this.modAnunt = modAnunt;
		this.corpAnunt = corpAnunt;
		this.functie = functie;
		this.dataInceput = dataInceput;
		this.dataExpirare = dataExpirare;
	}
	public Integer getIdAnunt() {
		return idAnunt;
	}
	public void setIdAnunt(Integer idAnunt) {
		this.idAnunt = idAnunt;
	}
	public String[] getModAnunt() {
		return modAnunt;
	}
	public void setModAnunt(String[] modAnunt) {
		this.modAnunt = modAnunt;
	}
	public String getCorpAnunt() {
		return corpAnunt;
	}
	public void setCorpAnunt(String corpAnunt) {
		this.corpAnunt = corpAnunt;
	}
	public Functie getFunctie() {
		return functie;
	}
	public void setFunctie(Functie functie) {
		this.functie = functie;
	}
	public Date getDataInceput() {
		return dataInceput;
	}
	public void setDataInceput(Date dataInceput) {
		this.dataInceput = dataInceput;
	}
	public Date getDataExpirare() {
		return dataExpirare;
	}
	public void setDataExpirare(Date dataExpirare) {
		this.dataExpirare = dataExpirare;
	}
	public AnuntLocMunca() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

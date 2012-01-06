package org.open.erp.services.personal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class AnuntLocMunca implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer		idAnunt;
	private String[] 	modAnunt = {"Internet", "Ziar", "Radio", "TV", "Altele"};
	private String 		corpAnunt;
	@ManyToOne @JoinColumn(name = "idFunctie")
	private Functie		functie;
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date		dataInceput;
	@Temporal(javax.persistence.TemporalType.DATE)
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

package org.open.erp.services.contabgest;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



//executie asamblare finisare
///va fi un camp in centru cost
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ProceseTehnicoEconomice implements Serializable{
	//mai multe centre const la un proces
	//procesul asamblare are mai multe centre de cost
	//dependente fata de celelalte module
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7890316176160841419L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProces;
	private String denumireProces;
	private String detaliiProces;
	
	@OneToMany(mappedBy = "proceseTehnicoEconomice", cascade = CascadeType.ALL)
	private Collection<CentruCost>  centrucost;
	
	
	public ProceseTehnicoEconomice() {

	}
	public ProceseTehnicoEconomice(Integer idProces, String denumireProces,
			String detaliiProces) {
		super();
		this.idProces = idProces;
		this.denumireProces = denumireProces;
		this.detaliiProces = detaliiProces;
	}
	
	
	

	public ProceseTehnicoEconomice(String denumireProces, String detaliiProces) {
		super();
		this.denumireProces = denumireProces;
		this.detaliiProces = detaliiProces;
	}
	public Integer getIdProces() {
		return idProces;
	}
	public void setIdProces(Integer idProces) {
		this.idProces = idProces;
	}
	public String getDenumireProces() {
		return denumireProces;
	}
	public void setDenumireProces(String denumireProces) {
		this.denumireProces = denumireProces;
	}
	public String getDetaliiProces() {
		return detaliiProces;
	}
	public void setDetaliiProces(String detaliiProces) {
		this.detaliiProces = detaliiProces;
	}
	
	
	

}

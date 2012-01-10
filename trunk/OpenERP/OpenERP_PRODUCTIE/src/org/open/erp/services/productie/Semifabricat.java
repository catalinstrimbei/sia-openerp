package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Produs;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */

@Entity
public class Semifabricat extends Produs implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	Integer idSemifabricat;
	
	String semifabricat;
	
	@ManyToOne (targetEntity=DummyMaterial.class)
	@JoinColumn(name="id")
	ArrayList <DummyMaterial> listaMateriale;
	
	Semifabricat semifabricatContinut;
	
	public Semifabricat(Integer idSemifabricat, String semifabricat,
			ArrayList<DummyMaterial> listaMateriale,
			Semifabricat semifabricatContinut) {
		super();
		this.semifabricat = semifabricat;
		this.listaMateriale = listaMateriale;
		this.semifabricatContinut = semifabricatContinut;
		this.idSemifabricat=idSemifabricat;
	}
	public Integer getIdSemifabricat() {
		return idSemifabricat;
	}
	public void setIdSemifabricat(Integer idSemifabricat) {
		this.idSemifabricat = idSemifabricat;
	}
	public Semifabricat() {
		super();
	}
	public String getSemifabricat() {
		return semifabricat;
	}
	public void setSemifabricat(String semifabricat) {
		this.semifabricat = semifabricat;
	}
	public ArrayList<DummyMaterial> getListaMateriale() {
		return listaMateriale;
	}
	public void setListaMateriale(ArrayList<DummyMaterial> listaMateriale) {
		this.listaMateriale = listaMateriale;
	}
	public Semifabricat getSemifabricatContinut() {
		return semifabricatContinut;
	}
	public void setSemifabricatContinut(Semifabricat semifabricatContinut) {
		this.semifabricatContinut = semifabricatContinut;
	}
	
}

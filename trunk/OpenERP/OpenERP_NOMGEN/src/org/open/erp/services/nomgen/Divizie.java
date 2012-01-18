/**
 * 
 */
package org.open.erp.services.nomgen;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Divizie extends Departament implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Integer Id;
	 @ManyToOne @JoinColumn(name = "DivDepartament")
	// @Column(name="IdDepartament")
	private Departament IdDepartament;
	 
	private String denumire;
	private String atributii;
	
	
	
	/**
	 * @return the id
	 */
	//@Id
	//public Integer getId() {
		//return Id;
	//}
	/**
	 * @param id the id to set
	 */
	//public void setId(Integer id) {
		//Id = id;
	//}
	/**
	 * @return the idDepartament
	 */
	public Departament getIdDepartament() {
		return IdDepartament;
	}
	/**
	 * @param idDepartament the idDepartament to set
	 */
	public void setIdDepartament(Departament idDepartament) {
		IdDepartament = idDepartament;
	}
	/**
	 * @return the denumire
	 */
	public String getDenumire() {
		return denumire;
	}
	/**
	 * @param denumire the denumire to set
	 */
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	/**
	 * @return the atributii
	 */
	public String getAtributii() {
		return atributii;
	}
	/**
	 * @param atributii the atributii to set
	 */
	public void setAtributii(String atributii) {
		this.atributii = atributii;
	}
	
	
	
	public Divizie( String denumire, String atributii, Persoana idContact) {
		super();
		
	}
	
	public Divizie( Departament dep, String denumire,
			String atributii) {
		super();
		
		//this.Id = id;
		
		this.denumire = denumire;
		this.atributii = atributii;
	
	}
	
	public Divizie() {
		super();	
	}
}

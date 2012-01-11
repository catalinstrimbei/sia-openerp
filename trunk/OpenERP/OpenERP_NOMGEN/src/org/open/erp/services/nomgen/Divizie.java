/**
 * 
 */
package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Divizie extends Departament implements Serializable{
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	 @ManyToOne @JoinColumn(name = "Id")
	private Departament IdDepartament;
	private String denumire;
	private String atributii;
	
	private List<String> telefoane;
	
	private List<String> emailuri;
	
	/**
	 * @return the id
	 */
	//@Id
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}
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
	
	
	
	public Divizie(Integer id, String denumire, String atributii, Persoana idContact) {
		super();
		
	}
	
	public Divizie(Integer id, Departament dep, String denumire,
			String atributii) {
		super();
		
		this.Id = id;
		
		this.denumire = denumire;
		this.atributii = atributii;
	
	}
	
	public Divizie() {
		super();	
	}
}

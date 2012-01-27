
package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Id;

/**
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */

@Entity
public class Partener extends Persoana implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Id @GeneratedValue
	//private Integer id;
	@OneToOne @JoinColumn(name= "id")
	private Persoana p;
	private Date    dataAfilierii;
	private Integer durataAfilierii;
	/**
	 * @return the id
	 */
	
	
	/*public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	/*public void setId(Integer id) {
		this.id = id;
	}*/
	/**
	 * @return the idPersoana
	 */

	/**
	 * @return the dataAfilierii
	 */
	public Date getDataAfilierii() {
		return dataAfilierii;
	}
	/**
	 * @param dataAfilierii the dataAfilierii to set
	 */
	public void setDataAfilierii(Date dataAfilierii) {
		this.dataAfilierii = dataAfilierii;
	}
	/**
	 * @return the durataAfilierii
	 */
	public Integer getDurataAfilierii() {
		return durataAfilierii;
	}
	/**
	 * @param durataAfilierii the durataAfilierii to set
	 */
	public void setDurataAfilierii(Integer durataAfilierii) {
		this.durataAfilierii = durataAfilierii;
	}

	public Partener ( Persoana p , Date dataAfilierii, Integer durataAfilierii) {
		super();
		
		//this.id = id;
		this.p = p;
		this.dataAfilierii = dataAfilierii;
		this.durataAfilierii = durataAfilierii;
	
	}
	
	public Partener() {
		super();
	}
	public Partener( Persoana p, Integer durataAfilierii) {
		super();
		//this.id = id;
		this.p = p;
		this.durataAfilierii = durataAfilierii;
	}
	public Persoana getP() {
		return p;
	}
	public void setP(Persoana p) {
		this.p = p;
	}
	public Partener(Integer id, Departament dep, String adresa,
			List<String> telefoane, List<String> emailuri, Integer id2,
			Persoana p, Date dataAfilierii, Integer durataAfilierii) {
		super(id, dep, adresa, telefoane, emailuri);
		id = id2;
		this.p = p;
		this.dataAfilierii = dataAfilierii;
		this.durataAfilierii = durataAfilierii;
	}	

	
}

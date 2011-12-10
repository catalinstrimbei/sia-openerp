
package org.open.erp.services.nomgen;

import java.util.Date;

/**
 * @author Suzy
 *
 */
public class Partener {

	private Integer id;
	private Integer idPersoana;
	private Date    dataAfilierii;
	private Integer durataAfilierii;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the idPersoana
	 */
	public Integer getIdPersoana() {
		return idPersoana;
	}
	/**
	 * @param idPersoana the idPersoana to set
	 */
	public void setIdPersoana(Integer idPersoana) {
		this.idPersoana = idPersoana;
	}
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

	public Partener (Integer id, Integer idPersoana , Date dataAfilierii, Integer durataAfilierii) {
		super();
		
		this.id = id;
		this.idPersoana = idPersoana;
		this.dataAfilierii = dataAfilierii;
		this.durataAfilierii = durataAfilierii;
	
	}
	
	public Partener() {
		super();
	}	

	
}

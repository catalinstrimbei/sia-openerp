package org.open.erp.services.marketing;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import org.open.erp.services.nomgen.Persoana;
@Entity
public class RaspunsChestionar {
	
	@Id
	Integer					idRaspuns;
	
	Persoana				Subiect;
	@Temporal(javax.persistence.TemporalType.DATE)
	Date					dataRaspuns;
	Chestionar				chestionar;
	Map<Integer, List<String>>	raspunsuri = new HashMap<Integer, List<String>>();
	
	public RaspunsChestionar() {
		super();
	}

	/**
	 * @return the idRaspuns
	 */
	public Integer getIdRaspuns() {
		return idRaspuns;
	}

	/**
	 * @param idRaspuns the idRaspuns to set
	 */
	public void setIdRaspuns(Integer idRaspuns) {
		this.idRaspuns = idRaspuns;
	}

	/**
	 * @return the subiect
	 */
	public Persoana getSubiect() {
		return Subiect;
	}

	/**
	 * @param subiect the subiect to set
	 */
	public void setSubiect(Persoana subiect) {
		Subiect = subiect;
	}

	/**
	 * @return the dataRaspuns
	 */
	public Date getDataRaspuns() {
		return dataRaspuns;
	}

	/**
	 * @param dataRaspuns the dataRaspuns to set
	 */
	public void setDataRaspuns(Date dataRaspuns) {
		this.dataRaspuns = dataRaspuns;
	}

	/**
	 * @return the chestionar
	 */
	public Chestionar getChestionar() {
		return chestionar;
	}

	/**
	 * @param chestionar the chestionar to set
	 */
	public void setChestionar(Chestionar chestionar) {
		this.chestionar = chestionar;
	}

	/**
	 * @return the raspunsuri
	 */
	public Map<Integer, List<String>> getRaspunsuri() {
		return raspunsuri;
	}

	/**
	 * @param raspunsuri the raspunsuri to set
	 */
	public void setRaspunsuri(Map<Integer, List<String>> raspunsuri) {
		this.raspunsuri = raspunsuri;
	}
	

}

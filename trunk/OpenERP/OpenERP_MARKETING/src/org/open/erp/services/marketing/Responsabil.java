package org.open.erp.services.marketing;
//test commit

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType; 
import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.personal.Angajat;
/**
 * 
 * @author echipa.marketing
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity

public class Responsabil implements Serializable {
	
	@Id
	Integer IdResponsabil;
	@ManyToOne @JoinColumn(name = "marca")
	Angajat		angajat;
	@OneToMany (mappedBy = "responsabil", cascade = CascadeType.ALL)
		List<Campanie> listaCampanii;
    
	@OneToMany (mappedBy = "Responsabil", cascade = CascadeType.ALL)
	List<Chestionar> listaChestionare;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Responsabil() {
		super();
	}
	/**
	 * @param idPersoana
	 * @param nume
	 * @param prenume
	 */
	
	public List<Campanie> getListaCampanii() {
		return listaCampanii;
	}
	/**
	 * @return the idResponsabil
	 */
	public Integer getIdResponsabil() {
		return IdResponsabil;
	}
	/**
	 * @param idResponsabil the idResponsabil to set
	 */
	public void setIdResponsabil(Integer idResponsabil) {
		IdResponsabil = idResponsabil;
	}
	/**
	 * @return the angajat
	 */
	public Angajat getAngajat() {
		return angajat;
	}
	/**
	 * @param angajat the angajat to set
	 */
	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}
	public void setListaCampanii(List<Campanie> listaCampanii) {
		this.listaCampanii = listaCampanii;
	}
	public List<Chestionar> getListaChestionare() {
		return listaChestionare;
	}
	public void setListaChestionare(List<Chestionar> listaChestionare) {
		this.listaChestionare = listaChestionare;
	}
	
	
}

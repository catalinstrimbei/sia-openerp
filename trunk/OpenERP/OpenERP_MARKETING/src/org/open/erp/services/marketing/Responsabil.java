package org.open.erp.services.marketing;
//test commit

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType; 
import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.open.erp.services.nomgen.Persoana;
//import org.open.erp.services.personal.Angajat;
/**
 * 
 * @author echipa.marketing
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity

public class Responsabil extends Persoana implements Serializable {
	
	@Id
	Integer IdResponsabil;
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
	public Responsabil(Integer idPersoana, String nume, String prenume) {
		super();
		this.setId(idPersoana);
		// TODO Auto-generated constructor stub
	}
	public List<Campanie> getListaCampanii() {
		return listaCampanii;
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

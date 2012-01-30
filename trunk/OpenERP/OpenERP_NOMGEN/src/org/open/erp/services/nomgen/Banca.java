
package org.open.erp.services.nomgen;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */

@Entity
@Table(name="Banca")
@Inheritance(strategy = InheritanceType.JOINED)
public class Banca extends PersoanaJuridica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne@JoinColumn(name= "marca")
	PersoanaJuridica pj;
	private String CapSocial;
	
	/**
	 * @return the capSocial
	 */
	
	public String getCapSocial() { 
		return CapSocial;
	}
	/**
	 * @param capSocial the capSocial to set
	 */
	public void setCapSocial(String capSocial) {
		CapSocial = capSocial;
	}
	
	public Banca(Integer id, String adresa, String denumire, String codFiscal, String nrInmatriculareFiscala, String atributFiscal, String capSocial) {
		super(id,adresa, denumire, codFiscal,nrInmatriculareFiscala, atributFiscal);
		
		CapSocial = capSocial;
	}
	
	public Banca() {
		super();
	       }	
    
}

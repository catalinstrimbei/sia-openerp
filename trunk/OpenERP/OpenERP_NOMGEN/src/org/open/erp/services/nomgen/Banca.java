
package org.open.erp.services.nomgen;

import javax.persistence.Entity;



/**
 * @author Echipa NomGen
 * @BusinessObject(Entity)
 */


public class Banca extends PersoanaJuridica {
	public String CapSocial;
	
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

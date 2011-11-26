/**
 * 
 */
package org.open.erp.services.nomgen;

/**
 * @author Suzy
 *
 */
public class Banca {
	
	public Integer Id;
	public Persoana IdPersoana;
	public String CapSocial;
	public String Denumire;
	/**
	 * @return the id
	 */
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
	 * @return the idPersoana
	 */
	public Persoana getIdPersoana() {
		return IdPersoana;
	}
	/**
	 * @param idPersoana the idPersoana to set
	 */
	public void setIdPersoana(Persoana idPersoana) {
		IdPersoana = idPersoana;
	}
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
	
	
	public String getDenumire() {
		return Denumire;
	}
	/**
	 * @param denumre the denumire to set
	 */
	public void setDenumire(String denumire) {
		Denumire = denumire;
	}
	
	public Banca(Integer id, Persoana idPersoana, String capSocial, String denumire) {
		super();
		Id = id;
		IdPersoana = idPersoana;
		CapSocial = capSocial;
		Denumire = denumire;
	}
	
	public Banca() {
		super();
	       }	
 
}

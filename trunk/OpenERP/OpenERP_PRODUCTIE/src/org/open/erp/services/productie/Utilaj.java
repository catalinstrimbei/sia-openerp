package org.open.erp.services.productie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.open.erp.services.nomgen.MijlocFix;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */
@Entity
public class Utilaj implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	Integer idUtilaj;
	
	@OneToOne (targetEntity=DummyMijlocFix.class)
	private DummyMijlocFix utilaj;
	
	String status;
	
	
	
	public Utilaj(Integer idUtilaj, DummyMijlocFix utilaj, String status) {
		super();
		this.utilaj = utilaj;
		this.status = status;
		this.idUtilaj=idUtilaj;
	}
	public Integer getIdUtilaj() {
		return idUtilaj;
	}
	public void setIdUtilaj(Integer idUtilaj) {
		this.idUtilaj = idUtilaj;
	}
	public Utilaj() {
		super();
	}
	public DummyMijlocFix getUtilaj() {
		return utilaj;
	}
	public void setUtilaj(DummyMijlocFix utilaj) {
		this.utilaj = utilaj;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
}

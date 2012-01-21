
package org.open.erp.services.stocuri;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.Persoana;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class BonTransfer extends Document {
	@ManyToOne@JoinColumn(name="idGestiuneOut")
	private Gestiune gestiuneOUT;
	@ManyToOne@JoinColumn(name="idGestiuneIn")
	private Gestiune gestiuneIN;
	@Temporal(TemporalType.DATE)
	private Date dataTransfer;
	@ManyToOne@JoinColumn(name="responsabil")
	private Gestionar responsabil;
	
	
	
	public BonTransfer(Integer idDoc, Date dataDoc, String solicitant) {
		super(idDoc, dataDoc);
	}
	public BonTransfer(Integer idDoc, Date dataDoc, String solicitant,
			Gestiune gestiuneOUT, Gestiune gestiuneIN, Date dataTransfer,
			Gestionar responsabil) {
		super(idDoc, dataDoc);
		this.gestiuneOUT = gestiuneOUT;
		this.gestiuneIN = gestiuneIN;
		this.dataTransfer = dataTransfer;
		this.responsabil = responsabil;
	}
	public Gestiune getGestiuneOUT() {
		return gestiuneOUT;
	}
	public void setGestiuneOUT(Gestiune gestiuneOUT) {
		this.gestiuneOUT = gestiuneOUT;
	}
	public Gestiune getGestiuneIN() {
		return gestiuneIN;
	}
	public void setGestiuneIN(Gestiune gestiuneIN) {
		this.gestiuneIN = gestiuneIN;
	}
	public Date getDataTransfer() {
		return dataTransfer;
	}
	public void setDataTransfer(Date dataTransfer) {
		this.dataTransfer = dataTransfer;
	}
	public Gestionar getResponsabil() {
		return responsabil;
	}
	public void setResponsabil(Gestionar responsabil) {
		this.responsabil = responsabil;
	}
	public BonTransfer() {
		super();
	}
	
	
	
	

}

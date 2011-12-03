
package org.open.erp.services.stocuri;

import java.util.Date;

import org.open.erp.services.nomgen.Document;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class BonTransfer extends Document {
	private Gestiune gestiuneOUT;
	private Gestiune gestiuneIN;
	private Date dataTransfer;
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
	
	
	
	

}

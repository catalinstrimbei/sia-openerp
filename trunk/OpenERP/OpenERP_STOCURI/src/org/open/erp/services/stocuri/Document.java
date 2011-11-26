package org.open.erp.services.stocuri;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */

public class Document {
	
	protected Integer idDoc;
	protected Date dataDoc;
	protected String solicitant;
	
    protected List<Linie> linii= new ArrayList<Linie>();
	
	
	
	public Document(Integer idDoc, Date dataDoc, String solicitant) {
		super();
		this.idDoc = idDoc;
		this.dataDoc = dataDoc;
		this.solicitant = solicitant;
		
	}
	public void addLinie(Linie linie){
		this.linii.add(linie);
	}
	public void removeLinie(Linie linie){
		this.linii.remove(linie);
	}
	
	public List<Linie> getLinii() {
		return linii;
	}
	public Integer getIdComanda() {
		return idDoc;
	}
	public void setIdComanda(Integer idComanda) {
		this.idDoc = idComanda;
	}
	public Date getDataComanda() {
		return dataDoc;
	}
	public void setDataComanda(Date dataComanda) {
		this.dataDoc = dataComanda;
	}
	public String getSolicitant() {
		return solicitant;
	}
	public void setSolicitant(String solicitant) {
		this.solicitant = solicitant;
	}
	public Document() {
		super();
	}
	public Document( Date dataComanda, String solicitant) {
		super();
	
		this.dataDoc = dataComanda;
		this.solicitant = solicitant;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idDoc == null) ? 0 : idDoc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (idDoc == null) {
			if (other.idDoc != null)
				return false;
		} else if (!idDoc.equals(other.idDoc))
			return false;
		return true;
	}
	
	
	

}

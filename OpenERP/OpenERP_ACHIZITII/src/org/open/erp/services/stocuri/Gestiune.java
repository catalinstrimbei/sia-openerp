package org.open.erp.services.stocuri;
import java.util.ArrayList;
import java.util.List;

import org.open.erp.services.nommat.Materiale;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
public class Gestiune {
	
	private Integer idGest;
	private String denumireGest;
	private List<Materiale>  materiale = new ArrayList<Materiale>();
	
	public Gestiune(Integer idGest, String denumireGest) {
		super();
		this.idGest = idGest;
		this.denumireGest = denumireGest;
	}
	
	public void addArticole(Materiale material){
		this.materiale.add(material);
	}
	public void removeArticole(Materiale material){
		this.materiale.remove(material);
	}
	
	public Integer getIdGest() {
		return idGest;
	}
	public void setIdGest(Integer idGest) {
		this.idGest = idGest;
	}
	public String getDenumireGest() {
		return denumireGest;
	}
	public void setDenumireGest(String denumireGest) {
		this.denumireGest = denumireGest;
	}

	public List<Materiale> getMaterial() {
		return materiale;
	}
	public void setMateriale(List<Materiale> materiale) {
		this.materiale = materiale;
	}

	
	

}

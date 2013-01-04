package org.open.erp.services.stocuri;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.ALL;

import org.open.erp.services.nommat.Material;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class Articol extends Material{
	@Id @GeneratedValue
	private Integer idArticol;
	private Double cantPeGestiune;
	private Gestiune gestiune;
	private Material material;
	@OneToMany(targetEntity = Loturi.class,
			cascade = ALL, fetch = EAGER)
	private List<Loturi> loturiArticole = new ArrayList<Loturi>();
	
	public void addLot(Loturi lot){
		this.loturiArticole.add(lot);
		cantPeGestiune += lot.getCantitate();
		//lot.setArticol(this);
	}

	public void removeLot(Loturi lot){
		this.loturiArticole.remove(lot);
		cantPeGestiune -= lot.getCantitate();
	}
	
	public void cresteCantitateArticolPeGestiune(Double cantitate){
		this.cantPeGestiune += cantitate;
	}
	public void scadeCantitateArticolPeGestiune(Double cantitate){
		this.cantPeGestiune -= cantitate;
	}
	
	
	public Integer getIdArticol() {
		return idArticol;
	}
	public void setIdArticol(Integer idArticol) {
		this.idArticol = idArticol;
	}
	public Double getCantPeGestiune() {
		return cantPeGestiune;
	}
	public void setCantPeGestiune(Double cantPeGestiune) {
		this.cantPeGestiune = cantPeGestiune;
	}
	public Gestiune getGestiune() {
		return gestiune;
	}
	public void setGestiune(Gestiune gestiune) {
		this.gestiune = gestiune;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material produs) {
		this.material = produs;
	}
	public List<Loturi> getLoturiArticole() {
		return loturiArticole;
	}
	public void setLoturiArticole(List<Loturi> loturiArticole) {
		this.loturiArticole = loturiArticole;
	}
	public Articol(Integer idArticol, Double cantPeGestiune,
			Gestiune gestiune, Material material, List<Loturi> loturiArticole) {
		super();
		this.idArticol = idArticol;
		this.cantPeGestiune = cantPeGestiune;
		this.gestiune = gestiune;
		this.material = material;
		this.loturiArticole = loturiArticole;
	}

	public Articol() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

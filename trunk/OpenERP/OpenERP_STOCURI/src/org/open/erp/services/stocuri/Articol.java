package org.open.erp.services.stocuri;

import java.util.ArrayList;
import java.util.List;
import org.open.erp.services.achizitii.Produs;

public class Articol {
	private Integer idArticol;
	private Double cantPeGestiune;
	private Gestiune gestiune;
	private Produs produs;
	private List<Loturi> loturiArticole = new ArrayList<Loturi>();
	
	public void addLot(Loturi lot){
		this.loturiArticole.add(lot);
		//cantPeGestiune += lot.getCantitate();
		//lot.setArticol(this);
	}

	public void removeLotIntrare(Loturi lot){
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
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public List<Loturi> getLoturiArticole() {
		return loturiArticole;
	}
	public void setLoturiArticole(List<Loturi> loturiArticole) {
		this.loturiArticole = loturiArticole;
	}
	public Articol(Integer idArticol, Double cantPeGestiune,
			Gestiune gestiune, Produs produs, List<Loturi> loturiArticole) {
		super();
		this.idArticol = idArticol;
		this.cantPeGestiune = cantPeGestiune;
		this.gestiune = gestiune;
		this.produs = produs;
		this.loturiArticole = loturiArticole;
	}
	
	
}

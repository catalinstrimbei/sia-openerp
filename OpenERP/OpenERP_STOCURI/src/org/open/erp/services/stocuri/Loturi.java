package org.open.erp.services.stocuri;
/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

@Entity
public class Loturi {
	@Id @GeneratedValue
	private	Integer idLot;
	private Double cantitate;
	private Double pretIntrare;
	@Temporal(DATE)
	private Date dataIntrare;
	//private Articol articol;
	
	public Loturi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loturi(Integer idLot, Double cantitate, Double pretIntrare,
			Date dataIntrare/*, Articol articol*/) {
		super();
		this.idLot = idLot;
		this.cantitate = cantitate;
		this.pretIntrare = pretIntrare;
		this.dataIntrare = dataIntrare;
		//this.articol = articol;
	}
	public Loturi(Double cantitate, Double pretIntrare,
			Date dataIntrare/*, Articol articol*/) {
		super();
		//this.idLot = idLot;
		this.cantitate = cantitate;
		this.pretIntrare = pretIntrare;
		this.dataIntrare = dataIntrare;
		//this.articol = articol;
	}
	
	public void scadeCantitatea(Double cantitate){
		this.cantitate -= cantitate;
		//this.articol.scadeCantitateArticolPeGestiune(cantitate);
	}
	
	public void cresteCantitate(Double cantitate){
		//this.cantitate += cantitate;
		//this.articol.cresteCantitateArticolPeGestiune(cantitate);
	}

	public Integer getIdLot() {
		return idLot;
	}

	public void setIdLot(Integer idLot) {
		this.idLot = idLot;
	}

	public Double getCantitate() {
		return cantitate;
	}

	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}

	public Double getPretIntrare() {
		return pretIntrare;
	}

	public void setPretIntrare(Double pretIntrare) {
		this.pretIntrare = pretIntrare;
	}

	public Date getDataIntrare() {
		return dataIntrare;
	}

	public void setDataIntrare(Date dataIntrare) {
		this.dataIntrare = dataIntrare;
	}

	/*public Articol getArticol() {
		return articol;
	}

	public void setArticol(Articol articol) {
		this.articol = articol;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLot == null) ? 0 : idLot.hashCode());
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
		Loturi other = (Loturi) obj;
		if (idLot == null) {
			if (other.idLot != null)
				return false;
		} else if (!idLot.equals(other.idLot))
			return false;
		return true;
	}
	
	
	
}

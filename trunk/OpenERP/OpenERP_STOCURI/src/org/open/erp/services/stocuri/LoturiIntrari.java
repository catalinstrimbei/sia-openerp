package org.open.erp.services.stocuri;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author echipa.stocuri
 * 
 * @BusinessObject(Entity)
 * 
 */

@Entity
public class LoturiIntrari implements Comparable<LoturiIntrari>, Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idLot;
	private Integer cantitate;
	private Double pretIntrare;
	@Temporal(TemporalType.DATE)
	private Date dataIntrare;
	@ManyToOne
	@JoinColumn(name = "idArticolStoc")
	private ArticolStoc articol;

	public LoturiIntrari() {
		super();
	}

	public LoturiIntrari(Integer idLot, Integer cantitate, Double pretIntrare,
			Date dataIntrare, ArticolStoc articol) {
		super();
		this.idLot = idLot;
		this.cantitate = cantitate;
		this.pretIntrare = pretIntrare;
		this.dataIntrare = dataIntrare;
		this.articol = articol;
	}

	public void decrementeazaCant(Integer cant) {
		this.cantitate -= cant;
		this.articol.decrementeazaCantArticolPeGestiune(cant);
	}

	public void incrementeazaCant(Integer cant) {
		this.cantitate += cant;
		this.articol.incrementeazaCantArticolPeGestiune(cant);
	}

	public Integer getIdLot() {
		return idLot;
	}

	public void setIdLot(Integer idLot) {
		this.idLot = idLot;
	}

	public Integer getCantitate() {
		return cantitate;
	}

	public void setCantitate(Integer cantitate) {
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

	public ArticolStoc getArticol() {
		return articol;
	}

	public void setArticol(ArticolStoc articol) {
		this.articol = articol;
	}

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
		LoturiIntrari other = (LoturiIntrari) obj;
		if (idLot == null) {
			if (other.idLot != null)
				return false;
		} else if (!idLot.equals(other.idLot))
			return false;
		return true;
	}

	@Override
	public int compareTo(LoturiIntrari o) {
		if (o == null) {
			return 0;
		}
		if (this.dataIntrare.after(o.dataIntrare)) {
			return 1;
		} else if (this.dataIntrare.before(o.dataIntrare)) {
			return -1;
		} else {
			return 0;
		}
	}

}

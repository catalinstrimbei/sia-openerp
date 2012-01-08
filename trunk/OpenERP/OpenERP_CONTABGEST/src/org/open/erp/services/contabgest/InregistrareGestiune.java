package org.open.erp.services.contabgest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.open.erp.services.ctbgen.ArticolCtb;
import org.open.erp.services.ctbgen.Cont;

@Entity
public class InregistrareGestiune implements Serializable {
	@Id
	@GeneratedValue
	private Integer idInregistrare;
	private ArticolCtb articolCtb;
	private Cont cont;
	private CentruCost centruCost;

	public InregistrareGestiune() {
		super();
	}

	public InregistrareGestiune(Integer idInregistrare, ArticolCtb articolCtb,
			Cont cont, CentruCost centruCost) {
		super();
		this.idInregistrare = idInregistrare;
		this.articolCtb = articolCtb;
		this.cont = cont;
		this.centruCost = centruCost;
	}

	public Integer getIdInregistrare() {
		return idInregistrare;
	}

	public void setIdInregistrare(Integer idInregistrare) {
		this.idInregistrare = idInregistrare;
	}

	public ArticolCtb getArticolCtb() {
		return articolCtb;
	}

	public void setArticolCtb(ArticolCtb articolCtb) {
		this.articolCtb = articolCtb;
	}

	public Cont getCont() {
		return cont;
	}

	public void setCont(Cont cont) {
		this.cont = cont;
	}

	public CentruCost getCentruCost() {
		return centruCost;
	}

	public void setCentruCost(CentruCost centruCost) {
		this.centruCost = centruCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idInregistrare == null) ? 0 : idInregistrare.hashCode());
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
		InregistrareGestiune other = (InregistrareGestiune) obj;
		if (idInregistrare == null) {
			if (other.idInregistrare != null)
				return false;
		} else if (!idInregistrare.equals(other.idInregistrare))
			return false;
		return true;
	}

}

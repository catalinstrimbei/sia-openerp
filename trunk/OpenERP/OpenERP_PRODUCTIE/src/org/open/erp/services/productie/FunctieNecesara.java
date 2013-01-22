package org.open.erp.services.productie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.open.erp.services.personal.Functie;

@Entity
public class FunctieNecesara extends Functie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne (targetEntity=Functie.class)
	@JoinColumn(name = "idFunctie", insertable=false, updatable=false)
	private Functie id;
	
	Integer nrAngajatiFunctie;
	
	@ManyToOne
	private FazaProductie faza;

	public Functie getId() {
		return id;
	}

	public void setId(Functie id) {
		this.id = id;
	}

	public Integer getNrAngajatiFunctie() {
		return nrAngajatiFunctie;
	}

	public void setNrAngajatiFunctie(Integer nrAngajatiFunctie) {
		this.nrAngajatiFunctie = nrAngajatiFunctie;
	}

	public FazaProductie getFaza() {
		return faza;
	}

	public void setFaza(FazaProductie faza) {
		this.faza = faza;
	}

	public FunctieNecesara(Integer idFunctie, String numeFunctie, Functie id,
			Integer nrAngajatiFunctie, FazaProductie faza) {
		super(idFunctie, numeFunctie);
		this.id = id;
		this.nrAngajatiFunctie = nrAngajatiFunctie;
		this.faza = faza;
	}

	public FunctieNecesara() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FunctieNecesara(Integer idFunctie, String numeFunctie) {
		super(idFunctie, numeFunctie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((faza == null) ? 0 : faza.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((nrAngajatiFunctie == null) ? 0 : nrAngajatiFunctie
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FunctieNecesara other = (FunctieNecesara) obj;
		if (faza == null) {
			if (other.faza != null)
				return false;
		} else if (!faza.equals(other.faza))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nrAngajatiFunctie == null) {
			if (other.nrAngajatiFunctie != null)
				return false;
		} else if (!nrAngajatiFunctie.equals(other.nrAngajatiFunctie))
			return false;
		return true;
	}
	
	
}

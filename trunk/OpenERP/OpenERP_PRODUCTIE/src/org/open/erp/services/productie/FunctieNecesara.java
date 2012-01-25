package org.open.erp.services.productie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.personal.Functie;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */
@Entity
public class FunctieNecesara extends Functie implements Serializable{

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

	public void setIdFunctie(Functie id) {
		this.id = id;
	}
	public FunctieNecesara(Integer id, String denumire) {
		super(id, denumire);
	}

	public FunctieNecesara(Integer id, String denumire,
			Integer nrAngajatiFunctie) {
		super(id, denumire);
		this.nrAngajatiFunctie = nrAngajatiFunctie;
	}

	public FunctieNecesara(){
		super();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

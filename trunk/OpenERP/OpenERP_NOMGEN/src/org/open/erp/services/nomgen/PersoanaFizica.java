package org.open.erp.services.nomgen;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/*
 * @author Echipa NomGen
 * @BusinessObject(DummyEntity)
 * @BusinessObject(Entity)
 */

@Entity
public class PersoanaFizica extends Persoana implements Serializable, PF{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6694004163196858228L;
	



	private String  nume;
	private String  prenume;
	private String  formaAdresare;
	private char    gen;
	private String  cnp;
	//@OneToOne @JoinColumn(name= "id")
	@ManyToOne
	private Persoana p;
	
	
	
	/**
	 * @return the nume
	 */
	@Override
	public String getNume() {
		return nume;
	}

	/**
	 * @param nume the nume to set
	 */
	@Override
	public void setNume(String nume) {
		this.nume = nume;
	}


	/**
	 * @return the prenume
	 */
	@Override
	public String getPrenume() {
		return prenume;
	}

	/**
	 * @param prenume the prenume to set
	 */
	@Override
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}


	/**
	 * @return the formaAdresare
	 */
	@Override
	public String getFormaAdresare() {
		return formaAdresare;
	}

	/**
	 * @param formaAdresare the formaAdresare to set
	 */
	@Override
	public void setFormaAdresare(String formaAdresare) {
		this.formaAdresare = formaAdresare;
	}


	/**
	 * @return the gen
	 */
	@Override
	public char getGen() {
		return gen;
	}

	/**
	 * @param gen the gen to set
	 */
	@Override
	public void setGen(char gen) {
		this.gen = gen;
	}


	/**
	 * @return the cnp
	 */
	@Override
	public String getCnp() {
		return cnp;
	}

	/**
	 * @param cnp the cnp to set
	 */
	@Override
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}


	

	
	@Override
	public Persoana getP() {
		return p;
	}
	@Override
	public void setP(Persoana p) {
		this.p = p;
	}

	

	public PersoanaFizica(Integer id, String adresa,String nume, String prenume, String formaAdresare, char gen, String cnp) {
	    super(id, adresa);
		
		this.nume = nume;
		this.prenume = prenume;
		this.formaAdresare = formaAdresare;
		this.gen = gen;
		this.cnp = cnp;
	}
	
	
	public PersoanaFizica() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnp == null) ? 0 : cnp.hashCode());
		result = prime * result
				+ ((formaAdresare == null) ? 0 : formaAdresare.hashCode());
		result = prime * result + gen;
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + ((prenume == null) ? 0 : prenume.hashCode());
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
		PersoanaFizica other = (PersoanaFizica) obj;
		if (cnp == null) {
			if (other.cnp != null)
				return false;
		} else if (!cnp.equals(other.cnp))
			return false;
		if (formaAdresare == null) {
			if (other.formaAdresare != null)
				return false;
		} else if (!formaAdresare.equals(other.formaAdresare))
			return false;
		if (gen != other.gen)
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (prenume == null) {
			if (other.prenume != null)
				return false;
		} else if (!prenume.equals(other.prenume))
			return false;
		return true;
	}
	

	public PersoanaFizica(Integer id, Departament dep, String adresa,
			List<String> telefoane2, List<String> emailuri2, String nume,
			String prenume, String formaAdresare, char gen, String cnp) {
		super(id, dep, adresa, telefoane2, emailuri2);
		this.nume = nume;
		this.prenume = prenume;
		this.formaAdresare = formaAdresare;
		this.gen = gen;
		this.cnp = cnp;
	}

	public PersoanaFizica(String nume, String prenume, String formaAdresare,
			char gen, String cnp) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.formaAdresare = formaAdresare;
		this.gen = gen;
		this.cnp = cnp;
	}
	
	
	
	
	
	
}
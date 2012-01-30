package org.open.erp.services.marketing;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.IndexColumn;


@Entity
public class Chestionar implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	Integer				idChestionar;
	String				denumireChestionar;	
    @ManyToOne @JoinColumn (name = "idResponsabil")
	Responsabil			Responsabil; 
	String				scopChestionar;
	Integer				numarIntrebari;
	@OneToMany(mappedBy = "chestionar", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@IndexColumn(name = "idIntrebare")
	List<Intrebare>		listaIntrebari; 
	/**
	 * @return the idChestionar

	 */
	public Integer getIdChestionar() {
		return idChestionar;
	}
	/**
	 * @param idChestionar the idChestionar to set
	 */
	public void setIdChestionar(Integer idChestionar) {
		this.idChestionar = idChestionar;
	}
	/**
	 * @param idChestionar
	 * @param denumireChestionar
	 * @param responsabil
	 * @param scopChestionar
	 * @param numarIntrebari
	 * @param listaIntrebari
	 */
	public Chestionar(Integer idChestionar, String denumireChestionar,
			org.open.erp.services.marketing.Responsabil responsabil,
			String scopChestionar, Integer numarIntrebari,
			List<Intrebare> listaIntrebari) {
		super();
		this.idChestionar = idChestionar;
		this.denumireChestionar = denumireChestionar;
		Responsabil = responsabil;
		this.scopChestionar = scopChestionar;
		this.numarIntrebari = numarIntrebari;
		this.listaIntrebari = listaIntrebari;
	}
	/**
	 * @return the denumireChestionar
	 */
	public String getDenumireChestionar() {
		return denumireChestionar;
	}
	/**
	 * @param denumireChestionar the denumireChestionar to set
	 */
	public void setDenumireChestionar(String denumireChestionar) {
		this.denumireChestionar = denumireChestionar;
	}
	/**
	 * @return the responsabil
	 */
	public Responsabil getResponsabil() {
		return Responsabil;
	}
	
	/**
	 * @return the scopChestionar
	 */
	public String getScopChestionar() {
		return scopChestionar;
	}
	/**
	 * @param scopChestionar the scopChestionar to set
	 */
	public void setScopChestionar(String scopChestionar) {
		this.scopChestionar = scopChestionar;
	}
	/**
	 * @param responsabil the responsabil to set
	 */
	public void setResponsabil(Responsabil responsabil) {
		Responsabil = responsabil;
	}
	/**
	 * @return the numarIntrebari
	 */
	public Integer getNumarIntrebari() {
		return numarIntrebari;
	}
	/**
	 * @param numarIntrebari the numarIntrebari to set
	 */
	public void setNumarIntrebari(Integer numarIntrebari) {
		this.numarIntrebari = numarIntrebari;
	}
	/**
	 * @return the listaIntrebari
	 */
	public List<Intrebare> getListaIntrebari() {
		return listaIntrebari;
	}
	/**
	 * @param listaIntrebari the listaIntrebari to set
	 */
	public void setListaIntrebari(List<Intrebare> listaIntrebari) {
		this.listaIntrebari = listaIntrebari;
	}
	
	/**
	 * @param denumireChestionar
	 * @param responsabil
	 * @param scopChestionar
	 * @param numarIntrebari
	 * @param listaIntrebari
	 */
	public Chestionar(String denumireChestionar,
			org.open.erp.services.marketing.Responsabil responsabil,
			String scopChestionar, Integer numarIntrebari,
			List<Intrebare> listaIntrebari) {
		super();
		this.denumireChestionar = denumireChestionar;
		Responsabil = responsabil;
		this.scopChestionar = scopChestionar;
		this.numarIntrebari = numarIntrebari;
		this.listaIntrebari = listaIntrebari;
	}
	public Chestionar() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idChestionar == null) ? 0 : idChestionar.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chestionar other = (Chestionar) obj;
		if (idChestionar == null) {
			if (other.idChestionar != null)
				return false;
		} else if (!idChestionar.equals(other.idChestionar))
			return false;
		return true;
	}

	
}

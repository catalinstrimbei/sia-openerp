package org.open.erp.services.contabgen.conturi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Clasa implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer id;
	private String denumireClasa;
	private Integer codClasa;
	
	@OneToMany(mappedBy="clasa" , cascade=CascadeType.ALL)
	private List<Cont> conturi = new ArrayList<Cont>();


	public Clasa() {
	}

	public Integer getCodClasa() {
		return codClasa;
	}

	public void setCodClasa(Integer codClasa) {
		this.codClasa = codClasa;
	}

	public String getDenumireClasa() {
		return denumireClasa;
	}

	public void setDenumireClasa(String denumireClasa) {
		this.denumireClasa = denumireClasa;
	}

	public List<Cont> getConturi() {
		return conturi;
	}

	public void addCont(Cont cont) {
		this.conturi.add(cont);
	}

	public void removeCont(Cont cont) {
		this.conturi.remove(cont);
	}

	public Clasa(String denumireClasa) {
		super();
		this.denumireClasa = denumireClasa;
	}

	public Cont getContByCod(Integer cod) {
		for (Cont c : this.conturi) {
			if (c.getCodCont() == cod)
				return c;
		}

		return null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setConturi(List<Cont> conturi) {
		this.conturi = conturi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Clasa other = (Clasa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}

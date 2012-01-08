package org.open.erp.services.marketing;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.open.erp.services.nomgen.Produs;
@Entity
public class ProduseAditionale {
	@Id
	Integer IdCombinatie;
	@OneToOne
	@JoinColumn(name="IdProdus")
	Produs	produs;
	@OneToMany
	@JoinTable(name="Produs",
	joinColumns = @JoinColumn (name="idCombinatie"),
	inverseJoinColumns = @JoinColumn(name = "idProdus"))
	List<Produs> produseAditionale = new ArrayList<Produs>();
	public Integer getIdCombinatie() {
		return IdCombinatie;
	}
	public void setIdCombinatie(Integer idCombinatie) {
		IdCombinatie = idCombinatie;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public List<Produs> getProduseAditionale() {
		return produseAditionale;
	}
	public void setProduseAditionale(List<Produs> produseAditionale) {
		this.produseAditionale = produseAditionale;
	}
	public ProduseAditionale(Integer idCombinatie, Produs produs,
			List<Produs> produseAditionale) {
		super();
		IdCombinatie = idCombinatie;
		this.produs = produs;
		this.produseAditionale = produseAditionale;
	}
	public void adaugaProdusAditional(Produs   prodAditional)
	{
		this.produseAditionale.add(prodAditional);
	}
	
	public void stergeProdusAditional (Produs prodAditional)
	{
		this.produseAditionale.remove(prodAditional);
	}
	public ProduseAditionale() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
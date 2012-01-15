package org.open.erp.services.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import org.open.erp.services.nomgen.Produs;
@Entity
public class ProduseAditionale implements Serializable{
	@Id
	Integer IdCombinatie;
	@OneToOne
	@JoinColumn(name="IdProdus")
	DummyProdus	produs;
	@OneToMany
	@JoinTable(name="Produs",
	joinColumns = @JoinColumn (name="idCombinatie"),
	inverseJoinColumns = @JoinColumn(name = "idProdus"))
	List<DummyProdus> produseAditionale = new ArrayList<DummyProdus>();
	@ManyToOne @JoinColumn(name = "idPromotie")
	Promotie	promotie;
	public Integer getIdCombinatie() {
		return IdCombinatie;
	}
	public void setIdCombinatie(Integer idCombinatie) {
		IdCombinatie = idCombinatie;
	}
	public DummyProdus getProdus() {
		return produs;
	}
	public void setProdus(DummyProdus produs) {
		this.produs = produs;
	}
	public List<DummyProdus> getProduseAditionale() {
		return produseAditionale;
	}
	public void setProduseAditionale(List<DummyProdus> produseAditionale) {
		this.produseAditionale = produseAditionale;
	}
	public ProduseAditionale(Integer idCombinatie, DummyProdus produs,
			List<DummyProdus> produseAditionale) {
		super();
		IdCombinatie = idCombinatie;
		this.produs = produs;
		this.produseAditionale = produseAditionale;
	}
	public void adaugaProdusAditional(DummyProdus   prodAditional)
	{
		this.produseAditionale.add(prodAditional);
	}
	
	public void stergeProdusAditional (DummyProdus prodAditional)
	{
		this.produseAditionale.remove(prodAditional);
	}
	public ProduseAditionale() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

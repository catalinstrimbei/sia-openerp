package org.open.erp.services.productie;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.personal.*;

/**
 * 
 * @author Echipa Productie
 * 
 * @BusinessObject(Entity)
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FazaProductie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	String faza;
	
	@ManyToOne
	//@JoinColumn(name="idFlux")
	FluxProductie flux;
	
	@ManyToOne
	@JoinColumn(name = "id")
	Utilaj utilaj;
	Double timpFolosire;
	
	@OneToMany (targetEntity=FunctieNecesara.class, mappedBy="faza")
	ArrayList <FunctieNecesara> functiiNecesare;
		
	@ManyToOne (targetEntity=Angajat.class)
	@JoinColumn(name="marca")
	ArrayList<Angajat> angajati;
	
	@ManyToOne (targetEntity=Material.class)
	@JoinColumn(name = "idMaterial")
	ArrayList<Material> materialeReteta;
	
	@ManyToOne 
	@JoinColumn(name = "idSemifabricat")
	Semifabricat semifabricatReteta;
	
	@ManyToOne
	@JoinColumn(name = "idSemifabricat")
	Semifabricat semifabricatDorit;
	
	@ManyToOne (targetEntity=Produs.class)
	@JoinColumn(name = "id")
	Produs produsDorit;
	
	@ManyToOne
	@JoinColumn(name = "idSemifabricat")
	Semifabricat semifabricatObtinut;
	
	@ManyToOne (targetEntity=Produs.class)
	@JoinColumn(name = "id")
	Produs produsObtinut;
	
	@ManyToOne  (targetEntity=Divizie.class)
	@JoinColumn(name = "id")
	Divizie sectie;
	
	Integer nrOrdine;
	Boolean isFinal;
	
		
	public Integer getNrOrdine() {
		return nrOrdine;
	}

	public void setNrOrdine(Integer nrOrdine) {
		this.nrOrdine = nrOrdine;
	}

	public Boolean getIsFinal() {
		return isFinal;
	}

	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	public FazaProductie() {
		super();
	}

	public Utilaj getUtilaj() {
		return utilaj;
	}

	public void setUtilaj(Utilaj utilaj) {
		this.utilaj = utilaj;
	}

	public ArrayList<FunctieNecesara> getFunctiiNecesare() {
		return functiiNecesare;
	}

	public void adaugaFunctieNecesara(FunctieNecesara functieNecesare) {
		this.functiiNecesare.add(functieNecesare);
	}

	public FazaProductie(String faza,  Utilaj utilaj, Double timpFolosire,
			ArrayList<FunctieNecesara> functiiNecesare,
			ArrayList<Material> materialeReteta,
			 Semifabricat semifabricatDorit,
			 Produs produsDorit, Divizie sectie, Integer nrOrdine, Boolean isFinal) {
		super();
		this.faza = faza;
		this.utilaj = utilaj;
		this.timpFolosire = timpFolosire;
		this.functiiNecesare = functiiNecesare;
		this.materialeReteta = materialeReteta;
		
		this.semifabricatDorit = semifabricatDorit;
		this.produsDorit = produsDorit;
		this.sectie=sectie;
		this.nrOrdine=nrOrdine;
		this.isFinal=isFinal;
		
	}
	public String getFaza() {
		return faza;
	}

	public FluxProductie getFlux() {
		return flux;
	}

	public void setFlux(FluxProductie flux) {
		this.flux = flux;
	}

	public void setFaza(String faza) {
		this.faza = faza;
	}

	public Double getTimpFolosire() {
		return timpFolosire;
	}

	public void setTimpFolosire(Double timpFolosire) {
		this.timpFolosire = timpFolosire;
	}

	public ArrayList<Angajat> getAngajati() {
		return angajati;
	}

	public void setAngajati(ArrayList<Angajat> angajati) {
		this.angajati = angajati;
	}

	public ArrayList<Material> getMaterialeReteta() {
		return materialeReteta;
	}

	public void addMaterialeReteta(Material materialReteta) {
		this.materialeReteta.add(materialReteta);
	}

	public Semifabricat getSemifabricatReteta() {
		return semifabricatReteta;
	}

	public void setSemifabricatReteta(Semifabricat semifabricatReteta) {
		this.semifabricatReteta = semifabricatReteta;
	}

	public Semifabricat getSemifabricatDorit() {
		return semifabricatDorit;
	}

	public void setSemifabricatDorit(Semifabricat semifabricatDorit) {
		this.semifabricatDorit = semifabricatDorit;
	}

	public Produs getProdusDorit() {
		return produsDorit;
	}

	public void setProdusDorit(Produs produsDorit) {
		this.produsDorit = produsDorit;
	}

	

	public Divizie getSectie() {
		return sectie;
	}

	public void setSectie(Divizie sectie) {
		this.sectie = sectie;
	}

	public Semifabricat procesareSemifabricat(){
		
		utilaj.setStatus("ocupat");
		
		if (semifabricatDorit.getListaMateriale()== materialeReteta && 
				semifabricatDorit.getSemifabricatContinut()== semifabricatReteta){
			
			semifabricatObtinut=semifabricatDorit;
			utilaj.setStatus("liber");
				}
		else{
			semifabricatObtinut=null;
			System.out.println("Lista materialelor nu corespunde");
			}
		return semifabricatObtinut;
		
	}
	
	 public Produs procesareProdus(){
	     
	     utilaj.setStatus("ocupat");
	     if(semifabricatDorit.semifabricat==produsDorit.getDenumire())
	     {produsObtinut=produsDorit;
	      utilaj.setStatus("liber");
	     }
	     else {
	      produsObtinut=null;
	      System.out.println("Nu s-a obtinut produsul dorit");
	     }
	     return produsObtinut;
	     
	    }
	
	 
}

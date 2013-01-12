package org.open.erp.services.vanzari;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.open.erp.services.personal.Angajat;
import javax.persistence.Id;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Facturi {

	@Id @GeneratedValue
	Integer idFactura;
	
	@Temporal(TIMESTAMP)
	Date data;
	
	@OneToOne(targetEntity = org.open.erp.services.personal.Angajat.class)
	Angajat responsabil;
	
	@OneToOne(targetEntity = org.open.erp.services.vanzari.Avize.class)
	Avize avizCorespondent;
	
	@ManyToOne(targetEntity = org.open.erp.services.vanzari.Comenzi.class)
	Comenzi comanda;
	
	@OneToMany(targetEntity = org.open.erp.services.vanzari.LiniiFactura.class, mappedBy = "factura")
	List<LiniiFactura> liniiFactura = new ArrayList<LiniiFactura>();
	
	
	
	
	public Facturi() {
		super();
	}




	public Facturi(Integer idFactura, Date data, Angajat responsabil,
			Avize avizCorespondent, Comenzi comanda,
			List<LiniiFactura> liniiFactura) {
		super();
		this.idFactura = idFactura;
		this.data = data;
		this.responsabil = responsabil;
		this.avizCorespondent = avizCorespondent;
		this.comanda = comanda;
		this.liniiFactura = liniiFactura;
	}

	
	

	public Integer getIdFactura() {
		return idFactura;
	}




	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}




	public Date getData() {
		return data;
	}




	public void setData(Date data) {
		this.data = data;
	}




	public Angajat getAngajat() {
		return responsabil;
	}




	public void setAngajat(Angajat responsabil) {
		this.responsabil = responsabil;
	}




	public Avize getAvizCorespondent() {
		return avizCorespondent;
	}




	public void setAvizCorespondent(Avize avizCorespondent) {
		this.avizCorespondent = avizCorespondent;
	}




	public Comenzi getComanda() {
		return comanda;
	}




	public void setComanda(Comenzi comanda) {
		this.comanda = comanda;
	}




	public List<LiniiFactura> getLiniiFactura() {
		return liniiFactura;
	}




	public void setLiniiFactura(List<LiniiFactura> liniiFactura) {
		this.liniiFactura = liniiFactura;
	}




	public Double getValoareFactura(Integer id){
					
			Double valoare = 0.0;
			for (LiniiFactura linie: liniiFactura){
				valoare = valoare + linie.valoareLinieFactura();
			}
			
			return valoare;
		}
	

	public void adaugaLinieFactura( LiniiFactura linieFactura){
		
		this.liniiFactura.add(linieFactura);
	}

	public List<LiniiFactura> getLiniiFacturiByIdFactura(Integer id){
		List<LiniiFactura> linii=null;
		if(this.idFactura.equals(id)){
			linii=this.getLiniiFactura();
		}
		return linii;
	}
}

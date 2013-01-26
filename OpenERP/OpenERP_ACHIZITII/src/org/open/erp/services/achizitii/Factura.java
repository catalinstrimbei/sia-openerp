
/*factura achizitii */

package org.open.erp.services.achizitii;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Factura implements Serializable{
	//in Document de la modulul NOMGEN trebuie adaugata 
		//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  inainte de clasa
	 
	@Id @GeneratedValue
	private Integer nrFactura;   /* public din private@LAR*/
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFactura;     /* public din private@LAR*/
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataScadenta;  //data pana la care se poate plati factura
	
	@ManyToOne
	private Furnizori funrizor;
	
	@OneToMany(mappedBy = "factura", 
			targetEntity = LiniiFactura.class, 
			cascade = ALL)
	private List<LiniiFactura> linieFactura;
	private Double valoareTotala; /* public din private@LAR*/

	
	public Integer getNrFactura() {
		return nrFactura;
	}
	public void setNrFactura(Integer nrFactura) {
		this.nrFactura = nrFactura;
	}
	public Date getDataFactura() {
		return dataFactura;
	}
	public void setDataFactura(Date dataFactura) {
		this.dataFactura = dataFactura;
	}
	public Date getDataScadenta() {
		return dataScadenta;
	}
	public void setDataScadenta(Date dataScadenta) {
		this.dataScadenta = dataScadenta;
	}
	public Furnizori getFunrizor() {
		return funrizor;
	}
	public void setFunrizor(Furnizori funrizor) {
		this.funrizor = funrizor;
	}
	public List<LiniiFactura> getLinieFactura() {
		return linieFactura;
	}
	public void setLinieFactura(List<LiniiFactura> linieFactura) {
		this.linieFactura = linieFactura;
	}
	/**
	 * necesar pentru inregistrarea in contabilitate
	 */
	public Double getValoareTotala() {
		return valoareTotala;
	}
	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}
	
	public Factura() {
		//super();
	}
	
	public Factura(Integer nrFactura, Date dataFactura, Date dataScadenta,
			Furnizori funrizor, List<LiniiFactura> linieFactura,
			Double valoareTotala) {
		super();
		this.nrFactura = nrFactura;
		this.dataFactura = dataFactura;
		this.dataScadenta = dataScadenta;
		this.funrizor = funrizor;
		this.linieFactura = linieFactura;
		this.valoareTotala = valoareTotala;
	}
	
	public Factura(Integer nrFactura, Date dataFactura, Date dataScadenta,
			Furnizori funrizor, Double valoareTotala) {
		super();
		this.nrFactura = nrFactura;
		this.dataFactura = dataFactura;
		this.dataScadenta = dataScadenta;
		this.funrizor = funrizor;
		this.valoareTotala = valoareTotala;
	}
	
	public Factura(Integer nrFactura, Date dataFactura, Date dataScadenta, Double valoareTotala) {
		super();
		this.nrFactura = nrFactura;
		this.dataFactura = dataFactura;
		this.dataScadenta = dataScadenta;
		this.valoareTotala = valoareTotala;
	}


}

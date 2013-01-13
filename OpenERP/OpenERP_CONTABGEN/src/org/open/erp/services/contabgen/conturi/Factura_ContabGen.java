package org.open.erp.services.contabgen.conturi;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Factura_ContabGen extends Document_ContabGen{
	//in Document de la modulul NOMGEN trebuie adaugata 
		//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  inainte de clasa
	//Update (Echipa 9) - nu intotdeauna trebuie sa folosim TABLE_PER_CLASS
	//                    In cazul de fata JOINED este optim 
	@GeneratedValue
	private Integer nrFactura;   /* public din private@LAR*/
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFactura;     /* public din private@LAR*/
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataScadenta;  //data pana la care se poate plati factura
	
	
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
	
	/**
	 * necesar pentru inregistrarea in contabilitate
	 */
	public Double getValoareTotala() {
		return valoareTotala;
	}
	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}
	
	public Factura_ContabGen() {
		//super();
	}
	
	
	public Factura_ContabGen(Integer nrFactura, Date dataFactura, Date dataScadenta, Double valoareTotala) {
		super();
		this.nrFactura = nrFactura;
		this.dataFactura = dataFactura;
		this.dataScadenta = dataScadenta;
		this.valoareTotala = valoareTotala;
	}


}


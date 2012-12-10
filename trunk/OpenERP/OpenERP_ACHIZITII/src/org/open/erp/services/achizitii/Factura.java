
/*factura achizitii */

package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.open.erp.services.finplati.Plata;


public class Factura extends Document{
	public Integer nrFactura;   /* public din private@LAR*/
	public Date dataFactura;     /* public din private@LAR*/
	private Date dataScadenta;  //data pana la care se poate plati factura
	private Furnizori funrizor;
	private List<LiniiFactura> linieFactura;
	public Double valoareTotala; /* public din private@LAR*/
	//Integer NrFactura;
	String numeFurnizor; /* adaugat@LAR*/
	Map<Integer, Plata> plati; /* adaugat@LAR*/
	
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
	
/*	public Factura() {
		super();
	}*/
/* adaugat@LAR -----------------------------------------*/
	public Factura() {
		if (plati == null)
			plati = new HashMap<Integer, Plata>();
	}
	
	public void setNumeFurnizor(String numeFurnizor) {
		this.numeFurnizor = numeFurnizor;
	}
	public String getNumeFurnizor() {
		return this.numeFurnizor;
	}
	public void setValoareTotal(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}

	public Double getValoareAchitata() {
		Double sumTotal = 0.0;
		Iterator<Entry<Integer,Plata>> plataIter = plati.entrySet().iterator();
		
		while (plataIter.hasNext()) {
			Plata p = plataIter.next().getValue();
			sumTotal += p.getValoarePlata();
		}
		return sumTotal;
	}
	
	public Integer getNrTranse() {
		return this.plati.size();
	}
	
	public void addPlata(Plata plata) {
		plati.put(plata.getId(), plata);
	}
	/* adaugat@LAR -----------------------------------------*/
}

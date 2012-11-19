/**
 * 
 */
package org.open.erp.services.finplati;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author paraschivgeanina
 *
 */
public class Factura implements Serializable {

	Integer idFactura;
	Date dataFactura;
	String numeFurnizor;
	Double valoareTotala;
	Map<Integer, Plata> plati;
	
	public Factura() {
		if (plati == null)
			plati = new HashMap<Integer, Plata>();
	}
	
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public Integer getIdFactura() {
		return this.idFactura;
	}
	public void setDataFactura(Date dataFactura) {
		this.dataFactura = dataFactura;
	}
	public Date getDataFactura() {
		return this.dataFactura;
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
	public Double getValoareTotala() {
		return this.valoareTotala;
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
}

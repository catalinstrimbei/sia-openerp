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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import org.open.erp.services.achizitii.Factura;



/**
 * @author paraschivgeanina
 *
 */
@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
 public class FacturaStatus implements Serializable{
//public class FacturaStatus extends Factura implements Serializable{
	@Id @GeneratedValue
	//Factura factura;
	private Integer NrFactura;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataFactura;
	
	private String numeFurnizor;
	
	Double valoareTotala;
	
	@ManyToMany
	Map<Integer, Plata> plati;
	
	//exemplu pt mapare
	
	//@OneToMany(mappedBy="department")
 //   private Set<Student> students = new HashSet<Student>(
	
	
	//public FacturaStatus getFacturaStatus() {
		//return FacturaStatus;
	//}
	//public void setFacturaStatus(Factura factura) {
		//this.FacturaStatus = factura;
	//}
	
	public FacturaStatus() {
		if (plati == null)
			plati = new HashMap<Integer, Plata>();
	}
	
	public void setIdFactura(Integer idFactura) {
		this.NrFactura = idFactura;
	}
	public Integer getNrFactura() {
		return this.NrFactura;
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
	public void setValoareTotala(Double valoareTotala) {
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


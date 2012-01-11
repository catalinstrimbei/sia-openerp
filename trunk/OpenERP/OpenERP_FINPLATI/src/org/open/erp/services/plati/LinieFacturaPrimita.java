package org.open.erp.services.plati;

/**
 * 
 * @author Echipa FINPLATI
 * 
 * @BusinessObject(Entity)
 * 
 */

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Produs;

@Entity(name = "LinieFacturaPrimita")
@DiscriminatorValue("LinieFacturaPrimita")
public class LinieFacturaPrimita extends LinieDocument implements Serializable{
	@Id
	Integer idLinieFactura;
	@ManyToOne
	Produs produs;
	Double pretUnitar;
	Double pretLinie;
	Double cantitateFacturata;
	Double tvaLinie;
	
	public LinieFacturaPrimita(){
		super();
	}
	
	/*public LinieFacturaPrimita(Produs _produs, Double _cant){
		super();
		this.material= getMaterial();
		this.cantitate = _cant;
	}*/

	public Double getPretLinie() {
		return pretLinie;
	}

	public void setPretLinie(Double pretLinie) {
		this.pretLinie = pretLinie;
	}

	public Integer getIdLinieFactura() {
		return idLinieFactura;
	}

	public void setIdLinieFactura(Integer idLinieFactura) {
		this.idLinieFactura = idLinieFactura;
	}

	public Produs getProdus() {
		return produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}

	public Double getPretUnitar() {
		return pretUnitar;
	}

	public void setPretUnitar(Double pretUnitar) {
		this.pretUnitar = pretUnitar;
	}

	public Double getCantitateFacturata() {
		return cantitateFacturata;
	}

	public void setCantitateFacturata(Double cantitateFacturata) {
		this.cantitateFacturata = cantitateFacturata;
	}

	public Double getTvaLinie() {
		return tvaLinie;
	}

	public void setTvaLinie(Double tvaLinie) {
		this.tvaLinie = tvaLinie;
	}
	
}
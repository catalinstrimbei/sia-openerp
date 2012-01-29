package org.open.erp.services.achizitii;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import static javax.persistence.CascadeType.ALL;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@Entity
public class NIR extends Document implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5673330387759089744L;
	@OneToOne(cascade = ALL)@JoinColumn(name="idFactura")
	private Factura factura;

	public NIR() {
		super();
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
		factura.setStatus(Factura.INREGISTRATA);		
	}

	public void addLinieNIR(LinieDocument li) {
        this.getLiniiDocument().add(li);
        li.setDocument(this);
    }

	public void removeLinieNIR(LinieDocument li) {
        this.getLiniiDocument().remove(li);
        li.setDocument(this);
    }
}

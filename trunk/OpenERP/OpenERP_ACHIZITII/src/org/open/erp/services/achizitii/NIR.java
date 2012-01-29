package org.open.erp.services.achizitii;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Persoana;

import static javax.persistence.CascadeType.ALL;

/**
 * 
 * @author echipa.achizitii
 * 
 * @BusinessObject(Entity)
 * 
 */
@javax.persistence.Entity
@AttributeOverride(name = "nrDocument", column = @Column(table = "NIR", name = "idNIR"))
public class NIR extends Document implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5673330387759089744L;
	@OneToOne/*(cascade = ALL)*/@JoinColumn(name="idFactura")
	private Factura factura;
	private Integer test;

	public NIR() {
		super();
	}

	public Integer getTest() {
		return test;
	}

	public void setTest(Integer test) {
		this.test = test;
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

	public NIR(Integer nrDocument, Date dataDocument ) {
		super(nrDocument, dataDocument);
		this.test=1;
	}
	
}

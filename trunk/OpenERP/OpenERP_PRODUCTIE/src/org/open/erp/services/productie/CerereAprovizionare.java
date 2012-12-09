package org.open.erp.services.productie;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Persoana;

public class CerereAprovizionare extends Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date dataCerere;
	
	public Date getDataCerere() {
		return dataCerere;
	}
	public void setDataCerere(Date dataCerere) {
		this.dataCerere = dataCerere;
	}
	
	public CerereAprovizionare(int nrDocument, Date dataDocument,
			Persoana persoana, String observatie,
			List<LinieDocument> liniiDocument, Date dataCerere) {
		super(nrDocument, dataDocument, persoana, observatie, liniiDocument);
		this.dataCerere = dataCerere;
	}
	
	public CerereAprovizionare() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CerereAprovizionare(int nrDocument, Date dataDocument,
			Persoana persoana, String observatie,
			List<LinieDocument> liniiDocument) {
		super(nrDocument, dataDocument, persoana, observatie, liniiDocument);
		// TODO Auto-generated constructor stub
	}
	
	
}

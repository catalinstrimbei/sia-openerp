package org.open.erp.services.plati;

import java.util.Date;

import org.open.erp.services.nomgen.PersoanaJuridica;

public class DocumentPlata {
	private Integer idDocumentPlata;

	public DocumentPlata(Integer idDocumentPlata){
		this.idDocumentPlata = idDocumentPlata;
	}
	
	public Integer getIdDocumentPlata() {
		return idDocumentPlata;
	}

	public void setIdDocumentPlata(Integer idDocumentPlata) {
		this.idDocumentPlata = idDocumentPlata;
	}
}

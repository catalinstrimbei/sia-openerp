package org.open.erp.services.plati;

import java.util.Calendar;


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
	public boolean efectPlata(Double totplata){
		return true;
	}

	public Double getTotalPlata() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getSeriaNr() {
		// TODO Auto-generated method stub
		return null;
	}

	public Calendar getFacturi() {
		// TODO Auto-generated method stub
		return null;
	}
}

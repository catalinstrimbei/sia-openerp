package org.open.erp.services.nomgen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentComercial {
	protected Integer nrDoc;
	protected Date dataDoc;
	protected List<Linie> liniiDocument;
	protected Double totalFact;

	public DocumentComercial(Integer nrDoc, Date dataDoc) {
		super();
		this.liniiDocument = new ArrayList<Linie>();
		this.nrDoc = nrDoc;
		this.dataDoc = dataDoc;
	}

	@Override
	public String toString() {
		return "Document [nrDoc=" + nrDoc + ", dataDoc=" + dataDoc;
	}
	
	public void printAll(){
		for(int i=0;i<liniiDocument.size();i++){
			System.out.println(liniiDocument.get(i).toString());
		}
		System.out.println("Total: "+this.totalFact);
	}

	public Double getTotalFact() {
		return totalFact;
	}
	
}

package org.open.erp.services.nomgen;



//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Document {
	protected Integer nrDoc;
	protected Date dataDoc;
	protected List<LinieDocument> liniiDocument= new ArrayList<LinieDocument>();
	protected String DocDetaliu;
	
	
	public String getDocDetaliu() {
		return DocDetaliu;
	}
	public void setDocDetaliu(String docDetaliu) {
		DocDetaliu = docDetaliu;
	}
	public Integer getNrDoc() {
		return nrDoc;
	}
	public void setNrDoc(Integer nrDoc) {
		this.nrDoc = nrDoc;
	}
	public Date getDataDoc() {
		return dataDoc;
	}
	public void setDataDoc(Date dataDoc) {
		this.dataDoc = dataDoc;
	}
	public List<LinieDocument> getLiniiDocument() {
		return liniiDocument;
	}
	public void setLiniiDocument(List<LinieDocument> liniiDocument) {
		this.liniiDocument = liniiDocument;
	}
	
	
	public void addLinie(LinieDocument linie){
		this.liniiDocument.add(linie);
	}
	public void removeLinie(LinieDocument linie){
		this.liniiDocument.remove(linie);
	}
	
	
	public Document() {
		super();
	}



	public Document(Integer nrDoc, Date dataDoc) {
		super();
		this.nrDoc = nrDoc;
		this.dataDoc = dataDoc;
	}



	public Document(Integer nrDoc, Date dataDoc,
			List<LinieDocument> liniiDocument) {
		super();
		this.nrDoc = nrDoc;
		this.dataDoc = dataDoc;
		this.liniiDocument = liniiDocument;
	}

	
	
	
	
}

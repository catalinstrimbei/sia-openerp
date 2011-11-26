package org.open.erp.services.nomgen;

import java.util.ArrayList;
import java.util.List;

public class RegDocumente {
	private static RegDocumente singleReference;

	private RegDocumente() {
		documente = new ArrayList <DocumentComercial>();
	}

	public static RegDocumente instantiaza() {
		if (singleReference == null)
			singleReference = new RegDocumente();
		return singleReference;
	}

	private List<DocumentComercial> documente;
	
	//--------------------------------------------------------
	public List<DocumentComercial> getDocumente() {
		return documente;
	}

	public void addDocument(DocumentComercial doc) {
		if (!documente.contains(doc)) {
			documente.add(doc);
		}
	}

	public void removeDocument(DocumentComercial doc) {
		documente.remove(doc);
	}

	public DocumentComercial getDocumentDupa(Integer nrDoc) {
		for (DocumentComercial t : documente) {
			if (nrDoc == t.nrDoc) {
				return t;
			}
		}
		return null;
	}
	
	//TODO: remove me
	public void printAll(){
		for(int i=0;i<documente.size();i++){
			System.out.println(documente.get(i).toString());
			documente.get(i).printAll();
		}
	}
}

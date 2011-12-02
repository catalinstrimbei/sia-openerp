package org.open.erp.services.achizitii;

import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;

public class NIR extends Document {
	public Factura factura;

	public void addLinieNIR(LinieDocument li) {
        this.getLiniiDocument().add(li);
        li.setDocument(this);
    }

	public void removeLinieNIR(LinieDocument li) {
        this.getLiniiDocument().remove(li);
        li.setDocument(this);
    }
}

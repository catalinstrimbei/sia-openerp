package dummy;

import java.util.Date;

import org.open.erp.services.nomgen.DocumentComercial;

public class Factura extends DocumentComercial{
	
	String nrFact;
	Integer idPartener;
	Integer tipFact;

	public void adaugaLinie(LinieFactura linie){
		super.liniiDocument.add(linie);
		this.totalFact=this.totalFact+linie.valoare*linie.cantitate;
	}

	public Factura(Integer nrDoc, Date dataDoc, String nrFact, Integer idPartener, Integer tipFact) {
		super(nrDoc, dataDoc);
		this.totalFact=0.0;
		this.nrFact = nrFact;
		this.idPartener = idPartener;
		this.tipFact = tipFact;
	}	 
	 
}

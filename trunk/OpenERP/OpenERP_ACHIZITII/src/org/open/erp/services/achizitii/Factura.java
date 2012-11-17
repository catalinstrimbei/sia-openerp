package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Furnizori;

public class Factura {
	private Integer nrFactura;
	private Date dataFactura;
	private Date dataScadenta;  //data pana la care se poate plati factura
	private Furnizori funrizor;
	private List<LiniiFactura> linieFactura;
	private Double valoareTotala;

}

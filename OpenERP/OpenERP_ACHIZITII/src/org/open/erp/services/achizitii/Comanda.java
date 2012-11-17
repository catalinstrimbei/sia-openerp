package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Furnizori;

public class Comanda {
	private Integer nrComanda;
	private Date dataComanda;
	private Date dataReceptionare; //cand vrem noi sa primim bunurile
	private Furnizori funrizor;
	private List<LiniiComanda> linieComanda;
	private Double valoareTotala;

}

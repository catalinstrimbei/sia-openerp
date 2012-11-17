package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Furnizori;

public class Oferta {
	private Integer nrOferta;
	private Date dataOferta;
	private Date dataLivrare; //cand poate furnizorul sa ne livreze bunurile
	private Furnizori funrizor;
	private List<LiniiOferta> linieOferta;
	private Double valoareTotala;
}

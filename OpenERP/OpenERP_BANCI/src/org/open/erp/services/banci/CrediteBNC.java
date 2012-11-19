package org.open.erp.services.banci;

import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Clienti;

public class CrediteBNC {
	private Integer contCredit;
	private Date datascandentaprimarata;
	private Date datascadentaultimarata;
	private Date datascadentalunacurenta;
	private Date datasemcontr; //cand se semeneaza contractul cu banca
	private Clienti client;
	private List<LiniiPlatirate> liniePlatarata;
	private Double valoarecredit;
	private Double ratadob;
	
	public Integer getcontCredit() {
		return contCredit;
	}
	public void setcontCredit(Integer contCredit) {
		this.contCredit = contCredit;
	}
	public Date getDatascadentaprimarata() {
		return  datascandentaprimarata;
	}
	public void setDatascadentaprimarata(Date datascadentaprimarata) {
		this.datascandentaprimarata = datascandentaprimarata;
	}
	public Date getDatascadentaultimarata() {
		return  datascandentaprimarata;
	}
	public void setDatascadentaultimarata(Date datascadentaultimarata) {
		this.datascadentaultimarata = datascadentaultimarata;
	}
	public Date getDatascadentalunacurenta() {
		return  datascadentalunacurenta;
	}
	public void setDatascadentalunacurenta(Date datascadentalunacurenta) {
		this.datascadentalunacurenta = datascadentalunacurenta;
	}		
	public Date getDatasemcontr() {
		return  datasemcontr;
	}
	public void setdatasemcontr(Date datasemcontr) {
		this.datasemcontr = datasemcontr;
	}			
		
	public Clienti getClient() {
		return client;
	}
	public void setClient(Clienti client) {
		this.client = client;
	}				
	
	public List<LiniiPlatirate> getliniePlatarata() {
		return liniePlatarata;
	}
	public void setliniePlatarata(List<LiniiPlatirate> liniePlatarata) {
		this.liniePlatarata = liniePlatarata;
	}
	
	public Double getValoarecredit() {
		return valoarecredit;
	}
	public void setValoarecredit(Double valoarecredit) {
		this.valoarecredit = valoarecredit;
	}
	public Double getRatadob() {
		return ratadob;
	}
	public void setRatadob(Double ratadob) {
		this.ratadob = ratadob;
	}
	
	public CrediteBNC(Integer contCredit, Date datascandentaprimarata, Date datascadentaultimarata,Date datascadentalunacurenta,
			Date datasemcontr, Clienti client,List<LiniiPlatirate> liniePlatarata,Double valoarecredit,Double ratadob) {
		super();
		this.contCredit = contCredit;
		this.datascandentaprimarata = datascandentaprimarata;
		this.datascadentaultimarata = datascadentaultimarata;
		this.datascadentalunacurenta = datascadentalunacurenta;
		this.datasemcontr = datasemcontr;
		this.client = client;
		this.liniePlatarata = liniePlatarata;
		this.valoarecredit = valoarecredit;
		this.ratadob = ratadob;
	}
	
	public CrediteBNC() {
		super();
	}

	
	
}
		
	
	
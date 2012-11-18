package org.open.erp.services.banci;




import java.util.Date;
import java.util.List;

import org.open.erp.services.achizitii.LiniiComanda;
import org.open.erp.services.nomgen.Clienti;

public class CrediteBNC<LiniiPlatirate> {
	private Integer CodCredit;
	private Date datascandentaprimarata;
	private Date datascadentaultimarata;
	private Date datascadentalunacurenta;
	private Date datasemcontr; //cand se semeneaza contractul cu banca
	private Clienti client;
	private List<LiniiPlatirate> liniePlatarata;
	private Double Valoarecredit;
	private Double Ratadob;
	public Integer getcodCredit() {
		return CodCredit;
	}
	public void setcodCredit(Integer codCredit) {
		this.CodCredit = codCredit;
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
	
	
		
		
		
		
		
	
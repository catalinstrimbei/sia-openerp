package org.open.erp.services.nomgen;


import java.util.Date;
import java.util.List;


public class Clienti {
	private Integer numepren;
	private Integer CNP;
	private Integer conturi;
	private Integer nrtel;
	private Integer email;
    private Date dataprimcontactbanca;
    
    public Integer getNumepren() {
		return numepren;
	}
	public void setNumepren(Integer numepren) {
		this.numepren = numepren;
	}
	
	public Integer getCNP() {
		return CNP;
	}
	public void setCNP(Integer CNP) {
		this.CNP = CNP;
	}
	public Integer getConturi() {
		return conturi;
	}
	public void setConturi(Integer conturi) {
		this.conturi = conturi;
	}
	
	public Integer getNrtel() {
		return nrtel;
	}
	public void setNrtel(Integer nrtel) {
		this.nrtel = nrtel;
	}
	public Integer getEmail() {
		return email;
	}
	public void setEmail(Integer email) {
		this.email = email;	
	}

	public Date getdataprimcontactbanca() {
		return dataprimcontactbanca;
	}
	public void setdataprimcontactbanca(Date dataprimcontactbanca) {
		this.dataprimcontactbanca = dataprimcontactbanca;
	}
	
	public Clienti(Integer numepren,Integer CNP,Integer conturi,Integer nrtel,Integer email,Date dataprimcontactbanca) {
		super();
		this.numepren = numepren;
		this.CNP = CNP;
		this.conturi = conturi;
		this.nrtel = nrtel;
		this.email = email;	
		this.dataprimcontactbanca = dataprimcontactbanca;
	}
	
	public Clienti() {
		super();
	}
	
}
		
	


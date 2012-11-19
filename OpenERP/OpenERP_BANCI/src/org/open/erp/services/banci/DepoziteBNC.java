package org.open.erp.services.banci;


import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Clienti;

public class DepoziteBNC {
	private Integer contDepozit;
	private Date dataprimeidepuneri;
	private Date dataultimeidepuneri;
	private Date datadepuneriicurente;
	private Date datasemcontrdep; //cand se semeneaza contractul cu banca
	private Clienti client;
	private List<LiniiDepuneri> linieDepunere;
	private Double valoaredepozit;
	private Double ratadobdep;
	
	public Integer getContDepozit() {
		return contDepozit;
	}
	public void setContDepozit(Integer contDepozit) {
		this.contDepozit = contDepozit;
	}
	public Date getDataprimeidepuneri() {
		return  dataprimeidepuneri;
	}
	public void setDataprimeidepuneri(Date dataprimeidepuneri) {
		this.dataprimeidepuneri = dataprimeidepuneri;
	}
	public Date getDataultimeidepuneri() {
		return  dataultimeidepuneri;
	}
	public void setDataultimeidepuneri(Date dataultimeidepuneri) {
		this.dataultimeidepuneri = dataultimeidepuneri;
	}
	public Date getDatadepuneriicurente() {
		return  datadepuneriicurente;
	}
	public void setDatadepuneriicurente(Date datadepuneriicurente) {
		this.datadepuneriicurente = datadepuneriicurente;
	}		
	public Date getDatasemcontrdep() {
		return  datasemcontrdep;
	}
	public void setDatasemcontrdep(Date datasemcontrdep) {
		this.datasemcontrdep = datasemcontrdep;
	}			
		
	public Clienti getClient() {
		return client;
	}
	public void setClient(Clienti client) {
		this.client = client;
	}				
	
	public List<LiniiDepuneri> getlinieDepunere() {
		return linieDepunere;
	}
	public void setlinieDepunere( List<LiniiDepuneri> linieDepunere) {
		this.linieDepunere = linieDepunere;
	}
	
	public Double getValoaredepozit() {
		return valoaredepozit;
	}
	public void setValoaredepozit(Double valoaredepozit) {
		this.valoaredepozit = valoaredepozit;
	}
	public Double getRatadobdep() {
		return ratadobdep;
	}
	public void setRatadobdep(Double ratadobdep) {
		this.ratadobdep = ratadobdep;
	}
	
	public DepoziteBNC(Integer contDepozit, Date dataprimeidepuneri, Date dataultimeidepuneri,Date datadepuneriicurente,
			Date datasemcontrdep, Clienti client,List<LiniiDepuneri> linieDepunere, Double valoaredepozit,Double ratadobdep) {
		super();
		this.contDepozit = contDepozit;
		this.dataprimeidepuneri = dataprimeidepuneri;
		this.dataultimeidepuneri = dataultimeidepuneri;
		this.datadepuneriicurente = datadepuneriicurente;
		this.datasemcontrdep = datasemcontrdep;
		this.client = client;
		this.linieDepunere = linieDepunere;
		this.valoaredepozit = valoaredepozit;
		this.ratadobdep = ratadobdep;
	}
	
	public DepoziteBNC() {
		super();
	}

	
	
}
		
	




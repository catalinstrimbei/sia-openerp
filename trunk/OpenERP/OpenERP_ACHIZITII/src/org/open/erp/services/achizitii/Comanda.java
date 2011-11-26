package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Comanda {
	public static final Integer APROBATA = 1;
	public static final Integer RESPINSA = -1;
	public static final Integer IN_CURS = 0;
	public Integer idComanda;
	public Furnizor furnizor;
	public Date dataComanda;
	public Integer statusComanda;
	public List<LinieComanda> liniiComanda=new LinkedList<LinieComanda>();
	public Integer getIdComanda() {
		return idComanda;
	}
	 public void addLinii(LinieComanda li) {
	        this.getLiniiComanda().add(li);
	        //li.setInchirieri(this);
	    }
	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}
	public Date getDataComanda() {
		return dataComanda;
	}
	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
	}
	public Integer getStatusComanda() {
		return statusComanda;
	}
	public void setStatusComanda(Integer statusComanda) {
		this.statusComanda = statusComanda;
	}
	public Comanda(Integer idComanda, Date dataComanda, Integer statusComanda) {
		super();
		this.idComanda = idComanda;
		this.dataComanda = dataComanda;
		this.statusComanda = statusComanda;
	}
	public List<LinieComanda> getLiniiComanda() {
		return liniiComanda;
	}
	public void setLiniiComanda(List<LinieComanda> liniiComanda) {
		this.liniiComanda = liniiComanda;
	}
	public Comanda(Integer idComanda, Furnizor furnizor, Date dataComanda,
			Integer statusComanda) {
		super();
		this.idComanda = idComanda;
		this.furnizor = furnizor;
		this.dataComanda = dataComanda;
		this.statusComanda = statusComanda;
	}
	
	
	
	
}

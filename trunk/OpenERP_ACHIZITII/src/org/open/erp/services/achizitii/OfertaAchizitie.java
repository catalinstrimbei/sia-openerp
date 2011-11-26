package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class OfertaAchizitie {
	public static final Integer APROBATA = 1;
	public static final Integer RESPINSA = -1;
	public static final Integer IN_CURS = 0;
	public Integer idOferta;
	public Date dataOferta;	
	public Integer statusOferta;
	public Furnizor furnizor;
	public List<LinieCerereOferta> liniiCerereOferta = new LinkedList<LinieCerereOferta>();
	public OfertaAchizitie(Integer idOferta, Date dataOferta,
			Integer statusOferta, Furnizor furnizor,
			List<LinieCerereOferta> liniiCerereOferta) {
		super();
		this.idOferta = idOferta;
		this.dataOferta = dataOferta;
		this.statusOferta = statusOferta;
		this.furnizor = furnizor;
		this.liniiCerereOferta = liniiCerereOferta;
	}
	public Integer getIdOferta() {
		return idOferta;
	}
	public void setIdOferta(Integer idOferta) {
		this.idOferta = idOferta;
	}
	public Date getDataOferta() {
		return dataOferta;
	}
	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}
	public Integer getStatusOferta() {
		return statusOferta;
	}
	public void setStatusOferta(Integer statusOferta) {
		this.statusOferta = statusOferta;
	}
	public Furnizor getFurnizor() {
		return furnizor;
	}
	public void setFurnizor(Furnizor furnizor) {
		this.furnizor = furnizor;
	}
	public List<LinieCerereOferta> getLiniiCerereOferta() {
		return liniiCerereOferta;
	}
	public void setLiniiCerereOferta(List<LinieCerereOferta> liniiCerereOferta) {
		this.liniiCerereOferta = liniiCerereOferta;
	}
	
}

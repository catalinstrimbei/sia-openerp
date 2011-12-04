package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.open.erp.services.nomgen.LinieDocument;

public class OfertaAchizitie {
	public static final Integer TRANSFORMATA = 1;
	public static final Integer RESPINSA = -1;
	public static final Integer IN_CURS = 0;
	private Integer idOferta;
	private Date dataOferta;	
	private Integer statusOferta;
	private Furnizor furnizor;
	private Double valTotal;
	private Integer nrZile;
	private CerereOferta cerereOferta;
	private List<LinieOfertaAchizitie> liniiOferta = new LinkedList<LinieOfertaAchizitie>();
	
	public Double getValTotal() {
		return valTotal;
	}
	public void setValTotal(Double valTotal) {
		this.valTotal = valTotal;
	}
	public Integer getNrZile() {
		return nrZile;
	}
	public void setNrZile(Integer nrZile) {
		this.nrZile = nrZile;
	}
	public CerereOferta getCerereOferta() {
		return cerereOferta;
	}
	public void setCerereOferta(CerereOferta cerereOferta) {
		this.cerereOferta = cerereOferta;
	}
	public OfertaAchizitie(Date dataOferta, Integer statusOferta,
			Furnizor furnizor, List<LinieOfertaAchizitie> liniiOferta) {
		super();
		this.dataOferta = dataOferta;
		this.statusOferta = statusOferta;
		this.furnizor = furnizor;
		this.liniiOferta = liniiOferta;
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
	
	public List<LinieOfertaAchizitie> getLiniiOferta() {
		return liniiOferta;
	}
	public void setLiniiOferta(List<LinieOfertaAchizitie> liniiOferta) {
		this.liniiOferta = liniiOferta;
	}
	public void addLinieOfertaAchizitie(LinieOfertaAchizitie li) {
        this.getLiniiOferta().add(li);
        li.setOferta(this);
    }

	public void removeLinieOfertaAchizitie(LinieOfertaAchizitie li) {
        this.getLiniiOferta().remove(li);
        li.setOferta(this);
    }
	
}

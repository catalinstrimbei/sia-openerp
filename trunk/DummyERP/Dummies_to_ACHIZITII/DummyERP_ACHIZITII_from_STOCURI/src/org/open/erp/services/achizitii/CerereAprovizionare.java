package org.open.erp.services.achizitii;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
 * 
 * @BusinessObject(DummyEntity)
 * 
 */
public class CerereAprovizionare {
	private Integer idCerere;
	private String nrCerere;
	private Date dataCerere;
	private String obs;
	
	private List<LinieCerereAprovizionare> liniiAprov = new ArrayList<LinieCerereAprovizionare>();

	
	public void addlinie(LinieCerereAprovizionare l){
		this.liniiAprov.add(l);
	}
	
	public void removelinie(LinieCerereAprovizionare l){
		this.liniiAprov.remove(l);
	}
	
	public CerereAprovizionare() {
		super();
	}

	public CerereAprovizionare(Integer idCerere, String nrCerere,
			Date dataCerere, String obs) {
		super();
		this.idCerere = idCerere;
		this.nrCerere = nrCerere;
		this.dataCerere = dataCerere;
		this.obs = obs;
	}

	public Integer getIdCerere() {
		return idCerere;
	}

	public void setIdCerere(Integer idCerere) {
		this.idCerere = idCerere;
	}

	public String getNrCerere() {
		return nrCerere;
	}

	public void setNrCerere(String nrCerere) {
		this.nrCerere = nrCerere;
	}

	public Date getDataCerere() {
		return dataCerere;
	}

	public void setDataCerere(Date dataCerere) {
		this.dataCerere = dataCerere;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<LinieCerereAprovizionare> getLiniiAprov() {
		return liniiAprov;
	}

	public void setLiniiAprov(List<LinieCerereAprovizionare> liniiAprov) {
		this.liniiAprov = liniiAprov;
	}
	
	
	

}

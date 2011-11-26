package org.open.erp.services.stocuri;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CerereAprovizionare {
	public static final Integer APROBATA = 1;
	public static final Integer RESPINSA = -1;
	public static final Integer IN_CURS = 0;
	public Integer idCerere;
	public Date data;
	public String departament;
	public Integer statusCerereAprovizionare;
	
	public List<LinieCerereAprovizionare> linii= new LinkedList<LinieCerereAprovizionare>();
	public Integer getIdCerere() {
		return idCerere;
	}
	public Integer getStatusCerereAprovizionare() {
		return statusCerereAprovizionare;
	}
	public void setStatusCerereAprovizionare(Integer statusCerereAprovizionare) {
		this.statusCerereAprovizionare = statusCerereAprovizionare;
	}
	public void setIdCerere(Integer idCerere) {
		this.idCerere = idCerere;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDepartament() {
		return departament;
	}
	public void setDepartament(String departament) {
		this.departament = departament;
	}
	public List<LinieCerereAprovizionare> getLinii() {
		return linii;
	}
	public void setLinii(List<LinieCerereAprovizionare> linii) {
		this.linii = linii;
	}
	public CerereAprovizionare(Integer idCerere, Date data, String departament,
			Integer statusCerereAprovizionare) {
		super();
		this.idCerere = idCerere;
		this.data = data;
		this.departament = departament;
		this.statusCerereAprovizionare = statusCerereAprovizionare;
		
	}
	
}

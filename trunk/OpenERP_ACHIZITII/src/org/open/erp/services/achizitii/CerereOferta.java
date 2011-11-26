package org.open.erp.services.achizitii;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CerereOferta {

public static final Integer APROBATA = 1;
public static final Integer RESPINSA = -1;
public static final Integer IN_CURS = 0;
public Integer idCerereOferta;
public Date dataCerere;
public Integer statusCerereOferta;

public Integer getStatusCerereOferta() {
	return statusCerereOferta;
}

public void setStatusCerereOferta(Integer statusCerereOferta) {
	this.statusCerereOferta = statusCerereOferta;
}

public List<LinieCerereOferta> linii= new LinkedList<LinieCerereOferta>();

public Integer getIdCerereOferta() {
	return idCerereOferta;
}

public void setIdCerereOferta(Integer idCerereOferta) {
	this.idCerereOferta = idCerereOferta;
}

public Date getDataCerere() {
	return dataCerere;
}

public void setDataCerere(Date dataCerere) {
	this.dataCerere = dataCerere;
}


public List<LinieCerereOferta> getLinii() {
	return linii;
}

public void setLinii(List<LinieCerereOferta> linii) {
	this.linii = linii;
}

public CerereOferta(Integer idCerereOferta, Date dataCerere, String categorie,
		Integer statusCerereOferta, List<LinieCerereOferta> linii) {
	super();
	this.idCerereOferta = idCerereOferta;
	this.dataCerere = dataCerere;	
	this.statusCerereOferta = statusCerereOferta;
	this.linii = linii;
}




}

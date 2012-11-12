package org.open.erp.services.proman;

import java.util.Date;

/**
 * 
 * @author catalin.strimbei
 * 
 * @BusinessObject(Interface)
 * 
 */
public interface Activitate {

	public static final Integer NE_PORNITA = -1;
	public static final Integer IN_CURS = 1;
	public static final Integer TERMINAT = 2;

	public abstract Double getProcentRealizare();

	public abstract void setProcentRealizare(Double procentRealizare);

	public abstract Date getDataActualizare();

	public abstract void setDataActualizare(Date dataActualizare);

	public abstract Proiect getProiect();

	public abstract void setProiect(Proiect proiect);

	public abstract Integer getIdActivitate();

	public abstract void setIdActivitate(Integer idActivitate);

	public abstract String getTitulatura();

	public abstract void setTitulatura(String titulatura);

	public abstract Date getDataStart();

	public abstract void setDataStart(Date dataStart);

	public abstract Date getDataSfarsit();

	public abstract void setDataSfarsit(Date dataSfarsit);

	public abstract Double getValoareBugetata();

	public abstract void setValoareBugetata(Double valoareBugetata);

	public abstract Integer getStatus();

	public abstract void setStatus(Integer status);

	public abstract Responsabil getResponsabil();

	public abstract void setResponsabil(Responsabil responsabil);

}
package org.open.erp.services.contabgest;


import java.util.Date;



public interface Activitate {

		public static final Integer NE_PORNITA = -1;
		public static final Integer IN_CURS = 1;
		public static final Integer TERMINAT = 2;

		public abstract Double getProcentRealizare();

		public abstract void setProcentRealizare(Double procentRealizare);

		public abstract Date getDataActualizare();

		public abstract void setDataActualizare(Date dataActualizare);

		public abstract CentruCost getCentruCost();

		public abstract void setCentruCost(CentruCost centruCost);

		public abstract Integer getIdActivitate();

		public abstract void setIdActivitate(Integer idActivitate);

		public abstract String getDenumire();

		public abstract void setDenumire(String denumire);

		public abstract Date getDataStart();

		public abstract void setDataStart(Date dataStart);

		public abstract Date getDataSfarsit();

		public abstract void setDataSfarsit(Date dataSfarsit);

		public abstract Double getCostActivitate();

		public abstract void setCostActivitate(Double costActivitate);

		public abstract Integer getStatus();

		public abstract void setStatus(Integer status);

		public abstract Responsabil getResponsabil();

		public abstract void setResponsabil(Responsabil responsabil);

	
}

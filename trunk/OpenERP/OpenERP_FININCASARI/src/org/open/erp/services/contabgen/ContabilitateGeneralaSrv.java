package org.open.erp.services.contabgen;

public interface ContabilitateGeneralaSrv {

	void jurnalizareIncasare(java.sql.Date dataInregistrarii, Double suma,
			Integer numar, TipIncasare tipIncasare, Integer idClient,
			Integer cont, String modificat, Object object);

}


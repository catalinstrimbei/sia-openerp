package org.open.erp.services.plati;

import java.util.Date;

import org.open.erp.services.nomgen.PersoanaJuridica;

public interface FinPlatiSrv {
	public Factura inregistrareFactura(String seriaNr, Date data, Double totalPlata, PersoanaJuridica furnizor, PersoanaJuridica client);
	public boolean efectPlata(Double totplata);
	}

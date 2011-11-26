package org.open.erp.services.finplati;

import java.util.Date;

import org.open.erp.services.nomgen.Partener;

public interface FinplatiSrv {
	public int acceptaPlataFurnizor(Partener partener,Double valoare, Date data);

}

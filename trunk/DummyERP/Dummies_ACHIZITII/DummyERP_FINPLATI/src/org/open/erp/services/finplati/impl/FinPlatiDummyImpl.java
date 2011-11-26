package org.open.erp.services.finplati.impl;

import java.util.Date;

import org.open.erp.services.finplati.FinplatiSrv;
import org.open.erp.services.nomgen.Partener;

public class FinPlatiDummyImpl implements FinplatiSrv{
	public int acceptaPlataFurnizor(Partener partener,Double valoare, Date data){
		return 1;		
	};

}

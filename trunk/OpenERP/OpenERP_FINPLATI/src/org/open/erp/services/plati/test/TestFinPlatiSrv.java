package org.open.erp.services.plati.test;

import org.open.erp.services.plati.DocumentPlata;
import org.open.erp.services.plati.CEC;
import org.open.erp.services.plati.OrdinPlata;
import org.open.erp.services.plati.FinPlatiSrv;


public class TestFinPlatiSrv {
	public static void main(String[] args) {
	DocumentPlata [] doc = new DocumentPlata[4];
	doc [1] = new CEC(1111, "sn1", null, 40.00, null, null, null);
	doc [2] = new CEC(1112, "sn2", null, 50.00, null, null, null);
	doc [3] = new OrdinPlata(1113, "sn3", null, 60.00, null, null, null, null, null);
	for (DocumentPlata d: doc){
		d.efectPlata(30.00);
		}
	}
}

package org.open.erp.services.ctbgen.teste;

import org.junit.Before;
import org.junit.Test;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.ctbgen.RegConturi;

public class TestCtb_RegConturi {
	RegConturi regConturi;

	@Before
	public void setUp() {
		regConturi = RegConturi.instantiaza();
	}

	@Test
	public void test_sequence() { // testare PK pt contructor
		Cont c = new Cont(301, "Materii prime", "301", "301",
				StatusSintetic.SINTETIC, TipCont.ACTIV);
		regConturi.addCont(c);
		Cont c1 = new Cont(411, "Clienti", "411", "4",
				StatusSintetic.SINTETIC, TipCont.ACTIV);
		regConturi.addCont(c1);
		Cont c2 = new Cont("Clienti", "4111", "4",
				StatusSintetic.ANALITIC, c1, TipCont.ACTIV);
		regConturi.addCont(c2);
		Cont c3 = new Cont("Clienti incerti", "4118", "4",
				StatusSintetic.ANALITIC, c1, TipCont.ACTIV);
		regConturi.addCont(c3);

		regConturi.printAll();
	}
}

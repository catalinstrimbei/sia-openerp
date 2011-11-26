package org.open.erp.services.ctbgen.teste;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.open.erp.services.ctbgen.Cont;
import org.open.erp.services.ctbgen.Cont.StatusSintetic;
import org.open.erp.services.ctbgen.Cont.TipCont;
import org.open.erp.services.ctbgen.RegConturi;
import org.open.erp.services.ctbgen.RegTipuriContabile;
import org.open.erp.services.ctbgen.TipContabil;

public class TestCtb_RegTipuriContabile {

	RegTipuriContabile regTipContabile;
	RegConturi regConturi;
	
	@Before
	public void setUp(){
		regTipContabile = RegTipuriContabile.instantiaza();
		regConturi = RegConturi.instantiaza();
	}
	
	@Test
	public void test_vizualizareListaTipuri(){ //testare vizualizare tipuri contabile
		Cont c = new Cont(341, "Semifabricate","341","341",StatusSintetic.SINTETIC,TipCont.ACTIV);
			regConturi.addCont(c);
		Cont c1 = new Cont(345, "Produse","345","345",StatusSintetic.SINTETIC,TipCont.ACTIV);
			regConturi.addCont(c);
		
		TipContabil t1 = new TipContabil("Semifabricat", c, null, null);
		regTipContabile.addTipContabil(t1);
		TipContabil t2 = new TipContabil("Produse", c1, null, null);
		regTipContabile.addTipContabil(t2);
		
		//regTipContabile.printAll();
		List<String>tipuri=regTipContabile.getTipuriContabile();
		
		for (int i = 0;i<tipuri.size();i++){
			System.out.println(tipuri.get(i));
		}
	}
}

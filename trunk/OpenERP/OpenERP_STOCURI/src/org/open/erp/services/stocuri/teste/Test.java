package org.open.erp.services.stocuri.teste;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.open.erp.services.nomenclatoare.MaterialPrim;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.ComandaMateriale;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.Linie;
import org.open.erp.services.stocuri.LoturiIntrari;
import org.open.erp.services.stocuri.impl.AplicarePret;
import org.open.erp.services.stocuri.impl.AplicarePret.METODE;
import org.open.erp.services.stocuri.impl.Procesare;
import org.open.erp.services.stocuri.util.StocuriLogger;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		Test t = new Test();
		t.metodaDeTest();
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@org.junit.Test
	public void metodaDeTest() throws Exception{
		AplicarePret apPret = new AplicarePret();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Gestiune>gestiuni = new ArrayList<Gestiune>();
		StocuriLogger logger = new StocuriLogger();
		logger.loggeazaINFO("START creare date de test------ ");
		logger.loggeazaINFO("START creare materiale ");
		//creare materiale
		MaterialPrim m1 = new MaterialPrim(1, "den mat 1", "uM", null, "30 zile");
		MaterialPrim m2 = new MaterialPrim(2, "den mat 2", "uM", null, "30 zile");
		MaterialPrim m3 = new MaterialPrim(3, "den mat 3", "uM", null, "30 zile");
		MaterialPrim m4 = new MaterialPrim(4, "den mat 3", "uM", null, "30 zile");
		MaterialPrim m5 = new MaterialPrim(5, "den mat 3", "uM", null, "30 zile");
		logger.loggeazaINFO("END creare materiale ");
		logger.loggeazaINFO("START creare gestiuni ");
		//creare gestiune
		Gestiune gst1 = new Gestiune(1, "den gest 1", new Depozit(1, "Iasi", "100 m2"));
		Gestiune gst2 = new Gestiune(2, "den gest 1", new Depozit(2, "Iasi", "100 m2"));
		
		gestiuni.add(gst1);
		gestiuni.add(gst2);
		logger.loggeazaINFO("END creare gestiuni ");
		logger.loggeazaINFO("START creare articole ");
		ArticolStoc ar0=  new ArticolStoc(1, 0, gst2, m1);
		LoturiIntrari l21 = new LoturiIntrari(1, 6, 2.2, sdf.parse("10/12/2010"), ar0);
		LoturiIntrari l22 = new LoturiIntrari(2, 7, 2.3, sdf.parse("11/12/2010"), ar0);
		LoturiIntrari l23 = new LoturiIntrari(3, 8, 2.4, sdf.parse("12/12/2010"), ar0);
		LoturiIntrari l24 = new LoturiIntrari(4, 9, 2.5, sdf.parse("13/12/2010"), ar0);
		ar0.addLotIntrare(l21);
		ar0.addLotIntrare(l22);
		ar0.addLotIntrare(l23);
		ar0.addLotIntrare(l24);
		
		
		// creare articole stoc + loturi intrari
		ArticolStoc ar1=  new ArticolStoc(1, 0, gst1, m1);
		LoturiIntrari l1 = new LoturiIntrari(1, 6, 2.2, sdf.parse("10/12/2010"), ar1);
		LoturiIntrari l2 = new LoturiIntrari(2, 7, 2.3, sdf.parse("11/12/2010"), ar1);
		LoturiIntrari l3 = new LoturiIntrari(3, 8, 2.4, sdf.parse("12/12/2010"), ar1);
		LoturiIntrari l4 = new LoturiIntrari(4, 9, 2.5, sdf.parse("13/12/2010"), ar1);
		//adaugare loturi pt articole
		ar1.addLotIntrare(l1);
		ar1.addLotIntrare(l2);
		ar1.addLotIntrare(l3);
		ar1.addLotIntrare(l4);
		//---
		ArticolStoc ar2=  new ArticolStoc(2, 0, gst1, m2);
		LoturiIntrari l5 = new LoturiIntrari(1, 6, 2.2, sdf.parse("10/02/2010"), ar2);
		LoturiIntrari l6 = new LoturiIntrari(2, 7, 2.3, sdf.parse("11/03/2010"), ar2);
		LoturiIntrari l7 = new LoturiIntrari(3, 8, 2.4, sdf.parse("12/05/2010"), ar2);
		LoturiIntrari l8 = new LoturiIntrari(4, 9, 2.5, sdf.parse("13/12/2010"), ar2);
		ar2.addLotIntrare(l6);
		ar2.addLotIntrare(l7);
		ar2.addLotIntrare(l8);
		ar2.addLotIntrare(l5);
		//--
		ArticolStoc ar3=  new ArticolStoc(3, 0, gst1, m3);
		LoturiIntrari l9 = new LoturiIntrari(1, 6, 2.2, sdf.parse("10/02/2010"), ar3);
		LoturiIntrari l10 = new LoturiIntrari(2, 7, 2.3, sdf.parse("11/03/2010"), ar3);
		LoturiIntrari l11 = new LoturiIntrari(3, 8, 2.4, sdf.parse("12/05/2010"), ar3);
		LoturiIntrari l12 = new LoturiIntrari(4, 9, 2.5, sdf.parse("13/12/2010"), ar3);
		ar3.addLotIntrare(l9);
		ar3.addLotIntrare(l10);
		ar3.addLotIntrare(l11);
		ar3.addLotIntrare(l12);
		
		gst1.addArticole(ar1);
		gst1.addArticole(ar2);
		gst1.addArticole(ar3);
		gst2.addArticole(ar0);
		logger.loggeazaINFO("END creare articole ");
		
		// ceare comanda materiale
		logger.loggeazaINFO("START creare comanda materiale ");
		ComandaMateriale comMat = new ComandaMateriale(1, new Date(), "tant", "yes");
		comMat.addLinie(new Linie(1, m1, comMat, 0.0, 2));
		comMat.addLinie(new Linie(2, m2, comMat, 0.0, 4));
		logger.loggeazaINFO("END creare articole ");
		// procesare comanda materiale
		Procesare proc = new Procesare(gestiuni, new Angajat(), apPret);
		//BonConsum bon = (BonConsum)proc.preoceseazaComandaMateriale(comMat);
		logger.loggeazaINFO("END creare date de test------ ");
		logger.loggeazaINFO("START teste------ ");
		
		
		
		// 1)-- aplicare metoda calcul pret fifo
		Double rezFIFO = apPret.getPretProdLot(ar1);
		assertNotNull(rezFIFO);
		assertEquals("valoarea nu e cea asteptata", new Double(2.2), apPret.getPretProdLot(ar1));
		logger.loggeazaDEBUG("rezultata fifo = "+ rezFIFO);
		
		
		// 2)-- aplicare metoda calcul pret LIFO
		apPret.setMetodaCurenta(METODE.LIFO);
		Double rezLIFO = apPret.getPretProdLot(ar1);
		assertNotNull(rezLIFO);
		assertEquals("valoarea nu e cea asteptata", new Double(2.5), apPret.getPretProdLot(ar1));
		logger.loggeazaDEBUG("rezultata LIFO = "+ rezLIFO);
		
		// 3)---intrare in articol existent (adica se actualizeaza)
		LoturiIntrari lotNew =new LoturiIntrari(55, 33, 5.5, new Date(), null);
		proc.intrareInStoc(m3, lotNew, gst1);
		assertEquals("nu a intrat nici un lot nou pentru m3 in gestiunea gst1",
						5, gst1.getArticole().get(2).getLoturiIntrariArt().size() );
		
		// 4)---intrare articol nou( un nou articol se creaza)
		proc.intrareInStoc(m4, new LoturiIntrari(55, 33, 5.5, new Date(), null), gst1);
		assertEquals("nu s-a creat nici un articol nou in gestiunea gst1",
				4, gst1.getArticole().size() );
		
		// 5)--- verificare stoc mijloc circulant
		assertEquals("Stoc incorect", new Integer(60),proc.verificareStocMaterial(m1) );
		
		
		// 6)--- transfer cu cantitate suficienta 
		proc.transfer(gst1, gst2, m2, 20);
		assertEquals("Transfer incorect", new Integer(10),gst1.getArticole().get(1).getCatitateStocPeGestiune() );
		assertEquals("Transfer incorect", new Integer(20),gst2.getArticole().get(1).getCatitateStocPeGestiune() );
		
		// 7)--- iesire din stoc
		proc.iesireDinStoc(m1, 56);
		assertEquals("trebuie sa mai ramana",new Integer(4), proc.verificareStocMaterial(m1));
		
		logger.loggeazaINFO("END teste------ ");
	}

}

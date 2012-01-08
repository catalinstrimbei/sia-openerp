package org.open.erp.services.stocuri.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.open.erp.services.nomgen.Document;
import org.open.erp.services.nomgen.LinieDocument;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.stocuri.ArticolStoc;
import org.open.erp.services.stocuri.Depozit;
import org.open.erp.services.stocuri.Gestiune;
import org.open.erp.services.stocuri.LoturiIntrari;
import org.open.erp.services.stocuri.impl.AplicarePret.METODE;
import org.open.erp.services.stocuri.impl.StocuriImpl;
import org.open.erp.services.stocuri.util.StocuriLogger;

public class TestEJB {
	private final StocuriLogger logger = new StocuriLogger();
	private StocuriImpl stocuriImpl;
	private Gestiune gst1;
	private Gestiune gst2;
	private Material m1;

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		stocuriImpl = (StocuriImpl) ctx.lookup("StocuriImpl/local");
		gst1 = new Gestiune(1, "gest unu", new Depozit(1, "Iasi", "1000mp"));
		gst2 = new Gestiune(2, "gest doi", new Depozit(2, "Suceava", "1000mp"));
		m1 = new Material(1, "pal", "uM");
		logger.loggeazaDEBUG("intiere test");
	}

	private static InitialContext initJBossJNDICtx() throws NamingException {
		Properties props = new Properties();
		props.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		props.put("java.naming.provider.url", "jnp://localhost:1099/");
		props.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");
		return new InitialContext(props);
	}

	@org.junit.Test
	public void metodaDeTestGetArticole() {
		try {
			logger.loggeazaINFO("START test GetArticole------ ");
			stocuriImpl.getArticole();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.loggeazaINFO("END test GetArticole------ ");
	}

	@org.junit.Test
	public void metodaDeTestGetArticolById(Integer id) {
		try {
			logger.loggeazaINFO("START test GetArticolById------ ");
			stocuriImpl.getArticolById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.loggeazaINFO("END test GetArticolById------ ");
	}

	@org.junit.Test
	public void metodaDeTestFIFO() {
		try {
			logger.loggeazaINFO("START test FIFO------ ");

			ArticolStoc ar1 = stocuriImpl.getArticolById(1);
			stocuriImpl.setMetodaCurenta(METODE.FIFO);
			Double rezFIFO = stocuriImpl
					.getPretArticolAplicareMetodaCalcul(ar1);

			assertNotNull(rezFIFO);
			assertEquals("valoarea nu e cea asteptata", new Double(2.2),
					rezFIFO);
			logger.loggeazaDEBUG("rezultata fifo = " + rezFIFO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.loggeazaINFO("END test FIFO------ ");
	}

	@org.junit.Test
	public void metodaDeTestLIFO() {
		try {
			logger.loggeazaINFO("START test LIFO------ ");

			ArticolStoc ar1 = stocuriImpl.getArticolById(1);
			stocuriImpl.setMetodaCurenta(METODE.LIFO);
			Double rezFIFO = stocuriImpl
					.getPretArticolAplicareMetodaCalcul(ar1);

			assertNotNull(rezFIFO);
			assertEquals("valoarea nu e cea asteptata", new Double(2.2),
					rezFIFO);
			logger.loggeazaDEBUG("rezultata fifo = " + rezFIFO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.loggeazaINFO("END test LIFO------ ");
	}

	@org.junit.Test
	public void metodaTestIntrareStoc() {
		logger.loggeazaINFO("START test IntrareStoc------ ");
		try {
			LoturiIntrari lotNew = new LoturiIntrari(55, 33, 5.5, new Date(),
					null);
			Material m3 = new Material(1, "panza", "metru");

			stocuriImpl.intrareInStoc(m3, lotNew, gst1);

			assertEquals(
					"nu a intrat nici un lot nou pentru m3 in gestiunea gst1",
					5, gst1.getArticole().get(0).getLoturiIntrariArt().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.loggeazaINFO("END test IntrareStoc------ ");
	}

	@org.junit.Test
	public void metodaTestIntrareStocCuDocument() {
		logger.loggeazaINFO("START test IntrareStocCuDocument------ ");

		Document doc = new Document(1, new Date());
		doc.addLinie(new LinieDocument(1, doc, m1, 100.0, 20.0, 0.0));

		stocuriImpl.intrareInStoc(doc, gst1);

		assertEquals("nu s-a creat nici un articol nou in gestiunea", 2, gst1
				.getArticole().size());
		logger.loggeazaINFO("END test IntrareStocCuDocument------ ");
	}

	@org.junit.Test
	public void metodaTestVerificareStocDupaMaterial() {
		logger.loggeazaINFO("START test VerificareStocDupaMaterial------ ");
		assertEquals("Stoc incorect", new Double(100.0),
				stocuriImpl.verificareStocMaterial(m1));

		logger.loggeazaINFO("END test VerificareStocDupaMaterial------ ");
	}

	@org.junit.Test
	public void metodaTestTransferIntreGestiuni() {
		logger.loggeazaINFO("START test TransferIntreGestiuni------ ");
		stocuriImpl.transfer(gst1, gst2, m1, 20);

		assertEquals("Transfer incorect", new Integer(80), gst1.getArticole()
				.get(0).getCatitateStocPeGestiune());
		assertEquals("Transfer incorect", new Integer(20), gst2.getArticole()
				.get(0).getCatitateStocPeGestiune());
		logger.loggeazaINFO("END test TransferIntreGestiuni------ ");
	}

	@org.junit.Test
	public void metodaTestIesireDinStoc() {
		logger.loggeazaINFO("START test IesireDinStoc------ ");
		try {

			stocuriImpl.iesireDinStoc(m1, 10);
			assertEquals("trebuie sa mai ramana", new Double(90.0),
					stocuriImpl.verificareStocMaterial(m1));

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.loggeazaINFO("END test IesireDinStoc------ ");
		logger.loggeazaINFO("END teste------ ");
	}

}

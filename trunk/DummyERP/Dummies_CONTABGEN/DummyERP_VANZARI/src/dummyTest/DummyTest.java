package dummyTest;

import java.util.Date;

import org.junit.Test;
import org.junit.Before;
import org.open.erp.services.nomgen.Material;
import org.open.erp.services.nomgen.RegDocumente;

import dummy.Factura;
import dummy.LinieFactura;


public class DummyTest {
	
	RegDocumente regDoc;
	@Before
	public void setUp(){
		regDoc= RegDocumente.instantiaza();
	}
	
	@Test
	public void test_adaugareFactura(){
		Factura fact = new Factura(1002, new Date(), "FACT123", 1, 2);
		fact.adaugaLinie(new LinieFactura(new Material(), 100.0, 100.0, 0.19));
		fact.adaugaLinie(new LinieFactura(new Material(), 200.0, 200.0, 0.19));
		fact.adaugaLinie(new LinieFactura(new Material(), 300.0, 300.0, 0.19));
		
		fact.printAll();
		regDoc.addDocument(fact);
		regDoc.printAll();
	}
}

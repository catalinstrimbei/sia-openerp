package org.open.erp.services.nomgen.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.nomgen.MateriePrima;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Banca;
import org.open.erp.services.nomgen.logger.NomgenLogger;



public class TestNomenclatoareDummyImpl{
	private NomenclatoareSrv instance = null;
	private static NomgenLogger logger;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//logger = new NomgenLogger();
	//	instance = new NomenclatoareDummyImpl();
	//	assertNotNull(instance);		
		//assertTrue(instance instanceof NomenclatoareDummyImpl);
		
		//InitialContext ctx = initJBossJNDICtx();
	//	instance = (NomenclatoareSrv)ctx.lookup("NomenclatoareSrv/remote");
		//logger.logINFO("test initial" + instance);
		
		logger = new NomgenLogger();
		InitialContext ctx = initJBossJNDICtx();
		instance = (NomenclatoareSrv)ctx.lookup("NomenclatoareSrv/remote");		
		logger.logINFO("initTest " + instance);
	}
	
	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
		props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.put("java.naming.provider.url", "jnp://localhost:1099/");
		props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		return new InitialContext(props);
		}

	

	/*@Test
	public void testCreazaPersoana() {
		//fail("Not yet implemented");
		Persoana p = new Persoana(1,"Alea Tudor Neculai");
		System.out.println("Am creat o persoana cu id "+ instance.get()+ " adresa: "+p.getAdresa());
	}
*/
	@Test
	public void testGetPersoanaDupaAdresa() throws Exception {
		//fail("Not yet implemented");
		Persoana persoana = instance.getPersoanaDupaAdresa("A1");
		
		assertNotNull(persoana);
		
		assertTrue(persoana instanceof Persoana);
		
		assertEquals((Integer)1, persoana.getId());
	}

	@Test
	public void testCautarePersoanaDupaId() {
		//fail("Not yet implemented");
		try{
			Persoana persoana = instance.getPF("2");
			assertNotNull(persoana);
		
			assertTrue(persoana instanceof Persoana);
			
			assertEquals((String)"id", persoana.getAdresa());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
		
		
	}

	@Test
	public void testCreazaPersoanaFizica() {
		//fail("Not yet implemented");
		PersoanaFizica p = new PersoanaFizica(1,"Adresa 1", "Popescu","Vasile","Domnul",'M',"1234567892365");
		System.out.println("Am creat persoana "+p.getNume()+"  "+p.getPrenume()+"cu id "+ p.getId()+" cu adresa "+p.getAdresa()+" cu forma de adresare "+p.getFormaAdresare()+"de genul "+p.getGen()+", avand CNP-ul: "+p.getCnp());
	}

	@Test
	public void testGetPersoanaFizicaCuId() throws Exception {
		//fail("Not yet implemented");
		
        PersoanaFizica persoana = instance.getPF("1");
		
		assertNotNull(persoana);
		
		assertTrue(persoana instanceof PersoanaFizica);
		
		assertEquals((Integer)1, persoana.getId());
		
	}



	@Test
	public void testCautarePersoanaFizicaDupaPrenume() {
		//fail("Not yet implemented");
		
		try{
			PersoanaFizica persoana = instance.cautarePersoanaFizicaDupaPrenume("prenume");
			assertNotNull(persoana);
		
			assertTrue(persoana instanceof PersoanaFizica);
			
			assertEquals((String)"prenume", persoana.getPrenume());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	

	@Test
	public void testCreazaPersoanaJuridica() {
		//fail("Not yet implemented");
		PersoanaJuridica p = new PersoanaJuridica(1, "Adresa2","S.C. UnknownLevel S.R.L","32434","9876","RO3556357");
		System.out.println("Am creat persoana juridica "+p.getDenumire()+" cu adresa "+p.getAdresa()+" cu codul fiscal "+p.getCodFiscal()+",cu nr de inmatriculare fiscala "+p.getNrInmatriculareFiscala()+" cu atributul fiscal "+p.getAtributFiscal());
		 
	}

	@Test
	public void testGetPersoanaJuridicaCuId() throws Exception {
	//	fail("Not yet implemented");
		
		PersoanaJuridica persoana = instance.getPJ("1");
		
		assertNotNull(persoana);
		
		assertTrue(persoana instanceof PersoanaJuridica);
		
		assertEquals((Integer)1, persoana.getId());
	}

	
	@Test
	public void testCautarePersoanaJuridicaDupaDenumire() {
		//fail("Not yet implemented");
		
		try{
			PersoanaJuridica persoana = instance.cautarePersoanaJuridicaDupaDenumire("adresa");
			assertNotNull(persoana);
		
			assertTrue(persoana instanceof PersoanaJuridica);
			
			assertEquals((String)"denumire", persoana.getAdresa());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCreazaProdus() throws ParseException {
		//fail("Not yet implemented");
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");

		Produs p = new Produs(1, "Produs1", "Litru", (Date)formatter.parse("01/29/02"), 70);
		System.out.println("Am creat un produs "+p.getDenumire()+"cu UM "+p.getUnitateMasura()+" fabricat la data de "+p.getDataFabricatiei()+", cu valabilitatea de "+p.getTermenValabilitate()+" zile.");
	}

	@Test
	public void testGetProdusCuId() throws Exception {
		//fail("Not yet implemented");
		Produs produs = instance.getProdus(1);
		
		assertNotNull(produs);
		
		assertTrue(produs instanceof Produs);
		
		assertEquals((Integer)1, produs.getIdMaterial());
		
	}

	@Test
	public void testCautareProdusDupaDenumire() {
		//fail("Not yet implemented");
		
		try{
			Produs produs = instance.CautareProdusDupaDenumire("denumire");
			assertNotNull(produs);
		
			assertTrue(produs instanceof Produs);
			
			assertEquals((String)"denumire", produs.getDenumire());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCreazaMateriePrima() throws ParseException {
		//fail("Not yet implemented");
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");

		MateriePrima p = new MateriePrima(1, "MateriePrima1", "Litru", (Date)formatter.parse("01/29/03"), 70);
		System.out.println("Am creat o materie prima "+p.getDenumire()+"cu UM "+p.getUnitateMasura()+" fabricat la data de "+p.getDataFabricatiei()+", cu valabilitatea de "+p.getTermenValabilitate()+" zile.");
		
	}

	@Test
	public void testGetMateriePrimaCuId() throws Exception {
		//fail("Not yet implemented");
        MateriePrima materieprima = instance.getMPDupaCod(1);
		
		assertNotNull(materieprima);
		
		assertTrue(materieprima instanceof MateriePrima);
		
		assertEquals((Integer)1, materieprima.getId());	
	}



	@Test
	public void testCreazaMijlocFix() throws ParseException {
		//fail("Not yet implemented");
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");

		Produs p = new Produs(1, "MijlcFix1", "Buc", (Date)formatter.parse("01/29/04"), 200);
		System.out.println("Am creat un mijloc fix "+p.getDenumire()+"cu UM "+p.getUnitateMasura()+" fabricat la data de "+p.getDataFabricatiei()+", cu valabilitatea de "+p.getTermenValabilitate()+" zile.");
		
		
	}

	@Test
	public void testGetMijlocFixCuId() throws Exception {
		//fail("Not yet implemented");
		 MijlocFix mijlocfix = instance.getMFDupaCod(1);
			
			assertNotNull(mijlocfix);
			
			assertTrue(mijlocfix instanceof MijlocFix);
			
			assertEquals((Integer)1, mijlocfix.getId());	
	}


	@Test
	public void testCreazaPartener() throws ParseException {
		//fail("Not yet implemented");
		
		Persoana pers = new Persoana(1,"adresa1");
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");

		Partener p = new Partener(pers, (Date)formatter.parse("01/29/02"), 120);
		System.out.println("Am creat un partener cu id-ul "+p.getId()+"cu idPersoana "+pers.getId()+" cu data afilierii "+p.getDataAfilierii()+", cu durata afilierii de "+p.getDurataAfilierii()+" zile.");
	}

	@Test
	public void testGetPartenerCuId() throws Exception {
		//fail("Not yet implemented");
		Partener partener = instance.getPartenerDupaCodPersoana("1");
		
		assertNotNull(partener);
		
		assertTrue(partener instanceof Partener);
		
		assertEquals((Integer)1, partener.getId());
	}

	

	@Test
	public void testCreazaBanca() {
		//fail("Not yet implemented");
		

		Banca b = new Banca(1,"Adresa3","Banca1", "12333448","J65576576","RO76345637","20000");
		System.out.println("Am creat o banca cu id-ul "+b.getId()+", cu capitalul social de "+b.getCapSocial()+", cu denumirea "+b.getDenumire());
	}

	
	

	

	@Test
	public void testCreazaDepartament() {
		//fail("Not yet implemented");
		Departament b = new Departament(1,"Departament1","Atributii");
		System.out.println("Am creat o un departament cu id-ul "+b.getId()+", cu denumirea "+b.getDenumire()+", cu atributiile "+b.getAtributii());
		
	}

	@Test
	public void testGetDepartamentCuId() throws Exception {
		//fail("Not yet implemented");
		
        Departament dep = instance.getDepDupaCod(1);
		
		assertNotNull(dep);
		
		assertTrue(dep instanceof Departament);
		
		assertEquals((Integer)1, dep.getId());
	}

	@Test
	public void testCautareDepartamentDupaDen() {
		//fail("Not yet implemented");
		
		try{
			Departament dep = instance.getDepartamentDupaDenumire("dummy");
			assertNotNull(dep);
		
			assertTrue(dep instanceof Departament);
			
			assertEquals((Integer)1, dep.getId());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	

	


}

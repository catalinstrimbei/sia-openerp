package org.open.erp.services.nomgen.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.nomgen.MateriePrima;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Divizie;

import org.open.erp.services.nomgen.Banca;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;

public class TestNomenclatoareDummyImpl{
	private NomenclatoareDummyImpl instance = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new NomenclatoareDummyImpl();
		assertNotNull(instance);		
		assertTrue(instance instanceof NomenclatoareDummyImpl);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreazaPersoana() {
		//fail("Not yet implemented");
		Persoana p = new Persoana(1,"Alea Tudor Neculai");
		System.out.println("Am creat o persoana cu id "+ p.getId()+ " adresa: "+p.getAdresa());
	}

	@Test
	public void testGetPersoanaCuId() {
		//fail("Not yet implemented");
		Persoana persoana = instance.getPersoanaCuId(1);
		
		assertNotNull(persoana);
		
		assertTrue(persoana instanceof Persoana);
		
		assertEquals((Integer)1, persoana.getId());
	}

	@Test
	public void testCautarePersoanaDupaAdresa() {
		//fail("Not yet implemented");
		try{
			Persoana persoana = instance.cautarePersoanaDupaAdresa("adresa");
			assertNotNull(persoana);
		
			assertTrue(persoana instanceof Persoana);
			
			assertEquals((String)"adresa", persoana.getAdresa());
			
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
	public void testGetPersoanaFizicaCuId() {
		//fail("Not yet implemented");
		
        PersoanaFizica persoana = instance.getPersoanaFizicaCuId(1);
		
		assertNotNull(persoana);
		
		assertTrue(persoana instanceof PersoanaFizica);
		
		assertEquals((Integer)1, persoana.getId());
		
	}

	@Test
	public void testCautarePersoanaFizicaDupaNume() {
		//fail("Not yet implemented");
		
		try{
			PersoanaFizica persoana = instance.cautarePersoanaFizicaDupaNume("nume");
			assertNotNull(persoana);
		
			assertTrue(persoana instanceof PersoanaFizica);
			
			assertEquals((String)"nume", persoana.getNume());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
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
	public void testCautarePersoanaFizicaDupaAdresa() {
		//fail("Not yet implemented");
		try{
			PersoanaFizica persoana = instance.cautarePersoanaFizicaDupaAdresa("adresa");
			assertNotNull(persoana);
		
			assertTrue(persoana instanceof PersoanaFizica);
			
			assertEquals((String)"adresa", persoana.getAdresa());
			
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
	public void testGetPersoanaJuridicaCuId() {
	//	fail("Not yet implemented");
		
		PersoanaJuridica persoana = instance.getPersoanaJuridicaCuId(1);
		
		assertNotNull(persoana);
		
		assertTrue(persoana instanceof PersoanaJuridica);
		
		assertEquals((Integer)1, persoana.getId());
	}

	@Test
	public void testCautarePersoanaJuridicaDupaDenumire() {
		//fail("Not yet implemented");
		
		try{
			PersoanaJuridica persoana = instance.cautarePersoanaJuridicaDupaDenumire("denumire");
			assertNotNull(persoana);
		
			assertTrue(persoana instanceof PersoanaJuridica);
			
			assertEquals((String)"denumire", persoana.getDenumire());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCautarePersoanaJuridicaDupaAdresa() {
		//fail("Not yet implemented");
		
		try{
			PersoanaJuridica persoana = instance.cautarePersoanaJuridicaDupaAdresa("adresa");
			assertNotNull(persoana);
		
			assertTrue(persoana instanceof PersoanaJuridica);
			
			assertEquals((String)"adresa", persoana.getAdresa());
			
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
	public void testGetProdusCuId() {
		//fail("Not yet implemented");
		Produs produs = instance.getProdusCuId(1);
		
		assertNotNull(produs);
		
		assertTrue(produs instanceof Produs);
		
		assertEquals((Integer)1, produs.getId());
		
	}

	@Test
	public void testCautareProdusDupaDenumire() {
		//fail("Not yet implemented");
		
		try{
			Produs produs = instance.cautareProdusDupaDenumire("denumire");
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
	public void testGetMateriePrimaCuId() {
		//fail("Not yet implemented");
        MateriePrima materieprima = instance.getMateriePrimaCuId(1);
		
		assertNotNull(materieprima);
		
		assertTrue(materieprima instanceof MateriePrima);
		
		assertEquals((Integer)1, materieprima.getId());	
	}

	@Test
	public void testCautareMateriePrimaDupaDenumire() {
		//fail("Not yet implemented");
		
		try{
			MateriePrima materie = instance.cautareMateriePrimaDupaDenumire("denumire");
			assertNotNull(materie);
		
			assertTrue(materie instanceof MateriePrima);
			
			assertEquals((String)"denumire", materie.getDenumire());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCreazaMijlocFix() throws ParseException {
		//fail("Not yet implemented");
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");

		Produs p = new Produs(1, "MijlcFix1", "Buc", (Date)formatter.parse("01/29/04"), 200);
		System.out.println("Am creat un mijloc fix "+p.getDenumire()+"cu UM "+p.getUnitateMasura()+" fabricat la data de "+p.getDataFabricatiei()+", cu valabilitatea de "+p.getTermenValabilitate()+" zile.");
		
		
	}

	@Test
	public void testGetMijlocFixCuId() {
		//fail("Not yet implemented");
		 MijlocFix mijlocfix = instance.getMijlocFixCuId(1);
			
			assertNotNull(mijlocfix);
			
			assertTrue(mijlocfix instanceof MijlocFix);
			
			assertEquals((Integer)1, mijlocfix.getId());	
	}

	@Test
	public void testCautareMijlocFixDupaDenumire() {
		//fail("Not yet implemented");
		
		try{
			MijlocFix mijlocfix = instance.cautareMijlocFixDupaDenumire("denumire");
			assertNotNull(mijlocfix);
		
			assertTrue(mijlocfix instanceof MijlocFix);
			
			assertEquals((String)"denumire", mijlocfix.getDenumire());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCautareMijlocFixDupaAdresa() {
		//fail("Not yet implemented");
		
		try{
			MijlocFix mijlocfix = instance.cautareMijlocFixDupaAdresa("adresa");
			assertNotNull(mijlocfix);
		
			assertTrue(mijlocfix instanceof MijlocFix);
			
			assertEquals((String)"adresa", mijlocfix.getAdresa());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCreazaPartener() throws ParseException {
		//fail("Not yet implemented");
		
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");

		Partener p = new Partener(1, 11, (Date)formatter.parse("01/29/02"), 120);
		System.out.println("Am creat un partener cu id-ul "+p.getId()+"cu idPersoana "+p.getIdPersoana()+" cu data afilierii "+p.getDataAfilierii()+", cu durata afilierii de "+p.getDurataAfilierii()+" zile.");
	}

	@Test
	public void testGetPartenerCuId() {
		//fail("Not yet implemented");
		Partener partener = instance.getPartenerCuId(1);
		
		assertNotNull(partener);
		
		assertTrue(partener instanceof Partener);
		
		assertEquals((Integer)1, partener.getId());
	}

	@Test
	public void testCautarePartenerDupaIdPersoana() {
		//fail("Not yet implemented");
		
		try{
			Partener partener = instance.cautarePartenerDupaIdPersoana(1);
			assertNotNull(partener);
		
			assertTrue(partener instanceof Partener);
			
			assertEquals((Integer)1, partener.getIdPersoana());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCreazaBanca() {
		//fail("Not yet implemented");
		

		Banca b = new Banca(1,"Adresa3","Banca1", "12333448","J65576576","RO76345637","20000");
		System.out.println("Am creat o banca cu id-ul "+b.getId()+", cu capitalul social de "+b.getCapSocial()+", cu denumirea "+b.getDenumire());
	}

	@Test
	public void testGetBancaCuId() {
	//	fail("Not yet implemented");
       Banca banca = instance.getBancaCuId(1);
		
		assertNotNull(banca);
		
		assertTrue(banca instanceof Banca);
		
		assertEquals((Integer)1, banca.getId());
		
	}

	@Test
	public void testCautareBancaDupaId() {
		//fail("Not yet implemented");
		
		try{
			Banca banca = instance.cautareBancaDupaId(1);
			assertNotNull(banca);
		
			assertTrue(banca instanceof Banca);
			
			assertEquals((Integer)1, banca.getId());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCautareBancaDupaDenumire() {
		//fail("Not yet implemented");
		
		try{
			Banca banca = instance.cautareBancaDupaDenumire("dummy");
			assertNotNull(banca);
		
			assertTrue(banca instanceof Banca);
			
			assertEquals((String)"dummy", banca.getDenumire());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCreazaDepartament() {
		//fail("Not yet implemented");
		Departament b = new Departament(1,"Departament1","Atributii");
		System.out.println("Am creat o un departament cu id-ul "+b.getId()+", cu denumirea "+b.getDenumire()+", cu atributiile "+b.getAtributii());
		
	}

	@Test
	public void testGetDepartamentCuId() {
		//fail("Not yet implemented");
		
        Departament dep = instance.getDepartamentCuId(1);
		
		assertNotNull(dep);
		
		assertTrue(dep instanceof Departament);
		
		assertEquals((Integer)1, dep.getId());
	}

	@Test
	public void testCautareDepartamentDupaId() {
		//fail("Not yet implemented");
		
		try{
			Departament dep = instance.cautareDepartamentDupaId(1);
			assertNotNull(dep);
		
			assertTrue(dep instanceof Departament);
			
			assertEquals((Integer)1, dep.getId());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCautareDepartamentDupaDenumire() {
		//fail("Not yet implemented");
		
		try{
			Departament dep = instance.cautareDepartamentDupaDenumire("dummy");
			assertNotNull(dep);
		
			assertTrue(dep instanceof Departament);
			
			assertEquals((String)"dummy", dep.getDenumire());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}

	@Test
	public void testCreazaDivizie() {
		//fail("Not yet implemented");
		Departament d = new Departament(1,"Dep1","Atrib1");
		Divizie b = new Divizie(1,d ,"Divizie1","Atributii");
		System.out.println("Am creat o divizie cu id-ul "+b.getId()+b.getIdDepartament()+" "+", cu denumirea "+b.getDenumire()+", cu atributiile "+b.getAtributii());
		
	}

	@Test
	public void testGetDivizieCuId() {
		//fail("Not yet implemented");
        Divizie divizie = instance.getDivizieCuId(1);
		
		assertNotNull(divizie);
		
		assertTrue(divizie instanceof Divizie);
		
		assertEquals((Integer)1, divizie.getId());
		
	}

	@Test
	public void testCautareDivizieDupaId() {
		//fail("Not yet implemented");
		
		try{
			Divizie div = instance.cautareDivizieDupaId(1);
			assertNotNull(div);
		
			assertTrue(div instanceof Divizie);
			
			assertEquals((Integer)1, div.getId());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
			
	}

	@Test
	public void testCautareDivizieDupaDenumire() {
		//fail("Not yet implemented");
		
		try{
			Divizie div = instance.cautareDivizieDupaDenumire("dummy");
			assertNotNull(div);
		
			assertTrue(div instanceof Divizie);
			
			assertEquals((String)"dummy", div.getDenumire());
			
		}catch (Exception e)
		{ System.out.println("Eroare");}
	}


}

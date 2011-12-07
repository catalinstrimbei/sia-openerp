package org.open.erp.services.nomgen.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.Produs;
import org.open.erp.services.nomgen.MateriePrima;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.Telefon;
import org.open.erp.services.nomgen.Email;
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
		
		 
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
	public void testCreazaProdus() {
		fail("Not yet implemented");
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
	public void testCreazaMateriePrima() {
		fail("Not yet implemented");
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
	public void testCreazaMijlocFix() {
		fail("Not yet implemented");
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
	public void testCreazaPartener() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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

	@Test
	public void testCreazaTelefon() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTelefonCuId() {
		//fail("Not yet implemented");
		    Telefon tel = instance.getTelefonCuId(1);		
			assertNotNull(tel);
			
			assertTrue(tel instanceof Telefon);
			
			assertEquals((Integer)1, tel.getId());
	}

	@Test
	public void testCreazaEmail() {
		
		Email email = instance.getEmailCuId(1);	
		assertNotNull(email);
		
		assertTrue(email instanceof Email);
		
	}

	@Test
	public void testGetEmailCuId() {
		//fail("Not yet implemented");
		    Email email = instance.getEmailCuId(1);	
			assertNotNull(email);
			
			assertTrue(email instanceof Email);
			
			assertEquals((Integer)1, email.getId());
	}

}

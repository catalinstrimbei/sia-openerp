package org.open.erp.services.nomgen.teste;

import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;
import org.open.erp.services.nomgen.logger.NomgenLogger;

public class TestNomGen {

		  
		
		NomenclatoareDummyImpl nomgenService = new NomenclatoareDummyImpl();
		NomgenLogger logger = new NomgenLogger();
		
		void vizualizarePersoane(TestNomGenImpl test) 
		{		
			
			test.generarePersoane();
			Iterator<Persoana> iterator = test.ListaPersoana.iterator();
			Iterator<PersoanaFizica> IPF = test.ListaPF.iterator();
			Iterator<PersoanaJuridica> IPJ = test.ListaPJ.iterator();
			Iterator<Partener> part = test.ListaParteneri.iterator();
			System.out.println("Persoane totale:" + test.ListaPersoana.size() + "din care Persoane fizice sunt:" + test.ListaPF.size());
			System.out.println("Persoane juridice:" + test.ListaPJ.size() +"Iar parteneri sunt:" + test.ListaParteneri.size());

		test.generareListaParteneri();
		test.AdaugarePersoanePF();
		test.AdaugarePersoanePJ();
		
			while (iterator.hasNext()) 
			{			
				Persoana p = iterator.next();
				
				System.out.println("Persoana ID:" + p.getId() + "Adresa:" + p.getAdresa());
				while (IPF.hasNext())
				{
				
				PersoanaFizica pf = IPF.next();
				if (p.getId()==pf.getId()) {
					System.out.println("Este persoana fizica");
					System.out.println("Numele:" + pf.getNume() + "Prenumele:" + pf.getPrenume());
					System.out.println("CNP:" + pf.getCnp() + "Domiciliat :" + pf.getAdresa());
				}
					
				}
				
				while (IPJ.hasNext())
				{
				
				PersoanaJuridica pj = IPJ.next();
				if (p.getId()==pj.getId()) {
					System.out.println("Este persoana juridica" + pj.getDenumire());
					System.out.println("Atribut Fiscal:" + pj.getAtributFiscal() + "CodFiscal:" + pj.getCodFiscal());
					System.out.println("Nr Inmatriculare:" + pj.getNrInmatriculareFiscala() + "Sediul :" + pj.getAdresa());
				}
					
				}
				
				while (part.hasNext())
				{
				
				Partener pa = part.next();
				if (p.getId()==pa.getId()) {
					System.out.println("Este partener");
					System.out.println("Data ailierii:" + pa.getDataAfilierii() + "Pe o durata de:" + pa.getDurataAfilierii() + "ani");
					}
					
				}
				
				
			}
				
				
		}
		
		
		void vizualizareListaDepartaente(TestNomGenImpl test) {
			test.generareListaDepartamente();
			Iterator<Departament> iterator = test.ListaDepartamente.iterator();
			Iterator<Divizie> idev1 = test.ListaDivizii1.iterator();
			Iterator<Divizie> idev2 = test.ListaDivizii2.iterator();
			
			while (iterator.hasNext()) {
			
				Departament dep = iterator.next();
				
				System.out.println("Departamentul:" + dep.getDenumire() + "Atributii:" + dep.getAtributii());
				
				while (idev1.hasNext())
				{
				
				Divizie d1 = idev1.next();
				if (dep.getId()==d1.getId()) {
					System.out.println("Contine SubDivizia1:" + d1.getDenumire());
					
					System.out.println("avand atributiile sale:" + d1.getAtributii());
				}
				}
				
				while (idev2.hasNext())
				{
				
					Divizie d2 = idev2.next();
					if (dep.getId()==d2.getId()) {
						System.out.println("Contine SubDivizia2:" + d2.getDenumire());
						
						System.out.println("avand atributiile sale:" + d2.getAtributii());}
				
				
							}
			}	
			
		
			}
		
		
		
		

		@Test
		public void testLogger() {
			logger.logDEBUG("DEBUG test");
			logger.logERROR("ERROR test");
			logger.logFATAL("FATAL test");
			logger.logINFO("INFO test");
			logger.logWARN("WARN test");		
		}
		
		
		@Test
		public void testPersoane() {
			TestNomGenImpl test = new TestNomGenImpl();
			
			
			vizualizarePersoane(test);
			System.out.println("Test 1 persoane ");
			vizualizareListaDepartaente(test);
	
		}
		
		@Test
		public void testAdaugarePersoana() throws Exception{
			TestNomGenImpl test = new TestNomGenImpl();
			Iterator<Persoana> ip = test.ListaPersoana.iterator();
			while (ip.hasNext()){
				Persoana p = ip.next();
			nomgenService.addPersoana(p);
			System.out.println("Persoana cu ID:" + p.getId() + " a fost adaugata");
			}
		}
		@Test
		public void testAdaugarePF() throws Exception{
			TestNomGenImpl test = new TestNomGenImpl();
			Iterator<PersoanaFizica> ip = test.ListaPF.iterator();
			while (ip.hasNext()){
				PersoanaFizica p = ip.next();
			nomgenService.addPersoanaFizica(p);
			System.out.println("Persoana Fizica Nume:" + p.getNume() + " a fost adaugata");
			}
		}
		
		@Test
		public void testAdaugarePJ() throws Exception{
			TestNomGenImpl test = new TestNomGenImpl();
			Iterator<PersoanaJuridica> ip = test.ListaPJ.iterator();
			while (ip.hasNext()){
				PersoanaJuridica p = ip.next();
			nomgenService.addPersoanaJuridica(p);
			System.out.println("Persoana Juridica:" + p.getDenumire() + " a fost adaugata");
			}
		}
		
		@Test
		public void testAdaugareDepartamente() throws Exception{
			TestNomGenImpl test = new TestNomGenImpl();
			Iterator<Departament> ip = test.ListaDepartamente.iterator();
			while (ip.hasNext()){
				Departament p = ip.next();
			nomgenService.addDepartament(p);
			System.out.println("Departamentul cu ID:" + p.getId() + " a fost adaugat");
			}
		}
		
		
		
		
		/**
		 * @throws java.lang.Exception
		 */
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
		}

		/**
		 * @throws java.lang.Exception
		 */
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}

		/**
		 * @throws java.lang.Exception
		 */
		@Before
		public void setUp() throws Exception {
		}

		/**
		 * @throws java.lang.Exception
		 */
		@After
		public void tearDown() throws Exception {
		}
	
		
		
		
		
		
		
		
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Persoana p1, p2;
		
		  // Persoana p1 = new Persoana(1, "Adresa1");
		//	Persoana p2 = new Persoana(2, "Adresa2");
			
	   
		 //  p1 = new Persoana( "Ionescu", "Mihai", 1.74, 'M');
		 //  p1.afiseazaInformatii("p1");
		 //  p2 = p1;
		 //  p2.afiseazaInformatii("p2");
		 //  p1.setVarsta(p1.getVarsta()+1); // modific p1
		 //  p2.afiseazaInformatii("p2");
		 //  p2 = new Persoana( "Georgescu", "Mihaela");
		//   p2.afiseazaInformatii("p2");
	



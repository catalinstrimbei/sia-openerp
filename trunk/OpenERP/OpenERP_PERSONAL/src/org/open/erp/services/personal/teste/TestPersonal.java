/**
 * 
 */
package org.open.erp.services.personal.teste;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//TODO uncomment this
//import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.personal.DummyDepartament;
import org.open.erp.services.personal.Activitate;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.RezultatProbaEvaluare;
import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.Eveniment;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.impl.PersonalImpl;
import org.open.erp.services.personal.logger.PersonalLogger;

/**
 * @author Doinoi
 *
 */
public class TestPersonal {
	PersonalImpl personalService = new PersonalImpl();
	PersonalLogger logger = new PersonalLogger();
	
	void vizualizareRecrutare2(TestPersonalImplSimplu test) 
	{		
		//this.generareAnunturi();
		test.generareCandidati();
		Iterator<AnuntLocMunca> iterator = test.ListaAnunturi2.iterator();
		System.out.println("Anunturi valide " + test.ListaAnunturi2.size());
		
		//System.out.println("Interviuri " + ListaInterviuri.size());
	
		while (iterator.hasNext()) 
		{			
			AnuntLocMunca anunt = iterator.next();
			System.out.println(anunt.getFunctie().getNumeFunctie());
			
			test.dataAnunt = anunt.getDataInceput();
			test.ListaCandidati2 = personalService.getCandidatipeFunctie(anunt, test.ListaCandidati);			
			Iterator<Candidat> iterator2 = test.ListaCandidati2.iterator();
			System.out.println("Candidati " + test.ListaCandidati2.size());
			while (iterator2.hasNext()) {		
			   //System.out.println("--" + iterator2.next().getNume());
				//System.out.println("Candidati " + ListaCandidati2.size());
			   Candidat candidat = iterator2.next();
			   test.ListaCandidati3 = personalService.recrutare(test.dataAnunt, candidat, test.ListaInterviuri);
			  // System.out.println("Interviuri " + ListaInterviuri.size());
			   
			//	if (ListaCandidati3.size() == 0) {System.out.println("-- Candidatii nu indeplinesc conditiile de angajare  ");}

				Iterator<Candidat> iterator3 = test.ListaCandidati3.iterator();
				

				if (test.ListaCandidati3.size() > 0) {
				while (iterator3.hasNext()) {
					
					System.out.println("--Numele candidatului pentru angajare: " + iterator3.next().getNume());
				}
				}			
			}
		}	
	}
	
	void vizualizareListaAnunturiCurente(TestPersonalImplSimplu test) {
		test.generareAnunturi();
		Iterator<AnuntLocMunca> iterator = test.ListaAnunturi2.iterator();
		//System.out.println("AM AJUNS AICI" + ListaAnunturi2.size());
		
		while (iterator.hasNext()) {
			//System.out.println("AM AJUNS AICI2");
			AnuntLocMunca anunt = iterator.next();
			System.out.println(anunt.getCorpAnunt());
			test.ListaCandidati2 = personalService.getCandidatipeFunctie(anunt, test.ListaCandidati);
			Iterator<Candidat> iterator2 = test.ListaCandidati2.iterator();
			while (iterator2.hasNext()) {
				System.out.println("--" + iterator2.next().getNume());
			}
		}	
		
	}
	void vizualizareProbeEvaluarePeDepartament(TestPersonalImplSimplu test)
	{
		test.generareDepartamente();
		test.generareProbeEvaluare();
		HashMap <DummyDepartament, Collection<ProbaEvaluare>> mapFinal = new HashMap <DummyDepartament, Collection<ProbaEvaluare>>(); 
		mapFinal = personalService.getProbeEvaluareDepartament(test.probeEvaluare, test.ListaDepartamente);
		Collection<DummyDepartament> keysDepartamente = new ArrayList<DummyDepartament>(mapFinal.keySet());
		Iterator<DummyDepartament> iteratorDepartamente = keysDepartamente.iterator();
		Collection<ProbaEvaluare> valuesProbeEvaluare = new ArrayList<ProbaEvaluare>();
		DummyDepartament depCurent;
		ProbaEvaluare probaEvaluare;
		while (iteratorDepartamente.hasNext()){
			depCurent = iteratorDepartamente.next();
			System.out.println(depCurent.getDenumire());
			valuesProbeEvaluare = mapFinal.get(depCurent);
			if (valuesProbeEvaluare.size() > 0) {
				Iterator <ProbaEvaluare> iteratorProbaEvaluare = valuesProbeEvaluare.iterator();
				while (iteratorProbaEvaluare.hasNext()){
					probaEvaluare = iteratorProbaEvaluare.next();
					System.out.println("---" + probaEvaluare.getIdProba().toString());
				}
			}
			else{
				System.out.println("Nu exista nicio proba pt departamentul curent");
			}
		}
	}
	
	void vizualizareRezultateProbeEvaluare(TestPersonalImplSimplu test)
	{
		test.generareProbeEvaluare();
		test.generareListaRezultate();
		HashMap <ProbaEvaluare, Collection<RezultatProbaEvaluare>> mapFinal = new HashMap <ProbaEvaluare, Collection<RezultatProbaEvaluare>>(); 
		mapFinal = personalService.getRezultateEvaluareByProba(test.ListaRezultateProbe, test.probeEvaluare);
		Collection<ProbaEvaluare> keysProbe = new ArrayList<ProbaEvaluare>(mapFinal.keySet());
		Iterator<ProbaEvaluare> iteratorProbe = keysProbe.iterator();
		Collection<RezultatProbaEvaluare> valuesRezultateProbeEvaluare = new ArrayList<RezultatProbaEvaluare>();
		//DummyDepartament depCurent;
		ProbaEvaluare probaEvaluareCurenta;
		RezultatProbaEvaluare rezultatCurent;
		while (iteratorProbe.hasNext()){
			probaEvaluareCurenta = iteratorProbe.next();
			System.out.println("La proba " + probaEvaluareCurenta.getIdProba() + " s-au obtinut urmatoarele rezultate:");
			valuesRezultateProbeEvaluare = mapFinal.get(probaEvaluareCurenta);
			if (valuesRezultateProbeEvaluare.size() > 0) {
				Iterator <RezultatProbaEvaluare> iteratorRezultateProbaEvaluare = valuesRezultateProbeEvaluare.iterator();
				while (iteratorRezultateProbaEvaluare.hasNext()){
					rezultatCurent = iteratorRezultateProbaEvaluare.next();
					Angajat angajatCurent =  rezultatCurent.getAngajat();
					System.out.println(" -- Angajatul: " + angajatCurent.getNume() + " a avut urmatorul rezultat: " + rezultatCurent.getRezultat());
				}
			}
			else{
				System.out.println("Nu exista niciun rezultat pt proba curenta");
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
	public void testRecrutare() {
		TestPersonalImplSimplu test = new TestPersonalImplSimplu();
		vizualizareListaAnunturiCurente(test);
		System.out.println("FAZA 2");
		vizualizareRecrutare2(test);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testDemisionare() {
		TestPersonalImplSimplu test = new TestPersonalImplSimplu();
		personalService.demisionare(test.cerereDemisie1);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testConcediere() {
		TestPersonalImplSimplu test = new TestPersonalImplSimplu();
		personalService.concediere(test.contract1);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testAngajare(){
		TestPersonalImplSimplu test = new TestPersonalImplSimplu();	
		personalService.angajare(test.candidat2);
		System.out.println("Candidatul " + test.candidat1.getNume() + " " + test.candidat1.getPrenume() + " a fost angajat");
	}
	
	@Test
	public void testGetContractAngajatActiv() {
		TestPersonalImplSimplu test = new TestPersonalImplSimplu();	
		test.ListaAngajati();
		test.ListaContracte();
		personalService.getContractAngajatActiv(test.angajat1);
		
	}
	
	
	
	
	@Test
	public void testActivareAngajati() {
		TestPersonalImplSimplu test = new TestPersonalImplSimplu();	
		test.ListaAngajati();
		test.ListaContracte();
		test.ListaDosare();
		System.out.println("Activare candidati");
		personalService.activareAngajati(test.angajati);
		
	}
	
	@Test
	public void testEvaluare(){
		TestPersonalImplSimplu test = new TestPersonalImplSimplu();
		vizualizareProbeEvaluarePeDepartament(test);
		vizualizareRezultateProbeEvaluare(test);
	}
	/*
	@Test
	public void testRelocalizare_promovare(){
		TestPersonalImplSimplu test = new TestPersonalImplSimplu();
		personalService.relocalizare_promovare(10001, test.functie2, null, true, 1200.00, 8.00);
	}
	*/
	@Test
	public void testAdaugareFunctie(){
		TestPersonalImplSimplu test = new TestPersonalImplSimplu();
		personalService.adaugareFunctie("Functie1", 1,null, null, null, null, null, test.departament1);
		System.out.println("Functia a fost creta");
	}
	
	@Test
	public void testEvenimente(){//Test Narcisa
		try
		{
			TestPersonalImplSimplu test = new TestPersonalImplSimplu();
			test.initEvenimenteActivitati();
			Iterator<Eveniment> evenimente = personalService.getEvenimenteAnuale(0).iterator();
			while(evenimente.hasNext())
			{
				Eveniment eveniment = evenimente.next();
				System.out.println(eveniment.getTipEveniment());
				if(eveniment.getActivitati()!=null)
				{
					Iterator<Activitate> activitatiIterator = eveniment.getActivitati().iterator();							
					while (activitatiIterator.hasNext()) {	
						Activitate activitate = activitatiIterator.next();
						System.out.println(activitate.getDescriereActivitate());
					    System.out.println(activitate.getEveniment().getTipEveniment());
					}
				}
				else
				{
					 System.out.println("Nu exista activitati pentru acest eveniment: "+eveniment.getIdEveniment());
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
				
	}
	
	@Test
	public void testAprobareEveniment()
	{
		try
		{
			TestPersonalImplSimplu test = new TestPersonalImplSimplu();
			test.initEvenimenteActivitati();
			personalService.aprobareEveniment(test.eveniment1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
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

/**
 * 
 */
package org.open.erp.services.personal.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.impl.PersonalImpl;

/**
 * @author Doinoi
 *
 */
public class TestPersonal {
	PersonalImpl personalService = new PersonalImpl();
	
	void vizualizareRecrutare2(TestPersonalImpl test) 
	{		
		//this.generareAnunturi();
		test.generareCandidati();
		Iterator<AnuntLocMunca> iterator = test.listaAnunturi2.iterator();
		System.out.println("Anunturi valide " + test.listaAnunturi2.size());
		
		//System.out.println("Interviuri " + listaInterviuri.size());

		
		while (iterator.hasNext()) 
		{
			
			AnuntLocMunca anunt = iterator.next();
			System.out.println(anunt.getFunctie().getNumeFunctie());
			
			test.dataAnunt = anunt.getDataInceput();
			test.listaCandidati2 = personalService.getCandidatipeFunctie(anunt, test.listaCandidati);			
			Iterator<Candidat> iterator2 = test.listaCandidati2.iterator();
			System.out.println("Candidati " + test.listaCandidati2.size());
			while (iterator2.hasNext()) {		
			   //System.out.println("--" + iterator2.next().getNume());
				//System.out.println("Candidati " + listaCandidati2.size());
			   Candidat candidat = iterator2.next();
			   test.listaCandidati3 = personalService.recrutare(test.dataAnunt, candidat, test.listaInterviuri);
			  // System.out.println("Interviuri " + listaInterviuri.size());
			   
			//	if (listaCandidati3.size() == 0) {System.out.println("-- Candidatii nu indeplinesc conditiile de angajare  ");}

				Iterator<Candidat> iterator3 = test.listaCandidati3.iterator();
				

				if (test.listaCandidati3.size() > 0) {
				while (iterator3.hasNext()) {
					
					System.out.println("--Numele candidatului pentru angajare: " + iterator3.next().getNume());
				}
				}			
			}
		}	
	}
	
	void vizualizareListaAnunturiCurente(TestPersonalImpl test) {
		test.generareAnunturi();
		Iterator<AnuntLocMunca> iterator = test.listaAnunturi2.iterator();
		//System.out.println("AM AJUNS AICI" + listaAnunturi2.size());
		
		while (iterator.hasNext()) {
			//System.out.println("AM AJUNS AICI2");
			AnuntLocMunca anunt = iterator.next();
			System.out.println(anunt.getCorpAnunt());
			test.listaCandidati2 = personalService.getCandidatipeFunctie(anunt, test.listaCandidati);
			Iterator<Candidat> iterator2 = test.listaCandidati2.iterator();
			while (iterator2.hasNext()) {
				System.out.println("--" + iterator2.next().getNume());
			}
		}	
		
	}
	void vizualizareProbeEvaluarePeDepartament(TestPersonalImpl test)
	{
		test.generareDepartamente();
		test.generareProbeEvaluare();
		HashMap <Departament, List<ProbaEvaluare>> mapFinal = new HashMap <Departament, List<ProbaEvaluare>>(); 
		mapFinal = personalService.getProbeEvaluareDepartament(test.probeEvaluare, test.listaDepartamente);
		List<Departament> keysDepartamente = new ArrayList<Departament>(mapFinal.keySet());
		Iterator<Departament> iteratorDepartamente = keysDepartamente.iterator();
		List<ProbaEvaluare> valuesProbeEvaluare = new ArrayList<ProbaEvaluare>();
		Departament depCurent;
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
	
	@Test
	public void testRecrutare() {
		TestPersonalImpl test = new TestPersonalImpl();
		vizualizareListaAnunturiCurente(test);
		System.out.println("FAZA 2");
		vizualizareRecrutare2(test);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testDemisionare() {
		TestPersonalImpl test = new TestPersonalImpl();
		personalService.demisionare(test.cerereDemisie1);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testConcediere() {
		TestPersonalImpl test = new TestPersonalImpl();
		personalService.concediere(test.contract1);
		//fail("Not yet implemented");
	}
	/*
	@Test
	public void testAngajare(){
		TestPersonalImpl test = new TestPersonalImpl();
		personalService.angajare(test.candidat1);
		System.out.println("Candidatul" + test.candidat1.getNume() + " " + test.candidat1.getPrenume() + " a fost angajat");
	}
	
	*/
	@Test
	public void testProbeEvaluarePeDepartament(){
		TestPersonalImpl test = new TestPersonalImpl();
		vizualizareProbeEvaluarePeDepartament(test);
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

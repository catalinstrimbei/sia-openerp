package org.open.erp.services.contabgest.teste;
//AICI AM MODIFICAT---

import java.util.Date;


import org.open.erp.services.nommat.Material;
//import org.open.erp.services.contabgest.impl.Material;
import org.open.erp.services.Productie.Reteta;
import org.open.erp.services.contabgest.AnalizaRezultatelor;
import org.open.erp.services.contabgest.CalculCost;
import org.open.erp.services.contabgest.CheltuieliProdus;
import org.open.erp.services.contabgest.RepartizareCheltuieli;
import org.open.erp.services.contabgest.impl.*;

public class ClasaTestare {

	public static void main(String arg[])
	{
		
		
	

		//responsabili
//		Persoana ionescu=new Persoana("Ionescu");
		
		
		
		
		//CREAREA DE  MATERIALE 
		//primum material de categoria MATERIEPRIMA...care nu au nevoie de o reteta;
		Material m1=new Material();
		m1.setCodMaterial("1");
		m1.setDenumireMaterial("lemn");
		m1.setCategorieMaterial("materiePrima");
		m1.setPretStandard("100");
		
		Material m2=new Material();
		m2.setCodMaterial("2");
		m2.setDenumireMaterial("fier");
		m2.setCategorieMaterial("materiePrima");
		m2.setPretStandard("230");
		
		Material m3=new Material();
		m3.setCodMaterial("3");
		m3.setDenumireMaterial("apa");
		m3.setCategorieMaterial("materiePrima");
		m3.setPretStandard("10");
		
		Material m4=new Material();
		m4.setCodMaterial("4");
		m4.setDenumireMaterial("grasime");
		m4.setCategorieMaterial("materiePrima");
		m4.setPretStandard("140");
		
		//CREAREA DE MATERIALE care nu sunt de categoria MATERIEPRIMA--aici calculam pretul...
		
		Material mc1=new Material();
		mc1.setCodMaterial("5");
		mc1.setDenumireMaterial("sapun");
		mc1.setCategorieMaterial("complex");
		Reteta r1=new Reteta();
		r1.setIdReteta(1);
		r1.setMaterial(mc1);
		
		r1.getMateriale().put(m3, 10);
		r1.getMateriale().put(m4, 5);
		mc1.setReteta(r1);
		
		CalculCost calc1=new CalculCost();
		calc1.setId(5);
		calc1.setMaterial(mc1);
		System.out.println("Costul final al sapunului este de "+calc1.costFinal());
			
		
		//pentru repartizarea cheltuielilor
		CheltuieliProdus cheltmc1=new CheltuieliProdus();
		cheltmc1.setMaterial(mc1);
		cheltmc1.setCalculCost(calc1);
		cheltmc1.setBugetEstimat(800);
		
		
		//-----------------Bugetul total si repartizarea cheltuielilor
		RepartizareCheltuieli centralizare=new RepartizareCheltuieli();
		centralizare.setBugetActual(1000);
		centralizare.alocaBugetInitial(cheltmc1, 500);
		System.out.println("bugetul total mai are o valoare de "+centralizare.getBugetActual());
		centralizare.alocaBugetComplet(cheltmc1);
		System.out.println("bugetul total mai are o valoare de "+centralizare.getBugetActual());
		
		//-----------------Analiza rezultatelor----------------------------
		AnalizaRezultatelor analiza1=new AnalizaRezultatelor(1,cheltmc1);
		double costEroare=analiza1.calcDiferenta();
		System.out.println("Diferenta dintre bugetul estimat si cel real este de "+costEroare);
		
		
		
		
		
//		Produs pizza=new Produs(1,"pizza","bucata",oLista);
//		
//		
//		//asignarea unui responsabil;
//		Activitate a1 =new Activitate(1,"materiale",x,date1,date2,pizza, "neinceputa",x);
//		a1.setResponsabil(ionescu);
//		a1.setCostEstimat(150);
		
		
//		Activitate a2 =new Activitate(2,"servicii",x,date1,date2,pizza, "neinceputa",x);
//		a2.setResponsabil(ionescu);
//		a2.setCostEstimat(100);
//		
//		
//		
//		Activitate a3 =new Activitate(3,"vanzare",x,date1,date2,pizza, "neinceputa",x);
//		a3.setResponsabil(ionescu);
//		a3.setCostEstimat(50);
//		
//		
//		Activitate a4=new Activitate(4,"ambalare",x,date1,date2,pizza, "neinceputa",x);
//		a4.setResponsabil(ionescu);
//		a4.setCostEstimat(50);
//		
//		pizza.stagiiProductie.add(a1);
//		pizza.stagiiProductie.add(a2);
//		pizza.stagiiProductie.add(a3);
//		pizza.stagiiProductie.add(a4);
//		
//		RepartizareCheltuieli repartizare=new RepartizareCheltuieli();
//		
//		repartizare.activitati.put(a1, 0.00);
//		repartizare.activitati.put(a2, 0.00);
//		repartizare.activitati.put(a3, 0.00);
//		repartizare.activitati.put(a4, 0.00);
//		
//		//alocam niste bugete				
//		repartizare.alocaBuget(a1, 100.00);
//		System.out.println(repartizare.activitati.get(a1));
//		repartizare.alocaBuget(a3, 175.00);
//		repartizare.alocaBuget(a4, 25.00);
//		
//		//a1.setBugetActual(0);
//		//repartizare.alocaBuget(a1, 132.75);
//		System.out.println(repartizare.activitati.get(a1));
//		
//		AnalizaRezultatelor analiza=new AnalizaRezultatelor(1,pizza);
//		
//		System.out.println(analiza.calcDiferenta());
//	
		
	
		
		
		
	}
}

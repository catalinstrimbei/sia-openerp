package org.open.erp.services.contabgest.teste;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.open.erp.services.contabgest.Persoana;
import org.open.erp.services.contabgest.impl.*;

public class ClasaTestare {

	public static void main(String arg[])
	{
		//date care sa ne ajute
		double x=0;
		Date date2=new Date(94,3,12);
		Date date1=new Date(94,3,15);
		ArrayList <Activitate> oLista = new ArrayList<Activitate>();

		//responsabili
		Persoana ionescu=new Persoana("Ionescu");
		
		//crearea unui produs cu activitatile aferente
		Produs pizza=new Produs(1,"pizza","bucata",oLista);
		
		
		//asignarea unui responsabil;
		Activitate a1 =new Activitate(1,"materiale",x,date1,date2,pizza, "neinceputa",x);
		a1.setResponsabil(ionescu);
		a1.setCostEstimat(150);
		
		
		Activitate a2 =new Activitate(2,"servicii",x,date1,date2,pizza, "neinceputa",x);
		a2.setResponsabil(ionescu);
		a2.setCostEstimat(100);
		
		
		
		Activitate a3 =new Activitate(3,"vanzare",x,date1,date2,pizza, "neinceputa",x);
		a3.setResponsabil(ionescu);
		a3.setCostEstimat(50);
		
		
		Activitate a4=new Activitate(4,"ambalare",x,date1,date2,pizza, "neinceputa",x);
		a4.setResponsabil(ionescu);
		a4.setCostEstimat(50);
	
		pizza.stagiiProductie.add(a1);
		pizza.stagiiProductie.add(a2);
		pizza.stagiiProductie.add(a3);
		pizza.stagiiProductie.add(a4);
		
		RepartizareCheltuieli repartizare=new RepartizareCheltuieli();
		
		repartizare.activitati.put(a1, 0.00);
		repartizare.activitati.put(a2, 0.00);
		repartizare.activitati.put(a3, 0.00);
		repartizare.activitati.put(a4, 0.00);
		
		//alocam niste bugete				
		repartizare.alocaBuget(a1, 100.00);
		System.out.println(repartizare.activitati.get(a1));
		repartizare.alocaBuget(a3, 175.00);
		repartizare.alocaBuget(a4, 25.00);
		
		//a1.setBugetActual(0);
		//repartizare.alocaBuget(a1, 132.75);
		System.out.println(repartizare.activitati.get(a1));
		
		AnalizaRezultatelor analiza=new AnalizaRezultatelor(1,pizza);
		
		System.out.println(analiza.calcDiferenta());
	
		
	
		
		
		
	}
}

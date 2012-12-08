package org.open.erp.services.contabgest.teste;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.open.erp.services.Productie.Produs;
import org.open.erp.services.Productie.Reteta;
import org.open.erp.services.Productie.Semifabricat;

import org.open.erp.services.contabgest.Manopera;
import org.open.erp.services.contabgest.impl.*;
import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.Post;

public class ClasaTestare {

	public static void main(String arg[])
	{
		//date care sa ne ajute
		double x=0;
		Adresa adresa=new Adresa();
		Post post=new Post();
		Date date2=new Date(94,3,12);
		Date date1=new Date(94,3,15);
		ListaCaracteristici l1=new ListaCaracteristici();
		Material m1=new Material("1","soda","3","10","24","nici o observatie",l1);
		Material m2=new Material("2","apa","3","101","24","nici o observatie",l1);
		Material m3=new Material("3","clor","3","103","24","nici o observatie",l1);
		Material m4=new Material("4","lemn","3","10","24","nici o observatie",l1);
		
		
		Semifabricat sem1=new Semifabricat();
		Semifabricat sem2=new Semifabricat();
		Semifabricat sem3=new Semifabricat();
		Semifabricat sem4=new Semifabricat();
		
		
		Produs p1=new Produs(1,"sapun");
		Produs p2=new Produs(2,"pizza");
		Produs p3=new Produs(2,"soba");
		
		Reteta r1=new Reteta(1,p1,m1,sem1,10.0,10.0);
		Reteta r2=new Reteta(2,p2,m2,sem2,7.0,6.0);
		Reteta r3=new Reteta(3,p3,m3,sem4,8.0,4.0);
		
		ContractMunca con1=new ContractMunca(1,1,date1,"perioada",4,8,post,100);
		
		Angajat a1=new Angajat(1,"popescu","M","sdad@dada.com","status","casatorit","craciun","0990000",adresa,con1);
		
		
		CalculCost c1=new CalculCost(1,p1,)
		
		
		public ContractMunca (int salar, int idContract, Date dataAngajare, String perioadaContract,
				int numarLuniContr, int normaZilnica, Post functie,int tarifOreSupl)
		
		
		public CalculCost(int id, Produs produs, Manopera manopera)
		
		public Manopera(Produs produs, Map m)
		{
			this.produs=produs;
			this.oreLucrateAngajati=m;
		}
		public Angajat(Integer id, String nume, String sex, String mail,
				String statutInCompanie, String stareCivila, String dataNastere,
				String telefon, Adresa adresa, ContractMunca cm)
		
//		public Reteta(Integer idReteta, Produs produs, Material materiePrima,
//				Semifabricat semifabricat, Double cantitateM,Double cantitateS)
//		public Material(String codMaterial, String denumireMaterial, String cantitateStandard, String pretStandard,
//				String procentTVACurent, String observatii, ListaCaracteristici listaCaracteristici)
//
//		//responsabili
//		Persoana ionescu=new Persoana("Ionescu");
//		
//		//crearea unui produs cu activitatile aferente
//		Produs pizza=new Produs(1,"pizza","bucata",oLista);
//		
//		
//		//asignarea unui responsabil;
//		Activitate a1 =new Activitate(1,"materiale",x,date1,date2,pizza, "neinceputa",x);
//		a1.setResponsabil(ionescu);
//		a1.setCostEstimat(150);
//		
//		
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
	
		
	
		
		
		
	}
}

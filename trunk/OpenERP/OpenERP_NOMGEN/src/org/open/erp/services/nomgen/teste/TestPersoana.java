package org.open.erp.services.nomgen.teste;

import org.open.erp.services.nomgen.Persoana;

public class TestPersoana {

	public static void main(String args[]) {

		
		   Persoana p1 = new Persoana(1, "Adresa1", 1);
			Persoana p2 = new Persoana(2, "Adresa2", 2);
	
		   		
		   p1.afiseazaInformatii("p1");
		   p2 = p1;
		   p2.afiseazaInformatii("p2");
	
		   p2.afiseazaInformatii("p2");
	
		   p2.afiseazaInformatii("p2");
}}

package org.open.erp.services.personal.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.PersonalSrv;

public class PersonalDummyImpl implements PersonalSrv {

	@Override
	public Angajat creazaAngajat(Integer idPersoana, String nume,
			String prenume, Date dataAngajare, Double salarBaza, Double tarifOrar, Integer numarCopii ) {
		
		Angajat angajat = new Angajat(idPersoana, nume, prenume, dataAngajare, salarBaza, tarifOrar, numarCopii);
		return angajat;
	}

	@Override
	public Angajat getAngajatById(Integer idPersoana) {
		
		Angajat angajat = new Angajat();
		angajat.setIdPersoana(idPersoana);
		//ar trebui un get din BD si un set cu valorile de acolo
		angajat.setNume("Dummy");
		angajat.setPrenume("John");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dataAngajare = dateFormat.parse("2011-11-16");
			angajat.setDataAngajare(dataAngajare);
		} 
		catch (Exception e) {
			System.out.println("Unable to parse date stamp");
		} 
		
		return angajat;
	}

	@Override
	public ArrayList<Angajat> getAngajati() {
		
		ArrayList<Angajat> angajati = new ArrayList<Angajat>();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dataAngajare = dateFormat.parse("2010-11-16");
			angajati.add(creazaAngajat(1,"Patron","Johnny",dataAngajare, 1600.0, 10.0, 1));	
			
			Date dataAngajare1 = dateFormat.parse("2001-01-07");
			angajati.add(creazaAngajat(1,"Sherif","Stelar",dataAngajare1, 3200.0, 20.0, 2));
			
		} 
		catch (Exception e) {
			System.out.println("Unable to parse date stamp");
		} 
		
		return angajati;
	}

}

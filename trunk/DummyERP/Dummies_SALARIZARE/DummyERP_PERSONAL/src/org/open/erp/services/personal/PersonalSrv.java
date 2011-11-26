package org.open.erp.services.personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.open.erp.services.nomgen.Persoana;

public interface PersonalSrv {
	Angajat creazaAngajat(Integer idPersoana, String nume, String prenume, Date dataAngajare, Double salarBaza, Double tarifOrar, Integer numarCopii);
	Angajat getAngajatById(Integer idPersoana);
	ArrayList<Angajat> getAngajati();
	
}

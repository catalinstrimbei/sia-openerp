package org.open.erp.services.salarizare.impl;

import java.util.ArrayList;

import org.open.erp.services.personal.Angajat;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.Retinere;
import org.open.erp.services.salarizare.Spor;

public class RegistruSalarizare {

	public Pontaj getPontajByAngajat(Angajat angajat, Integer an, Integer luna) {
		Pontaj p = new Pontaj();
		p.setAngajat(angajat);
		p.setAn(an);
		p.setLuna(luna);
		p.setOreLucrate(168.0);
		p.setOreSuplimentare(12.0);
		p.setOreConcediu(24.0);
		return p;
	}

	public ArrayList<Spor> getSporuriAngajat(Integer an, Integer luna, Angajat angajat){
		ArrayList<Spor> sporuri= new ArrayList<Spor>();
		//aici apelam ceva din DB care incarca sporurile
		sporuri.add(new Spor("Bonus", 1, 2011, 11, angajat, 1, 100.0));
		
		sporuri.add(new Spor("Bonus procent", 2, 2011, 11, angajat, 2, 5.0));
		return sporuri;
	}

	public ArrayList<Retinere> getRetineriAngajat(Integer an, Integer luna, Angajat angajat){
		ArrayList<Retinere> retineri= new ArrayList<Retinere>();
		//aici apelam ceva din DB care incarca sporurile
		retineri.add(new Retinere("Pensie alimentara", 1, angajat, 2011, 11, 1, 100.0));
		retineri.add(new Retinere("CAR", 2, angajat, 2011, 11, 2, 5.0));
		return retineri;
	}
	

}

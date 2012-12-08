package org.open.erp.services.contabgest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.open.erp.services.Productie.Produs;
import org.open.erp.services.personal.Angajat;


public class Manopera {

	private Produs produs;
	
	//o mapa care contine angajatii si numarul de ore lucrate fiecare pentru manufacturarea produsului
	private   Map<Angajat, Integer> oreLucrateAngajati = new HashMap<Angajat, Integer>();
	//private Integer oreLucru;

	
	public Manopera(Produs produs, Map m)
	{
		this.produs=produs;
		this.oreLucrateAngajati=m;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public Produs getProdus() {
		return produs;
	}
		
	public double calculManopera()
	{

		
		int sum=0;
		for(Map.Entry<Angajat,Integer> entry : oreLucrateAngajati.entrySet())
		{
			Angajat a = entry.getKey();
		    Integer i = entry.getValue();
		    //calculam salariul pe ora, pe urma inmultit cu numarul de ore necesare fabricarii produsului
		    sum=sum+(a.getCm().getSalar()/(a.getCm().getNormaZilnica()*20)) *i;
		  
		}
		return sum;

	}
	public  Map<Angajat, Integer> getOrelucrateangajati() {
		return oreLucrateAngajati;
	}
	
	
	
}

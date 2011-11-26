package org.open.erp.services.ctbgen;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegBalanta {
	private static RegBalanta singleReference;

	private RegBalanta() {
		balante = new ArrayList<Balanta>();
	}

	public static RegBalanta instantiaza() {
		if (singleReference == null)
			singleReference = new RegBalanta();
		return singleReference;
	}

	private List<Balanta> balante;
	
	private static int contorId = 1;
	public void addBalanta(Balanta balanta) {
		if(balanta.getId()==-1){
			balanta.setId(contorId);
			contorId++;
		}
		if (!balante.contains(balanta)) {
			balante.add(balanta);
		}
	}
	public void addAll(List<Balanta> listBal){
		for(Balanta b:listBal){
			addBalanta(b);
		}
	}

	void removeBalanta(Balanta balanta) {
		balante.remove(balanta);
	}
	
	void removeBalanta(int id) {
		for(int i=0;i<balante.size();i++){
			if(balante.get(i).getId()==id)
				removeBalanta(balante.get(i));
		}
	}
	
	public List<Balanta> getBalantaLunaAnterioare(LunaLucru luna){
		List<Balanta> rez = new ArrayList<Balanta>();
		
		Calendar c = Calendar.getInstance();
		c.set(luna.getAn(), luna.getLuna(), 15);
		c.add(Calendar.MONTH, -1);
		Date lunaAnterioara_date = c.getTime();
		
		LunaLucru lunaAnterioara = RegLuniLucru.instantiaza().getLunaLucruDupa(lunaAnterioara_date);
		for(int i=0;i<balante.size();i++){
			if(balante.get(i).getLunaB().equals(lunaAnterioara))
				rez.add(balante.get(i));
		}
		
		Collections.sort(rez);//TODO: sortare dupa conturi
		return rez;
	}
	
	public List<Balanta> getBalantaLunaDeInchis(LunaLucru luna){
		List<Balanta> rez = new ArrayList<Balanta>();
		
		for(int i=0;i<balante.size();i++){
			if(balante.get(i).getLunaB().equals(luna))
				rez.add(balante.get(i));
		}
		
		Collections.sort(rez);//TODO: sortare dupa conturi
		return rez;
	}
	
	public void updateRegistru(List<Balanta> balanteModificate) {
		for (int i = 0; i < balante.size(); i++) {
			for (int j = 0; j < balanteModificate.size(); j++)
				if (balante.get(i).getId() == balanteModificate.get(j).getId()) {
					balante.set(i, balanteModificate.get(j));
				}
		}
		
		List<Balanta> deAnulat = getBalantaLunaDeInchis(balanteModificate.get(0).getLunaB());
		for(int i=0;i<deAnulat.size();i++){
			if(deAnulat.get(i).isAnulat()==true)
				removeBalanta(deAnulat.get(i).getId());
		}
	}
	
	public void anuleazaBalanta (LunaLucru luna){
		for (Balanta b : this.balante) {
			if (b.getLunaB() == luna)
				 b.setAnulat(true);
		}
	}
	
	//TODO: remove me
	public void printAll(){
		//System.out.println(balante.size());
		for(int i=0;i<balante.size();i++){
					System.out.println(balante.get(i).toString());
		}
	}
	
}

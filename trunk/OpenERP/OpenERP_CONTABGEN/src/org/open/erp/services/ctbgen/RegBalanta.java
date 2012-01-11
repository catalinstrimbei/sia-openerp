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

public class RegBalanta extends Registru{
	
	private RegBalanta() {
		sqlDefaultText = "SELECT o FROM Balanta o";
	}
	
	private static RegBalanta singleReference;

	public static RegBalanta instantiaza() {
		if (singleReference == null)
			singleReference = new RegBalanta();
		return singleReference;
	}
	
	public List<Balanta> getBalante() {
		@SuppressWarnings("unchecked")
		List<Balanta> result = em.createQuery(this.sqlDefaultText).getResultList();
		return result;
	}
	
	public List<Balanta> getBalanteLuna(LunaLucru luna) {
		@SuppressWarnings("unchecked")
		List<Balanta> result = em.createQuery("SELECT b FROM Balanta b where  b.lunaB = :lunn").setParameter("lunn", luna ).getResultList();
		return result;
	}
	
	public void addBalanta(Balanta balanta) {
		if (em.contains(balanta))
				em.merge(balanta);
		else
			em.persist(balanta);
		
		synchronize();
	}
	
	public void addAll(List<Balanta> listBal){
		for(Balanta b:listBal){
			if (em.contains(b))
				em.merge(b);
			else
				em.persist(b);
		}
		
		synchronize();
	}

	void removeBalanta(Balanta balanta) {
		em.remove(balanta);
		
		synchronize();
	}
	
	void removeBalanta(int id) {
		List<Balanta> balante=getBalante();
		for(int i=0;i<balante.size();i++){
			if(balante.get(i).getId()==id) {
				removeBalanta(balante.get(i));
				break;//e doar una
			}	
		}
	}
	
	public List<Balanta> getBalantaLunaAnterioare(LunaLucru luna){
		List<Balanta> rez = new ArrayList<Balanta>();
		
		Calendar c = Calendar.getInstance();
		c.set(luna.getAn(), luna.getLuna(), 15);
		c.add(Calendar.MONTH, -1);
		Date lunaAnterioara_date = c.getTime();
		
		LunaLucru lunaAnterioara = RegLuniLucru.instantiaza().getLunaLucruDupa(lunaAnterioara_date);
		List<Balanta> balante=getBalante();
		for(int i=0;i<balante.size();i++){
			if(balante.get(i).getLunaB().equals(lunaAnterioara))
				rez.add(balante.get(i));
		}
		
		Collections.sort(rez);//TODO: sortare dupa luni si conturi
		return rez;
	}
	
	public List<Balanta> getBalantaLunaDeInchis(LunaLucru luna){
		List<Balanta> rez = new ArrayList<Balanta>();
		List<Balanta> balante=getBalante();
		
		for(int i=0;i<balante.size();i++){
			if(balante.get(i).getLunaB().equals(luna))
				rez.add(balante.get(i));
		}
		
		Collections.sort(rez);//TODO: sortare dupa luni si conturi
		return rez;
	}
	
	public List<Balanta> getBalantaContParinte(Cont cont){
		List<Balanta> rez = new ArrayList<Balanta>();
		List<Balanta> balante=getBalante();
		
		for(int i=0;i<balante.size();i++){
			if(balante.get(i).getContB().equals(cont))
				rez.add(balante.get(i));
		}
		
		Collections.sort(rez);//TODO: sortare dupa luni si conturi
		return rez;
	}
	
	public void updateRegistru(List<Balanta> balanteModificate) {
		List<Balanta> balante=getBalante();
		
		for (int i = 0; i < balante.size(); i++) {
			for (int j = 0; j < balanteModificate.size(); j++)
				if (balante.get(i).getId() == balanteModificate.get(j).getId()) {
					balante.set(i, balanteModificate.get(j));
				}
		}
		
		synchronize();
		
		List<Balanta> deAnulat = getBalantaLunaDeInchis(balanteModificate.get(0).getLunaB());
		for(int i=0;i<deAnulat.size();i++){
			if(deAnulat.get(i).isAnulat()==true)
				removeBalanta(deAnulat.get(i).getId()); //e apelat intern syncronise
		}
	}
	
	public void anuleazaBalanta (LunaLucru luna){
		List<Balanta> balante=getBalante();
		
		for (Balanta b : balante) {
			if (b.getLunaB() == luna)
				 b.setAnulat(true);
		}
	}
	
	//TODO: remove me
	public void printAll(){
		//System.out.println(balante.size());
		List<Balanta> balante=getBalante();
		for(int i=0;i<balante.size();i++){
				System.out.println(balante.get(i).toString());
		}
	}
		
}

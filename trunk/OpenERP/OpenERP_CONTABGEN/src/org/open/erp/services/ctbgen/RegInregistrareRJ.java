package org.open.erp.services.ctbgen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Repository)
 * 
 */

public class RegInregistrareRJ extends Registru{
	private static RegInregistrareRJ singleReference;

	private RegInregistrareRJ() {
		sqlDefaultText = "SELECT x FROM InregistrareRJ x";
	}

	public static RegInregistrareRJ instantiaza() {
		if (singleReference == null)
			singleReference = new RegInregistrareRJ();
		return singleReference;
	}
	
	
	   public List<InregistrareRJ> getListaInreg(){
		   @SuppressWarnings("unchecked")
			List<InregistrareRJ> result = em.createQuery(this.sqlDefaultText).getResultList();
			return result;
	}
	
	public InregistrareRJ addInregistrareRJ(InregistrareRJ inregistrareRJ) {
		try{
			if (inregistrareRJ.getIdInregRJ() == null || 
				em.find(inregistrareRJ.getClass(), inregistrareRJ.getIdInregRJ()) == null)
			{
				em.persist(inregistrareRJ);
				//System.out.println("add "+tip.getDenumireTip());
			}
			else{
				em.merge(inregistrareRJ);
				//System.out.println("merge "+tip.getDenumireTip());
				}
			
		}catch(Exception ex){
			System.out.println("EROARE PERSISTENTA *****add TIP "+ ex.getMessage());
			//ex.printStackTrace();
			
		}

	
	return inregistrareRJ;
	}

	public void removeInregistrareRJ(InregistrareRJ inregistrareRJ) {
		em.remove(inregistrareRJ);
		
	}
	
	   public List<InregistrareRJ> getInregLuna(LunaLucru luna){
		   @SuppressWarnings("unchecked")
			List<InregistrareRJ> result = em.createQuery(this.sqlDefaultText+" WHERE x.lunaCurs = :luna").setParameter("luna", luna ).getResultList();
			return result;
	}
	
	
	public List<InregistrareRJ> getInregistrariLunaDeInchis(LunaLucru luna){
		List<InregistrareRJ> rez = new ArrayList<InregistrareRJ>();
		List<InregistrareRJ> inregistrariRJ = getListaInreg();
		
		for(int i=0;i<inregistrariRJ.size();i++){
			if(inregistrariRJ.get(i).getLunaCurs().equals(luna))// && !inregistrariRJ.get(i).isAnulat())
				rez.add(inregistrariRJ.get(i));
		}
		
		Collections.sort(rez);
		return rez;
	}
	
 

	public void  anuleazaIregRJ(Integer id){
		List<InregistrareRJ> inregistrariRJ = getListaInreg();
		
		for(int i=0;i<inregistrariRJ.size();i++){
			if (inregistrariRJ.get(i).getIdInregRJ()==id){
				inregistrariRJ.get(i).anuleazaInreg();
			}
		}
		
		//synchronize();//pt ca au fost facute modificari la un/mai multe managed objects
	}
	
	
	
}

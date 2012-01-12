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
		sqlDefaultText = "SELECT o FROM InregistrariJurnal o";
	}

	public static RegInregistrareRJ instantiaza() {
		if (singleReference == null)
			singleReference = new RegInregistrareRJ();
		return singleReference;
	}
	
	public void addInregistrareRJ(InregistrareRJ inregistrareRJ) {
		if (em.contains(inregistrareRJ))
			em.merge(inregistrareRJ);
		else
			em.persist(inregistrareRJ);
	
		synchronize();
	}

	public void removeInregistrareRJ(InregistrareRJ inregistrareRJ) {
		em.remove(inregistrareRJ);
		
		synchronize();
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
    public List<InregistrareRJ> getListaInreg(){
        List<InregistrareRJ> rez = new ArrayList<InregistrareRJ>();
        List<InregistrareRJ> inregistrariRJ = getListaInreg();
        
        for(int i=0;i<inregistrariRJ.size();i++){
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
		
		synchronize();//pt ca au fost facute modificari la un/mai multe managed objects
	}
	
	
	
}

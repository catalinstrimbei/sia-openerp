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

public class RegInregistrareRJ {
	private static RegInregistrareRJ singleReference;

	private RegInregistrareRJ() {
		inregistrariRJ = new ArrayList<InregistrareRJ>();
	}

	public static RegInregistrareRJ instantiaza() {
		if (singleReference == null)
			singleReference = new RegInregistrareRJ();
		return singleReference;
	}

	private List<InregistrareRJ> inregistrariRJ;
	
	private static int contorId = 1;
	public void addInregistrareRJ(InregistrareRJ inregistrareRJ) {
		if(inregistrareRJ.getIdInregRJ()==-1){
			inregistrareRJ.setIdInregRJ(contorId);
			contorId++;
		}
		
		if (!inregistrariRJ.contains(inregistrareRJ)) {
			inregistrariRJ.add(inregistrareRJ);
		}
	}

	public void removeInregistrareRJ(InregistrareRJ inregistrareRJ) {
		inregistrariRJ.remove(inregistrareRJ);
	}
	
	public List<InregistrareRJ> getInregistrariLunaDeInchis(LunaLucru luna){
		List<InregistrareRJ> rez = new ArrayList<InregistrareRJ>();
		
		for(int i=0;i<inregistrariRJ.size();i++){
			if(inregistrariRJ.get(i).getLunaCurs().equals(luna))// && !inregistrariRJ.get(i).isAnulat())
				rez.add(inregistrariRJ.get(i));
		}
		
		Collections.sort(rez);
		return rez;
	}
    public List<InregistrareRJ> getListaInreg(){
        List<InregistrareRJ> rez = new ArrayList<InregistrareRJ>();
        
        for(int i=0;i<inregistrariRJ.size();i++){
                rez.add(inregistrariRJ.get(i));
        }
        
        Collections.sort(rez);
        return rez;
}

	public void  anuleazaIregRJ(Integer id){
			
		for(int i=0;i<inregistrariRJ.size();i++){
			if (inregistrariRJ.get(i).getIdInregRJ()==id){
				inregistrariRJ.get(i).anuleazaInreg();
			}
		}
		
		
	
	}
	
	
	
}

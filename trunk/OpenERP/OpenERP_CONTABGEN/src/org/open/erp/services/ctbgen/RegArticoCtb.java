package org.open.erp.services.ctbgen;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Echipa ContaGen
 * 
 * @BusinessObject(Repository)
 * 
 */
public class RegArticoCtb extends Registru{
	private static RegArticoCtb singleReference;

	private RegArticoCtb() {
		sqlDefaultText = "SELECT o FROM Articole_Inregistrari o";
	}

	public static RegArticoCtb instantiaza() {
		if (singleReference == null)
			singleReference = new RegArticoCtb();
		return singleReference;
	}
	
	public List<ArticolCtb> getArticole() { 
		@SuppressWarnings("unchecked")
		List<ArticolCtb> result = em.createQuery(this.sqlDefaultText).getResultList();
		return result;
	}
	

	public ArticolCtb getArticolDupaId(Integer idArt) {
		List<ArticolCtb>listaArticole=getArticole();
		
		for (ArticolCtb a : listaArticole) {
			if (idArt.equals(a.getIdArt())){
				return a;
			}
		}
		return null;
	}

	
	public List<ArticolCtb> getArticoleInreg(Integer idInreg) {
		List<ArticolCtb> artInr = new ArrayList<ArticolCtb>();
		List<ArticolCtb>listaArticole=getArticole();
		for (ArticolCtb a : listaArticole) {
			if (idInreg.equals(a.getInregRJ().getIdInregRJ())){
				artInr.add(a);
			}
		}
		return artInr;
	}
	
	public List<ArticolCtb> getArticoleContD(Integer idCont) {
		List<ArticolCtb> artCont = new ArrayList<ArticolCtb>();
		List<ArticolCtb>listaArticole=getArticole();
		for (ArticolCtb a : listaArticole) {
			if (idCont.equals(a.getContDebit())){
				artCont.add(a);
			}
		}
		return artCont;
	}
	public List<ArticolCtb> getArticoleContC(Integer idCont) {
		List<ArticolCtb> artCont = new ArrayList<ArticolCtb>();
		List<ArticolCtb>listaArticole=getArticole();
		for (ArticolCtb a : listaArticole) {
			if (idCont.equals(a.getContCredit())){
				artCont.add(a);
			}
		}
		return artCont;
	}
	

	public void addArticol(ArticolCtb art) {
		if (em.contains(art))
			em.merge(art);
		else
			em.persist(art);
	
		synchronize();
	}

	public void removeArticol(ArticolCtb art) {
		em.remove(art);
		
		synchronize();
	}

	

}

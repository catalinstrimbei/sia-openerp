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


public class RegTipuriContabile {
	private static RegTipuriContabile singleReference;

	private RegTipuriContabile() {
		listaTipuri = new ArrayList<TipContabil>();
	}

	public static RegTipuriContabile instantiaza() {
		if (singleReference == null)
			singleReference = new RegTipuriContabile();
		return singleReference;
	}
	
	private List<TipContabil> listaTipuri;
	private static int contorId = 1;
	
	public void addTipContabil(TipContabil tip) {
		if(tip.getIdTipContabil()==-1){
			tip.setIdTipContabil(contorId);
			contorId++;
		}
		
		if (!listaTipuri.contains(tip)) {
			listaTipuri.add(tip);
		}
	}

	public void removeTipContabil(TipContabil tip) {
		listaTipuri.remove(tip);
	}
	
	// TODO: remove me
	public void printAll() {
		for (int i = 0; i < listaTipuri.size(); i++) {
			System.out.println(listaTipuri.get(i).toString());
		}
	}
	
	public TipContabil getTipContabilDupa(Integer idTipContabil) {
		for (TipContabil t : listaTipuri) {
			if (idTipContabil == t.getIdTipContabil()) {
				return t;
			}
		}
		return null;
	}

	public TipContabil getTipDupaDen(String denumire) {
		for (TipContabil t : listaTipuri) {
			if (denumire.equals(t.getDenumireTip())) {
				return t;
			}
		}
		return null;
	}
	
	public List<String> getTipuriContabile() {
		List<String> rez = new ArrayList<String>();
		for (TipContabil t : listaTipuri) {
			rez.add(t.getDenumireTip());
		}
		return rez;
	}
}

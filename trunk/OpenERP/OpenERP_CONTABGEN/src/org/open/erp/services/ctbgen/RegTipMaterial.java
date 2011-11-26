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


public class RegTipMaterial {
	private static RegTipMaterial singleReference;

	private RegTipMaterial() {
		listaTipuri = new ArrayList<TipContabil>();
	}

	public static RegTipMaterial instantiaza() {
		if (singleReference == null)
			singleReference = new RegTipMaterial();
		return singleReference;
	}
	
	private List<TipContabil> listaTipuri;
	
	public void addTipMaterial(TipContabil tip) {
		if (!listaTipuri.contains(tip)) {
			listaTipuri.add(tip);
		}
	}

	public void removeTipMaterial(TipContabil tip) {
		listaTipuri.remove(tip);
	}
	
	// TODO: remove me
	public void printAll() {
		for (int i = 0; i < listaTipuri.size(); i++) {
			System.out.println(listaTipuri.get(i).toString());
		}
	}
}

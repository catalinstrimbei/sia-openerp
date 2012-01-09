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


public class RegTipuriContabile extends Registru{
	private static RegTipuriContabile singleReference;

	private RegTipuriContabile() {
		sqlDefaultText = "SELECT o FROM TipContabil o";
	}

	public static RegTipuriContabile instantiaza() {
		if (singleReference == null)
			singleReference = new RegTipuriContabile();
		return singleReference;
	}
	
	public List<TipContabil> getTipuriCbt() {
		@SuppressWarnings("unchecked")
		List<TipContabil> result = em.createQuery(this.sqlDefaultText).getResultList();
		return result;
	}
	
	public void addTipContabil(TipContabil tip) {
		if (em.contains(tip))
			em.merge(tip);
		else
			em.persist(tip);

		synchronize();
	}

	public void removeTipContabil(TipContabil tip) {
		em.remove(tip);
		
		synchronize();
	}
	
	// TODO: La majoritatea astea mergea si cu JSQL
	public void printAll() {
		List<TipContabil> listaTipuri=getTipuriCbt();
		for (int i = 0; i < listaTipuri.size(); i++) {
			System.out.println(listaTipuri.get(i).toString());
		}
	}
	
	public TipContabil getTipContabilDupa(Integer idTipContabil) {
		List<TipContabil> listaTipuri=getTipuriCbt();
		
		for (TipContabil t : listaTipuri) {
			if (idTipContabil == t.getIdTipContabil()) {
				return t;
			}
		}
		return null;
	}

	public TipContabil getTipDupaDen(String denumire) {
		List<TipContabil> listaTipuri=getTipuriCbt();
		
		for (TipContabil t : listaTipuri) {
			if (denumire.equals(t.getDenumireTip())) {
				return t;
			}
		}
		return null;
	}
	
	public List<String> getTipuriContabile() {
		List<TipContabil> listaTipuri=getTipuriCbt();
		List<String> rez = new ArrayList<String>();
		
		for (TipContabil t : listaTipuri) {
			rez.add(t.getDenumireTip());
		}
		return rez;
	}
}

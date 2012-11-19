package org.open.erp.services.finplati.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.open.erp.services.finplati.*;
import org.open.erp.services.proman.impl.ProjectManagementImpl;

public class FinanciarPlatiImpl implements FinanciarPlatiSrv {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FinanciarPlatiImpl.class.getName());
	
	SituatieFinanciara sitFit;
	
	public FinanciarPlatiImpl() {
		if (sitFit == null)
			sitFit = new SituatieFinanciara();
	}

	@Override
	public Double getSumePlatite(Date cDate) {
		logger.debug("1.1. Gestionare sume platite prin banca");
		return sitFit.getTotalPlati(cDate);
	}

	@Override
	public void setBugetDatorii(Double buget) {
		logger.debug("1.2. Alocare buget pentru datorii");
		sitFit.setBugetDatorii(buget);
	}

	@Override
	public Double getSolduriFacturi() {
		logger.debug("1.3. Afisare solduri facturi");
		return sitFit.getSolduriFacturi();
	}

	@Override
	public Contract createContractFurnizor(Furnizor furnizor, Double total,
			Plata avans) {
		logger.debug("2.1. Incheiere contract cu furnizorul");
		Contract contract = new Contract();
		contract.setFurnizor(furnizor);
		contract.setValoareContract(total);
		Date dataAzi = new Date();
		contract.setDataContract(dataAzi);
		if (avans != null)
			contract.adaugaPlata(avans);
		
		sitFit.adaugareContract(contract);
		
		return contract;
	}
	
	@Override
	public void inregistrarePlataAvans(Contract contract, Plata plata) {
		logger.debug("2.2. Inregistrare suma in avans");
		contract.adaugaPlata(plata);
	}
	
	@Override 
	public Double afisareDiscountAcordat(Contract contract) {
		logger.debug("2.3. Discountul acordat");
		Double dsc = contract.getDiscountContract();
		Double val = contract.getValoareContract();
		Double discount = dsc * val;
		
		return discount;
	}
	
	@Override
	public Double afisareSituatie(Contract contract) {
		logger.debug("2.4  Afisare situatie");
		Double remaining = contract.getValoareContract() * (1 - contract.getDiscountContract() ) - contract.getTotalPlati();
		return remaining;
	}
		
	@Override
	public List<Persoana> afisareListaPersonal() {
		logger.debug("3.1. Initiere efectuare plata");
		return sitFit.getListaPersonal();
	}
	
	@Override
	public void stabilireResponsabilPlata() {
		logger.debug("3.2. Stabilire responsabil plata");
		List<Persoana> listaPersonal =  this.afisareListaPersonal();
		int scorMax = 0;
		int position = 0;
		for (int i=0; i<listaPersonal.size(); i++) {
			if (listaPersonal.get(i).getScorAptitudini() > scorMax) {
				position = i;
				scorMax = listaPersonal.get(i).getScorAptitudini();
			}
		}
		sitFit.setResponsabil(listaPersonal.get(position));	
	}
	
	@Override
	public Map<TipPlata,List<Plata>> clasificarePlati() {
		logger.debug("3.3. Clasificare plati ( furnizori / datorii )");
		Map<Integer, Plata> toatePlatile = sitFit.getPlati();
		
		List<Plata> platiFurnizor = new ArrayList<Plata>();
		List<Plata> platiDatorii = new ArrayList<Plata>();
		List<Plata> altePlati = new ArrayList<Plata>();
		
		Iterator<Plata> plataIter = toatePlatile.values().iterator();
		while (plataIter.hasNext()) {
			Plata p = plataIter.next();
			if (p.getTipPlata() == TipPlata.FURNIZOR)
				platiFurnizor.add(p);
			else if (p.getTipPlata() == TipPlata.DATORIE)
				platiDatorii.add(p);
			else 
				altePlati.add(p);
		}
		Map<TipPlata,List<Plata>> tipuriPlati = new HashMap<TipPlata, List<Plata>>();
		
		tipuriPlati.put(TipPlata.FURNIZOR, platiFurnizor);
		tipuriPlati.put(TipPlata.DATORIE, platiDatorii);
		tipuriPlati.put(TipPlata.ALTTIP, altePlati);
		
		return tipuriPlati;
		
	}

	@Override
	public void procesarePlata(Furnizor furnizor, Double valoarePlata) {
		logger.debug("3.4. Procesare/onorare plata catre furnizori");
		Plata plata = new Plata();
		plata.setDataPlatii(new Date());
		plata.setValoarePlata(valoarePlata);
		plata.setTipPlata(TipPlata.FURNIZOR);
		plata.setModPlata(ModPlata.VIRAMENTBANCAR); // demonstrativ
		
		sitFit.adaugarePlata(plata);
		furnizor.adaugarePlata(plata);
	}
	
	@Override
	public Boolean verificarePlata(Furnizor furnizor, Plata plata) {
		logger.debug("3.5. Verificare desfasurare plata");
		return furnizor.verificaPlata(plata);
	}
	
	@Override
	public void procesarePlata(Double valoarePlata) {
		logger.debug("4.1 Efectuare plata pt datorii");
		Plata plata = new Plata();
		plata.setDataPlatii(new Date());
		plata.setValoarePlata(valoarePlata);
		plata.setTipPlata(TipPlata.DATORIE);
		plata.setModPlata(ModPlata.CASH); // demonstrativ
		
		sitFit.adaugarePlata(plata);
	}
	
	@Override
	public Chitanta primireChitanta(Double valoarePlata) {
		logger.debug("4.2. Primire chitanta");
		Plata plata = new Plata();
		plata.setDataPlatii(new Date());
		plata.setValoarePlata(valoarePlata);
		plata.setTipPlata(TipPlata.ALTTIP);
		plata.setModPlata(ModPlata.CASH); // demonstrativ
		
		return sitFit.adaugarePlata(plata);
	}
	
	@Override
	public Double afisareSituatiePlati() {
		logger.debug("4.3. Afisare situatie");
		
		Double platiTotale = 0.0;
		Iterator<Plata> platiIter = sitFit.getPlati().values().iterator();
		while (platiIter.hasNext()) {
			platiTotale += platiIter.next().getValoarePlata();
		}
		
		return platiTotale;
	}
	
	@Override
	public Double afisareDatorii() {
		logger.debug("5.1. Urmarire datorii ramase");
		Iterator<Factura> iterFacturi = sitFit.getFacturi().values().iterator();
		Iterator<Contract> iterContracte = sitFit.getContracte().values().iterator();
		
		Double totalDatorii = 0.0;
		while (iterFacturi.hasNext()) {
			Factura f = iterFacturi.next();
			totalDatorii += f.getValoareTotala() - f.getValoareAchitata();
		}
		
		while (iterContracte.hasNext()) {
			Contract c = iterContracte.next();
			totalDatorii += c.getValoareContract() * (1- c.getDiscountContract()) - c.getTotalPlati();
		}
		
		return totalDatorii;
	}

	@Override
	public Double afisarePlatiTotale() {
		logger.debug("5.2. Urmarire situatie plati");
		
		Iterator<Plata> iterPlati = sitFit.getPlati().values().iterator();
		
		Double totalPlati = 0.0;
		while (iterPlati.hasNext()) {
			totalPlati += iterPlati.next().getValoarePlata();
		}
		return totalPlati;
	}
	
	@Override
	public Double afisareSold() {
		logger.debug("5.3. Interogare sold");
		
		Double sold = sitFit.getBugetDatorii() - afisareDatorii();
		return sold;
	}
}

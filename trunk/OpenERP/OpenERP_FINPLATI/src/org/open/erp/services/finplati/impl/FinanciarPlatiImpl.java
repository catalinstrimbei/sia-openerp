

package org.open.erp.services.finplati.impl;

import org.open.erp.services.achizitii.AchizitiiSrv;
import org.open.erp.services.banci.BanciSrv;
import org.open.erp.services.finplati.FacturaStatus;
import org.open.erp.services.finplati.FurnizorContract;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.finplati.*;
import org.open.erp.services.nomgen.NomenclatoareSrv;


/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FinanciarPlatiImpl implements FinanciarPlatiSrv, FinanciarPlatiSrvLocal {
	//private AchizitiiSrv achizitiiSrv;

	//Dependente resurse proprii
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FinanciarPlatiImpl.class.getName());
	
	//Dependente resurse injectate
			@PersistenceContext(unitName="OpenERP_FINPLATI")
			private EntityManager em;
		//public AchizitiiSrv getAchizitiiSrv() {
			//return achizitiiSrv;
		//}
			
			//Initializare
		//	public FinanciarPlatiImpl() { }
	
	//@EJB(lookup="java:global/OpenERP_ACHIZITII/AchizitiiImpl!org.open.erp.services.achizitii.AchizitiiSrv")
	//private AchizitiiSrv achizitiiSrv;
	
	//@EJB(lookup="java:global/OpenERP_BANCI/BanciImpl!org.open.erp.services.banci.BanciSrv")
	//private BanciSrv banciSrv;
	
	//@EJB(lookup="java:global/OpenERP_NOMGEN/NomenclatoareImpl!org.open.erp.services.personal.NomenclatoareSrv")
	//private NomenclatoareSrv nomgenSrv;
	
	
		//public void setNomgenSrv(NomenclatoareSrv nomgenSrv) {
		//this.nomgenSrv = nomgenSrv;
		//}
	

 //public void setAchizitiiSrv(AchizitiiSrv achizitiiiSrv) {
	//	this.achizitiiSrv = achizitiiSrv;
	//}
	
	SituatieFinanciara sitFit;
	
	public FinanciarPlatiImpl() {
		if (sitFit == null)
			sitFit = new SituatieFinanciara();
	}
	
	@Override
	public void setAchizitii(AchizitiiSrv achizitiiSrv) {
		
	}

	@Override
	public SituatieFinanciara getSituatieFinanciara() {
		return sitFit;
	}
	
	@Override
	public void setSituatieFinanciara(SituatieFinanciara sitFit) {
		this.sitFit = sitFit;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
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
	public Double getSolduriFactura() {
		logger.debug("1.3. Afisare solduri facturi");
		return sitFit.getSoldurifactura();
	}

	@Override
	public Contract createContractFurnizor(FurnizorContract furnizor, Double total,
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
	public Contract cautaContractFurnizor(Integer idContract) {
		if (sitFit.getContracte().containsKey(idContract))
			return sitFit.getContracte().get(idContract);
		else	
			return null;
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
	public Plata procesarePlata(FurnizorContract furnizor, Double valoarePlata) {
		logger.debug("3.4. Procesare/onorare plata catre furnizori");
		Plata plata = new Plata();
		plata.setDataPlatii(new Date());
		plata.setValoarePlata(valoarePlata);
		plata.setTipPlata(TipPlata.FURNIZOR);
		plata.setModPlata(ModPlata.VIRAMENTBANCAR); // demonstrativ
		
		sitFit.adaugarePlata(plata);
		furnizor.adaugarePlata(plata);
		
		return plata;
	}
	
	@Override
	public Boolean verificarePlata(FurnizorContract furnizor, Plata plata) {
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
	public ChitantaPlata primireChitanta(Double valoarePlata) {
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
		Iterator<FacturaStatus> iterFactura = sitFit.getfactura().values().iterator();
		Iterator<Contract> iterContracte = sitFit.getContracte().values().iterator();
		
		Double totalDatorii = 0.0;
		while (iterFactura.hasNext()) {
			FacturaStatus f = iterFactura.next();
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

	@Override
	public double getBugetDatorii() {
		return this.sitFit.getBugetDatorii();
	}
}

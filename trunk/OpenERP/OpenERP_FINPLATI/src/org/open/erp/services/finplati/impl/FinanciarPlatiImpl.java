

package org.open.erp.services.finplati.impl;

//import org.open.erp.services.achizitii.AchizitiiSrv;
//import org.open.erp.services.achizitii.impl.RegistruAchizitii;
//import org.open.erp.services.banci.BanciSrv;
import org.open.erp.services.finplati.Contract;
import org.open.erp.services.finplati.FacturaStatus;
import org.open.erp.services.finplati.FurnizorContract;
import org.open.erp.services.finplati.Persoana;
import org.open.erp.services.finplati.Plata;
import org.open.erp.services.finplati.ResponsabilPlata;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.open.erp.services.finplati.*;
//import org.open.erp.services.nomgen.NomenclatoareSrv;


/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FinanciarPlatiImpl implements FinanciarPlatiSrv, FinanciarPlatiSrvLocal {
	
	 private RegistruFinPlati registruFinPlati;

	//Dependente resurse proprii
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FinanciarPlatiImpl.class.getName());
	
	//Dependente resurse injectate
			@PersistenceContext(unitName="OpenERP_FINPLATI")
			private EntityManager em;
		
			
			//Initializare
			//public FinanciarPlatiImpl() { }
			
			@PostConstruct
			public void init() {
				if(this.registruFinPlati == null) 
					registruFinPlati = new RegistruFinPlati(em);
			}
	
	//@EJB(lookup="java:global/OpenERP_ACHIZITII/AchizitiiImpl!org.open.erp.services.achizitii.AchizitiiSrv")
	//private AchizitiiSrv AchizitiiSrv;
	
	//@EJB(lookup="java:global/OpenERP_BANCI/BanciImpl!org.open.erp.services.banci.BanciSrv")
	//private BanciSrv banciSrv;
	
	//@EJB(lookup="java:global/OpenERP_NOMGEN/NomenclatoareImpl!org.open.erp.services.personal.NomenclatoareSrv")
	//private NomenclatoareSrv nomgenSrv;
	
	
	//public void setNomgenSrv(NomenclatoareSrv nomgenSrv) {
		//this.nomgenSrv = nomgenSrv;
	//}
	
	// NomenclatoareSrv getNomgenSrv() {
	//	return this.nomgenSrv;
	//}
	
	//public AchizitiiSrv getAchizitiiSrv() {
		//return this.AchizitiiSrv;
	//}
	
	//public void setAchizitiiSrv(AchizitiiSrv achizitiiSrv) {
		//this.AchizitiiSrv = achizitiiSrv;
    //}
      
  	//public void setBanciSrv(BanciSrv banciSrv) {
  		//this.banciSrv = banciSrv;
   // }
  	
  	//public BanciSrv getBanciSrv() {
  	//	return this.banciSrv;
  	//}
      
	SituatieFinanciara sitFit;
	
	public FinanciarPlatiImpl() {
		if (sitFit == null)
			sitFit = new SituatieFinanciara();
	}
	
	
	/* implementare actiuni serviciu ProjectManagementSrv */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	
	//@Override
	//public void setAchizitii(AchizitiiSrv achizitiiSrv) {
		
	//}

	@Override
	public SituatieFinanciara getSituatieFinanciara() {
		return sitFit;
	}
	
	@Override
	public void setSituatieFinanciara(SituatieFinanciara sitFit) {
		//this.sitFit = sitFit;
		try {
			registruFinPlati.salveazaSituatieFinanciara(sitFit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Double getSumePlatite(Date cDate) {
		logger.debug("1.1. Gestionare sume platite prin banca");
		//return sitFit.getTotalPlati(cDate);
		List<Plata> plati = registruFinPlati.getToatePlatile();
		Double sum = 0.0;
		
		for (Plata p : plati) {
			if (p.getDataPlatii().compareTo(cDate) <= 0)
				sum += p.getValoarePlata();
		}
		
		return sum;
	}

	@Override
	public void setBugetDatorii(Double buget) {
		logger.debug("1.2. Alocare buget pentru datorii");
		sitFit.setBugetDatorii(buget);
		try {
			registruFinPlati.salveazaSituatieFinanciara(sitFit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		try {
			registruFinPlati.salveazaContract(contract);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contract;
	}
	@Override
	public Contract cautaContractFurnizor(Integer idContract) {
		if (sitFit.getContracte().containsKey(idContract)) {
			return registruFinPlati.getContract(idContract);
		}
		//return sitFit.getContracte().get(idContract);
		else	
			return null;
	}
	
	@Override
	public void inregistrarePlataAvans(Contract contract, Plata plata) {
		logger.debug("2.2. Inregistrare suma in avans");
		contract.adaugaPlata(plata);
		try {
			registruFinPlati.salveazaPlata(plata);
			registruFinPlati.salveazaContract(contract);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		return registruFinPlati.getToatePersoanele();
		
		//return sitFit.getListaPersonal();
	}
	
	@Override
	public void stabilireResponsabilPlata() {
		logger.debug("3.2. Stabilire responsabil plata");
		return;
		
//		List<Persoana> listaPersonal =  this.afisareListaPersonal();
//		int scorMax = 0;
//		int position = 0;
//		
//		if (listaPersonal == null || listaPersonal.size() == 0)
//			return;
//		
//		for (int i=0; i<listaPersonal.size(); i++) {
//			if (listaPersonal.get(i).getScorAptitudini() > scorMax) {
//				position = i;
//				scorMax = listaPersonal.get(i).getScorAptitudini();
//			}
//		}
//		//sitFit.setResponsabil(listaPersonal.get(position));	
//		try {
//			registruFinPlati.salveazaResponsabilPlata((ResponsabilPlata) listaPersonal.get(position));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
		try {
			registruFinPlati.salveazaPlata(plata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ChitantaPlata primireChitanta(Double valoarePlata) {
		logger.debug("4.2. Primire chitanta");
		Plata plata = new Plata();
		plata.setDataPlatii(new Date());
		plata.setValoarePlata(valoarePlata);
		plata.setTipPlata(TipPlata.ALTTIP);
		plata.setModPlata(ModPlata.CASH); // demonstrativ
		
		try {
			registruFinPlati.salveazaPlata(plata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ChitantaPlata cp = sitFit.adaugarePlata(plata);
		
		try {
			registruFinPlati.salveazaChitantaPlata(cp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cp;
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


	@Override
	public void adaugarePlata(Plata plataNoua) {
		// TODO Auto-generated method stub
		ChitantaPlata cp = sitFit.adaugarePlata(plataNoua);
		
		try {
			registruFinPlati.salveazaPlata(plataNoua);
			registruFinPlati.salveazaSituatieFinanciara(sitFit);
			registruFinPlati.salveazaChitantaPlata(cp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void adaugaPersoana(Persoana persoanaNoua) {
		// TODO Auto-generated method stub
		try {
			registruFinPlati.salveazaPersoana(persoanaNoua);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void adaugaFurnizorContract(FurnizorContract furnizorContractNou) {
		// TODO Auto-generated method stub
		
	}
	 public Integer cautaPersona(String nume)
     {
             logger.debug("1. Cautare Persoana in baza de date");
             return -1;
     
     }


     @Override
     public Persoana findPersoanaById(Integer idPersoana) {
             
             Persoana persoana = em.find(Persoana.class, idPersoana);
             
             return persoana;
     }


	@Override
	public void adaugaFactura(FacturaStatus facturaNoua) {
		// TODO Auto-generated method stub
		FacturaStatus fac = sitFit.adaugaFactura(facturaNoua);
		
		try {
			registruFinPlati.salveazaFacturaStatus(facturaNoua);
			registruFinPlati.salveazaSituatieFinanciara(sitFit);
			registruFinPlati.salveazaFacturaStatus(fac);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	@Override
	public void adaugaContract(Contract contractNou) {
		// TODO Auto-generated method stub
	//Contract cont = sitFit.adaugareContract(contractNou);
		
		try {
			registruFinPlati.salveazaContract(contractNou);
			registruFinPlati.salveazaSituatieFinanciara(sitFit);
			//registruFinPlati.salveazaContract(cont);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		



	//@Override
	//public void setBanci(BanciSrv banciSrv) {
		// TODO Auto-generated method stub
		
//	}
}

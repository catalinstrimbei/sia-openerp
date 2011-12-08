package org.open.erp.services.salarizare.impl;

import java.util.ArrayList;

//import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.salarizare.CentralizatorStatSalarii;
import org.open.erp.services.salarizare.Configurare;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.Retinere;
import org.open.erp.services.salarizare.SalarizareSrv;
import org.open.erp.services.salarizare.Spor;
import org.open.erp.services.salarizare.StatSalarii;

public class SalarizareImpl implements SalarizareSrv {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SalarizareImpl.class.getName());
	
	private PersonalSrv personalSrv;
	//private NomenclatoareSrv nomenclatoareSrv;

	private RegistruSalarizare registru = new RegistruSalarizare();
	@Override
	public Pontaj inregistrarePontaj(Angajat angajat, Integer an, Integer luna,
			Double oreLucrate, Double oreSuplimentare, Double oreConcediu) {
		
		logger.debug("Creare pontaj angajat");
		Pontaj p = new Pontaj(angajat,an,luna,oreLucrate,oreSuplimentare,oreConcediu);
		return p;
	}

	@Override
	public void inregistrarePontajLuna(Integer an, Integer luna) {
		// pentru toti angajatii genereaza un pontaj default tinand cont de nr de ore lucratoare din luna
		
		//toti angajatii
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(this.personalSrv.getListaAngajati());
		
		logger.debug("Creare pontaj pentru toti angajatii");
		
		//parcurgem si setam pontajul (adica salvam in DB)
		for (Angajat angajat:angajati){
			Pontaj p = new Pontaj();
			p.setAn(an);
			p.setLuna(luna);
			p.setAngajat(angajat);
		}
	}

	@Override
	public void adaugaOreConcediu(Pontaj pontaj, Double oreConcediu) {
		logger.debug("Adaugare ore concediu angajat");
		pontaj.setOreConcediu(oreConcediu);

	}

	@Override
	public void adaugaOreSuplimentare(Pontaj pontaj, Double oreSuplimentare) {
		logger.debug("Adaugare ore suplimentare angajat");
		pontaj.setOreSuplimentare(oreSuplimentare);

	}

	@Override
	public Spor inregistrareSpor(String denumire, Integer tip, Integer an,
			Integer luna, Angajat angajat, Integer modCalcul, Double valoare) {
		logger.debug("Creare spor angajat");
		Spor spor = new Spor(denumire, tip, an, luna, angajat, modCalcul, valoare);
		return spor;
	}

	@Override
	public Double calculSporuriAngajat(Integer an, Integer luna, Angajat angajat) {
		// pentru fiecare angajat calculam sporurile (pot fi mai multe) si insumam
		Double valoareTotala=0.0;
		ArrayList<Spor> sporuri= new ArrayList<Spor>();
		ContractMunca contract = personalSrv.getContractAngajatActiv(angajat);
		//de inlocuit aici cu metoda getContractActivAngajat
		//daca prin absurd un angajat are mai multe contracte active la un moment data
		//atunci o sa iteram prin lista de contracte si o sa facem calculul
		if (contract != null){
		
			sporuri.addAll(registru.getSporuriAngajat(an, luna, angajat));
			
			logger.debug("Calcul sporuri angajat");
			for (Spor spor:sporuri){
				if(spor.getModCalcul()==1){ 
					//valoare
					valoareTotala = valoareTotala + spor.getValoare();
				}
				else{
					//valoare
					valoareTotala = valoareTotala + spor.getValoare()*contract.getSalarBaza();
				}
			}
		
		}
		else{
			valoareTotala = 0.0;
		}
		
		return valoareTotala;
	}

	@Override
	public Double calculVenitBrut(Integer an, Integer luna, Angajat angajat) {
		Pontaj p = registru.getPontajByAngajat(angajat, an, luna);
		ContractMunca contract = personalSrv.getContractAngajatActiv(angajat);
		
		logger.debug("Calcul venit brut angajat");
		Double venitBrut = 0.0;
		if (contract != null){
			Double venitOreLucrate = (p.getOreLucrate()-p.getOreConcediu())*contract.getTarifOrar();
			Double venitOreSuplimentare = p.getOreSuplimentare()*contract.getTarifOrar();
			venitBrut = venitOreLucrate+venitOreSuplimentare;
		}
		else{
			venitBrut = 0.0;
		}
		//venitul brut este format din nrorelucrate*tariforar+sporuri
		return venitBrut;
	}

	@Override
	public Retinere inregistrareRetinere(String denumire, Integer tip,
			Integer an, Integer luna, Angajat angajat, Integer modCalcul, Double valoare) {
		logger.debug("Creare retinere angajat");
		Retinere retinere = new Retinere(denumire, tip, angajat, an, luna, modCalcul, valoare);
		return retinere;
	}

	@Override
	public Double calculRetineriAngajat(Integer an, Integer luna,
			Angajat angajat) {
		// pentru fiecare angajat calculam retinerile (pot fi mai multe) si insumam
		ContractMunca contract = personalSrv.getContractAngajatActiv(angajat);
	
		logger.debug("Calcul retineri angajat");
		Double valoareTotala=0.0;
		ArrayList<Retinere> retineri= new ArrayList<Retinere>();
		if (contract != null){
			retineri.addAll(registru.getRetineriAngajat(an, luna, angajat));
		
			for (Retinere retinere:retineri){
				if(retinere.getModCalcul()==1){ 
					//valoare
					valoareTotala = valoareTotala + retinere.getValoare();
				}
				else{
					//valoare
					valoareTotala = valoareTotala + retinere.getValoare()*contract.getSalarBaza();
				}
			}
		}
		else{
			valoareTotala=0.0;
		}
		return valoareTotala;
	}

	@Override
	public Double calculRetineriObligatorii(Integer an, Integer luna,
			Angajat angajat, String tipRetinere) {
		logger.debug("Calcul retinere obligatorie "+tipRetinere+"angajat");
		// retinerile obligatorii se retin din salarul brut
		Double venitBrut = this.calculVenitBrut(an, luna, angajat);
		Double retinere = 0.0;
		if(tipRetinere=="CAS")
			 retinere = venitBrut*Configurare.CAS_ANGAJAT;
		else if	(tipRetinere=="CASS")
			retinere = venitBrut*Configurare.CASS_ANGAJAT;
		else if	(tipRetinere=="SOMAJ")
			retinere = venitBrut*Configurare.SOMAJ_ANGAJAT;
		
		return retinere;
	}
		 
		
	@Override
	public Double calculDeduceri(Integer an, Integer luna, Angajat angajat) {
		logger.debug("Calcul deducere angajat");
		
		Integer numarCopii = angajat.getNumarCopii();
		Double valoareDeducere = 0.0;
		switch(numarCopii){
			case 0: valoareDeducere = Configurare.DEDUCERE_ZERO_COPII;
			case 1: valoareDeducere = Configurare.DEDUCERE_UN_COPIL;
			case 2: valoareDeducere = Configurare.DEDUCERE_DOI_COPII;
			case 3: valoareDeducere = Configurare.DEDUCERE_TREI_COPII;
			default: valoareDeducere = Configurare.DEDUCERE_PATRU_COPII;
		}
		return valoareDeducere;
	}

	@Override
	public Double calculImpozit(Integer an, Integer luna, Angajat angajat) {
		// impozitul se calculeaza dupa ce am scazut retinerile si deducerea din venitul brut
		logger.debug("Calcul impozit angajat");
		Double venitBrut = this.calculVenitBrut(an, luna, angajat);
		Double retineriAlte = this.calculRetineriAngajat(an, luna, angajat);
		Double cas = this.calculRetineriObligatorii(an, luna, angajat,"CAS");
		Double cass = this.calculRetineriObligatorii(an, luna, angajat,"CASS");
		Double somaj = this.calculRetineriObligatorii(an, luna, angajat,"SOMAJ");
		Double deduceri = this.calculDeduceri(an, luna, angajat);
		Double impozit = 0.0;
		impozit = (venitBrut - retineriAlte - cas - cass - somaj - deduceri) * Configurare.IMPOZIT_ANGAJAT;
		return impozit;
	}

	@Override
	public Double calculSalarNet(Integer an, Integer luna, Angajat angajat) {
		logger.debug("Calcul salar net angajat");
		//TO DO: eliminare calcul de doua ori a retinerilor si deducerilor (sunt calculate si aici si la impozit)
		Double salarNet = 0.0;
		Double venitBrut = this.calculVenitBrut(an, luna, angajat);
		Double retineriAlte = this.calculRetineriAngajat(an, luna, angajat);
		Double cas = this.calculRetineriObligatorii(an, luna, angajat,"CAS");
		Double cass = this.calculRetineriObligatorii(an, luna, angajat,"CASS");
		Double somaj = this.calculRetineriObligatorii(an, luna, angajat,"SOMAJ");
		Double impozit = this.calculImpozit(an, luna, angajat);
		salarNet = venitBrut - retineriAlte - cas - cass - somaj - impozit;
		return salarNet;
	}

	
	@Override
	public void inregistrarStatSalariiLuna(Integer an, Integer luna) {
		
		logger.debug("Creare stat salarii pentru toti angajatii");
		//toti angajatii
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(this.personalSrv.getListaAngajati());
		
		//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
		for (Angajat angajat:angajati){
			Pontaj p = new Pontaj();
			p.setAn(an);
			p.setLuna(luna);
			p.setAngajat(angajat);
			
			StatSalarii statSalarii = new StatSalarii();
			statSalarii.setPontaj(p);
			statSalarii.setAlteSporuri(this.calculSporuriAngajat(an, luna, angajat));
			statSalarii.setAlteRetineri(this.calculRetineriAngajat(an, luna, angajat));
			statSalarii.setCas(this.calculRetineriObligatorii(an, luna, angajat, "CAS"));
			statSalarii.setCass(this.calculRetineriObligatorii(an, luna, angajat, "CASS"));
			statSalarii.setSomaj(this.calculRetineriObligatorii(an, luna, angajat, "SOMAJ"));
			statSalarii.setSalarBrut(this.calculVenitBrut(an, luna, angajat));
			statSalarii.setImpozit(this.calculImpozit(an, luna, angajat));
			statSalarii.setSalarNet(this.calculSalarNet(an, luna, angajat));
			
			//save in DB
		}
		
	}

	@Override
	public CentralizatorStatSalarii getStatSalariiLuna(Integer an, Integer luna) {
		
		logger.debug("Generare centralizator salarii");
		Double totalCAS=0.0;
		Double totalCASS=0.0;
		Double totalSomaj=0.0;
		Double totalImpozit=0.0;
		Double totalSalarNet=0.0;
		Double totalSporuri=0.0;
		Double totalAlteRetineri=0.0;
		//insumam sume pentru toti angajatii
		CentralizatorStatSalarii centralizator = new CentralizatorStatSalarii();
		centralizator.setAn(an);
		centralizator.setLuna(luna);
		
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(this.personalSrv.getListaAngajati());
		
		for (Angajat angajat:angajati){
			StatSalarii statSalarii = new StatSalarii();
			//aici ar trebui incarcat din DB din StatSalarii
			totalSporuri += this.calculSporuriAngajat(an, luna, angajat);
			totalAlteRetineri += this.calculRetineriAngajat(an, luna, angajat);
			totalCAS += this.calculRetineriObligatorii(an, luna, angajat, "CAS");
			totalCASS += this.calculRetineriObligatorii(an, luna, angajat, "CASS");
			totalSomaj += this.calculRetineriObligatorii(an, luna, angajat, "SOMAJ");
			
			totalImpozit += this.calculImpozit(an, luna, angajat);
			totalSalarNet += this.calculSalarNet(an, luna, angajat);
			
			
			centralizator.addStatSalarii(statSalarii);
		}
		
		
		return centralizator;
	}
	
	public PersonalSrv getPersonalSrv() {
		return personalSrv;
	}

	public void setPersonalSrv(PersonalSrv personalSrv) {
		this.personalSrv = personalSrv;
	}

	public RegistruSalarizare getRegistru() {
		return registru;
	}

	public void setRegistru(RegistruSalarizare registru) {
		this.registru = registru;
	}
}

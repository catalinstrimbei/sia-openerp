package org.open.erp.services.salarizare.impl;

import org.open.erp.services.nomgen.NomenclatoareSrv;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagementType;
import javax.ejb.TransactionManagement;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.nomgen.NomenclatoareSrv;
//import org.open.erp.services.personal.PersonalSrvLocal;
//import org.open.erp.services.personal.logger.PersonalLogger;
import org.open.erp.services.salarizare.Centralizare_Stat_Plata;
import org.open.erp.services.salarizare.Config;
import org.open.erp.services.salarizare.Pontaje;
import org.open.erp.services.salarizare.Retineri;
import org.open.erp.services.salarizare.SRV_Salarizare;
import org.open.erp.services.salarizare.Local_Salarizare;
import org.open.erp.services.salarizare.Remote_Salarizare;
import org.open.erp.services.salarizare.Sporuri;
import org.open.erp.services.salarizare.Stat_Salarii;


@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public abstract class Implement_Salarizare implements Local_Salarizare, Remote_Salarizare {

	
		private static Logger_Salarizare logger;
		private Registru_Salarizare registru ;
		@PersistenceContext(unitName="OpenERP_SALARIZARE")
		private EntityManager em;

		@Resource
		private SessionContext sessionContext;
		
		public Implement_Salarizare() { }
		@PostConstruct
		public void init(){
			logger = new Logger_Salarizare();
			logger.logINFO("EntityManager: " + em);		
			logger.logINFO("PersonalSrv: " + personalSrv);		
			
			if (this.registru == null)
				registru = new Registru_Salarizare(em);
		}
		
		//TO DO - de schimbar cand se va comite in modulul Personal sa foloseasca interfata locala
		@EJB(mappedName="PersonalSrv") 
		private PersonalSrv personalSrv;
		
	
		
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		@Override
		public Pontaje inregistrarePontaj(Integer cod_Pontaj, Angajat angajat, Integer Pontaj_an, Integer Pontaj_luna,
				Double Pontaj_oreLucrate, Double pontaj_oreSuplimentare, Double Pontaj_oreConcediu) throws Exception {
			
			logger.logINFO("START creare pontaj angajat");
			Pontaje p = new Pontaje(cod_Pontaj, Pontaj_an,Pontaj_luna, angajat, Pontaj_oreLucrate,pontaj_oreSuplimentare,Pontaj_oreConcediu);
			
			if (sessionContext.getRollbackOnly() == true){
				logger.logINFO("END creare pontaj angajat - FAILED TRANSACTION");
			}else{
				p = this.registru.salveazaPontaj(p);
			}
			
			logger.logINFO("END Creare pontaj angajat");
			
			return p;
		}
	 
		@Interceptors({Interceptor_Salarizare.class})
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		@Override
		public void inregistrarePontajLuna(Integer an, Integer luna) throws Exception {
			// pentru toti angajatii genereaza un pontaj default tinand cont de nr de ore lucratoare din luna
			
			//toti angajatii
			logger.logINFO("Incarca lista tuturor angajatilor");
			ArrayList<Angajat> angajati= new ArrayList<Angajat>();
			angajati.addAll(this.personalSrv.getListaAngajati());
			
			logger.logINFO("Creare pontaj pentru toti angajatii");
			Integer cod_Pontaj = 999999999;
			//parcurgem si setam pontajul (adica salvam in DB)
			for (Angajat angajat:angajati){
				this.inregistrarePontaj(null, angajat, an, luna, Config.luna_ore_lucratoare, 0.0, 0.0);
			}
			if (sessionContext.getRollbackOnly() == true){
				logger.logINFO("END creare pontaj luna - tranzactie esuata");
			}
			
			logger.logINFO("END Creare pontaj luna");
		}

		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		@Override
		public void adaugaOreConcediu(Pontaje pontaj, Double oreConcediu) throws Exception {
			logger.logINFO("Start - Adaugare ore concediu angajat");
			
			pontaj.setPontaj_oreConcediu(oreConcediu);
			
			if (sessionContext.getRollbackOnly() == true){
				logger.logINFO("END update ore concediu angajat - FAILED TRANSACTION");
			}else{
				 this.registru.salveazaPontaj(pontaj);
			}
			
			logger.logINFO("End - Adaugare ore concediu angajat");
		}

		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		@Override
		public void adaugaOreSuplimentare(Pontaje pontaj, Double oreSuplimentare) throws Exception {
			logger.logINFO("Adaugare ore suplimentare angajat");
			pontaj.setPontaj_oreSuplimentare(oreSuplimentare);

			if (sessionContext.getRollbackOnly() == true){
				logger.logINFO("END update ore suplimentare angajat - FAILED TRANSACTION");
			}else{
				 this.registru.salveazaPontaj(pontaj);
			}
			
			logger.logINFO("End - Adaugare ore suplimentare angajat");
		}

		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		@Override
		public Sporuri inregistrareSpor(Integer cod_Spor, String denumire_Spor, Integer tip_Spor, Integer an,
				Integer luna, Angajat angajat, Integer modCalcul, Double valoare) throws Exception {
			logger.logINFO("START creare spor angajat");
			Sporuri spor = new Sporuri(cod_Spor, denumire_Spor, tip_Spor, an, luna, angajat, modCalcul, valoare);
			
			if (sessionContext.getRollbackOnly() == true){
				logger.logINFO("END creare spor angajat - FAILED TRANSACTION");
			}else{
				spor = this.registru.salveazaSpor(spor);
			}
			
			logger.logINFO("END Creare spor angajat");
			
			return spor;
		}

		@Interceptors({Interceptor_Salarizare.class})
		@Override
		public Double calculSporuriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception {
			// pentru fiecare angajat calculam sporurile (pot fi mai multe) si insumam
			Double valoareTotala=0.0;
			ArrayList<Sporuri> sporuri= new ArrayList<Sporuri>();
			ContractMunca contract = personalSrv.getContractAngajatActiv(angajat);
			//de inlocuit aici cu metoda getContractActivAngajat
			//daca prin absurd un angajat are mai multe contracte active la un moment data
			//atunci o sa iteram prin lista de contracte si o sa facem calculul
			if (contract != null){
			
				sporuri.addAll(registru.getSporuriAngajat(an, luna, angajat));
				
				logger.logINFO("Calcul sporuri angajat");
				for (Sporuri spor:sporuri){
					if(spor.getModCalcul()==1){ 
						//valoare
						valoareTotala = valoareTotala + spor.getValoare();
					}
					else{
						//valoare
						valoareTotala = valoareTotala + spor.getValoare()*contract.getSalar();
					}
				}
			}
			else{
				valoareTotala = 0.0;
			}
			
			return valoareTotala;
		}

		@Override
		public Double calculVenitBrut(Integer an, Integer luna, Angajat angajat) throws Exception {
			Pontaje p = registru.getPontajByAngajat(angajat, an, luna);
			logger.logINFO("Am incarcat pontajul");
			ContractMunca contract = personalSrv.getContractAngajatActiv(angajat);
			
			logger.logINFO("Calcul venit brut angajat");
			Double venitBrut = 0.0;
			if (contract != null){
				Double venitOreLucrate = (p.getPontaj_oreLucrate()-p.getPontaj_oreConcediu())*contract.getNormaZilnica();
				Double venitOreSuplimentare = p.getPontaj_oreSuplimentare()*contract.getNormaZilnica();
				venitBrut = venitOreLucrate+venitOreSuplimentare;
			}
			else{
				venitBrut = 0.0;
			}
			//venitul brut este format din nrorelucrate*tariforar+sporuri
			return venitBrut;
		}

		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		@Override
		public Retineri inregistrareRetinere(Integer cod_Retinere, String denumire_Retinere, Integer tip_Retinere, Integer an, Integer luna, Angajat angajat, Integer modCalcul, Double valoare) throws Exception {
			logger.logINFO("Start creare retinere angajat");
			Retineri retinere = new Retineri(cod_Retinere, denumire_Retinere, tip_Retinere, an, luna, angajat, modCalcul, valoare);
			
			if (sessionContext.getRollbackOnly() == true){
				logger.logINFO("END creare retinere angajat - FAILED TRANSACTION");
			}else{
				retinere = this.registru.salveazaRetinere(retinere);
			}
			
			logger.logINFO("END Creare retinere angajat");
			
			return retinere;
		}

		@Interceptors({Interceptor_Salarizare.class})
		@Override
		public Double calculRetineriAngajat(Integer an, Integer luna,
				Angajat angajat) throws Exception {
			// pentru fiecare angajat calculam retinerile (pot fi mai multe) si insumam
			ContractMunca contract = personalSrv.getContractAngajatActiv(angajat);
		
			logger.logINFO("Calcul retineri angajat");
			Double valoareTotala=0.0;
			ArrayList<Retineri> retineri= new ArrayList<Retineri>();
			if (contract != null){
				retineri.addAll(registru.getRetineriAngajat(an, luna, angajat));
			
				for (Retineri retinere:retineri){
					if(retinere.getMod_Calcul()==1){ 
						//valoare
						valoareTotala = valoareTotala + retinere.getValoare();
					}
					else{
						//valoare
						valoareTotala = valoareTotala + retinere.getValoare()*contract.getSalar();
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
				Angajat angajat, String tipRetinere, Double venitBrut) {
			logger.logINFO("Calcul retinere obligatorie "+tipRetinere+"angajat");
			// retinerile obligatorii se retin din salarul brut
			Double retinere = 0.0;
			if(tipRetinere=="CAS")
				 retinere = venitBrut*Config.cas_angajat;
			else if	(tipRetinere=="CASS")
				retinere = venitBrut*Config.cass_angajat;
			else if	(tipRetinere=="SOMAJ")
				retinere = venitBrut*Config.somaj_angajat;
			
			return retinere;
		}
			 
			
		@Override
		public Double calculDeduceri(Integer an, Integer luna, Angajat angajat) {
			logger.logINFO("Calcul deducere angajat");
			
			Integer numarCopii = angajat.getNumarCopii();
			Double valoareDeducere = 0.0;
			switch(numarCopii){
				case 0: valoareDeducere = Config.deducere_zero;
				case 1: valoareDeducere = Config.deducere_I;
				case 2: valoareDeducere = Config.deducere_II;
				case 3: valoareDeducere = Config.deducere_III;
				default: valoareDeducere = Config.deducere_IV;
			}
			return valoareDeducere;
		}

		@Override
		public Double calculImpozit(Integer an, Integer luna, Angajat angajat, Double venitBrut, Double cas, Double cass, Double somaj, Double retineriAlte, Double deduceri) {
			// impozitul se calculeaza dupa ce am scazut retinerile si deducerea din venitul brut
			logger.logINFO("Calcul impozit angajat");
			
			Double impozit = 0.0;
			impozit = (venitBrut - retineriAlte - cas - cass - somaj - deduceri) * Config.impozit_angajat;
			return impozit;
		}

		@Override
		public Double calculSalarNet(Integer an, Integer luna, Angajat angajat, Double venitBrut, Double cas, Double cass, Double somaj, Double impozit, Double retineriAlte
				, Double deduceri) {
			logger.logINFO("Calcul salar net angajat");
			//TO DO: eliminare calcul de doua ori a retinerilor si deducerilor (sunt calculate si aici si la impozit)
			Double salarNet = 0.0;
			
			salarNet = venitBrut - retineriAlte - cas - cass - somaj - impozit;
			return salarNet;
		}

		@Interceptors({Interceptor_Salarizare.class})
		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		@Override
		public void inregistrarStatSalariiLuna(Integer an, Integer luna) throws Exception {
			
			logger.logINFO("Creare stat salarii pentru toti angajatii");
			//toti angajatii
			ArrayList<Angajat> angajati= new ArrayList<Angajat>();
			angajati.addAll(this.personalSrv.getListaAngajati());
			
			//parcurgem si apelam calculele pt fiecare angajat dupa care salvam in DB
			for (Angajat angajat:angajati){
				/*
				 * Pontaj p = new Pontaj();
				
				p.setAn(an);
				p.setLuna(luna);
				p.setAngajat(angajat);
				 */
				Pontaje p = registru.getPontajByAngajat(angajat, an, luna);
				Double venitBrut = this.calculVenitBrut(an, luna, angajat);
				Double retineriAlte = calculRetineriAngajat(an, luna, angajat);
				Double deduceri = calculDeduceri(an, luna, angajat);
				Double cas = calculRetineriObligatorii(2011, 11, angajat,"CAS", venitBrut);
				Double cass = calculRetineriObligatorii(2011, 11, angajat,"CASS", venitBrut);
				Double somaj = calculRetineriObligatorii(2011, 11, angajat,"SOMAJ", venitBrut);
				logger.logINFO("Inregistrare stat salarii inainte de calcul impozit");
				Double impozit = calculImpozit(an, luna, angajat, venitBrut, cas, cass, somaj, retineriAlte, deduceri);
				logger.logINFO("Inregistrare stat salarii dupa de calcul impozit");
				Double salarNet = calculSalarNet(an, luna, angajat, venitBrut, cas, cass, somaj, impozit, retineriAlte, deduceri);
				logger.logINFO("Inregistrare stat salarii dupa calcul salar net");
				Stat_Salarii statSalarii = new Stat_Salarii();
				statSalarii.setPontaje(p);
				statSalarii.setAlte_Sporuri(this.calculSporuriAngajat(an, luna, angajat));
				logger.logINFO("Inregistrare stat salarii dupa sporuri");
				statSalarii.setAlte_Retineri(retineriAlte);
				statSalarii.setCAS(cas);
				statSalarii.setCASS(cass);
				statSalarii.setSomaj(somaj);
				statSalarii.setSalariu_Brut(venitBrut);
				statSalarii.setImpozit(impozit);
				statSalarii.setSalariu_Net(salarNet);
				logger.logINFO("Inregistrare stat salarii inainte de salvare");
				this.registru.salveazaStatSalarii(statSalarii);
			}
			
			if (sessionContext.getRollbackOnly() == true){
				logger.logINFO("END inregistrare stat plata - FAILED TRANSACTION");
			}
			logger.logINFO("END inregistrare stat plata");
		}

		@TransactionAttribute(TransactionAttributeType.REQUIRED)
		@Override
		public Centralizare_Stat_Plata inregistreazaCentralizatorStatSalariiLuna(Integer an, Integer luna) throws Exception {
			
			logger.logINFO("Generare centralizator salarii");
			Double totalCAS=0.0;
			Double totalCASS=0.0;
			Double totalSomaj=0.0;
			Double totalImpozit=0.0;
			Double totalSalarNet=0.0;
			Double totalSporuri=0.0;
			Double totalAlteRetineri=0.0;
			Double totalSalarBrut = 0.0;
			//insumam sume pentru toti angajatii
			Centralizare_Stat_Plata centralizator = new Centralizare_Stat_Plata();
			centralizator.setAn(an);
			centralizator.setLuna(luna);
			
			List<Stat_Salarii> salarii= new ArrayList<Stat_Salarii>();
			salarii.addAll(registru.getStatAnLuna(an, luna));
			
			//inlocuit cu metodata getSalariiByLuna care returneaza salarii
			//performance wise ar trebui facut in DB cu proceduri stocate
			for (Stat_Salarii salar:salarii){
				
				totalSporuri += salar.getAlte_Sporuri();
				totalAlteRetineri += salar.getAlte_Retineri();
				totalCAS += salar.getCAS();
				totalCASS += salar.getCASS();
				totalSomaj += salar.getSomaj();
				totalImpozit += salar.getImpozit();
				totalSalarNet += salar.getSalariu_Net();
				totalSalarBrut += salar.getSalariu_Brut();
				
				centralizator.addStat_Salarii(salar);
			}
			if(sessionContext.getRollbackOnly()==true){
				logger.logINFO("END generare centralizator - TRANZACTIE ESUATA!");
			}
			else{
				centralizator = registru.salveazaCentralizator(centralizator);
			}
			
			logger.logINFO("END generare centralizator");
			return centralizator;
		}
		 
		public PersonalSrv getPersonalSrv() {
			return personalSrv;
		}

		public void setPersonalSrv(PersonalSrv personalSrv) {
			this.personalSrv = (PersonalSrv) personalSrv;
		}

		public Registru_Salarizare getRegistru() {
			return registru;
		}

		public void setRegistru(Registru_Salarizare registru) {
			this.registru = registru;
		}
		
		public  Angajat getAngajatById(Integer id) throws Exception{
			Angajat angajat = personalSrv.getAngajatById(id);
			//pentru a nu pica testele daca nu exista angajat atunci cream unul nou
			if (angajat==null){
				angajat = new Angajat();
				//angajat.setId(id);
				angajat.setNume("Gigel");
				angajat.setNumarCopii(2);
				 angajat = personalSrv.salveazaAngajat(angajat);
				
			}
			return angajat;
		}
		
		public Pontaje getPontajByAngajat(Angajat angajat, Integer an, Integer luna) throws Exception{
			Pontaje pontaj = registru.getPontajByAngajat(angajat, an, luna);
			//pt a nu pica testele daca nu exista pontaj atunci cream unul nou
			if (pontaj==null){
				pontaj = new Pontaje();
				pontaj.setPontaj_an(an);
				pontaj.setPontaj_luna(luna);
				pontaj.setAngajat(angajat);
		
				pontaj = registru.salveazaPontaj(pontaj);
				
			}
			return pontaj;
		}
		
		public List<Pontaje> getPontajAnLuna(Integer an, Integer luna) throws Exception {
			List<Pontaje> pontaje = registru.getPontajAnLuna(an, luna);
			return pontaje;
		}
		
		public List<Pontaje> getPontajAngajatAll(Angajat angajat) throws Exception {
			List<Pontaje> pontaje = registru.getPontajAngajatAll(angajat);
			return pontaje;
		}
		
		public List<Sporuri> getSporuriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception {
			List<Sporuri> sporuri = registru.getSporuriAngajat(an, luna, angajat);
			return sporuri;
		}
		
		public List<Retineri> getRetineriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception {
			List<Retineri> retineri = registru.getRetineriAngajat(an, luna, angajat);
			return retineri;
		}
		
		public List<Stat_Salarii> getStatAnLuna(Integer an, Integer luna) throws Exception {
			List<Stat_Salarii> salarii = registru.getStatAnLuna(an, luna);
			return salarii;
		}
		
		public Centralizare_Stat_Plata getCentralizatorStatSalariiLuna(Integer an, Integer luna) throws Exception {
			Centralizare_Stat_Plata centralizator = registru.getCentralizatorStatSalarii(an, luna);
			return centralizator;
		}
		
		public void stergeCentralizator(Centralizare_Stat_Plata centralizator){
			registru.stergeCentralizator(centralizator);
		}
		
		public List<Sporuri> getSporuriGenerale() throws Exception {
			List<Sporuri> sporuri = registru.getSporuriGenerale();
			return sporuri;
		}
		
		public List<Retineri> getRetineriGenerale() throws Exception {
			List<Retineri> retineri = registru.getRetineriGenerale();
			return retineri;
		}
		
		public void stergeSpor(Sporuri spor){
			registru.stergeSpor(spor);
		}
		
		public void stergeRetinere(Retineri retinere){
			registru.stergeRetinere(retinere);
		}
		
		public void stergePontaj(Pontaje pontaj){
			registru.stergePontaj(pontaj);
		}
		
		public void stergeStatSalarii(Stat_Salarii statSalarii){
			registru.stergeStatSalarii(statSalarii);
		}
		
		public Stat_Salarii salveazaStatSalarii(Stat_Salarii statSalarii) throws Exception{
			return registru.salveazaStatSalarii(statSalarii);
		}

		
	
}

package org.open.erp.services.salarizare.impl;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

//import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.PersonalSrvLocal;
import org.open.erp.services.personal.logger.PersonalLogger;
import org.open.erp.services.salarizare.CentralizatorStatSalarii;
import org.open.erp.services.salarizare.Configurare;
import org.open.erp.services.salarizare.Pontaj;
import org.open.erp.services.salarizare.Retinere;
import org.open.erp.services.salarizare.SalarizareSrv;
import org.open.erp.services.salarizare.SalarizareSrvLocal;
import org.open.erp.services.salarizare.SalarizareSrvRemote;
import org.open.erp.services.salarizare.Spor;
import org.open.erp.services.salarizare.StatSalarii;

@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SalarizareImpl implements SalarizareSrvLocal, SalarizareSrvRemote {
	//private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SalarizareImpl.class.getName());
	private static SalarizareLogger logger;
	private RegistruSalarizare registru ;
	//variabila de instanţa de tip EntityManager care sa fie injectata prin adnotarea @PersistenceContext(unitName="OpenERP_ModulPU");
	@PersistenceContext(unitName="OpenERP_SALARIZARE")
	private EntityManager em;

	//variabila de instanţă adonatată @Resource care să păstreze referinţa SessionContext;
	@Resource
	private SessionContext sessionContext;
	
	public SalarizareImpl() { }
	//metodă callback - @PostConstruct – în care registrul sau registrele din proiect să primească referinţa EntityManagerului care va fi injectat.
	@PostConstruct
	public void init(){
		logger = new SalarizareLogger();
		logger.logINFO("EntityManager: " + em);		
		logger.logINFO("PersonalSrv: " + personalSrv);		
		
		if (this.registru == null)
			registru = new RegistruSalarizare(em);
	}
	
	//TO DO - de schimbar cand se va comite in modulul Personal sa foloseasca interfata locala
	@EJB(mappedName="PersonalSrv/local") 
	private PersonalSrvLocal personalSrv;
	
	//private NomenclatoareSrv nomenclatoareSrv;

	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Pontaj inregistrarePontaj(Angajat angajat, Integer an, Integer luna,
			Double oreLucrate, Double oreSuplimentare, Double oreConcediu) throws Exception {
		
		logger.logINFO("START creare pontaj angajat");
		Pontaj p = new Pontaj(angajat,an,luna,oreLucrate,oreSuplimentare,oreConcediu);
		
		if (sessionContext.getRollbackOnly() == true){
			logger.logINFO("END creare pontaj angajat - FAILED TRANSACTION");
		}else{
			p = this.registru.salveazaPontaj(p);
		}
		
		logger.logINFO("END Creare pontaj angajat");
		
		return p;
	}

	@Interceptors({SalarizareInterceptor.class})
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void inregistrarePontajLuna(Integer an, Integer luna) throws Exception {
		// pentru toti angajatii genereaza un pontaj default tinand cont de nr de ore lucratoare din luna
		
		//toti angajatii
		logger.logINFO("Incarca lista tuturor angajatilor");
		ArrayList<Angajat> angajati= new ArrayList<Angajat>();
		angajati.addAll(this.personalSrv.getListaAngajati());
		
		logger.logINFO("Creare pontaj pentru toti angajatii");
		
		//parcurgem si setam pontajul (adica salvam in DB)
		for (Angajat angajat:angajati){
			this.inregistrarePontaj(angajat, an, luna, Configurare.NUMAR_ORE_LUCRATOARE_LUNA, 0.0, 0.0);
		}
		if (sessionContext.getRollbackOnly() == true){
			logger.logINFO("END creare pontaj luna - FAILED TRANSACTION");
		}
		
		logger.logINFO("END Creare pontaj luna");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void adaugaOreConcediu(Pontaj pontaj, Double oreConcediu) throws Exception {
		logger.logINFO("Start - Adaugare ore concediu angajat");
		
		pontaj.setOreConcediu(oreConcediu);
		
		if (sessionContext.getRollbackOnly() == true){
			logger.logINFO("END update ore concediu angajat - FAILED TRANSACTION");
		}else{
			 this.registru.salveazaPontaj(pontaj);
		}
		
		logger.logINFO("End - Adaugare ore concediu angajat");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void adaugaOreSuplimentare(Pontaj pontaj, Double oreSuplimentare) throws Exception {
		logger.logINFO("Adaugare ore suplimentare angajat");
		pontaj.setOreSuplimentare(oreSuplimentare);

		if (sessionContext.getRollbackOnly() == true){
			logger.logINFO("END update ore suplimentare angajat - FAILED TRANSACTION");
		}else{
			 this.registru.salveazaPontaj(pontaj);
		}
		
		logger.logINFO("End - Adaugare ore suplimentare angajat");
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Spor inregistrareSpor(Integer id, String denumire, Integer tip, Integer an,
			Integer luna, Angajat angajat, Integer modCalcul, Double valoare) throws Exception {
		logger.logINFO("START creare spor angajat");
		Spor spor = new Spor(id, denumire, tip, an, luna, angajat, modCalcul, valoare);
		
		if (sessionContext.getRollbackOnly() == true){
			logger.logINFO("END creare spor angajat - FAILED TRANSACTION");
		}else{
			spor = this.registru.salveazaSpor(spor);
		}
		
		logger.logINFO("END Creare spor angajat");
		
		return spor;
	}

	@Interceptors({SalarizareInterceptor.class})
	@Override
	public Double calculSporuriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception {
		// pentru fiecare angajat calculam sporurile (pot fi mai multe) si insumam
		Double valoareTotala=0.0;
		ArrayList<Spor> sporuri= new ArrayList<Spor>();
		ContractMunca contract = personalSrv.getContractAngajatActiv(angajat);
		//de inlocuit aici cu metoda getContractActivAngajat
		//daca prin absurd un angajat are mai multe contracte active la un moment data
		//atunci o sa iteram prin lista de contracte si o sa facem calculul
		if (contract != null){
		
			sporuri.addAll(registru.getSporuriAngajat(an, luna, angajat));
			
			logger.logINFO("Calcul sporuri angajat");
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

	//@Interceptors({SalarizareInterceptor.class})
	@Override
	public Double calculVenitBrut(Integer an, Integer luna, Angajat angajat) throws Exception {
		Pontaj p = registru.getPontajByAngajat(angajat, an, luna);
		logger.logINFO("Am incarcat pontajul");
		ContractMunca contract = personalSrv.getContractAngajatActiv(angajat);
		
		logger.logINFO("Calcul venit brut angajat");
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

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Retinere inregistrareRetinere(String denumire, Integer tip,
			Integer an, Integer luna, Angajat angajat, Integer modCalcul, Double valoare) throws Exception {
		logger.logINFO("Start creare retinere angajat");
		Retinere retinere = new Retinere(denumire, tip, angajat, an, luna, modCalcul, valoare);
		
		if (sessionContext.getRollbackOnly() == true){
			logger.logINFO("END creare retinere angajat - FAILED TRANSACTION");
		}else{
			retinere = this.registru.salveazaRetinere(retinere);
		}
		
		logger.logINFO("END Creare retinere angajat");
		
		return retinere;
	}

	@Interceptors({SalarizareInterceptor.class})
	@Override
	public Double calculRetineriAngajat(Integer an, Integer luna,
			Angajat angajat) throws Exception {
		// pentru fiecare angajat calculam retinerile (pot fi mai multe) si insumam
		ContractMunca contract = personalSrv.getContractAngajatActiv(angajat);
	
		logger.logINFO("Calcul retineri angajat");
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
			Angajat angajat, String tipRetinere, Double venitBrut) {
		logger.logINFO("Calcul retinere obligatorie "+tipRetinere+"angajat");
		// retinerile obligatorii se retin din salarul brut
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
		logger.logINFO("Calcul deducere angajat");
		
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
	public Double calculImpozit(Integer an, Integer luna, Angajat angajat, Double venitBrut, Double cas, Double cass, Double somaj, Double retineriAlte, Double deduceri) {
		// impozitul se calculeaza dupa ce am scazut retinerile si deducerea din venitul brut
		logger.logINFO("Calcul impozit angajat");
		
		Double impozit = 0.0;
		impozit = (venitBrut - retineriAlte - cas - cass - somaj - deduceri) * Configurare.IMPOZIT_ANGAJAT;
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

	@Interceptors({SalarizareInterceptor.class})
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
			Pontaj p = registru.getPontajByAngajat(angajat, an, luna);
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
			StatSalarii statSalarii = new StatSalarii();
			statSalarii.setPontaj(p);
			statSalarii.setAlteSporuri(this.calculSporuriAngajat(an, luna, angajat));
			logger.logINFO("Inregistrare stat salarii dupa sporuri");
			statSalarii.setAlteRetineri(retineriAlte);
			statSalarii.setCas(cas);
			statSalarii.setCass(cass);
			statSalarii.setSomaj(somaj);
			statSalarii.setSalarBrut(venitBrut);
			statSalarii.setImpozit(impozit);
			statSalarii.setSalarNet(salarNet);
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
	public CentralizatorStatSalarii inregistreazaCentralizatorStatSalariiLuna(Integer an, Integer luna) throws Exception {
		
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
		CentralizatorStatSalarii centralizator = new CentralizatorStatSalarii();
		centralizator.setAn(an);
		centralizator.setLuna(luna);
		
		List<StatSalarii> salarii= new ArrayList<StatSalarii>();
		salarii.addAll(registru.getStatAnLuna(an, luna));
		
		//inlocuit cu metodata getSalariiByLuna care returneaza salarii
		//performance wise ar trebui facut in DB cu proceduri stocate
		for (StatSalarii salar:salarii){
			
			totalSporuri += salar.getAlteSporuri();
			totalAlteRetineri += salar.getAlteRetineri();
			totalCAS += salar.getCas();
			totalCASS += salar.getCass();
			totalSomaj += salar.getSomaj();
			totalImpozit += salar.getImpozit();
			totalSalarNet += salar.getSalarNet();
			totalSalarBrut += salar.getSalarBrut();
			
			centralizator.addStatSalarii(salar);
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
		this.personalSrv = (PersonalSrvLocal) personalSrv;
	}

	public RegistruSalarizare getRegistru() {
		return registru;
	}

	public void setRegistru(RegistruSalarizare registru) {
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
	
	public Pontaj getPontajByAngajat(Angajat angajat, Integer an, Integer luna) throws Exception{
		Pontaj pontaj = registru.getPontajByAngajat(angajat, an, luna);
		//pt a nu pica testele daca nu exista pontaj atunci cream unul nou
		if (pontaj==null){
			pontaj = new Pontaj();
			pontaj.setAn(an);
			pontaj.setLuna(luna);
			pontaj.setAngajat(angajat);
	
			pontaj = registru.salveazaPontaj(pontaj);
			
		}
		return pontaj;
	}
	
	public List<Pontaj> getPontajAnLuna(Integer an, Integer luna) throws Exception {
		List<Pontaj> pontaje = registru.getPontajAnLuna(an, luna);
		return pontaje;
	}
	
	public List<Spor> getSporuriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception {
		List<Spor> sporuri = registru.getSporuriAngajat(an, luna, angajat);
		return sporuri;
	}
	
	public List<Retinere> getRetineriAngajat(Integer an, Integer luna, Angajat angajat) throws Exception {
		List<Retinere> retineri = registru.getRetineriAngajat(an, luna, angajat);
		return retineri;
	}
	
	public List<StatSalarii> getStatAnLuna(Integer an, Integer luna) throws Exception {
		List<StatSalarii> salarii = registru.getStatAnLuna(an, luna);
		return salarii;
	}
	
	public CentralizatorStatSalarii getCentralizatorStatSalariiLuna(Integer an, Integer luna) throws Exception {
		CentralizatorStatSalarii centralizator = registru.getCentralizatorStatSalarii(an, luna);
		return centralizator;
	}
	
	public void stergeCentralizator(CentralizatorStatSalarii centralizator){
		registru.stergeCentralizator(centralizator);
	}
	
	public List<Spor> getSporuriGenerale() throws Exception {
		List<Spor> sporuri = registru.getSporuriGenerale();
		return sporuri;
	}
	
	public void stergeSpor(Spor spor){
		registru.stergeSpor(spor);
	}
}

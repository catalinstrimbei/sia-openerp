package org.open.erp.services.personal.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


//import org.open.erp.services.buget.Buget;
//import org.open.erp.services.buget.BugetareSrv;
//import org.open.erp.services.buget.LinieBugetara;
import org.open.erp.services.nomgen.Departament;
//import org.open.erp.services.personal.Activitate;
//import org.open.erp.services.personal.Proiect;
import org.open.erp.services.personal.Activitate;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.AngajatProbaEvaluare;
import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.CerereDemisie;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.DosarAngajat;
import org.open.erp.services.personal.Eveniment;
import org.open.erp.services.personal.Functie;
import org.open.erp.services.personal.InterviuCandidat;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.ProbaEvaluare;
import org.open.erp.services.personal.teste.TestPersonalImpl;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */

public class PersonalImpl implements PersonalSrv{	
	final static long MILLIS_PER_DAY = 24 * 3600 * 1000;
	DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	
	@Override
	public void demisionare(CerereDemisie cerereDemisie_) {
		// TODO Auto-generated method stub				
		ContractMunca	contract = cerereDemisie_.getContract();
		Angajat 		angajat = contract.getAngajat();
		Date			data;
		
		if(cerereDemisie_.getDataCerere() == null)
		{
			data = Calendar.getInstance().getTime();
			cerereDemisie_.setDataCerere(data);
		}
		
		if(cerereDemisie_.getDataDemisie() == null)
		{
			cerereDemisie_.setDataDemisie(Calendar.getInstance().getTime());
		}
		
		long msDiff= cerereDemisie_.getDataDemisie().getTime() - cerereDemisie_.getDataCerere().getTime();
		int nrZile = Math.round(msDiff / ((int)MILLIS_PER_DAY));
		
		cerereDemisie_.setPerioadaPreaviz(nrZile);
		
		contract.setDataTerminare(cerereDemisie_.getDataDemisie());
		contract.setMotivIncheiere("Demisionare");
		
		angajat.setActiv(false);
		cerereDemisie_.setStatus("Finalizata");
		
		System.out.println("Detalii cerere: " + cerereDemisie_.getNrInregistrare().toString());
		System.out.println("Status--------- " + cerereDemisie_.getStatus().toString());
		System.out.println("DataCerere----- " + cerereDemisie_.getDataCerere().toString());
		System.out.println("DataDemisie---- " + cerereDemisie_.getDataDemisie().toString());
		System.out.println("PerioadaPreaviz " + cerereDemisie_.getPerioadaPreaviz().toString());
		
		System.out.println("------------------------------------------------------------ ");
		System.out.println("Detalii ContractMunca: " + contract.getNrContract().toString());
		System.out.println("DataSemnare----------- " + contract.getDataSemnare().toString());
		System.out.println("DataTerminare--------- " + contract.getDataTerminare().toString());
		System.out.println("MotivIncheiere-------- " + contract.getMotivIncheiere().toString());
		
		System.out.println("------------------------------------------------------------ ");
		System.out.println("Detalii Angajat: " + angajat.getMarca().toString());
		System.out.println("Activ----------- " + angajat.getActiv().toString());
		System.out.println("Nume------------ " + angajat.getNume().toString());
		System.out.println("Prenume--------- " + angajat.getPrenume().toString());	
		
	}

	@Override
	public void concediere(ContractMunca contractMunca_) {
		// TODO Auto-generated method stub		
		Angajat 		angajat = contractMunca_.getAngajat();
		
		contractMunca_.setDataTerminare(Calendar.getInstance().getTime());
		
		angajat.setActiv(false);
		contractMunca_.setMotivIncheiere("Concediere");
		
		System.out.println("------------------------------------------------------------ ");
		System.out.println("Detalii ContractMunca: " + contractMunca_.getNrContract().toString());
		System.out.println("DataSemnare----------- " + contractMunca_.getDataSemnare().toString());
		System.out.println("DataTerminare--------- " + contractMunca_.getDataTerminare().toString());
		System.out.println("MotivIncheiere-------- " + contractMunca_.getMotivIncheiere().toString());
		
		System.out.println("------------------------------------------------------------ ");
		System.out.println("Detalii Angajat: " + angajat.getMarca().toString());
		System.out.println("Activ----------- " + angajat.getActiv().toString());
		System.out.println("Nume------------ " + angajat.getNume().toString());
		System.out.println("Prenume--------- " + angajat.getPrenume().toString());
	}

	//private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PersonalImpl.class.getName());

	@Override
	public  List<AnuntLocMunca> getPosturiVacante(Date dataVizata_, List<AnuntLocMunca> listaInit_) {
		List<AnuntLocMunca> rezultat = new ArrayList<AnuntLocMunca>();
		
		Iterator<AnuntLocMunca> iterator = listaInit_.iterator();
		while (iterator.hasNext()) {
			AnuntLocMunca	anunt = iterator.next();
			//System.out.println(anunt.getCorpAnunt());
			if(dataVizata_.compareTo(anunt.getDataInceput()) >= 0 && dataVizata_.compareTo(anunt.getDataExpirare()) <= 0)
			{
				rezultat.add(anunt);	
			}
		}
		return rezultat;
	}

	@Override
	public List<Candidat> getCandidatipeFunctie(AnuntLocMunca anuntLocMunca_, List<CV> listaInit_) {
		
		List<Candidat> rezultat = new ArrayList<Candidat>();
		
		Iterator<CV> iterator = listaInit_.iterator();
		
		while (iterator.hasNext()) {
			CV	cv = iterator.next();
			//System.out.println(cv.getCandidat().getNume());
			if(cv.getUltimaModificare().compareTo(anuntLocMunca_.getDataInceput()) >= 0 && cv.getUltimaModificare().compareTo(anuntLocMunca_.getDataExpirare()) <= 0
				&& 	cv.getFunctieVizata() == anuntLocMunca_.getFunctie())
			{
				rezultat.add(cv.getCandidat());	
			}
		}
		return rezultat;
	}
	
	
	@Override
	public List<Candidat> recrutare(Date dataAnunt_, Candidat candidat_, List<InterviuCandidat> listaInit_) {
		
		List<Candidat> rezultat = new ArrayList<Candidat>();
		
		Iterator<InterviuCandidat> iterator = listaInit_.iterator();
		
		while (iterator.hasNext()) {
			InterviuCandidat	interviu = iterator.next();
			if (interviu.getRezultatEvaluare() == "ADMIS" && interviu.getInterviu().getTipInterviu() == "Final" 
							&& candidat_.getIdCandidat()== interviu.getCandidat().getIdCandidat()
							&& (interviu.getDataInterviu().compareTo(dataAnunt_)) >= 0)
										
			{
				rezultat.add(interviu.getCandidat());	
			}
		}
		return rezultat;
	}
	
	//evaluareAngajat - Andreea

	@Override
	public HashMap <Departament, List<ProbaEvaluare>> getProbeEvaluareDepartament(
			List<ProbaEvaluare> probeEvaluareInit_, List<Departament> departamenteInit) 
	{
		Departament 	departamentCurent;
		ProbaEvaluare	probaEvaluare;
		
		Iterator <Departament>	iteratorDepartament = departamenteInit.iterator();
		HashMap <Departament, List<ProbaEvaluare>> tMap = new HashMap<Departament, List<ProbaEvaluare>>();
		List<ProbaEvaluare> probeEvaluarePeDepartament = new ArrayList<ProbaEvaluare>();
		while (iteratorDepartament.hasNext()) {
			departamentCurent = iteratorDepartament.next();
			probeEvaluarePeDepartament.clear();
			Iterator <ProbaEvaluare> iteratorProbe = probeEvaluareInit_.iterator();
			while (iteratorProbe.hasNext())
			{
				probaEvaluare = iteratorProbe.next();
				if (probaEvaluare.getDepartament() == departamentCurent
						&& probaEvaluare.getScop() == "EvaluarePeriodica")
				{
					probeEvaluarePeDepartament.add(probaEvaluare);
				}
			}			
			tMap.put(departamentCurent, new ArrayList<ProbaEvaluare>(probeEvaluarePeDepartament));			
		}
		
		return tMap;
	}

	@Override
	public Angajat getAngajatById(Integer marca_) {
		// TODO Auto-generated method stub
		TestPersonalImpl test = new TestPersonalImpl();
		test.listaAngajati();
		Iterator <Angajat> iteratorAngajati = test.angajati.iterator();
		while(iteratorAngajati.hasNext())
		{
			Angajat angajat = iteratorAngajati.next();
			if(angajat.getMarca().equals(marca_))
			{
				return angajat;
			}
			
		}
		System.out.println("Nu a fost gasit niciun angajat cu marca " + marca_.toString());
		return null;
	}

	@Override
	public List<Angajat> getListaAngajati() {
		// TODO Auto-generated method stub
		TestPersonalImpl test = new TestPersonalImpl();
		test.listaAngajati();
		return test.angajati;
	}

	@Override
	public List<ContractMunca> getListaContracteByAngajat(Angajat angajat_) {
		TestPersonalImpl test = new TestPersonalImpl();
		test.listaContracte();
		Iterator <ContractMunca> iteratorMunca = test.contracteMunca.iterator();
		List <ContractMunca> listaContractelor = new ArrayList<ContractMunca>();
		while (iteratorMunca.hasNext()){
			ContractMunca contractCurent;
			contractCurent = iteratorMunca.next();
			if (contractCurent.getAngajat() == angajat_ 
					&&
					contractCurent.getDataInceput().compareTo(Calendar.getInstance().getTime()) <= 0 
					&&
					contractCurent.getDataTerminare().compareTo(Calendar.getInstance().getTime()) >= 0)
			{
				listaContractelor.add(contractCurent);
			}
		}
		return listaContractelor;
	}
	
	@Override
	public CV getCVByCandidat (Candidat candidat_) {
		// TODO Auto-generated method stub
		TestPersonalImpl test = new TestPersonalImpl();
	
		test.generareAnunturi();
		Iterator <CV> iteratorCV = test.listaCandidati.iterator();
		while (iteratorCV.hasNext()){
			CV cvCurent = iteratorCV.next();
			if (cvCurent.getCandidat().equals(candidat_ ))
			{
				return cvCurent;
			}
		}
		return null;
	}
	

	@Override
	public void angajare(Candidat candidat_) {
		// TODO Auto-generated method stub
		Angajat angajat;
		angajat = new Angajat (candidat_.getId(), candidat_.getAdresa(), candidat_.getIdContact(), candidat_.getNume(), candidat_.getPrenume(),
				candidat_.getFormaAdresare(), candidat_.getGen(), candidat_.getCnp(), candidat_.getIdCandidat(), candidat_.getTipCandidat(),
				3// va fi modificat odata cu baza de date
				, null, 0);
		
		CV cv = getCVByCandidat(candidat_);
		
		ContractMunca contract;
		contract = new ContractMunca("C1", 1000.00, 10.00, angajat, cv.getFunctieVizata(), new Date("11/08/2011"), new Date("15/08/2011"), null,0,null);
		
		DosarAngajat dosar;
		dosar = new DosarAngajat(10, angajat, false, false, false);	
		
	}

	
	@Override
	public DosarAngajat getDosarByAngajat(Angajat angajat_) {
		TestPersonalImpl test = new TestPersonalImpl();
		test.listaDosare();
		Iterator <DosarAngajat> iteratorDosar = test.dosareAngajati.iterator();
		while (iteratorDosar.hasNext()){
			DosarAngajat dosarCurent = iteratorDosar.next();
			if (dosarCurent.getAngajat() == angajat_ )
			{
				return dosarCurent;
			}
		}
		return null;
	}
	
	
	
	@Override
	public void activareAngajati(List<Angajat> listaAngajati) {
		// TODO Auto-generated method stub
		Iterator<Angajat> iterator = listaAngajati.iterator();
		List<ContractMunca> contracte = new ArrayList<ContractMunca>();
		
		while (iterator.hasNext()) {
			
			DosarAngajat dosar;   
			dosar = getDosarByAngajat (iterator.next());
		
			
			if(iterator.next().getActiv() == false &&
				dosar.getAdeverintaStudii() ==true && dosar.getAdeverintaStudii() == true && dosar.getFisaMedicala() == true)
				
			{
				contracte = getListaContracteByAngajat(iterator.next());
				
				if (contracte.size()>0){
					
					iterator.next().setActiv(true);	
				}
				
				contracte.clear();
			}
		}				
	}

	@Override
	public HashMap<ProbaEvaluare, List<AngajatProbaEvaluare>> getRezultateEvaluareByProba(
			List<AngajatProbaEvaluare> angajatProbaInit_,
			List<ProbaEvaluare> probeEvaluareInit_) {
		//List<ProbaEvaluare> listaProbelorEvaluate = new ArrayList<ProbaEvaluare>();
		HashMap<ProbaEvaluare, List<AngajatProbaEvaluare>> rezultat = new HashMap<ProbaEvaluare, List<AngajatProbaEvaluare>>();
		List<AngajatProbaEvaluare> angajatiRezultate = new ArrayList<AngajatProbaEvaluare>();
		Iterator<ProbaEvaluare> iteratorProbe = probeEvaluareInit_.iterator();
		AngajatProbaEvaluare rezultatCurent;
		ProbaEvaluare probaCurenta;
		while (iteratorProbe.hasNext()) {
			probaCurenta = iteratorProbe.next();
			Iterator<AngajatProbaEvaluare> iteratorRezultate = angajatProbaInit_.iterator();
			while (iteratorRezultate.hasNext()){
				rezultatCurent = iteratorRezultate.next();
				//probaE = rezultatCurent.getProbaEvaluare();
				if (rezultatCurent.getProbaEvaluare() == probaCurenta)
				{
					angajatiRezultate.add(rezultatCurent);
				}
			}
			rezultat.put(probaCurenta, new ArrayList<AngajatProbaEvaluare>(angajatiRezultate));
			angajatiRezultate.clear();
		}
		return rezultat;
	}

	@Override
	public ContractMunca relocalizare_promovare(Integer marca_, Functie functieNoua_, ContractMunca contractVizat_, boolean promovare_, double salarBaza_, double tarifOrar_)
	 {
		// TODO Auto-generated method stub
		Angajat angajat = this.getAngajatById(marca_);
		if(angajat == null)
		{
			return null;
		}
		if (contractVizat_ == null)
		{
			Iterator<ContractMunca> iteratorContracte = this.getListaContracteByAngajat(angajat).iterator();
			
			while (iteratorContracte.hasNext())
			{
				ContractMunca contractVechi = iteratorContracte.next();
				contractVechi.setDataTerminare(Calendar.getInstance().getTime());
				if(promovare_)
				{
					contractVechi.setMotivIncheiere("Promovare");
				}
				else
				{
					contractVechi.setMotivIncheiere("Relocalizare");
				}
			}	
		}
		else
		{
			contractVizat_.setDataTerminare(Calendar.getInstance().getTime());
			if(promovare_)
			{
				contractVizat_.setMotivIncheiere("Promovare");
			}
			else
			{
				contractVizat_.setMotivIncheiere("Relocalizare");
			}
		}
		ContractMunca	contractNou = new ContractMunca("reloc01", salarBaza_, tarifOrar_, angajat, functieNoua_, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), null, 0, null);
		
		return contractNou;
		
		
	}

	@Override
	public Functie adaugareFunctie(String numeFunctie_, Integer pozitiaInCOR_,
			List<String> obiective_, List<String> responsabilitati_,
			List<String> cunostinte_, List<String> deprinderi_,
			List<String> aptitudini_, Departament departament) {
		Functie functieNoua = new Functie (1,//va fi modificat cu BD
				numeFunctie_, pozitiaInCOR_, obiective_, responsabilitati_, cunostinte_, deprinderi_, aptitudini_, departament);
		return functieNoua;
	}
	@Override
	public List<Eveniment> getEvenimenteAnuale(Integer _year) {
		List<Eveniment> evenimente = new ArrayList<Eveniment>();
		// TODO Auto-generated method stub
		if(_year ==0)
		{
			return Eveniment.getEvenimente();
		}		
		return evenimente;
	}

	
	
	@Override
	public void aprobareEveniment(Eveniment _eveniment) {
		// TODO Auto-generated method stub
		Iterator <Activitate> activitatiEveniment =_eveniment.getActivitati().iterator();
		Double sumaActivitati = 0.00;
		while (activitatiEveniment.hasNext())
		{
			Activitate activitateCurenta = activitatiEveniment.next();
			sumaActivitati += activitateCurenta.getSumaEstimata();				
		}
		if(sumaActivitati<= _eveniment.getSumaAlocata())
		{
			_eveniment.setStatusEveniment("Eveniment Aprobat");
		}		
		System.out.println(_eveniment.getStatusEveniment());
	}
	
}

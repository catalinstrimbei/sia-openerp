package org.open.erp.services.personal.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.open.erp.services.buget.Buget;
import org.open.erp.services.buget.BugetareSrv;
import org.open.erp.services.buget.LinieBugetara;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Persoana;
//import org.open.erp.services.personal.Activitate;
//import org.open.erp.services.personal.Proiect;
import org.open.erp.services.personal.Angajat;
import org.open.erp.services.personal.AngajatProbaEvaluare;
import org.open.erp.services.personal.AnuntLocMunca;
import org.open.erp.services.personal.CV;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.CerereDemisie;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.Functie;
import org.open.erp.services.personal.InterviuCandidat;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.ProbaEvaluare;

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

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PersonalImpl.class.getName());

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
	public TreeMap <Departament, ProbaEvaluare> getProbeEvaluareDepartament(
			List<ProbaEvaluare> probeEvaluareInit_, List<Departament> departamenteInit) {
		Iterator <ProbaEvaluare> iteratorProbe = probeEvaluareInit_.iterator();
		Iterator <Departament>	iteratorDepartament = departamenteInit.iterator();
		TreeMap <Departament, ProbaEvaluare> tMap = new TreeMap<Departament, ProbaEvaluare>();
		while (iteratorDepartament.hasNext()) {
			while (iteratorProbe.hasNext())
			{
				if (iteratorProbe.next().getDepartament() == iteratorDepartament.next()
						&& iteratorProbe.next().getScop() == "EvaluarePeriodica")
				{
					tMap.put(iteratorDepartament.next(), iteratorProbe.next());
				}
			}
		}
		return tMap;
	}

	@Override
	public TreeMap<ProbaEvaluare, AngajatProbaEvaluare> evaluarePeriodica(
			List<AngajatProbaEvaluare> angajatProbaInit_,
			List<ProbaEvaluare> probeEvaluareInit_) {
				
		Iterator <ProbaEvaluare> iteratorProbe = probeEvaluareInit_.iterator();
		Iterator <AngajatProbaEvaluare>	iteratorAngajatProba = angajatProbaInit_.iterator();
		TreeMap<ProbaEvaluare, AngajatProbaEvaluare> tMap = new TreeMap<ProbaEvaluare, AngajatProbaEvaluare>();
		while (iteratorProbe.hasNext()) {
			while (iteratorAngajatProba.hasNext())
			{
				if (iteratorProbe.next().getScop() == "EvaluarePeriodica" 
						&& iteratorProbe.next() == iteratorAngajatProba.next().getProbaEvaluare())
				{
					tMap.put(iteratorProbe.next(), iteratorAngajatProba.next());
				}
			}
		}
		return tMap;
	}
		
}

package org.open.erp.services.personal.teste;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.*;
import org.open.erp.services.personal.logger.PersonalLogger;

public class TestPersonalEJBBusinessLogic {

	/**
	 * @throws java.lang.Exception
	 */
	/* Resurse test*/
	private static PersonalLogger logger;
	
	/* Unitatea de test sursa/gazda unitatii de test */
	private static PersonalSrv personalInstance;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger = new PersonalLogger();
		InitialContext ctx = initJBossJNDICtx();
		personalInstance = (PersonalSrv)ctx.lookup("PersonalSrv/remote");		
		logger.logINFO("initTest " + personalInstance);
	
	}

	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}	

	@Test
	public void TESTgetDosareAndContracteAngajatEJB() {
		try
		{			
			logger.logINFO("Start test: TESTgetDosareAndContracteAngajatEJB");
			
			Collection<Angajat> listaAngajati = personalInstance.getListaAngajati();
			for(Iterator<Angajat> i = listaAngajati.iterator(); i.hasNext();)
			{
				Angajat angajat = i.next();
				logger.logINFO("Start test: TESTgetContractAngajatActivEJB cu angajat" + angajat.getNume());
				ContractMunca contractActiv = personalInstance.getContractAngajatActivEJB(angajat);
				logger.logINFO("End test: TESTgetContractAngajatActivEJB");
				
				logger.logINFO("Start test: TESTgetDosarByAngajatEJB cu angajat" + angajat.getNume());
				DosarAngajat dosar = personalInstance.getDosarByAngajatEJB(angajat);
				logger.logINFO("End test: TESTgetDosarByAngajatEJB");
				
				Collection<ContractMunca> listaContracte = personalInstance.getListaContracteAngajatEJB(angajat);
				for(Iterator<ContractMunca> j = listaContracte.iterator(); j.hasNext();)
				{
					ContractMunca contract = j.next();
					System.out.println(contract.getNrContract());
				}
			}					
			logger.logINFO("End test: TESTgetDosareAndContracteAngajatEJB");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	@Test
	public void TESTgetCVByCandidatEJB() {
		try
		{
			logger.logINFO("Start test: TESTgetCVByCandidatEJB");
			
			Collection<Candidat> listaCandidati= personalInstance.getListaCandidati();
			for(Iterator<Candidat> i = listaCandidati.iterator(); i.hasNext();)
			{
				CV cvCurent = personalInstance.getCVByCandidatEJB(i.next());
				if(cvCurent != null)
					System.out.println(cvCurent.getNrCV().toString());
			}					
			logger.logINFO("End test: TESTgetCVByCandidatEJB");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	@Test
	public void TESTrecrutareEJB() {
		try
		{
			logger.logINFO("Start test: TESTrecrutareEJB");
			
			Collection<Candidat> listaCandidati= personalInstance.getListaCandidati();
			for(Iterator<Candidat> i = listaCandidati.iterator(); i.hasNext();)
			{
				CV cvCurent = personalInstance.getCVByCandidatEJB(i.next());
				if(cvCurent != null)
					System.out.println(cvCurent.getNrCV().toString());
			}					
			logger.logINFO("End test: TESTrecrutareEJB");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	@Test
	public void TESTangajareEJB() {
		try
		{
			logger.logINFO("Start test: TESTangajareEJB");
			
			Collection<Candidat> listaCandidati= personalInstance.getListaCandidati();
			for(Iterator<Candidat> i = listaCandidati.iterator(); i.hasNext();)
			{
				personalInstance.angajareEJB(i.next());				
			}					
			logger.logINFO("End test: TESTangajareEJB");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	@Test
	public void TESTdemisionareEJB() {
		try
		{
			logger.logINFO("Start test: TESTdemisionareEJB");
			
			Collection<CerereDemisie> listaCereri= personalInstance.getListaCereriDemisie();
			for(Iterator<CerereDemisie> i = listaCereri.iterator(); i.hasNext();)
			{
				personalInstance.demisionareEJB(i.next());				
			}					
			logger.logINFO("End test: TESTdemisionareEJB");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	@Test
	public void TESTconcediereEJB() {
		try
		{
			logger.logINFO("Start test: TESTconcediereEJB");
			
			Collection<ContractMunca> listaContracte = personalInstance.getListaContracteMunca();
			for(Iterator<ContractMunca> j = listaContracte.iterator(); j.hasNext();)
			{
				ContractMunca contract = j.next();
				System.out.println(contract.getNrContract());
				personalInstance.concediereEJB(contract);
			}
			logger.logINFO("End test: TESTconcediereEJB");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	
	@Test
	public void TESTrelocalizare_promovareEJB() {
		try
		{
			logger.logINFO("Start test: TESTrelocalizare_promovareEJB");
			
			Collection<ContractMunca> listaContracte = personalInstance.getListaContracteMunca();
			for(Iterator<ContractMunca> j = listaContracte.iterator(); j.hasNext();)
			{
				ContractMunca contract = j.next();
				System.out.println(contract.getNrContract());
			//	personalInstance.relocalizare_promovareEJB(contract.get);
			}
			logger.logINFO("End test: TESTrelocalizare_promovareEJB");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}
	@Test
		public void TESTgetRezultatePeProbaEvaluare(){
		try{
				logger.logINFO("Start test: TESTgetRezultatePeProbaEvaluare");
			HashMap <ProbaEvaluare, Collection<RezultatProbaEvaluare>> mapFinal = new HashMap <ProbaEvaluare, Collection<RezultatProbaEvaluare>>();
				mapFinal = personalInstance.getRezultateEvaluareByProbaEJB();
				Collection<ProbaEvaluare> keysProbe = new ArrayList<ProbaEvaluare>(mapFinal.keySet());
				Iterator<ProbaEvaluare> iteratorProbe = keysProbe.iterator();
			Collection<RezultatProbaEvaluare> valuesRezultateProbeEvaluare = new ArrayList<RezultatProbaEvaluare>();
				//DummyDepartament depCurent;
				ProbaEvaluare probaEvaluareCurenta;
			RezultatProbaEvaluare rezultatCurent;
			while (iteratorProbe.hasNext()){
				probaEvaluareCurenta = iteratorProbe.next();
					System.out.println("La proba " + probaEvaluareCurenta.getIdProba() + " s-au obtinut urmatoarele rezultate:");
				valuesRezultateProbeEvaluare = mapFinal.get(probaEvaluareCurenta);
					if (valuesRezultateProbeEvaluare.size() > 0) {
						Iterator <RezultatProbaEvaluare> iteratorRezultateProbaEvaluare = valuesRezultateProbeEvaluare.iterator();
						while (iteratorRezultateProbaEvaluare.hasNext()){
							rezultatCurent = iteratorRezultateProbaEvaluare.next();
							Angajat angajatCurent =  rezultatCurent.getAngajat();
						System.out.println(" -- Angajatul: " + angajatCurent.getNume() + " a avut urmatorul rezultat: " + rezultatCurent.getRezultat());
						}
				}
					else{
						System.out.println("Nu exista niciun rezultat pt proba curenta");
					}
				}
				logger.logINFO("End test: TESTgetRezultatePeProbaEvaluare");
		}catch(Exception ex){
				logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
			}
		}
		
}



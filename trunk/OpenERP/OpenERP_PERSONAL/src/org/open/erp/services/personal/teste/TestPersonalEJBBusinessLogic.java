package org.open.erp.services.personal.teste;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.*;
import org.open.erp.services.personal.Candidat;
import org.open.erp.services.personal.ContractMunca;
import org.open.erp.services.personal.PersonalSrv;
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
				DosarAngajat dosar = personalInstance.getDosarByAngajat(angajat);
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

}
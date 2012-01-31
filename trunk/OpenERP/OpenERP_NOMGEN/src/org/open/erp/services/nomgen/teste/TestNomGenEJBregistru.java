package org.open.erp.services.nomgen.teste;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.logger.NomgenLogger;




@SuppressWarnings("unused")
public class TestNomGenEJBregistru {

	
private static NomgenLogger logger;
	
	/* Unitatea de test sursa/gazda unitatii de test */
	private static NomenclatoareSrv NGInstance;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger = new NomgenLogger();
		InitialContext ctx = initJBossJNDICtx();
		NGInstance = (NomenclatoareSrv)ctx.lookup("NomenclatoareSrv/remote");		
		logger.logINFO("initTest " + NGInstance);
	
	}

	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}	
	
	

	
	@Test	
	public void testInserari() throws Exception {
		try
		{
			logger.logINFO("Begin test: Inserari");			
						
			
			TestNomGenImpl test = new TestNomGenImpl();
			
			
			Persoana p = new Persoana();
			p.setAdresa(test.persoana2.getAdresa());
			p.setId(test.persoana2.getId());
			p = NGInstance.addPersoana(test.persoana2);			
			Persoana p2 = NGInstance.addPersoana(test.persoana3);
			Persoana p3 = NGInstance.addPersoana(test.persoana4);
			Persoana p4 = NGInstance.addPersoana(test.persoana5);
			
			
			Departament d1 = NGInstance.addDepartament(test.dep2);
			Departament d2 = NGInstance.addDepartament(test.dep5);
			
			PersoanaFizica pf1 = new PersoanaFizica();
			pf1.setNume(test.pf2.getNume());
			pf1.setPrenume(test.pf2.getPrenume());
			pf1.setCnp(test.pf2.getCnp());
			pf1.setP(test.persoana3);
			pf1 = NGInstance.addPersoanaFizica(test.pf1);
			
			PersoanaFizica pf2 = NGInstance.addPersoanaFizica(test.pf3);
			
			PersoanaJuridica pj1 = new PersoanaJuridica();
			pj1.setCodFiscal(test.pj1.getCodFiscal());
			pj1.setAtributFiscal(test.pj1.getAtributFiscal());
			pj1.setDenumire(test.pj1.getDenumire());
			pj1.setNrInmatriculareFiscala(test.pj1.getNrInmatriculareFiscala());
			pj1.setP(test.persoana7);
			pj1 = NGInstance.addPersoanaJuridica(test.pj1);
			test.AdaugarePersoanePJ();
			
			PersoanaJuridica pj2 = NGInstance.addPersoanaJuridica(test.pj2);
			PersoanaJuridica pj3 = NGInstance.addPersoanaJuridica(test.pj3);
			
			
			
			
			//DummyDepartament departament1 = new DummyDepartament(null, "Departament1", "atributiile vietii");
			
			
			logger.logINFO("End test: Inserari");
		}
		catch(Exception ex)
		{
			logger.logERROR("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.logERROR("<< Stack Trace >>" + st.toString());
		}
	}				
	
	@Test
	public void testPersoanaById() throws Exception {
		try{
		Partener p = NGInstance.getPartenerDupaCodPersoana(5);
		if(p != null)
			System.out.println("Adresa partener: " + p.getAdresa().toString() + "codul de cautare a fost" + p.getP().getAdresa());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		}
	
	
}

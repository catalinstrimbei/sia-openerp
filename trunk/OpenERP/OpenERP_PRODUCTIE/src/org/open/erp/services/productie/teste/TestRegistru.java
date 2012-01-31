package org.open.erp.services.productie.teste;

import static org.junit.Assert.assertNotNull;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.personal.PersonalSrv;
import org.open.erp.services.personal.logger.PersonalLogger;
import org.open.erp.services.productie.CriteriuCalitate;
import org.open.erp.services.productie.FluxProductie;
import org.open.erp.services.productie.ProductieSrv;



public class TestRegistru {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestProductie.class.getName());
	
	private static ProductieSrv productie;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		InitialContext ctx = initJBossJNDICtx();
		productie = (ProductieSrv)ctx.lookup("ProductieSrv/remote");		
		logger.info("initTest " + productie);
	
	}
	private static InitialContext initJBossJNDICtx() throws NamingException {
		 Properties props = new Properties();
	        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
	props.put("java.naming.provider.url", "jnp://localhost:1099/");
	props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
	        return new InitialContext(props);
	}

	
	@Test
	/*public void testInserari() throws Exception {
		try
		{
			logger.info("Begin test: Inserari");
			
			
			FluxProductie flux=new FluxProductie();
			logger.info("-------nou flux-----------");
			flux.setIdFlux(1);
			logger.info("-------id flux-----------"+ flux.getIdFlux());
			flux.setProdus(null);
			logger.info("-------produs flux-----------"+flux.getProdus());
			flux = productie.definireFluxProductie(1, null);
			logger.info("-------salvare flux-----------"+flux.getIdFlux());
		} 
		catch(Exception ex)
		{
			logger.info("Class >> " + ex.getClass().toString() + "<< StackTrace >> " + ex.getStackTrace().toString() + "<< Error >> " + ex.getMessage().toString());
			ex.printStackTrace();   StringWriter st = new StringWriter(); PrintWriter pt = new PrintWriter(st); ex.printStackTrace(pt); logger.info("<< Stack Trace >>" + st.toString());
		}
		
	}*/
	public void testInserariCriteriuCalitate() throws Exception{
		/*CriteriuCalitate criteriuCalitate = new CriteriuCalitate();
		logger.info("-------nou criteriu calitate-----------");
		criteriuCalitate.setIdCriteriu(1);
		logger.info("-------id criteiru calitate-----------" + criteriuCalitate.getIdCriteriu());
		criteriuCalitate.setCriteriu("criteriu nou");
		logger.info("-------denumire criteriu calitate-----------" + criteriuCalitate.getCriteriu());*/
		logger.info("-------nou criteriu calitate-----------");
		CriteriuCalitate criteriuCalitate=productie.salveazaCriteriuCalitate(1,"criteriu");
		logger.info("-------salvare criteriu calitate-----------"+criteriuCalitate.getIdCriteriu()); 
		  
		assertNotNull("Metoda de creare a criteirului nu a functionat!", criteriuCalitate.getIdCriteriu());
		 
		logger.info("End test: criteriu"); 
	}
	
}
		

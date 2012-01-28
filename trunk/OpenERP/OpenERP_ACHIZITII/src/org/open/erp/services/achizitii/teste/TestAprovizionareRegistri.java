package org.open.erp.services.achizitii.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.achizitii.AprovizionareSrv;
import org.open.erp.services.achizitii.Categorie;
import org.open.erp.services.achizitii.impl.AprovizionareImpl;
import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.stocuri.StocuriSrv;


public class TestAprovizionareRegistri {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TestAprovizionareEJBLogic.class.getName());
	static StocuriSrv stocuriInstance;
	static AprovizionareSrv aprovizionareInstance;
	static NomenclatoareSrv nomenclatorInstance;
	static ContabilizareSrv contabgenInstance;
	/*static AprovizionareImpl ap;*/
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		InitialContext ctx = initJBossJNDICtx();		
		stocuriInstance = (StocuriSrv)ctx.lookup("StocuriSrv/remote");	
		aprovizionareInstance=(AprovizionareSrv)ctx.lookup("AprovizionareSrv/remote");
		nomenclatorInstance=(NomenclatoareSrv)ctx.lookup("NomenclatoareSrv/remote");
		contabgenInstance=(org.open.erp.services.ctbgen.ContabilizareSrv)ctx.lookup("ContabilizareSrv/remote");
	
	}

	private static InitialContext initJBossJNDICtx() throws NamingException{
		Properties props = new Properties();
        props.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");		
        props.put("java.naming.provider.url", "jnp://localhost:1099/");
        props.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        return new InitialContext(props);
	}
	

	@Before
	public void setUp() throws Exception {		
		/*aprovizionareInstance= AprovizionareFactory.getAprovizionareSrv();
		nomenclatorInstance=AprovizionareFactory.getNomenclatoareSrv();
		contabgenInstance=AprovizionareFactory.getContabGenSrv();
		stocuriInstance=AprovizionareFactory.getStocuriSrv();		
		logger.info("initTest");	*/
	    
	}
	@SuppressWarnings("static-access")
	@Test	
	public void testInsert() throws Exception {
		try
		{
			logger.debug("Begin test: Insert-uri");			
		@SuppressWarnings("unused")
		List<Categorie> listCategorii =new ArrayList<Categorie>();	
		Categorie cat = new Categorie(1,"Categorie1");
		//this.aprovizionareInstance.registru.salveazaCategorie(cat);
			
			logger.debug("End test: Insert-uri");
		}
		catch(Exception ex)
		{
			logger.debug("ERROR: "+ex.getMessage());
		}
	}			

}

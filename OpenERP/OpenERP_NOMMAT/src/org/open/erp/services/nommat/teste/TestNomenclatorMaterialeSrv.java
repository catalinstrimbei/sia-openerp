package org.open.erp.services.nommat.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;


public class TestNomenclatorMaterialeSrv {
	private static Logger logger;
	NomenclatorMaterialeSrv nomenInstance;
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestNomenclatorMaterialeSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		nomenInstance= NomenclatorMaterialeSrvFactory.getNomenSrv();
		logger.debug("NomenclatoareSrv Service intiated for Test!");
	}
	
	
	@Test
	public void testIntroducereMaterial() throws Exception{
		ListaCaracteristici caract = nomenInstance.incarcareLista("1", "Material Dur");
		Material mat = nomenInstance.introducereMaterial("1", "fier", "20", "5"," 1.2", null, caract);
		logger.debug("++++++ Afisare Material: " + mat.getDenumireMaterial() + "; "+ "Detalii: " + mat.getPretStandard() + ", " + mat.getCantitateStandard());
		logger.debug("++++ Afisare ListaCaract: " + caract.getId() + " " + caract.getListaCaracteristici());
		
	}
   
}
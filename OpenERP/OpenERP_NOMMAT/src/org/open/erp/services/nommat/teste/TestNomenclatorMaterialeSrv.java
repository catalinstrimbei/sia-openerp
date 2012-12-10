package org.open.erp.services.nommat.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nommat.ListaCaracteristici;
import org.open.erp.services.nommat.Material;
import org.open.erp.services.nommat.NomenclatorMaterialeSrv;
import org.open.erp.services.nommat.teste.NomenclatorMaterialeSrvFactory;
import org.open.erp.services.nommat.teste.TestNomenclatorMaterialeSrv;


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
		Material mat = nomenInstance.introducereMaterial("1", "fier", "20", "5"," 1.2", null, "materie prima", caract);
		logger.debug("++++++ Afisare Material: " + mat.getDenumireMaterial() + "; "+ "Detalii: " + mat.getPretStandard() + ", " + mat.getCantitateStandard());
		logger.debug("++++ Afisare ListaCaract: " + caract.getId() + " " + caract.getListaCaracteristici());
		
	}
	
	@Test
	public void testCautareMaterial() throws Exception{
		  ListaCaracteristici caract = nomenInstance.incarcareLista("2", "Material Fin");
		  Material mat = nomenInstance.introducereMaterial("2", "Canepa", "20", "5"," 1.2", null,"materie prima", caract);
		  String denumire= "Canepa";
		  logger.debug("Cautare material Canepa:" + nomenInstance.cautareMaterialDupaDenumire(denumire));
		  
		 }
	@Test
	public void testModificareMaterial() throws Exception{
		ListaCaracteristici caract = nomenInstance.incarcareLista("2", "Material Fin");
		  Material mat = nomenInstance.introducereMaterial("2", "Canepa", "20", "5"," 1.2", null,"materie prima", caract);
		  String codMaterial="2";
		  String newcodMaterial="24";
		  String newdenumireMaterial="Canepa finisata";
		  String newcantitateStandard="700";
		  String newpretStandard="25";
		  String newcategorieMaterial="produs finisat";
		  String newprocentTVACurent="2.63";
		  String newobservatii="Se distribuie corect";
		  ListaCaracteristici newcaracteristici=caract;
		  Boolean overwrite=true;
		 
		  logger.debug("Modificare material Canepa:" + codMaterial + " cu " + newcodMaterial +" avand noua denumire "+ newdenumireMaterial +  nomenInstance.modificareMaterial(codMaterial, newcodMaterial, newdenumireMaterial, newcantitateStandard, newpretStandard,
					newcategorieMaterial,  newprocentTVACurent,  newobservatii, newcaracteristici, overwrite));
	}
	@Test
	public void testStergereMaterial() throws Exception{
		ListaCaracteristici caract = nomenInstance.incarcareLista("2", "Material Fin");
		  Material mat = nomenInstance.introducereMaterial("2", "Canepa", "20", "5"," 1.2", null,"materie prima", caract);
		  String codMat="2";
		  logger.debug("Stergere material dupa cod" +  nomenInstance.stergereMaterial(codMat));
		 
	}


   
}

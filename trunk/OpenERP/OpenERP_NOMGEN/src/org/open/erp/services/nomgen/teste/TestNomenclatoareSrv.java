package org.open.erp.services.nomgen.teste;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.open.erp.services.nomgen.Adresa;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Divizie;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.Subdepartament;


public class TestNomenclatoareSrv {
	private static Logger logger;
	NomenclatoareSrv nomenInstance;
	
	@BeforeClass
	public static void initLocalJavaLogger(){
		logger =  Logger.getLogger(TestNomenclatoareSrv.class.getName());	
	}
	
	@Before public void initServices(){	
		nomenInstance= NomenclatoareSrvFactory.getNomenSrv();
		logger.debug("NomenclatoareSrv Service intiated for Test!");
	}
	
	
	
	@Test
	public void testCreareAdresa() throws Exception{
		Adresa adr = nomenInstance.creareAdresa ("1", "Iasi", "Iasi", "Ro", "St", "700358");		
		logger.debug("++ Afisare adresa: " + adr.getStrada() + " " + adr.getCodPostal() + " "
				+ adr.getLocalitate() + " " + adr.getJudet() + " " +adr.getTara());
		
	}
	
	

	@Test
	public void testCrearePersoanaFizica() throws Exception{
		Adresa adr = nomenInstance.creareAdresa ("1", "Iasi", "Iasi", "Ro", "St", "700358");		
		PersoanaFizica pers = nomenInstance.crearePF(1, "Test", "M", "ics@yahoo.co","Anngajat", null, "12-03-1988", "074444445", adr );
		logger.debug("++++++ Afisare persoana: " + pers.getNume() + "; "+ "Detalii: " + pers.getSex() + ", " + pers.getTelefon());
		logger.debug("++++ Afisare adresa: " + adr.getStrada() + " " + adr.getCodPostal() + " "
				+ adr.getLocalitate() + " " + adr.getJudet() + " " +adr.getTara());
		
	}
    @Test
	public void testCrearePersoanaJuridica() throws Exception{
		Adresa adr = nomenInstance.creareAdresa ("1", "Iasi", "Iasi", "Ro", "Str. Independentei", "762900");		
		PersoanaJuridica persjr = nomenInstance.crearePJ(1, "Rulmenti", "Denumire Firma?", "Societate pe actiuni","6749783", "RO28247273", adr );
		logger.debug("++++++ Afisare persoana juridica: " + persjr.getNume() + ";"  + "CUI: " + persjr.getCUI() + "," +"Cod Fiscal: " + persjr.getCodFiscal()+ ", " + "TipFirma: " + persjr.getTipFirma());
		logger.debug("++++ Afisare adresa: " + adr.getStrada() + " " + adr.getCodPostal() + " "
				+ adr.getLocalitate() + " " + adr.getJudet() + " " +adr.getTara());
			}
   
    @Test
    
	public void testCreareDepart() throws Exception{
		Departament dep = nomenInstance.creareDepart("1", "Dep1");
		logger.debug("++ Afisare departament: " +  dep.getDenumire() );
}

    
@Test
	public void testCreareDivizieNoua() throws Exception{
		Departament dep = nomenInstance.creareDepart("1", "Dep1");
		Subdepartament sub = nomenInstance.creareSubDep("1", "Sub1", "test",dep);
		Divizie div = nomenInstance.creareDivizie("1", "Div", "test", dep, " ", sub);
		logger.debug("1.7 Afisare divizie: " + div.getDenumire() + ", subdepartament: " + sub.getDenumire() + ", departament: " + dep.getDenumire() );
}
}
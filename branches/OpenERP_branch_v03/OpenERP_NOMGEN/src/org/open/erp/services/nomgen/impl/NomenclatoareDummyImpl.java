package org.open.erp.services.nomgen.impl;

import java.util.Date;

import org.open.erp.services.nomgen.Banca;
import org.open.erp.services.nomgen.Departament;
import org.open.erp.services.nomgen.Divizie;

import org.open.erp.services.nomgen.MateriePrima;
import org.open.erp.services.nomgen.MijlocFix;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Partener;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.nomgen.PersoanaFizica;
import org.open.erp.services.nomgen.PersoanaJuridica;
import org.open.erp.services.nomgen.Produs;

/**
 * 
 * @ApplicationServiceFacadeImpl(Dummy)
 * 
 */
public class NomenclatoareDummyImpl implements NomenclatoareSrv {

	@Override
	public Persoana creazaPersoana(Integer id, String adresa) {
		Persoana persoana = new Persoana();
		
		persoana.setId(id);
		persoana.setAdresa(adresa);
		
		
		return persoana;
	}

	@Override
	public Persoana getPersoanaCuId(Integer id) {
		Persoana persoanaDummy = new Persoana();
		
		persoanaDummy.setId(id);
		persoanaDummy.setAdresa("dummy");

		
		return persoanaDummy;
	}
	
	@Override
	public Persoana cautarePersoanaDupaAdresa(String adresa) {
		Persoana persoanaDummy = new Persoana();
		
		persoanaDummy.setId(-1);
		persoanaDummy.setAdresa(adresa);
		
		
		return persoanaDummy;
	}
	
	
	@Override
	public PersoanaFizica creazaPersoanaFizica(Integer id, String adresa,
                                               String nume, String prenume, String formaAdresare, char gen, String cnp) {
		PersoanaFizica persoanaFizica = new PersoanaFizica();
		
		persoanaFizica.setId(id);
		persoanaFizica.setAdresa(adresa);
		
		persoanaFizica.setNume(nume);
		persoanaFizica.setPrenume(prenume);
		persoanaFizica.setFormaAdresare(formaAdresare);
		persoanaFizica.setGen(gen);
		persoanaFizica.setCnp(cnp);
		
		return persoanaFizica;
	}
	
	@Override
	public PersoanaFizica getPersoanaFizicaCuId(Integer id) {
		PersoanaFizica persoanaFizicaDummy = new PersoanaFizica();
		
		persoanaFizicaDummy.setId(id);
		persoanaFizicaDummy.setAdresa("dummy");
	
		persoanaFizicaDummy.setNume("dummy");
		persoanaFizicaDummy.setPrenume("dummy");
		persoanaFizicaDummy.setGen('M');
		persoanaFizicaDummy.setCnp("dummy");
		
		return persoanaFizicaDummy;
	}

	@Override
	public PersoanaFizica cautarePersoanaFizicaDupaNume(String nume) {
		PersoanaFizica persoanaFizicaDummy = new PersoanaFizica();
		
		persoanaFizicaDummy.setId(-1);
		persoanaFizicaDummy.setAdresa("dummy");
		
		persoanaFizicaDummy.setNume(nume);
		persoanaFizicaDummy.setPrenume("dummy");
		persoanaFizicaDummy.setGen('M');
		persoanaFizicaDummy.setCnp("dummy");
		
		return persoanaFizicaDummy;
	}
	
	@Override
	public PersoanaFizica cautarePersoanaFizicaDupaPrenume(String prenume) {
		PersoanaFizica persoanaFizicaDummy = new PersoanaFizica();
		
		persoanaFizicaDummy.setId(-1);
		persoanaFizicaDummy.setAdresa("dummy");
		
		persoanaFizicaDummy.setNume("dummy");
		persoanaFizicaDummy.setPrenume(prenume);
		persoanaFizicaDummy.setGen('M');
		persoanaFizicaDummy.setCnp("dummy");
		
		return persoanaFizicaDummy;
	}
	
	@Override
	public PersoanaFizica cautarePersoanaFizicaDupaAdresa(String adresa) {
		PersoanaFizica persoanaFizicaDummy = new PersoanaFizica();
		
		persoanaFizicaDummy.setId(-1);
		persoanaFizicaDummy.setAdresa(adresa);
		
		persoanaFizicaDummy.setNume("dummy");
		persoanaFizicaDummy.setPrenume("dummy");
		persoanaFizicaDummy.setGen('M');
		persoanaFizicaDummy.setCnp("dummy");
		
		return persoanaFizicaDummy;
	}
	
	
	@Override
    public PersoanaJuridica creazaPersoanaJuridica(Integer id, String adresa,
                                                   String denumire, String codFiscal, String nrInmatriculareFiscala, String atributFiscal) {
		PersoanaJuridica persoanaJuridica = new PersoanaJuridica();
		
		persoanaJuridica.setId(id);
		persoanaJuridica.setAdresa(adresa);
		
		persoanaJuridica.setDenumire(denumire);
		persoanaJuridica.setCodFiscal(codFiscal);
		persoanaJuridica.setNrInmatriculareFiscala(nrInmatriculareFiscala);
		persoanaJuridica.setAtributFiscal(atributFiscal);
		
		return persoanaJuridica;
	}
	
	@Override
    public PersoanaJuridica getPersoanaJuridicaCuId(Integer id) {
		PersoanaJuridica persoanaJuridicaDummy = new PersoanaJuridica();
		
		persoanaJuridicaDummy.setId(id);
		persoanaJuridicaDummy.setAdresa("dummy");
		
		persoanaJuridicaDummy.setDenumire("dummy");
		persoanaJuridicaDummy.setCodFiscal("dummy");
		persoanaJuridicaDummy.setNrInmatriculareFiscala("dummy");
		persoanaJuridicaDummy.setAtributFiscal("dummy");
		
		return persoanaJuridicaDummy;
	}
	
	@Override
	public PersoanaJuridica cautarePersoanaJuridicaDupaDenumire(String denumire) {
		PersoanaJuridica persoanaJuridicaDummy = new PersoanaJuridica();
		
		persoanaJuridicaDummy.setId(-1);
		persoanaJuridicaDummy.setAdresa("dummy");
		
		persoanaJuridicaDummy.setDenumire(denumire);
		persoanaJuridicaDummy.setCodFiscal("dummy");
		persoanaJuridicaDummy.setNrInmatriculareFiscala("dummy");
		persoanaJuridicaDummy.setAtributFiscal("dummy");
		
		return persoanaJuridicaDummy;
	}
	
	@Override
	public PersoanaJuridica cautarePersoanaJuridicaDupaAdresa(String adresa) {
		PersoanaJuridica persoanaJuridicaDummy = new PersoanaJuridica();
		
		persoanaJuridicaDummy.setId(-1);
		persoanaJuridicaDummy.setAdresa(adresa);
		
		persoanaJuridicaDummy.setDenumire("dummy");
		persoanaJuridicaDummy.setCodFiscal("dummy");
		persoanaJuridicaDummy.setNrInmatriculareFiscala("dummy");
		persoanaJuridicaDummy.setAtributFiscal("dummy");
		
		return persoanaJuridicaDummy;
	}
	
	
	@Override
	public Produs creazaProdus(Integer id, String denumire, String unitateMasura, Date dataFabricatiei, Integer termenValabilitate) {
		Produs produs = new Produs();
		
		produs.setId(id);
		produs.setDenumire(denumire);
		produs.setUnitateMasura(unitateMasura);
		produs.setDataFabricatiei(dataFabricatiei);
		produs.setTermenValabilitate(termenValabilitate);
		
		return produs;
	}
	
	@Override
	public Produs getProdusCuId(Integer id) {
		Produs produsDummy = new Produs();
		
		produsDummy.setId(id);
		produsDummy.setDenumire("dummy");
		produsDummy.setUnitateMasura("dummy");
		produsDummy.setDataFabricatiei(new Date());
		produsDummy.setTermenValabilitate(-1);
		
		return produsDummy;
	}
	
	@Override
	public Produs cautareProdusDupaDenumire(String denumire) {
		Produs produsDummy = new Produs();
		
		produsDummy.setId(-1);
		produsDummy.setDenumire(denumire);
		produsDummy.setUnitateMasura("dummy");
		produsDummy.setDataFabricatiei(new Date());
		produsDummy.setTermenValabilitate(-1);
		
		return produsDummy;
	}
	
	
	@Override
	public MateriePrima creazaMateriePrima(Integer id, String denumire, String unitateMasura, Date dataFabricatiei, Integer termenValabilitate) {
		MateriePrima materiePrima = new MateriePrima();
		
		materiePrima.setId(id);
		materiePrima.setDenumire(denumire);
		materiePrima.setUnitateMasura(unitateMasura);
		materiePrima.setDataFabricatiei(dataFabricatiei);
		materiePrima.setTermenValabilitate(termenValabilitate);
		
		return materiePrima;
	}
	
	@Override
	public MateriePrima getMateriePrimaCuId(Integer id) {
		MateriePrima materiePrimaDummy = new MateriePrima();
		
		materiePrimaDummy.setId(id);
		materiePrimaDummy.setDenumire("dummy");
		materiePrimaDummy.setUnitateMasura("dummy");
		materiePrimaDummy.setDataFabricatiei(new Date());
		materiePrimaDummy.setTermenValabilitate(-1);
		
		return materiePrimaDummy;
	}
	
	@Override
	public MateriePrima cautareMateriePrimaDupaDenumire(String denumire) {
		MateriePrima materiePrimaDummy = new MateriePrima();
		
		materiePrimaDummy.setId(-1);
		materiePrimaDummy.setDenumire(denumire);
		materiePrimaDummy.setUnitateMasura("dummy");
		materiePrimaDummy.setDataFabricatiei(new Date());
		materiePrimaDummy.setTermenValabilitate(-1);
		
		return materiePrimaDummy;
	}
	
// Bianca - Mijloc Fix si Partener
	
	@Override
	public MijlocFix creazaMijlocFix(Integer id, String denumire, String adresa, Integer valoare, Integer termenExploatare) {
		MijlocFix mijlocFix = new MijlocFix();
		
		mijlocFix.setId(id);
		mijlocFix.setDenumire(denumire);
		mijlocFix.setAdresa(adresa);
		mijlocFix.setValoare(valoare);
		mijlocFix.setTermenExploatare(termenExploatare);
		
		return mijlocFix;
		}

		
	@Override
	public MijlocFix getMijlocFixCuId(Integer id){
	   
		MijlocFix mijlocfixDummy = new MijlocFix();
		
		mijlocfixDummy.setId(id);
		mijlocfixDummy.setDenumire("dummy");
		mijlocfixDummy.setAdresa("dummy");
		mijlocfixDummy.setValoare(-1);
		mijlocfixDummy.setTermenExploatare(-1);
		
		return mijlocfixDummy;
	}
	
	@Override
	public MijlocFix cautareMijlocFixDupaDenumire(String denumire) {
		
		MijlocFix mijlocfixDummy = new MijlocFix();
		
		mijlocfixDummy.setId(-1);
		mijlocfixDummy.setDenumire(denumire);
		mijlocfixDummy.setAdresa("dummy");
		mijlocfixDummy.setValoare(-1);
		mijlocfixDummy.setTermenExploatare(-1);
		
		return mijlocfixDummy;
	}
 
    public MijlocFix cautareMijlocFixDupaAdresa(String adresa) {
		
		MijlocFix mijlocfixDummy = new MijlocFix();
		
		mijlocfixDummy.setId(-1);
		mijlocfixDummy.setDenumire("dummy");
		mijlocfixDummy.setAdresa(adresa);
		mijlocfixDummy.setValoare(-1);
		mijlocfixDummy.setTermenExploatare(-1);
		
		return mijlocfixDummy;
	}
	
	
	@Override
	public Partener creazaPartener(Integer id,Integer idPersoana,Date dataAfilierii,Integer durataAfilierii) {
		Partener partener= new Partener();
		
		partener.setId(id);
		partener.setIdPersoana(idPersoana);
		partener.setDataAfilierii(dataAfilierii);
		partener.setDurataAfilierii(durataAfilierii);
				
		return partener;
	}
	
	@Override
	public Partener getPartenerCuId(Integer id) {
		Partener  partenerDummy = new Partener();
		
		partenerDummy.setId(id);
		partenerDummy.setIdPersoana(-1);
		partenerDummy.setDataAfilierii(new Date());
		partenerDummy.setDurataAfilierii(-1);
	
		
		return partenerDummy;
	}
	
	@Override
	public Partener cautarePartenerDupaIdPersoana(Integer IdPersoana) {
		Partener  partenerDummy= new Partener();
		
		partenerDummy.setId(-1);
		partenerDummy.setIdPersoana(IdPersoana);
		partenerDummy.setDataAfilierii(new Date());
		partenerDummy.setDurataAfilierii(-1);
			
		return partenerDummy;
	}

	//Max 
	
	@Override
	public Banca creazaBanca(Integer id, String capSocial, String denumire) {
		Banca banca = new Banca();
		
		banca.setId(id);
		
		banca.setCapSocial(capSocial);
		banca.setDenumire(denumire);
		
		return banca;
	}
	
	@Override
	public Banca getBancaCuId(Integer id) {
		Banca  bancaDummy = new Banca();
		
		bancaDummy.setId(id);
		
		bancaDummy.setCapSocial("dummy");
	
		
		return bancaDummy;
	}
	
	@Override
	public Banca cautareBancaDupaId(Integer id) {
		Banca  bancaDummy= new Banca();
		
		bancaDummy.setId(1);
	
		bancaDummy.setCapSocial("dummy");
			
		return bancaDummy;
	}
	
	public Banca cautareBancaDupaDenumire(String denumire) {
		Banca  bancaDummy= new Banca();
		
		bancaDummy.setId(-1);
		
		bancaDummy.setCapSocial("dummy");
		bancaDummy.setDenumire("dummy");
			
		return bancaDummy;
	}
	
	@Override
	public Departament creazaDepartament(Integer id, String denumire, String atributii) {
		Departament departament = new Departament();
		
		departament.setId(id);
		departament.setDenumire(denumire);
		departament.setAtributii(atributii);
		
		
		return departament;
	}
	
	@Override
	public Departament getDepartamentCuId(Integer id) {
		Departament  departamentDummy = new Departament();
		
		departamentDummy.setId(id);
		departamentDummy.setDenumire("dummy");
		departamentDummy.setAtributii("dummy");
		
		
		return departamentDummy;
	}
	
	@Override
	public Departament cautareDepartamentDupaId(Integer id) {
		Departament  departamentDummy= new Departament();
		
		departamentDummy.setId(1);
		departamentDummy.setDenumire("dummy");
		departamentDummy.setAtributii("dummy");
		
			
		return departamentDummy;
	}
	
	@Override
	public Departament cautareDepartamentDupaDenumire(String denumire) {
		Departament  departamentDummy= new Departament();
		
		departamentDummy.setId(-1);
		departamentDummy.setDenumire("dummy");
		departamentDummy.setAtributii("dummy");
		
		departamentDummy.setDenumire("dummy");
			
		return departamentDummy;
	}
	
	@Override
	public Divizie creazaDivizie(Integer id, Departament idDepartament, String denumire, String atributii) {
		Divizie divizie = new Divizie();
		
		divizie.setId(id);
		divizie.setIdDepartament(idDepartament);
		divizie.setDenumire(denumire);
		divizie.setAtributii(atributii);
		
		
		return divizie;
	}
	
	@Override
	public Divizie getDivizieCuId(Integer id) {
		Divizie  divizieDummy = new Divizie();
		
		divizieDummy.setId(id);
		divizieDummy.setIdDepartament(new Departament());
		divizieDummy.setDenumire("dummy");
		divizieDummy.setAtributii("dummy");
		
		
		return divizieDummy;
	}
	
	@Override
	public Divizie cautareDivizieDupaId(Integer id) {
		Divizie  divizieDummy= new Divizie();
		
		divizieDummy.setId(1);
		divizieDummy.setIdDepartament(new Departament());
		divizieDummy.setDenumire("dummy");
		divizieDummy.setAtributii("dummy");
	
			
		return divizieDummy;
	}
	
	@Override
	public Divizie cautareDivizieDupaDenumire(String denumire) {
		Divizie  divizieDummy= new Divizie();
		
		divizieDummy.setId(-1);
		divizieDummy.setIdDepartament(new Departament());
		divizieDummy.setDenumire("dummy");
		divizieDummy.setAtributii("dummy");
		
			
		return divizieDummy;
	}
	
}
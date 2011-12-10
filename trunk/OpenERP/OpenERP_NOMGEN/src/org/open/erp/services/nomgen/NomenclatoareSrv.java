package org.open.erp.services.nomgen;

import java.util.Date;

/**
 * 
 * @author catalin.strimbei
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 */

public interface NomenclatoareSrv {
	Persoana creazaPersoana(Integer id, String adresa);
	Persoana getPersoanaCuId(Integer id);
	Persoana cautarePersoanaDupaAdresa(String adresa);
	
	
	PersoanaFizica creazaPersoanaFizica(Integer id, String adresa,
			                            String nume, String prenume, String formaAdresare, char gen, String cnp);
	PersoanaFizica getPersoanaFizicaCuId(Integer id);
	PersoanaFizica cautarePersoanaFizicaDupaNume(String nume);
	PersoanaFizica cautarePersoanaFizicaDupaPrenume(String prenume);
	PersoanaFizica cautarePersoanaFizicaDupaAdresa(String adresa);
	
	
	PersoanaJuridica creazaPersoanaJuridica(Integer id, String adresa,
			                                String denumire, String codFiscal, String nrInmatriculareFiscala, String atributFiscal);
	PersoanaJuridica getPersoanaJuridicaCuId(Integer id);
	PersoanaJuridica cautarePersoanaJuridicaDupaDenumire(String denumire);
	PersoanaJuridica cautarePersoanaJuridicaDupaAdresa(String adresa);
	
	
	Produs creazaProdus(Integer id, String denumire, String unitateMasura, Date dataFabricatiei, Integer termenValabilitate);
	Produs getProdusCuId(Integer id);
	Produs cautareProdusDupaDenumire(String denumire);
	
	
	MateriePrima creazaMateriePrima(Integer id, String denumire, String unitateMasura, Date dataFabricatiei, Integer termenValabilitate);
	MateriePrima getMateriePrimaCuId(Integer id);
	MateriePrima cautareMateriePrimaDupaDenumire(String denumire);
	
	//Bianca - MijlocFix si Partener
	
	MijlocFix creazaMijlocFix(Integer id, String denumire, String adresa, Integer valoare, Integer termenExploatare);
	MijlocFix getMijlocFixCuId(Integer id);
	MijlocFix cautareMijlocFixDupaDenumire(String denumire);
	
	Partener creazaPartener(Integer id,Integer idPersoana,Date dataAfilierii,Integer durataAfilierii);
	Partener getPartenerCuId(Integer id);
	Partener cautarePartenerDupaIdPersoana(Integer IdPersoana);
	
	// Max - Banca, Depatament, Divizie
	
	Banca creazaBanca(Integer id, String capSocial, String denumire);
	Banca getBancaCuId(Integer id);
	Banca cautareBancaDupaId(Integer id);
	Banca cautareBancaDupaDenumire(String denumire);
	
	Departament creazaDepartament(Integer id, String denumire, String atributii);
	Departament getDepartamentCuId(Integer id);
	Departament cautareDepartamentDupaId(Integer id);
	Departament cautareDepartamentDupaDenumire(String denumire);
	
	
	Divizie creazaDivizie(Integer id, Departament idDepartament, String denumire, String atributii);
	Divizie getDivizieCuId(Integer id);
	Divizie cautareDivizieDupaId(Integer id);
    Divizie cautareDivizieDupaDenumire(String denumire);
    
    
    
}

package org.open.erp.services.nomgen;

import javax.ejb.Remote;

@Remote
public interface NomenclatoareSrv {

	PersoanaFizica crearePF (Integer id, String nume,String sex,String mail,String statutInCompanie,String stareCivila,String dataNastere,String telefon,Adresa adresa);
	PersoanaJuridica crearePJ (Integer id, String nume, String denumireFirma,String tipFirma,String CUI,String codFiscal,Adresa adresa);
	Adresa creareAdresa (String id,String localitate,String judet,String tara,String strada,String codPostal);
	Departament creareDepart (String id, String denumire);
	Subdepartament creareSubDep (String id, String denumire, String descriere, Departament parinte);
		Divizie creareDivizie (String id,String denumire, String descriere, Departament parinte,String dataInfiintarii, Subdepartament parinte2);
	Persoana findPersoanaById(Integer idPersoana);
}

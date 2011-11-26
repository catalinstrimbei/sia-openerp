package org.open.erp.services.nomgen;


/**
 * 
 * @author catalin.strimbei
 * 
 * @ApplicationServiceFacade(ServiceDummyAPI)
 */

public interface NomenclatoareSrv {
	Persoana creazaPersona(Integer idPersoana, String nume, String prenume);
	Persoana getPersoanaCuId(Integer idPersoana);
	Document getDocument(Integer nrDocument, String data, String observatie, Persoana persoana);
}

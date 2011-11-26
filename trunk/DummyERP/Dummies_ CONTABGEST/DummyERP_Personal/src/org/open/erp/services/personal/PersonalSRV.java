package org.open.erp.services.personal;




public interface PersonalSRV {
	
	Persoana creazaPersona(Integer idPersoana, String nume, String prenume);
	Persoana getPersoanaCuId(Integer idPersoana);
}

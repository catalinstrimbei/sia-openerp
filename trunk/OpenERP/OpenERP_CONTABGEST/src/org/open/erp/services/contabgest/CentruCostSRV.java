package org.open.erp.services.contabgest;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Remote;


import org.open.erp.services.personal.Angajat;
import org.open.erp.services.productie.FazaProductie;

/**
 * 
 * @author andreea.andronic, marius.borsan, andreea.zaharia, anca.zavate
 * 
 * @ApplicationServiceFacade(ServiceAPI)
 * 
 * @Dependente: CosturiPrimareSrv, PersonalSrv
 * 
 * @EntitatiNomGen: Responsabil
 * 
 * @EntitatiAlteSrv:
 * 
 * @EntitatiLocale: CentruCost, CosturiPrimare
 * 
 * @UseCase("initiere centru cost"): 1. Creaza instanta centru cost 2. Alocare
 *                    costuri *. Returneata centruCost initializat in IN_ALOCARE
 * 
 * @UseCase("initiere centru cost"):
 * 
 */
@Remote
public interface CentruCostSRV {

	/**
	 * Returneaza un centru de cost templetizat.
	 * 
	 * @param nume
	 *            Denumirea centrului de cost nou creat
	 * @param responsabil
	 *            Numele persoanei responsabila pe centru de cost
	 * @param dataStart
	 *            Data start conform fazei de productie
	 * @param dataSfarsit
	 *            Data sfarsit conform fazei de productie
	 * @param sumaCentruCost
	 *            Valoarea costului (din CosturiPrimare)
	 * 
	 * @return instanta Activitate nou creat.
	 * 
	 */
	CentruCost creareCentruCost(String denumireCentruCost,FazaProductie faza, Angajat responsabil,
		 Date dataStart, Date dataSfarsit, Double sumaCentruCost) throws Exception;

	/**
	 * Scop Creeaza activitate si o asociaza centrului de cost.
	 * 
	 * @param centru
	 *            cost Centrul de cost caruia i se va asocia o activitate nou
	 *            creata
	 * @param faza
	 * @param responsabil
	 * @param denumireActivitate
	 * @param dataStart
	 * @param dataSfarsit
	 * @param valoareAprovizionareExterna
	 *            (din LinieCost)
	 * 
	 * @return activitatea nou creata
	 * 
	 */

	Activitate creareActivitate(CentruCost centruCost, FazaProductie faza,
			Angajat responsabil, String denumireCentru, Date dataStart,
			Date dataSfarsit, Double valoareAprovizionareExterna) throws Exception;

	/**
	 * Scop Schimba status centrului de cost in started, schimba status primei
	 * activitati in started.
	 * 
	 * @param centruCost
	 *            Centrul de cost a carui derulare va fi initiata
	 * 
	 * @return
	 * 
	 */

	void startCentruCost(CentruCost centruCost);

	/**
	 * Scop Schimba status centru cost in progress, actualizeaza activitate,
	 * actualizeaza liniie de cost ale centrului de cost
	 * 
	 * @param nume
	 *            denumireActivitate in progres.
	 * 
	 * @return
	 * 
	 */

	void progresActivitate(Activitate activitate, Double procent,
			Double costTotal, Date dataActualizata);

	/**
	 * Scop Calculeaza sold centrului de cost de la inceput pina la data
	 * actualizarii
	 * 
	 * @param centruCost
	 *            CentruCost in progres.
	 * @param centruCost
	 *            Data referinta sold.
	 * 
	 * @return Valoare(suma) reprezentand soldul calculat
	 * 
	 */
	Double getSoldCentruCostInCurs(Integer idCentruCost, Date dataSold);
	CentruCost getCentruCost (Integer idCentruCost);

}

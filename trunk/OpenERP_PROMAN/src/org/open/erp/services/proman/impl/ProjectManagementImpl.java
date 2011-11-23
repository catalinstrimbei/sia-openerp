package org.open.erp.services.proman.impl;

import java.util.Date;

import org.open.erp.services.buget.Buget;
import org.open.erp.services.buget.BugetareSrv;
import org.open.erp.services.buget.LinieBugetara;
import org.open.erp.services.nomgen.Persoana;
import org.open.erp.services.proman.Activitate;
import org.open.erp.services.proman.Proiect;
import org.open.erp.services.proman.ProjectManagementSrv;

/**
 * 
 * @ApplicationServiceImplementation(ServiceAPI)
 * 
 */

public class ProjectManagementImpl implements ProjectManagementSrv{
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProjectManagementImpl.class.getName());
	
	
	// referinte servicii (application service) dependente
	private BugetareSrv bugetareSrv;

	public void setBugetareSrv(BugetareSrv bugetareSrv) {
		this.bugetareSrv = bugetareSrv;
	}
	// alte referinte
	private RegistruProiect registruProiect = new RegistruProiect();
	
	/*
	 * 
	 * @ConstrutorForDummy
	 * 
	 */
	public ProjectManagementImpl() {
	}	
	
	
	// implementare actiuni serviciu ProjectManagementSrv //
	@Override
	public Proiect creareProiect(String nume, Persoana responsabil,
			Date dataStart, Date dataSfarsit, Double valoareBuget) {
		
		logger.debug("Creare proiect");
		
		Proiect proiectNou = new Proiect(1, nume, dataStart, dataSfarsit, valoareBuget, responsabil);
		Buget buget = bugetareSrv.creareBuget(valoareBuget);
		proiectNou.setBuget(buget);
		
		logger.debug("Buget proiect: " + buget.getValoareBuget());
		
		return proiectNou;
	}
	
	@Override
	public Activitate creareActivitate(Proiect proiect, Persoana responsabil,
			String titulatura, Date dataStart, Date dataSfarsit,
			Double valoareBugetata) {
		Activitate activitate = new Activitate(1, titulatura, dataStart, dataSfarsit, valoareBugetata, responsabil);
		LinieBugetara linieBugetara = bugetareSrv.creeareLinieBugetaraInBuget(proiect.getBuget(), activitate.getValoareBugetata());
		proiect.adaugaActivitate(activitate, linieBugetara);
		activitate.setProiect(proiect);
		
		return activitate;
	}

	@Override
	public void startProiect(Proiect proiect) {
		// Schimba status proiect in started, schimba status prima activitate in started
		proiect.setStatus(Proiect.INITIALIZAT);
		Activitate primaActivitate = proiect.getActivitati().iterator().next();
		primaActivitate.setStatus(Activitate.IN_CURS);
		
	}

	@Override
	public void progresActivitate(Activitate activitate, Double procent,
			Double cost, Date dataActualizata) {
		// Schimba status proiect in progress, actualizeaza activitate, actualizeaza linii de bugetare proiect
		if (activitate.getStatus().equals(Activitate.NE_PORNITA))
			activitate.setStatus(activitate.IN_CURS);
		activitate.setDataActualizare(dataActualizata);
		activitate.setProcentRealizare(activitate.getProcentRealizare() + procent);
		// Actualizare buget
		bugetareSrv.actualizareBuget(activitate.getProiect().getLinieBugetara(activitate), cost);
	}

	@Override
	public Double getSoldProiectInCurs(Integer idProiect, Date dataSold) {
		Proiect proiect = registruProiect.getProiect(idProiect); 
		ProcesorProiecte procesorProiecte = new ProcesorProiecte();
		Double buget = procesorProiecte.getBugetProiectInCurs(proiect, dataSold);
		Double cost = procesorProiecte.getCostProiectInCurs(proiect, dataSold);
		
		return buget - cost;
	}	
}

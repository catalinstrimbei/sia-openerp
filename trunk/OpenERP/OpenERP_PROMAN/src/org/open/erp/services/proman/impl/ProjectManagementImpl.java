package org.open.erp.services.proman.impl;

import java.util.Date;
import java.util.List;

import org.open.erp.services.buget.Buget;
import org.open.erp.services.buget.BugetareSrv;
import org.open.erp.services.proman.Activitate;
import org.open.erp.services.proman.ActivitateBugetata;
import org.open.erp.services.proman.Proiect;
import org.open.erp.services.proman.ProjectManagementSrv;
import org.open.erp.services.proman.Responsabil;

/**
 * @ApplicationServiceImplementation
 * 
 */

public class ProjectManagementImpl implements ProjectManagementSrv{
	
	private BugetareSrv bugetareSrv;
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProjectManagementImpl.class.getName());
	
	
	
	public void setBugetareSrv(BugetareSrv bugetareSrv) {
		this.bugetareSrv = bugetareSrv;
	}

	@Override
	public Proiect creareProiect(String nume, Responsabil responsabil,
			Date dataStart, Date dataSfarsit, Double valoareBuget) {
		logger.debug("1.1 Initiere/Creare proiect nou");
		
		Proiect proiectNou = new Proiect(1, nume, dataStart, dataSfarsit, valoareBuget, responsabil);
		Buget buget = bugetareSrv.creareBuget(valoareBuget);
		proiectNou.setBuget(buget);		
		return proiectNou;
	}

	public ProjectManagementImpl() {
	}

	@Override
	public Activitate creareActivitate(Proiect proiect,
			Responsabil responsabil, String titulatura, Date dataStart,
			Date dataSfarsit, Double valoareBugetata) throws Exception {
		logger.debug("1.3 Adaugare activitati in proiect");
		
		ActivitateBugetata activitate = new ActivitateBugetata(titulatura, dataStart, dataSfarsit, valoareBugetata, responsabil);
		proiect.adaugaActivitate(activitate);
		activitate.setProiect(proiect);
		
		return activitate;
	}
	
	@Override
	public void stabilireResponsabilActivitate(Activitate activitate,
			Responsabil responsabil) {
		logger.debug("1.4 Stabilire responsabil activitate");
		activitate.setResponsabil(responsabil);
	}

	@Override
	public void stabilireLinieBugetara(Activitate activitate,
			Double valoareBugetata) {
		logger.debug("1.5 Stabilire linie bugetara");
		((ActivitateBugetata)activitate).setValoareBugetata(valoareBugetata);
		
	}

	/* ------------- */
	@Override
	public Proiect creareProiect(String numeProiect, Date dataStart, Date dataSfarsit, Double valoareBuget) {
		logger.debug("1.1 Initiere/Creare proiect nou");
		Proiect proiectNou = new Proiect(1, numeProiect, dataStart, dataSfarsit, null, null);
		Buget buget = bugetareSrv.creareBuget(valoareBuget);
		proiectNou.setBuget(buget);		
		return proiectNou;
	}

	@Override
	public Activitate creareActivitate(Proiect proiect, String titulatura,
			Date dataStart, Date dataSfarsit) throws Exception {
		logger.debug("1.3 Adaugare activitate in proiect");
		
		ActivitateBugetata activitate = new ActivitateBugetata(titulatura, dataStart, dataSfarsit,
				null, null);
		proiect.adaugaActivitate(activitate);
		activitate.setProiect(proiect);
		
		return activitate;
	}

	//
	@Override
	public Double getSoldProiectInCurs(Integer idProiect, Date dataSold) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proiect getProiect(Integer idProiect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proiect> getProiecte() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void startProiect(Proiect proiect) {
		// Schimba status proiect in started, schimba status prima activitate in started
		
	}

	@Override
	public void progresActivitate(Activitate activitate, Double procent,
			Double cost, Date dataActualizata) {
		// Schimba status proiect in progress, actualizeaza activitate, actualizeaza linii de bugetare proiect
		
	}

	@Override
	public Proiect creareProiect(Proiect proiectNou) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proiect salvareProiect(Proiect proiect) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}

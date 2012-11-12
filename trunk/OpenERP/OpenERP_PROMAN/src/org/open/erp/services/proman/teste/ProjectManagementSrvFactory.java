package org.open.erp.services.proman.teste;

import org.apache.log4j.Logger;
import org.open.erp.services.buget.Buget;
import org.open.erp.services.buget.BugetareSrv;
import org.open.erp.services.nomgen.NomenclatoareGeneraleSrv;
import org.open.erp.services.proman.ProjectManagementSrv;
import org.open.erp.services.proman.impl.ProjectManagementImpl;

public class ProjectManagementSrvFactory {
	private static Logger logger = Logger.getLogger(ProjectManagementSrvFactory.class.getName());
	
	public static ProjectManagementSrv getProjectManagementSrv(){
		ProjectManagementSrv projectSrv = new ProjectManagementImpl();
		BugetareSrv bugetareSrv = ProjectManagementSrvFactory.getProjectBugetareSrv();
		projectSrv.setBugetareSrv(bugetareSrv);
		
		logger.info("Crerare ProjectManagementSrv instance from ProjectManagementSrvFactory!");
		
		return projectSrv;
	}
	
	//
	public static BugetareSrv getProjectBugetareSrv(){
		logger.info("Creare dummy instance of BugetareSrv from BugetareSrvFactory!");
		// Dummmy Implementation of BugetareSrv
		return new BugetareSrv(){
			@Override
			public Buget creareBuget(Double valoareBuget) {
				logger.info("1.2 Stabilire buget proiect");
				return new Buget();
			}
		};
		// ----
	}
	
	//
	public static NomenclatoareGeneraleSrv getNomenclatoareGeneraleSrv(){
		logger.info("Creare dummy instance of NomenclatoareGeneraleSrv from NomenclatoareGeneraleSrvFactory!");
		// Dummmy Implementation of BugetareSrv
		return new NomenclatoareGeneraleSrv(){
			// Null implementation
		};
		// ----
	}	
}

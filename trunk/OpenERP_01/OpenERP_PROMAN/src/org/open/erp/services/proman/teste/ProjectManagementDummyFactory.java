package org.open.erp.services.proman.teste;

import org.open.erp.services.buget.BugetareSrv;
import org.open.erp.services.buget.impl.BugetareDummyImpl;
import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;
import org.open.erp.services.proman.ProjectManagementSrv;
import org.open.erp.services.proman.impl.ProjectManagementImpl;

/*
 * 
 * @Factory(ProjectManagementSrv, BugetareSrv, NomGenSrv) 
 *  
 *  Furnizeaza depedente Dummy pentru serviciul local si cele dependente
 * 
 */

public class ProjectManagementDummyFactory {
	public static ProjectManagementSrv getProjectManagementSrv(){
		ProjectManagementImpl projectSrv = new ProjectManagementImpl();
		projectSrv.setBugetareSrv(getBugetareSrv());
		return projectSrv;
	}
	
	public static BugetareSrv getBugetareSrv(){
		return new BugetareDummyImpl();
	}
	
	public static NomenclatoareSrv getNomenclatoareSrv(){
		return new NomenclatoareDummyImpl();
	}
}

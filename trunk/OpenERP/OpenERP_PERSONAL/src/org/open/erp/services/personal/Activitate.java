package org.open.erp.services.personal;

import java.util.Date;

//import org.open.erp.services.buget.Buget;

/**
 * 
 * @BusinessObject(Entity)
 * 
 */


public class Activitate {
	private String 		idActivitate;
	private Eveniment	eveniment;
	private String 		descriereActivitate;
	private Integer 	numarMinimParticipanti;
	private Double		sumaConsumata;
	private Date		dataStart;
	private Date		dataSfarsit;
	private String 		locatie;
}

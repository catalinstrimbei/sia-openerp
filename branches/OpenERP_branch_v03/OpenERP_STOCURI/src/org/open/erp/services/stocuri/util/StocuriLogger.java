package org.open.erp.services.stocuri.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class StocuriLogger {
	
	private Logger logger;

	public StocuriLogger() {
		super();

	}

	public String getName() {
		return logger.getName();
	}
	

	
	public void loggeazaDEBUG(Object mesaj){
		log(Level.DEBUG, mesaj, null);
	}
	public void loggeazaDEBUG(Object mesaj, Throwable t){
		log(Level.DEBUG, mesaj, t);
	}
	
	public void loggeazaINFO(Object mesaj){
		log(Level.INFO, mesaj, null);
	}
	public void loggeazaINFO(Object mesaj, Throwable t){
		log(Level.INFO, mesaj, t);
	}
	public void loggeazaERROR(Object mesaj){
		log(Level.ERROR, mesaj, null);
	}
	public void loggeazaERROR(Object mesaj, Throwable t){
		log(Level.ERROR, mesaj, t);
	}
	public void loggeazaWARN(Object mesaj){
		log(Level.WARN, mesaj, null);
	}
	public void loggeazaWARN(Object mesaj, Throwable t){
		log(Level.WARN, mesaj, t);
	}
	public void loggeazaFATAL(Object mesaj){
		log(Level.FATAL, mesaj, null);
	}
	public void loggeazaFATAL(Object mesaj, Throwable t){
		log(Level.FATAL, mesaj, t);
	}
	
	 public void log( Level level, Object msg, Throwable t)
	{
		 if(level == null){
			 level = Level.DEBUG;
			 logger= Logger.getLogger(StocuriLogger.class.getName()); 
		 }else if(level.equals(Level.DEBUG)) {
	    	 logger= Logger.getLogger(StocuriLogger.class.getName());
	     }else  if(level.equals(Level.INFO)) {
	    	 logger= Logger.getLogger("com.INFO"); 
	     }else  if(level.equals(Level.ERROR)) {
	    	 logger= Logger.getLogger("com.ERROR");
	     }else  if(level.equals(Level.WARN)) {
	    	 logger= Logger.getLogger("com.WARN");
	     }else  if(level.equals(Level.FATAL)) {
	    	 logger= Logger.getLogger("com.FATAL");
	     }else{
	      logger= Logger.getLogger(StocuriLogger.class.getName());
	     }
		 
	     
	        logger.log(level, msg, t );
	                             
	 }    

}

package org.open.erp.services.personal.logger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class PersonalLogger {
	private Logger logger;

	public PersonalLogger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return logger.getName();
	}	

	
	public void logDEBUG(Object message_){
		log(Level.DEBUG, message_, null);
	}
	public void logDEBUG(Object message_, Throwable t){
		log(Level.DEBUG, message_, t);
	}
	
	public void logINFO(Object message_){
		log(Level.INFO, message_, null);
	}
	public void logINFO(Object message_, Throwable t){
		log(Level.INFO, message_, t);
	}
	public void logERROR(Object message_){
		log(Level.ERROR, message_, null);
	}
	public void logERROR(Object message_, Throwable t){
		log(Level.ERROR, message_, t);
	}
	public void logWARN(Object message_){
		log(Level.WARN, message_, null);
	}
	public void logWARN(Object message_, Throwable t){
		log(Level.WARN, message_, t);
	}
	public void logFATAL(Object message_){
		log(Level.FATAL, message_, null);
	}
	public void logFATAL(Object message_, Throwable t){
		log(Level.FATAL, message_, t);
	}
	
	public void log( Level level, Object message_, Throwable t)
	{
		 if(level == null || level.equals(Level.DEBUG))
		 {
			 level = Level.DEBUG;
			 logger= Logger.getLogger(PersonalLogger.class.getName());  
		 }			 	
		 else if(level.equals(Level.DEBUG)) 
		 {
	    	 logger= Logger.getLogger(PersonalLogger.class.getName());
	     }
		 else  if(level.equals(Level.INFO))
		 {
	    	 logger= Logger.getLogger("com.INFO"); 
	     }
		 else  if(level.equals(Level.ERROR)) 
		 {
	    	 logger= Logger.getLogger("com.ERROR");
	     }
		 else  if(level.equals(Level.WARN))
		 {
	    	 logger= Logger.getLogger("com.WARN");
	     }
		 else  if(level.equals(Level.FATAL))
		 {
	    	 logger= Logger.getLogger("com.FATAL");
	     }
		 else
		 {
	      logger= Logger.getLogger(PersonalLogger.class.getName());
	     }
		 
	     logger.log(level, message_, t );                       
	 }    
	
}

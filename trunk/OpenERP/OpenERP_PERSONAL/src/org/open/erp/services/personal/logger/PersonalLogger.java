package org.open.erp.services.personal.logger;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class PersonalLogger {
	private Logger logger;

	public PersonalLogger() {
		super();
	}
	
	private static void addAppender(Logger logger)
	{
		// TODO Auto-generated constructor stub	
				//Create the RollingFileAppender.
		        PatternLayout layout = new PatternLayout();
		        layout.setConversionPattern("%d %-5p [%c] %m%n");
		        RollingFileAppender myAppender;
				try {
					myAppender = new RollingFileAppender(layout, "T:\\logTest.log");
					myAppender.setAppend(true);
			        myAppender.setMaxFileSize("5MB");
			        myAppender.setMaxBackupIndex(3);
			        myAppender.setName("logTest");

				//Add the appender.
			        logger.addAppender(myAppender);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public static void addCustomAppender(String logId) throws IOException {
        String logName = logId;

	//Make sure the logger has not already been added.
        Logger rootLogger = Logger.getRootLogger();
        if (rootLogger.getAppender(logId) != null)
            return;

	//Get the FILE appender to find the location of our server.log file.
        Appender fileAppender = rootLogger.getAppender("FILE");
        if (fileAppender != null) {
            String logFolder = ((RollingFileAppender)fileAppender).getFile();
            logFolder = logFolder.substring(1, logFolder.lastIndexOf(File.pathSeparator));
            logName = logFolder + File.pathSeparator + logId + ".log";
        }

	//Create the RollingFileAppender.
        PatternLayout layout = new PatternLayout();
	layout.setConversionPattern("%d %-5p [%c] %m%n");
        RollingFileAppender myAppender = new RollingFileAppender(layout, logName);
        myAppender.setAppend(true);
        myAppender.setMaxFileSize("5MB");
        myAppender.setMaxBackupIndex(3);
        myAppender.setName(logId);

	//Add the appender.
        rootLogger.addAppender(myAppender);
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
		 this.addAppender(logger);
	     logger.log(level, message_, t );                       
	 }    
	
}

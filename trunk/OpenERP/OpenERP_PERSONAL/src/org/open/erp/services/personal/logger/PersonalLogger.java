package org.open.erp.services.personal.logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

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
	public static void trace(PersonalLogger logger_, StackTraceElement e[]) 
	{
	   boolean doNext = false;
	   for (StackTraceElement s : e) 
	   {
	       if (doNext)
	       {
	    	   logger_.logERROR("Stack Trace >>> " + s.getMethodName());
	          return;
	       }
	       doNext = s.getMethodName().equals("getStackTrace");
	   }
	}
	private void addAppender(Logger logger)
	{
		// TODO Auto-generated constructor stub	
				//Create the RollingFileAppender.
		        PatternLayout layout = new PatternLayout();
		        layout.setConversionPattern("%d %-5p [%c] %m%n");
		        RollingFileAppender myAppender;
				try {
					
					ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
					URL url = classLoader.getResource("");
					String path = url.getPath().toString();
					if(false || path.length() > 4)
					{
						path = path.substring(1, path.length() - 4);					
						path = path + "Resources/";					
						path = path.replace("/", "\\");
						path = path.replace("%20", " ");
					}
					else
					{
						path = "T:\\";
					}
					path = "T:\\";
					myAppender = new RollingFileAppender(layout, path + "LogFile_OpenERP_PERSONAL.log");
					myAppender.setAppend(true);
			        myAppender.setMaxFileSize("5MB");
			        myAppender.setMaxBackupIndex(3);
			        myAppender.setName("fileAppender");

				//Add the appender.
			        logger.addAppender(myAppender);
					logger.setLevel(Level.ALL);
					logger.info("**************************************************************************************");
					logger.info("LOG begins at " + Calendar.getInstance().getTime().toString());
					logger.info("**************************************************************************************");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		 }
		 logger= Logger.getLogger(PersonalLogger.class.getName());
		 logger.setLevel(Level.ALL);
		 if(logger.getAppender("fileAppender") == null)
		 {
			 this.addAppender(logger);
		 }
	     logger.log(level, message_, t );
	     if(level.equals(Level.ERROR) || level.equals(Level.FATAL)) 
	     {
	    	 
	    	 
	     }
	 }    
	
}

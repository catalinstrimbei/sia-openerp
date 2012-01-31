package org.open.erp.services.vanzari.impl;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

public class VanzariInterceptor {

	private static Logger logger = Logger.getLogger(VanzariInterceptor.class.getName());
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception
	{
		String methodName = ctx.getMethod().getName(); 
		logger.info("*** VanzariInterceptor intercepting method >>" + methodName);
	   try
	   {
	      return ctx.proceed();
	   }
	   finally
	   {
	      logger.info("*** VanzariInterceptor exiting method >>" + methodName);
	   }
	}
}

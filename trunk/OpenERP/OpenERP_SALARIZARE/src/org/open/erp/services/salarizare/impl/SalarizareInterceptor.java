package org.open.erp.services.salarizare.impl;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class SalarizareInterceptor {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SalarizareImpl.class.getName());
	
	@AroundInvoke
	public Object logMessage(InvocationContext ctx) throws Exception{
		// Decodifica informatii privind contextul de invocare
		Class<? extends Object> targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		// Executa logica de interceptare
		logger.info("#### call of: " + targetBeanClass.getName() + "." + invokedMethodName);
		// executa metoda interceptata
		return ctx.proceed();
	}
	@AroundInvoke
	public Object logEJBInjection(InvocationContext ctx) throws Exception{
		// Decodifica informatii privind contextul de invocare
		Class<? extends Object> targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		SalarizareImpl ejbean = (SalarizareImpl) ctx.getTarget();
		
		logger.info("#### call of: " + targetBeanClass.getName() + "." + invokedMethodName);
		// Executa logica de interceptare
		if ("inregistrarePontajLuna".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass)){
			logger.info("#### personalSrv: " + (ejbean.getPersonalSrv()!=null? " is injected, ":" isn't injected, ") 
					);
			//return null;
		}
		// executa metoda interceptata
		return ctx.proceed();
	}
	@AroundInvoke
	public Object logInvocationResult(InvocationContext ctx) throws Exception{
		// Decodifica informatii privind contextul de invocare
		Class targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		SalarizareImpl ejbean = (SalarizareImpl) ctx.getTarget();
		
		logger.info("#### call of: " + targetBeanClass.getName() + "." + invokedMethodName);
		// Executa logica de interceptare
		if ("inregistrarStatSalariiLuna".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass)){
			Object invocationResult = ctx.proceed();
			logger.info("#### invocationResult message: " + invocationResult);
			return invocationResult;
		}
		// executa metoda interceptata
		return ctx.proceed();
	}
}

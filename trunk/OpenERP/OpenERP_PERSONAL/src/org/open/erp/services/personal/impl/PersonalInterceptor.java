package org.open.erp.services.personal.impl;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.open.erp.services.personal.logger.PersonalLogger;

public class PersonalInterceptor {
	PersonalLogger logger = new PersonalLogger();

	//validare parametri metode
		@AroundInvoke
		public Object logValidationResult(InvocationContext ctx) throws Exception{
			// Decodifica informatii privind contextul de invocare
			Class targetBeanClass = ctx.getTarget().getClass();
			String invokedMethodName = ctx.getMethod().getName();
			PersonalImpl ejbean = (PersonalImpl) ctx.getTarget();
			
			logger.logINFO("#### call of: " + targetBeanClass.getName() + "." + invokedMethodName);
			// Executa logica de interceptare
			if (
					("salveazaFunctie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
					("salveazaAngajat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))					
				)
			{
				//verifica ca obiectele trimise spre salvare in BD sa nu fie null
				if(ctx.getParameters()[1] == null)
				{
					logger.logINFO("Metoda "+ invokedMethodName + " a fost apelata cu parametrul null");
				}				
			}
			// executa metoda interceptata
			return ctx.proceed();
		}
		
	//logare clasa/metoda apelate
	@AroundInvoke
	public Object logMessage(InvocationContext ctx) throws Exception{
		// Decodifica informatii privind contextul de invocare
		Class<? extends Object> targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		
		// Executa logica de interceptare
		logger.logINFO("#### call of: " + targetBeanClass.getName() + "." + invokedMethodName);
		// executa metoda interceptata
		return ctx.proceed();
	}
	
	//logare rezultat apel metoda EJB
	@AroundInvoke
	public Object logInvocationResult(InvocationContext ctx) throws Exception{
		// Decodifica informatii privind contextul de invocare
		Class targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		PersonalImpl ejbean = (PersonalImpl) ctx.getTarget();
		
		logger.logINFO("#### call of: " + targetBeanClass.getName() + "." + invokedMethodName);
		// Executa logica de interceptare
		if 
		(
				("salveazaFunctie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaAngajat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))					
		)
		{
			Object invocationResult = ctx.proceed();
			logger.logINFO("#### invocationResult message: " + invocationResult);
			return invocationResult;
		}
		// executa metoda interceptata
		return ctx.proceed();
	}
	
	}

package org.open.erp.services.salarizare.impl;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class SalarizareInterceptor {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SalarizareImpl.class.getName());
	
	//logare clasa/metoda apelate
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
	//verificare dependency injection
	@AroundInvoke
	public Object logEJBInjection(InvocationContext ctx) throws Exception{
		// Decodifica informatii privind contextul de invocare
		Class<? extends Object> targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		SalarizareImpl ejbean = (SalarizareImpl) ctx.getTarget();
		
		logger.info("#### call of: " + targetBeanClass.getName() + "." + invokedMethodName);
		// Executa logica de interceptare pt fiecare metoda care foloseste personalSrv
		if (
				("inregistrarePontajLuna".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass)) ||
				("calculSporuriAngajat".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))   ||
				("calculVenitBrut".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))   ||
				("calculRetineriAngajat".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))   ||
				("inregistrarStatSalariiLuna".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))   
				)
		{
			logger.info("#### personalSrv: " + (ejbean.getPersonalSrv()!=null? " is injected, ":" isn't injected, ") 
					);
			//return null;
		}
		// executa metoda interceptata
		return ctx.proceed();
	}
	
	//logare rezultat apel metoda EJB
	@AroundInvoke
	public Object logInvocationResult(InvocationContext ctx) throws Exception{
		// Decodifica informatii privind contextul de invocare
		Class targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		SalarizareImpl ejbean = (SalarizareImpl) ctx.getTarget();
		
		logger.info("#### call of: " + targetBeanClass.getName() + "." + invokedMethodName);
		// Executa logica de interceptare
		if (
				("inregistrarStatSalariiLuna".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))||
				("calculSporuriAngajat".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))   ||
				("calculVenitBrut".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))   ||
				("calculRetineriAngajat".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))   ||
				("inregistrarStatSalariiLuna".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))
				)
		{
			Object invocationResult = ctx.proceed();
			logger.info("#### invocationResult message: " + invocationResult);
			return invocationResult;
		}
		// executa metoda interceptata
		return ctx.proceed();
	}
	
	//validare parametri metode
	@AroundInvoke
	public Object logValidationResult(InvocationContext ctx) throws Exception{
		// Decodifica informatii privind contextul de invocare
		Class targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		SalarizareImpl ejbean = (SalarizareImpl) ctx.getTarget();
		
		logger.info("#### call of: " + targetBeanClass.getName() + "." + invokedMethodName);
		// Executa logica de interceptare
		if (
				("inregistrarStatSalariiLuna".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))||
				("calculSporuriAngajat".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))   ||
				("calculVenitBrut".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))   ||
				("calculRetineriAngajat".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))   ||
				("inregistrarStatSalariiLuna".equals(invokedMethodName) && SalarizareImpl.class.equals(targetBeanClass))
				)
		{
			//verifica parametri An/Luna sa aiba valori intre 2000 si 2050, respectiv 1 si 12
			Integer an = (Integer)ctx.getParameters()[1];
			Integer luna = (Integer)ctx.getParameters()[2];
			if(an>2050||an<2000){
				logger.info("Metoda "+ invokedMethodName + " a fost apelata cu parametrul an cu valoarea"+an);
			}
			if(luna>12||an<1){
				logger.info("Metoda "+ invokedMethodName + " a fost apelata cu parametrul luna cu valoarea"+luna);
			}
		}
		// executa metoda interceptata
		return ctx.proceed();
	}
}

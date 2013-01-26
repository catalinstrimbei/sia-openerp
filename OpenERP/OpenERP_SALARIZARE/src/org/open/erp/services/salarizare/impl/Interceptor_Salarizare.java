package org.open.erp.services.salarizare.impl;


import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Interceptor_Salarizare {
	
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Implement_Salarizare.class.getName());

	//validare parametri metode
		@AroundInvoke
		public Object logValidationResult(InvocationContext ctx) throws Exception{
			// Decodifica informatii privind contextul de invocare
			Class targetBeanClass = ctx.getTarget().getClass();
			String invokedMethodName = ctx.getMethod().getName();
			Implement_Salarizare ejbean = (Implement_Salarizare) ctx.getTarget();
			
			logger.info("#### call of logValidationResult: " + targetBeanClass.getName() + "." + invokedMethodName);
			// Executa logica de interceptare
			if (
					("inregistrarePontajLuna".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))||
					("calculSporuriAngajat".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))   ||
					("calculVenitBrut".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))   ||
					("calculRetineriAngajat".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))   ||
					("inregistrarStatSalariiLuna".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))
					)
			{
				//verifica parametri An/Luna sa aiba valori intre 2000 si 2050, respectiv 1 si 12
				Integer an = (Integer)ctx.getParameters()[0];
				Integer luna = (Integer)ctx.getParameters()[1];
				if(an>2050||an<2000){
					logger.info("#### Metoda "+ invokedMethodName + " a fost apelata cu parametrul an cu valoarea "+an);
				}
				else{
					logger.info("#### Metoda "+ invokedMethodName + " a fost apelata CORECT cu parametrul an cu valoarea "+an);	
					}
				
				if(luna>12||an<1){
					logger.info("##### Metoda "+ invokedMethodName + " a fost apelata cu parametrul luna cu valoarea "+luna);
				}
			}
			// executa metoda interceptata
			return ctx.proceed();
		}

		//validare salar calculat
		@AroundInvoke
		public Object logValidationSalar(InvocationContext ctx) throws Exception{
			// Decodifica informatii privind contextul de invocare
			Class targetBeanClass = ctx.getTarget().getClass();
			String invokedMethodName = ctx.getMethod().getName();
			Implement_Salarizare ejbean = (Implement_Salarizare) ctx.getTarget();
			
			logger.info("#### call of logValidationSalar: " + targetBeanClass.getName() + "." + invokedMethodName);
			// Executa logica de interceptare
			if (
					("calculSalarNet".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))
					)
			{
				//verifica salarul calculat sa nu fie ngativ
				Double salar = (Double)ctx.proceed();
				
				if(salar<0){
					logger.info("Metoda "+ invokedMethodName + " a returnat un salar negativ: "+salar);
				}
				else{
					logger.info("Metoda "+ invokedMethodName + " a returnat CORECT un salar pozitiv: "+salar);
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
		Implement_Salarizare ejbean = (Implement_Salarizare) ctx.getTarget();
		
		logger.info("#### call of logEJBInjection: " + targetBeanClass.getName() + "." + invokedMethodName);
		// Executa logica de interceptare pt fiecare metoda care foloseste personalSrv
		if (
				("inregistrarePontajLuna".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass)) ||
				("calculSporuriAngajat".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))   ||
				("calculVenitBrut".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))   ||
				("calculRetineriAngajat".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))   ||
				("inregistrarStatSalariiLuna".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))   
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
		Implement_Salarizare ejbean = (Implement_Salarizare) ctx.getTarget();
		
		logger.info("#### call of logInvocationResult: " + targetBeanClass.getName() + "." + invokedMethodName);
		// Executa logica de interceptare
		if (
				("inregistrarePontajLuna".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))||
				("calculSporuriAngajat".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))   ||
				("calculVenitBrut".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))   ||
				("calculRetineriAngajat".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))   ||
				("inregistrarStatSalariiLuna".equals(invokedMethodName) && Implement_Salarizare.class.equals(targetBeanClass))
				)
		{
			Object invocationResult = ctx.proceed();
			logger.info("#### invocationResult message: " + invocationResult);
			return invocationResult;
		}
		// executa metoda interceptata
		return ctx.proceed();
	}

}

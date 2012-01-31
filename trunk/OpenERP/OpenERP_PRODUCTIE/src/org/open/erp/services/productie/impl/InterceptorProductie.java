package org.open.erp.services.productie.impl;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptorProductie {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ProductieImpl.class.getName());

	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception
	{
		String methodName = ctx.getMethod().getName(); 
		logger.info("*** InterceptorProductie intercepting method >>" + methodName);
	   try
	   {
	      return ctx.proceed();
	   }
	   finally
	   {
	      logger.info("*** InterceptorProductie exiting method >>" + methodName);
	   }
	}
	
	@AroundInvoke
	public Object logValidationResult(InvocationContext ctx) throws Exception
	{		
		@SuppressWarnings("rawtypes")
		Class targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		if(ctx.getParameters().length <= 1)
			return ctx.proceed();
		logger.info("*** InterceptorProductie(logValidationResult) : call method >>" + targetBeanClass.getName() + "." + invokedMethodName);		
		if (		
				("definireFluxProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("definireFazaProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("lansareComandaProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("consumResursa".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("controlCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||					
				("livrareProdus".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("inregistrareGestiuneConsum".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("inregistrareGestiuneProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getFlux".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("fabricare".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("getFazaFlux".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("comandaMateriale".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getListaFluxuri".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("stergeFlux".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getListaSemifabricate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("stergeSemifabricat".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("salveazaSemifabricat".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getCriteriiCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("stergeCriteriuCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||					
				
				("salveazaCriteriuCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getFazaProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getListaFaze".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("stergeFaza".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getUtilaje".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("stergeUtilaj".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))			
			)
		{			
			if(ctx.getParameters()[1] == null)
			{
				logger.info("*** Metoda >>"+ invokedMethodName + " a fost apelata cu parametrul null");
			}				
		}		
		return ctx.proceed();
	}
			
	@AroundInvoke
	public Object logMessage(InvocationContext ctx) throws Exception{		
		Class<? extends Object> targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
				
		logger.info("*** InterceptorProductie(logMessage) : call method >>: " + targetBeanClass.getName() + "." + invokedMethodName);		
		return ctx.proceed();
	}
	
	@AroundInvoke
	public Object logInvocationResult(InvocationContext ctx) throws Exception{
		@SuppressWarnings("rawtypes")
		Class targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		ProductieImpl ejbean = (ProductieImpl) ctx.getTarget();
		
		logger.info("*** InterceptorProductie(logInvocationResult) : call method >>: " + targetBeanClass.getName() + "." + invokedMethodName);
		
		if (		
				("definireFluxProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("definireFazaProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("lansareComandaProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("consumResursa".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("controlCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||					
				("livrareProdus".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("inregistrareGestiuneConsum".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("inregistrareGestiuneProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getFlux".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("fabricare".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("getFazaFlux".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("comandaMateriale".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getListaFluxuri".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("stergeFlux".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getListaSemifabricate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("stergeSemifabricat".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("salveazaSemifabricat".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getCriteriiCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("stergeCriteriuCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||					
				
				("salveazaCriteriuCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getFazaProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getListaFaze".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("stergeFaza".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getUtilaje".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("stergeUtilaj".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))			
			){
		
		Object invocationResult = ctx.proceed();
		logger.info("*** InterceptorProductie(logInvocationResult) : result >>: " + invocationResult);
		return invocationResult;
		}
		return ctx.proceed();
	}
	
	
	@AroundInvoke
	public Object logEJBInjection(InvocationContext ctx) throws Exception{
		// Decodifica informatii privind contextul de invocare
		Class<? extends Object> targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		ProductieImpl ejbean = (ProductieImpl) ctx.getTarget();
		
		logger.info("#### call of logEJBInjection: " + targetBeanClass.getName() + "." + invokedMethodName);
		// Executa logica de interceptare pt fiecare metoda care foloseste personalSrv
		if (		
				("definireFluxProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("definireFazaProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("lansareComandaProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("consumResursa".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("controlCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||					
				("livrareProdus".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("inregistrareGestiuneConsum".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("inregistrareGestiuneProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getFlux".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("fabricare".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("getFazaFlux".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("comandaMateriale".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getListaFluxuri".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("stergeFlux".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getListaSemifabricate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("stergeSemifabricat".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("salveazaSemifabricat".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getCriteriiCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("stergeCriteriuCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||					
				
				("salveazaCriteriuCalitate".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getFazaProductie".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getListaFaze".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				
				("stergeFaza".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("getUtilaje".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))||
				("stergeUtilaj".equals(invokedMethodName) && ProductieImpl.class.equals(targetBeanClass))			
			)
		{
			logger.info("#### personalSrv: " + (ejbean.getPersonalSrv()!=null? " is injected, ":" isn't injected, ")
					);
			logger.info("#### nomgenSrv: " + (ejbean.getNomenclatoareSrv()!=null? " is injected, ":" isn't injected, ")
					);
			//return null;
		}
		// executa metoda interceptata
		return ctx.proceed();
	}
	
	
}

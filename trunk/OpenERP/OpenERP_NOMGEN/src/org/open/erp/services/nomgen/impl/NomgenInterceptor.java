package org.open.erp.services.nomgen.impl;


import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.open.erp.services.nomgen.logger.NomgenLogger;
import org.open.erp.services.nomgen.impl.NomenclatoareDummyImpl;


public class NomgenInterceptor {

	NomgenLogger logger = new NomgenLogger();
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception
	{
		String methodName = ctx.getMethod().getName(); 
		logger.logINFO("*** NomgenInterceptor intercepting method >>" + methodName);
	   try
	   {
	      return ctx.proceed();
	   }
	   finally
	   {
	      logger.logINFO("*** NomgenInterceptor exiting method >>" + methodName);
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
		logger.logINFO("*** NomgenInterceptor(logValidationResult) : call method >>" + targetBeanClass.getName() + "." + invokedMethodName);		
		if (
	        
			("getPF".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getPartener".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getPartenerDupaCodPersoana".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getPJ".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("addPersoana".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("removePersoana".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("refreshPersoana".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("addPartener".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("removePartener".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("refreshPartener".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("addPersoanaFizica".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("removePersoanaFizica".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("refreshPersoanaFizica".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("addPersoanaJuridica".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("removePersoanaJuridica".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("refreshPersoanaJuridica".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getPersoanaDupaAdresa".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getCountPersoane".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getDocumente".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getDocumentDupaCod".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getLinieDocument".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getLinieDocumentDupaCodDoc".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getLinieDocumentDupaMaterial".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("addDocument".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("addLinieDocument".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("removeDocument".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("removeLinieDocument".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("refreshDocument".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("refreshLinieDocument".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getDocumentDupaNrDocument".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getCountDocumente".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getProduse".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("generateRandomProduse".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getProduseOrdonateDupaId".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getProdusDupaCod".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getMFOrdonatbyId".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getMFDupaCod".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getMaterialOrdonatbyId".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getMaterialDupaCod".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getMPOrdonatbyId".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getMPDupaCod".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("addProdus".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("removeProdus".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("refreshProdus".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("addMF".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("removeMijlocFix".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("refreshMF".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("addMP".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("removeMP".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("refreshMP".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||	
			("addMaterial".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||	
			("removeMaterial".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||	
			("refreshMaterial".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getProdus".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("cautarePersoanaFizicaDupaPrenume".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("cautarePersoanaJuridicaDupaDenumire".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("CautareProdusDupaDenumire".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getDepartament".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getDepDupaCod".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("addDepartament".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("removeDepartament".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getDepartamentDupaDenumire".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			("getCountDepartament".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			(" ".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))||
			(" ".equals(invokedMethodName) && NomenclatoareDummyImpl.class.equals(targetBeanClass))
				)
		{			
			if(ctx.getParameters()[1] == null)
			{
				logger.logINFO("*** Metoda >>"+ invokedMethodName + " a fost apelata cu parametrul null");
			}				
		}		
		return ctx.proceed();
	}
	
	@AroundInvoke
	public Object logMessage(InvocationContext ctx) throws Exception{		
		Class<? extends Object> targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
				
		logger.logINFO("*** NomgenInterceptor(logMessage) : call method >>: " + targetBeanClass.getName() + "." + invokedMethodName);		
		return ctx.proceed();
	}
				
	@AroundInvoke
	public Object logInvocationResult(InvocationContext ctx) throws Exception{
		@SuppressWarnings("rawtypes")
		Class targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		
		logger.logINFO("*** NomgenInterceptor(logInvocationResult) : call method >>: " + targetBeanClass.getName() + "." + invokedMethodName);		
				
		Object invocationResult = ctx.proceed();
		logger.logINFO("*** NomgenInterceptor(logInvocationResult) : result >>: " + invocationResult);
		return invocationResult;					
	  }
	
	
	
}

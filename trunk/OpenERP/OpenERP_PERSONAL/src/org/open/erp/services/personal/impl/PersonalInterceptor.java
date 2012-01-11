package org.open.erp.services.personal.impl;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.open.erp.services.personal.logger.PersonalLogger;

public class PersonalInterceptor {
	PersonalLogger logger = new PersonalLogger();

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception
	{
		String methodName = ctx.getMethod().getName(); 
		logger.logINFO("*** PersonalInterceptor intercepting method >>" + methodName);
	   try
	   {
	      return ctx.proceed();
	   }
	   finally
	   {
	      logger.logINFO("*** PersonalInterceptor exiting method >>" + methodName);
	   }
	}
	
	
	@AroundInvoke
	public Object logValidationResult(InvocationContext ctx) throws Exception
	{		
		Class targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		PersonalImpl ejbean = (PersonalImpl) ctx.getTarget();
		if(ctx.getParameters().length <= 1)
			return ctx.proceed();
		logger.logINFO("PersonalInterceptor(logValidationResult) : call method >>" + targetBeanClass.getName() + "." + invokedMethodName);		
		if (		
				("getActivitateTeamBuildingById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaActivitateTeamBuilding".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeActivitateTeamBuilding".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getActivitateTrainingById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaActivitateTraining".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||					
				("stergeActivitateTraining".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getAngajatById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("getAngajatByMarca".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaAngajat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeAngajat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getAnuntLocMuncaById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaAnuntLocMunca".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeAnuntLocMunca".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getCandidatById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("getCandidatByIdCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("getCandidatiPeFunctie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("refreshCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||					
				
				("getEvenimentById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaEveniment".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeEveniment".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getFunctieById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaFunctie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeFunctie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getInstructorById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaInstructor".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeInstructor".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getInterviuById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaInterviu".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeInterviu".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||

				("getInterviuCandidatById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaInterviuCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeInterviuCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getProbaEvaluareById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaProbaEvaluare".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeProbaEvaluare".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getRezultatProbaEvaluareById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaRezultatProbaEvaluare".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeRezultatProbaEvaluare".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||

				("getCerereDemisieById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaCerereDemisie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeCerereDemisie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getContractMuncaById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaContractMunca".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeContractMunca".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getCVById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaCV".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeCV".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getDosarAngajatById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaDosarAngajat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeDosarAngajat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))				
			)
		{			
			if(ctx.getParameters()[1] == null)
			{
				logger.logINFO("Metoda >>"+ invokedMethodName + " a fost apelata cu parametrul null");
			}				
		}		
		return ctx.proceed();
	}
			
	@AroundInvoke
	public Object logMessage(InvocationContext ctx) throws Exception{		
		Class<? extends Object> targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
				
		logger.logINFO("PersonalInterceptor(logMessage) : call method >>: " + targetBeanClass.getName() + "." + invokedMethodName);		
		return ctx.proceed();
	}
	
	@AroundInvoke
	public Object logInvocationResult(InvocationContext ctx) throws Exception{
		Class targetBeanClass = ctx.getTarget().getClass();
		String invokedMethodName = ctx.getMethod().getName();
		PersonalImpl ejbean = (PersonalImpl) ctx.getTarget();
		
		logger.logINFO("PersonalInterceptor(logInvocationResult) : call method >>: " + targetBeanClass.getName() + "." + invokedMethodName);
		/*
		if 
		(
				("getActivitateTeamBuildingById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaActivitateTeamBuilding".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeActivitateTeamBuilding".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getActivitateTrainingById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaActivitateTraining".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||					
				("stergeActivitateTraining".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getAngajatById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("getAngajatByMarca".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaAngajat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeAngajat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getAnuntLocMuncaById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaAnuntLocMunca".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeAnuntLocMunca".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getCandidatById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("getCandidatByIdCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("getCandidatiPeFunctie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("refreshCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||					
				
				("getEvenimentById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaEveniment".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeEveniment".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getFunctieById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaFunctie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeFunctie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getInstructorById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaInstructor".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeInstructor".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getInterviuById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaInterviu".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeInterviu".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||

				("getInterviuCandidatById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaInterviuCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeInterviuCandidat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getProbaEvaluareById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaProbaEvaluare".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeProbaEvaluare".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getRezultatProbaEvaluareById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaRezultatProbaEvaluare".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeRezultatProbaEvaluare".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||

				("getCerereDemisieById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaCerereDemisie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeCerereDemisie".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getContractMuncaById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaContractMunca".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeContractMunca".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getCVById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaCV".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeCV".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				
				("getDosarAngajatById".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("salveazaDosarAngajat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))||
				("stergeDosarAngajat".equals(invokedMethodName) && PersonalImpl.class.equals(targetBeanClass))					
		)
		{
		*/
			Object invocationResult = ctx.proceed();
			logger.logINFO("PersonalInterceptor(logInvocationResult) : result >>: " + invocationResult);
			return invocationResult;
		//}		
		//return ctx.proceed();
	}
	
	}

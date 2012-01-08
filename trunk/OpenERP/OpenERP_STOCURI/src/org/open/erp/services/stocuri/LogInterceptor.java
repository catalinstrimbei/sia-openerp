package org.open.erp.services.stocuri;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.open.erp.services.stocuri.util.StocuriLogger;

public class LogInterceptor {
	StocuriLogger logger = new StocuriLogger();

	@AroundInvoke
	public Object logeazaApelMetoda(InvocationContext ctx) throws Exception {
		System.out.println("Metoda: " + ctx.getMethod() + " este invocata");
		return ctx.proceed();
	}
}

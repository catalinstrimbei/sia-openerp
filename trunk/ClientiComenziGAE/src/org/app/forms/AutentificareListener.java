package org.app.forms;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AutentificareListener implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent evt) {
		System.out.println("LISTENER AUTENTIFICARE");
		
		FacesContext facesContext = evt.getFacesContext();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		
		// Fara FormAutentificare si FormUtilizatori
		HttpServletRequest appRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		String appURL = appRequest.getRequestURI();
		System.out.println("appURL = " + appURL);
		if (appURL.contains("FormAutentificare.xhtml") 
				|| appURL.contains("FormUtilizatori.xhtml")
				|| appURL.contains(".jpg")){
			System.out.println("Load resource ... ");
			return;
		}
		
		// Procedura autentificare
		FormAutentificare credentials = (FormAutentificare) session.getAttribute("formAutentificare");
		if (credentials == null){
			System.out.println("Create credentials ...");
			credentials = new FormAutentificare();
			session.setAttribute("formAutentificare", credentials);
		}
		if (credentials.getUtilizator() == null || credentials.getUtilizator().getParola() == null){
			System.out.println("Check credentials: " + credentials.getUtilizator());
			System.out.println("Redirectare autentificare " +
					facesContext.getApplication().getNavigationHandler()
					);
			//facesContext.getApplication().getNavigationHandler()
			//	.handleNavigation(facesContext, null, "/FormAutentificare.xhtml");
			try {
				facesContext.getExternalContext().redirect("/faces/FormAutentificare.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			System.out.println("User autentificat: " + credentials.getUtilizator().getNumeUtilizator());
		}
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}
	

}

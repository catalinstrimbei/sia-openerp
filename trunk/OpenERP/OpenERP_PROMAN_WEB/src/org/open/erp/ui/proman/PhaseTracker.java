package org.open.erp.ui.proman;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import org.apache.log4j.Logger;

public class PhaseTracker implements
	javax.faces.event.PhaseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Resurse test*/
	private static Logger logger = Logger.getLogger(PhaseTracker.class.getPackage().getName());
	
	public void afterPhase(PhaseEvent event) {
		System.out.println("AFTER - "+ event.getPhaseId());
	}
	public void beforePhase(PhaseEvent event) {
		System.out.println("BEFORE - "+ event.getPhaseId());
		
		if (PhaseId.RENDER_RESPONSE.equals(event.getPhaseId())){
			/*
			 * FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("bean");
			 * FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(context, "#{bean}", CountryBean.class);
			 */
			FormProiecte formProiecte = (FormProiecte)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("formProiecte");
			if (formProiecte != null)
				System.out.println("RENDER_RESPONSE proiect.nume: " + formProiecte.getProiect().getNume());
		}
	}
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}